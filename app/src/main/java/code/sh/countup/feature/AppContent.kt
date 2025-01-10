package code.sh.countup.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import code.sh.countup.core.ui.theme.CountUpTheme
import code.sh.countup.feature.root.RootScreen

@Composable
fun AppContent() {
    CountUpTheme {
        BottomSheetNavigator {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.systemBars)
            ) {
                Navigator(
                    screen = RootScreen,
                    key = "AppContentNavigator"
                )
            }
        }
    }
}