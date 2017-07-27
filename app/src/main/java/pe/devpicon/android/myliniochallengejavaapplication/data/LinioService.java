package pe.devpicon.android.myliniochallengejavaapplication.data;

import java.util.List;

import pe.devpicon.android.myliniochallengejavaapplication.data.entity.CollectionEntity;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by armando on 7/26/17.
 */

public interface LinioService {
    @GET("/la-ursic/3c5f25d5ee955ee9a6e493ac57884b9c/raw/5fab9af8e1f4db60419ba3a8da9f138cbb3a8461/Wish%2520lists")
    Call<List<CollectionEntity>> getCollections();
}
