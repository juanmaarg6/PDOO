/**
 * @file WeaponToUI.java
 * @author Profesor
 */
package deepspace;

/**
 * @brief Representación ToUI de Weapon
 */
public class WeaponToUI {
    private WeaponType type;
    private float power;
    private int uses;  
    
    /**
     * @brief Constructor con un parámetro
     * @param w Instancia de la clase Weapon
     */
    WeaponToUI(Weapon w) {
        type=w.getType();
        power=w.power();
        uses=w.getUses();
    }  

    /**
     * @brief Consultor del tipo de arma
     * @return type
     */
    public WeaponType getType() {
        return type;
    }

    /**
     * @brief Consultor del poder del arma
     * @return power
     */
    public float getPower() {
        return power;
    }

    /**
     * @brief Consultor de los usos
     * @return uses
     */
    public int getUses() {
        return uses;
    }
}