package com.example.sprint4frameworks.ui.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sprint4frameworks.data.db.entities.UserEntity
import com.example.sprint4frameworks.databinding.FragmentUserDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailsBinding
    private val viewModel: UserDetailsViewModel by viewModels()
    private val args: UserDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            val user = viewModel.getUser(args.id)
            setUpAll(user)
        }

        binding.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }


        return binding.root
    }

    private fun setUpOpenMapButton(user: UserEntity) {
        binding.btOpenMap.setOnClickListener {
            val action = UserDetailsFragmentDirections.actionFragmentUserDetailsToFragmentMarkedMap(
                latitude = user.favoriteCityCoordinatesLat.toString(),
                longitude = user.favoriteCityCoordinatesLng.toString(),
                cityName = user.favoriteCityName
            )
            findNavController().navigate(action)
        }
    }

    private fun setUpAll(user: UserEntity?) {

        if (user != null) {
            val favCityCoordinates =
                "${user.favoriteCityCoordinatesLat}, ${user.favoriteCityCoordinatesLng}"
            val actualLocationCoordinates = "${user.actualPositionLat}, ${user.actualPositionLng}"

            binding.tvUserName.text = user.name
            binding.tvUserFavColor.text = user.favoriteColor
            binding.tvUserBirthdate.text = user.birthdate
            binding.tvUserFavCityCoordinates.text = favCityCoordinates
            binding.tvUserFavCityName.text = user.favoriteCityName
            binding.tvUserFavNumber.text = user.favoriteNumber.toString()
            binding.tvActualLocationValue.text = actualLocationCoordinates

            setUpOpenMapButton(user)

        } else
            Toast.makeText(context, "ERROR: User not found or null", Toast.LENGTH_LONG).show()

    }
}