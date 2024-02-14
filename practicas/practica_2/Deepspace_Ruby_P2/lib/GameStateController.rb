#encoding:utf-8

# File: GameStateController.rb
# Author: Profesor

require_relative 'GameState'

module Deepspace

# Brief: Controlador del estado del juego
class GameStateController 

    # Consultor
    attr_reader :state
    
    # Constructor sin parámetros
    def initialize () 
        @state=GameState::CANNOTPLAY;        
    end

    # Brief: Determina el siguiente estado del juego
    # Param turn: Número de turnos
    # Param nPlayers: Número de jugadores
    # Return: Siguiente estado del juego
    def next(turn,nPlayers) 
        case @state
            when GameState::CANNOTPLAY
                @state=GameState::INIT
            when GameState::INIT
                @state=GameState::AFTERCOMBAT
            when GameState::BEFORECOMBAT
                @state=GameState::AFTERCOMBAT
            when GameState::AFTERCOMBAT
                if (turn>=nPlayers)
                    @state=GameState::BEFORECOMBAT
                else
                    @state=GameState::INIT
                end
        end
        return @state;
    end
end # Class

end # Module

if $0 == __FILE__ then
  gsc = Deepspace::GameStateController.new()
  puts gsc.state
  20.times {
    i = rand(5)+1
    puts "Turno " + i.to_s + " de 5 jugadores"
    puts gsc.next(i,5)
  }
end