package kollektiv.zmittapp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tzhware7 on 01.11.14.
 */
public class Menu {


    @Expose
    private Integer id;
    @Expose
    private String appetizer;
    @SerializedName("main_course")
    @Expose
    private String mainCourse;
    @Expose
    private String desert;
    @Expose
    private Integer price;
    @Expose
    private String date;
    @Expose
    private Boolean vegetarian;
    @Expose
    private Boolean vegan;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The appetizer
     */
    public String getAppetizer() {
        return appetizer;
    }

    /**
     *
     * @param appetizer
     * The appetizer
     */
    public void setAppetizer(String appetizer) {
        this.appetizer = appetizer;
    }

    /**
     *
     * @return
     * The mainCourse
     */
    public String getMainCourse() {
        return mainCourse;
    }

    /**
     *
     * @param mainCourse
     * The main_course
     */
    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    /**
     *
     * @return
     * The desert
     */
    public String getDesert() {
        return desert;
    }

    /**
     *
     * @param desert
     * The desert
     */
    public void setDesert(String desert) {
        this.desert = desert;
    }

    /**
     *
     * @return
     * The price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The vegetarian
     */
    public Boolean getVegetarian() {
        return vegetarian;
    }

    /**
     *
     * @param vegetarian
     * The vegetarian
     */
    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    /**
     *
     * @return
     * The vegan
     */
    public Boolean getVegan() {
        return vegan;
    }

    /**
     *
     * @param vegan
     * The vegan
     */
    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

}
