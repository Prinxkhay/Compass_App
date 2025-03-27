🌍 Compass App
A simple Android app that functions as a digital compass using the device's accelerometer and magnetometer.

🚀 Features
✅ Real-time compass rotation based on sensor data
✅ Smooth rotation animation
✅ Minimalist design with a white background for a clean look
✅ Uses device's accelerometer and magnetometer for accurate orientation

📸 Screenshots
 ![image](https://github.com/user-attachments/assets/7fb0b0c5-b405-462a-911b-4566e24bacb2)
 ![image](https://github.com/user-attachments/assets/fcf777d3-19e6-4e0d-953d-153c108211f3)


 
🛠️ How It Works
The app calculates the orientation of the device using:
•	Accelerometer – Detects the device's movement and tilt.
•	Magnetometer – Measures the Earth's magnetic field to determine the direction.
The rotation is calculated using SensorManager.getRotationMatrix() and SensorManager.getOrientation() methods. The compass image rotates smoothly based on the calculated degree.

💻 Tech Stack
•	Kotlin – Primary programming language
•	Android Studio – Development environment
•	Material Design – For UI consistency

🏆 How to Use
1.	Open the app.
2.	Allow necessary permissions (if prompted).
3.	Hold your phone flat and point it in any direction — the compass will rotate automatically!

🐞 Known Issues
•	Compass accuracy may vary depending on the magnetic interference in the environment.
•	Some devices may have compatibility issues with the sensor readings.

🙌 Contributing
Feel free to submit a pull request or open an issue if you’d like to improve the project!

