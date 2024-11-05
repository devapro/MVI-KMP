package reducer

import Reducer
import mvi.MviAction
import mvi.MviEvent
import mvi.MviState

class ClickOnToggleImageButtonReducer : Reducer<MviAction.ClickOnToggleImageButton, MviState.Loaded, MviAction, MviEvent> {
    override val actionClass = MviAction.ClickOnToggleImageButton::class

    override suspend fun reduce(
        action: MviAction.ClickOnToggleImageButton,
        getState: () -> MviState.Loaded,
    ): Reducer.Result<MviState.Loaded, MviAction, MviEvent> {
        val currentState = getState()
        return Reducer.Result(
            state =
                currentState.copy(
                    showImage = currentState.showImage.not(),
                    message = if (currentState.showImage) "Show image" else "Hide image",
                ),
            action = null,
            event = null,
        )
    }
}
