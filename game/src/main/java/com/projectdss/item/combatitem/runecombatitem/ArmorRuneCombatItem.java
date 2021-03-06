package com.projectdss.item.combatitem.runecombatitem;

import com.projectdss.Rarity;
import com.projectdss.item.combatitem.RuneCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class ArmorRuneCombatItem represents any RuneCombatItem that can be added to 
 * an ArmorEquipableCombatItem to enhace it.
 */
public abstract class ArmorRuneCombatItem extends RuneCombatItem {

    public ArmorRuneCombatItem(){}

    public ArmorRuneCombatItem(String name, Rarity rarity, String description) {
        super(name, rarity, description);
    }

    public abstract int getFirmness();

}