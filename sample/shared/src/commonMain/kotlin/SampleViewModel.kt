class SampleViewModel(
    mviStorage: SampleMviStorage,
) : MviViewModel<MviState, MviAction, MviEvent>(mviStorage)
