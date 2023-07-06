package com.example.my_shop

import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter (var productList: List<Products>): RecyclerView.Adapter<MyShopViewHolder>(){
    override fun onCreateViewHolder(parent: ViewParent, viewType: Int): MyShopViewHolder{
        val binding =
            ProductListItemBinding: inflate(LayoutInflater.from(parent.context), parent, false)
        return MyShopViewHolder(binding)
    }
    override fun getItemCount(): Int{
        return productList.size
    }
}

override fun OnBindViewHolder(holder: MyShopViewHolder, position: Int){
    var currentProducts = productList[position]
    binding.tvId.text = currentProducts.id.toString()
    binding.tvCategory.text = currentProducts.category.toString()
    binding.tvDescription.text = currentProducts.description.toString()
    binding.tvPrice.text = currentProducts.price.toString()
    binding.tvTitle.text = currentProducts.title.toString()
    binding.tvRating.text = currentProducts.rating.toString()
    binding.tvStock.text = currentProducts.stock.toString()

    Picasso
        .get()
        .load(currentProducts.thumbnail)
        .into(binding.ivThumbnail)

}
}
        class MyShopViewHolder(var binding: ProductListItemBinding): RecyclerView.ViewHolder(binding.root)