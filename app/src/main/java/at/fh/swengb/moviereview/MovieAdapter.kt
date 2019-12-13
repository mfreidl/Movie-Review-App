package at.fh.swengb.moviereview//freidl


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movie.view.*
import java.math.RoundingMode
import android.graphics.Bitmap

class MovieAdapter(val clickListener: (movie: Movie) -> Unit): RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieItemView = inflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(movieItemView, clickListener)

    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var movie = movieList.get(position)
        holder.bindItem(movie)
    }

    fun updateList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }
}

class MovieViewHolder(itemView: View, val clickListener: (movie: Movie) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bindItem(movie: Movie) {
        itemView.item_movie_title.text = movie.title
        itemView.item_movie_date.text = movie.release
        itemView.item_movie_actor1.text = movie.actors.elementAt(0).name
        itemView.item_movie_actor2.text = movie.actors.elementAt(1).name
        itemView.item_movie_avg_rating_bar.rating = movie.ratingAverage().toFloat()
        itemView.item_movie_avg_rating_value.text = movie.ratingAverage().toBigDecimal().setScale(2, RoundingMode.CEILING).toString()
        itemView.item_movie_avg_rating_count.text = movie.reviews.count().toString()
        itemView.image_view.setImageResource(movie.image)
        itemView.setOnClickListener {
            clickListener(movie)
        }
    }
}