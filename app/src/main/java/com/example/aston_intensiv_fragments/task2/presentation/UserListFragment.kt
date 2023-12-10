package com.example.aston_intensiv_fragments.task2.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.aston_intensiv_fragments.R
import com.example.aston_intensiv_fragments.task2.data.UserAdapter
import com.example.aston_intensiv_fragments.databinding.FragmentUserListBinding
import com.example.aston_intensiv_fragments.task2.UserItemClickListener
import com.example.aston_intensiv_fragments.task2.data.model.UserItem
import com.example.aston_intensiv_fragments.task2.presentation.EditUserFragment.Companion.EDITED_USER
import com.example.aston_intensiv_fragments.task2.presentation.EditUserFragment.Companion.EDIT_USER_FRAGMENT
import kotlin.random.Random


class UserListFragment : Fragment(), UserItemClickListener {

    private var userAdapter: UserAdapter? = null
    private val binding: FragmentUserListBinding
        get() = requireNotNull(_binding)
    private var _binding: FragmentUserListBinding? = null

    private var listUsers = (1..4).map {
        UserItem(it, R.drawable.baseline_person_24,"Name$it", "LastName$it", Random.nextInt().toString())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userAdapter = UserAdapter(onUserItemClick = {it ->
            onUserItemClick(it)
        })
        userAdapter?.submitList(listUsers)

        binding.recyclerViewUserList.adapter = userAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onUserItemClick(userItem: UserItem) {
        val editUserFragment = EditUserFragment()

        setFragmentResultListener(EDIT_USER_FRAGMENT) { key, result ->
            val editedUser = result.getSerializable(EDITED_USER) as UserItem
            listUsers = listUsers.map { user ->
                if (user.id == editedUser.id) editedUser else user
            }
            userAdapter?.submitList(listUsers)
        }

        val bundle = Bundle().apply {
            putSerializable("user", userItem)
        }
        editUserFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, editUserFragment)
            .addToBackStack(null)
            .commit()
    }
}