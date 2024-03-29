package com.example.logonrmlocal.blocodenotasapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.blocodenotasapp.model.Nota
import com.example.logonrmlocal.blocodenotasapp.repository.NotaRepository

class MainViewModel : ViewModel() {
    val notaRepository = NotaRepository()

    val notas: MutableLiveData<List<Nota>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarTodos() {
        isLoading.value = true
        notaRepository
                .buscarTodos(onComplete = {
                    isLoading.value = false
                    notas.value = it
                }, onError = {
                    isLoading.value = false
                    notas.value = arrayListOf()
                })
    }
}