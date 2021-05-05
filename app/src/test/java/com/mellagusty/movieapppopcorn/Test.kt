package com.mellagusty.movieapppopcorn

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

object Test {

    fun <U>LiveData<U>.getandwaitValue(
        timeout: Long = 5000L,
        timeUnit: TimeUnit = TimeUnit.MILLISECONDS,
    ): U {
        val lock = CountDownLatch(1)
        var data: U? = null
        val observer = object : Observer<U> {
            override fun onChanged(t: U) {
                data = t
                removeObserver(this)
                lock.countDown()
            }
        }
        observeForever(observer)

        if (!lock.await(timeout, timeUnit)) {
            throw TimeoutException("The value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as U
    }

}