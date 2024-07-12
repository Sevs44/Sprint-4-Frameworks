package com.example.sprint4frameworks.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sprint4frameworks.databinding.FragmentUserListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)

        binding.btnAdd.setOnClickListener {
            goToAddUser()
        }

        return binding.root
    }

    private fun goToAddUser() {
        val action = UserListFragmentDirections.actionFragmentUserListToFragmentAddUser()
        findNavController().navigate(action)
    }
}