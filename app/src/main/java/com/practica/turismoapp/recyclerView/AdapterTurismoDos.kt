package com.practica.turismoapp.recyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.practica.turismoapp.Constants
import com.practica.turismoapp.R
import com.practica.turismoapp.data.Turismo
import org.w3c.dom.Text


class AdapterTurismoDos(
    private val listaTurismo: List<Turismo>
) :
    RecyclerView.Adapter<AdapterTurismoDos.MyViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_layout, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val turismo = listaTurismo[position]
        viewHolder.bind(turismo)

    }

    override fun getItemCount(): Int = listaTurismo.size


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvLugares: TextView = view.findViewById(R.id.tvLugares)
        private val ivimagenuno: ImageView = view.findViewById(R.id.ivimagenUno)
        private val ivimagendos: ImageView = view.findViewById(R.id.ivimagenDos)
        private val ivProvinciasDA: ImageView = view.findViewById(R.id.ivProvincias)
        private val ivProvincias: ImageView = view.findViewById(R.id.ivProvincias)
        private val tvDescripcion: TextView = view.findViewById(R.id.tvDescripcion)
        private val tvProvincia: TextView = view.findViewById(R.id.tvProvincia)


        fun bind(Glamping: Turismo) {
            tvLugares.text = Glamping.Lugares
            ivimagenuno.load(Glamping.ImagenPrincipal)
            ivimagendos.load(Glamping.Servicios)
            ivProvinciasDA.load(Glamping.Provincia)
            ivProvincias.load(Glamping.ImagenPrincipal)
            tvDescripcion.text = Glamping.Descripcion
            tvProvincia.text = Glamping.Provincia
        }
    }
}





