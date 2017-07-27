package pe.devpicon.android.myliniochallengejavaapplication.data.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/**
 * Created by armando on 7/26/17.
 */

public class CollectionEntity {
    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @SerializedName("products")
    public JsonObject productJson;
}
