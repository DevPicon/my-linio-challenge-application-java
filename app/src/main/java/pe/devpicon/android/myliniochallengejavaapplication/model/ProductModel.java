package pe.devpicon.android.myliniochallengejavaapplication.model;

/**
 * Created by armando on 7/26/17.
 */

public class ProductModel {
    private final Integer id;
    private final String name;
    private final String imageUrl;
    private final Integer linioPlusLevel;
    private final String conditionType;
    private final Boolean freeShipping;
    private final Boolean imported;
    private final Boolean active;

    public ProductModel(Integer id, String name, String imageUrl, Integer linioPlusLevel, String conditionType, Boolean freeShipping, Boolean imported, Boolean active) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.linioPlusLevel = linioPlusLevel;
        this.conditionType = conditionType;
        this.freeShipping = freeShipping;
        this.imported = imported;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getLinioPlusLevel() {
        return linioPlusLevel;
    }

    public String getConditionType() {
        return conditionType;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public Boolean getImported() {
        return imported;
    }

    public Boolean getActive() {
        return active;
    }
}
