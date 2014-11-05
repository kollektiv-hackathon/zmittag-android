package kollektiv.zmittapp.entities;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by tzhware7 on 01.11.14.
 */
public class Menu {


    private int ID;
    private String APPETIZER;
    private String MAIN_COURSE;
    private String DESERT;
    private double PRICE;
    private String DATE;
    private boolean VEGETARIAN;
    private boolean VEGAN;


    @JsonCreator
    public Menu(@JsonProperty("id") int id,
                @JsonProperty("appetizer") String appetizer,
                @JsonProperty("main_course") String main_course,
                @JsonProperty("desert") String desert,
                @JsonProperty("price") double price,
                @JsonProperty("date") String date,
                @JsonProperty("vegetarian") boolean vegetarian,
                @JsonProperty("vegan") boolean vegan){

        this.ID = id;
        this.APPETIZER = appetizer;
        this.MAIN_COURSE = main_course;
        this.DESERT = desert;
        this.PRICE = price;
        this.DESERT = date;
        this.VEGETARIAN = vegetarian;
        this.VEGAN = vegan;
    }

    public int getID(){return ID;}

    public String getAPPETIZER(){return APPETIZER;}

    public String getMAIN_COURSE(){return MAIN_COURSE;}

    public String getDESERT(){return DESERT;}

    public double getPRICE(){return PRICE;}

    public String getDATE(){return DATE;}

    public boolean isVEGETARIAN(){return VEGETARIAN;}

    public boolean isVEGAN(){return VEGAN;};


}
