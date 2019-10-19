package com.bn.smkcoding51019


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bn.smkcoding51019.connection.ConfigRetrofit
import com.bn.smkcoding51019.connection.MovieInterface
import com.hanifabdullah21.smkcoding.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_movie, container, false)

//        val list = Movie.listMovie as ArrayList<MovieModel>
//        val layoutmanager = LinearLayoutManager(activity)
//        val adapter = MovieAdapter(list, activity!!.applicationContext)
//
//        rootView.rv_movie.apply {
//            layoutManager = layoutmanager
//            setAdapter(adapter)
//        }

        return rootView
    }

    private fun getMovieList(){
        val movieNowPlaying =
            ConfigRetrofit.retrofitConfig()
                .create(MovieInterface::class.java)
                .getListMovieNowPlaying("68dba54ce69489d9d28d43f7450cabb8")

        movieNowPlaying
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                    val list = response.results
                    val layoutAdapter = LinearLayoutManager(activity)
                    val adapter = MovieAdapter(list, activity!!.applicationContext)
            },{})
    }


}
