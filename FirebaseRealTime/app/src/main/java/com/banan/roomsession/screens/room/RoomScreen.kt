import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banan.roomsession.R
import com.banan.roomsession.ui.theme.PurpleGrey80
import com.banan.roomsession.screens.room.view_model.RoomUiState
import com.banan.roomsession.screens.room.view_model.RoomViewModel

@Composable
fun RoomScreen(
    navController: NavController,
    roomViewModel: RoomViewModel = hiltViewModel()
) {
    val state by roomViewModel.state.collectAsState()

    RoomContent(
        state = state,
        onClick = {
                if (state.showImage) {
                    roomViewModel.hideImage()
                } else {
                    roomViewModel.showImage()
                }
        }
    )
}

@Composable
fun RoomContent(
    state: RoomUiState,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val imageAlpha: Float by animateFloatAsState(
            targetValue = if (state.showImage) 1f else 0f,
            animationSpec = tween(500)
        )

        AnimatedVisibility(visible = state.showImage) {
            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(7f)
                    .padding(top = 25.dp)
                    .alpha(imageAlpha)
            )
        }

        Spacer(modifier = Modifier.height(height = 290.dp))

        if (state.visitors.isNotEmpty()) {

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = PurpleGrey80,
                    contentColor = Color.Black
                ),
                onClick = onClick,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(bottom = 24.dp),
                enabled = state.visitorId == state.visitors.first().id
            ) {
                Text(text = if (state.showImage) "Hide Image" else "Show Image")
            }
        }
    }
}