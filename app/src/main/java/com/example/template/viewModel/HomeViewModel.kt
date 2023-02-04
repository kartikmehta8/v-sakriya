package com.example.template.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.model.PoliceData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor():ViewModel() {
    private val _policeDataResponse = MutableStateFlow<HomeScreenState>(HomeScreenState.Empty)
    var  policeDataResponse = _policeDataResponse.asStateFlow()
    private val database = Firebase.database
    fun getPoliceData(){
        database.getReference("PoliceOfficer").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var data =snapshot.getValue(PoliceData::class.java)
                if (data != null) {
                   _policeDataResponse.value= HomeScreenState.Success(data)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                _policeDataResponse.value=HomeScreenState.Empty
            }

        })

    }



}




sealed class HomeScreenState {
    object Empty : HomeScreenState()
    object Loading: HomeScreenState()
    class Success(var policeData: Any ) : HomeScreenState()
    object Error : HomeScreenState()
}