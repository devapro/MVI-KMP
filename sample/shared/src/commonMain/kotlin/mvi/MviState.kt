package mvi

sealed interface MviState {
    data object Loading : MviState

    data class Loaded(
        val message: String,
        val showImage: Boolean,
    ) : MviState

    data object Error : MviState
}
