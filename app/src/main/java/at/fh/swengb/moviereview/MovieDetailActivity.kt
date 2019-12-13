package at.fh.swengb.moviereview//freidl

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import java.math.RoundingMode

class MovieDetailActivity : AppCompatActivity() {

    val API_KEY="AIzaSyCcDFSTMvSIz1nEouSjuM55evkt--5X2Y0"

    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
        val ADD_OR_EDIT_RATING_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        open_trailer.setOnClickListener {
            val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)
            val intent = YouTubeStandalonePlayer.createVideoIntent(this,API_KEY,MovieRepository.moviesById(movieId)?.youtubeId)
            startActivity(intent)
        }

        open_rating.setOnClickListener {
            val data = intent.getStringExtra(EXTRA_MOVIE_ID)
            val intent = Intent(this, MovieRatingActivity::class.java)
            intent.putExtra("Data", data)
            startActivityForResult(intent, ADD_OR_EDIT_RATING_REQUEST)
        }

            updateDetail()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == ADD_OR_EDIT_RATING_REQUEST && resultCode == Activity.RESULT_OK) {
                setResult(Activity.RESULT_OK)
                updateDetail()
            }
    }

    fun updateDetail() {

        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)

        if (movieId == null) {
            finish()
        } else {

        movie_title.text = (MovieRepository.moviesById(movieId))?.title
        movie_director.text = (MovieRepository.moviesById(movieId))?.director?.name
        movie_actors.text = (MovieRepository.moviesById(movieId))?.actors?.joinToString{it.name}
        movie_genre.text = (MovieRepository.moviesById(movieId))?.genre?.description
        movie_release.text = (MovieRepository.moviesById(movieId))?.release
        movie_plot.text = (MovieRepository.moviesById(movieId))?.plot
        item_movie_avg_rating_bar.rating = MovieRepository.moviesById(movieId)?.ratingAverage()!!.toFloat()
        rating_value_number.text = MovieRepository.moviesById(movieId)?.ratingAverage()?.toBigDecimal()?.setScale(2, RoundingMode.CEILING).toString()
        rating_count.text = MovieRepository.moviesById(movieId)?.reviews?.count().toString()
        }
    }
}
