package p06_mirror_image.repository;

import p06_mirror_image.contracts.Repository;
import p06_mirror_image.contracts.Wizard;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {

    private List<Wizard> wizards;

    public RepositoryImpl() {
        this.wizards = new ArrayList<>();
    }

    @Override
    public void addWizard(Wizard wizard) {
        wizard.setId(this.wizards.size());
        this.wizards.add(wizard);
    }

    @Override
    public Wizard getWizardById(int id) {
        return this.wizards.get(id);
    }
}