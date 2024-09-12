package com.amitraj.constraintlayoutcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.amitraj.constraintlayoutcompose.ui.theme.ConstraintLayoutComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstraintLayoutComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ConstraintLayoutContent()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // this are the id reference (very important)
        val (text1, text2, text3, col) = createRefs()
        ConstraintLayout(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .background(color = Color.Cyan)
                    .constrainAs(text1) {
                        top.linkTo(parent.top)
                    },
                text = "FIRST"
            )
            Text(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Magenta)
                    .constrainAs(text2) {
                        top.linkTo(anchor = text1.bottom)
                        start.linkTo(anchor = text1.start)
                        end.linkTo(anchor = text1.end)
                        bottom.linkTo(anchor = text1.bottom)
                    },
                text = "SECOND"
            )
            Text(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .background(color = Color.Yellow)
                    .constrainAs(text3) {
                        top.linkTo(anchor = text2.bottom)
                        start.linkTo(anchor = text2.start)
                        end.linkTo(anchor = text2.end)
                    },
                text = "THIRD"
            )
            Column(
                modifier = Modifier
                    .width(150.dp)
                    .fillMaxHeight()
                    .background(color = Color.Green)
                    .constrainAs(col) {
                        top.linkTo(anchor = text3.bottom)
                        start.linkTo(anchor = text2.start)
                        end.linkTo(anchor = text2.end)
                    }
            ) {

            }
        }
    }
}