package rpg.models.participants;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class WarriorTest {

    private static final int HERO_HEALTH_MULTIPLIER = 10;
    private static final int LEVEL_UP_MULTIPLIER = 2;

    private Warrior warrior;

    @Before
    public void setUp() {
        this.warrior = new Warrior();
    }

    @Test
    public void testReceiveRewardMethodShouldAddExactAmountOfRewardSuccessfully() {

        double startGold = this.getGold(this.warrior);
        double reward = 1.0;

        this.warrior.receiveReward(reward);
        double expected = startGold + reward;
        double actual = this.getGold(this.warrior);

        Assert.assertEquals(expected, actual, Double.MIN_VALUE);
    }

    @Test
    public void testTakeDamageMethodShouldReduceWarriorHealthAndWarriorStaysAlive() {

        double startHealth = 5.0;
        double damage = 1.0;
        this.warrior.setHealth(startHealth);

        this.warrior.takeDamage(damage);
        double expected = startHealth - damage;
        double actual = this.warrior.getHealth();

        Assert.assertEquals(expected, actual, Double.MIN_VALUE);
    }

    @Test
    public void testIsAliveMethodWithDamageEqualToWarriorHealthShouldReturnFalse() {

        this.warrior.takeDamage(this.warrior.getHealth());
        boolean actual = this.warrior.isAlive();

        Assert.assertFalse(actual);
    }

    @Test
    public void testLevelUpMethodShouldDoubleWarriorStatsSuccessfully() {

        this.warrior.setStrength(3);
        this.warrior.setDexterity(4);
        this.warrior.setIntelligence(5);

        this.warrior.levelUp();
        int expectedStrength = 3 * LEVEL_UP_MULTIPLIER;
        int actualStrength = this.warrior.getStrength();
        int expectedDexterity = 4 * LEVEL_UP_MULTIPLIER;
        int actualDexterity = this.warrior.getDexterity();
        int expectedIntelligence = 5 * LEVEL_UP_MULTIPLIER;
        int actualIntelligence = this.warrior.getIntelligence();
        double expectedHealth = 3 * LEVEL_UP_MULTIPLIER * HERO_HEALTH_MULTIPLIER;
        double actualHealth = this.warrior.getHealth();

        Assert.assertEquals(expectedStrength, actualStrength);
        Assert.assertEquals(expectedDexterity, actualDexterity);
        Assert.assertEquals(expectedIntelligence, actualIntelligence);
        Assert.assertEquals(expectedHealth, actualHealth, Double.MIN_VALUE);
    }

    @SuppressWarnings("unchecked")
    private double getGold(Warrior warrior) {
        try {
            //Field gold = Warrior.class.getDeclaredField("gold");         // Use for Judge
            Field gold = AbstractHero.class.getDeclaredField("gold");
            gold.setAccessible(true);
            return (double) gold.get(warrior);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}