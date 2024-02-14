/**
 * @file SpaceStation.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

import java.util.ArrayList;

/**
 * @brief Representa la estacion espacial del juego
 */
class SpaceStation {
    
    // Atributos de clase
    private static final float MAXFUEL = 100f;
    private static final float SHIELDLOSSPERUNITSHOT = 0.1f;
    
    // Atributos de instancia
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    
    // Atributos de relación
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<ShieldBooster> shieldBoosters = new ArrayList<>();
    private Hangar hangar;  
    
    /**
     * @brief Fija la cantidad de combustible al valor pasado como parámetro
     *        sin que nunca exceda del limite
     * @param f Cantidad de combustible
     */
    private void assignFuelValue(float f) {
        if(f > MAXFUEL)
            fuelUnits = MAXFUEL;
        else
            fuelUnits = f;
    }
    
    /**
     * @brief Si el daño pendiente no tiene efecto fija la referencia
     *        al mismo a null
     */
    private void cleanPendingDamage() {
        if( pendingDamage.hasNoEffect() )
            pendingDamage = null;
    }
    
    /**
     * @brief Constructor con parámetros
     * @param n Nombre de la estación espacial
     * @param supplies Paquete de suministros
     */
    SpaceStation(String n, SuppliesPackage supplies) {
        ammoPower = supplies.getAmmoPower();
        fuelUnits = supplies.getFuelUnits();
        name = n;
        nMedals = 0;
        shieldPower = supplies.getShieldPower();
        pendingDamage = null;
    }
    
    /**
     * @brief Elimina todas las armas y potenciadores de escudo montados a
     *        las que no les queden usos
     */
    public void cleanUpMountedItems() {
        
        // Obtenemos las armas que no tienen usos
        ArrayList<Weapon> weaponsWithNoUses = new ArrayList<>();
        for(Weapon w: weapons)
            if (w.getUses() == 0)
                weaponsWithNoUses.add(w);
        
        // Eliminamos las armas que no tienen usos
        for(Weapon w: weaponsWithNoUses){
            weapons.remove(w);
        }
        
        // Obtenemos los potenciadores de escudo que no tienen usos
        ArrayList<ShieldBooster> shieldWithNoUses = new ArrayList<>();
        for(ShieldBooster s: shieldBoosters)
            if(s.getUses() == 0)
                shieldWithNoUses.add(s);
        
        // Eliminamos los potenciadores de escudo que no tienen usos
        for(ShieldBooster s: shieldWithNoUses)
            shieldBoosters.remove(s);
    }
    
    /**
     * @brief Fija la referencia del hangar a null para indicar que no se
     *        dispone del mismo
     */
    public void discardHangar() {
        hangar = null;
    }
    
    /**
     * @brief Descarta un potenciador de escudo
     * @param i Índice del potenciador de escudo a descartar
     */
    public void discardShieldBooster(int i) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Si se dispone de hangar, se solicita al mismo descartar el
     *        potenciador de escudo con índice i
     * @param i Índice del potenciador de escudo a descartar
     */
    public void discardShieldBoosterInHangar(int i) {
        if(hangar != null)
            hangar.removeShieldBooster(i);
    }
    
    /**
     * @brief Descarta un arma
     * @param i Índice del arma a descartar
     */
    public void discardWeapon(int i) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Si se dispone de hangar, se solicita al mismo descartar el
     *        arma con índice i
     * @param i Índice del arma a descartar
     */
    public void discardWeaponInHangar(int i) {
        if(hangar != null)
            hangar.removeWeapon(i);
    }
    
    /**
     * @brief Realiza un disparo
     * @return La potencia del disparo
     */
    public float fire() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Consultor del nivel de energía de disparo
     * @return ammoPower
     */
    public float getAmmoPower() {
        return ammoPower;
    }
    
    /**
     * @brief Consultor del nivel de combustible
     * @return fuelUnits
     */
    public float getFuelUnits() {
        return fuelUnits;
    }
    
    /**
     * @brief Consultor del hangar
     * @return hangar
     */
    public Hangar getHangar() {
        return hangar;
    }
    
    /**
     * @brief Consultor del nombre de la estación espacial
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @brief Consultor del número de medallas
     * @return nMedals
     */
    public int getNMedals() {
        return nMedals;
    }
    
    /**
     * @brief Consultor del daño pendiente
     * @return pendingDamage
     */
    public Damage getPendingDamage() {
        return pendingDamage;
    }
    
    /**
     * @brief Consultor de los potenciadores de escudo disponibles
     * @return ArrayList con los potenciadores de escudo disponibles
     */
    public ArrayList<ShieldBooster> getShieldBoosters() {
        return shieldBoosters;
    }
    
    /**
     * @brief Consultor del nivel de energía de escudo
     * @return shieldPower
     */
    public float getShieldPower() {
        return shieldPower;
    }
    
    /**
     * @brief Devuelve la velocidad de la estación espacial. Esta se calcula 
     *        como la fracción entre las unidades de combustible de las que 
     *        dispone en la actualidad la estación espacial respecto al
     *        máximo unidades de combustible que es posible almacenar. 
     *        La velocidad se representa por tanto como un número del 
     *        intervalo [0,1].
     * @return speed
     */
    public float getSpeed() {
        
        float speed = fuelUnits/MAXFUEL;
        
        return speed;
    }
    
    /**
     * @brief Construye una nueva instancia SpaceStationToUI a partir de la propia 
     *        instancia que recibe el mensaje y lo devuelve.
     *        Estos objetos constituyen una capa que permite conectar el 
     *        modelo con la interfaz de usuario (SpaceStation) manteniendo 
     *        cierto nivel de aislamiento entre ambos niveles
     * @return Instancia de la clase SpaceStationToUI
     */
    public SpaceStationToUI getUIversion() {
        return new SpaceStationToUI(this);
    }
    
    /**
     * @brief Consultor de las armas disponibles
     * @return ArrayList con las armas disponibles
     */
    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    
    /**
     * @brief Se intenta montar el potenciador de escudo con el índice i dentro
     *        del hangar. Si se dispone de hangar, se le indica que elimine el 
     *        potenciador de escudo de esa posición y si esta operación tiene 
     *        éxito (el hangar proporciona el potenciador), se añade el mismo a
     *        la colección de potenciadores en uso
     * @param i Índice del potenciador de escudo a montar
     */
    public void mountShieldBooster(int i) {
        if(hangar != null)
            if( (i >= 0) && ( i < hangar.getShieldBoosters().size() ) ) {
                ShieldBooster shieldBooster = hangar.removeShieldBooster(i);
                if(shieldBooster != null)
                    shieldBoosters.add(shieldBooster);
            }
    }
    
    /**
     * @brief Se intenta montar el arma con el índice i dentro del hangar. Si 
     *        se dispone de hangar, se le indica que elimine el arma de esa 
     *        posición y si esta operación tiene éxito (el hangar proporciona 
     *        el arma), se añade el arma a la colección de armas en uso.
     * @param i Índice del arma a montar
     */
    public void mountWeapon(int i) {
        if(hangar != null)
            if( (i >= 0) && ( i < hangar.getWeapons().size() ) ) {
                Weapon weapon = hangar.removeWeapon(i);
                if(weapon != null)
                    weapons.add(weapon);
            }
    }
    
    /**
     * @brief Decremento de unidades de combustible disponibles a causa de un 
     *        desplazamiento. Al número de las unidades almacenadas se les 
     *        resta una fracción de las mismas que es igual a la velocidad de 
     *        la estación. Las unidades de combustible no pueden ser inferiores 
     *        a 0
     */
    public void move() {
        fuelUnits -= getSpeed();
        if(fuelUnits < 0)
            fuelUnits = 0;
    }
    
    /**
     * @brief Se usa el escudo de protección 
     * @return Se devuelve la energía del mismo
     */
    public float protection() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Si no se dispone de hangar, el parámetro pasa a ser el hangar de 
     *        la estación espacial. Si ya se dispone de hangar esta operación 
     *        no tiene efecto.
     * @param h Instancia de la clase Hangar
     */
    public void receiveHangar(Hangar h) {
        if(hangar == null)
            hangar = h;
    }
    
    /**
     * @brief Si se dispone de hangar, devuelve el resultado de intentar 
     *        añadir el potenciador de escudo al mismo. Si no se dispone de 
     *        hangar devuelve False
     * @param s Potenciador de escudo a insertar
     * @return True si se dispone de hangar y se ha insertado el potenciador
     *         de escudo al mismo y False si no se dispone de hangar
     */
    public boolean receiveShieldBooster(ShieldBooster s) {
        if(hangar != null)
            return hangar.addShieldBooster(s);
        else
            return false;
    }
    
    /**
     * @brief Realiza las operaciones relacionadas con la recepción del impacto 
     *        de un disparo enemigo
     * @param shot Disparo enemigo
     * @return Devuelve si se ha resistido el disparo o no
     */
    public ShotResult receiveShot(float shot) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief La potencia de disparo, la del escudo y las unidades de
     *        combustible se incrementan con el contenido del paquete 
     *        de suministro
     * @param s Paquete de suministros
     */
    public void receiveSupplies(SuppliesPackage s) {
        
        ammoPower += s.getAmmoPower();
        fuelUnits += s.getFuelUnits();
        shieldPower += s.getShieldPower();
        
        if(fuelUnits > MAXFUEL)
            fuelUnits = MAXFUEL;
    }
    
    /**
     * @brief Si se dispone de hangar, devuelve el resultado de intentar
     *        añadir el arma al mismo. Si no se dispone de hangar devuelve 
     *        False
     * @param w Arma a insertar
     * @return True si se dispone de hangar y se ha insertado el arma
     *         al mismo y False si no se dispone de hangar
     */
    public boolean receiveWeapon(Weapon w) {
        if(hangar != null)
            return hangar.addWeapon(w);
        else
            return false;
    }
    
    /**
     * @brief Recepción de un botín
     * @param loot Botín a recibir
     */
    public void setLoot(Loot loot){
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Se calcula el parámetro ajustado (adjust) a la lista de armas y 
     *        potenciadores de escudo de la estación y se almacena el resultado 
     *        en el atributo correspondiente.
     * @param d Instancia de la clase Damage
     */
    public void setPendingDamage(Damage d) {
        pendingDamage = d.adjust(weapons, shieldBoosters);
        cleanPendingDamage();
    }
    
    /**
     * @brief Devuelve True si la estación espacial está en un estado válido. 
     *        Eso implica que o bien no se tiene ningún daño pendiente o que 
     *        este no tiene efecto
     * @return True si la estación espacial está en un estado válido
     *         y False en otro caso
     */
    public boolean validState() {
        
        if(pendingDamage == null)
            return true;
        
        return pendingDamage.hasNoEffect();
    }
    
    /**
     * @brief Función para representar una instancia de la clase SpaceStation
     *        en un string
     * @return s String que representa una instancia de la clase SpaceStation
     */
    public String toString() {
        
        String s;
        
        String s_name = "- Nombre de la estacion espacial: " + name + "\n";
        String s_ammoPower = "- Nivel de energia de disparo de la estacion espacial: " + ammoPower + "\n";
        String s_fuelUnits = "- Nivel de combustible de la estacion espacial: " + fuelUnits + "\n";
        String s_shieldPower = "- Nivel de energia de escudo de la estacion espacial: " + shieldPower + "\n";
        String s_nMedals = "- Numero de medallas de la estacion espacial: " + nMedals + "\n";
        
        String s_weapons = "\n- Armas montadas: \n";
        if( weapons == null || weapons.isEmpty() )
            s_weapons += " Ninguna\n";
        else
            for(Weapon w : weapons)
                s_weapons += w.toString();
        
        String s_shieldBoosters = "\n- Potenciadores de escudo montados: \n";
        if( shieldBoosters == null || shieldBoosters.isEmpty() )
            s_shieldBoosters += " Ninguno\n";
        else
            for(ShieldBooster sb : shieldBoosters)
                s_shieldBoosters += sb.toString();
        
        String s_hangar = "\n- Hangar: \n";
        if(hangar == null)
            s_hangar += " Ninguno\n";
        else
            s_hangar += hangar.toString();
        
        String s_pendingDamage = "\n- Daño pendiente: \n";
        if(pendingDamage == null)
            s_pendingDamage += " Ninguno\n";
        else
            s_pendingDamage += pendingDamage.toString() + "\n";
        
        
        s = s_name + s_ammoPower + s_fuelUnits + s_shieldPower + s_nMedals + s_weapons + s_shieldBoosters + s_hangar + s_pendingDamage;
        
        return s;
    }
}