package com.projectdss.item.combatitem.runecombatitem.armorrunecombatitem;

import com.projectdss.Rarity;
import com.projectdss.CharacterStats;
import com.projectdss.item.combatitem.runecombatitem.ArmorRuneCombatItem;

/**
 * @author JoseCorrero
 * 
 * Class ArmorRuneCombatItemDecorator represents any ArmorRuneCombatItem that 
 * can be added to a ArmorEquipableCombatItem to enhance its base defense and something else.
 */
public abstract class ArmorRuneCombatItemDecorator extends ArmorRuneCombatItem {

    protected ArmorRuneCombatItem rune;

    public ArmorRuneCombatItemDecorator(){}

    public ArmorRuneCombatItemDecorator(String name, Rarity rarity, String description, 
                                         ArmorRuneCombatItem rune) {
        super(name, rarity, description);
        this.rune = rune;
    }

    @Override
    public int getFirmness() {
        return rune.getFirmness();
    }

    public ArmorRuneCombatItem getRune() {
        return rune;
    }

    public void setRune(ArmorRuneCombatItem rune) {
        this.rune = rune;
    }

    @Override
    public void use(CharacterStats characterStats) {
        rune.use(characterStats);
    }

    @Override
    public void disuse(CharacterStats characterStats) {
        rune.disuse(characterStats);
    }

}