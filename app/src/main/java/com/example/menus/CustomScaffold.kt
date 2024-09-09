package com.example.menus

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CustomScaffold(navController: NavHostController) {
    // Estado para el contador
    var count by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = {
            CustomFAB(onClick = { count++ })
        },
        content = { padding ->
            CustomContent(padding = padding, count = count)
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavHostController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = {
                navController.navigate("profile")  // Navegar a la pantalla de perfil
            }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Account"
                )
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavHostController) {
    BottomAppBar {
        IconButton(onClick = { navController.navigate("build") }) {
            Icon(Icons.Filled.Build, contentDescription = "Build")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate("menu") }) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate("favorite") }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate("delete") }) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}

@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Text(text = "+")
    }
}

@Composable
fun CustomContent(padding: PaddingValues, count: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        Text(text = "My app content")
        Spacer(modifier = Modifier.height(16.dp))  // Espacio entre los elementos
        Text(text = "Button pressed: $count times")
    }
}

@Composable
fun MainScreen() {
    // Estado para contar las veces que se presiona el botón
    var count by remember { mutableStateOf(0) }

    Scaffold(
        floatingActionButton = {
            CustomFAB(onClick = { count++ })
        }
    ) { paddingValues ->
        CustomContent(padding = paddingValues, count = count)
    }
}
