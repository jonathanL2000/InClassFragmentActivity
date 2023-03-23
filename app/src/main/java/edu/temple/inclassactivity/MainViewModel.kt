package edu.temple.inclassactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val imageIDs = MutableLiveData<IntArray>()
    //setter method
    fun setImageIDs(imageIDs: IntArray) {
        this.imageIDs.value = imageIDs
    }
    /*
    getter, do NOT want to return "mutable" LiveData, as we do not
    want to be able to manipulate the data with this function
    */
    fun getImageIDs(): LiveData<IntArray> {
         return imageIDs
     }
}