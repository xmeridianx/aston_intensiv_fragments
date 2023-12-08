package com.example.aston_intensiv_fragments.task2.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aston_intensiv_fragments.R
import com.example.aston_intensiv_fragments.task2.data.UserAdapter
import com.example.aston_intensiv_fragments.databinding.FragmentUserListBinding
import com.example.aston_intensiv_fragments.task2.UserItemClickListener
import com.example.aston_intensiv_fragments.task2.UserList
import com.example.aston_intensiv_fragments.task2.data.model.UserItem


class UserListFragment : Fragment(), UserItemClickListener {

    private lateinit var binding: FragmentUserListBinding
    private var userAdapter: UserAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userAdapter = UserAdapter(onUserItemClick = {it ->
            onUserItemClick(it)
        })
        userAdapter?.submitList(UserList.getUsers())

        binding.recyclerViewUserList.adapter = userAdapter


    }

    override fun onUserItemClick(userItem: UserItem) {
        val editUserFragment = EditUserFragment()
        val args = Bundle()
        args.putInt("userId", userItem.id)
        editUserFragment.arguments = args

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, editUserFragment)
            .addToBackStack(null)
            .commit()
    }
}