package com.davidchura.proyectoloki

import android.content.Intent
import com.davidchura.proyectoloki.components.BottomNavigationBar
import com.davidchura.proyectoloki.GamesActivity
import com.davidchura.proyectoloki.screens.videojuegos.VideojuegosActivity
import com.davidchura.proyectoloki.screens.PerfilActivity
import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidchura.proyectoloki.ui.theme.ProyectoLokiTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

private val Background = Color(0xFF05040A)
private val Card = Color(0xFF0E0D1C)
private val Card2 = Color(0xFF151329)
private val Purple = Color(0xFF7C3AED)
private val PurpleLight = Color(0xFF9333EA)
private val White = Color(0xFFFFFFFF)
private val Gray = Color(0xFFA5A1B5)

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoLokiTheme {
                GameOnHome(
                    onGamesClick = {
                        startActivity(
                            Intent(
                                this,
                                VideojuegosActivity::class.java
                            )
                        )
                    },
                    onNotificationClick = {
                    },
                    onProfileClick = {
                        startActivity(
                            Intent(
                                this,
                                GamesActivity::class.java
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun GameOnHome(
    onGamesClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
        ) {
        Spacer(modifier = Modifier.height(18.dp))

        // LOGO

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.SportsEsports,
                contentDescription = null,
                tint = PurpleLight,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "GAMEON",
                color = White,
                fontSize = 17.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        // HERO

        Text(
            text = "Next Level",
            color = White,
            fontSize = 38.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Black
        )
        Text(
            text = "Gaming",
            color = PurpleLight,
            fontSize = 38.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Black
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "All your games, stats, friends\nand rewards in one place.",
            color = Gray,
            fontSize = 15.sp,
            lineHeight = 22.sp
        )
        Spacer(modifier = Modifier.height(18.dp))

        Box(
            modifier = Modifier
                .width(38.dp)
                .height(4.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(PurpleLight)
        )
        Spacer(modifier = Modifier.height(22.dp))

        // TRES BOTONES

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            HomeAction(
                modifier = Modifier.weight(1f),
                icon = "🎮",
                title = "Play",
                subtitle = "Explore\ntournaments"
            )
            HomeAction(
                modifier = Modifier.weight(1f),
                icon = "⚔",
                title = "Compete",
                subtitle = "Challenge\nplayers"
            )
            HomeAction(
                modifier = Modifier.weight(1f),
                icon = "🏆",
                title = "Win",
                subtitle = "Earn\nrewards"
            )
        }
        Spacer(modifier = Modifier.height(25.dp))

        // PERFIL

            ProfileCard(
                onNotificationClick = onNotificationClick
            )
        Spacer(modifier = Modifier.height(22.dp))

        // BUSCADOR
        SearchBox()
        Spacer(modifier = Modifier.height(22.dp))

        // JUEGO DESTACADO
        FeaturedGame()
        Spacer(modifier = Modifier.height(28.dp))

        // TOP GAMES
        SectionTitle(
            title = "Top Games",
            onClick = { }
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                GameMiniCard(
                    imageRes = R.drawable.valoranticon,
                    title = "Valorant",
                    rating = "4.8"
                )
            }
            item {
                GameMiniCard(
                    imageRes = R.drawable.apexicon,
                    title = "Apex Legends",
                    rating = "4.6"
                )
            }
            item {
                GameMiniCard(
                    imageRes = R.drawable.fortniteicon,
                    title = "Fortnite",
                    rating = "4.7"
                )
            }
            item {
                GameMiniCard(
                    imageRes = R.drawable.pubgicon,
                    title = "PUBG Mobile",
                    rating = "4.5"
                )
            }
        }
        Spacer(modifier = Modifier.height(28.dp))

        // LIVE TOURNAMENTS

        SectionTitle(
            title = "Live Tournaments",
            onClick = {}
        )

        Spacer(modifier = Modifier.height(12.dp))

        TournamentCard()

        Spacer(modifier = Modifier.height(28.dp))

        // RECOMMENDED
        SectionTitle(
            title = "Recommended for you",
            onClick = { }
        )
        Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    RecommendationCard(
                        title = "GTA V",
                        rating = "4.8",
                        image = R.drawable.gtaicon
                    )
                }
                item {
                    RecommendationCard(
                        title = "Elden Ring",
                        rating = "4.9",
                        image = R.drawable.eldenringicon
                    )
                }
            }
            Spacer(modifier = Modifier.height(110.dp))
        }
        BottomNavigationBar(
            selectedItem = "Home",
            onHomeClick = {},
            onGamesClick = onGamesClick,
            onProfileClick = onProfileClick
        )
    }
}

// ACTION CARD
@Composable
fun HomeAction(
    modifier: Modifier = Modifier,
    icon: String,
    title: String,
    subtitle: String
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Card)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = icon,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = title,
            color = White,
            fontSize = 14.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = subtitle,
            color = Gray,
            fontSize = 10.sp,
            lineHeight = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

// PROFILE CARD
@Composable
fun ProfileCard(
    onNotificationClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(Card)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(
                    Brush.linearGradient(
                        listOf(Purple, PurpleLight)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = White,
                modifier = Modifier.size(27.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = "Hi, Dennis!",
                color = White,
                fontSize = 15.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
            Text(
                text = "Level 24",
                color = Gray,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onNotificationClick
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = PurpleLight
            )
        }
    }
}

// SEARCH
@Composable
fun SearchBox() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(Card2)
            .padding(horizontal = 15.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            tint = Gray,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "Search games, users...",
            color = Gray,
            fontSize = 13.sp
        )
    }
}

// FEATURED GAME
@Composable
fun FeaturedGame() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(18.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.codportada),
            contentDescription = "Call of Duty",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color(0xCC05040A)
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Call of Duty",
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "MW III",
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Purple)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
            ) {
                Text(
                    text = "Play Now",
                    color = White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// SECTION TITLE
@Composable
fun SectionTitle(
    title: String,
    imageRes: Int? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (imageRes != null) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(22.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = title,
            color = White,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onClick) {
            Text(
                text = "See all",
                color = PurpleLight,
                fontSize = 11.sp
            )
        }
    }
}
// GAME CARD
@Composable
fun GameMiniCard(
    title: String,
    rating: String,
    imageRes: Int? = null
) {
    Column(
        modifier = Modifier
            .width(105.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(Card)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Card2),
            contentAlignment = Alignment.Center
        ) {
            if (imageRes != null) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            color = White,
            fontSize = 11.sp,
            maxLines = 1
        )
        Text(
            text = "★ $rating",
            color = Color(0xFFFACC15),
            fontSize = 10.sp
        )
    }
}

// TOURNAMENT
@Composable
fun TournamentCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Card)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.valorantchampions),
            contentDescription = "Valorant",
            modifier = Modifier
                .size(65.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Valorant Champions Tour",
                color = White,
                fontSize = 13.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
            Text(
                text = "Live Tournament",
                color = Gray,
                fontSize = 10.sp
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "$50,000",
                color = Color(0xFF22C55E),
                fontSize = 13.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Purple)
                .padding(horizontal = 13.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Watch",
                color = White,
                fontSize = 11.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
    }
}
// RECOMMENDATION
@Composable
fun RecommendationCard(
    title: String,
    rating: String,
    image: Int
) {
    Row(
        modifier = Modifier
            .width(190.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(Card)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = title,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Text(
                text = title,
                color = White,
                fontSize = 12.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
            Text(
                text = "★ $rating",
                color = Color(0xFFFACC15),
                fontSize = 10.sp
            )
        }
    }
}
