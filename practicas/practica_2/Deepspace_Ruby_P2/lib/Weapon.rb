#encoding:utf-8

# File: Weapon.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa a las armas de las que puede disponer una estación espacial 
    #        para potenciar su energía al disparar
    class Weapon

        # Brief: Constructor con parámetros
        # Param p_name: Nombre
        # Param p_type: Tipo de arma
        # Param p_uses: Usos
        def initialize(p_name, p_type, p_uses)
            @name = p_name
            @type = p_type
            @uses = p_uses
        end

        # Brief: Constructor de copia
        # Param w: Otro objeto de la clase Weapon
        def self.newCopy(w)
            copy = Weapon.new(w.name, w.type, w.uses)
        end

        public

        # Brief: Consultor del tipo de arma
        # Return: type
        def type
            if(@type == WeaponType::LASER)
                return WeaponType::LASER
            elsif (@type == WeaponType::MISSILE)
                return WeaponType::MISSILE
            else
                return WeaponType::PLASMA
            end
        end
      
        # Brief: Consultor del nombre del arma
        # Return: name
        def name
            @name
        end

        # Brief: Consultor de los usos
        # Return: uses
        def uses
            @uses
        end

        # Brief: Devuelve la potencia de disparo indicada por el tipo de arma
        def power
            return type.power
        end

        # Brief: Emula el uso del arma
        def useIt
            if (uses > 0)
              @uses -= 1
              return power
            else
              return 1.0
            end
        end

        # Brief: Construye una nueva instancia WeaponToUI a partir de la propia 
        #        instancia que recibe el mensaje y lo devuelve.
        #        Estos objetos constituyen una capa que permite conectar el 
        #        modelo con la interfaz de usuario (Weapon) manteniendo 
        #        cierto nivel de aislamiento entre ambos niveles
        # Return: Instancia de la clase WeaponToUI
        def getUIversion
            return WeaponToUI.new(self)
        end
        
        # Brief: Función para representar una instancia de la clase Weapon
        #        en un string
        # Return: String que representa una instancia de la clase Weapon
        def to_s
            s_name = "- Nombre del arma: #{@name} "
            s_type = "- Tipo de arma: #{@type.to_s} "
            s_power = "- Potencia de disparo del arma: #{power} "
            s_uses = "- Usos restantes del arma: #{@uses}\n"
            
            return s_name + s_type + s_power + s_uses
        end
    end # Class
end # Module