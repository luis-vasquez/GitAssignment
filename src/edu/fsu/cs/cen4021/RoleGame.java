package edu.fsu.cs.cen4021;

import edu.fsu.cs.cen4021.armory.Weapon;
import edu.fsu.cs.cen4021.armory.WeaponFactory;

/**
 * @author Javier
 */
public class RoleGame {

    public static void main(String[] args) {
        Weapon sword = WeaponFactory.getWeapon("sword");
        System.out.println("Sword has " + sword.hit() + " of damage.");
        int armor = 20;
        System.out.println("Swords was able to do " + sword.hit(armor) + " of damage due to an armor with " + armor + " points.");

        //TODO: Add the remaining weapons here
        Weapon simplearrow = WeaponFactory.getWeapon("simplearrow");
        System.out.println("SimpleArrow has " + simplearrow.hit() + " of damage.");
        armor = 50;
        System.out.println("SimpleArrow was able to do " + simplearrow.hit(armor) + " of damage due to an armor with " + armor + " points.");

        Weapon simpleaxe = WeaponFactory.getWeapon("simpleaxe");
        System.out.println("SimpleAxe has " + simpleaxe.hit() + " of damage.");
        armor = 14;
        System.out.println("SimpleAxe was able to do " + simpleaxe.hit(armor) + " of damage due to an armor with " + armor + " points.");

        Weapon simplemagicstaff = WeaponFactory.getWeapon("simplemagicstaff");
        System.out.println("SimpleMagicStaff has " + simplemagicstaff.hit() + " of damage.");
        armor = 40;
        System.out.println("SimpleMagicStaff was able to do " + simplemagicstaff.hit(armor) + " of damage due to an armor with " + armor + " points.");

        Weapon thechosenoneaxe = WeaponFactory.getWeapon("thechosenoneaxe");
        System.out.println("TheChosenOneAxe has " + thechosenoneaxe.hit() + " of damage.");
        armor = 14;
        System.out.println("TheChosenOneAxe was able to do " + thechosenoneaxe.hit(armor) + " of damage due to an armor with " + armor + " points.");

        Weapon ancientmagicstaff = WeaponFactory.getWeapon("ancientmagicstaff");
        System.out.println("AncientMagicStaff has " + ancientmagicstaff.hit() + " of damage.");
        armor = 100;
        System.out.println("AncientMagicStaff was able to do " + ancientmagicstaff.hit(armor) + " of damage due to an armor with " + armor + " points.");

    }
}
