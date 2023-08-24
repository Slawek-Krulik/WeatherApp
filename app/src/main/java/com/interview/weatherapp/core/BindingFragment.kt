package com.interview.weatherapp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.interview.weatherapp.R

abstract class BindingFragment<VDB : ViewDataBinding>(private val layoutRes: Int) : Fragment() {

    protected var binding: VDB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding?.lifecycleOwner = viewLifecycleOwner
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) {
        observe(this@BindingFragment, Observer(observer))
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