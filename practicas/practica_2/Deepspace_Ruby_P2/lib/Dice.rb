#encoding:utf-8

# File: Dice.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief:  Toma todas las decisiones que dependen del azar del juego.
    class Dice

        # Constructor sin parámetros
        def initialize
            @NHANGARSPROB=0.25 
            @NSHIELDSPROB=0.33
            @NWEAPONSPROB=0.33
            @FIRSTSHOTPROB=0.5
        end

        public
    
        # Brief: Determina el número de hangares que recibirá una estación espacial
        #        al ser creada
        def initWithNHangars

            probabilidad = rand()
            
            if probabilidad < @NHANGARSPROB
                return 0
            else
                return 1
            end
        end
    
        # Brief: Determina el número de armas que recibirá una estación espacial
        #        al ser creada
        def initWithNWeapons
        
            probabilidad = rand()
        
            if probabilidad < @NWEAPONSPROB
                return 1
            elsif probabilidad < 2*@NWEAPONSPROB
                return 2
            else
                return 3
            end
        end
    
        # Brief: Determina el número de potenciadores de escudo que recibirá una
        #        estación espacial al ser creada
        def initWithNShields
      
            probabilidad = rand()
      
            if probabilidad < @NSHIELDSPROB
                return 0
            else
                return 1
            end
        end

        # Brief: Determina el jugador (su índice) que iniciará la partida
        # Param nPlayers: Número de jugadores
        def whoStarts(nPlayers)
            rand(nPlayers)
        end
      
        # Brief: Determina quién (de los tipos de personajes del juego) dispara
        #        primero en un combate: la estación espacial o la nave enemiga
        def firstShot
        
            probabilidad = rand()
        
            if probabilidad < @FIRSTSHOTPROB
                return GameCharacter::SPACESTATION
            else
                return GameCharacter::ENEMYSTARSHIP
            end
        end
      
        # Brief: Determina si la estación espacial se moverá para 
        #        esquivar un disparo
        # Param speed: Velocidad máxima potencial
        def spaceStationMoves(speed)
            probabilidad = rand()

            return (probabilidad < speed)
        end

        # Brief: Función para representar una instancia de la clase Dice
        #        en un string
        # Return: String que representa una instancia de la clase Dice
        def to_s
      
            s_initHangars = "- Numero de hangares que recibe la estacion espacial al comenzar: #{initWithNHangars}\n"
            s_initWeapons = "- Numero de armas que recibe la estacion espacial al comenzar: #{initWithNWeapons}\n"
            s_initShields = "- Numero de potenciadores de escudo que recibe la estacion espacial al comenzar: #{initWithNShields}\n"
        
            if firstShot == Deepspace::GameCharacter::SPACESTATION
                s_firstShot = "- Dispara primero: SPACESTATION\n"
            else
                s_firstShot = "- Dispara primero: ENEMYSTARSHIP\n"
            end
        
            return s_initHangars + s_initWeapons + s_initShields + s_firstShot
        end
    end # Class
end # Module