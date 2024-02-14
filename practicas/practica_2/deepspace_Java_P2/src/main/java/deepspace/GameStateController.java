/**
 * @file GameStateController.java
 * @author Profesor
 */
package deepspace;

/**
 * @brief Controlador del estado del juego
 */
class GameStateController {
    private GameState state;
    
    /**
     * @brief Constructor sin parámetros
     */
    GameStateController() {
        state=GameState.CANNOTPLAY;        
    }

    /**
     * @brief Devuelve el estado actual del juego
     * @return state
     */
    public GameState getState() {
        return state;
    }
    
    /**
     * @brief Determina el siguiente estado del juego
     * @param turn Número de turnos
     * @param nPlayers Número de jugadores
     * @return Siguiente estado del juego
     */
    public GameState next(int turn,int nPlayers) {
        switch (state) {
            case CANNOTPLAY: 
                state=GameState.INIT;
                break;
            case INIT: 
                state=GameState.AFTERCOMBAT;
                break;                
            case BEFORECOMBAT: 
                state=GameState.AFTERCOMBAT;
                break;
            case AFTERCOMBAT: 
                if (turn>=nPlayers)
                    state=GameState.BEFORECOMBAT;
                else
                    state=GameState.INIT;
                break;                
        }
        return state;
    }
}