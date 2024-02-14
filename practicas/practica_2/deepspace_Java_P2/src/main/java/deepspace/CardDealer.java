/**
 * @file CardDealer.java
 * @author Profesor
 */
package deepspace;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @brief Representación de un crupier. Esta clase de carácter Singleton 
 *        se encarga de crear una serie de mazos con diferentes instancias: 
 *        Supplies, ShieldBoosters Weapons, Hangares y Enemigos, y dispone de 
 *        diversos métodos para la obtención de diferentes cartas
 */
class CardDealer {
    private static final CardDealer instance=new CardDealer();
    
    CardDeck<SuppliesPackage> suppliesPackages;
    CardDeck<ShieldBooster> shieldBoosters;
    CardDeck<Weapon> weapons;
    CardDeck<Hangar> hangars;
    CardDeck<EnemyStarShip> enemies;
    
    /**
     * @brief Constructor sin parámetros
     */
    private CardDealer(){
        suppliesPackages=new CardDeck<>();
        shieldBoosters=new CardDeck<>();
        weapons=new CardDeck<>();
        hangars=new CardDeck<>();
        enemies=new CardDeck<>();

        initCards();
    };
           
    /**
     * @brief Crea una instancia Singleton de la clase
     * @return Instancia de CardDealer
     */
    public static CardDealer getInstance() {
        return instance;
    }

    /**
     * @brief Devuelve una carta del mazo de SuppliesPackage
     * @return Siguiente carta de SuppliesPackage
     */
    public SuppliesPackage nextSuppliesPackage() { 
        return suppliesPackages.next();

    }
    
    /**
     * @brief Devuelve una carta del mazo de Weapon
     * @return Siguiente carta de Weapon
     */
    public Weapon nextWeapon() {
        return weapons.next();          
    }

    /**
     * @brief Devuelve una carta del mazo de ShieldBooster
     * @return Siguiente carta de ShieldBooster
     */
    public ShieldBooster nextShieldBooster() {
        return shieldBoosters.next();
    }
    
    /**
     * @brief Devuelve una carta del mazo de Hangar
     * @return Siguiente carta de Hangar
     */
    public Hangar nextHangar() {
        return hangars.next();
    }

    /**
     * @brief Devuelve una carta del mazo de EnemyStarShip
     * @return Siguiente carta de EnemyStarShip
     */
    public EnemyStarShip nextEnemy() {
        return enemies.next();
    }
    
    /**
     * @brief Inicializa los mazos con diferentes instancias 
     */
    private void initCards() {    
        createSuppliesPackages();
        createWeapons();
        createShieldBoosters();
        createHangars();
        createEnemies();      
    }
    
    /**
     * @brief Inserta cartas en el mazo de SuppliesPackages
     */
    private void createSuppliesPackages() {
        suppliesPackages.add(new SuppliesPackage(1,10,1));
        suppliesPackages.add(new SuppliesPackage(1,10,1));
        suppliesPackages.add(new SuppliesPackage(1,10,1));
        suppliesPackages.add(new SuppliesPackage(2,10,2));
        suppliesPackages.add(new SuppliesPackage(2,10,2));
        suppliesPackages.add(new SuppliesPackage(2,10,2));
        suppliesPackages.add(new SuppliesPackage(2,30,1));
        suppliesPackages.add(new SuppliesPackage(1,30,2));
        suppliesPackages.add(new SuppliesPackage(3,0,1));
        suppliesPackages.add(new SuppliesPackage(1,0,3));
        suppliesPackages.add(new SuppliesPackage(3,50,3));    
        suppliesPackages.add(new SuppliesPackage(40,100,40));
        suppliesPackages.add(new SuppliesPackage(100,100,100));
    }
    
    /**
     * @brief Inserta cartas en el mazo de Weapons
     */
    private void createWeapons() {
       weapons.add(new Weapon("Láser infinito",WeaponType.LASER,100));
       weapons.add(new Weapon("Láser ACME",WeaponType.LASER,1));
       weapons.add(new Weapon("Láser ACME",WeaponType.LASER,1));
       weapons.add(new Weapon("Láser ACME",WeaponType.LASER,1));
       weapons.add(new Weapon("Láser ACME",WeaponType.LASER,1));
       weapons.add(new Weapon("Láser ACME",WeaponType.LASER,1));
       weapons.add(new Weapon("Láser normal",WeaponType.LASER,2));
       weapons.add(new Weapon("Láser normal",WeaponType.LASER,2));
       weapons.add(new Weapon("Láser normal",WeaponType.LASER,2));
       weapons.add(new Weapon("Láser Mejorado",WeaponType.LASER,4));
       weapons.add(new Weapon("Láser Mejorado",WeaponType.LASER,4));
       
       weapons.add(new Weapon("Misiles del apocalipsis",WeaponType.MISSILE,100));
       weapons.add(new Weapon("Misil ACME",WeaponType.MISSILE,1));
       weapons.add(new Weapon("Misil ACME",WeaponType.MISSILE,1));
       weapons.add(new Weapon("Misil ACME",WeaponType.MISSILE,1));
       weapons.add(new Weapon("Misil normal",WeaponType.MISSILE,2));
       weapons.add(new Weapon("Misil normal",WeaponType.MISSILE,2));
       weapons.add(new Weapon("Misil mejorado",WeaponType.MISSILE,2));       
       
       weapons.add(new Weapon("Cañón definitivo",WeaponType.PLASMA,100)); 
       weapons.add(new Weapon("Cañón ACME",WeaponType.PLASMA,1)); 
       weapons.add(new Weapon("Cañón ACME",WeaponType.PLASMA,1)); 
       weapons.add(new Weapon("Cañón ACME",WeaponType.PLASMA,1)); 
       weapons.add(new Weapon("Cañón mejorado",WeaponType.PLASMA,2));       
       
    }
    
    /**
     * @brief Inserta cartas en el mazo de ShieldBoosters
     */
    private void createShieldBoosters() {
       shieldBoosters.add(new ShieldBooster("El escudo infinito",2.0f,100));
       shieldBoosters.add(new ShieldBooster("El escudo definitivo",10.0f,2));
       shieldBoosters.add(new ShieldBooster("Escudo ACME",1.5f,2));
       shieldBoosters.add(new ShieldBooster("Escudo ACME",1.5f,2));
       shieldBoosters.add(new ShieldBooster("Escudo ACME",1.5f,2));
       shieldBoosters.add(new ShieldBooster("Escudo ACME",1.5f,2));
       shieldBoosters.add(new ShieldBooster("Escudo ACME",1.5f,2));
       shieldBoosters.add(new ShieldBooster("Escudo ACME",1.5f,2));
       shieldBoosters.add(new ShieldBooster("Escudo ACME",1.5f,2));
       shieldBoosters.add(new ShieldBooster("Escudo normal",3.0f,2));
       shieldBoosters.add(new ShieldBooster("Escudo normal",4.0f,2));
    }
    
    /**
     * @brief Inserta cartas en el mazo de Hangars
     */
    private void createHangars() {
        hangars.add(new Hangar(4));
        hangars.add(new Hangar(4));
        hangars.add(new Hangar(3));
        hangars.add(new Hangar(3));
        hangars.add(new Hangar(3));    
        hangars.add(new Hangar(2));
        hangars.add(new Hangar(2));
        hangars.add(new Hangar(1));
        hangars.add(new Hangar(1));
    }
    
    /**
     * @brief Inserta cartas en el mazo de EnemyStarShips
     */
    private void createEnemies() {
        Loot regularLoot0=new Loot(1,2,1,1,1);
        Loot regularLoot1=new Loot(1,1,2,1,1);
        Loot badLoot=new Loot(1,1,1,0,1);
        Loot goodLoot=new Loot(2,2,2,1,2);
        
        Damage regularDamage0=new Damage(2,1); 
        Damage regularDamage1=new Damage(1,1); 
        Damage lowDamage0=new Damage(1,1);
        Damage lowDamage1=new Damage(0,1);
        Damage lowDamage2=new Damage(1,0);
        

        
        Damage regularSpecificDamage0;
        regularSpecificDamage0=new Damage(new ArrayList<>(Arrays.asList(WeaponType.LASER,                                                                      
                                                                        WeaponType.MISSILE,
                                                                        WeaponType.PLASMA)),1);        
        
        Damage hardSpecificDamage0;
        hardSpecificDamage0=new Damage(new ArrayList<>(Arrays.asList(WeaponType.LASER,
                                                                        WeaponType.LASER,
                                                                        WeaponType.LASER,
                                                                        WeaponType.MISSILE,
                                                                        WeaponType.MISSILE,
                                                                        WeaponType.MISSILE,
                                                                        WeaponType.PLASMA,
                                                                        WeaponType.PLASMA,
                                                                        WeaponType.PLASMA)),2);    
        
        Damage softSpecificDamage0;
        softSpecificDamage0=new Damage(new ArrayList<>(Arrays.asList(WeaponType.LASER)),1);  
        Damage softSpecificDamage1;
        softSpecificDamage1=new Damage(new ArrayList<>(Arrays.asList(WeaponType.MISSILE)),1);  
        Damage softSpecificDamage2;
        softSpecificDamage2=new Damage(new ArrayList<>(Arrays.asList(WeaponType.PLASMA)),1);  
        Damage mediumSpecificDamage0;
        mediumSpecificDamage0=new Damage(new ArrayList<>(Arrays.asList(WeaponType.LASER,
                                                                        WeaponType.MISSILE)),2);  
        
        enemies.add(new EnemyStarShip("Enemigo fácil -1",0,0,regularLoot0,lowDamage0));
        enemies.add(new EnemyStarShip("Enemigo fácil -1",0,10,badLoot,lowDamage0));
        enemies.add(new EnemyStarShip("Enemigo fácil -1",10,0,badLoot,lowDamage0));
        enemies.add(new EnemyStarShip("Enemigo fácil 0",10,10,badLoot,lowDamage0));
        enemies.add(new EnemyStarShip("Enemigo fácil 0",10,10,badLoot,lowDamage0));
        enemies.add(new EnemyStarShip("Enemigo fácil 0",10,10,badLoot,lowDamage0));
        enemies.add(new EnemyStarShip("Enemigo fácil 1",10,20,badLoot,lowDamage1));
        enemies.add(new EnemyStarShip("Enemigo fácil 1",10,20,badLoot,lowDamage1));
        enemies.add(new EnemyStarShip("Enemigo fácil 1",10,20,badLoot,lowDamage1));
        enemies.add(new EnemyStarShip("Enemigo fácil 2",20,10,badLoot,lowDamage2));
        enemies.add(new EnemyStarShip("Enemigo fácil 2",20,10,badLoot,lowDamage2));
        enemies.add(new EnemyStarShip("Enemigo fácil 2",20,20,badLoot,lowDamage2));        
        enemies.add(new EnemyStarShip("Enemigo fácil 3",50,50,badLoot,softSpecificDamage0)); 
        enemies.add(new EnemyStarShip("Enemigo fácil 4",50,50,badLoot,softSpecificDamage1)); 
        enemies.add(new EnemyStarShip("Enemigo fácil 5",30,30,badLoot,softSpecificDamage2));         
        
        enemies.add(new EnemyStarShip("Enemigo normal 0",100,100,regularLoot0,regularDamage0));
        enemies.add(new EnemyStarShip("Enemigo normal 1",150,70,regularLoot1,regularDamage1));   
        enemies.add(new EnemyStarShip("Enemigo normal 2",100,100,regularLoot0,mediumSpecificDamage0));
        enemies.add(new EnemyStarShip("Enemigo normal 3",150,90,regularLoot1,mediumSpecificDamage0));  
        enemies.add(new EnemyStarShip("Enemigo normal 3",150,70,regularLoot0,regularSpecificDamage0));   
        enemies.add(new EnemyStarShip("Enemigo normal 3",150,70,regularLoot0,regularSpecificDamage0));
        enemies.add(new EnemyStarShip("Enemigo normal 3",150,70,regularLoot0,regularSpecificDamage0));        
          
        enemies.add(new EnemyStarShip("Enemigo difícil 0",200,100,goodLoot,hardSpecificDamage0));          
        enemies.add(new EnemyStarShip("Enemigo difícil 1",100,200,goodLoot,hardSpecificDamage0));   
        
        enemies.add(new EnemyStarShip("Enemigo imposible",500,500,goodLoot,hardSpecificDamage0));              
    }
}