package com.davidchura.proyectoloki

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidchura.proyectoloki.ui.theme.GameOnBackground
import com.davidchura.proyectoloki.ui.theme.GameOnPurple
import com.davidchura.proyectoloki.ui.theme.GameOnText
import com.davidchura.proyectoloki.ui.theme.ProyectoLokiTheme
import com.davidchura.proyectoloki.ui.theme.Urbanist

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProyectoLokiTheme {
                MainScreen(
                    onEnterClick = {
                        startActivity(
                            Intent(
                                this,
                                DashboardActivity::class.java
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    onEnterClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GameOnBackground)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "GAMEON",
            fontFamily = Urbanist,
            fontWeight = FontWeight.Black,
            fontSize = 42.sp,
            color = GameOnText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "NEXT LEVEL GAMING",
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = GameOnPurple
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onEnterClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = GameOnPurple
            )
        ) {
            Text(
                text = "ENTRAR",
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}