package com.projectdss.item.combatitem.equipablecombatitem;

import java.util.Set;
import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.item.combatitem.EquipableCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class WeaponEquipableCombatItem represents any EquipableCombatItem 
 * that can be equipped as weapon.
 */
public class WeaponEquipableCombatItem extends EquipableCombatItem {
    
    private int baseDamage;

    public WeaponEquipableCombatItem(){}

    public WeaponEquipableCombatItem(String name, Rarity rarity, String description, int maxRunes,
                                     Set<RuneCombatItem> runes, int baseDamage) {
        super(name, rarity, description, maxRunes, runes);
        this.baseDamage = baseDamage;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    @Override
    public void use(CharacterStats characterStats) {
        characterStats.setBaseDamage(characterStats.getBaseDamage() + baseDamage);

        for(RuneCombatItem rune : runes) {
            rune.use(characterStats);
        }
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        characterStats.setBaseDamage(characterStats.getBaseDamage() - baseDamage);

        for(RuneCombatItem rune : runes) {
            rune.disuse(characterStats);
        }
    }

}