package mvi

import InitStateFactory

class SampleInitialStateFactory : InitStateFactory<MviState> {
    override fun createInitState(): MviState {
        return MviState.Loading
    }
}
