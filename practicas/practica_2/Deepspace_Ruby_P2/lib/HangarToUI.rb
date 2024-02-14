#encoding:utf-8

# File: HangarToUI.rb
# Author: Profesor

module Deepspace

# Brief: Representación ToUI de Hangar
class HangarToUI 

  # Consultores
  attr_reader :maxElements, :weapons, :shieldBoosters
  
  # Brief: Constructor con un parámetro
  # Param h: Instancia de la clase Hangar
  def initialize(h) 
    @weapons=Array.new()
    @shieldBoosters=Array.new()
    @maxElements=h.maxElements
    
    for w in h.weapons do
      @weapons.push(w.getUIversion())
    end
    
    for s in h.shieldBoosters do
      @shieldBoosters.push(s.getUIversion())
    end
  end
  
  # Brief: Función para representar una instancia de la clase HangarToUI
  #        en un string
  # Return: out String que representa una instancia de la clase HangarToUI
  def to_s
    return "Max Elements: #{@maxElements}, Weapons: [#{@weapons.join(", ")}], Shields: [#{@shieldBoosters.join(", ")}]"
  end

end # Class

end # Module