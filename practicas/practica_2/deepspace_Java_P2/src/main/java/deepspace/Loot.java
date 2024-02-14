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
    
    /**
     * @brief Construye una nueva instancia LootToUI a partir de la propia 
     *        instancia que recibe el mensaje y lo devuelve.
     *        Estos objetos constituyen una capa que permite conectar el 
     *        modelo con la interfaz de usuario (Loot) manteniendo cierto nivel 
     *        de aislamiento entre ambos niveles
     * @return Instancia de la clase LootToUI
     */
    public LootToUI getUIversion() {
        return new LootToUI(this);
    }
    
    /**
     * @brief Función para representar una instancia de la clase Loot 
     *        en un string
     * @return s String que representa una instancia de la clase Loot
     */
    public String toString() {
        
        String s;
        
        String s_nSupplies = "- Numero de suministros: " + nSupplies + "\n";
        String s_nWeapons = "- Numero de armas: " + nWeapons + "\n";
        String s_nShields = "- Numero de escudos: " + nShields + "\n";
        String s_nHangars = "- Numero de hangares: " + nHangars + "\n";
        String s_nMedals = "- Numero de medallas: " + nMedals + "\n";
        
        s = s_nSupplies + s_nWeapons + s_nShields + s_nHangars + s_nMedals;
        
        return s;
    }
}