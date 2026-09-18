package com.example.assignment0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.example.assignment0.ui.theme.Assignment0Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment0Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen()
                }
            }
        }
    }
}


@Composable
fun Screen(
    modifier: Modifier = Modifier
) {
    var outputText by remember { mutableStateOf<String>("Should we go?") }
    var clickCount by remember { mutableIntStateOf(0) }

    // https://www.google.com/search?q=kotlin+function+with+25%25+chance+of+picking+a+certain+output&sca_esv=1a1cf151c48bf507&biw=2560&bih=1351&sxsrf=APpeQnt2pa4IgU-IYdKjJVMzp4TrIP4Z8Q%3A1789686727496&ei=x3Osat3rHdTz0PEPtrjogAw&ved=2ahUKEwid65rN3vaWAxXUOTQIHTYcGsAQ4dUDegQIBhAM&uact=5&oq=kotlin+function+with+25%25+chance+of+picking+a+certain+output&gs_lp=Egxnd3Mtd2l6LXNlcnAiO2tvdGxpbiBmdW5jdGlvbiB3aXRoIDI1JSBjaGFuY2Ugb2YgcGlja2luZyBhIGNlcnRhaW4gb3V0cHV0MgUQABjvBTIFEAAY7wVI1RRQqw9Y9g9wAXgBkAEAmAHbAaABlQOqAQUwLjEuMbgBA8gBAPgBAZgCAqACwQHCAgoQIxjwBRiwAxgnwgIKEAAYRxjWBBiwA5gDAIgGAZAGA5IHAzEuMaAHuASyBwMwLjG4B70BwgcDMC4yyAcEgAgB&sclient=gws-wiz-serp
    // i googled this to figure out what kotlin import is used for random choices and how i can structure the function
    fun yes() {
        outputText = if (Random.nextBoolean()) {
            "Yes"
        } else {
            "No"
        }
    }

    fun maybe() {
        outputText = if (Random.nextDouble() < 0.25) {
            "Yes"
        } else {
            "No"
        }
    }

    fun no() {
        outputText = if (Random.nextDouble() < 0.10) {
            "Yes"
        } else {
            "No"
        }
    }

    Column(modifier = modifier.fillMaxSize()) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 32.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = "Shenura Mendis\n(CCID: wmendis)\n(Num: 1851907)", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = outputText, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    clickCount += 1
                    yes()
                    }

            ) {
                Text("Yes")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    clickCount += 1
                    maybe()
                }

            ) {
                Text("Maybe")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    clickCount += 1
                    no()
                }

            ) {
                Text("No")
            }
        }

        Row (
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Click Count: $clickCount", fontSize = 18.sp)
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = {
                    clickCount = 0
                    outputText = "Should we go?"
                }

            ) {
                Text("Reset")
            }

    }
}}