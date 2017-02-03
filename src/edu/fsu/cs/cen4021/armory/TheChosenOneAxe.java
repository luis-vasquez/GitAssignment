package edu.fsu.cs.cen4021.armory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by luis on 2/2/17.
 */
class TheChosenOneAxe extends BasicWeapon implements Weapon {
    TheChosenOneAxe(int DAMAGE) {
        super ( DAMAGE );
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        if (armor > 0 && armor < 20) {
            armor = 0;
        }

        int damage = DAMAGE - armor;

        if (damage < 0) {
            return 0;
        }

        return damage;
    }

    public static int getDamage() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("conf/thechosenone.txt"));
            String newstr;
            String oldstr = null;
            boolean first = true;
            int strcount = 0;

            try {
                while ((newstr = in.readLine()) != null) {
                    if (first) {
                        newstr = oldstr;
                        first = false;
                    }

                    if (newstr.equals(oldstr)) {
                        strcount++;
                        oldstr = newstr;
                    } else {
                        return strcount;
                    }
                }
            } catch (IOException ex) {
                System.out.println("Error with reading the file...");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not open the file...");
        }

        return 0;
    }
}
