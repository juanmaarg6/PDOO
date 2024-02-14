#encoding:utf-8

# File: WeaponType.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa a los tipos de armas del juego
    #        más cierta funcionalidad adicional.
    module WeaponType

        class Type
            
            # Brief: Constructor con un parámetro
            # Param p_power: Poder del arma
            def initialize(p_power)
                @power = p_power;
            end
          
            # Brief: Consultor del poder del arma
            # Return: power
            def power
                @power
            end

            # Brief: Función para representar el enumerado WeaponType
            # Return: String que representa el enumerado WeaponType
            def to_s
                if self == WeaponType::LASER
                  return "LASER"
                elsif self == WeaponType::MISSILE
                  return "MISSILE"
                else
                  return "PLASMA"
                end
              end
        end # Class

        LASER = Type.new(2.0)
        MISSILE = Type.new(3.0)
        PLASMA = Type.new(4.0) 
    end # Module WeaponType
end # Module Deepspace