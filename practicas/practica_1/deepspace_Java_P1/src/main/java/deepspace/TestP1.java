/**
 * @file TestP1.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

/**
 * @brief Test Deepspace Práctica 1
 */
public class TestP1 {

    public static void main(String[] args) {
        Weapon arma;
        ShieldBooster pEscudo;
        Loot botin;
        Dice dado;
        SuppliesPackage suministros;
        
        arma = new Weapon("Rayo", WeaponType.LASER, 0);
        pEscudo = new ShieldBooster("Ligero", 3.5f, 0);
        botin = new Loot(1,1,1,1,1);
        dado = new Dice();
        suministros = new SuppliesPackage(3.0f, 50f, 3.5f);
        
        System.out.format("\nTipo de arma: %s\n", arma.getType());
        System.out.format("\nUsos del arma: %d\n", arma.getUses());
        System.out.format("\nPoder del arma: %f\n", arma.power());
        
        System.out.format("\nShieldBoost: %f\n", pEscudo.getBoost());
        System.out.format("\nUsos del potenciador de escudo: %d\n", pEscudo.getUses());
        
        System.out.format("\nSuministros obtenidos: %d\n", botin.getNSupplies());
        System.out.format("\nNumero de armas obtenidas: %d\n", botin.getNWeapons());
        System.out.format("\nNumero de escudos obtenidos: %d\n", botin.getNShields());
        System.out.format("\nNumero de medallas obtenidas: %d\n", botin.getNMedals());
        System.out.format("\nNumero de hangares obtenidos: %d\n", botin.getNHangars());

        System.out.format("\nPontenciador del escudo: %f\n", pEscudo.getBoost());
        System.out.format("\nUsos del escudo: %d\n", pEscudo.getUses());
        
        System.out.format("\nPoder del arma obtenida en los suministros: %f\n", suministros.getAmmoPower());
        System.out.format("\nPoder del escudo obtenido en los suministros: %f\n", suministros.getShieldPower());
        System.out.format("\nGasolina obtenida en los suministros: %f\n", suministros.getFuelUnits());
        
        
        for(int i = 0; i < 100; ++i) {
            System.out.format("\nNumero de hangares: %d\n", dado.initWithNHangars());
            System.out.format("\nNumero de armas: %d\n", dado.initWithNWeapons());
            System.out.format("\nNumero de escudos: %d\n", dado.initWithNShields());
            System.out.format("\nComienza el jugador: %d\n", dado.whoStarts(2));
            System.out.format("\nPrimer disparo: %s\n", dado.firstShot());
            System.out.format("\n¿Se ha movido?: %b\n", dado.spaceStationMoves((i+1)/100));
        }      
    }
}