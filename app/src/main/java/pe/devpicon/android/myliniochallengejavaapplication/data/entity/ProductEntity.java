package pe.devpicon.android.myliniochallengejavaapplication.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by armando on 7/26/17.
 */

public class ProductEntity {
    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @SerializedName("image")
    public String imageUrl;
    @SerializedName("linioPlusLevel")
    public Integer linioPlusLevel;
    @SerializedName("conditionType")
    public String conditionType;
    @SerializedName("freeShipping")
    public Boolean freeShipping = false;
    @SerializedName("imported")
    public Boolean imported = false;
    @SerializedName("active")
    public Boolean active = false;
}
