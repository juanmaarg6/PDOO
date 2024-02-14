/**
 * @file ShieldToUI.java
 * @author Profesor
 */
package deepspace;

/**
 * @brief Representación ToUI de ShieldBooster
 */
public class ShieldToUI {
    private float boost;
    private int uses;

    /**
     * @brief Constructor con un parámetro
     * @param s Instancia de la clase ShieldBooster
     */
    ShieldToUI (ShieldBooster s) {
        boost=s.getBoost();
        uses=s.getUses();
    }    

    /**
     * @brief Consultor del valor del potenciador
     * @return boost
     */
    public float getBoost() {
        return boost;
    }

    /**
     * @brief Consultor de los usos
     * @return uses
     */
    public int getUses() {
        return uses;
    }
}