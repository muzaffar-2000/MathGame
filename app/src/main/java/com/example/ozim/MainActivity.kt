package com.example.ozim

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ozim.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var tjavob = 0

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mediaPlayer2:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tahminiysonlar()
        tekshirish()
    }
    fun tahminiysonlar(): String {
        val nomer1 = Random.nextInt(1,10)
        val nomer2 = Random.nextInt(1,10)
        val amal = Random.nextInt(4)
        var savollar = ""
        when (amal) {
            0 -> {
                savollar = "$nomer1+$nomer2"
                tjavob = nomer2+nomer1
                binding.savollar.text=savollar
            }

            1 -> { if (nomer1>=nomer2){
                savollar = "$nomer1-$nomer2"
                tjavob = nomer1-nomer2
                binding.savollar.text = savollar}
            else{
                savollar = "$nomer2-$nomer1"
                tjavob = nomer2-nomer1
                binding.savollar.text = savollar

            }

            }

            2 -> {
                savollar = "$nomer1*$nomer2"
                tjavob = nomer2*nomer1
                binding.savollar.text = savollar
            }

            3 -> {
                if (nomer1%nomer2==0){
                savollar = "$nomer1/$nomer2"
                tjavob = nomer2/nomer1
                binding.savollar.text = savollar
                }else{
                    tahminiysonlar()

                }

            }

        }
        return savollar
    }

    fun tekshirish() {
        mediaPlayer=MediaPlayer.create(this,R.raw.muzaffar)
        mediaPlayer2=MediaPlayer.create(this,R.raw.togri)


        binding.button.setOnClickListener {
            try {
                if (!binding.javobkiritadiganjoy.text.isNullOrEmpty()) {
                    if (binding.javobkiritadiganjoy.text.toString().toInt() == tjavob) {
                        mediaPlayer2.start()

                        Toast.makeText(this, "😎😎😎😎😎😎", Toast.LENGTH_SHORT).show()
                        tahminiysonlar()
                        binding.javobkiritadiganjoy.text.clear()

                    } else {
                        Toast.makeText(this, "🤬🤬🤬🤬🤬🤬", Toast.LENGTH_SHORT).show()
                        mediaPlayer.start()
                        binding.javobkiritadiganjoy.text.clear()
                        tahminiysonlar()
                    }
                } else {
                    Toast.makeText(this, "javobni kiriting", Toast.LENGTH_SHORT).show()
                }
            }catch (e:NumberFormatException){
                binding.javobkiritadiganjoy.text.clear()
                tahminiysonlar()
            }
        }

    }
}