package com.example.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.Extensions.applyBoldText


class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = Product(
            name = "Petits pois et carottes",
            brand = "Cassegrain",
            barcode = "3083680085304",
            nutriScore = "E",
            nutriInfo = "234 kCal",
            quantity = "400 g (280 g net égoutté)",
            countries = listOf("France", "Japon", "Suisse"),
            imageUrl = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            ingredients = listOf(
                "Petit pois 66%",
                "eau",
                "garniture 2,8% (salade, oignon grelot)",
                "sucre",
                "sel",
                "arôme naturel"
            ),
            allergens = listOf("aucune"),
            additives = listOf("aucun")
        )
        Glide.with(this).load(product.imageUrl).into(view.findViewById(R.id.img))
        view.findViewById<TextView>(R.id.barcode).applyBoldText("Code-barres", product.barcode)
        view.findViewById<TextView>(R.id.quantity).applyBoldText("Quantité", product.quantity)
        view.findViewById<TextView>(R.id.countries).applyBoldText("Vendu en", product.countries.joinToString( "," ))
        view.findViewById<TextView>(R.id.ingredients).applyBoldText("Ingrédients",product.ingredients.joinToString ("," ))
        view.findViewById<TextView>(R.id.allergens).applyBoldText("Substance allergènes", product.allergens.joinToString ("," ))
        view.findViewById<TextView>(R.id.additives).applyBoldText("Additifs", product.additives.joinToString ( "," ))

        toast()
    }

    fun toast(){
        val text = "Hello toast!"
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(requireContext(), text, duration)
        toast.show()
    }

}

