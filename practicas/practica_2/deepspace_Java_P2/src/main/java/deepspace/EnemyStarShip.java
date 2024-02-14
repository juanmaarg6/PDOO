/**
 * @file EnemyStarShip.java
 * @author Juan Manuel Rodríguez Gómez
 */
package deepspace;

/**
 * @brief Representa la nave enemiga
 */
class EnemyStarShip {
    
    // Atributos de instancia
    private float ammoPower;
    private String name;
    private float shieldPower;
    
    // Atributos de relación
    private Loot loot;
    private Damage damage;
    
    /**
     * @brief Constructor con parámetros
     * @param n Nombre de la nave enemiga
     * @param a Nivel de energía de disparo de la nave enemiga
     * @param s Nivel de energía de los escudos de la nave enemiga
     * @param l Instancia de la clase Loot de la nave enemiga
     * @param d Instancia de la clase Damage de la nave enemiga
     */
    EnemyStarShip(String n, float a, float s, Loot l, Damage d) {
        ammoPower = a;
        name = n;
        shieldPower = s;
        loot = l;
        damage = new Damage(d);
    }
    
    /**
     * @brief Constructor de copia
     * @param e Otra instancia de la clase EnemyStarShip
     */
    EnemyStarShip(EnemyStarShip e) {
        ammoPower = e.ammoPower;
        name = e.name;
        shieldPower = e.shieldPower;
        loot = e.loot;
        damage = new Damage(e.damage);
    }
    
    /**
     * @brief Construye una nueva instancia EnemyToUI a partir de la propia 
     *        instancia que recibe el mensaje y lo devuelve.
     *        Estos objetos constituyen una capa que permite conectar el 
     *        modelo con la interfaz de usuario (EnemyStarShip) manteniendo 
     *        cierto nivel de aislamiento entre ambos niveles
     * @return Instancia de la clase EnemyToUI
     */
    EnemyToUI getUIversion() {
        return new EnemyToUI(this);
    }
    
    /**
     * @brief Devuelve el nivel de energía de disparo de la nave enemiga
     * @return ammoPower
     */
    public float fire() {
        return ammoPower;
    }
    
    /**
     * @brief Consultor del nivel de energía de disparo de la nave enemiga
     * @return ammoPower
     */
    public float getAmmoPower() {
        return ammoPower;
    }
    
    /**
     * @brief Consultor del daño que produce la nave enemiga
     * @return damage
     */
    public Damage getDamage() {
        return damage;
    }
    
    /**
     * @brief Consultor del loot de la nave enemiga
     * @return loot
     */
    public Loot getLoot() {
        return loot;
    }
    
    /**
     * @brief Consultor del nombre de la nave enemiga
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @brief Consultor del nivel de energía de escudo de la nave enemiga
     * @return shieldPower
     */
    public float getShieldPower() {
        return shieldPower;
    }
    
    /**
     * @brief Devuelve el nivel de energía de escudo de la nave enemiga
     * @return shieldPower
     */
    public float getProtection() {
        return shieldPower;
    }
    
    /**
     * @brief Devuelve el resultado que se produce al recibir un disparo de 
     *        una determinada potencia (pasada como parámetro). Si el nivel de 
     *        la protección de los escudos es menor que la intensidad del 
     *        disparo, la nave enemiga no resiste (DONOTRESIST). En caso
     *        contrario resiste el disparo (RESIST). Se devuelve el resultado 
     *        producido por el disparo recibido
     * @param shot Disparo de una determinada potencia
     * @return DONOTRESIST si el nivel de la protección de los escudos es 
     *         menor que la intensidad del disparo y RESIST en caso contrario
     */
    public ShotResult receiveShot(float shot) {
        if(shot > shieldPower)
            return ShotResult.DONOTRESIST;
        else
            return ShotResult.RESIST;
    }
    
    /**
     * @brief Función para representar una instancia de la clase EnemyStarShip
     *        en un string
     * @return s String que representa una instancia de la clase EnemyStarShip
     */
    public String toString() {
        
        String s;
        
        String s_name = "- Nombre de la nave enemiga: " + name + "\n";
        String s_ammoPower = "- Nivel de energia de disparo de la nave enemiga: " + ammoPower + " ";
        String s_shieldPower = "- Nivel de energia de escudo de la nave enemiga: " + shieldPower + "\n";
        
        String s_loot = "- Loot de la nave enemiga: \n";
        if(loot == null)
            s_loot += "Ninguno\n";
        else 
            s_loot += loot.toString();
        
        String s_damage = "\n- Daño que produce la nave enemiga: \n";
        if(damage == null)
            s_damage += "Ninguno \n";
        else
            s_damage += damage.toString() + "\n";
        
        s = s_name + s_ammoPower + s_shieldPower + s_loot + s_damage;
        
        return s;
    }
}