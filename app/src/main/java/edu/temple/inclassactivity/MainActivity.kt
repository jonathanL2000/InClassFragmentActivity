package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        //tell the ViewModelProvider what you want to scope against, in this case, the main activity
        //this is because we want the fragments to be able to access the data
        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        //puts the livedata in the viewmodel
        mainViewModel.setImageIDs(imageArray)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, ImageDisplayFragment())
            .commit()
    }
}