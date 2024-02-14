#encoding: utf-8

# File: Weapon.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa a las armas de las que puede disponer una estación espacial 
    #        para potenciar su energía al disparar
    class Weapon

        # Constructor con parámetros
        def initialize(p_name, p_type, p_uses)
            @name = p_name
            @type = p_type
            @uses = p_uses
        end

        # Constructor de copia
        def self.newCopy(w)
            copy = Weapon.new(w.name, w.type, w.uses)
        end

        public

        #Consultor del tipo de arma
        def type
            if(@type == WeaponType::LASER)
                return WeaponType::LASER
            elsif (@type == WeaponType::MISSILE)
                return WeaponType::MISSILE
            else
                return WeaponType::PLASMA
            end
        end
      
        #Consultor del nombre
        def name
            @name
        end

        #Consultor de los usos
        def uses
            @uses
        end

        # Devuelve la potencia de disparo indicada por el tipo de arma.
        def power
            return type.power
        end

        # Emula el uso del arma.
        def useIt
            if (uses > 0)
              @uses -= 1
              return power
            else
              return 1.0
            end
        end
    end
end