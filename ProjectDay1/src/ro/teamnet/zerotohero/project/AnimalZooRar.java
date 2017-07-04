package ro.teamnet.zerotohero.project;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class AnimalZooRar extends Animal {
    private String numeAnimal;
    private String numeTaraOrigine;

    public AnimalZooRar(String numeAnimal, String numeTaraOrigine) {
        this.numeAnimal = numeAnimal;
        this.numeTaraOrigine = numeTaraOrigine;
    }

    public AnimalZooRar(String numeAnimal) {
        this.numeAnimal = numeAnimal;
        this.numeTaraOrigine = "";
    }

    public AnimalZooRar(){
        this.numeAnimal = "";
        this.numeTaraOrigine = "";
    }

    public String getNumeAnimal() {
        return numeAnimal;
    }

    public String getNumeTaraOrigine() {
        return numeTaraOrigine;
    }


    @Override
    void mananca(Object obj) throws AnimalManancaAnimalException {
        if (obj instanceof AngajatZoo)
            throw new AnimalManancaOmException();
        if (obj instanceof Animal)
            throw new AnimalManancaAnimalException();
        else
            System.out.println("AnimalulZooRar mananca");
    }

    @Override
    void seJoaca() {
        System.out.println("AnimalulZooRar se joaca");
        super.doarme();
    }

    @Override
    void faceBaie() {
        System.out.println("AnimalulZooRar face baie");
    }

}
