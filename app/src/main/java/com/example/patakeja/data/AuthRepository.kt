@file:Suppress("DEPRECATION")

package com.example.patakeja.data

import com.example.patakeja.models.Users
import com.example.patakeja.navigation.ROUTE_HOME
import com.example.patakeja.navigation.ROUTE_LOGIN
import com.example.patakeja.navigation.ROUTE_MY_ACCOUNT
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.patakeja.navigation.ROUTE_ADD_PROPERTY
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class AuthRepository(var navController: NavHostController, var context: Context) {
    var mAuth: FirebaseAuth
    val progress: ProgressDialog
    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setTitle("Please wait...")
    }


    fun signup(name:String, email:String, password:String){
        progress.show()
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                val userData = Users(name,email,password,mAuth.currentUser!!.uid)
                val regRef = FirebaseDatabase.getInstance() .getReference()
                    .child("Users/"+mAuth.currentUser!!.uid)
                regRef.setValue(userData).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context,"Signup successful", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_HOME)
                    }
                    else{
                        navController.navigate(ROUTE_LOGIN)
                    }
                }
            }else{
                navController.navigate(ROUTE_MY_ACCOUNT)
            }
        }

    }


    fun login(email: String, password: String) {
        progress.show()
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            progress.dismiss()
            if(it.isSuccessful){
                Toast.makeText(context,"Login successful", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_ADD_PROPERTY)
            }
            else{
                navController.navigate(ROUTE_LOGIN)
            }
        }
    }

}
