#encoding:utf-8

# File: CardDeck.rb
# Author: Profesor

module Deepspace

# Brief: Clase que representa un mazo de cartas de objetos
class CardDeck 
  
  # Constructor sin parámetros
  def initialize()
    @cards=Array.new()
    @ready=false
    @count=0
  end
  
  public
  
  # Brief: Inserta una nueva carta en el mazo
  # Param t: Carta a insertar
  def add (t)
    if !@ready then
      @cards << t
    end
  end
  
  # Brief: Devuelve la siguiente carta del mazo
  # Return: Siguiente carta del mazo
  def next ()
    if (!@ready) then
      @ready=true;
      shuffle();
    end
      
    card=@cards.delete_at(0);
    @cards.push(card);
    
    @count+=1
    if (@count==@cards.size()) then
      shuffle();
      @count=0;
    end
      
    return card.class.newCopy(card)
  end
  
  # Brief: Comprueba si se han barajado las cartas
  # Return: True si se han bajarado las cartas y False en otro caso
  def justShuffled()
    return (@count==0)
  end

  private
  
  # Brief: Baraja la colección de cartas disponibles
  def shuffle()
    @cards.shuffle!
  end
  
  # Brief: Función para representar una instancia de la clase CardDeck
  #        en un string
  # Return s: String que representa una instancia de la clase CardDeck
  def to_s
    getUIversion().to_s
  end
  
end # Class

end # Module

if $0 == __FILE__ then
  class TestCard
    attr_accessor :a, :b
    def initialize (a,b=nil)
      @a=a
      if b != nil then
        @b = Array.new(b)
      else 
        @b=Array.new()
        @b << 1
        @b << 2
        @b << 3
      end
    end
    
    def self.newCopy(tc)
      new(tc.a, tc.b)
    end
    
  end
  
  test=Deepspace::CardDeck.new
  test.add(TestCard.new(1))
  test.add(TestCard.new(2))
  test.add(TestCard.new(3))
  test.add(TestCard.new(4))
  test.add(TestCard.new(5))
  for i in 0..15 do
    c = test.next
    puts c.a
    puts "[ #{c.b[0]}  ]"
    c.a +=10
    c.b.delete_at(0)
  end
end