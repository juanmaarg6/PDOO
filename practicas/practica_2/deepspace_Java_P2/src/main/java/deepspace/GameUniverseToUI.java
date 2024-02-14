/**
 * @file GameUniverseToUI.java
 * @author Profesor
 */
package deepspace;

/**
 * @brief Representación ToUI de GameUniverse
 */
public class GameUniverseToUI {
    SpaceStationToUI currentStation;
    EnemyToUI currentEnemy;
    
    /**
     * @brief Constructor con parámetros
     * @param station Instancia de la clase SpaceStation
     * @param enemy Instancia de la clase EnemyStarShip
     */
    GameUniverseToUI(SpaceStation station,EnemyStarShip enemy) {
        currentStation = station.getUIversion();
        currentEnemy= enemy.getUIversion();
    }

    /**
     * @brief Consultor de la estación actual
     * @return currentStation
     */
    public SpaceStationToUI getCurrentStation() {
        return currentStation;
    }

    /**
     * @brief Consultor del enemigo actual
     * @return currentEnemy
     */
    public EnemyToUI getCurrentEnemy() {
        return currentEnemy;
    } 
}