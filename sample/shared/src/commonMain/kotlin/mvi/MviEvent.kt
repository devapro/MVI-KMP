package mvi

sealed interface MviEvent {
    data class ShowToast(
        val message: String,
    ) : MviEvent
}
