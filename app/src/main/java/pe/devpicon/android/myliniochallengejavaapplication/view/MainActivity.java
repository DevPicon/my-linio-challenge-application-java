package pe.devpicon.android.myliniochallengejavaapplication.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import pe.devpicon.android.myliniochallengejavaapplication.R;
import pe.devpicon.android.myliniochallengejavaapplication.model.CollectionModel;
import pe.devpicon.android.myliniochallengejavaapplication.model.ProductModel;
import pe.devpicon.android.myliniochallengejavaapplication.presenter.MainPresenter;
import pe.devpicon.android.myliniochallengejavaapplication.view.adapter.CollectionAdapter;
import pe.devpicon.android.myliniochallengejavaapplication.view.adapter.ProductAdapter;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter = null;
    private ProductAdapter productAdapter = null;
    private CollectionAdapter collectionAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        RecyclerView rvCollections = (RecyclerView) findViewById(R.id.rv_collections);
        rvCollections.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        collectionAdapter = new CollectionAdapter();
        rvCollections.setAdapter(collectionAdapter);

        RecyclerView rvProducts = (RecyclerView) findViewById(R.id.rv_favourite_products);
        rvProducts.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        productAdapter = new ProductAdapter();
        rvProducts.setAdapter(productAdapter);

        presenter.loadProducts();
    }

    @Override
    public void showProducts(List<ProductModel> productModelList) {
        if(productModelList != null){
            TextView txtAllFavouritesTitles = (TextView) findViewById(R.id.all_favourites_title);
            txtAllFavouritesTitles.setText(String.format(getString(R.string.all_products_title), productModelList.size()));
            productAdapter.setProductModelList(productModelList);
            productAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void showCollections(List<CollectionModel> collections) {
        if(collections != null){
            collectionAdapter.setCollectionModelList(collections);
            collectionAdapter.notifyDataSetChanged();
        }
    }
}
