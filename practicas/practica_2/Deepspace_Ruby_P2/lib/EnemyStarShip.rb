#encoding:utf-8

# File: EnemyStarShip.rb
# Author: Juan Manuel Rodríguez Gómez

require_relative 'EnemyToUI'
require_relative 'Damage'
require_relative 'Loot'
require_relative 'ShotResult'

module Deepspace
    
    # Brief: Representa la nave enemiga
    class EnemyStarShip
    
        #Constructor con parámetros
        def initialize(n,a,s,l,d)
            @name = n
            @ammoPower = a
            @shieldPower = s
            @loot = l
            @damage = d
        end
    
        # Brief: Constructor de copia
        # Param e: Otra instancia de la clase EnemyStarShip
        def self.newCopy(e)
            copy = EnemyStarShip.new(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage)
        end
        
        public
        
        # Brief: Construye una nueva instancia EnemyToUI a partir de la propia 
        #        instancia que recibe el mensaje y lo devuelve.
        #        Estos objetos constituyen una capa que permite conectar el 
        #        modelo con la interfaz de usuario (EnemyStarShip) manteniendo 
        #        cierto nivel de aislamiento entre ambos niveles
        # Return: Instancia de la clase EnemyToUI
        def getUIversion
            return EnemyToUI.new(self)
        end
        
        # Brief: Devuelve el nivel de energía de disparo de la nave enemiga
        # Return: ammoPower
        def fire
            @ammoPower
        end
        
        # Brief: Consultor del nivel de energía de disparo de la nave enemiga
        # Return: ammoPower
        def ammoPower
            @ammoPower
        end
        
        # Brief: Consultor del daño que produce la nave enemiga
        # Return: damage
        def damage
            @damage
        end
        
        # Brief: Consultor del loot de la nave enemiga
        # Return: loot
        def loot
            @loot
        end
        
        # Brief: Consultor del nombre de la nave enemiga
        # Return: name
        def name
            @name
        end
        
        # Brief: Consultor del nivel de energía de escudo de la nave enemiga
        # Return: shieldPower
        def shieldPower
            @shieldPower
        end
        
        # Brief: Devuelve el nivel de energía de escudo de la nave enemiga
        # Return: shieldPower
        def getProtection
            @shieldPower
        end
        
        # Brief: Devuelve el resultado que se produce al recibir un disparo de 
        #        una determinada potencia (pasada como parámetro). Si el nivel de 
        #        la protección de los escudos es menor que la intensidad del 
        #        disparo, la nave enemiga no resiste (DONOTRESIST). En caso
        #        contrario resiste el disparo (RESIST). Se devuelve el resultado 
        #        producido por el disparo recibido
        # Param shot: Disparo de una determinada potencia
        # Return: DONOTRESIST si el nivel de la protección de los escudos es 
        #         menor que la intensidad del disparo y RESIST en caso contrario
        def receiveShot(shot)
            if shot > shieldPower
                return ShotResult::DONOTRESIST
            else
                return ShotResult::RESIST
            end
        end
    
        # Brief: Función para representar una instancia de la clase EnemyStarShip
        #        en un string
        # Return: String que representa una instancia de la clase EnemyStarShip
        def to_s
            
            s_name = "- Nombre de la nave enemiga: #{@name}\n"
            s_ammoPower = "- Nivel de energia de disparo de la nave enemiga: #{@ammoPower}\n"
            s_shieldPower = "- Nivel de energia de escuco de la nave enemiga: #{@shieldPower}\n"
            
            if loot == nil
                s_loot = "- Loot de la nave enemiga: Ninguno\n"
            else
                s_loot = "- Loot de la nave enemiga: \n#{@loot.to_s}\n"
            end
            
            if damage == nil
                s_damage = "- Daño que produce la nave enemiga: Ninguno\n"
            else
                s_damage = "- Daño que produce la nave enemiga: \n#{@damage.to_s}\n"
            end
            
            return s_name + s_ammoPower + s_shieldPower + s_loot + s_damage
        end
    end # Class
end # Module