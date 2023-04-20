package com.a_lab.textarc

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekBar)

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                findViewById<LinearLayout>(R.id.textArcView).removeAllViews()

                findViewById<LinearLayout>(R.id.textArcView).addView(
                    TextArc(this@MainActivity).apply {
                        setText("Text arc that was added programmatically")
                        setRadius((resources.displayMetrics.density * progress).toInt())
                        setCenterAngle(-90)
                        setTextColor(R.color.blue)
                        setTextSize((resources.displayMetrics.density * 28).toInt())
                        setFontFamily(ResourcesCompat.getFont(this@MainActivity, R.font.krabuler))
                        layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        ).apply {
                            gravity = Gravity.CENTER_HORIZONTAL
                        }
                    }
                )
            }
        })


    }
}