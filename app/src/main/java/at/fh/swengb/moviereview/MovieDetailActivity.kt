package at.fh.swengb.moviereview

import android.app.Activity
import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_movie_detail.*
import java.math.RoundingMode
import android.view.Menu
import android.view.MenuItem
import com.ms.square.android.expandabletextview.ExpandableTextView

class MovieDetailActivity : AppCompatActivity() {

    val API_KEY="AIzaSyCcDFSTMvSIz1nEouSjuM55evkt--5X2Y0"

    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
        val ADD_OR_EDIT_RATING_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)


        open_rating.setOnClickListener {
            val data = intent.getStringExtra(EXTRA_MOVIE_ID)
            val intent = Intent(this, MovieRatingActivity::class.java)
            intent.putExtra("Data", data)
            startActivityForResult(intent, ADD_OR_EDIT_RATING_REQUEST)
        }

        updateDetail()
        updateComments()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == ADD_OR_EDIT_RATING_REQUEST && resultCode == Activity.RESULT_OK) {
                setResult(Activity.RESULT_OK)
                updateDetail()
                updateComments()
            }
    }

    fun updateDetail() {

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val height = size.y/4

        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)

        if (movieId == null) {
            finish()
        } else {
            MovieRepository.movieById(
                id = movieId,
                success = {
                    Glide
                        .with(backdrop)
                        .load(it.backdropImagePath)
                        .into(backdrop)
                    Glide
                        .with(poster)
                        .load(it.posterImagePath)
                        .into(poster)
                    cardView.layoutParams.height = height
                    movie_title.text = it.title
                    movie_release.text = it.release
                    item_movie_avg_rating_bar.rating = it.ratingAverage().toFloat()
                    rating_value_number.text = it.ratingAverage().toBigDecimal().setScale(2, RoundingMode.CEILING).toString()
                    rating_count.text = it.reviews.count().toString()
                    movie_director.text = it.director.name
                    movie_actors.text = it.actors.joinToString { it.name }
                    movie_genre.text = it.genres.joinToString{it}
                    movie_plot.text = it.plot
                    comments.text = getString(R.string.comments, it.reviews.filter{it.reviewText != ""}.count().toString())
                },
                error = {
                    Log.e("ERROR", it)
                })
        }
    }

    fun updateComments() {
        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)
        if (movieId == null) {
            Log.e("error", "error")
        } else {
            MovieRepository.movieById(
                id = movieId,
                success = {
                    open_trailer.setOnClickListener {
                        val intent = YouTubeStandalonePlayer.createVideoIntent(this,API_KEY,YoutubeUrls.urlById(movieId.toInt()))
                        startActivity(intent)
                    }
                    val expTv: ExpandableTextView = findViewById(R.id.expand_text_view)
                    expTv.text = it.reviews.filter{it.reviewText != ""}.map{ getString(R.string.stars, it.reviewText, it.reviewValue.toString()) }.joinToString { it }.replace(",", "")

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
