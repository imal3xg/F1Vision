package com.example.f1vision

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashImage = findViewById<ImageView>(R.id.imageViewLogo)
        // Aplicar la animación de aparecer
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        splashImage.startAnimation(fadeInAnimation)

        // Establecer un listener para la animación de aparecer
        fadeInAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                // Aplicar la animación de desvanecer cuando la de aparecer termine
                val fadeOutAnimation = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_out)
                splashImage.startAnimation(fadeOutAnimation)
                // Establecer la visibilidad de la imagen como GONE al finalizar la animación de desvanecimiento
                fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {}

                    override fun onAnimationEnd(animation: Animation?) {
                        splashImage.visibility = View.GONE
                        // Ir a la siguiente actividad cuando la animación de desvanecer termine
                        startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                        finish() // Finalizar la actividad de Splash Screen para evitar que el usuario regrese a ella
                    }
                    override fun onAnimationRepeat(animation: Animation?) {}
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}

