/**
 * @file Damage.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @brief Representa el daño producido a una estación espacial por una nave 
 *        enemiga cuando se pierde un combate. Cada instancia indicará la 
 *        pérdida de una cantidad de potenciadores de escudo y por otro lado, 
 *        o bien una cantidad de tipos indeterminados de armas o un conjunto 
 *        de tipos de armas concretas que se deben eliminar
 */
class Damage {
    
    // Atributos de instancia
    private int nShields;
    private int nWeapons;
    
    // Atributos de relación
    private ArrayList<WeaponType> weapons = new ArrayList<>();
    
    /**
     * @brief Constructor con parámetros
     * @param w Número de armas a eliminar
     * @param s Número de potenciadores de escudos a eliminar
     */
    Damage(int w, int s) {
        nShields = s;
        nWeapons = w;
        weapons = null;
    }
    
    /**
     * @brief Constructor con parámetros
     * @param wl Array de tipos de armas concretas a eliminar
     * @param s Número de potenciadores de escudos a eliminar
     */
    Damage(ArrayList<WeaponType> wl, int s) {
        nShields = s;
        nWeapons = -1;
        for(WeaponType w : wl)
            weapons.add(w);
    }
    
    /**
     * @brief Constructor de copia
     * @param d Otra instancia de la clase Damage
     */
    Damage(Damage d) {
        if(d.weapons == null) {
            nShields = d.nShields;
            nWeapons = d.nWeapons;
            weapons = null;
        }
        else {
            nShields = d.nShields;
            nWeapons = -1;
            for(WeaponType w : d.weapons)
                weapons.add(w);
        }
    }
    
    /**
     * @brief Construye una nueva instancia DamageToUI a partir de la propia 
     *        instancia que recibe el mensaje y lo devuelve.
     *        Estos objetos constituyen una capa que permite conectar el 
     *        modelo con la interfaz de usuario (Damage) manteniendo 
     *        cierto nivel de aislamiento entre ambos niveles
     * @return Instancia de la clase DamageToUI
     */
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    }
    
    /**
     * @brief Devuelve el índice de la posición de la primera arma de la 
     *        colección de armas (primer parámetro) cuyo tipo coincida con el 
     *        tipo indicado por el segundo parámetro. Devuelve -1 si no hay 
     *        ninguna arma en la colección del tipo indicado por el segundo 
     *        parámetro
     * @param w Colección de armas disponibles
     * @param t Tipo de arma a buscar
     * @return Índice de la posición de la primera arma de la colección de 
     *         armas cuyo tipo coincida con el tipo indicado por el segundo
     *         parámetro, o -1 si no se ha encontrado ninguna arma en la
     *         colección del tipo indicado por el segundo parámetro
     */
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t) {
        
        int index = 0;
        
        for (Weapon weapon : w) {
            if(weapon.getType() == t)
                return index;
            else
                index++;
        }
        
        return -1;
    }
 
    /**
     * @brief Devuelve una versión ajustada del objeto a las colecciones de 
     *        armas y potenciadores de escudos suministradas como parámetro.
     *        Partiendo del daño representado por el objeto que recibe este 
     *        mensaje, se devuelve una copia del mismo pero reducida si es 
     *        necesario para que no implique perder armas o potenciadores de 
     *        escudos que no están en las colecciones de los parámetros
     * @param w Colección de armas disponibles
     * @param s Colección de potenciadores de escudo disponibles
     * @return Damage ajustado
     */
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
        
        // Mínimo entre el número de potenciadores de escudo disponibles y el 
        // número de potenciadores de escudo a eliminar
        int minNShields = Math.min( nShields, s.size() );
        
        // Mínimo entre el número de armas disponibles y el número de armas
        // a eliminar
        int minNWeapons = Math.min( nWeapons, w.size() );
        
        // Ajuste de la colección de armas concretas a eliminar
        if( (weapons != null) && ( !weapons.isEmpty() ) ) {
            
            ArrayList<WeaponType> typesCopy = new ArrayList<>();
            ArrayList<Weapon> weaponsCopy = new ArrayList<>();
            ArrayList<WeaponType> adjustTypes = new ArrayList<>();
            
            // Copia del conjunto de armas concretas a eliminar
            for(int i = 0; i < weapons.size(); i++)
                typesCopy.add( weapons.get(i) );
            
            // Copia del conjunto de armas disponibles
            for(int i = 0; i < w.size(); i++)
                weaponsCopy.add( w.get(i) );
            
            // Iterador para realizar el ajuste
            Iterator<WeaponType> it = typesCopy.iterator();
            int index;
            
            // Recorremos todo el vector typesCopy elemento a elemento
            // usando el iterador
            while( it.hasNext() ) {
                

               // Seleccionamos el tipo de arma concreta a eliminar
               WeaponType type = it.next();
               
               // Comprobamos si el tipo de arma concreta a eliminar está
               // en weaponsCopy, es decir, en la copia del conjunto de 
               // armas disponibles
               index = arrayContainsType(weaponsCopy,type);
               
               // En el caso de que el tipo de arma concreta a eliminar está
               // en weaponsCopy, se elimina de weaponsCopy y se añade
               // a adjustTypes
               if(index != -1) {
                   weaponsCopy.remove(index);
                   adjustTypes.add(type);
               }
               
               it.remove();
            }
            
            // Devolvemos el Damage ajustado con el número de 
            // potenciadores de escudo y la colección de armas concretas
            // a eliminar
            return new Damage(adjustTypes, minNShields);
        }
        
        // En el caso de que no se haya especificado ninguna colección de
        // armas concretas a eliminar, devolvemos el Damage ajustado con
        // el número de potenciadores de escudo y el número de armas
        // a eliminar
        return new Damage(minNWeapons, minNShields);
    }
    
    /**
     * @brief Si la instancia dispone de una lista de tipos concretos de armas, 
     *        intenta eliminar el tipo del arma pasada como parámetro de esa 
     *        lista. En otro caso, simplemente decrementa en una unidad el 
     *        contador de armas que deben ser eliminadas. Ese contador no puede
     *        ser inferior a cero en ningún caso
     * @param w Arma cuyo tipo se va a eliminar de la lista de tipos concretos
     *          de armas disponibles, siempre que sea posible
     */
    public void discardWeapon(Weapon w) {
        if(nWeapons > 0)
            nWeapons--;
        if( (weapons != null) && ( !weapons.isEmpty() ) ) {
            int i = weapons.indexOf( w.getType() );
            
            if(i >= 0)
                weapons.remove(i);           
        }
    }
    
    /**
     * @brief Decrementa en una unidad el número de potenciadores de escudo que 
     *        deben ser eliminados. Ese contador no puede ser inferior a cero 
     *        en ningún caso
     */
    public void discardShieldBooster() {
        if(nShields > 0)
            nShields--;
    }
    
    /**
     * @brief Devuelve True si el daño representado no tiene ningún efecto.
     *        Esto quiere decir que no implica la pérdida de ningún tipo de 
     *        accesorio (armas o potenciadores de escudo)
     * @return True si el daño representado no tiene ningún efecto y 
     *         False en otro caso
     */
    public boolean hasNoEffect() {
        
        if(weapons == null)
            return ( (nShields == 0) && (nWeapons == 0) );
        
        return ( (nShields == 0) && ( weapons.isEmpty() ) );
    }
    
    /**
     * @brief Consultor del número de potenciadores de escudo a eliminar
     * @return nShields
     */
    public int getNShields() {
        return nShields;
    }
    
    /**
     * @brief Consultor del número de armas a eliminar
     * @return nWeapons
     */
    public int getNWeapons() {
        return nWeapons;
    }
    
    /**
     * @brief Consultor de la colección de armas concretas a eliminar
     * @return ArrayList weapons
     */
    public ArrayList<WeaponType> getWeapons() {
        return weapons;
    }
    
    /**
     * @brief Función para representar una instancia de la clase Damage
     *        en un string
     * @return s String que representa una instancia de la clase Damage
     */
    public String toString() {
        
        String s;
        
        String s_nShields = "- Numero de potenciadores de escudo a eliminar: " + nShields + "\n";
        String s_nWeapons = "- Numero de armas a eliminar: " + nWeapons + "\n";
        
        String s_weapons = "- Coleccion de armas a eliminar: ";
        if( weapons == null || weapons.isEmpty() )
            s_weapons += "Ninguna\n";
        else
            s_weapons += weapons.toString() + "\n";
        
        s = s_nShields + s_nWeapons + s_weapons;
        
        return s;
    }
}