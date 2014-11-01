package kollektiv.zmittapp.entities;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by tzhware7 on 01.11.14.
 */
public class Restaurant {


    private int ID;
    private String NAME;
    private String PHONE;
    private String EMAIL;
    private double LONGITUDE;
    private double LATITUDE;

    @JsonCreator
    public Restaurant(@JsonProperty("id") int id,
                      @JsonProperty("name") String NAME,
                      @JsonProperty("phone") String PHONE,
                      @JsonProperty("email") String EMAIL,
                      @JsonProperty("longitude") double LONGITUDE,
                      @JsonProperty("latitude") double LATITUDE){

        this.ID = id;
        this.NAME = NAME;
        this.PHONE = PHONE;
        this.EMAIL = EMAIL;
        this.LONGITUDE = LONGITUDE;
        this.LATITUDE = LATITUDE;

    }

    public int getID(){
        return ID;
    }

    public String getNAME(){
        return NAME;
    }

    public String getPHONE(){
        return PHONE;
    }

    public String getEMAIL(){
        return EMAIL;
    }

    public double getLONGITUDE(){
        return LONGITUDE;
    }

    public double getLATITUDE(){
        return LATITUDE;
    }


}
