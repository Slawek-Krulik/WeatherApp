package com.interview.weatherapp.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.interview.weatherapp.R

abstract class BaseActivity<B : ViewBinding>(private val bindingInflater: (LayoutInflater) -> B) :
    AppCompatActivity() {
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }

    fun showSnackbar(message: String?) {
        message?.also {
            val snackbar = Snackbar.make(
                binding.root,
                it,
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction(R.string.close) { snackbar.dismiss() }
            snackbar.show()
        }
    }
}