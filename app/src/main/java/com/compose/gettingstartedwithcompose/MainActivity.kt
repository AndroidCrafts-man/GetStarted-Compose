package com.compose.gettingstartedwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.gettingstartedwithcompose.ui.theme.GettingStartedWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainUi()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainUi( ) {
   var  names:List<String> = listOf("khan","ali")
    GettingStartedWithComposeTheme {
        Column(Modifier.padding(horizontal = 10.dp)) {
        for (name in names){
            Spacer(modifier = Modifier.height(10.dp))
                header(
                    name,
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Cyan)
                        .padding(10.dp)
                )
            }
        }

    }
}

@Composable
fun header(text:String,modifier1: Modifier) {
    var isexpanded= remember {
        mutableStateOf(false)
    }
    var extraPadding=if (isexpanded.value) 48.dp else 0.dp
  Box(modifier = modifier1)
  {
      Row {
          Column(modifier = Modifier.weight(1f).padding(extraPadding)) {
              Text(text = text)
              Text(text = "android")
          }

          ElevatedButton(onClick = { isexpanded.value = !isexpanded.value }) {
              Text(if (isexpanded.value) "Show less" else "Show more")

          }
      }
  }
}





