package p08_military_elite.implementations;

import p08_military_elite.interfaces.Commando;
import p08_military_elite.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando{

    private Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps, Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.setMissions(missions);
    }

    private void setMissions(Collection<Mission> missions) {
        if (missions != null){
            this.missions = new ArrayList<>(missions);
            return;
        }
        this.missions = new ArrayList<>();
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        this.missions.forEach(m -> sb.append("  ").append(m).append(System.lineSeparator()));
        return sb.toString();
    }
}