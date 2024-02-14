#encoding:utf-8

# File: TestP2.rb
# Author: Juan Manuel Rodríguez Gómez

require_relative 'Hangar'
require_relative 'ShieldBooster'
require_relative 'Weapon'
require_relative 'WeaponType'
require_relative 'Damage'
require_relative 'Loot'
require_relative 'EnemyStarShip'

module Deepspace
  class TestP2
    
    def self.main
      puts "Iniciando TestP2"

      hangar = Deepspace::Hangar.new(2)
      hangarCopy = Deepspace::Hangar.newCopy(hangar)
      shield = Deepspace::ShieldBooster.new("Shield", 2.4, 3)
      laser = Deepspace::Weapon.new("Laser", Deepspace::WeaponType::LASER, 2)
      plasma = Deepspace::Weapon.new("Plasma", Deepspace::WeaponType::PLASMA, 4)
      missile = Deepspace::Weapon.new("Missile", Deepspace::WeaponType::MISSILE, 3)
      
      weaponTypes = [Deepspace::WeaponType::LASER, Deepspace::WeaponType::PLASMA]
      weaponTypes.push(Deepspace::WeaponType::PLASMA)
      weaponTypes.push(Deepspace::WeaponType::PLASMA)
      weapons = [laser, plasma]
      
      weapAdjust = [laser, missile]
      shAdjust = [shield]
      
      damage = Deepspace::Damage.newNumericWeapons(5,3)
      damageSpecific = Deepspace::Damage.newSpecificWeapons(weaponTypes, 4)
      damageCopy = Deepspace::Damage.newCopy(damage)
      damageSpecificCopy = Deepspace::Damage.newCopy(damageSpecific)
      
      loot = Deepspace::Loot.new(4, 4, 5, 3, 6)
      enemy = Deepspace::EnemyStarShip.new("Enemigo", 2, 3, loot, damage)
      enemyCopy = Deepspace::EnemyStarShip.newCopy(enemy)
      
      # HANGAR
      puts "\n----- HANGAR -----\n"
      puts "Hangar ->\n%s" % hangar.to_s
      puts "\nHangarCopy ->\n%s" % hangarCopy.to_s
      
      puts "\nAñadiendo un escudo al original y un laser al hangar original y a la copia...\n"
      hangar.addShieldBooster(shield)
      hangar.addWeapon(laser)
      hangarCopy.addWeapon(laser)
      puts "Hangar ->\n%s" % hangar.to_s
      puts "\nHangarCopy ->\n%s" % hangarCopy.to_s
      
      puts "\nHangar ->\n%s" % hangar.to_s
      puts "\nHangarCopy ->\n%s" % hangarCopy.to_s

      puts "\nEliminando escudo del original...\n"
      hangar.removeShieldBooster(0)
      puts "\nHangar ->\n%s" % hangar.to_s
      puts "\nHangarCopy ->\n%s" % hangarCopy.to_s
      
      puts "\nEliminando primera arma de la copia...\n"
      hangarCopy.removeWeapon(0)
      puts "\nHangar ->\n%s" % hangar.to_s
      puts "\nHangarCopy ->\n%s" % hangarCopy.to_s
    
      # DAMAGE
      puts "\n----- DAMAGE -----\n"
      puts "Damage ->\n%s" % damage.to_s
      puts "\nDamageSpecific ->\n%s" % damageSpecific.to_s
      puts "\nDamageCopy ->\n%s" % damageCopy.to_s
      puts "\nDamageSpecificCopy ->\n%s" % damageSpecificCopy.to_s

      puts "\nAjustando DamageSpecific..."
      adjust = damageSpecific.adjust(weapAdjust, shAdjust)
      puts "\nDamageSpecific ->\n%s" % damageSpecific.to_s
      puts "\nDamageSpecificAdjust ->\n%s" % adjust.to_s
      
      puts "\nDescartando PLASMA y un escudo..."
      damage.discardWeapon(plasma)
      damageSpecific.discardWeapon(plasma)
      damage.discardShieldBooster
      damageSpecific.discardShieldBooster
      puts "Damage ->\n%s" % damage.to_s
      puts "\nDamageSpecific ->\n%s" % damageSpecific.to_s
      puts "\nDamageCopy ->\n%s" % damageCopy.to_s
      puts "\nDamageSpecificCopy ->\n%s" % damageSpecificCopy.to_s
      
    end
  end # Class

  TestP2.main

end # Module