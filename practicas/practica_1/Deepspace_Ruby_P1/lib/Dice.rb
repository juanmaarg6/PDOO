#encoding: utf-8

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
    
        # Determina el número de hangares que recibirá una estación espacial
        # al ser creada.
        def initWithNHangars

            probabilidad = rand()
            
            if(probabilidad < @NHANGARSPROB)
                return 0
            else
                return 1
            end
        end
    
        # Determina el número de armas que recibirá una estación espacial
        # al ser creada.
        def initWithNWeapons
        
            probabilidad = rand()
        
            if(probabilidad < @NWEAPONSPROB)
                return 1
            elsif (probabilidad < 2*@NWEAPONSPROB)
                return 2
            else
                return 3
            end
        end
    
        # Determina el número de potenciadores de escudo que recibirá una
        # estación espacial al ser creada.
        def initWithNShields
      
            probabilidad = rand()
      
            if(probabilidad < @NSHIELDSPROB)
                return 0
            else
                return 1
            end
        end

        # Determina el jugador (su índice) que iniciará la partida.
        def whoStarts(nPlayers)
            rand(nPlayers)
        end
      
        # Determina quién (de los tipos de personajes del juego) dispara
        # primero en un combate: la estación espacial o la nave enemiga.
        def firstShot
        
            probabilidad = rand()
        
            if (probabilidad < @FIRSTSHOTPROB)
                return GameCharacter::SPACESTATION
            else
                return GameCharacter::ENEMYSTARSHIP
            end
        end
      
        # Determina si la estación espacial se moverá para 
        #        esquivar un disparo.
        def spaceStationMoves(speed)
            probabilidad = rand()
            return (probabilidad < speed)
        end
    end
end