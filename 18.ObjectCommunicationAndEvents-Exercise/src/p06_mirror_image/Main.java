package p06_mirror_image;

import p06_mirror_image.contracts.Repository;
import p06_mirror_image.contracts.Wizard;
import p06_mirror_image.models.WizardImpl;
import p06_mirror_image.repository.RepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] wizardParams = reader.readLine().split("\\s+");

        String wizardName = wizardParams[0];
        int wizardMagicalPower = Integer.parseInt(wizardParams[1]);
        Repository repository = new RepositoryImpl();

        Wizard wizard = new WizardImpl(wizardName, wizardMagicalPower, repository);
        repository.addWizard(wizard);

        while (true){
            String line = reader.readLine();
            if("END".equals(line)){
                break;
            }

            String[] tokens = line.split("\\s+");
            int wizardId = Integer.parseInt(tokens[0]);
            String spellName = tokens[1];

            Wizard wizardById = repository.getWizardById(wizardId);

            if("FIREBALL".equals(spellName)){
                System.out.println(wizardById.castFireball());
            }else if("REFLECTION".equals(spellName)){
                System.out.println(wizardById.castReflection());
            }
        }
    }
}