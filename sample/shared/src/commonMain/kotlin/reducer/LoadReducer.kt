package reducer

import MviAction
import MviEvent
import MviState
import Reducer
import kotlinx.coroutines.delay

class LoadReducer : Reducer<MviAction.Load, MviState, MviAction, MviEvent> {
    override val actionClass = MviAction.Load::class

    override suspend fun reduce(
        action: MviAction.Load,
        getState: () -> MviState,
    ): Reducer.Result<MviState, MviAction, MviEvent> {
        delay(1000)
        return Reducer.Result(
            state = MviState.Loaded("Loaded", false),
            action = null,
            event = null,
        )
    }
}
