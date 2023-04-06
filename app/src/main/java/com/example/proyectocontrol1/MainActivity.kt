package com.example.proyectocontrol1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() ,View.OnClickListener {

    lateinit var ed1 :EditText
    lateinit var ed2 :EditText
    lateinit var ed3 :EditText
    lateinit var btn1 :Button
    lateinit var tres :TextView
    lateinit var img :ImageView
    val vec:Array<Int> = arrayOf(R.drawable.error,R.drawable.equilatero,R.drawable.escaleno,
        R.drawable.isoceles)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //relacionar los controles del formulario con las variables
        ed1=findViewById(R.id.edn1)
        ed2=findViewById(R.id.edn2)
        ed3=findViewById(R.id.edn3)
        btn1=findViewById(R.id.btnCalcular)
        img=findViewById(R.id.image1)
        tres=findViewById(R.id.txtRes)
        btn1.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        var a= ed1.text.toString().toInt()
        var b= ed2.text.toString().toInt()
        var c= ed3.text.toString().toInt()

        if(a+b>c && b+c>a && a+c>b){
            var sp: Double = (a+b+c) /2.0
            var are= sqrt(sp * (sp-a)*(sp-b)*(sp-c))
            var tipo=""
            var dir=0
            if(a==b && b==c && c==a){
                tipo="equilatero"; dir=1
            }else if(a!=b && b!=c && c!=a){
                tipo="escaleno"; dir=2
            }else{
                tipo="isoceles"; dir=3
            }
            img.setImageResource(vec[dir])
            tres.setText("El area es "+are+" tipo=$tipo")
        }else{
            img.setImageResource(vec[0])
            tres.setText("no forma triangulo")
        }
    }

}