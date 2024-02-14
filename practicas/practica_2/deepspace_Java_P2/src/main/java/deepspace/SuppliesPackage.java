/**
 * @file SuppliesPackage.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

/**
 * @brief Representa a un paquete de suministros para una estación espacial. 
 *        Puede contener armamento, combustible y/o energía para los escudos.
 */
class SuppliesPackage {
    
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    /**
     * @brief Constructor con parámetros
     * @param p_ammoPower Nivel de energía de disparo
     * @param p_fuelUnits Nivel de combustible
     * @param p_shieldPower Nivel de energía de los escudos
     */
    SuppliesPackage(float p_ammoPower, float p_fuelUnits, float p_shieldPower) {
        ammoPower = p_ammoPower;
        fuelUnits = p_fuelUnits;
        shieldPower = p_shieldPower;
    }
    
    /**
     * @brief Constructor de copia
     * @param s Otro objeto de la clase SuppliesPackage
     */
    SuppliesPackage(SuppliesPackage s) {
        ammoPower = s.ammoPower;
        fuelUnits = s.fuelUnits;
        shieldPower = s.shieldPower;
    }
 
    /**
     * @brief Consultor del nivel de energía de disparo
     * @return ammoPower
     */
    public final float getAmmoPower() {
        return ammoPower;
    }
    
    /**
     * @brief Consultor del nivel de combustible
     * @return fuelUnits
     */
    public final float getFuelUnits() {
        return fuelUnits;
    }
    
    /**
     * @brief Consultor del nivel de energía de los escudos
     * @return shieldPower
     */
    public final float getShieldPower() {
        return shieldPower;
    }
    
    /**
     * @brief Función para representar una instancia de la clase SuppliesPackage
     *        en un string
     * @return s String que representa una instancia de la clase SuppliesPackage
     */
    public String toString() {
        
        String s;
        
        String s_ammoPower = "- Nivel de energia de disparo: " + ammoPower + " ";
        String s_fuelUnits = "- Nivel de combustible: " + fuelUnits + " ";
        String s_shieldPower = "- Nivel de energia de escudo: " + shieldPower + "\n";
        
        s = s_ammoPower + s_fuelUnits + s_shieldPower;
        
        return s;
    }
}