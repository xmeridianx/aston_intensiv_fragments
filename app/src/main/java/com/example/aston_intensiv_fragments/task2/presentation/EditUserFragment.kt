package com.example.aston_intensiv_fragments.task2.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_fragments.databinding.FragmentEditUserBinding
import com.example.aston_intensiv_fragments.task2.UserList


class EditUserFragment : Fragment() {

    private lateinit var binding: FragmentEditUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = arguments?.getInt("userId", 0) ?: 0
        val user = UserList.getUserById(userId)

        binding.textViewName.text = user?.name
        binding.textViewSurname.text = user?.surname
        binding.textViewPhoneNumber.text = user?.phoneNumber

        binding.buttonSaveContact.setOnClickListener {
            val newName = binding.editTextName.text.toString()
            val newSurname = binding.editTextSurname.text.toString()
            val newPhoneNumber = binding.editTextPhoneNumber.text.toString()

            UserList.editUser(userId, newName, newSurname, newPhoneNumber)

            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}