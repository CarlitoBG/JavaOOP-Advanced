package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;
    private static final String WRONG_DURABILITY_MESSAGE = "Wrong Durability";

    private Weapon weapon;
    private Target target;

    @Before
    public void initializeTestObjects(){
        this.weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void weaponAttacksLosesDurability(){
        //Act
        this.weapon.attack(this.target);

        //Assert
        Assert.assertEquals(WRONG_DURABILITY_MESSAGE, EXPECTED_DURABILITY, this.weapon.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class) //Assert
    public void brokenWeaponCantAttack(){
        //Act
        this.weapon.attack(this.target);
        this.weapon.attack(this.target);
    }
}