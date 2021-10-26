package com.jacksonfdam.methoring.lab01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jacksonfdam.methoring.lab01.databinding.ActivityMainBinding
import dagger.Component
import javax.inject.Inject

/*
https://developer.android.com/topic/libraries/view-binding
https://medium.com/androiddevelopers/use-view-binding-to-replace-findviewbyid-c83942471fc

 */
class MainActivity : AppCompatActivity() {
    /*
    Was
    val info = Info()
     */

    @Inject
    lateinit var info: Info

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        DaggerMagicBox.create().poke(this)
        setContentView(view)
        // view.textView.text = info.text
    }
}


@Component
interface MagicBox {
    fun poke(app: MainActivity)
}

/*
Was
class Info  {
    val text = "Hello Dagger 2"
}
 */
class Info @Inject constructor() {
    val text = "Hello Dagger 2"
}
