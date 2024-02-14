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
     * @param p_name Valor del nombre
     * @param p_boost Valor del potenciador
     * @param p_uses Valor de los usos
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
     * @brief Emula el uso del potenciador de escudo.
     */
    public float useIt() {
        
        if(getUses() > 0) {
            uses--;
            return boost;
        }
        else
            return 1.0f;
    }
}