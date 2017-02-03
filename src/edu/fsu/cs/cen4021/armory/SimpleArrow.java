package edu.fsu.cs.cen4021.armory;

/**
 * Created by luis on 2/2/17.
 */
class SimpleArrow extends BasicWeapon implements Weapon {

    SimpleArrow() { super(70); }

    @Override
    public int hit() { return DAMAGE; }

    @Override
    public int hit(int armor) {
        armor-=5;

        if (armor < 0) {
            armor = 0;
        }

        int damage = DAMAGE - armor;

        if (damage < 0) {
            return 0;
        }

        return damage;
    }
}
