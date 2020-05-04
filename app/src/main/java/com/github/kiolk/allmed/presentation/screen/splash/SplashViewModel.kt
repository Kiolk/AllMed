package com.github.kiolk.allmed.presentation.screen.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.kiolk.allmed.data.datasource.drug.DragRepository
import com.github.kiolk.allmed.data.model.Drug
import com.github.kiolk.allmed.presentation.base.BaseViewModel
import com.github.kiolk.allmed.presentation.base.viewModel.ActionLiveData
import com.github.kiolk.allmed.presentation.model.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class SplashViewModel(private val drugRepository: DragRepository) : BaseViewModel() {

    private val _showTrackerScreenAction: ActionLiveData<Event<Any>> = ActionLiveData()

    val showTrackerScreenAction: LiveData<Event<Any>> = _showTrackerScreenAction

    override fun onFirstAttached() {
        viewModelScope.launch {
            drugRepository.saveDrug(
                listOf(
                    Drug(
                        null,
                        "Амоксиклав ${Random().nextInt()}",
                        "https://lekopttorg.ru/upload/resizer2/2/07d/07d15714f190646e1b69a4aad982cf42.png"
                    ),
                    Drug(
                        null,
                        "Амоксиклав ${Random().nextInt()}",
                        "https://lekopttorg.ru/upload/resizer2/2/07d/07d15714f190646e1b69a4aad982cf42.png"
                    ),
                    Drug(
                        null,
                        "Амоксиклав ${Random().nextInt()}",
                        "https://lekopttorg.ru/upload/resizer2/2/07d/07d15714f190646e1b69a4aad982cf42.png"
                    ),
                    Drug(
                        null,
                        "Амоксиклав ${Random().nextInt()}",
                        "https://lekopttorg.ru/upload/resizer2/2/07d/07d15714f190646e1b69a4aad982cf42.png"
                    ),
                    Drug(
                        null,
                        "Амоксиклав ${Random().nextInt()}",
                        "https://lekopttorg.ru/upload/resizer2/2/07d/07d15714f190646e1b69a4aad982cf42.png"
                    ),
                    Drug(
                        null,
                        "Амоксиклав ${Random().nextInt()}",
                        "https://lekopttorg.ru/upload/resizer2/2/07d/07d15714f190646e1b69a4aad982cf42.png"
                    )
                )
            )
            _showTrackerScreenAction.value = Event(Any())
        }
    }
}