#encoding:utf-8

# File: ShieldToUI.rb
# Author: Profesor

module Deepspace;

# Brief: Representación ToUI de ShieldBooster
class ShieldToUI 
  
  # Consultores
  attr_reader :boost, :uses

  # Brief: Constructor con un parámetro
   # Param s: Instancia de la clase ShieldBooster
  def initialize (s)
    @boost=s.boost
    @uses=s.uses
  end
  
  # Brief: Función para representar una instancia de la clase ShieldToUI
  #        en un string
  # Return: out String que representa una instancia de la clase ShieldToUI
  def to_s
    return "Boost: #{@boost}, Uses: #{@uses}"
  end
    
end # Class

end # Module