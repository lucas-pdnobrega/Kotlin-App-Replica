package com.example.replicateimagepractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.replicateimagepractice.ui.theme.ReplicateImagePracticeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReplicateImagePracticeTheme {
                Scaffold(
                    topBar = { TopBar() },
                    floatingActionButton = { ActionButtons() },
                    bottomBar = { BottomBar() }
                ) { innerPadding ->
                    Content(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF6200EE), // Purple color
            titleContentColor = Color.White
        ),
        title = {
            Text("Jetpack Compose")
        },
        navigationIcon = {
            IconButton(onClick = { /**/ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { /**/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun ActionButtons() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            containerColor = Color(0xFF03DAC5), // Teal color
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
        ) {
            Icon(Icons.Filled.LocationOn, contentDescription = "Location")
        }
        ExtendedFloatingActionButton(
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Filled.Send, contentDescription = "Navigate") },
            text = { Text(text = "Navigate") },
            containerColor = Color(0xFF03DAC5) // Teal color
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar() {
    BottomAppBar(
        containerColor = Color(0xFF6200EE), // Purple color
        actions = {
            BottomBarButton(icon = Icons.Default.Home, text = "Home")
            BottomBarButton(icon = Icons.Default.AddCircle, text = "Create")
            BottomBarButton(icon = Icons.Default.Settings, text = "Settings")
        }
    )
}

@Composable
fun BottomBarButton(icon: ImageVector, text: String) {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier.padding(4.dp),
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(icon, contentDescription = text)
            Text(text)
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        for (i in 0..9) {
            ListItem(headlineContent = {
                Text(text = "List item - $i")
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReplicateImagePracticeTheme {
        Scaffold(
            topBar = { TopBar() },
            floatingActionButton = { ActionButtons() },
            bottomBar = { BottomBar() }
        ) { innerPadding ->
            Content(modifier = Modifier.padding(innerPadding))
        }
    }
}
