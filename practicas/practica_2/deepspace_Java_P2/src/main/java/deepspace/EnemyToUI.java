/**
 * @file EnemyToUI.java
 * @author Profesor
 */
package deepspace;

/**
 * @brief Representación ToUI de EnemyStarShip
 */
public class EnemyToUI {
    private final String name;
    private final float ammoPower;
    private final float shieldPower;
    
    private LootToUI loot;
    private DamageToUI damage;   
    
    /**
     * @brief Constructor con un parámetro
     * @param enemy Instancia de la clase EnemyStarShip
     */
    EnemyToUI(EnemyStarShip enemy) {
        name=enemy.getName();
        ammoPower=enemy.getAmmoPower();
        shieldPower=enemy.getShieldPower();
    
        loot=enemy.getLoot().getUIversion();
        damage = enemy.getDamage().getUIversion();
    }

    /**
     * @brief Consultor del nombre de la nave enemiga
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Consultor del nivel de energía de disparo de la nave enemiga
     * @return ammoPower
     */
    public float getAmmoPower() {
        return ammoPower;
    }

    /**
     * @brief Consultor del nivel de energía de escudo de la nave enemiga
     * @return shieldPower
     */
    public float getShieldPower() {
        return shieldPower;
    }

    /**
     * @brief Consultor del loot de la nave enemiga
     * @return loot
     */
    public LootToUI getLoot() {
        return loot;
    }

    /**
     * @brief Consultor del daño de la nave enemiga
     * @return damage
     */
    public DamageToUI getDamage() {
        return damage;
    } 
}