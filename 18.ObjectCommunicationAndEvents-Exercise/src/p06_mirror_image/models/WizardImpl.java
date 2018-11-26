package p06_mirror_image.models;

import p06_mirror_image.contracts.Repository;
import p06_mirror_image.contracts.Wizard;

public class WizardImpl implements Wizard {
    private static final int STATIC_NUMBER_OF_MIRROR_IMAGES = 2;

    private int id;
    private String name;
    private int magicalPower;
    private Repository wizardRepository;
    private Wizard[] wizards;

    public WizardImpl(String name, int magicalPower, Repository wizardRepository) {
        this.name = name;
        this.magicalPower = magicalPower;
        this.wizardRepository = wizardRepository;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String castFireball() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %d casts Fireball for %d damage", this.name, this.id, this.magicalPower)).append(System.lineSeparator());
        
        if (this.wizards != null) {
            sb.append(this.wizards[0].castFireball()).append(System.lineSeparator());
            sb.append(this.wizards[1].castFireball()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String castReflection() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %d casts Reflection", this.name, this.id)).append(System.lineSeparator());
        
        if (this.wizards == null) {
            this.wizards = new Wizard[STATIC_NUMBER_OF_MIRROR_IMAGES];
            this.wizards[0] = new WizardImpl(this.name, this.magicalPower / 2, this.wizardRepository);
            this.wizards[1] = new WizardImpl(this.name, this.magicalPower / 2, this.wizardRepository);

            this.wizardRepository.addWizard(this.wizards[0]);
            this.wizardRepository.addWizard(this.wizards[1]);
        } else {
            sb.append(this.wizards[0].castReflection()).append(System.lineSeparator());
            sb.append(this.wizards[1].castReflection()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}