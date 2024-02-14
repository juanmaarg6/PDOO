#encoding:utf-8

# File: GameUniverse.rb
# Author: Juan Manuel Rodríguez Gómez

require_relative 'GameUniverseToUI'
require_relative 'SpaceStation'
require_relative 'GameStateController'
require_relative 'EnemyStarShip'
require_relative 'Dice'
require_relative 'ShotResult'
require_relative 'CombatResult'
require_relative 'GameCharacter'
require_relative 'CardDealer'

module Deepspace

    # Brief: Representa la jugabilidad del juego
    class GameUniverse

        # Constante
        @@WIN = 10
    
        #Constructor de la clase
        def initialize
            @currentStationIndex = -1
            @turns = 0
            @gameState = GameStateController.new
            @currentEnemy
            @dice = Dice.new
            @currentStation
            @spaceStations = Array.new
        end
        
        # Brief: Combate entre la estación espacial y la nave enemiga
        # Param station: Instancia de la clase SpaceStation
        # Param enemy Instancia de la clase EnemyStarShip
        # Return: Resultado de Combate
        def combatGo(station, enemy)
            #CODE GOES HERE AT P-03
        end
        
        # Brief: Si el juego se encuentra en un estado en el cual combatir 
        #        está permitido, entonces se realiza un combate entre la 
        #        estación espacial que tiene el turno y la nave enemiga
        # Return: Resultado del combate
        def combat
            #CODE GOES HERE AT P-03
        end
    
        public
        
        # Brief: Si el juego está en estado iniciado o después de combate, 
        #        se llama al método discardHangar() de la clase SpaceStation
        def discardHangar
            if(state == GameState::INIT || state == GameState::AFTERCOMBAT)
                @currentStation.discardHangar
            end
        end
        
        # Brief: Si el juego está en estado iniciado o después de combate, 
        #        se llama al método discardShieldBooster(int i) de la clase 
        #        SpaceStation
        # Param i: Índice del potenciador de escudo
        def discardShieldBooster(i)
            if(state == GameState::INIT || state == GameState::AFTERCOMBAT)
                @currentStation.discardShieldBooster(i)
            end
        end
        
        # Brief: Si el juego está en estado iniciado o después de combate, 
        #        se llama al método discardShieldBoosterInHangar(int i) de la 
        #        clase SpaceStation
        # Param i: Índice del potenciador de escudo
        def discardShieldBoosterInHangar(i)
            if(state == GameState::INIT || state == GameState::AFTERCOMBAT)
                @currentStation.discardShieldBoosterInHangar(i)
            end
        end
        
        # Brief: Si el juego está en estado iniciado o después de combate, 
        #        se llama al método discardWeapon(int i) de la 
        #        clase SpaceStation
        # Param i: Índice del arma
        def discardWeapon(i)
            if(state == GameState::INIT || state == GameState::AFTERCOMBAT)
                @currentStation.discardWeapon(i)
            end
        end
        
        # Brief: Si el juego está en estado iniciado o después de combate, 
        #        se llama al método discardWeaponInHangar(int i) de la 
        #        clase SpaceStation
        # Param i: Índice del arma
        def discardWeaponInHangar(i)
            if(state == GameState::INIT || state == GameState::AFTERCOMBAT)
                @currentStation.discardWeaponInHangar(i)
            end
        end
        
        # Brief: Consultor del estado del juego
        # Return: gameState
        def gameState
            @gameState
        end
        
        # Brief: Consultor del estado del juego
        # Return: gameState.state
        def state
            @gameState.state
        end
        
        # Brief: Construye una nueva instancia GameUniverseToUI a partir de la propia 
        #        instancia que recibe el mensaje y lo devuelve.
        #        Estos objetos constituyen una capa que permite conectar el 
        #        modelo con la interfaz de usuario (GameUniverse) manteniendo 
        #        cierto nivel de aislamiento entre ambos niveles
        # Return: Instancia de la clase GameUniverseToUI
        def getUIversion
            return GameUniverseToUI.new(@currentStation, @currentEnemy)
        end
        
        # Brief: Devuelve True si la estación espacial que tiene el turno ha 
        #        llegado al número de medallas necesarias para ganar
        # Return: True si la estación espacial que tiene el turno ha 
        #         llegado al número de medallas necesarias para ganar 
        #         y False en otro caso
        def haveAWinner
            return @currentStation.nMedals >= @@WIN
        end
        
        # Brief: Inicia una partida
        # Param names: Nombres de los jugadores
        def init(names)
            #CODE GOES HERE AT P-03
        end
        
        # Brief: Si el juego está en estado iniciado o después de combate, 
        #        se llama al método mountShieldBooster(int i) de la clase 
        #        SpaceStation
        # Param i: Índice del potenciador de escudo
        def mountShieldBooster(i)
            if(state == GameState::INIT || state == GameState::AFTERCOMBAT)
                @currentStation.mountShieldBooster(i)
            end
        end
        
        # Brief: Si el juego está en estado iniciado o después de combate, 
        #        se llama al método mountWeapon(int i) de la clase 
        #        SpaceStation
        # Param i: Índice del arma
        def mountWeapon(i)
            if(state == GameState::INIT || state == GameState::AFTERCOMBAT)
                @currentStation.mountWeapon(i)
            end
        end
        
        # Brief: Se comprueba que el jugador actual no tiene ningún daño pendiente 
        #        de cumplir, en cuyo caso se realiza un cambio de turno al 
        #        siguiente jugador con un nuevo enemigo con quien combatir
        # Return: True si el jugador actual no tiene ningún daño pendiente 
        #        de cumplir y False en otro caso
        def nextTurn
            #CODE GOES HERE AT P-03
        end
        
        # Brief: Función para representar una instancia de la clase GameUniverse
        #        en un string
        # Return: String que representa una instancia de la clase GameUniverse
        def to_s
            s_currentStationIndex = "- Indice de la estacion espacial actual: #{@currentStationIndex}\n"
            s_turns = "- Turnos: #{@turns}\n"
        
            s_gameState = "- Estado del juego: "
            if gameState == Deepspace::GameState::INIT
                s_gameState += "INIT\n"
            elsif gameState == Deepspace::GameState::CANNOTPLAY
                s_gameState += "CANNOTPLAT\n"
            elsif gameState == Deepspace::GameState::BEFORECOMBAT
                s_gameState += "BEFORECOMBAT\n"
            else
                s_gameState += "AFTERCOMBAT\n"
            end
        
            s_currentEnemy = "- Enemigo actual: Ninguno\n"
            if @currentEnemy != nil
                s_currentEnemy = "- Enemigo actual: \n#{@currentEnemy.to_s}\n"
            end

            s_currentStation = "- Estacion espacial actual: Ninguna\n"
            if @currentStation != nil
                s_currentStation = "- Estacion espacial actual: \n#{@currentStation.to_s}\n"
            end
        
            s_dice = "\n- Dado: \n#{@dice.to_s}\n"
        
            s_spaceStations = "- Estaciones espaciales: \n#{@spaceStations.to_s}\n"
        
            return s_currentStationIndex + s_turns + s_gameState + s_currentEnemy + s_currentStation + s_dice + s_spaceStations
        end
    end # Class
end # Module