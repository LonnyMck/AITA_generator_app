package com.example.aita_generator_app

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import kotlin.random.Random.Default.nextInt

class SampleViewModel (
    app: Application
): AndroidViewModel( app ){
    var mobGen by mutableStateOf("n/a")

    fun handleAction( action: Action ){
        when(action){
            Action.ButtonOne -> randoClick1()
            Action.ButtonTwo -> randoClick2()
        }
    }

    fun randoClick1(){
        val option = nextInt(0, LISTONE.size)
        mobGen = LISTONE[option]
    }

    fun randoClick2(){
        val option = nextInt(0, LISTTWO.size)
        mobGen = LISTTWO[option]
    }



    sealed class Action {
        object ButtonOne: Action()
        object ButtonTwo: Action()
    }

    companion object {
        val LISTONE = listOf<String>("zombies", "skeletons", "witches", "phantoms", "creepers")
        val LISTTWO = listOf<String>("villagers", "dolphins", "sheep", "foxes", "endermen")
    }
}