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
     * @param p_ammoPower Valor del armamento
     * @param p_fuelUnits Valor del combustible
     * @param p_shieldPower Valor de la energía para los escudos
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
     * @brief Consultor del valor del armamento
     * @return ammoPower
     */
    public final float getAmmoPower() {
        return ammoPower;
    }
    
    /**
     * @brief Consultor del valor del combustible
     * @return fuelUnits
     */
    public final float getFuelUnits() {
        return fuelUnits;
    }
    
    /**
     * @brief Consultor del valor de la energía para los escudos
     * @return shieldPower
     */
    public final float getShieldPower() {
        return shieldPower;
    }
}