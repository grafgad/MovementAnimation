package com.example.movementanimation

import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movementanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

//    private val handler = Handler(Looper.getMainLooper())
//    private var _binding: ActivityMainBinding? = null
//    private val binding = _binding!!

    private val binding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//    }


}