package ro.teamnet.zerotohero.project;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {
    int bonusSalarial = 0;

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
        calculeazaBonusSalarial();
    }

    @Override
    public void calculeazaBonusSalarial() {
        bonusSalarial += valoareBonusPerAnimal * 3;
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException, AnimalManancaAnimalException {
        if ( animal instanceof AnimalZooRar && mancare == null)
            throw new AnimalPeCaleDeDisparitieException();
        lucreaza(animal);

        animal.mananca(mancare);
        animal.faceBaie();
        animal.seJoaca();
        animal.doarme();
    }
}
