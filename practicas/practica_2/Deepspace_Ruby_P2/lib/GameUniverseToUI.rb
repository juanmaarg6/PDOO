#encoding:utf-8

# File: GameUniverseToUI.rb
# Author: Profesor

module Deepspace

# Brief: Representación ToUI de GameUniverse
class GameUniverseToUI 
  
  # Consultores
  attr_reader :currentStation, :currentEnemy
      
  # Brief: Constructor con parámetros
  # Param station: Instancia de la clase SpaceStation
  # Param enemy: Instancia de la clase EnemyStarShip
  def initialize (station,enemy) 
      @currentStation = station.getUIversion()
      @currentEnemy= enemy.getUIversion()
  end

  public
  
  # Brief: Función para representar una instancia de la clase GameUniverseToUI
  #        en un string
  # Return: out String que representa una instancia de la clase GameUniverseToUI
  def to_s
    out = "Estación actual -> #{@currentStation}\n"
    out +="Enemigo actual --> #{@currentEnemy}"
    return out
  end
    
end # Class

end # Module