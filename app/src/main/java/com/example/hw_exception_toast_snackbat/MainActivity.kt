package com.example.hw_exception_toast_snackbat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var  constraintLayout:ConstraintLayout?=null
    private var buttonNull:Button?=null
    private var buttonOut:Button?=null
    private var buttonToast:Button?=null
    private var buttonSnack:Button?=null
    private var num:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        checkNull()
        checkOutOfBound()
        showToast()
        showSnackbar()
    }
    private fun connectViews(){

        constraintLayout = findViewById(R.id.root)
        buttonNull = findViewById(R.id.btnIn)
        buttonOut = findViewById(R.id.btnOut)
        buttonToast = findViewById(R.id.btnToast)
        buttonSnack= findViewById(R.id.btnSnack)
    }
    private fun checkNull(){
        buttonNull?.setOnClickListener(){
            try{
            val sum = num!! + 10
        }catch (e:NullPointerException){
            Toast.makeText(this,"num can not be null",Toast.LENGTH_SHORT).show()

            }

            }
    }
    private fun checkOutOfBound(){
        buttonOut?.setOnClickListener {

            val arr:ArrayList<String> =ArrayList()
            arr.add("ahmad")  // index= 0
            arr.add("khaled") //index =1
            arr.add("fayez")  //index= 2

            try {
                val name = arr[3]
            }catch (e:IndexOutOfBoundsException){

                Toast.makeText(this,"this element does not exist",Toast.LENGTH_SHORT).show()
            }

        }

    }
    private fun showToast(){

        buttonToast?.setOnClickListener {

            Toast.makeText(this,"this is sample toast",Toast.LENGTH_SHORT).show()
        }
    }
    private fun showSnackbar(){

        buttonSnack?.setOnClickListener {

            Snackbar.make(constraintLayout!!, "this is sample snackBar",Snackbar.LENGTH_SHORT).setAction("ok"){


            }.show()
        }
    }

}