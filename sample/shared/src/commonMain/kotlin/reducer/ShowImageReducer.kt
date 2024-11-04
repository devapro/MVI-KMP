package reducer

import MviAction
import MviEvent
import MviState
import Reducer

class ShowImageReducer : Reducer<MviAction.ShowImage, MviState.Loaded, MviAction, MviEvent> {
    override val actionClass = MviAction.ShowImage::class

    override suspend fun reduce(
        action: MviAction.ShowImage,
        getState: () -> MviState.Loaded,
    ): Reducer.Result<MviState.Loaded, MviAction, MviEvent> {
        return Reducer.Result(
            state =
                getState().copy(
                    showImage = true,
                ),
            action = null,
            event = null,
        )
    }
}
