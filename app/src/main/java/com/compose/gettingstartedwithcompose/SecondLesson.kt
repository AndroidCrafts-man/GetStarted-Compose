package com.compose.gettingstartedwithcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun counter() {
    var counter = remember{
        mutableIntStateOf(1)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Text(text = "${counter.value}")
        Spacer(modifier = Modifier.height(180.dp))
        buttonClick {
            counter.value+=100
        }

    }
}

@Composable
fun buttonClick( onclick : ()->Unit){
    Card(
        modifier = Modifier
            .size(50.dp)
            .clickable {
                onclick.invoke()
            },
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Yellow)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Tap"
            )

        }
    }
}