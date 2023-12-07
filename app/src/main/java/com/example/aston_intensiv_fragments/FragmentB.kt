package com.example.aston_intensiv_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_fragments.databinding.FragmentABinding
import com.example.aston_intensiv_fragments.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToFragmentC.setOnClickListener {

            val fragmentC = FragmentC()
            val bundle = Bundle()
            bundle.putString("message", "Hello Fragment C")
            fragmentC.arguments = bundle

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentC)
                .addToBackStack(null)
                .commit()
        }

        binding.buttonBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }


}