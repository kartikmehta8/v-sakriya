package com.example.template.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.data.repository.AuthService
import com.example.template.model.CarDetailsResponse
import com.example.template.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CarDetailsViewModel @Inject constructor(
    private val authService: AuthService,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _getDetails = MutableStateFlow<CarsDetailsState>(CarsDetailsState.Empty)
    val getDetails = _getDetails.asStateFlow()
    val imageUrl: MutableState<String?> = mutableStateOf("")
    fun getCarDetails() {
        viewModelScope.launch(dispatcherProvider.io) {
            _getDetails.value = CarsDetailsState.Loading
            try {
                val response = authService.getCar("63de1d2b90dabecdd80557c2")
                if (response.isSuccessful) {
                    response.body().let {
                        if (it != null) {
                            _getDetails.value = CarsDetailsState.Success(it)
                            imageUrl.value = getImageUrl(it)
                            Timber.tag("CarDetailsViewModel").d(it.data.carDetails.carModel)
                        }

                    }
                } else {

                    Timber.tag("CarDetailsViewModel").d(response.errorBody()?.string())
                    _getDetails.value = CarsDetailsState.Error
                }
            } catch (e: Exception) {
                Timber.tag("CarDetailsViewModel").d(e)
            }

        }
    }


}

val list = mapOf<String, String>(
    "Maruti Swift" to "https://i.postimg.cc/sf9VG0Hk/swift-Image.jpg",
    "Honda City " to "https://i.postimg.cc/fT9FG4cp/hondacity.jpg",
    "Hyundai Grand i10" to "https://i.postimg.cc/qRDST4ZV/i10.jpg",
    "Mahindra Scorpio" to "https://i.postimg.cc/2yPt1TD0/scorpio1.jpg",
    "Tata Tiago" to "https://i.postimg.cc/PJLcf9BL/tiago.jpg",
    "Toyota Innova" to "https://i.postimg.cc/1RT27RqD/toyota.jpg"
)

fun getImageUrl(carDetailsResponse: CarDetailsResponse): String? {
    return list[carDetailsResponse.data.carDetails.carModel]

}

sealed class CarsDetailsState {
    object Empty : CarsDetailsState()
    object Loading : CarsDetailsState()
    class Success(var policeData: Any) : CarsDetailsState()
    object Error : CarsDetailsState()
}