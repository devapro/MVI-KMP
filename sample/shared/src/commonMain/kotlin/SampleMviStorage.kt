import kotlinx.coroutines.Dispatchers
import reducer.LoadReducer
import reducer.ShowImageReducer
import reducer.ShowToastReducer

class SampleMviStorage : MviStorage<MviState, MviAction, MviEvent>(
    reducers =
        setOf(
            LoadReducer() as Reducer<MviAction, MviState, MviAction, MviEvent>,
            ShowToastReducer() as Reducer<MviAction, MviState, MviAction, MviEvent>,
            ShowImageReducer() as Reducer<MviAction, MviState, MviAction, MviEvent>,
        ),
    initStateFactory = SampleInitialStateFactory(),
    coroutineDispatcher = Dispatchers.Default,
    logger =
        object : MviLogger {
            override fun e(throwable: Throwable) {
                println(throwable)
            }

            override fun i(message: String) {
                println(message)
            }
        },
)
