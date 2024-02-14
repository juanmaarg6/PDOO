#encoding:utf-8

# File: WeaponToUI.rb
# Author: Profesor

module Deepspace;

# Brief: Representación ToUI de Weapon
class WeaponToUI 

  # MIGUEL: por que  name  no forma parte de esta clase ?
  
    # Consultores
    attr_reader :type, :power, :uses
    
    # Brief: Constructor con un parámetro
    # Param w: Instancia de la clase Weapon
    def initialize(w) 
        @type=w.type();
        @power=w.power();
        @uses=w.uses();
    end  
    
      # Brief: Función para representar una instancia de la clase WeaponToUI
  #        en un string
  # Return: out String que representa una instancia de la clase WeaponToUI
    def to_s
      return "Type: #{@type}, Power: #{@power}, Uses: #{@uses}"
    end
    
end # Class

end # Module