#encoding:utf-8

# File: Loot.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa el botín que se obtiene al vencer a una nave enemiga. 
    #        Puede incluir cantidades que representen un número de paquetes de 
    #        suministros, armas, potenciadores de escudo, hangares y/o medallas.
    class Loot
        
        # Brief: Constructor con parámetros
        # Param p_nSupplies: Número de suministros
        # Param p_nWeapons: Número de armas
        # Param p_nShields: Número de escudos
        # Param p_nHangars: Número de hangares
        # Param p_nMedals: Número de medallas
        def initialize(p_nSupplies, p_nWeapons, p_nShields, p_nHangars, p_nMedals)
            @nSupplies = p_nSupplies
            @nWeapons = p_nWeapons
            @nShields = p_nShields
            @nHangars = p_nHangars
            @nMedals = p_nMedals
        end
        
        public
        
        # Brief: Consultor del número de suministros
        # Return: nSupplies
        def nSupplies
            @nSupplies
        end
        
        # Brief: Consultor del número de armas
        # Return: nWeapons
        def nWeapons
            @nWeapons
        end
        
        # Brief: Consultor del número de escudos
        # Return: nShields
        def nShields
            @nShields
        end
        
        # Brief: Consultor del número de hangares
        # Return: nHangars
        def nHangars
            @nHangars
        end
        
        # Brief: Consultor del número de medallas
        # Return: nMedals
        def nMedals
            @nMedals
        end

        # Brief: Construye una nueva instancia LootToUI a partir de la propia 
        #        instancia que recibe el mensaje y lo devuelve.
        #        Estos objetos constituyen una capa que permite conectar el 
        #        modelo con la interfaz de usuario (Loot) manteniendo cierto nivel 
        #        de aislamiento entre ambos niveles
        # Return: Instancia de la clase LootToUI
        def getUIversion
            return LootToUI.new(self)
        end
      
        #Brief : Funcion de depuracion
        #Return : Representacion de la instancia pasada a cadena String
        def to_s
            
            s_nSupplies = "- Numero de suministros: #{@nSupplies} \n"
            s_nWeapons = "- Numero de armas: #{@nWeapons} \n"
            s_nShields = "- Numero de escudos: #{@nShields} \n"
            s_nHangars = "- Numero de hangares: #{@nHangars}\n"
            s_nMedals = "- Numero de medallas: #{@nMedals} \n"
            
            return s_nSupplies + s_nWeapons + s_nShields + s_nHangars + s_nMedals
        end
      
    end # Class
end # Module