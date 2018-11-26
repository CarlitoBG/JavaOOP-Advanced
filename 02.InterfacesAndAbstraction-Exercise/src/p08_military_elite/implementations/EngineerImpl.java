package p08_military_elite.implementations;

import p08_military_elite.interfaces.Engineer;
import p08_military_elite.interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{

    private Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps, Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs(repairs);
    }

    private void setRepairs(Collection<Repair> repairs) {
        if (repairs != null){
            this.repairs = new ArrayList<>(repairs);
        }
        this.repairs = repairs;
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        this.repairs.forEach(r -> sb.append("  ").append(r).append(System.lineSeparator()));
        return sb.toString();
    }
}