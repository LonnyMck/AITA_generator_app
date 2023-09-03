package com.example.aita_generator_app

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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

                    AITAmain(
                        vm.starter,  vm.opinion, vm.commenter, vm.location, vm.involves,
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
Button( onClick = clickHandle,
    modifier = Modifier
        .fillMaxWidth(),

    //colors = ButtonDefaults.buttonColors(containerColor = Color.BLACK),
    shape = CutCornerShape(2),
    //colors =  ButtonDefaults.textButtonColors(Color.BLACK)


){

    Text(displayName,
        fontWeight = FontWeight.Bold,

    )
}


}


@Composable
fun AITAmain(starter: String, opinion: String, commenter: String, location:String, involves: String, clickHandle1:()->Unit, clickHandle2:()->Unit, modifier: Modifier = Modifier) {

    Column( modifier = Modifier.padding(40.dp) ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()


        ){
            RandoClick(clickHandle1, displayName = "AITA")
        }

        Column(
            Modifier.weight(1f)
        ){
        Text(
            text = "$starter...",
            modifier = modifier
        )

        Text(
            text = "Location: $location",
            modifier = modifier
        )

        Text(
            text = "Involves: $involves",
            modifier = modifier
        )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()


        ) {
            RandoClick(clickHandle2, displayName = "Comment")
        }
        Column(Modifier.weight(2f)){
        Text(
            text = "$commenter thinks $opinion because..."
        )
        }

    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AITA_generator_appTheme {
        //val sample2 = SampleThing(5, "sweet")
        AITAmain("I, 28F...",  "YTA", "A baby","funeral", "banana bread", {},{} )
    }
}