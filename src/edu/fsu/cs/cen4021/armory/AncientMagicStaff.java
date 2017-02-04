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
            ObjectInputStream ancientobj = new ObjectInputStream(new FileInputStream("conf/ancientstaff.obj"));

            try {
                double temp;
                inputlist = (List<Integer>) ancientobj.readObject();

                for(int i = 0; i < inputlist.size(); i++){
                    //System.out.println("Before: " + inputlist.get(i));
                    temp = (inputlist.get(i)).doubleValue();
                    temp = Math.pow(temp, 2.0);

                    inputlist.set(i, new Integer((int) temp));
                    System.out.println("Num " + i + ":" + + inputlist.get(i));
                }

                inputlist.remove(2);
                inputlist.remove(5);

                for(Integer num : inputlist){
                    System.out.println(num);
                }

                System.out.println("\n");
                Collections.reverse(inputlist);

                for(Integer num : inputlist){
                    System.out.println(num);
                }

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
