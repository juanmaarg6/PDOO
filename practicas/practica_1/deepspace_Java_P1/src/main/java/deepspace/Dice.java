/**
 * @file Dice.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;
import java.util.Random;

/**
 * @brief Toma todas las decisiones que dependen del azar del juego.
 */
class Dice {

    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    private Random generator;

    /**
     * @brief Constructor sin parámetros
     */
    Dice() {
        NHANGARSPROB = 0.25f;
        NSHIELDSPROB = 0.25f;
        NWEAPONSPROB = 0.33f;
        FIRSTSHOTPROB = 0.5f;
        generator = new Random();
    }

    /**
     * @brief Determina el número de hangares que recibirá una estación espacial
     *        al ser creada.
     */
    int initWithNHangars() {
        
        float probabilidad;
        probabilidad = generator.nextFloat();
        
        if(probabilidad < NHANGARSPROB)
            return 0;
        else
            return 1;
    }

    /**
     * @brief Determina el número de armas que recibirá una estación espacial
     *        al ser creada.
     */
    int initWithNWeapons() {
        
        float probabilidad;
        probabilidad = generator.nextFloat();
        
        if(probabilidad < NWEAPONSPROB)
            return 1;
        else if (probabilidad < 2*NWEAPONSPROB)
            return 2;
        else
            return 3;
    }
    
    /**
     * @brief Determina el número de potenciadores de escudo que recibirá una
     *        estación espacial al ser creada.
     */
    int initWithNShields() {
        
        float probabilidad;
        probabilidad = generator.nextFloat();
        
        if(probabilidad < NSHIELDSPROB)
            return 0;
        else
            return 1;
    }
    
    /**
     * @brief Determina el jugador (su índice) que iniciará la partida.
     * @param nPlayers Número de jugadores
     */
    int whoStarts(int nPlayers) {
        
        int player;
        player = generator.nextInt(nPlayers);
        
        return player;
    }
    
    /**
     * @brief Determina quién (de los tipos de personajes del juego) dispara
     *        primero en un combate: la estación espacial o la nave enemiga.
     */
    GameCharacter firstShot() {
                
        float probabilidad;
        probabilidad = generator.nextFloat();
        
        if(probabilidad < FIRSTSHOTPROB)
            return GameCharacter.SPACESTATION;
        else
            return GameCharacter.ENEMYSTARSHIP;
    }
    
    /**
     * @brief Determina si la estación espacial se moverá para 
     *        esquivar un disparo.
     * @param speed Velocidad máxima potencial
     */
    boolean spaceStationMoves(float speed) {
        
        float probabilidad;
        probabilidad = generator.nextFloat();
        
        return(probabilidad < speed);
    }
}