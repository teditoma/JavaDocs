package ro.teamnet.zerotohero.project;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {
    int bonusSalarial = 0;

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal");
        if ( animal instanceof AnimalZooFeroce)
            animal.faceBaie();
        calculeazaBonusSalarial();
    }

    @Override
    public void calculeazaBonusSalarial() {
        bonusSalarial += valoareBonusPerAnimal * 2;
    }
}
