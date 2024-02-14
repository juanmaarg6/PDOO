#encoding:utf-8

# File: Hangar.rb
# Author: Juan Manuel Rodríguez Gómez

require_relative 'Weapon'
require_relative 'WeaponType'
require_relative 'ShieldBooster'
require_relative 'HangarToUI'

module Deepspace

    # Brief: Representa al Hangar donde se alojará la nave
    class Hangar
        
        # Brief: Constructor con un parámetro
        # Param capacity: Capacidad del hangar
        def initialize(capacity)
            @maxElements = capacity
            @shieldBoosters = Array.new
            @weapons = Array.new
        end
        
        # Brief: Constructor de copia
        # Param h: Otra instancia de la clase Hangar
        def self.newCopy(h)
            hangarCopy = new(h.maxElements)
        
            h.shieldBoosters.each { |sB|
                hangarCopy.addShieldBooster(sB)
            }
        
            h.weapons.each { |w|
                hangarCopy.addWeapon(w)
            }
        
            return hangarCopy
        end
        
        public
        
        # Brief: Construye una nueva instancia HangarToUI a partir de la propia 
        #        instancia que recibe el mensaje y lo devuelve.
        #        Estos objetos constituyen una capa que permite conectar el 
        #        modelo con la interfaz de usuario (Hangar) manteniendo 
        #        cierto nivel de aislamiento entre ambos niveles
        # Return: Instancia de la clase HangarToUI
        def getUIversion
            return HangarToUI.new(self)
        end
    
        private
        
        # Brief: Comprueba el espacio disponible
        # Return: True si hay espacio para añadir elementos (y, por lo tanto, 
        #         no se ha llegado a la capacidad máxima) y False en otro caso
        def spaceAvailable
            return (@shieldBoosters.length + @weapons.length) < @maxElements
        end
        
        public
        
        # Brief: Añade un arma en el hangar si queda espacio
        # Param w: Arma a insertar
        # Return: True si se ha insertado el arma en el hangar y
        #         False en otro caso
        def addWeapon(w)
            if spaceAvailable
                @weapons.push( Weapon.newCopy(w) )
                return true
            end

                return false
        end
        
        # Brief: Añade un potenciador de escudo en el hangar si queda espacio
        # Param s: Potenciador de escudo a insertar
        # Return: True si se ha insertado el potenciador de escudo en el hangar y
        #         False en otro caso
        def addShieldBooster(s)
            if spaceAvailable
                @shieldBoosters.push( ShieldBooster.newCopy(s) )
                return true
            end

                return false
        end
        
        # Brief: Consultor de la capacidad máxima de elementos dentro del hangar
        # Return: maxElements
        def maxElements
            @maxElements
        end
        
        # Brief: Consultor de los potenciadores de escudo disponibles dentro del
        #        hangar
        # Return: shieldBoosters Array con los potenciadores de escudo del hangar
        def shieldBoosters
            @shieldBoosters
        end
    
        # Brief: Consultor de la colección de armas concretas disponibles 
        #        dentro del hangar
        # Return: weapons Array con las armas del hangar
        def weapons
        @weapons
        end
    
        # Brief: Elimina el potenciador de escudo número s del hangar y lo 
        #        devuelve, siempre que este exista. Si el índice suministrado 
        #        es incorrecto, entonces devuelve null.
        # Param s: Índice del potenciador de escudo a eliminar
        # Return: Potenciador de escudo de índice s, si existe, y
        #         null en el caso de que no existiera
        def removeShieldBooster(s)
            if(s < 0 || s >= @shieldBoosters.length)
                return nil
            end
        
            return @shieldBoosters.delete_at(s)
        end
        
        # Brief: Elimina el arma número w del hangar y la devuelve, siempre que
        #        esta exista. Si el índice suministrado es incorrecto,
        #        entonces devuelve null.
        # Param w: Índice del arma a eliminar
        # Return: Arma de índice s, si existe, y null en el caso de que 
        #         no existiera
        def removeWeapon(w)
            if(w < 0 || w >= @weapons.length)
                return nil
            end
        
            return @weapons.delete_at(w)
        end
    
        # Brief: Función para representar una instancia de la clase Hangar
        #        en un string
        # Return: String que representa una instancia de la clase Hangar
        def to_s
        
            s_maxElements = "- Capacidad maxima de elementos dentro del hangar: #{@maxElements}\n"

            s_weapons = "- Coleccion de armas disponibles dentro del hangar: Ninguna\n"
            if !@weapons.empty?
                s_weapons = "- Coleccion de armas disponibles dentro del hangar: \n"

                @weapons.each { |w|
                    s_weapons += "#{w.to_s}"
                }
            end

            s_shielBoosters = "\n- Potenciadores de escudo disponibles dentro del hangar: Ninguno\n"
            if !@shieldBoosters.empty?
                s_shielBoosters = "\n- Potenciadores de escudo disponibles dentro del hangar: \n"
                
                @shieldBoosters.each { |sb|
                    s_shielBoosters += "#{sb.to_s}"
                }
            end
        
            return s_maxElements + s_weapons + s_shielBoosters
        end
    end # Class
end # Module