package com.example.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductListFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view as RecyclerView

        val product1 = Product(
            imageUrl = "https://images.openfoodfacts.org/images/products/327/408/000/5003/front_en.797.400.jpg",
            name = "Eau de source",
            brand = "Cristaline",
            nutriScore = "A",
            nutriInfo = "234 kCal",
            barcode = "3274080005003",
            quantity = "1,5 L",
            countries = listOf("Allemagne", "Belgique", "Nouvelle-Calédonie", "France", "Japon", "Royaume-Uni", "Suisse", "États-Unis"),
            ingredients = listOf("Eau"),
            allergens = listOf("Aucune"),
            additives = listOf("Aucun")
        )

        val list = listOf(product1, product1, product1)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListAdapter(list, object : OnProductClickListener {
            override fun onProductClicked(product: Product) {
               /* findNavController().navigate(
                    ProductListFragmentDirections.actionListFragmentToDetailsFragment(
                        product = product
                    )
                ) */
            }
        })
    }
}

class ListAdapter(private val listOfPositions: List<Product>,
                  private val listener: OnProductClickListener,
) : RecyclerView.Adapter<PositionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        return PositionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false),
            listener,
        )
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        holder.updateCell(listOfPositions[position])
    }

    override fun getItemCount(): Int {
        return listOfPositions.size
    }

}

class PositionViewHolder(v: View, val listener: OnProductClickListener) : RecyclerView.ViewHolder(v) {

    private val imageUrl : ImageView =v.findViewById(R.id.image)
    private val name : TextView = v.findViewById(R.id.name)
    private val brand : TextView = v.findViewById(R.id.brand)
    private val nutriInfo : TextView = v.findViewById(R.id.nutriInfo)

    fun updateCell(product: Product) {
        itemView.setOnClickListener {
            listener.onProductClicked(product)
        }

        Glide.with(itemView.context).load(product.imageUrl).into(imageUrl)
        name.text = product.name
        brand.text = product.brand
        nutriInfo.text = product.nutriInfo
    }

}

interface OnProductClickListener {
    fun onProductClicked(product: Product)
}