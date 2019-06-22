package com.gustibimo.shoppingcart.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gustibimo.shoppingcart.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.product_row_item.view.*
import java.text.FieldPosition

class ProductAdapter(var context: Context, var products: List<Product> = arrayListOf()) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.product_row_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindProduct(products[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindProduct(product: Product) {
            val item = CartItem(product)

            itemView.product_name.text = product.name
            itemView.product_price.text = "$${product.price.toString()}"
            Picasso.get().load(product.photos[0].filename).fit().into(itemView.product_image)

            ShoppingCart.addItem(item)
            //notification
            Snackbar.make(
                (itemView.context as MainActivity).coordinator,
                "${product.name} added to your cart",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}