#encoding:utf-8

# File: Damage.rb
# Author: Juan Manuel Rodríguez Gómez

require_relative 'WeaponType'
require_relative 'Weapon'
require_relative 'DamageToUI'

module Deepspace
    
    # Brief: Representa el daño producido a una estación espacial por una nave 
    #        enemiga cuando se pierde un combate. Cada instancia indicará la 
    #        pérdida de una cantidad de potenciadores de escudo y por otro lado, 
    #        o bien una cantidad de tipos indeterminados de armas o un conjunto 
    #        de tipos de armas concretas que se deben eliminar
    class Damage
        
        # Constructor con parámetros
        def initialize(nS, nW, w)
            @nShields = nS
            @nWeapons = nW
            @weapons = w
        end
        
        # Constructor para utilizar un número de armas de tipo indeterminado en la construcción del objeto
        def self.newNumericWeapons(w, s)
            return Damage.new(s, w, nil)
        end
        
        # Constructor para utilizar una lista de tipos de armas en la construcción del objeto
        def self.newSpecificWeapons(wList, s)
            return Damage.new(s, -1, wList)
        end
        
        # Brief: Constructor de copia
        # Param: d: Otra instancia de la clase Damage
        def self.newCopy(d)
            if d.weapons == nil
                newNumericWeapons(d.nWeapons, d.nShields) 
            else
                newSpecificWeapons(d.weapons, d.nShields)
            end
        end
        
        # Brief: Construye una nueva instancia DamageToUI a partir de la propia 
        #        instancia que recibe el mensaje y lo devuelve.
        #        Estos objetos constituyen una capa que permite conectar el 
        #        modelo con la interfaz de usuario (Damage) manteniendo 
        #        cierto nivel de aislamiento entre ambos niveles
        # Return: Instancia de la clase DamageToUI
        def getUIversion
            return DamageToUI.new(self)
        end

        private

        # Brief: Devuelve el índice de la posición de la primera arma de la 
        #        colección de armas (primer parámetro) cuyo tipo coincida con el 
        #        tipo indicado por el segundo parámetro. Devuelve -1 si no hay 
        #        ninguna arma en la colección del tipo indicado por el segundo 
        #        parámetro
        # Param w: Colección de armas disponibles
        # Param t: Tipo de arma a buscar
        # Return: Índice de la posición de la primera arma de la colección de 
        #         armas cuyo tipo coincida con el tipo indicado por el segundo
        #         parámetro, o -1 si no se ha encontrado ninguna arma en la
        #         colección del tipo indicado por el segundo parámetro
        def arrayContainsType(w, t)

            i = 0
        
            w.each { |weapon|
                if weapon.type == t
                    return i
                else
                    i += 1
                end
            }
        
            return -1
        end
        
        public
        
        # Brief: Devuelve una versión ajustada del objeto a las colecciones de 
        #        armas y potenciadores de escudos suministradas como parámetro.
        #        Partiendo del daño representado por el objeto que recibe este 
        #        mensaje, se devuelve una copia del mismo pero reducida si es 
        #        necesario para que no implique perder armas o potenciadores de 
        #        escudos que no están en las colecciones de los parámetros
        # Param w: Colección de armas disponibles
        # Param s: Colección de potenciadores de escudo disponibles
        # Return: Damage ajustado
        def adjust(w, s)

            # Mínimo entre el número de potenciadores de escudo disponibles y el 
            # número de potenciadores de escudo a eliminar
            minNShields = [@nShields, s.length].min

            # Mínimo entre el número de armas disponibles y el número de armas
            # a eliminar
            minNWeapons = [@nWeapons, w.length].min
        
            # Ajuste de la colección de armas concretas a eliminar
            if(@weapons != nil && !@weapons.empty?)
                typesCopy = [] 
                weaponsCopy = []

                # Copia del conjunto de armas concretas a eliminar
                @weapons.each{ |weaponType|
                    typesCopy.push(weaponType)
                }

                # Copia del conjunto de armas disponibles
                w.each { |weapon|
                    weaponsCopy.push(weapon)
                }

                adjustTypes = Array.new

                # Recorremos la copia de todo el conjunto de armas concretas a eliminar
                @weapons.each { |weaponType|

                    # Comprobamos si el tipo de arma concreta a eliminar está
                    # en weaponsCopy, es decir, en la copia del conjunto de 
                    # armas disponibles
                    index = arrayContainsType(weaponsCopy, weaponType)
                
                    # En el caso de que el tipo de arma concreta a eliminar está
                    # en weaponsCopy, se elimina de weaponsCopy y se añade
                    # a adjustTypes
                    if index != -1
                        weaponsCopy.delete_at(index)
                        adjustTypes.push(weaponType)
                    end
                    
                    typesCopy.delete(weaponType)
                }
                
                # Devolvemos el Damage ajustado con el número de 
                # potenciadores de escudo y la colección de armas concretas
                # a eliminar
                return Damage.newSpecificWeapons(adjustTypes,minNShields)
            end
            
            # En el caso de que no se haya especificado ninguna colección de
            # armas concretas a eliminar, devolvemos el Damage ajustado con
            # el número de potenciadores de escudo y el número de armas
            # a eliminar
            return Damage.newNumericWeapons(minNWeapons,minNShields)
        end
        
        # Brief: Si la instancia dispone de una lista de tipos concretos de armas, 
        #        intenta eliminar el tipo del arma pasada como parámetro de esa 
        #        lista. En otro caso, simplemente decrementa en una unidad el 
        #        contador de armas que deben ser eliminadas. Ese contador no puede
        #        ser inferior a cero en ningún caso
        # Param w: Arma cuyo tipo se va a eliminar de la lista de tipos concretos
        #          de armas disponibles, siempre que sea posible
        def discardWeapon(w)
            if(@weapons == nil && @nWeapons > 0)
                @nWeapons -= 1	
            else
                index = @weapons.index(w.type)
                if index != nil
                    @weapons.delete_at(index)
                end
            end
        end
        
        # Brief: Decrementa en una unidad el número de potenciadores de escudo que 
        #        deben ser eliminados. Ese contador no puede ser inferior a cero 
        #        en ningún caso
        def discardShieldBooster
            if @nShields > 0
                @nShields -= 1;
            end
        end
        
        # Brief: Devuelve True si el daño representado no tiene ningún efecto.
        #        Esto quiere decir que no implica la pérdida de ningún tipo de 
        #        accesorio (armas o potenciadores de escudo)
        # Return: True si el daño representado no tiene ningún efecto y 
        #         False en otro caso
        def hasNoEffect
            if @weapons == nil
                return @nShields == 0 && @nWeapons == 0
            end
        
            return @nShields == 0 && @weapons.empty?
        end
        
        # Brief: Consultor del número de potenciadores de escudo a eliminar
        # Return: nShields
        def nShields
            @nShields
        end
        
        # Brief: Consultor del número de armas a eliminar
        # Return: nWeapons
        def nWeapons
            @nWeapons
        end
        
        # Brief: Consultor de la colección de armas concretas a eliminar
        # Return: ArrayList weapons
        def weapons
        @weapons
        end
    
        public

        # Brief: Función para representar una instancia de la clase Damage
        #        en un string
        # Return: String que representa una instancia de la clase Damage
        def to_s
            
            s_nShields = "- Numero de potenciadores de escudo a eliminar: #{@nShields}\n"
            s_nWeapons = "- Numero de armas a eliminar: #{@nWeapons}\n"

            s_weapons = "- Coleccion de armas a eliminar: Ninguna \n"
            if weapons != nil
                s_weapons = "- Coleccion de armas a eliminar: ["

                for i in (0..@weapons.length-2) do
                    w = @weapons[i]
                    s_weapons += w.to_s
                    s_weapons += ","
                end

                w = @weapons[@weapons.length-1]
                s_weapons += w.to_s
                s_weapons += "] \n"
            end

            return s_nShields + s_nWeapons + s_weapons
        end
    end # Class
end # Module