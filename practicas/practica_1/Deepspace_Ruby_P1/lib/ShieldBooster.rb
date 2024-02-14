#encoding: utf-8

# File: ShieldBooster.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa los potenciadores de escudo que pueden tener las 
    #        estaciones espaciales.
    class ShieldBooster

        # Constructor con parámetros
        def initialize(p_name, p_boost, p_uses)
            @name = p_name
            @boost = p_boost
            @uses = p_uses
        end

        # Constructor de copia
        def self.newCopy(sb)
            copy = ShieldBooster.new(sb.name, sb.boost, sb.uses)
        end

        public
        
        # Consultor del nombre
        def name
            @name
        end

        # Consultor del valor del potenciador
        def boost
            @boost
        end
      
        # Consultor de los usos
        def uses
            @uses
        end

        # Emula el uso del potenciador de escudo.
        def useIt
            if(uses > 0)
              @uses -= 1
              return @boost
            else
              return 1.0
            end
        end
    end
end