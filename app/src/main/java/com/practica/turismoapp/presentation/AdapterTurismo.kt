package com.practica.turismoapp.presentation


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.practica.turismoapp.R
import com.practica.turismoapp.data.Turismo

interface TurismoClickedListener {
    fun onTurismoClicked(turismo: Turismo)
}

class AdapterTurismo(
    private var listaTurismo: List<Turismo>,
    private val cuandoAgoClickedListener: TurismoClickedListener,
) :
    RecyclerView.Adapter<AdapterTurismo.MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val turismo = listaTurismo[position]
        viewHolder.bind(turismo)
        viewHolder.itemView.setOnClickListener { cuandoAgoClickedListener.onTurismoClicked(turismo) }
    }

    override fun getItemCount(): Int = listaTurismo.size

 /*

  fun updateProvince(listaTurismo: List<Turismo>){
        this.listaTurismo = listaTurismo
        notifyDataSetChanged()
    }
 */

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       // private val tvProvincia: TextView = view.findViewById(R.id.tvProvincia)
        private val ivProvincias: ImageView = view.findViewById(R.id.ivProvincias)
        private val textLugares: TextView = view.findViewById(R.id.textLugares)
        private val tvDirection: TextView = view.findViewById(R.id.tvDireccion)





        fun bind(Glamping: Turismo) {
            ivProvincias.load(Glamping.ImagenPrincipal) {
                scale(Scale.FIT)
                crossfade(2_000)
            }
            textLugares.text = Glamping.Lugares
            tvDirection.text = Glamping.Provincia

        }
    }
}
