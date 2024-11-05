package mvi

import MviLogger
import MviStorage
import Reducer
import kotlinx.coroutines.Dispatchers
import reducer.ClickOnToggleImageButtonReducer
import reducer.LoadReducer
import reducer.ShowToastReducer

class SampleMviStorage : MviStorage<MviState, MviAction, MviEvent>(
    reducers =
        setOf(
            LoadReducer() as Reducer<MviAction, MviState, MviAction, MviEvent>,
            ShowToastReducer() as Reducer<MviAction, MviState, MviAction, MviEvent>,
            ClickOnToggleImageButtonReducer() as Reducer<MviAction, MviState, MviAction, MviEvent>,
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
