package com.example.sprint4frameworks.ui.adduser

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sprint4frameworks.data.models.City
import com.example.sprint4frameworks.databinding.FragmentAddUserBinding
import com.google.android.gms.maps.model.LatLng
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

        getLocation()

        binding = FragmentAddUserBinding.inflate(inflater, container, false)

        binding.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btSaveUser.setOnClickListener {
            addUser(cities)
        }
        setUpSpinner(cities)

        return binding.root
    }

    private fun addUser(cities: List<City>) {
        val name = binding.etName.text.toString()
        val favColor = binding.etFavColor.text.toString()
        val birthdate = binding.etBirthdate.text.toString()
        val favCityName = binding.spinnerFavCity.selectedItem.toString()
        val favCityLat =
            getCity(cities, binding.spinnerFavCity.onItemSelectedListener.toString()).lat
        val favCityLng =
            getCity(cities, binding.spinnerFavCity.onItemSelectedListener.toString()).lng
        val favNumber = binding.etFavNumber.text.toString()
        val actualLocationLat = getLocation().latitude
        val actualLocationLng = getLocation().longitude
        if (viewModel.checkFields(
                name,
                favColor,
                birthdate,
                favCityLat,
                favCityLng,
                favCityName,
                favNumber,
                actualLocationLat,
                actualLocationLng
            )
        ) {
            viewModel.addUser(
                name,
                favColor,
                birthdate,
                favCityLat,
                favCityLng,
                favCityName,
                favNumber.toInt(),
                actualLocationLat,
                actualLocationLng
            )

            findNavController().navigateUp()
        } else
            Toast.makeText(context, "Fill all fields", Toast.LENGTH_LONG).show()
    }

    private fun getCity(cities: List<City>, cityName: String): City {
        val city: City
        val unknownCity = cities.find { it.name == cityName }
        city = unknownCity?.copy() ?: cities[0]
        return city
    }

    private fun getLocation(): LatLng {
        //TODO
        return LatLng(40.7128, -74.0060)
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
                    cities[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    cities[0]
                }
            }
    }

}