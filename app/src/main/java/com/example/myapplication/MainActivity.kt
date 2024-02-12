package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.let {
            currentquestionindex = it.getInt("currentQuestionIndex", 0)
            score = it.getInt("score", 0)
            dispalyquestion()
        } ?: run {

            dispalyquestion()

        }
        binding.button.setOnClickListener {
            checkanswer(selectAnswerIndex = 0)
        }

        binding.button2.setOnClickListener {
            checkanswer(selectAnswerIndex = 1)

        }

        binding.button3.setOnClickListener {
            checkanswer(selectAnswerIndex = 2)


        }


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the current state of the quiz
        outState.putInt("currentQuestionIndex", currentquestionindex)
        outState.putInt("score", score)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore the saved state of the quiz
        currentquestionindex = savedInstanceState.getInt("currentQuestionIndex", 0)
        score = savedInstanceState.getInt("score", 0)
        dispalyquestion()
    }



    val questions = arrayOf(
        "What does ADB stand for?",
        "Which layout is best suited for complex UI designs with multiple nested views?",
        "Which component is responsible for managing the app's navigation and back stack?",
        "Which method is called when an activity is no longer visible to the user?",
        "Which permission is required for an app to access the device's camera?",
        "Which component is used to perform background tasks independently of the UI?",
        "Which method is used to inflate the layout XML resource in an Activity or Fragment?",
        "What does APK stand for in the context of Android development?",
        "Which tool is used to build user interfaces for Android applications?",
        "What is the purpose of the AndroidManifest.xml file?"
    )

    val options = arrayOf(
        arrayOf(
            "Android Development Board",
            "Android Debug Bridge",
            "Application Development Basics"
        ),
        arrayOf("LinearLayout", "RelativeLayout", "ConstraintLayout"),
        arrayOf("Activity", "Service", "Intent"),
        arrayOf("onStop()", "onPause()", "onDestroy()"),
        arrayOf("CAMERA", "WRITE_EXTERNAL_STORAGE", "INTERNET"),
        arrayOf("BroadcastReceiver", "Service", "ContentProvider"),
        arrayOf("inflateLayout()", "onCreateLayout()", "setContentView()"),
        arrayOf("Android Package Kit", "Android Programming Kit", "Application Package"),
        arrayOf("Android Studio", "IntelliJ IDEA", "Eclipse"),
        arrayOf(
            "To declare app's components and permissions",
            "To define layout of the app's UI",
            "To store string resources used in the app"
        )
    )


    val correctAnswers = arrayOf(1, 2, 0, 0, 0, 1, 2, 0, 0, 0)

    var currentquestionindex = 0
    var score = 0

    fun dispalyquestion() {

        binding.question.text = questions[currentquestionindex]


        binding.button.text = options[currentquestionindex][0]
        binding.button2.text = options[currentquestionindex][1]
        binding.button3.text = options[currentquestionindex][2]

    }

    @SuppressLint("SuspiciousIndentation")
    fun checkanswer(selectAnswerIndex: Int) {
        val currentanswerIndex = correctAnswers[currentquestionindex]

        if (selectAnswerIndex == currentanswerIndex)
            score++
        binding.button4.setOnClickListener {
            if (currentquestionindex < questions.size - 1) {
                currentquestionindex++
                dispalyquestion()


                if (selectAnswerIndex == currentanswerIndex)
                    Toast.makeText(this, "Correct  Answer :$score", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Wrong answerr ", Toast.LENGTH_SHORT).show()


            }


        }

        if (currentquestionindex == questions.size - 1) {

            val intent = Intent(this, resultscreen::class.java)

            intent.putExtra("scoreee", score)

            startActivity(intent)
            finish()
        }




    }

}













