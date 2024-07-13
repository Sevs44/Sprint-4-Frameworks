package com.example.sprint4frameworks.ui.usermarkedmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sprint4frameworks.R
import com.example.sprint4frameworks.databinding.FragmentMarkedMapBinding
import com.example.sprint4frameworks.ui.userdetails.UserDetailsViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserMarkedMapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMarkedMapBinding
    private val viewModel: UserDetailsViewModel by viewModels()
    private val args: UserMarkedMapFragmentArgs by navArgs()
    private lateinit var myGoogleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMarkedMapBinding.inflate(inflater, container, false)

        binding.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.fcvMap) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(map: GoogleMap) {

        myGoogleMap = map

        val userLocation = LatLng(args.latitude.toDouble(), args.longitude.toDouble())
        myGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 10f))
        myGoogleMap.addMarker(MarkerOptions().position(userLocation).title(args.cityName))
    }
}