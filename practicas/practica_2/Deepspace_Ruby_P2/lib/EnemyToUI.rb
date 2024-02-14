#encoding:utf-8

# File: EnemyToUI.rb
# Author: Profesor

module Deepspace

# Brief: Representación ToUI de EnemyStarShip
class EnemyToUI 
  
  # Consultores
  attr_reader :name, :ammoPower, :shieldPower, :loot, :damage
  
  # Brief: Constructor con un parámetro
  # Param enemy: Instancia de la clase EnemyStarShip
  def initialize(enemy) 
    @name=enemy.name
    @ammoPower=enemy.ammoPower
    @shieldPower=enemy.shieldPower
    @loot=enemy.loot.getUIversion()
    @damage = enemy.damage.getUIversion()
  end

  # Brief: Función para representar una instancia de la clase EnemyToUI
  #        en un string
  # Return: out String que representa una instancia de la clase EnemyToUI
  def to_s
    return "Name: #{@name}, " + \
        "Ammo Power: #{@ammoPower}, " + \
        "Shield Power: #{@shieldPower}\n" + \
        "\tLoot..: #{@loot}\n" + \
        "\tDamage: #{@damage}"
  end
    
end # Class

end # Module