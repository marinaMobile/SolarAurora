package com.tencent.igh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.tencent.igh.databinding.ActivitySolarGameBinding
import java.util.*

class SolarGame : AppCompatActivity() {
    lateinit var bindGame: ActivitySolarGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindGame = ActivitySolarGameBinding.inflate(layoutInflater)
        setContentView(bindGame.root)
        var counter: Int = 0
        var counter1: Int = 0
        var counter2: Int = 0

        bindGame.tr1.setOnClickListener{
            counter++
            bindGame.trTitle.text = counter.toString()
        }

        bindGame.tr2.setOnClickListener{
            counter1++
            bindGame.tr1Title.text = counter1.toString()
        }

        bindGame.tr3.setOnClickListener{
            counter2++
            bindGame.tr2Title.text = counter2.toString()
        }

        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.background.width-bindGame.tr1.width)
                    val dy: Float = rand.nextFloat() * (bindGame.background.height-bindGame.tr1.height)
                    bindGame.tr1.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(200)
                        .start()
                }
            }
        }, 0, 1000)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.background.width-bindGame.tr1.width)
                    val dy: Float = rand.nextFloat() * (bindGame.background.height-bindGame.tr1.height)
                    bindGame.tr2.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(300)
                        .start()
                }
            }
        }, 0, 1000)


        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.background.width-bindGame.tr2.width)
                    val dy: Float = rand.nextFloat() * (bindGame.background.height-bindGame.tr2.height)
                    bindGame.tr3.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(200)
                        .start()
                }
            }
        }, 0, 1000)

    }
}