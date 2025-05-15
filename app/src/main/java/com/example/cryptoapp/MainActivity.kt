package com.example.cryptoapp
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.cryptoapp.models.Asset
import com.example.cryptoapp.ui.theme.CryptoappTheme
import com.example.cryptoapp.views.AssetRow
import com.example.cryptoapp.views.BottomTabBar
import com.example.cryptoapp.views.LoginView
import com.example.cryptoapp.views.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoappTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomTabBar(navController = navController)
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AssetsList.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.AssetsList.route) {
                            // Aquí va tu pantalla principal actual (con AssetRow)
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                            ) {
                                AssetRow(
                                    Asset(
                                        id = "1",
                                        name = "Bitcoin",
                                        symbol = "BTC",
                                        percentage = 5.38,
                                        price = "87000",
                                    )
                                )
                            }
                        }
                        composable(Screen.Settings.route) {
                            LoginView()
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptoappTheme {
        Greeting("Android")
    }
}