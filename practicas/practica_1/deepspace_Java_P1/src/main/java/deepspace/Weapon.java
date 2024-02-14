/**
 * @file Weapon.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

/**
 * @brief Representa a las armas de las que puede disponer una estación espacial 
 *        para potenciar su energía al disparar
 */
class Weapon {

    private String name;
    private WeaponType type;
    private int uses;
    
    /**
     * @brief Constructor con parámetros
     * @param p_name Valor del nombre
     * @param p_type Valor del tipo de arma
     * @param p_uses Valor de los usos
     */
    Weapon(String p_name, WeaponType p_type, int p_uses) {
        name = p_name;
        type = p_type;
        uses = p_uses;
    }
    
    /**
     * @brief Constructor de copia
     * @param w Otro objeto de la clase Weapon
     */
    Weapon(Weapon w) {
        name = w.name;
        type = w.type;
        uses = w.uses;
    }
    
    /**
     * @brief Consultor del tipo de arma
     * @return type
     */
    public final WeaponType getType() {
        return type;
    }
    
    /**
     * @brief Consultor de los usos
     * @return uses
     */
    public final int getUses() {
        return uses;
    }

    /**
     * @brief Devuelve la potencia de disparo indicada por el tipo de arma.
     */
    public final float power() {
        return type.getPower();
    }
    
    /**
     * @brief Emula el uso del arma.
     */
    public final float useIt() {
        if(getUses() > 0) {
            uses--;
            return power();
        }
        else
            return 1.0f;
    }
}