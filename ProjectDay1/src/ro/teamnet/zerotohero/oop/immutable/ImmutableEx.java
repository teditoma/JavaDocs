package ro.teamnet.zerotohero.oop.immutable;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class ImmutableEx {
    // x cannot be modified after instantiation
    private final int x;

    public ImmutableEx(int x){
        this.x = x;
    }

    public int getX() {
        return this.x;
    }


}
