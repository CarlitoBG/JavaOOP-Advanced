package p06_mirror_image.contracts;

public interface Repository {
    void addWizard(Wizard wizard);
    Wizard getWizardById(int id);
}