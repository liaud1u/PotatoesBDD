package fr.liaud1u.potatoesbdd.model;

import javax.persistence.*;

@Entity
public class Potato {
    // Potato Variety Name
    private String varietyName;

    @Column(columnDefinition = "LONGTEXT")
    // Potato Variety description
    private String description;

    // Potato parentage
    private String parentage;

    // Potato IVT Variety
    private String IVTVariety;

    // Potato Breeder country
    private String breederCountry;

    // Potato colour of skin
    private String colourOfSkin;

    // Potato colour of flesh
    private String colourOfFlesh;

    // Potato smoothness
    private String smoothness;

    // Potato maturity
    private String maturity;

    // Potato crop height
    private String height;

    // Potato crop flower colour
    private String colourOfFlower;


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    /**
     * Default constructor
     *
     * @param varietyName
     * @param description
     * @param parentage
     * @param IVTVariety
     * @param breederCountry
     * @param colourOfSkin
     * @param colourOfFlesh
     * @param smoothness
     * @param maturity
     * @param height
     * @param coulourOfFlower
     */
    public Potato(String varietyName, String description, String parentage, String IVTVariety, String breederCountry, String colourOfSkin, String colourOfFlesh, String smoothness, String maturity, String height, String coulourOfFlower) {
        this.varietyName = varietyName;
        this.description = description;
        this.parentage = parentage;
        this.IVTVariety = IVTVariety;
        this.breederCountry = breederCountry;
        this.colourOfSkin = colourOfSkin;
        this.colourOfFlesh = colourOfFlesh;
        this.smoothness = smoothness;
        this.maturity = maturity;
        this.height = height;
        this.colourOfFlower = coulourOfFlower;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentage() {
        return parentage;
    }

    public void setParentage(String parentage) {
        this.parentage = parentage;
    }

    public String getIVTVariety() {
        return IVTVariety;
    }

    public void setIVTVariety(String IVTVariety) {
        this.IVTVariety = IVTVariety;
    }

    public String getBreederCountry() {
        return breederCountry;
    }

    public void setBreederCountry(String breederCountry) {
        this.breederCountry = breederCountry;
    }

    public String getColourOfSkin() {
        return colourOfSkin;
    }

    public void setColourOfSkin(String colourOfSkin) {
        this.colourOfSkin = colourOfSkin;
    }

    public String getColourOfFlesh() {
        return colourOfFlesh;
    }

    public void setColourOfFlesh(String colourOfFlesh) {
        this.colourOfFlesh = colourOfFlesh;
    }

    public String getSmoothness() {
        return smoothness;
    }

    public void setSmoothness(String smoothness) {
        this.smoothness = smoothness;
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getColourOfFlower() {
        return colourOfFlower;
    }

    public void setColourOfFlower(String colourOfFlower) {
        this.colourOfFlower = colourOfFlower;
    }

    public Potato(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Potato{" +
                "varietyName='" + varietyName + '\'' +
                ", description='" + description + '\'' +
                ", parentage='" + parentage + '\'' +
                ", IVTVariety='" + IVTVariety + '\'' +
                ", breederCountry='" + breederCountry + '\'' +
                ", colourOfSkin='" + colourOfSkin + '\'' +
                ", colourOfFlesh='" + colourOfFlesh + '\'' +
                ", smoothness='" + smoothness + '\'' +
                ", maturity='" + maturity + '\'' +
                ", height='" + height + '\'' +
                ", colourOfFlower='" + colourOfFlower + '\'' +
                ", id=" + id +
                '}';
    }
}
