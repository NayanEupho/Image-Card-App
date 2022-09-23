package com.example.imagecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagecard.ui.theme.ImageCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.call_of_the_night) /* Resource id of our image*/
            val discription = "Night Ep 11"
            val title = "Call of The Night"
            
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)){

                ImageCard(painter = painter, content = discription, title = title)
            }

        }
    }
}

@Composable
// this makes the code more re usable
fun ImageCard(
    painter: Painter, /*Pinter is for using image from image resource */
    content: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(  /* used to make card component in jetpack compose*/
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        /* Here We want to stack the content so we use Box which is container */

        /* This box is for our image*/
        Box(modifier = Modifier
            .height(200.dp)
            .clickable { }){
            Image(painter = painter,
                contentDescription = content,
                contentScale = ContentScale.Crop /* To crop and scale our image */
            )

            /* Out gradiant*/
             /* This will be empty box that we only using for gradiant*/
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient( /* To define a gradiant */
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f /* Used to Start the gradiant so it starts from top to bottmon */
                    )
                ))

            /* We only want to align the text and not everything else in the box
            * so we create another box*/
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart /* This to align our content just like in row & col.*/
            ){
                Text(title,
                    style = TextStyle(color = Color.White), /* This to style our text*/
                    fontSize = 16.sp)

            }
        }
    }
}

