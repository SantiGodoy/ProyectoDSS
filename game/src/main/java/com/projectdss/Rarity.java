package com.projectdss;

import java.util.*;

/**
 * @author JoseCorrero
 * 
 * Class Rarity.
 */
public enum Rarity {
    COMMON,
    RARE,
    LEGENDARY,
    OHMYGODNESS;

    @override
    public String toString() {
        switch(this) {
            case COMMON:        return "Common";
            case RARE:          return "Rare";
            case LEGENDARY:     return "Legendary";
            case OHMYGODNESS:   return "Oh, my godness!";
            case default:       return "";
        }
    }
}