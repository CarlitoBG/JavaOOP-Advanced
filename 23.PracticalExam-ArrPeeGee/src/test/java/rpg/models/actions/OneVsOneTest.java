package rpg.models.actions;

import rpg.contracts.Targetable;
import rpg.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OneVsOneTest {

    private static final String NOT_TWO_PARTICIPANTS = "There should be exactly 2 participants for OneVsOne!";

    private OneVsOne action;
    private List<Targetable> participants;

    @Before
    public void setUp() {
        this.action = new OneVsOne();
        this.participants = new ArrayList<>();
    }

    @Test
    public void executeActionShouldFailForInvalidCountOfWarriors() {

        String actual = this.action.executeAction(this.participants);

        Assert.assertEquals(NOT_TWO_PARTICIPANTS, actual);
    }

    @Test
    public void executeActionShouldSucceedForSecondWarrior() {

        Warrior victor = Mockito.mock(Warrior.class);
        Warrior looser = Mockito.mock(Warrior.class);
        Mockito.doNothing().when(victor).levelUp();
        Mockito.doNothing().when(looser).levelUp();
        Mockito.when(victor.attack(looser)).thenReturn("");
        Mockito.when(looser.attack(victor)).thenReturn("");
        Mockito.when(victor.isAlive()).thenReturn(true);
        Mockito.when(victor.getName()).thenReturn("Victor");
        Mockito.when(looser.isAlive()).thenReturn(false);
        Mockito.when(looser.getName()).thenReturn("Looser");

        this.participants.add(looser);
        this.participants.add(victor);

        String result = this.action.executeAction(this.participants).trim();

        Assert.assertTrue(result, result.startsWith(victor.getName()));
    }
}