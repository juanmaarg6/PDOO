/**
 * @file GameUniverse.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

import java.util.ArrayList;

/**
 * @brief Representa la jugabilidad del juego
 */
public class GameUniverse {
    
    // Atributos de clase
    private static final int WIN = 10;
    
    // Atributos de instancia
    private int currentStationIndex;
    private int turns;
    
    // Atributos de relación
    private GameStateController gameState;
    private EnemyStarShip currentEnemy;
    private Dice dice;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations = new ArrayList<>();
    
    /**
     * @brief Constructor sin parámetros
     */
    public GameUniverse() {
        currentStationIndex = -1;
        turns = 0;
        gameState = new GameStateController();
        currentEnemy = null;
        dice = new Dice();
        currentStation = null;
    }
    
    /**
     * @brief Combate entre la estación espacial y la nave enemiga
     * @param station Instancia de la clase SpaceStation
     * @param enemy Instancia de la clase EnemyStarShip
     * @return Resultado de Combate
     */
    CombatResult combat(SpaceStation station, EnemyStarShip enemy) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Si el juego se encuentra en un estado en el cual combatir 
     *        está permitido, entonces se realiza un combate entre la 
     *        estación espacial que tiene el turno y la nave enemiga
     * @return Resultado del combate
     */
    public CombatResult combat() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Si el juego está en estado iniciado o después de combate, 
     *        se llama al método discardHangar() de la clase SpaceStation
     */
    public void discardHangar() {
        if( (gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT) )
            currentStation.discardHangar();
    }
    
    /**
     * @brief Si el juego está en estado iniciado o después de combate, 
     *        se llama al método discardShieldBooster(int i) de la clase 
     *        SpaceStation
     * @param i Índice del potenciador de escudo
     */
    public void discardShieldBooster(int i) {
        if((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            currentStation.discardShieldBooster(i);
    }
    
    /**
     * @brief Si el juego está en estado iniciado o después de combate, 
     *        se llama al método discardShieldBoosterInHangar(int i) de la 
     *        clase SpaceStation
     * @param i Índice del potenciador de escudo
     */
    public void discardShieldBoosterInHangar(int i) {
        if( (gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT) )
            currentStation.discardShieldBoosterInHangar(i);
    }
    
    /**
     * @brief Si el juego está en estado iniciado o después de combate, 
     *        se llama al método discardWeapon(int i) de la 
     *        clase SpaceStation
     * @param i Índice del arma
     */
    public void discardWeapon(int i) {
        if( (gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT) )
            currentStation.discardWeapon(i);
    }
    
    /**
     * @brief Si el juego está en estado iniciado o después de combate, 
     *        se llama al método discardWeaponInHangar(int i) de la 
     *        clase SpaceStation
     * @param i Índice del arma
     */
    public void discardWeaponInHangar(int i) {
        if( (gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT) )
            currentStation.discardWeaponInHangar(i);
    }
    
    /**
     * @brief Consultor del estado del juego
     * @return gamestate.getState() 
     */
    public GameState getState() {
        return gameState.getState();
    }
    
    /**
     * @brief Construye una nueva instancia GameUniverseToUI a partir de la propia 
     *        instancia que recibe el mensaje y lo devuelve.
     *        Estos objetos constituyen una capa que permite conectar el 
     *        modelo con la interfaz de usuario (GameUniverse) manteniendo 
     *        cierto nivel de aislamiento entre ambos niveles
     * @return Instancia de la clase GameUniverseToUI
     */
    public GameUniverseToUI getUIversion() {
        return new GameUniverseToUI(this.currentStation, this.currentEnemy);
    }
    
    /**
     * @brief Devuelve True si la estación espacial que tiene el turno ha 
     *        llegado al número de medallas necesarias para ganar
     * @return True si la estación espacial que tiene el turno ha 
     *         llegado al número de medallas necesarias para ganar 
     *         y False en otro caso
     */
    public boolean haveAWinner() {
        return (currentStation.getNMedals() >= WIN);
    }
    
    /**
     * @brief Inicia una partida
     * @param names Nombres de los jugadores
     */
    public void init(ArrayList<String> names) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Si el juego está en estado iniciado o después de combate, 
     *        se llama al método mountShieldBooster(int i) de la clase 
     *        SpaceStation
     * @param i Índice del potenciador de escudo
     */
    public void mountShieldBooster(int i) {
        if( (gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT) )
            currentStation.mountShieldBooster(i);
    }
    
    /**
     * @brief Si el juego está en estado iniciado o después de combate, 
     *        se llama al método mountWeapon(int i) de la clase 
     *        SpaceStation
     * @param i Índice del arma
     */
    public void mountWeapon(int i) {
        if( (gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT) )
            currentStation.mountWeapon(i);
    }
    
    /**
     * @brief Se comprueba que el jugador actual no tiene ningún daño pendiente 
     *        de cumplir, en cuyo caso se realiza un cambio de turno al 
     *        siguiente jugador con un nuevo enemigo con quien combatir
     * @return True si el jugador actual no tiene ningún daño pendiente 
     *        de cumplir y False en otro caso
     */
    public boolean nextTurn() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Función para representar una instancia de la clase GameUniverse
     *        en un string
     * @return s String que representa una instancia de la clase GameUniverse
     */
    public String toString() {
        
        String s;
        
        String s_currentStationIndex = "- Indice de la estacion espacial actual: " + currentStationIndex + "\n";
        String s_turns = "- Turnos: " + turns + "\n";
        String s_gameState = "- Estado del juego: " + gameState.getState() + "\n";
        
        String s_currentEnemy = "- Enemigo actual:\n";
        if(currentEnemy == null)
            s_currentEnemy += "Ninguno\n";
        else
            s_currentEnemy += currentEnemy.toString() + "\n";
            
        String s_currentStation = "- Estacion espacial actual:\n";
        if(currentStation != null)
            s_currentStation +=  "Ninguna\n";
        else
            s_currentStation += currentStation.toString() + "\n";
        
        String s_dice = "- Dado: \n" + dice.toString() + "\n";
        String s_spaceStations = "- Estaciones espaciales: \n" + spaceStations.toString() + "\n";
        
        s = s_currentStationIndex + s_turns + s_gameState + s_currentEnemy + s_currentStation + s_dice + s_spaceStations;
        
        return s;
    }
}