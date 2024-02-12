package br.com.apkdoandroid.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.apkdoandroid.timer.databinding.ActivityMainBinding
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var timer : Timer
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            timer = Timer()
            timer.schedule(
                object  : TimerTask(){
                    override fun run() {
                        runOnUiThread{
                            binding.textView.text = "Executou ${contador}"
                        }
                        contador++
                    }

                },2000,1000
            )
        }

        binding.button2.setOnClickListener {
            binding.textView.text = "Finalizou"
                timer.cancel() }
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }
}