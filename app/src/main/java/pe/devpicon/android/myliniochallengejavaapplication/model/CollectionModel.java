package pe.devpicon.android.myliniochallengejavaapplication.model;

/**
 * Created by armando on 7/26/17.
 */

import java.util.List;

/**
 * data class CollectionModel (val id:Int, val name:String, val productList:List<ProductModel>)
 */
public class CollectionModel {
    private final Integer id;
    private final String name;
    private final List<ProductModel> productList;

    public CollectionModel(Integer id, String name, List<ProductModel> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProductModel> getProductList() {
        return productList;
    }
}
