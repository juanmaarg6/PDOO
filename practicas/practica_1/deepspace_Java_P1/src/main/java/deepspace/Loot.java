/**
 * @file Loot.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

/**
 * @brief Representa el botín que se obtiene al vencer a una nave enemiga. 
 *        Puede incluir cantidades que representen un número de paquetes de 
 *        suministros, armas, potenciadores de escudo, hangares y/o medallas.
 */
class Loot {
    
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;

    /**
     * @brief Constructor con parámetros
     * @param p_nSupplies Número de suministros
     * @param p_nWeapons Número de armas
     * @param p_nShields Número de escudos
     * @param p_nHangars Número de hangares
     * @param p_nMedals Número de medallas
     */
    Loot(int p_nSupplies, int p_nWeapons, int p_nShields, int p_nHangars, int p_nMedals) {
        nSupplies = p_nSupplies;
        nWeapons = p_nWeapons;
        nShields = p_nShields;
        nHangars = p_nHangars;
        nMedals = p_nMedals;
    }
    
    /**
     * @brief Consultor del número de suministros
     * @return nSupplies
     */
    public final int getNSupplies() {
        return nSupplies;
    }
    
    /**
     * @brief Consultor del número de armas
     * @return nWeapons
     */
    public final int getNWeapons() {
        return nWeapons;
    }
    
    /**
     * @brief Consultor del número de escudos
     * @return nShields
     */
    public final int getNShields() {
        return nShields;
    }
    
    /**
     * @brief Consultor del número de hangares
     * @return nHangars
     */
    public final int getNHangars() {
        return nHangars;
    }
    
    /**
     * @brief Consultor del número de medallas
     * @return nMedals
     */
    public final int getNMedals() {
        return nMedals;
    }
}