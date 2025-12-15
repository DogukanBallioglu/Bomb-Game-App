package com.example.bombgameandroid

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.sync.Mutex



@Composable
fun MainMenu(modifier: Modifier) {

    var gameKey by remember { mutableStateOf(0) }
    var gameStarted by remember { mutableStateOf(false) }

    key(gameKey) {
        var bombSayisi by remember {mutableStateOf(value = 1)}
        val bombalar = remember(bombSayisi) {
            (1..28).shuffled().take(bombSayisi).toSet()
        }
        var score by remember { mutableStateOf(value = 0)}
        val Heavitas = FontFamily(Font(R.font.heavitas))



        val clickedList = remember {
            mutableStateListOf<Boolean>().apply {
                repeat(28) { add(false) }
            }
        }

        val isWrongList = remember {
            mutableStateListOf<Boolean>().apply {
                repeat(28) { add(false) }
            }
        }

        /**/

        var index = 0
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Spacer(modifier = Modifier.padding(35.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(450.dp,50.dp)
                // .background(Color.Gray)
            ){
                Text(
                    text = "Score: " + score,
                    fontFamily = Heavitas,
                    fontSize = 45.sp
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Press any button and start!",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.padding(25.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                for(i in 1..7){
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ){
                        for(j in 1..4){
                            val buttonIndex = index
                            val number = index + 1
                            index++

                            Spacer(modifier = Modifier.width(1.dp))
                            Button(
                                onClick = {

                                    if (!gameStarted) {
                                        gameStarted = true
                                    }

                                    if (!clickedList[buttonIndex]) {
                                        clickedList[buttonIndex] = true

                                        if (bombalar.contains(number)) {
                                            isWrongList[buttonIndex] = false
                                            gameStarted = false
                                            gameKey++   // oyun bitti
                                        } else {
                                            isWrongList[buttonIndex] = true
                                            score++
                                        }
                                    }
                                },

                                modifier = Modifier
                                    .padding(2.dp)
                                    .size(80.dp, 60.dp)
                                    .border(
                                        3.dp,
                                        Color.Gray,
                                        shape = RoundedCornerShape(5.dp)
                                    ),

                                colors = ButtonDefaults.buttonColors(
                                    containerColor = when {
                                        !clickedList[buttonIndex] -> Color.Black
                                        isWrongList[buttonIndex] -> Color.Green
                                        else -> Color.Red
                                    }
                                ),
                                shape = RoundedCornerShape(5.dp)

                            ) {
                                Text(
                                    text = number.toString()
                                )
                            }
                            Spacer(modifier = Modifier.width(1.dp))

                        }}

                    Spacer(modifier = Modifier.height(2.dp))
                }}

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    if (gameStarted) {
                        gameStarted = false
                    }
                    gameKey++ },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = Modifier
                    .size(300.dp,60.dp),

                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Restart",
                    fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.height(25.dp))


            Row(
                horizontalArrangement = Arrangement.Center

            ){
                Button(
                    onClick = { if (bombSayisi > 1) bombSayisi-- },
                    enabled = !gameStarted,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (gameStarted) Color.Gray else Color.Red
                    ),
                    shape = RoundedCornerShape(5.dp)

                ) {
                    Text(
                        text = "-",
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    text = "Bomba Sayısı: " + bombSayisi,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    onClick = {
                        if (bombSayisi < 5) bombSayisi++ },
                    enabled = !gameStarted,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (gameStarted) Color.Gray else Color.Green
                    ),                    shape = RoundedCornerShape(5.dp)

                ) {
                    Text(
                        text = "+",
                        fontSize = 20.sp
                    )
                }

                /*Text(
                    text = "Bombalar: ${bombalar.joinToString()}",
                    color = Color.Red,
                    fontSize = 14.sp
                )*/

            }

        }
    }

}

