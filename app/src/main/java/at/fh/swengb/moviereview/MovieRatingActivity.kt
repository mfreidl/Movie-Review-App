package at.fh.swengb.moviereview//freidl

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_rating.*
import kotlinx.android.synthetic.main.activity_movie_rating.movie_title

class MovieRatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)

        val movieId = intent.getStringExtra("Data")

        if (movieId == null) {
            finish()
        } else {
            movie_title.text = (MovieRepository.moviesById(movieId))?.title

            rate_movie.setOnClickListener {
                val myRating = movie_rating_bar.rating.toDouble()
                val myFeedback = movie_feedback.text.toString()
                val movieRating = Review(myRating, myFeedback)

                MovieRepository.rateMovie(movieId, movieRating)

                setResult(Activity.RESULT_OK)

                finish()

            }

        }
    }
}


