package com.cafeconpalito.pruebadanieldos.ui.luck

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.cafeconpalito.pruebadanieldos.R
import com.cafeconpalito.pruebadanieldos.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LuckFragment : Fragment() {

    //Manera de trabajar con Binding y Fragmentos
    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        binding.ivRoulete.setOnClickListener { spinRoulete() }
    }

    /**
     * Generando Animacion ruleta en la accion
     */
    private fun spinRoulete() {

        val random = java.util.Random()
        val degrees = random.nextInt(1440) + 360

        val animator =
            ObjectAnimator.ofFloat(binding.ivRoulete, View.ROTATION, 0f, degrees.toFloat())

        //Duracion
        animator.duration = 2000
        //Desacelera al final
        animator.interpolator = DecelerateInterpolator()
        //Al teminar la animacion deslizamos la carta
        animator.doOnEnd { slideCard() }
        //Lanza la animacion
        animator.start()

    }

    /**
     * Animacion de la carta
     *
     * UTILIZANDO XML
     * FUNCIONA DE OTRA MANERA
     */
    private fun slideCard() {

        //Cargando animacion desde XML, se encuentran en res -> anim
        val slideCardAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)

        //Implemento cuando inicia termina o se repita
        slideCardAnimation.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation?) {
                binding.ivReverseCard.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })

        //Inicia la animacion del XML
        binding.ivReverseCard.startAnimation(slideCardAnimation)

    }

    /**
     * Animacion para que cresca la carta via XML
     */
    private fun growCard() {
        val growCardAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)

        growCardAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                //Al terminar la animacion muestra la vista
                showPremonitionView()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })

        binding.ivReverseCard.startAnimation(growCardAnimation)
    }

    /**
     * Mostrando la prediccion de las Cartas
     *
     */
    private fun showPremonitionView() {
        //Alpha Animation para tener una transicion de desaparecer
        val disapairAnimation = AlphaAnimation(1.0f,0.0f)
        disapairAnimation.duration = 200

        val apearAnimation = AlphaAnimation(0.0f,1.0f)
        apearAnimation.duration = 1000

        disapairAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.clRoulete.isVisible = false
                binding.clPrediction.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.clRoulete.startAnimation(disapairAnimation)
        binding.clPrediction.startAnimation(apearAnimation)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Cargando el Binding para Un fragmento
        _binding = FragmentLuckBinding.inflate(inflater, container, false)
        return binding.root
    }

}