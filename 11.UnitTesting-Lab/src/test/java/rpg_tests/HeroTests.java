package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTests {

    private static final int TARGET_XP = 5;
    private static final int HERO_INVENTORY_SIZE = 1;
    private static final String HERO_NAME = "Pesho";
    private static final String WRONG_EXPERIENCE = "Wrong experience";
    private static final String LOOT_NUMBER_MESSAGE = "Wrong number of loot";

    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals(WRONG_EXPERIENCE, TARGET_XP, hero.getExperience());
    }

    @Test
    public void heroGetsLootWhenKillsTarget(){
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals(LOOT_NUMBER_MESSAGE, HERO_INVENTORY_SIZE, hero.getInventory().size());
    }
}