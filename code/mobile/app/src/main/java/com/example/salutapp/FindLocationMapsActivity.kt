package com.example.salutapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.salutapp.api.GoogleMapsAPI
import com.example.salutapp.api.model.google.GeolocationResults
import com.example.salutapp.api.model.google.GoogleGeolocationAPIResponse
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindLocationMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var userLocation: LatLng
    private var selectedMarker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_location_maps)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            5769 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    mMap.isMyLocationEnabled = true
//                    Toast.makeText(this,"Acesso garantido",Toast.LENGTH_SHORT).show()
                    createMapAndLocations()
                } else {
                    mMap.isMyLocationEnabled = false
                    Toast.makeText(this, "Acesso negado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val permissionsToRequest = arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            ActivityCompat.requestPermissions(this, permissionsToRequest, 5769)
            return
        } else {
            createMapAndLocations()
        }
    }

    @SuppressLint("MissingPermission")
    fun createMapAndLocations() {
        mMap.isMyLocationEnabled = true
        mMap.uiSettings.isMyLocationButtonEnabled  = true
        mMap.uiSettings.isZoomControlsEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                val currentLocation = LatLng(location.latitude, location.longitude)

                userLocation = currentLocation

                val api = GoogleMapsAPI().requestGoogleMaps()

                val hospitalsNearby = api.getHospitalsNearby("${location.latitude},${location.longitude}")

                hospitalsNearby.enqueue(object : Callback<GoogleGeolocationAPIResponse> {
                    override fun onFailure(call: Call<GoogleGeolocationAPIResponse>, t: Throwable) {
                        Toast.makeText(
                            this@FindLocationMapsActivity,
                            "Falha ao requisitar os hospitais próximos: $t",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<GoogleGeolocationAPIResponse>,
                        response: Response<GoogleGeolocationAPIResponse>
                    ) {
                        if (response.code() == 200) {
                            Toast.makeText(
                                this@FindLocationMapsActivity,
                                "Carregando...",
                                Toast.LENGTH_SHORT
                            ).show()

                            var geolocationResults: List<GeolocationResults> = listOf()
                            var responseStatus: String = ""

                            response?.body()?.let {
                                geolocationResults = it.results
                                responseStatus = it.status
                            }

                            for (geolocationResult in geolocationResults) {
                                val geometryLocation = LatLng(
                                    geolocationResult.geometry.location.lat,
                                    geolocationResult.geometry.location.lng
                                )

                                val geolocationName = geolocationResult.name

                                mMap.addMarker(
                                    MarkerOptions().position(geometryLocation).title(
                                        geolocationName
                                    )
                                )
                            }
                        } else {
                            Toast.makeText(
                                this@FindLocationMapsActivity,
                                "${response.toString()}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                })

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 10.0f))
            }
        }

        mMap.setOnMarkerClickListener { marker ->

            val markerPositions = marker.position
            val markerName = marker.title

            selectedMarker = marker

            marker.showInfoWindow()

            Toast.makeText(this, "Você selecionou $markerName", Toast.LENGTH_SHORT).show()

            true
        }
    }

    fun openUberApp() {
        try {
            if (selectedMarker == null) {
                Toast.makeText(this, "Nenhum ponto marcado", Toast.LENGTH_SHORT).show()
                return
            }

            val markerName = selectedMarker!!.title.split(" ").joinToString("%20")
            val markerLatLng = selectedMarker!!.position

            packageManager.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES)

            val uri = "uber://?action=setPickup&client_id=glpBKnfzziW7qkbuDR9o1yZq8FauixJ3&pickup=my_location&dropoff[formatted_address]=$markerName&dropoff[latitude]=${markerLatLng.latitude}&dropoff[longitude]=${markerLatLng.longitude}"
            val intent = Intent(Intent.ACTION_VIEW)

            intent.setData(Uri.parse(uri))
            startActivity(intent)
        } catch (e: PackageManager.NameNotFoundException) {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=com.ubercab")
                    )
                )
            } catch (anfe: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")
                    )
                )
            }
        }
    }

    fun callApp(button: View) {

        when (button.id) {
            R.id.btn_uber -> openUberApp()
            //R.id.btn_noventa_e_nove -> {
            //}
        }
    }
}