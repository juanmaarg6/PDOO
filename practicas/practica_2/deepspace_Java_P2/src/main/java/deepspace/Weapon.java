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
     * @param p_name Nombre
     * @param p_type Tipo de arma
     * @param p_uses Usos
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
     * @brief Devuelve la potencia de disparo indicada por el tipo de arma
     */
    public final float power() {
        return type.getPower();
    }
    
    /**
     * @brief Emula el uso del arma
     */
    public final float useIt() {
        if(getUses() > 0) {
            uses--;
            return power();
        }
        else
            return 1.0f;
    }
    
    /**
     * @brief Construye una nueva instancia WeaponToUI a partir de la propia 
     *        instancia que recibe el mensaje y lo devuelve.
     *        Estos objetos constituyen una capa que permite conectar el 
     *        modelo con la interfaz de usuario (Weapon) manteniendo 
     *        cierto nivel de aislamiento entre ambos niveles
     * @return Instancia de la clase WeaponToUI
     */
    public WeaponToUI getUIversion() {
        return new WeaponToUI(this);
    }
    
    /**
     * @brief Función para representar una instancia de la clase Weapon
     *        en un string
     * @return s String que representa una instancia de la clase Weapon
     */
    public String toString() {
        
        String s;
        
        String s_name = "- Nombre del arma: " + name + " ";
        String s_type = "- Tipo de arma: " + type + " ";
        String s_power = "- Potencia de disparo del arma: " + power() + " ";
        String s_uses = "- Usos restantes del arma: " + uses + "\n";
        
        
        s = s_name + s_type + s_power + s_uses;
        
        return s;
    }
}