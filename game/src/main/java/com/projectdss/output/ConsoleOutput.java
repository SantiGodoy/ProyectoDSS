package com.projectdss.output;

import com.projectdss.event.InventoryEvent;
import com.projectdss.inventory.Inventory;
import com.projectdss.character.MainCharacter;
import com.projectdss.item.CombatItem;
import com.projectdss.item.ConsumableItem;
import com.projectdss.item.combatitem.EquipableCombatItem;
import com.projectdss.item.combatitem.RuneCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.ArmorEquipableCombatItem;
import com.projectdss.item.combatitem.equipablecombatitem.WeaponEquipableCombatItem;
import com.projectdss.map.Minizone;
import com.projectdss.map.World;
import com.projectdss.character.EnemyCharacter;
import com.projectdss.Character;
import com.projectdss.Event;
import com.projectdss.Item;
import com.projectdss.Ability;
import com.projectdss.map.Zone;
import java.util.Set;

/**
 * ConsoleOutput.java
 * 
 * @author Santiago Godoy Poce
 */
public abstract class ConsoleOutput implements OutputHandler {
    
    @Override
    public void showInventory(Inventory inventory) {
        int counter = 1;
        for(Item i: inventory) {
            System.out.println(counter + ". " + i.getName() + " (" + i.getRarity() + "): " + i.getDescription());
            if(i instanceof WeaponEquipableCombatItem) {
                WeaponEquipableCombatItem weapon = (WeaponEquipableCombatItem) i;
                System.out.println(weapon.getBaseDamage() + " damage.\n" +
                                   weapon.getRunes().size() + "/" + weapon.getMaxRunes() + " runes.");
            } else if(i instanceof ArmorEquipableCombatItem) {
                ArmorEquipableCombatItem armor = (ArmorEquipableCombatItem) i;
                System.out.println(armor.getBaseDefense() + " defense.\n" +
                                   armor.getRunes().size() + "/" + armor.getMaxRunes() + " runes.");
            }
            ++counter;
        }
        System.out.println();
    }

    @Override
    public void showAbilities(Set<Ability> abilities) {
        int counter = 1;
        for(Ability a: abilities) {
            System.out.println(counter++ + ". " + a.getName() + " (" + a.getDescription() + ")" + 
                " [" + a.getNecessaryMana() + "]");
        }
        System.out.println();
    }

    @Override
    public int showEvents(Event[] events) {
        int counter = 0;
        for(int i = 0; i < events.length; ++i) 
            System.out.println(++counter + ". " + events[i].getDescription());
        System.out.println("0. Options");
        System.out.println();
        return counter;
    }

    @Override
    public int showItemOptions(ConsumableItem item) {
        System.out.println(item.getName());
        System.out.println("1. Use" +
        "\n2. Remove" +
        "\n0. Return");
        System.out.println();
        return 3;
    }

    @Override
    public int showItemOptions(EquipableCombatItem item) {
        System.out.println(item.getName());
        if(item.isEquipped())
            System.out.println("1. Take off");
        else
            System.out.println("1. Equip");
        System.out.println("2. Remove item" +
        "\n0. Return");
        System.out.println();
        return 3;
    }

    @Override
    public int showItemOptions(RuneCombatItem item) {
        System.out.println(item.getName());
        System.out.println("1. Merge\n" +
                           "2. Remove item\n" +
                           "0. Return");
        System.out.println();
        return 3;
    }

    @Override
    public void showGlobalSettings() {
        System.out.println("Settings" + 
        "\n\t1. White/black screen" + 
        "\n\t2. Colored screen" + 
        "\n\t0. Return");
        System.out.println();
    }

    @Override
    public int showAdjacentMinizones(Minizone minizone) {
        int counter = 0;
        System.out.println("Where do you want to go?");
        for(Minizone mz : minizone.getAdjacentMinizones()) {
            System.out.println(++counter + ". " + mz.getName() + "\t\t" + mz.getDescription());
        }
        System.out.println("0. Return");
        System.out.println();
        return counter;
    }

    @Override
    public int showAdjacentZones(Zone zone) {
        int counter = 0;
        System.out.println("Where do you want to go?");
        for(Zone z : zone.getAdjacentZones()) {
            System.out.println(++counter + ". " + z.getName() + "\t\t" + z.getDescription());
        }
        System.out.println("0. Return");
        System.out.println();
        return counter;
    }

    @Override
    public void showStartBattleMessage(EnemyCharacter enemy) {
        System.out.println("The battle against '" + enemy.getName() +  "' has begun!\n" +
                            enemy.getInitMessage());
        System.out.println();
    }

    @Override
    public void showCombatOptions() {
        System.out.println("What do you want to do?" +
                         "\n1. Attack\t\t2. Ability" + 
                         "\n3. Run away");
        System.out.println();
    }

    @Override
    public void showTargetOptions(MainCharacter player, EnemyCharacter enemy) {
        System.out.println("Select the target:" + 
                         "\n1. " + player.getName() +
                         "\n2. " + enemy.getName() +
                         "\n0. Return");
        System.out.println();
    }

    @Override
    public void showUseAbility(Character player1, Character player2, 
                               Ability ability, int abilityPower) {
            String message = player1.getName() + " used the ability '" + ability.getName() + "' on ";
            
            if(player1.equals(player2))
                if(player1.getGender().equals("Man"))
                    message += "himself, ";
                else
                    message += "herself, ";
            else
                message += player2.getName() + ", ";

            if(abilityPower > 0)
                message += "dealing " + abilityPower + " damage!";
            else if(abilityPower < 0)
                    message += "restoring " + (abilityPower * -1) + " health!";
            else
                message += "but it had no effect!";

            System.out.println(message);
            System.out.println();
        }

    @Override
    public void showRunAway() {
        System.out.println("Wow! You got out of that battle!");
        System.out.println();
    }

    @Override
    public void showUseAttack(Character player1, Character player2, int appliedDamage) {
        String message = player1.getName() + " attacked to ";
            
        if(player1.equals(player2))
            if(player1.getGender().equals("Man"))
                message += "himself, ";
            else
                message += "herself, ";
        else
            message += player2.getName() + ", ";

        if(appliedDamage <= 0)
            message += "but it did not deal damage!";
        else
            message += "dealing " + appliedDamage + " damage!";

        System.out.println(message);
        System.out.println();
    }
    
    @Override
    public void showXPGain(int xpDrop, int levelUp) {
        System.out.print("You earned " + xpDrop + " experience points ");
        if(levelUp == 0)
            System.out.println("but you didn't reach the next level :(");
        else
            System.out.println("and you have got " + levelUp + " levels");
        System.out.println();
    }
    
    @Override
    public void showLevelUpOptions(MainCharacter player) {
        System.out.println("Select the stats you want to level:\t\tLevel " + player.getLevel() + " -> " + (player.getLevel() + 1) +
                           "\n1. Maximum health\t(" + player.getCharacterStats().getMaxHealth() + ")" +
                           "\n2. Maximum mana\t\t(" + player.getCharacterStats().getMaxMana() + ")" +
                           "\n3. Strength\t\t(" + player.getCharacterStats().getStrength() + ")" +
                           "\n4. Magical power\t(" + player.getCharacterStats().getMagicalPower() + ")" +
                           "\n5. Resistance\t\t(" + player.getCharacterStats().getResistance() + ")" +
                           "\n6. Agility\t\t(" + player.getCharacterStats().getAgility() + ")");
        System.out.println();
    }
    
    @Override
    public void showItemGain(Item item) {
        System.out.println("You picked up a " + item.getName() + " (" + item.getRarity() + ")");
        System.out.println();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void showWorldInformation(MainCharacter player, World world) {
        System.out.println("Zone : " + world.getZones()[player.getIdZone()].getName());
        if(player.isIn())
            System.out.println("Minizone : " + world.getZones()[player.getIdZone()].
                                                     getMinizones()[player.getIdMinizone()].getName());
        System.out.println();
    }

    @Override
    public void showSaveLoadExitOptions() {
        System.out.println("1. Load\n" + 
                           "2. Save\n" +
                           "3. Save and exit\n" +
                           "4. Exit\n" +
                           "0. Return");
        System.out.println();
    }
}