package com.interview.weatherapp.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.interview.weatherapp.R

abstract class BaseActivity<VDB : ViewDataBinding>(private val layoutRes: Int) :
    AppCompatActivity() {
    protected var binding: VDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding?.lifecycleOwner = this
    }

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) {
        observe(this@BaseActivity, Observer(observer))
    }

    fun showSnackbar(message: String?) {
        message?.also {
            val snackbar = binding?.let { binding ->
                Snackbar.make(
                    binding.root,
                    it,
                    Snackbar.LENGTH_INDEFINITE
                )
            }
            snackbar?.setAction(R.string.close) { snackbar.dismiss() }
            snackbar?.show()
        }
    }
}