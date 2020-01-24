package at.fh.swengb.moviereview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
            MovieRepository.movieById(
                id = movieId,
                success = {
                    movie_title.text = it.title

                    rate_movie.setOnClickListener {
                        val myRating = movie_rating_bar.rating.toDouble()
                        val myFeedback = movie_feedback.text.toString()
                        val movieRating = Review(myRating, myFeedback)

                        MovieRepository.rateMovie(movieId, movieRating)

                        setResult(Activity.RESULT_OK)

                        finish()

                    }
                },
                error = {
                    Log.e("ERROR", it)
                })
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.logout -> {
                val newIntent = Intent(this, QuitApp::class.java)
                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(newIntent)
                finish()

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


