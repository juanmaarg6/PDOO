/**
 * @file ShieldBooster.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

/**
 * @brief Representa los potenciadores de escudo que pueden tener las 
 *        estaciones espaciales.
 */
class ShieldBooster {
    
    private String name;
    private float boost;
    private int uses;
    
    /**
     * @brief Constructor con parámetros
     * @param p_name Nombre
     * @param p_boost Potenciador
     * @param p_uses Usos
     */
    ShieldBooster(String p_name, float p_boost, int p_uses) {
        name = p_name;
        boost = p_boost;
        uses = p_uses;
    }
    
    /**
     * @brief Constructor de Copia
     * @param sb Otro objeto de la clase ShieldBooster
     */
    ShieldBooster(ShieldBooster sb) {
        name = sb.name;
        boost = sb.boost;
        uses = sb.uses;
    }
    
    /**
     * @brief Consultor del valor del potenciador
     * @return boost
     */
    public final float getBoost() {
        return boost;
    }
    
    /**
     * @brief Consultor de los usos
     * @return uses
     */
    public final int getUses() {
        return uses;
    }
    
    /**
     * @brief Emula el uso del potenciador de escudo
     */
    public float useIt() {
        
        if(getUses() > 0) {
            uses--;
            return boost;
        }
        else
            return 1.0f;
    }

    /**
     * @brief Construye una nueva instancia ShieldToUI a partir de la propia 
     *        instancia que recibe el mensaje y lo devuelve.
     *        Estos objetos constituyen una capa que permite conectar el 
     *        modelo con la interfaz de usuario (ShieldBooster) manteniendo 
     *        cierto nivel de aislamiento entre ambos niveles
     * @return Instancia de la clase ShieldToUI
     */
    public ShieldToUI getUIversion() {
        return new ShieldToUI(this);
    }
    
    /**
     * @brief Función para representar una instancia de la clase ShieldBooster
     *        en un string
     * @return s String que representa una instancia de la clase ShieldBooster
     */
    public String toString() {
        
        String s;
        
        String s_name = "- Nombre del potenciador de escudo: " + name + " ";
        String s_boost = "- Valor del potenciador de escudo: " + boost + " ";
        String s_uses = "- Usos restantes del potenciador de escudo: " + uses + "\n";
        
        s = s_name + s_boost + s_uses;
        
        return s;
    }
}