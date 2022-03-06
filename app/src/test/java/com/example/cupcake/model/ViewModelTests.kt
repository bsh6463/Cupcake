package com.example.cupcake.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ViewModelTests {
    //기본 스레드를 호출하면 안 된다고 명시적으로 지정
    @get: Rule //아래 rule을 사용하겠다.
    var instantTaskExecutionRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes(){
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever{}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes(){
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {}
        viewModel.quantity.observeForever{}
        viewModel.setQuantity(12)
        assertEquals(27.00, viewModel.priceGet())
    }

}
