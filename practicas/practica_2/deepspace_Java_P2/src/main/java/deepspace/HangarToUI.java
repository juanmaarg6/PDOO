/**
 * @file HangarToUI.java
 * @author Profesor
 */
package deepspace;

import java.util.ArrayList;

/**
 * @brief Representación ToUI de Hangar
 */
public class HangarToUI {
    private int maxElements;
    private ArrayList<WeaponToUI> weapons;
    private ArrayList<ShieldToUI> shieldBoosters;    
    
    /**
     * @brief Constructor con un parámetro
     * @param h Instancia de la clase Hangar
     */
    HangarToUI(Hangar h) {
        weapons=new ArrayList<>();
        shieldBoosters=new ArrayList<>(); 
    
        maxElements=h.getMaxElements();
        
        for (Weapon w:h.getWeapons()) {
            weapons.add(w.getUIversion());
        }
        
        for(ShieldBooster s:h.getShieldBoosters()) {
            shieldBoosters.add(s.getUIversion());
        }
    }
    
    /**
     * @brief Consultor de la capacidad máxima de elementos dentro del hangar
     * @return maxElements
     */
    public int getMaxElements() {
        return maxElements;
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
}