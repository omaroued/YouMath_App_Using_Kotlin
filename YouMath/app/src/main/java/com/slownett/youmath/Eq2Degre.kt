package com.slownett.youmath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_eq2_degre.*

class Eq2Degre : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eq2_degre)

         MobileAds.initialize(this, "ca-app-pub-9723852870925367/4054068345")

        var mAdView:AdView
        mAdView = findViewById(R.id.adView1)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)



            imButton.setOnClickListener(View.OnClickListener{

                try {
                    var a= etA.text.toString()
                    var b= etB.text.toString()
                    var c=etC.text.toString()



                    var delta=(b.toDouble()*b.toDouble())-((4)*(a.toDouble()))*(c.toDouble())
                    var sqrt=Math.sqrt(delta)

                    if (delta<0){
                        Toast.makeText(this,"Check your inputs",Toast.LENGTH_LONG).show()
                    }else if (delta>=0){
                        var x2=(-b.toDouble()+sqrt)/(2*a.toDouble())
                        var x1=(-b.toDouble()-sqrt)/(2*a.toDouble())

                        var dicimalx1=Math.floor(x1*1000)/1000
                        var dicimalx2=Math.floor(x2*1000)/1000

                        x1result.text="X1= $dicimalx1"
                        x2Result.text="X2= $dicimalx2"
                    }
                }catch (ex:Exception){
                    Toast.makeText(this,"Check your inputs",Toast.LENGTH_LONG).show()
                }


            })
        }


    }

