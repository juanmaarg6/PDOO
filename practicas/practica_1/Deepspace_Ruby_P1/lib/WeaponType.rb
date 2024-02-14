#encoding: utf-8

# File: WeaponType.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa a los tipos de armas del juego
    #        más cierta funcionalidad adicional.
    module WeaponType
        class Type
            
            # Constructor con parámetro
            def initialize(p_power)
                @power = p_power;
            end
          
            #Consultor del poder del arma
            def power
                @power
            end
        end

        LASER = Type.new(2.0)
        MISSILE = Type.new(3.0)
        PLASMA = Type.new(4.0) 
    end
end