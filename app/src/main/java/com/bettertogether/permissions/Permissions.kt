package com.bettertogether.permissions

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.LatLng
/*
private fun getLocationPermission(){
    if (ContextCompat.checkSelfPermission(this.applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
    {
        viewModel.permissionGrand(true)
        getDeviceLocation()

    }
}

private  fun getDeviceLocation(){
    val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

    try {
        if (viewModel.locationPermissionGranted.value ==true){
            val locationResult = fusedLocationProviderClient.lastLocation

            locationResult.addOnCompleteListener {
                    task ->
                if (task.isSuccessful){
                    val lastKnownLocation = task.result

                    if (lastKnownLocation != null){
                        viewModel.currentUserGeoCOord(
                            LatLng(
                                lastKnownLocation.altitude,
                                lastKnownLocation.longitude
                            )
                        )
                    }
                }
            }

        }

    }catch (e: SecurityException){
    }
}
}
*/
