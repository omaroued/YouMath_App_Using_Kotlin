package com.slownett.youmath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_theo_details.*

class TheoDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theo_details)

        MobileAds.initialize(this, "ca-app-pub-9723852870925367/4054068345")

        var mAdView:AdView?=null
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        var bundle=intent.extras
        imDetails.setImageResource(bundle!!.getInt("img"))
        tvDetails.text=bundle.getString("des")
    }
}
