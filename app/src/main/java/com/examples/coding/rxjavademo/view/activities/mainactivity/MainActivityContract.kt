package com.examples.coding.rxjavademo.view.activities.mainactivity

import com.examples.coding.networkingdemoone.model.ChuckNorrisResponse.JokeResponse

interface MainActivityContract {
    interface View {
        fun onAddJokeToRecyclerView(jokeResponse: JokeResponse)
    }
    interface Presenter {
        fun attatchView(view : MainActivityContract.View)
        fun requestNewJoke()
    }
}