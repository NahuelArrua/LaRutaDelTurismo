package com.practica.turismoapp.recyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.practica.turismoapp.R
import com.practica.turismoapp.data.Turismo


class AdapterTutismoThree(
    private val listaTurismo: List<Turismo>
) :
    RecyclerView.Adapter<AdapterTutismoThree.MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int, ): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_layout, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = listaTurismo.size

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val turismo = listaTurismo[position]
        viewHolder.bind(turismo)
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvLugares: TextView = view.findViewById(R.id.tvLugares)

        fun bind(Glamping: Turismo) {
            tvLugares.text = Glamping.Lugares

        }
    }
}