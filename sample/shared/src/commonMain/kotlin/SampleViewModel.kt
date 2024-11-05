import mvi.MviAction
import mvi.MviEvent
import mvi.MviState
import mvi.SampleMviStorage

class SampleViewModel(
    mviStorage: SampleMviStorage,
) : MviViewModel<MviState, MviAction, MviEvent>(mviStorage)
