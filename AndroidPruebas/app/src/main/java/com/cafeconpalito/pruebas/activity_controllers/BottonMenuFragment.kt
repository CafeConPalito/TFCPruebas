package com.cafeconpalito.pruebas.activity_controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cafeconpalito.pruebas.R

// SE PUEDE BORRAR!!!!
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
// private const val ARG_PARAM1 = "param1"
// private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottonMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottonMenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var saludo: String? = null
    private var nombre: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // el if es para comprobar que la instancia no esta creada y crearla.
        if (savedInstanceState == null) {
            arguments?.let {
                saludo = it.getString(BUNDLE_SALUDO)
                nombre = it.getString(BUNDLE_NOMBRE)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_botton_menu, container, false)
    }

    //ESTO ME PERMITE SETEAR Y PASAR LOS ARGUMENTOS DE UNA VISTA A OTRA, UTILIZANDO CLAVES - VALOR
    companion object {

        const val BUNDLE_SALUDO = "Saludo"
        const val BUNDLE_NOMBRE = "Nombre"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottonMenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(saludo: String, nombre: String) =
            BottonMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(BUNDLE_SALUDO,saludo)
                    putString(BUNDLE_NOMBRE,nombre)
                }
            }
    }
}