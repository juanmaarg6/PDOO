/**
 * @file Hangar.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

import java.util.ArrayList;

/**
 * @brief Representa al Hangar donde se alojará la nave
 */
class Hangar {
    
    // Atributos de instancia
    private int maxElements;
    
    // Atributos de relación
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<ShieldBooster> shieldBoosters = new ArrayList<>();
    
    /**
     * @brief Constructor con un parámetro
     * @param capacity Capacidad del hangar
     */
    Hangar(int capacity) {
        maxElements = capacity;
    }
    
    /**
     * @brief Constructor de copia
     * @param h Otra instancia de la clase Hangar
     */
    Hangar(Hangar h) {
        
        maxElements = h.maxElements;
        
        for(Weapon w : h.weapons)
            weapons.add(w);
        
        for(ShieldBooster sb : h.shieldBoosters)
            shieldBoosters.add(sb);
    }
    
    /**
     * @brief Construye una nueva instancia HangarToUI a partir de la propia 
     *        instancia que recibe el mensaje y lo devuelve.
     *        Estos objetos constituyen una capa que permite conectar el 
     *        modelo con la interfaz de usuario (Hangar) manteniendo 
     *        cierto nivel de aislamiento entre ambos niveles
     * @return Instancia de la clase HangarToUI
     */
    HangarToUI getUIversion() {
        return new HangarToUI(this);
    }
    
    /**
     * @brief Comprueba el espacio disponible
     * @return True si hay espacio para añadir elementos (y, por lo tanto, 
     *         no se ha llegado a la capacidad máxima) y False en otro caso
     */
    private boolean spaceAvailable() {
        return ( (weapons.size() + shieldBoosters.size()) < maxElements );
    }
    
    /**
     * @brief Añade un arma en el hangar si queda espacio
     * @param w Arma a insertar
     * @return True si se ha insertado el arma en el hangar y
     *         False en otro caso
     */
    public boolean addWeapon(Weapon w) {
        
        boolean result = this.spaceAvailable();
        
        if(result)
            weapons.add(w);
        
        return result;    
    }
    
    /**
     * @brief Añade un potenciador de escudo en el hangar si queda espacio
     * @param s Potenciador de escudo a insertar
     * @return True si se ha insertado el potenciador de escudo en el hangar y
     *         False en otro caso
     */
    public boolean addShieldBooster(ShieldBooster s) {
        
        boolean result = this.spaceAvailable();
        
        if(result)
            shieldBoosters.add(s);
        
        return result;
    }
    
    /**
     * @brief Consultor de la capacidad máxima de elementos dentro del hangar
     * @return maxElements
     */
    public int getMaxElements(){
        return maxElements;
    }
    
    /**
     * @brief Consultor de los potenciadores de escudo disponibles dentro del
     *        hangar
     * @return shieldBoosters Array con los potenciadores de escudo del hangar
     */
    public ArrayList<ShieldBooster> getShieldBoosters() {
        return shieldBoosters;
    }
    
    /**
     * @brief Consultor de la colección de armas concretas disponibles 
     *        dentro del hangar
     * @return weapons Array con las armas del hangar
     */
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    
    /**
     * @brief Elimina el potenciador de escudo número s del hangar y lo 
     *        devuelve, siempre que este exista. Si el índice suministrado 
     *        es incorrecto, entonces devuelve null.
     * @param s Índice del potenciador de escudo a eliminar
     * @return Potenciador de escudo de índice s, si existe, y
     *         null en el caso de que no existiera
     */
    public ShieldBooster removeShieldBooster(int s) {
        if( s < 0 || s >= shieldBoosters.size() )
            return null;
        else
            return shieldBoosters.remove(s);
    }
    
    /**
     * @brief Elimina el arma número w del hangar y la devuelve, siempre que
     *        esta exista. Si el índice suministrado es incorrecto,
     *        entonces devuelve null.
     * @param w Índice del arma a eliminar
     * @return Arma de índice s, si existe, y null en el caso de que 
     *         no existiera
     */
    public Weapon removeWeapon(int w) {
        if( w < 0 || w >= weapons.size() )
            return null;
        else
            return weapons.remove(w);
    }
    
    /**
     * @brief Función para representar una instancia de la clase Hangar
     *        en un string
     * @return s String que representa una instancia de la clase Hangar
     */
    public String toString() {
        
        String s;
        
        String s_maxElements = "- Capacidad maxima de elementos dentro del hangar: " + maxElements + "\n";
        
        String s_weapons = "- Coleccion de armas disponibles dentro del hangar: \n";
        if( weapons == null || weapons.isEmpty() )
            s_weapons += "Ninguna\n";
        else
            for(Weapon w : weapons)
                s_weapons += " " + w.toString();
        
        String s_shieldBoosters = "\n- Potenciadores de escudo disponibles dentro del hangar: \n";
        if( shieldBoosters == null || shieldBoosters.isEmpty() )
            s_shieldBoosters += "Ninguno\n";
        else
            for(ShieldBooster sb : shieldBoosters)
                s_shieldBoosters += " " +sb.toString();
        
        s = s_maxElements + s_weapons + s_shieldBoosters;
        
        return s;
    }
}