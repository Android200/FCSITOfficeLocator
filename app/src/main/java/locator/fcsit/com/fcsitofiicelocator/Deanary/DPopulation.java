package locator.fcsit.com.fcsitofiicelocator.Deanary;

/**
 * Created by Umar Saidu Auna on 09/06/2017.
 */

public class DPopulation {
    private String office;
    private String lecturer;
    private String phone;
    private String email;
    private String map;
    private int photo;

    public DPopulation(String office, String lecturer, String phone, String email, String map,
                       int photo) {
        this.office = office;
        this.lecturer = lecturer;
        this.phone = phone;
        this.email = email;
        this.map = map;
        this.photo = photo;


    }

    public String getOffice() {
        return this.office;
    }

    public String getLecturer() {
        return this.lecturer;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail(){
        return  this.email;
    }

    public String getMap(){
        return this.map;
    }


    public int getPhoto() {
        return this.photo;
    }
}
