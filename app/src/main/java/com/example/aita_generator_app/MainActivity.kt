package com.example.aita_generator_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.aita_generator_app.ui.theme.AITA_generator_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AITA_generator_appTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //val sample1 = SampleThing(5, "sweet")

                    val vm = ViewModelProvider(this)[SampleViewModel::class.java]

                    Greeting(
                        vm.mobGen,
                        clickHandle1 = {vm.handleAction( SampleViewModel.Action.ButtonOne)},
                        clickHandle2 = {vm.handleAction( SampleViewModel.Action.ButtonTwo)}
                        )
                }
            }
        }
    }
}

data class SampleThing(val fish: Int, val cookies:String = "default")


@Composable
fun RandoClick( clickHandle:()->Unit, displayName: String = "default"){
Button( onClick = clickHandle, modifier = Modifier.padding(10.dp) ){
    Text(displayName)
}


}

@Composable
fun Greeting(name: String, clickHandle1:()->Unit, clickHandle2:()->Unit, modifier: Modifier = Modifier) {

    Column() {
        Text(

            //text = "Hello ${name}, ${sample.cookies}!",
            text = "I don't know how to feel about Minecraft, I'm so scared of the $name",
            modifier = modifier
        )
        Row(horizontalArrangement = Arrangement.Center){
            RandoClick(clickHandle1, displayName = "Scared")
            RandoClick(clickHandle2, displayName = "Cute")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AITA_generator_appTheme {
        //val sample2 = SampleThing(5, "sweet")
        Greeting("Android", {}, {} )
    }
}