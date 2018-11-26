package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class DummyTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int ATTACK_POINTS = 5;
    private static final int EXPECTED_DUMMY_HEALTH = 5;
    private static final int EXPECTED_HERO_XP_WITH_DEAD_DUMMY = 10;
    private static final int EXPECTED_HERO_XP_WITH_ALIVE_DUMMY = 0;
    private static final int ALIVE_DUMMY_HEALTH_AFTER_ATTACK = 11;
    private static final String HERO_NAME = "Pesho";
    private static final String DEAD_DUMMY_GIVES_CORRECT_EXPERIENCE = "Dead dummy does not give correct experience";
    private static final String ALIVE_DUMMY_GIVES_INCORRECT_RESULT = "Alive dummy gives experience, when it shouldn't";

    private Weapon weapon;
    private Target target;
    private Hero hero;

    @Before
    public void initializeTestObjects() {
        this.weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        this.hero = new Hero(HERO_NAME, this.weapon);
    }

    @Test
    public void attackedTargetLosesHealth(){
        this.target.takeAttack(ATTACK_POINTS);

        Assert.assertEquals(EXPECTED_DUMMY_HEALTH, this.target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadTargetThrowsExceptionIfAttacked(){

        this.weapon.attack(this.target);
        this.weapon.attack(this.target);
    }

    @Test
    public void deadDummyCanGiveXP(){

        this.hero.attack(this.target);

        Assert.assertEquals(DEAD_DUMMY_GIVES_CORRECT_EXPERIENCE, EXPECTED_HERO_XP_WITH_DEAD_DUMMY, this.hero.getExperience());
    }

    @Test
    public void aliveDummyCantGiveXP(){
        this.target = new Dummy(ALIVE_DUMMY_HEALTH_AFTER_ATTACK, DUMMY_XP);

        this.hero.attack(this.target);

        Assert.assertEquals(ALIVE_DUMMY_GIVES_INCORRECT_RESULT, EXPECTED_HERO_XP_WITH_ALIVE_DUMMY, this.hero.getExperience());
    }
}