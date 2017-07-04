package ro.teamnet.zerotohero.project;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public abstract class Animal {
    public Animal(){
        System.out.println("Animal nou");
    }

    abstract void mananca(Object obj) throws AnimalManancaAnimalException;
    abstract void seJoaca();
    abstract void faceBaie();

    void doarme() {
        System.out.println("Animalul doarme");
    }
}
