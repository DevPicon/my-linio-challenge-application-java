package pe.devpicon.android.myliniochallengejavaapplication.presenter;

import java.util.List;

import pe.devpicon.android.myliniochallengejavaapplication.data.Service;
import pe.devpicon.android.myliniochallengejavaapplication.model.CollectionModel;
import pe.devpicon.android.myliniochallengejavaapplication.model.ProductModel;
import pe.devpicon.android.myliniochallengejavaapplication.view.MainView;

/**
 * Created by armando on 7/26/17.
 */

public class MainPresenter {
    private final MainView view;
    private final Service service;
    
    public MainPresenter(MainView view) {
        this.view = view;
        this.service = new Service(this);
    }

    public void loadProducts() {
        service.getProducts();
    }

    public void showCollections(List<CollectionModel> collections) {
        view.showCollections(collections);
    }

    public void showAllProducts(List<ProductModel> allProducts) {
        view.showProducts(allProducts);
    }
}
