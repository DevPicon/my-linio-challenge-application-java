package pe.devpicon.android.myliniochallengejavaapplication.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import pe.devpicon.android.myliniochallengejavaapplication.R;
import pe.devpicon.android.myliniochallengejavaapplication.model.CollectionModel;

/**
 * Created by armando on 7/26/17.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder> {
    private List<CollectionModel> collectionModelList;

    public CollectionAdapter() {
        if (this.collectionModelList == null) {
            this.collectionModelList = new ArrayList<>();
        }
    }

    public void setCollectionModelList(List<CollectionModel> collectionModelList) {
        this.collectionModelList = collectionModelList;
    }

    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, int position) {
        if (holder != null) {
            holder.bind(collectionModelList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return collectionModelList.size();
    }

    class CollectionViewHolder extends RecyclerView.ViewHolder {
        View itemView;

        public CollectionViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void bind(CollectionModel collectionModel) {
            Context context = itemView.getContext();
            Integer limit = (collectionModel.getProductList().size() > 3) ? 3 : collectionModel.getProductList().size();

            for (int i = 0; i < limit; i++) {
                ImageView imageView;
                String imageUrl;
                switch (i){
                    case 0:
                        imageView = (ImageView) itemView.findViewById(R.id.iv_collection_1);
                        imageUrl = collectionModel.getProductList().get(i).getImageUrl();
                        populateImage(context, imageUrl, imageView);
                        break;
                    case 1:
                        imageView = (ImageView) itemView.findViewById(R.id.iv_collection_2);
                        imageUrl = collectionModel.getProductList().get(i).getImageUrl();
                        populateImage(context, imageUrl, imageView);
                        break;
                    case 2:
                        imageView = (ImageView) itemView.findViewById(R.id.iv_collection_3);
                        imageUrl = collectionModel.getProductList().get(i).getImageUrl();
                        populateImage(context, imageUrl, imageView);
                        break;
                }

                TextView txtCollectionName = (TextView) itemView.findViewById(R.id.collection_name);
                txtCollectionName.setText(collectionModel.getName());

                TextView txtCollectionSize = (TextView) itemView.findViewById(R.id.collection_size);
                txtCollectionSize.setText(String.valueOf(collectionModel.getProductList().size()));


            }


        }
    }

    private void populateImage(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions().placeholder(R.drawable.ic_empty_product_found))
                .into(imageView);
    }

}
