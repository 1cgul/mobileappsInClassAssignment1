package edu.farmingdale.bcs371_w7_demo_nav

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.farmingdale.bcs371_w7_demo_nav.ui.theme.BCS371_W7_Demo_NavTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BCS371_W7_Demo_NavTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicOperations(
                        name = "Activity 1",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicOperations(name: String, modifier: Modifier = Modifier) {
    val  context = LocalContext.current
    var checked by remember { mutableStateOf(true)}

    Column {
        Spacer(modifier = Modifier.padding(50.dp))
        Button( onClick = {
            val newInt = Intent(Intent.ACTION_VIEW)
            newInt.setData(Uri.parse("geo:0,0?q=Farmingdale State College, NY"))
            context.startActivity(newInt)
        },
            modifier= Modifier.padding(start = 40.dp, end = 40.dp), enabled = checked) {
            Icon( imageVector = Icons.Default.LocationOn, contentDescription = "Location")
            Text("Show me  Farmingdale", modifier = Modifier.padding(start = 10.dp))
        }
        HorizontalDivider(thickness = DividerDefaults.Thickness)

        Button( onClick = {
            val phoneNumber = "tel:0000000000"
           // val url = "https://www.farmingdale.edu"
            val newInt = Intent(Intent.ACTION_VIEW, Uri.parse(phoneNumber))
            // val newInt = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            // ToDo 1: create implicit intent to open a web page or call a phone number

            context.startActivity(newInt)
        },
            modifier= Modifier.padding(start = 40.dp, end = 40.dp), enabled = checked) {
            Icon( imageVector = Icons.Default.Phone, contentDescription = "Phone")
            Text("Call Me", modifier = Modifier.padding(start = 10.dp))
        }

        HorizontalDivider(thickness = DividerDefaults.Thickness)

        Button( onClick = {
            // ToDo 2: create explicit intent to open a new activity
            context.startActivity(Intent(context, MainActivity::class.java))
        },
            modifier= Modifier.padding(start = 40.dp, end = 40.dp), enabled = checked) {
            Icon( imageVector = Icons.Default.Info, contentDescription = "Phone")
            //Spacer(modifier = Modifier.width(10.dp))
            Text("Go To activity 2", modifier = Modifier.padding(start = 10.dp))
        }
        HorizontalDivider(thickness = DividerDefaults.Thickness)


        Switch(
            checked = checked,
            onCheckedChange = {checked = it},
            modifier = Modifier.padding(10.dp),
        )
    }


}

@Preview(showBackground = true)
@Composable
fun BasicOperationsPreview() {
    BCS371_W7_Demo_NavTheme {
        BasicOperations("Android")
    }
}