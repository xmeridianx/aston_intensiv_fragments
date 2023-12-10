package com.example.aston_intensiv_fragments.task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.aston_intensiv_fragments.R
import com.example.aston_intensiv_fragments.databinding.FragmentCBinding


class FragmentC : Fragment() {

    private lateinit var binding: FragmentCBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val message = it.getString("message", "")
            binding.textviewFromFragmentB.text = message
        }

        binding.buttonToFragmentD.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentD())
                .addToBackStack(null)
                .commit()
        }

        binding.buttonToFragmentA.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack(
                null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }

}