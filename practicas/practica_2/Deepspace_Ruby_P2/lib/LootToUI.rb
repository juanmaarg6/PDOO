#encoding:utf-8

# File: LootToUI.rb
# Author: Profesor

module Deepspace

# Brief: Representación ToUI de Loot
class LootToUI

  # Consultores
  attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals

  # Brief: Constructor con un parámetro
  # Param l: Instancia de la clase Loot
  def initialize(l)
    @nSupplies=l.nSupplies
    @nWeapons=l.nWeapons
    @nShields=l.nShields
    @nHangars=l.nHangars
    @nMedals=l.nMedals
  end

  # Brief: Función para representar una instancia de la clase LootToUI
  #        en un string
  # Return: out String que representa una instancia de la clase LootToUI
  def to_s
    return "Supplies: #{@nSupplies}, Weapons: #{@nWeapons}, Shields: #{@nShields}, Hangars: #{@nHangars}, Medals: #{@nMedals}"
  end

end # Class

end # Module