package pe.devpicon.android.myliniochallengejavaapplication.data;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pe.devpicon.android.myliniochallengejavaapplication.data.entity.CollectionEntity;
import pe.devpicon.android.myliniochallengejavaapplication.data.entity.ProductEntity;
import pe.devpicon.android.myliniochallengejavaapplication.data.entity.Result;
import pe.devpicon.android.myliniochallengejavaapplication.model.CollectionModel;
import pe.devpicon.android.myliniochallengejavaapplication.model.ProductModel;
import pe.devpicon.android.myliniochallengejavaapplication.presenter.MainPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by armando on 7/26/17.
 */

public class Service {
    private static final String LOG_TAG = "Service";
    private final MainPresenter mainPresenter;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gist.githubusercontent.com").addConverterFactory(GsonConverterFactory.create()).build();

    public Service(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    public void getProducts() {
        final Result result;
        LinioService service = retrofit.create(LinioService.class);
        Call<List<CollectionEntity>> collections = service.getCollections();

        collections.enqueue(new Callback<List<CollectionEntity>>() {
            @Override
            public void onResponse(Call<List<CollectionEntity>> call, Response<List<CollectionEntity>> response) {

                List<ProductModel> allProducts = new ArrayList<ProductModel>();
                List<CollectionModel> collections = new ArrayList<CollectionModel>();

                List<CollectionEntity> body = response.body();
                for (int i = 0; i < body.size(); i++) {
                    CollectionEntity collectionEntity = body.get(i);
                    Gson gson = new Gson();
                    JsonObject productJson = collectionEntity.productJson;
                    Map<String, JsonObject> mapElements = gson.fromJson(productJson, new TypeToken<Map<String, JsonObject>>() {
                    }.getType());
                    List<JsonObject> jsonObjectList = new ArrayList<JsonObject>(mapElements.values());
                    List<ProductModel> products = new ArrayList<ProductModel>();
                    for (int j = 0; j < jsonObjectList.size(); j++) {
                        JsonObject jsonObject = jsonObjectList.get(j);
                        ProductEntity productEntity = gson.fromJson(jsonObject, new TypeToken<ProductEntity>() {
                        }.getType());
                        ProductModel productModel = new ProductModel(productEntity.id, productEntity.name, productEntity.imageUrl, productEntity.linioPlusLevel, productEntity.conditionType, productEntity.freeShipping, productEntity.imported, productEntity.active);

                        products.add(productModel);
                        allProducts.add(productModel);
                    }

                    CollectionModel collectionModel = new CollectionModel(collectionEntity.id, collectionEntity.name, products);
                    collections.add(collectionModel);

                }

                mainPresenter.showCollections(collections);
                mainPresenter.showAllProducts(allProducts);

            }

            @Override
            public void onFailure(Call<List<CollectionEntity>> call, Throwable t) {
                Log.e(LOG_TAG, "onFailure: ", t );
            }
        });
    }

}
