package com.cafeconpalito.pruebadanieldos.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebadanieldos.databinding.ItemHoroscopeBinding
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelectec: (HoroscopeInfo) -> Unit) {

        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        //Esta comentado ya que no funciona correctamenet
        //binding.tvHoroscope.text = horoscopeInfo.name.toString()
        binding.tvHoroscope.text = binding.tvHoroscope.context.getString(horoscopeInfo.name)

        //Listener para si se selecciona una de los horoscopos.
        binding.parent.setOnClickListener {

            //Inicio la animacion y le paso como vista la imagen del horoscopo
            //IMPORTANTE son dos onItemSelectec Distintos, funciones Lambda
            //Se ocupan de cambiar la vista al terminar la animacion.
            startRotationAnimation(
                binding.ivHoroscope,
                onItemSelectec = { onItemSelectec(horoscopeInfo) })

        }

    }

    /**
     * Se ocupa de realizar la animacion
     * necesita recibir una vista
     *
     * IMPORTANTE!!!
     * RECIBE UNA FUNCION LAMBA " onItemSelectec: () -> Unit " aunque tenga el mismo nombre es otra
     * y lo que va a hacer es que al terminar la animacion activara otra Funcion Lambda
     */
    private fun startRotationAnimation(view: View, onItemSelectec: () -> Unit) {

        view.animate().apply {
            //Duracion en milisegundos
            duration = 500

            //Si tiene aceleracion o es linear
            interpolator = LinearInterpolator()

            //Grados de Rotacion en Floats, vuelta entera
            rotationBy(360f)

            //Lanza esto al terminar la accion (END) de movimiento
            //Va a llamar a la funcion para cambiar la vista
            withEndAction { onItemSelectec() }

            //lanza la animacion
            start()
        }

    }


}