/**
 * @file SpaceStationToUI.java
 * @author Profesor
 */
package deepspace;

import java.util.ArrayList;

/**
 * @brief Representación ToUI de SpaceStation
 */
public class SpaceStationToUI {
    private String name;
    private int nMedals;
    
    private float ammoPower=1.0f;
    private float fuelUnits=1.0f;
    private float shieldPower=1.0f;
    
    private ArrayList<WeaponToUI> weapons;
    private ArrayList<ShieldToUI> shieldBoosters;
    private HangarToUI hangar;   
    private DamageToUI pendingDamage;
    
    /**
     * @brief Constructor con un parámetro
     * @param station Instancia de la clase SpaceStation
     */
    SpaceStationToUI(SpaceStation station) {
        weapons=new ArrayList<>();
        shieldBoosters=new ArrayList<>(); 
        
        name=station.getName();
        nMedals=station.getNMedals();
        
        ammoPower=station.getAmmoPower();
        fuelUnits=station.getFuelUnits();
        shieldPower=station.getShieldPower();
        
        for (Weapon w:station.getWeapons()) {
            weapons.add(w.getUIversion());
        }
        
        for(ShieldBooster s:station.getShieldBoosters()) {
            shieldBoosters.add(s.getUIversion());
        }
        
        Hangar h=station.getHangar();
        if (h!=null) {
            hangar=h.getUIversion();
        }
        else {
            hangar=null;
        }
            
        Damage d = station.getPendingDamage();
        if (d != null) {
          pendingDamage = d.getUIversion();
        } else {
          pendingDamage = null;
        }
    }

    /**
     * @brief Consultor del nombre
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Consultor del número de medallas
     * @return nMedals
     */
    public int getnMedals() {
        return nMedals;
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
     * @brief Consultor del nivel de energía de los escudos
     * @return shieldPower
     */
    public float getShieldPower() {
        return shieldPower;
    }

    /**
     * @brief Consultor de la colección de armas concretas disponibles 
     *        dentro del hangar
     * @return weapons Array con las armas del hangar
     */
    public ArrayList<WeaponToUI> getWeapons() {
        return weapons;
    }

    /**
     * @brief Consultor de los potenciadores de escudo disponibles dentro del
     *        hangar
     * @return shieldBoosters Array con los potenciadores de escudo del hangar
     */
    public ArrayList<ShieldToUI> getShieldBoosters() {
        return shieldBoosters;
    }

    /**
     * @brief Consultor del hangar
     * @return hangar
     */
    public HangarToUI getHangar() {
        return hangar;
    }
    
    /**
     * @brief Consultor del daño pendiente
     * @return pendingDamage
     */
    public DamageToUI getPendingDamage() {
        return pendingDamage;
    }
}