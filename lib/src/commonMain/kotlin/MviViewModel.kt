import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class MviViewModel<STATE, ACTION : Any, EVENT>(
    private val mviStorage: MviStorage<STATE, ACTION, EVENT>,
) : ViewModel() {
    val state
        get() = mviStorage.state

    val event
        get() = mviStorage.event

    fun onAction(action: ACTION) {
        viewModelScope.launch {
            mviStorage.process(action)
        }
    }
}
