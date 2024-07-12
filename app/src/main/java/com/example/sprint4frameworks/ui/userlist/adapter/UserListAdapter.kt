package com.example.sprint4frameworks.ui.userlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint4frameworks.data.db.entities.UserEntity
import com.example.sprint4frameworks.databinding.ItemRecyclerviewListNameBinding

class UserListAdapter(
    private val users: List<UserEntity>,
    private val onItemClick: (UserEntity) -> Unit
) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemRecyclerviewListNameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.binding.tvName.text = user.name
        holder.binding.root.setOnClickListener {
            onItemClick(user)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}