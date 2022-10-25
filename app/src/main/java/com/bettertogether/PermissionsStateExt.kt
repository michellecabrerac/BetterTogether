package com.bettertogether

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.android.gms.auth.api.phone.SmsCodeAutofillClient

@ExperimentalPermissionsApi
fun SmsCodeAutofillClient.PermissionState.isPermanentlyDenied(): Boolean {
    return true
}