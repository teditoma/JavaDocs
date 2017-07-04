package ro.teamnet.zerotohero.project;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {

    @Override
    void mananca(Object obj) throws AnimalManancaAnimalException {
        if ( obj instanceof AngajatZoo)
            throw new AnimalManancaOmException();
        if (obj instanceof Animal)
            throw new AnimalManancaAnimalException();
        else
            System.out.println("AnimalulZooFeroce mananca");
    }

    @Override
    void seJoaca() {
        System.out.println("AnimalulZooFeroce se joaca");
        super.doarme();
    }

    @Override
    void faceBaie() {
        System.out.println("AnimalulZooFeroce face baie");
    }

    void doarme() {
        super.doarme();
        System.out.println("AnimalulZooFeroce vaneaza");
    }
}
