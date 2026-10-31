package com.davidchura.proyectoloki.screens.videojuegos

import android.os.Bundle
import android.content.Intent
import com.davidchura.proyectoloki.DashboardActivity
import com.davidchura.proyectoloki.GamesActivity
import com.davidchura.proyectoloki.components.BottomNavigationBar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidchura.proyectoloki.models.Videojuego
import com.davidchura.proyectoloki.ui.theme.GameOnBackground
import com.davidchura.proyectoloki.ui.theme.GameOnBorder
import com.davidchura.proyectoloki.ui.theme.GameOnPurple
import com.davidchura.proyectoloki.ui.theme.GameOnPurpleBright
import com.davidchura.proyectoloki.ui.theme.GameOnSurface
import com.davidchura.proyectoloki.ui.theme.GameOnSurface2
import com.davidchura.proyectoloki.ui.theme.GameOnText
import com.davidchura.proyectoloki.ui.theme.GameOnTextSecondary
import com.davidchura.proyectoloki.ui.theme.ProyectoLokiTheme
import com.davidchura.proyectoloki.ui.theme.Urbanist
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mielsen.alwaysdata.net/"

private interface VideojuegosApi {

    @GET("videojuegos.php")
    suspend fun getVideojuegos(): List<Videojuego>
}

private object VideojuegosApiClient {
    val api: VideojuegosApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VideojuegosApi::class.java)
    }
}

class VideojuegosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProyectoLokiTheme {
                VideojuegosScreen(
                    onBack = {
                        finish()
                    },
                    onHomeClick = {
                        startActivity(
                            Intent(this, DashboardActivity::class.java)
                        )
                        finish()
                    },
                    onGamesClick = {
                    },
                    onProfileClick = {
                        startActivity(
                            Intent(this, GamesActivity::class.java)
                        )
                        finish()
                    }
                )
            }
        }
    }
}
@Composable
private fun VideojuegosScreen(
    onBack: () -> Unit,
    onHomeClick: () -> Unit,
    onGamesClick: () -> Unit,
    onProfileClick: () -> Unit
) {

    var videojuegos by remember {
        mutableStateOf<List<Videojuego>>(emptyList())
    }

    var cargando by remember {
        mutableStateOf(true)
    }

    var error by remember {
        mutableStateOf<String?>(null)
    }

    var recarga by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(recarga) {

        cargando = true

        try {

            videojuegos = VideojuegosApiClient.api.getVideojuegos()

            error = null

        } catch (e: Exception) {

            error = e.message
                ?: "No se pudo conectar con el servicio web."

        } finally {

            cargando = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GameOnBackground)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    end = 20.dp,
                    top = 18.dp,
                    bottom = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .background(GameOnSurface2)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = GameOnText
                )
            }
            Spacer(
                modifier = Modifier.width(14.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "VIDEOJUEGOS",
                    color = GameOnText,
                    fontFamily = Urbanist,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 0.5.sp
                )
                Spacer(
                    modifier = Modifier.height(2.dp)
                )
                Text(
                    text = "Catálogo de juegos",
                    color = GameOnTextSecondary,
                    fontFamily = Urbanist,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(
                            listOf(
                                GameOnPurple,
                                GameOnPurpleBright
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.SportsEsports,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            //Barra de Carga

            when {
                cargando -> {
                    Column(
                        modifier = Modifier.align(
                            Alignment.Center
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        CircularProgressIndicator(
                            color = GameOnPurpleBright,
                            strokeWidth = 3.dp,
                            modifier = Modifier.size(42.dp)
                        )

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        Text(
                            text = "Cargando videojuegos...",
                            color = GameOnTextSecondary,
                            fontFamily = Urbanist,
                            fontSize = 14.sp
                        )
                    }
                }
                error != null -> {
                    ErrorVideojuegos(
                        mensaje = error
                            ?: "Error desconocido",
                        onRetry = {
                            recarga++
                        }
                    )
                }
                videojuegos.isEmpty() -> {
                    EmptyVideojuegos()
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            top = 6.dp,
                            bottom = 24.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        items(
                            items = videojuegos,
                            key = {
                                it.id
                            }
                        ) { videojuego ->
                            VideojuegoCard(
                                videojuego = videojuego
                            )
                        }
                    }
                }
            }
        }
        BottomNavigationBar(
            selectedItem = "Games",
            onHomeClick = onHomeClick,
            onGamesClick = onGamesClick,
            onProfileClick = onProfileClick
        )
    }
}
@Composable
private fun VideojuegoCard(
    videojuego: Videojuego
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(20.dp)
            )
            .background(GameOnSurface)
            .border(
                width = 1.dp,
                color = GameOnBorder,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = videojuego.nombre,
                    color = GameOnText,
                    fontFamily = Urbanist,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
                Text(
                    text = videojuego.desarrollador,
                    color = GameOnTextSecondary,
                    fontFamily = Urbanist,
                    fontSize = 13.sp
                )
            }
            Row(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
                    .background(
                        GameOnPurple.copy(alpha = 0.18f)
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 7.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = GameOnPurpleBright,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(
                    modifier = Modifier.width(4.dp)
                )
                Text(
                    text = videojuego.rating.toString(),
                    color = GameOnText,
                    fontFamily = Urbanist,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(
            modifier = Modifier.height(18.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DatoVideojuego(
                etiqueta = "PLATAFORMA",
                valor = videojuego.plataforma,
                modifier = Modifier.weight(1f)
            )
            DatoVideojuego(
                etiqueta = "AÑO",
                valor = videojuego.anio.toString(),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DatoVideojuego(
                etiqueta = "DURACIÓN",
                valor = "${videojuego.duracion_horas} h",
                modifier = Modifier.weight(1f)
            )
            DatoVideojuego(
                etiqueta = "GÉNERO ID",
                valor = videojuego.id_genero.toString(),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(
            modifier = Modifier.height(14.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(GameOnBorder)
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
        Text(
            text = "PLATAFORMA",
            color = GameOnPurpleBright,
            fontFamily = Urbanist,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
        Spacer(
            modifier = Modifier.height(3.dp)
        )
        Text(
            text = videojuego.plataforma.ifBlank {
                "No disponible"
            },
            color = GameOnTextSecondary,
            fontFamily = Urbanist,
            fontSize = 13.sp
        )
    }
}
@Composable
private fun DatoVideojuego(
    etiqueta: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(12.dp)
            )
            .background(GameOnSurface2)
            .padding(
                horizontal = 12.dp,
                vertical = 10.dp
            )
    ) {
        Text(
            text = etiqueta,
            color = GameOnPurpleBright,
            fontFamily = Urbanist,
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.7.sp
        )
        Spacer(
            modifier = Modifier.height(3.dp)
        )
        Text(
            text = valor.ifBlank {
                "No disponible"
            },
            color = GameOnText,
            fontFamily = Urbanist,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
private fun EmptyVideojuegos() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(76.dp)
                .clip(CircleShape)
                .background(GameOnSurface2),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.SportsEsports,
                contentDescription = null,
                tint = GameOnPurpleBright,
                modifier = Modifier.size(38.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(18.dp)
        )
        Text(
            text = "No hay videojuegos",
            color = GameOnText,
            fontFamily = Urbanist,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier.height(6.dp)
        )
        Text(
            text = "No se encontraron juegos disponibles.",
            color = GameOnTextSecondary,
            fontFamily = Urbanist,
            fontSize = 13.sp
        )
    }
}
@Composable
private fun ErrorVideojuegos(
    mensaje: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(76.dp)
                .clip(CircleShape)
                .background(
                    GameOnPurple.copy(alpha = 0.15f)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.SportsEsports,
                contentDescription = null,
                tint = GameOnPurpleBright,
                modifier = Modifier.size(38.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(18.dp)
        )
        Text(
            text = "No se pudieron cargar",
            color = GameOnText,
            fontFamily = Urbanist,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "los videojuegos",
            color = GameOnText,
            fontFamily = Urbanist,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Text(
            text = mensaje,
            color = GameOnTextSecondary,
            fontFamily = Urbanist,
            fontSize = 12.sp
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(
                containerColor = GameOnPurple
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "Volver a intentar",
                color = Color.White,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
