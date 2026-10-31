package com.davidchura.proyectoloki

import android.content.Intent
import com.davidchura.proyectoloki.components.BottomNavigationBar
import com.davidchura.proyectoloki.screens.PerfilActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Gamepad
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidchura.proyectoloki.screens.videojuegos.VideojuegosActivity
import com.davidchura.proyectoloki.ui.theme.GameOnBackground
import com.davidchura.proyectoloki.ui.theme.GameOnPurple
import com.davidchura.proyectoloki.ui.theme.GameOnPurpleBright
import com.davidchura.proyectoloki.ui.theme.GameOnSurface
import com.davidchura.proyectoloki.ui.theme.GameOnSurface2
import com.davidchura.proyectoloki.ui.theme.GameOnText
import com.davidchura.proyectoloki.ui.theme.GameOnTextSecondary
import com.davidchura.proyectoloki.ui.theme.ProyectoLokiTheme
import com.davidchura.proyectoloki.ui.theme.Urbanist
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

private val BorderColor = Color(0xFF252039)
private val Muted = Color(0xFF6F6B82)
private val PurpleDark = Color(0xFF28144F)

class GamesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoLokiTheme {
                GamesScreen(
                    onBackClick = {
                        finish()
                    },
                    onVideojuegosClick = {
                        startActivity(
                            Intent(
                                this,
                                VideojuegosActivity::class.java
                            )
                        )
                    },
                    onHomeClick = {
                        startActivity(
                            Intent(
                                this,
                                DashboardActivity::class.java
                            )
                        )
                    },
                    onProfileClick = {
                    }
                )
            }
        }
    }
}
@Composable
fun GamesScreen(
    onBackClick: () -> Unit,
    onVideojuegosClick: () -> Unit,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GameOnBackground)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(18.dp))

            // CABECERA
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        onBackClick()
                    },
                    modifier = Modifier.size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                        tint = GameOnText,
                        modifier = Modifier.size(28.dp)
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(38.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Más opciones",
                        tint = GameOnText
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            // PERFIL
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    PurpleDark,
                                    GameOnPurple,
                                    Color(0xFF17152C)
                                )
                            )
                        )
                        .border(
                            width = 1.dp,
                            color = GameOnPurpleBright,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.SportsEsports,
                        contentDescription = "Avatar",
                        tint = GameOnText,
                        modifier = Modifier.size(34.dp)
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Dennis",
                        fontFamily = Urbanist,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = GameOnText
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Level 24",
                        fontFamily = Urbanist,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = GameOnTextSecondary
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(GameOnSurface2)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.72f)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(GameOnPurpleBright)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {  },
                        modifier = Modifier.size(38.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Videojuegos",
                            tint = GameOnPurpleBright,
                            modifier = Modifier.size(21.dp)
                        )
                    }
                    Text(
                        text = "12,450 / 10,000 XP",
                        fontFamily = Urbanist,
                        fontSize = 7.sp,
                        color = Muted
                    )
                }
            }
            Spacer(modifier = Modifier.height(22.dp))

            // ESTADÍSTICAS
            StatsCard()
            Spacer(modifier = Modifier.height(24.dp))

            // FAVORITE GAMES
            SectionHeader(
                title = "Favorite Games",
                action = "See all",
                onClick = onVideojuegosClick
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                FavoriteGameCard(
                    title = "Valorant",
                    image = R.drawable.valoranticon,
                    modifier = Modifier.weight(1f)
                )
                FavoriteGameCard(
                    title = "Apex Legends",
                    image = R.drawable.apexicon,
                    modifier = Modifier.weight(1f)
                )
                FavoriteGameCard(
                    title = "Call of Duty",
                    image = R.drawable.codicon,
                    modifier = Modifier.weight(1f)
                )
                FavoriteGameCard(
                    title = "Fortnite",
                    image = R.drawable.fortniteicon,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))

            // RECENT ACTIVITY
            Text(
                text = "Recent Activity",
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = GameOnText
            )
            Spacer(modifier = Modifier.height(10.dp))

            ActivityCard(
                icon = Icons.Default.EmojiEvents,
                title = "Won a match in Apex Legends",
                time = "2m ago"
            )
            ActivityCard(
                icon = Icons.Default.Gamepad,
                title = "Unlocked achievement \"Apex Predator\"",
                time = "2h ago"
            )
            ActivityCard(
                icon = Icons.Default.Person,
                title = "Reached Level 24",
                time = "3h ago"
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        // BARRA INFERIOR
        BottomNavigationBar(
            selectedItem = "Profile",
            onHomeClick = onHomeClick,
            onGamesClick = onVideojuegosClick,
            onProfileClick = onProfileClick
        )
    }
}
@Composable
fun StatsCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(GameOnSurface)
            .border(
                width = 1.dp,
                color = BorderColor,
                shape = RoundedCornerShape(14.dp)
            )
            .padding(vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem(
            value = "530",
            label = "Matches"
        )
        StatItem(
            value = "312",
            label = "Wins"
        )
        StatItem(
            value = "58.9%",
            label = "Win Rate"
        )
        StatItem(
            value = "1.85",
            label = "K/D Ratio"
        )
    }
}
@Composable
fun StatItem(
    value: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = GameOnText
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            fontFamily = Urbanist,
            fontSize = 9.sp,
            color = GameOnTextSecondary
        )
    }
}
@Composable
fun SectionHeader(
    title: String,
    action: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = GameOnText,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = action,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = GameOnPurpleBright,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(PurpleDark)
                .padding(
                    horizontal = 8.dp,
                    vertical = 5.dp
                )
        )
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(28.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Ver todos",
                tint = GameOnPurpleBright,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
@Composable
fun FavoriteGameCard(
    title: String,
    image: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(GameOnSurface)
            .border(
                width = 1.dp,
                color = BorderColor,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp
                    )
                ),
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = GameOnText,
            maxLines = 1,
            modifier = Modifier.padding(
                horizontal = 7.dp,
                vertical = 8.dp
            )
        )
    }
}
@Composable
fun ActivityCard(
    icon: ImageVector,
    title: String,
    time: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(9.dp))
                .background(GameOnSurface2),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = GameOnPurpleBright,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = title,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 11.sp,
            color = GameOnText,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = time,
            fontFamily = Urbanist,
            fontSize = 9.sp,
            color = Muted
        )
    }
}
