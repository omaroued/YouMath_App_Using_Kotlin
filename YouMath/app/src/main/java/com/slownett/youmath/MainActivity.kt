package com.slownett.youmath

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*



class MainActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

        mAuth = FirebaseAuth.getInstance()



            mAuth!!.signInAnonymously()
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {

                            Toast.makeText(this,"welcome",Toast.LENGTH_LONG).show()
                            var thread=object :Thread(){

                                override fun run() {

                                    try {

                                        var intent = Intent(baseContext, Home::class.java)
                                        Thread.sleep(3 / 2 * 1000.toLong())
                                        startActivity(intent)
                                        finish()
                                    }
                                    catch (ex:Exception){
                                        Toast.makeText(baseContext,"Unknown error",Toast.LENGTH_LONG).show()


                                    }
                                }


                            }

                            thread.start()


                        } else {


                            var thread=object :Thread(){

                                override fun run() {

                                    try {

                                        var intent = Intent(baseContext, Home::class.java)
                                        Thread.sleep(3 / 2 * 1000.toLong())
                                        startActivity(intent)
                                        finish()
                                    }
                                    catch (ex:Exception){
                                        Toast.makeText(baseContext,"Unknown error",Toast.LENGTH_LONG).show()


                                    }
                                }


                            }

                            thread.start()


                        }


                    }





        }






    }








