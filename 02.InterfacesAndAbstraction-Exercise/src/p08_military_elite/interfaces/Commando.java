package p08_military_elite.interfaces;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier{
    Collection<Mission> getMissions();
}