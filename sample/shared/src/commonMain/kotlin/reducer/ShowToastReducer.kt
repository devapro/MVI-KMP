package reducer

import Reducer
import mvi.MviAction
import mvi.MviEvent
import mvi.MviState

class ShowToastReducer : Reducer<MviAction.ShowToast, MviState, MviAction, MviEvent> {
    override val actionClass = MviAction.ShowToast::class

    override suspend fun reduce(
        action: MviAction.ShowToast,
        getState: () -> MviState,
    ): Reducer.Result<MviState, MviAction, MviEvent> {
        return Reducer.Result(
            state = getState(),
            action = null,
            event = MviEvent.ShowToast("It is a toast!"),
        )
    }
}
