package com.slownett.youmath

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        MobileAds.initialize(this, "ca-app-pub-9723852870925367/4054068345")

        var mAdView:AdView?=null
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)



        imFun.setOnClickListener(View.OnClickListener {
            try {
                var intent=Intent(this,Function::class.java)
                startActivity(intent)
            }catch (ex:Exception){
                Toast.makeText(this,"Unknown error",Toast.LENGTH_LONG).show()
            }
        })

        imTheo.setOnClickListener(View.OnClickListener {
            try {
                var intent=Intent(this,theo::class.java)
                startActivity(intent)
            }catch (ex:Exception){
                Toast.makeText(this,"Unknown error",Toast.LENGTH_LONG).show()
            }
        })

        imSite.setOnClickListener(View.OnClickListener {
            try {
                var intent=Intent("android.intent.action.VIEW",Uri.parse("https://www.slownett.com/"))
                startActivity(intent)
            }catch (ex:Exception){
                Toast.makeText(this,"Unknown error",Toast.LENGTH_LONG).show()
            }
        })

        imInfo.setOnClickListener {
            try {
                var intent=Intent(this,Info::class.java)
                startActivity(intent)
            }catch (ex:Exception){
                Toast.makeText(this,"Unknown error",Toast.LENGTH_LONG).show()
            }
        }
    }
}
