#encoding:utf-8

# File: DamageToUI.rb
# Author: Profesor

module Deepspace

# Brief: Representación ToUI de Damage
class DamageToUI
  
  # Consultores
  attr_reader :nWeapons, :weapons, :nShields
  

  # Brief: Constructor con un parámetro
  # Param d: Instancia de la clase Damage
  def initialize (d) 
    @nWeapons=d.nWeapons
    @nShields=d.nShields
    tmp=d.weapons
    if (tmp!=nil) then
      @weapons=Array.new(tmp)
    else
      @weapons=nil
    end
  end
    
  public
  
  # Brief: Devuelve la información de la colección de armas concretas 
  #        a eliminar
  # Return: String con la información de la colección de armas concretas 
  #         a eliminar
  def getWeaponInfo() 
    out = "";
    
    if (nWeapons == -1) then
      out += "[" + @weapons.join(", ") + "]"
    else
      out += @nWeapons.to_s
    end
    return out
  end
  
  # Brief: Función para representar una instancia de la clase DamageToUI
  #        en un string
  # Return: out String que representa una instancia de la clase DamageToUI
  def to_s
    out = "Weapons: " + getWeaponInfo() + ", Shields: #{@nShields}"
  end
  
end # Class

end # Module