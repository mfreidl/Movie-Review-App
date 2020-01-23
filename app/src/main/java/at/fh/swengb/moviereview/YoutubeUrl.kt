package at.fh.swengb.moviereview

class YoutubeUrl (val id : Int, val name : String)

object YoutubeUrls {
    private val urls: List<YoutubeUrl> = listOf(
        YoutubeUrl(278, "6hB3S9bIaco"),
        YoutubeUrl(238, "sY1S34973zA"),
        YoutubeUrl(680, "s7EdQ4FqbhY"),
        YoutubeUrl(13, "bLvqoHBptjg"),
        YoutubeUrl(155, "EXeTwQWrcwY"),
        YoutubeUrl(122, "r5X-hFf6Bwo"),
        YoutubeUrl(550, "qtRKdVHc-cE"),
        YoutubeUrl(1891, "JNwNXF9Y6kY"),
        YoutubeUrl(120, "V75dMMIW2B4"),
        YoutubeUrl(807, "znmZoVkCjpI"),
        YoutubeUrl(299534, "TcMBFSGVi1c"),
        YoutubeUrl(27205, "JEv8W3pWqH0"),
        YoutubeUrl(121, "LbfMDwc4azU"),
        YoutubeUrl(299536, "6ZfuNTqbHE8"),
        YoutubeUrl(157336, "zSWdZVtXT7E"),
        YoutubeUrl(8587, "7TavVZMewpY"),
        YoutubeUrl(105, "qvsgGtivCgs"),
        YoutubeUrl(77338, "34WIbmXkewU"),
        YoutubeUrl(11, "1g3_CFmnU7k"),
        YoutubeUrl(354912, "Ga6RYejo6Hk")
    )

    fun urlById(id: Int): String? {
        val url = urls.find {it.id == id}
        return url?.name
    }
}