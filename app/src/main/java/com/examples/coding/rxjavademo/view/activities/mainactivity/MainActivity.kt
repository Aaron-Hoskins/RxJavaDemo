package com.examples.coding.rxjavademo.view.activities.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.examples.coding.networkingdemoone.model.ChuckNorrisResponse.JokeResponse
import com.examples.coding.rxjavademo.R
import com.examples.coding.rxjavademo.datasource.remote.retrofit.JokesObserver
import com.examples.coding.rxjavademo.datasource.remote.retrofit.JokesService
import com.examples.coding.rxjavademo.view.adapters.JokesAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity(), MainActivityContract.View {
    val adapter by lazy{JokesAdapter()}
    val presenterContract = MainActivityPresenter() as MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenterContract.attatchView(this)
        rvJokeList.layoutManager = LinearLayoutManager(this)
        rvJokeList.adapter = adapter
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.btnGenerateNewJoke -> presenterContract.requestNewJoke()
        }
    }

    override fun onAddJokeToRecyclerView(jokeResponse: JokeResponse) {
        adapter.addJoke(jokeResponse)
    }
}
