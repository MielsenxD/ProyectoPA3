package com.davidchura.proyectoloki.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidchura.proyectoloki.ui.theme.GameOnBackground
import com.davidchura.proyectoloki.ui.theme.GameOnPurpleBright
import com.davidchura.proyectoloki.ui.theme.Urbanist
import androidx.compose.ui.graphics.Color

private val Muted = Color(0xFF6F6B82)

@Composable
fun BottomNavigationBar(
    selectedItem: String,
    onHomeClick: () -> Unit,
    onGamesClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(GameOnBackground)
            .padding(
                horizontal = 10.dp,
                vertical = 10.dp
            ),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(
            icon = Icons.Default.Home,
            label = "Home",
            selected = selectedItem == "Home",
            onClick = onHomeClick
        )

        BottomNavItem(
            icon = Icons.Default.Gamepad,
            label = "Games",
            selected = selectedItem == "Games",
            onClick = onGamesClick
        )

        BottomNavItem(
            icon = Icons.Default.EmojiEvents,
            label = "Tournaments",
            selected = false,
            onClick = {}
        )

        BottomNavItem(
            icon = Icons.Default.Search,
            label = "Social",
            selected = false,
            onClick = {}
        )

        BottomNavItem(
            icon = Icons.Default.Person,
            label = "Profile",
            selected = selectedItem == "Profile",
            onClick = onProfileClick
        )
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(68.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) {
                    GameOnPurpleBright
                } else {
                    Muted
                },
                modifier = Modifier.size(23.dp)
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = label,
                fontFamily = Urbanist,
                fontWeight = if (selected) {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                },
                fontSize = 9.sp,
                color = if (selected) {
                    GameOnPurpleBright
                } else {
                    Muted
                }
            )
        }
    }
}
