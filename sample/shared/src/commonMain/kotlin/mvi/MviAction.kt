package mvi

sealed interface MviAction {
    data object Load : MviAction

    data object ShowToast : MviAction

    data object ClickOnToggleImageButton : MviAction
}
