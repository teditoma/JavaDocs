package ro.teamnet.zerotohero.project;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class GradinaZooMain {
    public static void main(String[] args) throws AnimalPeCaleDeDisparitieException, AnimalManancaAnimalException {
        AnimalZooRar animal1 = new AnimalZooRar("Pinguin");
        AnimalZooRar animal2 = new AnimalZooRar("Elefant","Africa");
        AnimalZooRar animal3 = new AnimalZooRar();

        AnimalZooFeroce animalFeroce = new AnimalZooFeroce();

        AngajatZoo angajat1 = new IngrijitorZoo();
        IngrijitorZoo angajat2 = new IngrijitorZoo();

        AngajatZoo angajat3 = new VeterinarZoo();
        VeterinarZoo angajat4 = new VeterinarZoo();

        System.out.println(animal1.getNumeAnimal());
        System.out.println(animal1.getNumeTaraOrigine());
        System.out.println(animal2.getNumeAnimal());
        System.out.println(animal2.getNumeTaraOrigine());

        //apelul metodelor
        angajat3.lucreaza(animal1);
        angajat3.lucreaza(animal2);
        angajat3.lucreaza(animal3);
        angajat4.lucreaza(animal1);
        angajat4.lucreaza(animal2);
        angajat4.lucreaza(animal3);

        angajat1.lucreaza(animal1);
        angajat1.lucreaza(animal2);
        angajat1.lucreaza(animal3);

        angajat2.lucreaza(animal1);
        angajat2.lucreaza(animal2);
        angajat2.lucreaza(animal3);

        try{
            angajat2.lucreaza(animal1,null);
        }
        catch (AnimalPeCaleDeDisparitieException e) {
            System.err.println("Animal pe cale de disparitie");
        }

        try {
            angajat2.lucreaza(animal1,angajat1);
        }
        catch (AnimalManancaOmException e){
            System.err.println("Animal mananca om!!!!");
        }

        angajat2.lucreaza(animal1,new String("Mancare"));

        angajat2.lucreaza(animalFeroce);
        angajat2.lucreaza(animalFeroce,null);
        angajat2.lucreaza(animalFeroce, new String("Mancare"));

        //Animal mananca animal
        try{
            animalFeroce.mananca(animal2);
        }
        catch (Exception e){
            System.err.println("Animal feroce mananca alt animal!!!");
        }
        System.out.println("Finish!");

    }
}
