/**
 * @file WeaponType.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

/**
 * @brief Representa a los tipos de armas del juego
 *        más cierta funcionalidad adicional.
 */
public enum WeaponType {
    LASER(2.0f),
    MISSILE(3.0f),
    PLASMA(4.0f);
    
    private float power;
    
    /**
     * @brief Constructor con un parámetro
     * @param p_power Poder del arma
     */
    WeaponType(float p_power) {
        power = p_power;
    }
    
    /**
     * @brief Consultor del poder del arma
     * @return power
     */
    final float getPower() {
        return power;
    }
}