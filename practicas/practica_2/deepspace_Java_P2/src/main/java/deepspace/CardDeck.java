/**
 * @file CardDeck.java
 * @author Profesor
 */
package deepspace;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @brief Clase parametrizable que representa un mazo de cartas de objetos de
 *        tipo T
 * @param <T> : Objeto del que se realizará el mazo de cartas
 */
class CardDeck<T> {    
    private ArrayList<T> cards=new ArrayList<>();
    private boolean ready;
    private int count;
    
    /**
     * @brief Constructor sin parámetros
     */
    CardDeck() {
        ready=false;
        count=0;
    }
    
    /**
     * @brief Inserta una nueva carta en el mazo
     * @param t Carta a insertar
     */
    public void add(T t) {
        if (!ready)
            cards.add(t);
    }
    
    /**
     * @brief Devuelve la siguiente carta del mazo
     * @return Siguiente carta del mazo
     */
    public T next() {
        if (!ready) {
            ready=true;
            shuffle();
        }

        T card=cards.remove(0);
        cards.add(card);
        
        count++;
        if (count==cards.size()) {
            shuffle();
            count=0;
        }
        
        T t=null;
        try {
            Class<T> clazz = (Class<T>) card.getClass();
            Constructor<T> c= clazz.getDeclaredConstructor(clazz);
            t = c.newInstance( card );
        } catch (ReflectiveOperationException ex) {
            Logger.getLogger(CardDeck.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
        
        //return card;
    }
    
    /**
     * @brief Baraja la colección de cartas disponibles
     */
    private void shuffle() {
        Collections.shuffle(cards);
    }
    
    /**
     * @brief Comprueba si se han barajado las cartas
     * @return True si se han bajarado las cartas y False en otro caso
     */
    boolean justShuffled() {
        return (count==0);
    }
}

/*
class SafeHangarCardDeck extends CardDeck<Hangar> {
    @Override
    public Hangar next() {
        Hangar h=(Hangar)(super.next());
        return new Hangar(h) ;
    }
}
*/