package com.example.ktoner.highscore

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var prefsEdit: SharedPreferences.Editor = prefs.edit()

        val btn: Button = findViewById(R.id.btn) as Button
        val scoreText: TextView = findViewById(R.id.score) as TextView
        val highScoreText: TextView = findViewById(R.id.highScore) as TextView

        var score: Int = 0
        var highScore: Int = prefs.getInt("highScore", 0)

        highScoreText.setText("HighScore: " + highScore.toString())
        scoreText.setText("Score: " + score.toString())

        btn.setOnClickListener {
            score++
            scoreText.setText("Score: " + score.toString())

            if (score >= highScore) {
                highScore = score
                highScoreText.setText("HighScore: " + highScore.toString())
                prefsEdit.putInt("highScore: ", highScore).commit()
            }
        }
    }
}
