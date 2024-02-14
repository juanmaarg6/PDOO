#encoding: utf-8

# File: Loot.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace
    # Brief: Representa el botín que se obtiene al vencer a una nave enemiga. 
    #        Puede incluir cantidades que representen un número de paquetes de 
    #        suministros, armas, potenciadores de escudo, hangares y/o medallas.
    class Loot
        
        # Constructor con parámetros
        def initialize(p_nSupplies, p_nWeapons, p_nShields, p_nHangars, p_nMedals)
            @nSupplies = p_nSupplies
            @nWeapons = p_nWeapons
            @nShields = p_nShields
            @nHangars = p_nHangars
            @nMedals = p_nMedals
        end
        
        public
        
        # Consultor del número de suministros
        def nSupplies
            @nSupplies
        end
        
        # Consultor del número de armas
        def nWeapons
            @nWeapons
        end
        
        # Consultor del número de escudos
        def nShields
            @nShields
        end
        
        # Consultor del número de hangares
        def nHangars
            @nHangars
        end
        
        # Consultor del número de medallas
        def nMedals
            @nMedals
        end
    end
end