package pe.devpicon.android.myliniochallengejavaapplication.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import pe.devpicon.android.myliniochallengejavaapplication.R;
import pe.devpicon.android.myliniochallengejavaapplication.model.ProductModel;

/**
 * Created by armando on 7/26/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<ProductModel> productModelList;

    public ProductAdapter() {
        if (this.productModelList == null) {
            this.productModelList = new ArrayList<>();
        }
    }

    public void setProductModelList(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        if (holder != null) {
            holder.bind(productModelList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        View itemView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void bind(ProductModel productModel) {
            Context context = itemView.getContext();

            ImageView ivProduct = (ImageView) itemView.findViewById(R.id.iv_product);
            ImageView ivFreeShipping = (ImageView) itemView.findViewById(R.id.iv_freeshipping);
            View ivLinioPlusLevel = itemView.findViewById(R.id.iv_linio_plus_level);
            View ivLinioPlusLevel48 = itemView.findViewById(R.id.iv_linio_plus_level_48);

            if(productModel.getFreeShipping()){
                ivFreeShipping.setVisibility(View.VISIBLE);
            } else {
                ivFreeShipping.setVisibility(View.GONE);
            }

            if(productModel.getLinioPlusLevel().equals(1)){
                ivLinioPlusLevel.setVisibility(View.VISIBLE);
                ivLinioPlusLevel48.setVisibility(View.GONE);
            } else {
                ivLinioPlusLevel.setVisibility(View.GONE);
                ivLinioPlusLevel48.setVisibility(View.VISIBLE);
            }

            if(productModel.getConditionType().equals("refurbished")){
                itemView.findViewById(R.id.iv_new).setVisibility(View.GONE);
                itemView.findViewById(R.id.iv_refurbished).setVisibility(View.VISIBLE);
            } else if (productModel.getConditionType().equals("new")){
                itemView.findViewById(R.id.iv_new).setVisibility(View.VISIBLE);
                itemView.findViewById(R.id.iv_refurbished).setVisibility(View.GONE);
            } else{
                itemView.findViewById(R.id.iv_new).setVisibility(View.GONE);
                itemView.findViewById(R.id.iv_refurbished).setVisibility(View.GONE);
            }

            if(productModel.getImported()){
                itemView.findViewById(R.id.iv_international).setVisibility(View.VISIBLE);
            }else{
                itemView.findViewById(R.id.iv_international).setVisibility(View.GONE);
            }

            populateImage(context, productModel.getImageUrl(), ivProduct);

        }
    }

    private void populateImage(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions().placeholder(R.drawable.ic_empty_product_found))
                .into(imageView);
    }

}
