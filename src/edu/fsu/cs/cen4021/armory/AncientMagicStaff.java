package edu.fsu.cs.cen4021.armory;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;

/**
 * Created by luis on 2/2/17.
 */
class AncientMagicStaff extends BasicWeapon implements Weapon {
    AncientMagicStaff(int DAMAGE) {
        super ( DAMAGE );
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        armor -= (armor*.25);

        if(armor < 0){
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
            List<Integer> inputlist;
            ObjectInputStream ancientobj = new ObjectInputStream(new FileInputStream("config/ancientstaff.obj"));

            try {
                double temp;
                inputlist = (List<Integer>) ancientobj.readObject();

                for(int i = 0; i < inputlist.size(); i++){
                    temp = (inputlist.get(i)).doubleValue();
                    temp = Math.pow(temp, 2.0);

                    inputlist.set(i, new Integer((int) temp));
                }

                inputlist.remove(2);
                inputlist.remove(5);

                Collections.reverse(inputlist);

                return inputlist.get(1) + inputlist.get(3) + inputlist.get(7);
            }

            catch (ClassNotFoundException ex){
                System.out.println("Could not create object...");
            }
        }


        catch (IOException ex){
            System.out.println("Could not open the file...");
        }

        return 0;
    }
}
