package com.examples.coding.rxjavademo.view.activities.mainactivity

import com.examples.coding.rxjavademo.datasource.remote.retrofit.JokesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter : MainActivityContract.Presenter {
    lateinit var viewContract : MainActivityContract.View

    override fun requestNewJoke() {
        JokesService
            .getChuckNorrisJokeCallService()
            .getRandomJokes("random")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { result -> viewContract.onAddJokeToRecyclerView(result) }
            .subscribe()

    }

    override fun attatchView(view: MainActivityContract.View) {
        viewContract = view
    }
}