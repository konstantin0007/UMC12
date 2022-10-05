package com.example.umcver12

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // определение ориаентации экрана
        val appContext = this.applicationContext
        val configuration = resources.configuration
        if (configuration.orientation === Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.promo_por)
        }
        if (configuration.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.promo_land)
        }

        var namberPromo: Int = 0
        var constL = findViewById<ConstraintLayout>(R.id.PromoConstL)
        var nextButtom = findViewById<Button>(R.id.PromoButton)
        var mainImg: ImageView = findViewById<ImageView>(R.id.PromoMainImg)
        var batImg = findViewById<ImageView>(R.id.PromoBatImg)
        var lText = findViewById<TextView>(R.id.PromoLText)
        var sText = findViewById<TextView>(R.id.PromoSText)

        // пример чтения настроек, будет использоваться в настроках темы
        val sharedPreferences = getSharedPreferences("SettingsMobUMC", Context.MODE_PRIVATE)
        var brightness = sharedPreferences.getString("ThemePril", "black")

        constL.setBackgroundResource(R.color.black)
        mainImg.setImageResource(R.drawable.promo_1m)
        batImg.setImageResource(R.drawable.promo_1b)
        lText.setText(R.string.PromoL1)
        sText.setText(R.string.PromoS1)

        nextButtom.setOnClickListener{
            if (namberPromo == 0) {
                mainImg.setImageResource(R.drawable.promo_2m)
                batImg.setImageResource(R.drawable.promo_2b)
                lText.setText(R.string.PromoL2)
                sText.setText(R.string.PromoS2)
                namberPromo += 1
            }
            else if (namberPromo == 1) {
                mainImg.setImageResource(R.drawable.promo_3m)
                batImg.setImageResource(R.drawable.promo_3b)
                lText.setText(R.string.PromoL3)
                sText.setText(R.string.PromoS3)
                namberPromo += 1

                //пример сохранения настроек, будет использоваться в настроках темы
                val editor = sharedPreferences.edit()
                editor.putString("ThemePril", "black")
                editor.apply()
            }
            else if (namberPromo == 2) {
                val VhodIntent = Intent(this, RegistrVhod::class.java)
                startActivity(VhodIntent)
                namberPromo += 1

            }
        }

    }
}