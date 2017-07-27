package pe.devpicon.android.myliniochallengejavaapplication.data.entity;

import java.util.List;

import pe.devpicon.android.myliniochallengejavaapplication.model.CollectionModel;
import pe.devpicon.android.myliniochallengejavaapplication.model.ProductModel;

/**
 * Created by armando on 7/26/17.
 */

public class Result {
    private final List<CollectionModel> collections;
    private final List<ProductModel> allProducts;

    public Result(List<CollectionModel> collections, List<ProductModel> allProducts) {
        this.collections = collections;
        this.allProducts = allProducts;
    }

    public List<CollectionModel> getCollections() {
        return collections;
    }

    public List<ProductModel> getAllProducts() {
        return allProducts;
    }
}
