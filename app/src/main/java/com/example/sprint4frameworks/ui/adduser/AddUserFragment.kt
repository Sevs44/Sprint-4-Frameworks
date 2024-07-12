package com.example.sprint4frameworks.ui.adduser

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sprint4frameworks.data.models.City
import com.example.sprint4frameworks.databinding.FragmentAddUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserFragment : Fragment() {

    private lateinit var binding: FragmentAddUserBinding
    private val viewModel: AddUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cities = viewModel.getCities()

        binding = FragmentAddUserBinding.inflate(inflater, container, false)

        binding.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btSaveUser.setOnClickListener {
            addUser()
        }
        setUpSpinner(cities)

        return binding.root
    }

    private fun addUser() {
        //TODO
    }

    private fun getLocation() {
        //TODO
    }

    private fun setUpSpinner(cities: List<City>) {
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            cities.map { it.name }
        )
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerFavCity.adapter = adapter

        binding.spinnerFavCity.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    var selectedCity = cities[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    var selectedCity = cities[0]
                }
            }
    }

}