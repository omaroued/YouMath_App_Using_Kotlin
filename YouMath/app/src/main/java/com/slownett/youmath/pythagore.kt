package com.slownett.youmath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_pythagore.*

class pythagore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pythagore)



        MobileAds.initialize(this, "ca-app-pub-9723852870925367/4054068345")

        var mAdView:AdView?=null
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        imButton.setOnClickListener{
            try {
                var a=etA.text.toString()
                var b=etB.text.toString()
                var d=(a.toDouble()*a.toDouble())+(b.toDouble()*b.toDouble())
                var c=Math.sqrt(d)
                var dicimal=Math.floor(c*1000)/1000
                cResult.text="C= $dicimal"
            }catch (ex:Exception){
                Toast.makeText(this,"Check your inputs",Toast.LENGTH_LONG).show()

            }
        }
    }
}
