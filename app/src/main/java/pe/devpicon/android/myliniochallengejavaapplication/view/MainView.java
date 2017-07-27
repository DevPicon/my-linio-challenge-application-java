package pe.devpicon.android.myliniochallengejavaapplication.view;

import android.content.Context;

import java.util.List;

import pe.devpicon.android.myliniochallengejavaapplication.model.CollectionModel;
import pe.devpicon.android.myliniochallengejavaapplication.model.ProductModel;

/**
 * Created by armando on 7/26/17.
 */

public interface MainView {
    void showProducts(List<ProductModel> productModelList);
    Context getActivityContext();
    void showCollections(List<CollectionModel> collections);
}
