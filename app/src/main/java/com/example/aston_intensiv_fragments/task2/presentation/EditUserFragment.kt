package com.example.aston_intensiv_fragments.task2.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.aston_intensiv_fragments.R
import com.example.aston_intensiv_fragments.databinding.FragmentEditUserBinding
import com.example.aston_intensiv_fragments.databinding.FragmentUserListBinding
import com.example.aston_intensiv_fragments.task2.data.model.UserItem


class EditUserFragment : Fragment() {
    private val binding: FragmentEditUserBinding
        get() = requireNotNull(_binding)
    private var _binding: FragmentEditUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val user = arguments?.getSerializable("user") as UserItem


        binding.textViewName.text = user.name
        binding.textViewSurname.text = user.surname
        binding.textViewPhoneNumber.text = user.phoneNumber

        binding.buttonSaveContact.setOnClickListener {
            val editedUser = UserItem(
                user.id,
                photo = R.drawable.baseline_person_24,
                name = binding.editTextName.text.toString(),
                surname = binding.editTextSurname.text.toString(),
                phoneNumber = binding.editTextPhoneNumber.text.toString(),
            )
            setFragmentResult(EDIT_USER_FRAGMENT, bundleOf("EDITED_USER" to editedUser))
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    companion object {
        const val EDIT_USER_FRAGMENT = "EDIT_USER_FRAGMENT"
        const val EDITED_USER = "EDITED_USER"
    }
}