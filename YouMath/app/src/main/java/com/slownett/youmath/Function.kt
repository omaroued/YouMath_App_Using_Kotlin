package com.slownett.youmath

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_function.*
import kotlinx.android.synthetic.main.fx_ticket.view.*
import org.intellij.lang.annotations.Language
import java.util.*

class Function : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)


        MobileAds.initialize(this, "ca-app-pub-9723852870925367/4054068345")

        var mAdView:AdView?=null
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        var adapter:FunctionsAdapter?=null

        var listOfFunctions=ArrayList<FunctionsClass>()


        listOfFunctions.add(FunctionsClass("ax",R.drawable.degre))
        listOfFunctions.add(FunctionsClass("phythagore",R.drawable.pythagore))
        listOfFunctions.add(FunctionsClass("kachi",R.drawable.el_kachi))

        adapter= FunctionsAdapter(this,listOfFunctions)
        lvFunctions.adapter=adapter


    }
}
class FunctionsAdapter:BaseAdapter{
    var listOfFunctions=ArrayList<FunctionsClass>()
    var context:Context?=null
    constructor(context:Context,listOfFunctions:ArrayList<FunctionsClass>):super(){
        this.listOfFunctions=listOfFunctions
        this.context=context
    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var fx=this.listOfFunctions[p0]
        var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var fxView=inflator.inflate(R.layout.fx_ticket, null)
        fxView.imFx.setImageResource(fx.img!!)
        fxView.imFunction.setOnClickListener{
            if (fx.name.equals("ax")){
                var intent=Intent(context,Eq2Degre::class.java)
                context!!.startActivity(intent)
            }else if (fx.name!!.equals("phythagore")){
                var intent=Intent(context,pythagore::class.java)
                context!!.startActivity(intent)
            }else if(fx.name.equals("kachi")){
                var intent=Intent(context,el_kachi::class.java)
                context!!.startActivity(intent)

            }
        }

        return fxView
    }

    override fun getItem(p0: Int): Any {
        return listOfFunctions[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }


    override fun getCount(): Int {
       return listOfFunctions.size
    }

}

