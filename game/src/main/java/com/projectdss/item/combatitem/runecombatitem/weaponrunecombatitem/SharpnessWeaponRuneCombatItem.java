package com.projectdss.item.combatitem.runecombatitem.weaponrunecombatitem;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.runecombatitem.WeaponRuneCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class SharpnessWeaponRuneCombatItem represents any WeaponRuneCombatItem that 
 * can be added to a WeaponEquipableCombatItem to enhance its base damage.
 */
public class SharpnessWeaponRuneCombatItem extends WeaponRuneCombatItem {

    private int sharpness;

    public SharpnessWeaponRuneCombatItem(){}

    public SharpnessWeaponRuneCombatItem(String name, Rarity rarity, String description, 
                                         int sharpness) {
        super(name, rarity, description);
        this.sharpness = sharpness;
    }

    @Override
    public int getSharpness() {
        return sharpness;
    }

    public void setSharpness(int sharpness) {
        this.sharpness = sharpness;
    }

    @Override
    public void use(CharacterStats characterStats) {
        characterStats.setBaseDamage(characterStats.getBaseDamage() + sharpness);
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        characterStats.setBaseDamage(characterStats.getBaseDamage() - sharpness);
    }

}