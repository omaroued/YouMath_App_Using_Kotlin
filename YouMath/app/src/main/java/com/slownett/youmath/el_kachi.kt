package com.slownett.youmath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds;


import kotlinx.android.synthetic.main.activity_el_kachi.*

class el_kachi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_el_kachi)


       MobileAds.initialize(this, "ca-app-pub-9723852870925367/4054068345")

         var mAdView:AdView?=null
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)



        imButton.setOnClickListener {
            try {
                var b=etb.text.toString()
                var c=etc.text.toString()
                var d=etd.text.toString()

                var cosD=Math.cos(Math.toRadians(d.toDouble()))
                var a=((b.toDouble()*b.toDouble())+(c.toDouble()*c.toDouble()))-((2*b.toDouble()*c.toDouble())*cosD)
                var result=Math.sqrt(a)
                var dicimal=Math.floor(result*1000)/1000
                tvElKachi.text="a= $dicimal"

            }catch (ex:Exception){
                Toast.makeText(this,"Check your input",Toast.LENGTH_LONG).show()
            }
        }
    }
}
