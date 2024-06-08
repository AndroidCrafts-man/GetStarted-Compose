package com.compose.gettingstartedwithcompose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Greeting() {
    val isOpen = remember {
        mutableStateOf(false)
    }
    Surface(
        shadowElevation = 9.dp,
        color = colorResource(id = R.color.white),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(12.dp),
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.cropped_profile_picture_round_color),
                contentDescription = null,
                modifier = Modifier.size(120.dp),
            )

            Divider()
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_github),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                )
                Text(text = "My Github")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(12.dp)
                )
                Text(text = "My Instagram")

            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { isOpen.value =!isOpen.value
                Log.d("checl", "${isOpen.value} ")
            }) {
                Text(text = "Show")
            }
            if (isOpen.value) {
                Log.d("checl", "if: ")
                LazyColumn {
                    items(dataProvider()) {
                        ProjectItem(it)
                    }
                }
            } else {
                Log.d("checl", "else: ")
            }

        }
    }

}


@Composable
fun ProjectItem(projectModel: ProjectModel) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp),
        color = colorResource(id = R.color.teal_200),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(
                painter = painterResource(id = R.drawable.cropped_profile_picture_round_color),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(5.dp),
            )
            Column() {
                Text(
                    text = projectModel.name,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = projectModel.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

data class ProjectModel(val name: String, val description: String)

fun dataProvider(): List<ProjectModel> {
    return listOf(
        ProjectModel("saeed", "i love android"),
        ProjectModel("ali", "i love android"),
        ProjectModel("fahad", "i love android"),
        ProjectModel("naveed", "i love android"),
        ProjectModel("asara", "i love android"),
        ProjectModel("no name", "i love android"),
        ProjectModel("khani", "i love android"),
        ProjectModel("no", "i love android"),
        ProjectModel("saeed", "i love android"),
        ProjectModel("haa", "i love android"),
        ProjectModel("saeed", "i love android"),
    )
}