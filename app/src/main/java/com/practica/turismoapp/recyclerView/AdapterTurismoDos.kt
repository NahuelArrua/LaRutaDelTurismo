package com.practica.turismoapp.recyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.practica.turismoapp.R
import com.practica.turismoapp.data.Turismo


class AdapterTurismoDos(
    private val listaTurismo: List<Turismo>,
) :
    RecyclerView.Adapter<AdapterTurismoDos.MyViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val turismo = listaTurismo[position]
        viewHolder.bind(turismo)

    }

    override fun getItemCount(): Int = listaTurismo.size


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ivimagenuno: ImageView = view.findViewById(R.id.ivimagenUno)
        private val ivimagendos: ImageView = view.findViewById(R.id.ivimagenDos)
        private val imageOne: ImageView = view.findViewById(R.id.imageone)
        private val imageTwo: ImageView = view.findViewById(R.id.ivGastronomy)
        private val textServicios: TextView = view.findViewById(R.id.textServicios)
       // private val textLugares: TextView = view.findViewById(R.id.tvLugares)
        private val textDescripcion: TextView = view.findViewById(R.id.textDescripcion)
      //  private val tvLugares: TextView = view.findViewById(R.id.tvLugares)




        fun bind(Glamping: Turismo) {
            ivimagenuno.load(Glamping.Fotos)
            ivimagendos.load(Glamping.Fotos)
            imageOne.load(Glamping.Fotos)
            imageTwo.load(Glamping.Fotos)
            textServicios.text = Glamping.Servicios
          //  textLugares.text = Glamping.Lugares
            textDescripcion.text = Glamping.Descripcion
           // tvLugares.text = Glamping.Lugares



        }
    }
}





