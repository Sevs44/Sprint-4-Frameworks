package com.example.sprint4frameworks.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint4frameworks.data.db.entities.UserEntity
import com.example.sprint4frameworks.databinding.FragmentUserListBinding
import com.example.sprint4frameworks.ui.userlist.adapter.UserListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private val viewModel: UserListViewModel by viewModels()
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)

        binding.btnAdd.setOnClickListener {
            goToAddUser()
        }

        binding.rvUserList.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            val users = viewModel.getUsers()
            showUsers(users)
        }

        return binding.root
    }


    private fun showUsers(users: List<UserEntity>?) {
        if (users.isNullOrEmpty()) {
            binding.tvNoUsersFound.visibility = View.VISIBLE
        } else {
            binding.tvNoUsersFound.visibility = View.GONE
            setUpAdapter(users)
        }
    }

    private fun setUpAdapter(users: List<UserEntity>) {
        userListAdapter = UserListAdapter(users) { user ->
            val action =
                UserListFragmentDirections.actionFragmentUserListToFragmentUserDetails(user.id)
            findNavController().navigate(action)
        }
        binding.rvUserList.adapter = userListAdapter
    }

    private fun goToAddUser() {
        val action = UserListFragmentDirections.actionFragmentUserListToFragmentAddUser()
        findNavController().navigate(action)
    }
}