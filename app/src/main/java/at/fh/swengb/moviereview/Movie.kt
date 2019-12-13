package at.fh.swengb.moviereview//freidl

class Movie(
    val id :String,
    val title : String,
    val release : String,
    val plot : String,
    val genre : MovieGenre,
    val actors : List<Person>,
    val director : Person,
    val reviews : MutableList<Review>,
    val image : Int,
    val youtubeId : String
) {
    fun ratingAverage() : Double{
        var average = reviews.map { it.reviewValue }.average()

        if (average.isNaN()) {
            average = 0.0
        }
        return average
    }
}
