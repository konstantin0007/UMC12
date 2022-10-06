package com.example.umcver12

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class RegistrVhod : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // определение ориаентации экрана
        /*
        val appContext = this.applicationContext
        val configuration = resources.configuration
        if (configuration.orientation === Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.vhod_por)
        }
        if (configuration.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.vhod_land)
        }
        */

        setContentView(R.layout.vhod)

        var PhoneMail: Boolean = true
        var VhodL1 = findViewById<TextView>(R.id.VhodL1)
        var constL = findViewById<ConstraintLayout>(R.id.VhodConstL)
        var VhodBT1 = findViewById<TextView>(R.id.VhodBT1)
        var VhodBT2 = findViewById<TextView>(R.id.VhodBT2)
        var VhodPS = findViewById<TextView>(R.id.VhodPS)
        var VhodETPhone = findViewById<EditText>(R.id.VhodETPhone)
        var VhodES = findViewById<TextView>(R.id.VhodES)
        var VhodETMail = findViewById<EditText>(R.id.VhodETMail)
        var VhodBEnter = findViewById<Button>(R.id.VhodBEnter)
        var VhodBReg = findViewById<Button>(R.id.VhodBReg)
        var VhodPassT = findViewById<TextView>(R.id.VhodPassT)
        var vhodPass = findViewById<EditText>(R.id.vhodPass)

        constL.setBackgroundResource(R.color.black)

        VhodPassT.setVisibility(View.INVISIBLE)
        vhodPass.setVisibility(View.GONE)
        VhodBT2.setVisibility(View.INVISIBLE)

        //  чтение настроек, телефон почта
        val sharedPreferences = getSharedPreferences("SettingsMobUMC", MODE_PRIVATE)
        var phoneUser = sharedPreferences.getString("phoneUser", "")
        var mailUser = sharedPreferences.getString("mailUser", "")

        if (PhoneMail == true ) {
            VhodES.setVisibility(View.INVISIBLE)
            VhodETMail.setVisibility(View.GONE)
            VhodPS.setVisibility(View.VISIBLE)
            VhodETPhone.setVisibility(View.VISIBLE)
            VhodBT1.setText(R.string.VhodBT1)
            if (phoneUser != "") {
                VhodETPhone.setText(phoneUser)
            }
            PhoneMail = false
        } else {
            VhodPS.setVisibility(View.INVISIBLE)
            VhodETPhone.setVisibility(View.GONE)
            VhodES.setVisibility(View.VISIBLE)
            VhodETMail.setVisibility(View.VISIBLE)
            VhodBT1.setText(R.string.VhodBT3)
            if (mailUser != "") {
                VhodETPhone.setText(mailUser)
            }
            PhoneMail = true
        }

        VhodBEnter.setOnClickListener{
            VhodPassT.setVisibility(View.VISIBLE)
            vhodPass.setVisibility(View.VISIBLE)
            VhodES.setVisibility(View.INVISIBLE)
            VhodETMail.setVisibility(View.GONE)
            VhodPS.setVisibility(View.INVISIBLE)
            VhodETPhone.setVisibility(View.GONE)
            VhodBT1.setVisibility(View.INVISIBLE)
            VhodBT2.setVisibility(View.VISIBLE)
            VhodBReg.setVisibility(View.GONE)
            VhodBEnter.setText(R.string.VhodNext)
            VhodL1.setText(R.string.VhodL2)


        }

        VhodBT1.setOnClickListener{
            if (PhoneMail == true ) {
                VhodES.setVisibility(View.INVISIBLE)
                VhodETMail.setVisibility(View.GONE)
                VhodPS.setVisibility(View.VISIBLE)
                VhodETPhone.setVisibility(View.VISIBLE)
                VhodBT1.setText(R.string.VhodBT1)
                if (phoneUser != "") {
                    VhodETPhone.setText(phoneUser)
                }
                PhoneMail = false
            } else {
                VhodPS.setVisibility(View.INVISIBLE)
                VhodETPhone.setVisibility(View.GONE)
                VhodES.setVisibility(View.VISIBLE)
                VhodETMail.setVisibility(View.VISIBLE)
                VhodBT1.setText(R.string.VhodBT3)
                if (mailUser != "") {
                    VhodETPhone.setText(mailUser)
                }
                PhoneMail = false
                //1234567890
            }
            }


    }



}