package com.slownett.youmath

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.AndroidException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FilterQueryProvider
import android.widget.Toast
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_theo.*
import kotlinx.android.synthetic.main.lv_ticket.*
import kotlinx.android.synthetic.main.lv_ticket.view.*
import org.intellij.lang.annotations.Language
import java.util.*
import java.util.Locale.LanguageRange.MAX_WEIGHT



class theo : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theo)


        MobileAds.initialize(this, "ca-app-pub-9723852870925367/4054068345")

        var mAdView:AdView?=null
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)












        var adapter:TheoremAdapter?=null


        var listOfTheorems=ArrayList<Teorems>()









       var a = Locale.getDefault().language



        if (a =="fr"){
            listOfTheorems.add(Teorems("Phythagore","Le théorème de Pythagore est un théorème de géométrie euclidienne qui met en relation les longueurs des côtés dans un triangle rectangle : le carré de la longueur de l'hypoténuse, qui est le côté opposé à l'angle droit, est égal à la somme des carrés des longueurs des deux autres côtés.",R.drawable.pythagore))
            listOfTheorems.add(Teorems("degre","Le nombre b2 − 4ac est appelé discriminant de l'équation du second degré ax2 + bx + c = 0 ou du trinôme ax2 + bx + c. On le note ∆ (lire delta). 4a2 ] est la forme canonique de f(x). Théorème 1 Racine de l'équation ax2 + bx + c = 0 Lorsque ∆ < 0, l'équation n'a pas de racine.",R.drawable.degre))
            listOfTheorems.add(Teorems("el kachi","Dans un triangle quelconque, le carré de la longueur opposée à un angle est égale à la somme des carrés des deux autres côtés moins le double du produit de ces mêmes côtés et du cosinus de l'angle.",R.drawable.el_kachi))


        }else{

            listOfTheorems.add(Teorems("phythagore","In trigonometry, the law of cosines (also known as the cosine formula or cosine rule) relates the lengths of the sides of a triangle to the cosine of one of its angles. Using notation as in Fig. 1, the law of cosines states {\\displaystyle c^{2}=a^{2}+b^{2}-2ab\\cos \\gamma ,} {\\displaystyle c^{2}=a^{2}+b^{2}-2ab\\cos \\gamma ,} where γ denotes the angle contained between sides of lengths a and b and opposite the side of length c.",R.drawable.pythagore))
            listOfTheorems.add(Teorems("degre","The number b2 - 4ac is called the discriminant of the equation of the second degree ax2 + bx + c = 0 or the trinomial ax2 + bx + c. It is noted Δ (read delta). 4a2] is the canonical form of f (x). Theorem 1 Root of the equation ax2 + bx + c = 0 When Δ <0, the equation has no root.",R.drawable.degre))
            listOfTheorems.add(Teorems("el kachi", "In any triangle, the square of the length opposite to an angle is equal to the sum of the squares of the two other sides minus the double of the product of these same sides and the cosine of the angle.",R.drawable.el_kachi))

        }








        adapter= TheoremAdapter(this,listOfTheorems)
        lvTheo.adapter=adapter
    }



}
class TheoremAdapter:BaseAdapter{

    var listOfTheorems=ArrayList<Teorems>()
    var context:Context?=null
    constructor(context: Context,listOfTheorems:ArrayList<Teorems>):super(){
        this.listOfTheorems=listOfTheorems
        this.context=context

    }
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var theo=listOfTheorems[p0]
        var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var TheoView=inflator.inflate(R.layout.lv_ticket, null)
        TheoView.imtheoimage.setImageResource(theo.img!!)
        TheoView.imtheoimage.setOnClickListener {
            var intent = Intent(context, TheoDetails::class.java)
            intent.putExtra("des", theo.des)
            intent.putExtra("img", theo!!.img)
            context!!.startActivity(intent)
        }
        return  TheoView
    }

    override fun getItem(p0: Int): Any {
        return listOfTheorems[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()

    }

    override fun getCount(): Int {
        return listOfTheorems.size
    }

}

