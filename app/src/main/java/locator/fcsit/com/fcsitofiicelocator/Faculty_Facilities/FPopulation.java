package locator.fcsit.com.fcsitofiicelocator.Faculty_Facilities;

/**
 * Created by Umar Saidu Auna on 11/06/2017.
 */

public class FPopulation {
    private String Fnumber;
    private String Fname;
    private String Fmap;
    private int Fphoto;

    public FPopulation(String Fnumber, String Fname, String Fmap, int Fphoto) {
        this.Fnumber = Fnumber;
        this.Fname = Fname;
        this.Fmap = Fmap;
        this.Fphoto = Fphoto;

    }

    public String getFnumber() {
        return this.Fnumber;
    }

    public String getFname() {
        return this.Fname;
    }

    public String getFMap() {
        return this.Fmap;
    }


    public int getFPhoto() {
        return this.Fphoto;
    }
}
