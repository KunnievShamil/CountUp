package code.sh.countup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import code.sh.countup.core.navigation.Routes
import code.sh.countup.core.ui.theme.CountUpTheme
import code.sh.countup.feature.counter.CounterScreen
import code.sh.countup.feature.counter_creating.CounterCreatingScreen
import code.sh.countup.feature.counter_list.CounterListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppContent()
        }
    }
}

@Composable
private fun AppContent() {
    CountUpTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars)
        ) {
            val navigationController = rememberNavController()
            NavHost(
                navController = navigationController,
                startDestination = Routes.COUNTER_LIST,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = Routes.COUNTER_LIST) {
                    CounterListScreen(
                        onClickCounter = { id ->
                            navigationController.navigate(Routes.counter(id))
                        },
                        onClickCreateCounter = {
                            navigationController.navigate(Routes.CREATE_COUNTER)
                        }
                    )
                }

                composable(route = Routes.CREATE_COUNTER) {
                    CounterCreatingScreen(
                        onCreateCounter = { counterId ->
                            navigationController.navigate(Routes.counter(id = counterId)) {
                                popUpTo(Routes.CREATE_COUNTER) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable(
                    route = Routes.COUNTER,
                    arguments = listOf(navArgument("id") { type = NavType.IntType })
                ) { entry ->
                    val id = entry.arguments!!.getInt("id")
                    CounterScreen(counterId = id)
                }
            }
        }
    }
}