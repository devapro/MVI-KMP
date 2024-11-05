import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import mvi.MviAction
import mvi.MviEvent
import mvi.MviState
import mvi.SampleMviStorage
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    viewModel: SampleViewModel =
        viewModel {
            SampleViewModel(
                SampleMviStorage(),
            )
        },
) {
    MaterialTheme {
        val state = viewModel.state.collectAsState()
        val lifecycleOwner = LocalLifecycleOwner.current

        when (state.value) {
            is MviState.Loading -> {
                CircularProgressIndicator()
            }

            is MviState.Loaded -> {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(onClick = {
                        viewModel.onAction(MviAction.ClickOnToggleImageButton)
                    }) {
                        Text((state.value as MviState.Loaded).message)
                    }
                    AnimatedVisibility((state.value as MviState.Loaded).showImage) {
                        Image(
                            painterResource("compose-multiplatform.xml"),
                            contentDescription = "Compose Multiplatform icon",
                        )
                    }
                }
            }

            is MviState.Error -> {
                Text("Error")
            }
        }

        LaunchedEffect(Unit) {
            viewModel.onAction(MviAction.Load)
        }
        LaunchedEffect(Unit) {
            viewModel.event
                .flowWithLifecycle(lifecycleOwner.lifecycle)
                .collect {
                    when (it) {
                        is MviEvent.ShowToast -> {
                            showToast(it.message)
                        }
                    }
                }
        }
    }
}
