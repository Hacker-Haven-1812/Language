package com.example.language

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var tvSelect: TextView
    private lateinit var tvOutput: TextView
    private lateinit var rgLanguage: RadioGroup
    private lateinit var rbEnglish: RadioButton
    private lateinit var rbHindi: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvSelect = findViewById(R.id.tv_select)
        rgLanguage = findViewById(R.id.rg_language)
        rbEnglish = findViewById(R.id.rb_english)
        rbHindi = findViewById(R.id.rb_hindi)
        tvOutput = findViewById(R.id.tv_output)

        rgLanguage.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_english -> setLocale("en")
                R.id.rb_hindi -> setLocale("hi")
            }
        }
    }

    private fun setLocale(language: String) {
        val resources: Resources = resources
        val metrics: DisplayMetrics = resources.displayMetrics
        val configuration: Configuration = resources.configuration

        val locale = Locale(language)
        Locale.setDefault(locale)
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, metrics)

        onConfigurationChanged(configuration)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Update UI text with the new language
        tvSelect.setText(R.string.select_language)
        rbEnglish.setText(R.string.english)
        rbHindi.setText(R.string.hindi)
        tvOutput.setText(R.string.is_test)
    }
}
