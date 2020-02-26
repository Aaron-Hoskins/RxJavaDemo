package com.examples.coding.rxjavademo.datasource.remote.retrofit

import android.util.Log
import com.examples.coding.networkingdemoone.model.ChuckNorrisResponse.JokeResponse
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus

class JokesObserver : Observer<JokeResponse> {
    lateinit var joke : JokeResponse
    override fun onSubscribe(d: Disposable) {
        Log.d("OBSERVER_TAG", "onSubscribed")
    }

    override fun onNext(jokeResponse: JokeResponse) {
        Log.d("OBSERVER_TAG", "onNext Joke = ${jokeResponse.value.joke}")
        joke = jokeResponse
    }
    override fun onComplete() {
        Log.d("OBSERVER_TAG", "onComplete")
        EventBus.getDefault().post(joke)
    }

    override fun onError(e: Throwable) {
        Log.e("OBSERVER_TAG", "ERROR ------>>>  ----->> \n", e)
    }

}