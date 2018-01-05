package com.projectdss.item;

import com.projectdss.Item;
import com.projectdss.Rarity;
import com.projectdss.Character;

/**
 * @author JoseCorrero
 * 
 * Class ConsumableItem represents any Item that can be used to recovery from inventory.
 */
public abstract class ConsumableItem extends Item {

    public ConsumableItem(int id, String name, Rarity rarity, String description) {
        super(id, name, rarity, description);
    }

    public abstract void use(Character player);

}