#encoding: utf-8

require_relative "mi_enumerado"

module ElJuego
    class Primera_Clase
        
        def initialize(a,b,c)
            @atributo1 = a
            @atributo2 = b
            @atributo3 = c
        end

        def metodo_instancia
            puts "He llegado"
            puts inspect
            puts MiEnumerado::SEGUNDO
        end
    end

    mc=Primera_Clase.new(1,2,3)
    mc.metodo_instancia
end