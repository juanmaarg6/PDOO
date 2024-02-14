#encoding: utf-8

# File: SuppliesPackage.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa a un paquete de suministros para una estación espacial. 
    #        Puede contener armamento, combustible y/o energía para los escudos.
    class SuppliesPackage

        # Constructor con parámetros
        def initialize(p_ammoPower, p_fuelUnits, p_shieldPower)
            @ammoPower = p_ammoPower
            @fuelUnits = p_fuelUnits
            @shieldPower = p_shieldPower
        end

        # Constructor de copia
        def self.newCopy(s)
            copy = SuppliesPackage.new(s.ammoPower, s.fuelUnits, s.shieldPower)
        end

        public
    
        # Consultor del valor del armamento
        def ammoPower
            @ammoPower
        end
        
        #Consultor del valor del combustible
        def fuelUnits
            @fuelUnits
        end
        
        # Consultor del valor de la energía para los escudos
        def shieldPower
            @shieldPower
        end
    end
end