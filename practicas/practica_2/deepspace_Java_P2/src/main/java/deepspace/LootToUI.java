/**
 * @file LootToUI.java
 * @author Profesor
 */
package deepspace;

/**
 * @brief Representación ToUI de Loot
 */
public class LootToUI {
    private final int nSupplies;
    private final int nWeapons;
    private final int nShields;
    private final int nHangars;
    private final int nMedals;

    /**
     * @brief Constructor con un parámetro
     * @param l Instancia de la clase Loot
     */
    LootToUI(Loot l) {
        nSupplies=l.getNSupplies();
        nWeapons=l.getNWeapons();
        nShields=l.getNShields();
        nHangars=l.getNHangars();
        nMedals=l.getNMedals();
    }  

    /**
     * @brief Consultor del número de suministros
     * @return nSupplies
     */
    public int getnSupplies() {
        return nSupplies;
    }

    /**
     * @brief Consultor del número de armas
     * @return nWeapons
     */
    public int getnWeapons() {
        return nWeapons;
    }

    /**
     * @brief Consultor del número de escudos
     * @return nShields
     */
    public int getnShields() {
        return nShields;
    }

    /**
     * @brief Consultor del número de hangares
     * @return nHangars
     */
    public int getnHangars() {
        return nHangars;
    }

    /**
     * @brief Consultor del número de medallas
     * @return nMedals
     */
    public int getnMedals() {
        return nMedals;
    }  
}