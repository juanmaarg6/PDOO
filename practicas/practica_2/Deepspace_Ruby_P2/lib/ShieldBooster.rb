#encoding:utf-8

# File: ShieldBooster.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa los potenciadores de escudo que pueden tener las 
    #        estaciones espaciales.
    class ShieldBooster

        # Brief: Constructor con parámetros
        # Param p_name: Nombre
        # Param p_boost: Potenciador
        # Param p_uses: Usos
        def initialize(p_name, p_boost, p_uses)
            @name = p_name
            @boost = p_boost
            @uses = p_uses
        end

        # Brief: Constructor de Copia
        # Param sb: Otro objeto de la clase ShieldBooster
        def self.newCopy(sb)
            copy = ShieldBooster.new(sb.name, sb.boost, sb.uses)
        end

        public
        
        # Brief: Consultor del nombre
        # Return: name
        def name
            @name
        end

        # Brief: Consultor del valor del potenciador
        # Return: boost
        def boost
            @boost
        end
      
        # Brief: Consultor de los usos
        # Return: uses
        def uses
            @uses
        end

        # Brief: Emula el uso del potenciador de escudo
        def useIt
            if(uses > 0)
              @uses -= 1
              return @boost
            else
              return 1.0
            end
        end

        # Brief: Construye una nueva instancia ShieldToUI a partir de la propia 
        #        instancia que recibe el mensaje y lo devuelve.
        #        Estos objetos constituyen una capa que permite conectar el 
        #        modelo con la interfaz de usuario (ShieldBooster) manteniendo 
        #        cierto nivel de aislamiento entre ambos niveles
        # Return: Instancia de la clase ShieldToUI
        def getUIversion
            return ShieldToUI.new(self)
        end
      
        # Brief: Función para representar una instancia de la clase ShieldBooster
        #        en un string
        # Return: String que representa una instancia de la clase ShieldBooster
        def to_s
        
            s_name = "- Nombre del potenciador de escudo: #{@name} "
            s_boost = "- Valor del potenciador de escudo: #{@boost} "
            s_uses = "- Usos restantes del potenciador de escudo: #{@uses}\n"
        
            return s_name + s_boost + s_uses
        end
    end # Class
end # Module