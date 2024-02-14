/**
 * @file DamageToUI.java
 * @author Profesor
 */
package deepspace;

import java.util.ArrayList;

/**
 * @brief Representación ToUI de Damage
 */
public class DamageToUI {
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    private int nShields;

    /**
     * @brief Constructor con un parámetro
     * @param d Instancia de la clase Damage
     */
    DamageToUI(Damage d) {
        nWeapons=d.getNWeapons();
        nShields=d.getNShields();
        ArrayList<WeaponType> tmp=d.getWeapons();
        if (tmp!=null) {
            weapons=new ArrayList<WeaponType>(tmp);
        }
        else
            weapons=null;
    }
    
    /**
     * @brief Consultor del número de armas a eliminar
     * @return Numero de Weapons
     */
    public int getNWeapons() {
        return nWeapons;
    }
    
    /**
     * @breif Consultor de la colección de armas concretas a eliminar
     * @return ArrayList weapons
     */
    public ArrayList<WeaponType> getWeapons() {
        return weapons;
    }

    /**
     * @brief Consultor del número de potenciadores de escudo a eliminar
     * @return nShields
     */
    public int getNShields() {
        return nShields;
    }
    
    /**
     * @brief Devuelve la información de la colección de armas concretas 
     *        a eliminar
     * @return String con la información de la colección de armas concretas 
     *         a eliminar
     */
    public String getWeaponInfo() {
      String out = "";
      
      if (nWeapons == -1) {
          out += weapons.toString();
      } else {
          out += nWeapons;
      }
      return out;
    }
}