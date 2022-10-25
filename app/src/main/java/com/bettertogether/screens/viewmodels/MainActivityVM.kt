package com.bettertogether.screens.viewmodels

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bettertogether.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivityVM : ViewModel() {

    private val isLoading = MutableLiveData(false)
    private val hasErrors = MutableLiveData(false)
    val userLogged = MutableLiveData(false)
    val onHomeClick = MutableLiveData(false)
    val onWorkClick = MutableLiveData(false)

    fun isLoading(): LiveData<Boolean> = isLoading
    fun hasErrors(): LiveData<Boolean> = hasErrors
    fun userLogged(): LiveData<Boolean> = userLogged

    fun loginWithGoogle(activity: Activity) {
        isLoading.postValue(true)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(activity.getString(
            R.string.default_web_client_id)).requestEmail().build()
        val client = GoogleSignIn.getClient(activity, gso)

        val signInIntent: Intent = client.signInIntent
        activity.startActivityForResult(signInIntent, 1)

       }

    fun clearErrors(){
        hasErrors.postValue(false)
    }

    fun finishLogin(accountTask: Task<GoogleSignInAccount>){

        try {
           val account: GoogleSignInAccount? = accountTask.getResult(ApiException::class.java)

            account?.idToken?.let { token ->
                val auth = FirebaseAuth.getInstance()
                val credential = GoogleAuthProvider.getCredential(token, null)

                auth.signInWithCredential(credential).addOnCompleteListener { task ->

                    if(task.isSuccessful){
                       val user = auth.currentUser
                        userLogged.postValue(true)
                    }else{
                        hasErrors.postValue(true)

                    }
                    isLoading.postValue(false)

                }
            }
        } catch (e: ApiException){

            hasErrors.postValue(true)
        }

    }
}