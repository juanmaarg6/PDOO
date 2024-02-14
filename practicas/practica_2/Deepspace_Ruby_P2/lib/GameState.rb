#encoding:utf-8

# File: GameState.rb
# Author: Profesor

module Deepspace

# Brief: Representa el estado del juego    
module GameState
  
    CANNOTPLAY = :cannotplay
    INIT = :init
    BEFORECOMBAT = :beforecombat
    AFTERCOMBAT = :aftercombat
    

#     CANNOTPLAY:     the Gameuniverse has been created but not initialized
#     INIT:   the GameUniverse has been initialized and the current player has not combated. Players can mount weapons and shielboosters, or combat
#     BEFORECOMBAT:   players can only combat
#     AFTERCOMBAT:    players can mount/discard weapons,shielboosters and hangars 

end # Module GameState

end # Module Deepspace