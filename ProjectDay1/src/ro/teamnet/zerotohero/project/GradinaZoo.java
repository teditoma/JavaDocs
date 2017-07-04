package ro.teamnet.zerotohero.project;

import java.util.Date;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public final class GradinaZoo {
    private final String denumireGradinaZoo;
    private final Date dataDeschideriiGradinii;
    private final AnimalZooRar animalRar;
    private final IngrijitorZoo angajatulLunii;

    public String getDenumireGradinaZoo() {
        return denumireGradinaZoo;
    }

    public Date getDataDeschideriiGradinii() {
        // Date is mutable
        return new Date(this.dataDeschideriiGradinii.getTime());
    }

    public AnimalZooRar getAnimalRar() {
        // AnimalZooRar is mutable
        return new AnimalZooRar(animalRar.getNumeAnimal(),animalRar.getNumeTaraOrigine());
    }

    public IngrijitorZoo getAngajatulLunii() {
        return angajatulLunii;
    }

    public GradinaZoo(String denumireGradinaZoo, Date dataDeschideriiGradinii, AnimalZooRar animalRar, IngrijitorZoo angajatulLunii) {
        this.denumireGradinaZoo = denumireGradinaZoo;
        this.dataDeschideriiGradinii = dataDeschideriiGradinii;
        this.animalRar = animalRar;
        this.angajatulLunii = angajatulLunii;
    }

}
