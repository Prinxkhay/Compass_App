package com.example.compassapp

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), SensorEventListener {

    var sensor: Sensor?= null
    var sensorManager: SensorManager? = null
    lateinit var compassImage: ImageView
    lateinit var rotationTV: TextView
    // track the degree of the sensor
    var currentDegree = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ORIENTATION)

        compassImage = findViewById(R.id.imageView7)
        rotationTV = findViewById(R.id.textView6)
    }

    override fun onSensorChanged(event: SensorEvent?) {

        var degree = Math.round(event!!.values[0])
        rotationTV.text = "Rotation: $degree degrees"
        var rotationAnimation = RotateAnimation(currentDegree, (-degree).toFloat(),
            Animation.RELATIVE_TO_SELF.toFloat(), 0.5f,)

        rotationAnimation.duration = 500
        rotationAnimation.fillAfter = true
        currentDegree = (-degree).toFloat()
        compassImage.startAnimation(rotationAnimation)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
    // Register a listener for the sensor.
    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }
}