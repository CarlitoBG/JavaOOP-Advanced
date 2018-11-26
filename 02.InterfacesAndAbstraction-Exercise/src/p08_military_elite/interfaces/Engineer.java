package p08_military_elite.interfaces;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier{
    Collection<Repair> getRepairs();
}