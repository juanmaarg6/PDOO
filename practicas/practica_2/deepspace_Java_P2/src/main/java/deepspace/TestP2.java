/**
 * @file TestP2.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

import java.util.ArrayList;

/**
 * @brief Test Deepspace Práctica 2
 */
public class TestP2 {
    
    public static void main(String[] args) {
        final String LINE = "\n=========================\n";
        
        Hangar hangar = new Hangar(2);
        Hangar hangarCopy =new Hangar(hangar);
        ShieldBooster shield = new ShieldBooster("Shield", 2.4f, 3);
        Weapon laser = new Weapon("Laser", WeaponType.LASER, 2);
        Weapon plasma = new Weapon("Plasma", WeaponType.PLASMA, 4);
        Weapon missile = new Weapon("Missile", WeaponType.MISSILE, 3); 
        
        ArrayList<WeaponType> weaponTypes = new ArrayList<>();
        weaponTypes.add(WeaponType.LASER);
        weaponTypes.add(WeaponType.PLASMA);
        weaponTypes.add(WeaponType.PLASMA);
        weaponTypes.add(WeaponType.PLASMA);
        
        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(laser);
        weapons.add(plasma);
        
        ArrayList<Weapon> weapAdjust = new ArrayList<>();
        weapAdjust.add(laser);
        weapAdjust.add(missile);
        ArrayList<ShieldBooster> shAdjust = new ArrayList<>();
        shAdjust.add(shield);
        
        
        Damage damage = new Damage(5, 3);
        Damage damageSpecific = new Damage(weaponTypes, 4);
        Damage damageCopy = new Damage(damage);
        Damage damageSpecificCopy = new Damage(damageSpecific);
        
        Loot loot = new Loot(4,4,5,3,6);
        EnemyStarShip enemy = new EnemyStarShip("Enemigo", 2, 3, loot, damage);
        EnemyStarShip enemyCopy = new EnemyStarShip(enemy);
        
        // HANGAR
        System.out.println("\n----- HANGAR -----\n");
        System.out.printf("Hangar ->\n%s\n", hangar.toString());
        System.out.printf("\nHangarCopy ->\n%s\n", hangarCopy.toString());
        
        System.out.println("\nAñadiendo un escudo al original y un laser al hangar original y a la copia...\n");
        hangar.addShieldBooster(shield);
        hangar.addWeapon(laser);
        hangarCopy.addWeapon(laser);      
        System.out.printf("Hangar ->\n%s\n", hangar.toString());
        System.out.printf("\nHangarCopy ->\n%s\n", hangarCopy.toString());
        
        System.out.println("\nEliminando escudo del original...\n");
        hangar.removeShieldBooster(0);      
        System.out.printf("Hangar ->\n%s\n", hangar.toString());
        System.out.printf("\nHangarCopy ->\n%s\n", hangarCopy.toString());

        System.out.println("\nEliminando arma de la copia...\n");
        hangarCopy.removeWeapon(0);     
        System.out.printf("Hangar ->\n%s\n", hangar.toString());
        System.out.printf("\nHangarCopy ->\n%s\n", hangarCopy.toString());
        
        // DAMAGE
        System.out.println("\n----- DAMAGE -----\n");
        System.out.printf("Damage ->\n%s\n", damage.toString());
        System.out.printf("\nDamageCopy ->\n%s\n", damageCopy.toString());
        System.out.printf("\nDamageSpecific ->\n%s\n", damageSpecific.toString());
        System.out.printf("\nDamageSpecificCopy ->\n%s\n", damageSpecificCopy.toString());

        System.out.println("\nAjustando DamageSpecific...");
        Damage adjust = damageSpecific.adjust(weapAdjust, shAdjust);
        System.out.printf("\nDamageSpecific ->\n%s\n", damageSpecific.toString());
        System.out.printf("\nDamageSpecificAdjust ->\n%s\n", adjust.toString());
    
        System.out.println("\nDescartando PLASMA y escudo...");
        damage.discardWeapon(plasma);
        damageSpecific.discardWeapon(plasma);
        damage.discardShieldBooster();
        damageSpecific.discardShieldBooster();
        System.out.printf("Damage ->\n%s\n", damage.toString());
        System.out.printf("\nDamageCopy ->\n%s\n", damageCopy.toString());
        System.out.printf("\nDamageSpecific ->\n%s\n", damageSpecific.toString());
        System.out.printf("\nDamageSpecificCopy ->\n%s\n", damageSpecificCopy.toString());
    
        // ENEMYSTARSHIP
        System.out.println("\n----- ENEMY STARSHIP -----\n");
        System.out.printf("Enemy ->\n%s\n", enemy.toString());
        System.out.printf("\nEnemyCopy ->\n%s\n", enemyCopy.toString());
    }
}