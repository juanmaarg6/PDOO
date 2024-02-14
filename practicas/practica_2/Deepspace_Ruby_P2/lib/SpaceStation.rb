#encoding:utf-8

# File: SpaceStation.rb
# Author: Juan Manuel Rodríguez Gómez

require_relative 'SpaceStationToUI'
require_relative 'SuppliesPackage'
require_relative 'Hangar'
require_relative 'Weapon'
require_relative 'WeaponType'
require_relative 'ShieldBooster'
require_relative 'Damage'
require_relative 'Loot'
require_relative 'CardDealer'

module Deepspace
  
    # Brief: Representa la estacion espacial del juego
    class SpaceStation

        # Constantes
        @@MAXFUEL=100.0
        @@SHIELDLOSSPERUNITSHOT=0.1
    
        # Brief: Constructor con parámetros
        # Param n: Nombre de la estación espacial
        # Param supplies Paquete de suministros
        def initialize(n,s)
            @ammoPower = s.ammoPower
            @fuelUnits = s.fuelUnits
            @name = n
            @nMedals = 0
            @shieldPower = s.shieldPower
            @pendingDamage = nil
            @weapons = Array.new
            @shieldBoosters = Array.new
            @hangar = nil
        end
    
        private
        
        # Brief: Fija la cantidad de combustible al valor pasado como parámetro
        #        sin que nunca exceda del limite
        # Param f: Cantidad de combustible
        def assignFuelValue(f)
            if(f > @@MAXFUEL)
                @fuelUnits = @@MAXFUEL
            else
                @fuelUnits = f
            end
        end
        
        public
        
        # Brief: Si el daño pendiente no tiene efecto fija la referencia
        #        al mismo a null
        def cleanPendingDamage
            if(@pendingDamage.hasNoEffect)
                @pendingDamage = nil
            end
        end
        
        # Brief: Elimina todas las armas y potenciadores de escudo montados a
        #        las que no les queden usos
        def cleanUpMountedItems
            # Obtenemos las armas que no tienen usos

            weaponsWithNoUses = []
            @weapons.each{ |w|
                if w.uses == 0
                    weaponsWithNoUses.push(w)
                end
            }
            
            # Eliminamos las armas que no tienen usos
            weaponsWithNoUses.each{ |wNoUses|
                @weapons.delete(wNoUses)
            }
            
            # Obtenemos los potenciadores de escudo que no tienen usos
            sbWithNoUses = []
            @shieldBoosters.each { |sb|
                if sb.uses == 0
                    sbWithNoUses.push(sb)
                end
            }

            # Eliminamos los potenciadores de escudo que no tienen usos
            sbWithNoUses.each{ |sbNoUses|
                @shieldBoosters.delete(sbNoUses)
            }
        
        end
        
        # Brief: Fija la referencia del hangar a null para indicar que no se
        #        dispone del mismo
        def discardHangar
            @hangar = nil
        end
        
        # Brief: Descarta un potenciador de escudo
        # Param i: Índice del potenciador de escudo a descartar
        def discardShieldBooster(i)
            #CODE GOES HERE AT P-03
        end
        
        # Brief: Si se dispone de hangar, se solicita al mismo descartar el
        #        potenciador de escudo con índice i
        # Param i: Índice del potenciador de escudo a descartar
        def discardShieldBoosterInHangar(i)
            if(@hangar != nil)
                @hangar.removeShieldBooster(i)
            end
        end
        
        # Brief: Descarta un arma
        # Param i: Índice del arma a descartar
        def discardWeapon(i)
            #CODE GOES HERE AT P-03
        end
        
        # Brief: Si se dispone de hangar, se solicita al mismo descartar el
        #        arma con índice i
        # Param i: Índice del arma a descartar
        def discardWeaponInHangar(i)
            if(@hangar != nil)
                @hangar.removeWeapon(i)
            end
        end
        
        # Brief: Realiza un disparo
        # Return: La potencia del disparo
        def fire
            #CODE GOES HERE AT P-03
        end
    
        # Brief: Consultor del nivel de energía de disparo
        # Return: ammoPower
        def ammoPower
            @ammoPower
        end
        
        # Brief: Consultor del nivel de combustible
        # Return: fuelUnits
        def fuelUnits
            @fuelUnits
        end
        
        # Brief: Consultor del hangar
        # Return: hangar
        def hangar
            @hangar
        end
        
        # Brief: Consultor del nombre de la estación espacial
        # Return: name
        def name
            @name
        end
        
        # Brief: Consultor del número de medallas
        # Return: nMedals
        def nMedals
            @nMedals
        end
        
        # Brief: Consultor del daño pendiente
        # Return: pendingDamage
        def pendingDamage
            @pendingDamage
        end
        
        # Brief: Consultor de los potenciadores de escudo disponibles
        # Return: Array con los potenciadores de escudo disponibles
        def shieldBoosters
            @shieldBoosters
        end
        
        # Brief: Consultor del nivel de energía de escudo
        # Return: shieldPower
        def shieldPower
            @shieldPower
        end
        
        # Brief: Devuelve la velocidad de la estación espacial. Esta se calcula 
        #        como la fracción entre las unidades de combustible de las que 
        #        dispone en la actualidad la estación espacial respecto al
        #        máximo unidades de combustible que es posible almacenar. 
        #        La velocidad se representa por tanto como un número del 
        #        intervalo [0,1].
        # Return: speed
        def getSpeed
            return @fuelUnits.to_f/@@MAXFUEL.to_f
        end
        
        # Brief: Construye una nueva instancia SpaceStationToUI a partir de la propia 
        #        instancia que recibe el mensaje y lo devuelve.
        #        Estos objetos constituyen una capa que permite conectar el 
        #        modelo con la interfaz de usuario (SpaceStation) manteniendo 
        #        cierto nivel de aislamiento entre ambos niveles
        # Return: Instancia de la clase SpaceStationToUI
        def getUIversion
            return SpaceStationToUI.new(self)
        end
        
        # Brief: Consultor de las armas disponibles
        # Return: Array con las armas disponibles
        def weapons
            @weapons
        end
        
        # Brief: Se intenta montar el potenciador de escudo con el índice i dentro
        #        del hangar. Si se dispone de hangar, se le indica que elimine el 
        #        potenciador de escudo de esa posición y si esta operación tiene 
        #        éxito (el hangar proporciona el potenciador), se añade el mismo a
        #        la colección de potenciadores en uso
        # Param i: Índice del potenciador de escudo a montar
        def mountShieldBooster(i)
            if(@hangar != nil && (i >= 0))
                shieldBooster = @hangar.shieldBoosters[i]
                @hangar.removeShieldBooster(i)
                
                if(shieldBooster != nil)
                    @shieldBoosters.push(shieldBooster)
                end 
            end
        end
        
        # Brief: Se intenta montar el arma con el índice i dentro del hangar. Si 
        #        se dispone de hangar, se le indica que elimine el arma de esa 
        #        posición y si esta operación tiene éxito (el hangar proporciona 
        #        el arma), se añade el arma a la colección de armas en uso.
        # Param i: Índice del arma a montar
        def mountWeapon(i)
            if(@hangar != nil && (i >= 0))
                weapon = @hangar.weapons[i]
                @hangar.removeWeapon(i)
            
                if(weapon != nil)
                    @weapons.push(weapon)
                end
            end
        end
        
        # Brief: Decremento de unidades de combustible disponibles a causa de un 
        #       desplazamiento. Al número de las unidades almacenadas se les 
        #        resta una fracción de las mismas que es igual a la velocidad de 
        #        la estación. Las unidades de combustible no pueden ser inferiores 
        #        a 0
        def move
            @fuelUnits -= (getSpeed * fuelUnits)

            if fuelUnits < 0
                @fuelUnits = 0
            end
        end
        
        # Brief: Se usa el escudo de protección 
        # Return: Se devuelve la energía del mismo
        def protection
            #CODE GOES HERE AT P-03
        end
        
        # Brief: Si no se dispone de hangar, el parámetro pasa a ser el hangar de 
        #        la estación espacial. Si ya se dispone de hangar esta operación 
        #        no tiene efecto.
        # Param h: Instancia de la clase Hangar
        def receiveHangar(h)
            if(hangar == nil)
                @hangar = h
            end
        end
        
        # Brief: Si se dispone de hangar, devuelve el resultado de intentar 
        #        añadir el potenciador de escudo al mismo. Si no se dispone de 
        #        hangar devuelve False
        # Param s: Potenciador de escudo a insertar
        # Return: True si se dispone de hangar y se ha insertado el potenciador
        #         de escudo al mismo y False si no se dispone de hangar
        def receiveShieldBooster(s)
            if(hangar != nil)
                return @hangar.addShieldBooster(s)
            else
                return false
            end
        end
    
        # Brief: Realiza las operaciones relacionadas con la recepción del impacto 
        #        de un disparo enemigo
        # Param shot: Disparo enemigo
        # Return: Devuelve si se ha resistido el disparo o no
        def receiveShot(shot)
            #CODE GOES HERE AT P-03
        end
        
        # Brief: La potencia de disparo, la del escudo y las unidades de
        #        combustible se incrementan con el contenido del paquete 
        #        de suministro
        # Param s: Paquete de suministros
        def receiveSupplies(s)
            @ammoPower += s.ammoPower
            @fuelUnits += s.fuelUnits
            @shieldPower += s.shieldPower
            
            if(fuelUnits > @@MAXFUEL)
                @fuelUnits = @@MAXFUEL
            end
        end
        
        # Brief: Si se dispone de hangar, devuelve el resultado de intentar
        #        añadir el arma al mismo. Si no se dispone de hangar devuelve 
        #        False
        # Param w: Arma a insertar
        # Return: True si se dispone de hangar y se ha insertado el arma
        #         al mismo y False si no se dispone de hangar
        def receiveWeapon(w)
            if(hangar != nil)
                return @hangar.addWeapon(w)
            else
                return false
            end
        end
        
        # Brief: Recepción de un botín
        # Param loot: Botín a recibir
        def setLoot(loot)
            #CODE GOES HERE AT P-03
        end
        
        # Brief: Se calcula el parámetro ajustado (adjust) a la lista de armas y 
        #        potenciadores de escudo de la estación y se almacena el resultado 
        #        en el atributo correspondiente.
        # Param d: Instancia de la clase Damage
        def setPendingDamage(d)
            @pendingDamage = d.adjust(@weapons, @shieldBoosters)
            cleanPendingDamage
        end
        
        # Brief: Devuelve True si la estación espacial está en un estado válido. 
        #        Eso implica que o bien no se tiene ningún daño pendiente o que 
        #        este no tiene efecto
        # Return: True si la estación espacial está en un estado válido
        #         y False en otro caso
        def validState
            if @pendingDamage == nil
                return true
            end
        
            return @pendingDamage.hasNoEffect
        end
        
        # Brief: Función para representar una instancia de la clase SpaceStation
        #        en un string
        # Return: String que representa una instancia de la clase SpaceStation
        def to_s
        
            s_name = "- Nombre de la estacion espacial: #{@name}\n"
            s_ammoPower = "- Nivel de energia de disparo de la estacion espacial: #{@ammoPower}\n"
            s_fuelUnits = "- Nivel de combustible de la estacion espacial: #{@fuelUnits}\n"
            s_shieldPower = "- Nivel de energia de escudo de la estacion espacial: #{@shieldPower}\n"
            s_nMedals = "- Numero de medallas de la estacion espacial: #{@nMedals}\n"
            
            s_weapons = "\n- Armas montadas: Ninguna\n"
            if !weapons.empty?
                s_weapons = "\n- Armas montadas: \n"

                @weapons.each { |w|
                    s_weapons += "#{w.to_s}"
                }
            end

            s_shieldBoosters = "\n- Potenciadores de escudo montados: Ninguno\n"
            if !shieldBoosters.empty?
                s_shieldBoosters = "\n- Potenciadores de escudo montados: \n"

                @shieldBoosters.each { |shieldB|
                    s_shieldBoosters += "#{shieldB.to_s}"
                }
            end

            s_hangar = "\n- Hangar: Ninguno \n"
            if hangar != nil
                s_hangar = "\n- Hangar: \n#{@hangar.to_s}\n"
            end

            s_pendingDamage = "\n- Daño pendiente: Ninguno \n"
            if pendingDamage != nil
                s_pendingDamage = "\n- Daño pendiente: \n#{@pendingDamage.to_s}"
            end
    
            

            
            return s_name + s_ammoPower + s_fuelUnits + s_shieldPower + s_nMedals + s_weapons + s_shieldBoosters + s_hangar + s_pendingDamage
        end
    end # Class
end # Module