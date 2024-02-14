#encoding:utf-8

# File: SuppliesPackage.rb
# Author: Juan Manuel Rodríguez Gómez

module Deepspace

    # Brief: Representa a un paquete de suministros para una estación espacial. 
    #        Puede contener armamento, combustible y/o energía para los escudos.
    class SuppliesPackage

        # Brief: Constructor con parámetros
        # Param p_ammoPower: Nivel de energía de disparo
        # Param p_fuelUnits: Nivel de combustible
        # Param p_shieldPower: Nivel de energía de los escudos
        def initialize(p_ammoPower, p_fuelUnits, p_shieldPower)
            @ammoPower = p_ammoPower
            @fuelUnits = p_fuelUnits
            @shieldPower = p_shieldPower
        end

        # Brief: Constructor de copia
        # Param s: Otro objeto de la clase SuppliesPackage
        def self.newCopy(s)
            copy = SuppliesPackage.new(s.ammoPower, s.fuelUnits, s.shieldPower)
        end

        public
    
        # Brief: Consultor del nivel de energía de disparo
        # Return: ammoPower
        def ammoPower
            @ammoPower
        end
        
        # Brief: Consultor del nivel de combustible
        # Return: fuelUnits
        def fuelUnits
            @fuelUnits
        end
        
        # Brief: Consultor del nivel de energía de los escudos
        # Return: shieldPower
        def shieldPower
            @shieldPower
        end

        # Brief: Función para representar una instancia de la clase SuppliesPackage
        #        en un string
        # Return: String que representa una instancia de la clase SuppliesPackage
        def to_s
            s_ammoPower = "- Nivel de energia de disparo:: #{@ammoPower} "
            s_fuelUnits = "- Nivel de combustible: #{@fuelUnits} "
            s_shieldPower = "- Nivel de energia de escudo: #{@shieldPower}\n"
            
            return s_ammoPower + s_fuelUnits + s_shieldPower
        end
    end # Class
end # Module