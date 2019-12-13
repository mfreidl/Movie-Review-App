package at.fh.swengb.moviereview//freidl


object MovieRepository {
    private val movies: List<Movie>

    init {
        // Eiskönigin 2
        val personMenzel = Person("Idina Menzel", "30.Mai 1971")
        val personBell = Person("Kristen Bell", "18.Juli 1980")
        val personBuck = Person("Chris Buck", "24.Februar 1958")
        // Advengers: Endgame
        val personJohansson = Person("Scarlett Johansson", "22. November 1984")
        val personDowney = Person("Robert Downey", "4.April 1965")
        val personRusso = Person("Joe Rosso", "18.Juli 1971")
        // 3 Engel für Charlie
        val personStewart = Person("Kristen Stewart", "15. Juli 1985")
        val personScott = Person("Naomi Scott", "19.Oktober.1982")
        val personBanks = Person("Elizabeth Banks", "25.Juli 1966")
        // Star Wars: Der Aufstieg Skywalkers
        val personRidley = Person("Daisy Ridley", "25.April 1981")
        val personBoyega = Person("John Boyega", "15.Dezember 1984")
        val personAbrams = Person("Jeffrey Abrams", "19.Jänner 1968")
        // Le Mans 66 - Gegen jede Chance
        val personBale = Person("Christian Bale", "15.April 1979")
        val personDamon = Person ("Matt Damon", "27.März 1982")
        val personMangold = Person ("James Mangold", "22.April 1967")
        // A Toy Story: Alles hört auf kein Kommando
        val personHanks = Person("Tom Hanks", " 12.Jänner 1982")
        val personPotts = Person("Annie Potts","25.März 1988")
        val personColley = Person ("Josh Colley", "23.September 1964")
        // Jumanji 2: The Next Level
        val personGillan = Person("Karen Gillan", "25.November 1978")
        val personDwayne = Person("Dwayne Johnson", "22.Jänner 1980")
        val personKasdan = Person("Jake Kasdan", "19.September 1974")
        // Last Christmas
        val personClarke = Person("Emilia Clarke", "12.März 1980")
        val personGolding = Person ("Henry Golding", "18.März 1989")
        val personFeig = Person ("Paul Feig", "15.Jänner 1974")
        // A Beautiful Day in the Neighborhood
        val personHanks2 = Person("Tom Hankks", "18.Dezember 1965")
        val personRhys = Person("Matthew Rhys", "12.März 1974")
        val personHeller = Person ("Marielle Heller", " 19.Oktoober 1972")
        // Joker
        val personPhoenix = Person ("Joaquin Phoenix", "15.Dezember 1974")
        val personBeetz = Person("Zazie Beetz", "12.Februar 1988")
        val personPhillips = Person ("Todd Phillips", "15.Jänner 1975")

        movies = listOf(
            Movie("0",
                "Eiskönigin 2",
                "November 2019",
                "Anna und Elsa sind Prinzessinnen. Nach einer abenteuerlichen Reise haben sie wieder zueinandergefunden. Doch es warten neue Abenteuer auf sie. Gemeinsam mit Kristoff und Olaf wollen sie mehr über ein altes Rätsel ihres Königreichs erfahren.",
                MovieGenre.ANIMATION,
                listOf (personMenzel, personBell),
                personBuck,
                mutableListOf(),
                R.drawable.eiskoenigin,
                "qNSQQlpAuy4"

            ),
            Movie("1",
                "Avengers: Endgame",
                "April 2019",
                "Nach den vorangegangenen Ereignissen liegt das Universum dank des Titanen Thanos in Schutt und Asche. Die übrig gebliebenen Avengers - Thor, Black Widow, Captain America and Bruce Banner - müssen versuchen, ihre besiegten Verbündeten ein letztes mal zu versammeln.",
                MovieGenre.ACTION,
                listOf (personJohansson, personDowney),
                personRusso,
                mutableListOf(),
                R.drawable.avengers,
                "4EFoz_6cy2Q"
            ),
            Movie("2",
                "3 Engel für Charlie",
                "November 2019",
                "Reboot von 3 Engel für Charlie. Wie bereits in den vorangegangenen 3 Engel für Charlie-Filmen und der TV-Serie arbeiten die drei Ermittlerinnen Dylan (Kristen Stewart), Natalie (Naomi Scott) und Alex (Ella Balinska) für einen geheimnisvollen Charlie, dem sie selbst noch nie begegnet sind.",
                MovieGenre.ACTION,
                listOf (personStewart, personScott),
                personBanks,
                mutableListOf(),
                R.drawable.engel,
                "v3n1PquOElI"

            ),
            Movie("3",
                "Star Wars: Der Aufstieg Skywalkers",
                "Dezember 2019",
                "Die legendäre Filmreihe geht weiter und gleichzeitig in die letzte Runde. J.J. Abrams hat auch beim letzten Kapitel der Saga wieder Regie geführt.",
                MovieGenre.ANIMATION,
                listOf (personRidley, personBoyega),
                personAbrams,
                mutableListOf(),
                R.drawable.starwars,
                "iMaNj9v2c34"

            ),
            Movie("4",
                "Joker",
                "Oktober 2019",
                "Für den an einer seltenen Lachstörung leidenden Comedian Arthur Fleck geht es im Gotham City der 80er Jahre in allen Bereichen des Lebens bergab. Der erhoffte Erfolg in seinem Job bleibt aus; er verliert seine Stelle als Clown und wird von einer, den Bach hinuntergehenden Gesellschaft nicht beachtet und misshandelt. ",
                MovieGenre.DRAMA,
                listOf (personPhoenix, personBeetz),
                personPhillips,
                mutableListOf(),
                R.drawable.joker,
                "vVGJUj6Hh8s"
            ),
            Movie("5",
                "Le Mans 66 – Gegen jede Chance",
                "November 2019",
                "Biopic zur Riviltät zwischen Ford und Ferrari in den 1960er Jahren. Im Fokus steht die Biografie von Henry Ford II und dem Konkurrenzkampf zwischen Ford und Ferrari bei dem Rennen in Le Mans im Jahr 1966. Henry Ford II hat das Familiengeschäft seines Großvaters Anfang der 1960er Jahre übernommen. ",
                MovieGenre.DRAMA,
                listOf (personBale, personDamon),
                personMangold,
                mutableListOf(),
                R.drawable.lemans,
                "gfUBO7C1nTw"
            ),
            Movie("6",
                "A Toy Story:  Alles hört auf kein Kommando",
                "Juni 2019",
                "Die Spielzeuge Cowboy Woody und Astronaut Buzz Lightyear leben jetzt bei der kleinen Bonnie. Nach kurzer Zeit haben sie sich hier eingelebt und zaubern ihr ein Lächeln ins Gesicht. Doch eines Tages bringt Bonnie ein neues Spielzeug mit.",
                MovieGenre.ANIMATION,
                listOf (personHanks, personPotts),
                personColley,
                mutableListOf(),
                R.drawable.toystory,
                "lzFSiolOANM"
            ),
            Movie("7",
                "Jumanji 2: The Next Level",
                "Dezember 2019",
                "Nach dem Erfolg der ersten beiden Teile kommt nun der dritte Teil dieser Film-Reihe. Auch in diesem Teil wartet ein großes Abenteuer auf alle Beteiligten. Eine spannende Reise mit einer ganze Menge Action und viel Witz.\n",
                MovieGenre.COMEDY,
                listOf (personGillan, personDwayne),
                personKasdan,
                mutableListOf(),
                R.drawable.jumanji,
                "zHTJvqb7BxE"
            ),
            Movie("8",
                "Last Christmas",
                "November 2019",
                "Kate versucht, in London über die Runden zu kommen. Dafür arbeitet sie auch als Elfe in einem Weihnachtsshop. Eines Tages begegnet sie Tom und alles scheint perfekt zu sein. Nun müssen sie prüfen, ob sie auch im vorweihnachtlichen Stress bestehen.",
                MovieGenre.ROMANCE,
                listOf (personClarke, personGolding),
                personFeig ,
                mutableListOf(),
                R.drawable.lastchristmas,
                "oX0s0BBat-Q"
            ),
            Movie("9",
                "A Beautiful Day in the Neighborhood",
                "November 2019",
                "Biopic über den populären Fernsehmoderator Fred Rogers (Tom Hanks), der vor allem mit seiner Kinderserie 'Mr. Rogers' Neighborhood' Berühmtheit erlangte.",
                MovieGenre.DRAMA,
                listOf (personHanks2, personRhys),
                personHeller,
                mutableListOf(),
                R.drawable.neighborhood,
                "bj2ni8nOmeU"
            ),
            Movie("10",
                "Fast & Furious: Hobbs & Shaw",
                "Juli 2019",
                "Spin-off zur Fast & Furious-Reihe rund um die Figuren Luke Hobbs (Dwayne Johnson) und Deckard Shaw (Jason Statham). Zwei Jahre nach den Ereignissen mit Cipher (Charlize Theron) in Fast & Furious 8 müssen sich der Bundesagent Luke Hobbs und der ehemalige britische Militärsoldat Deckard Shaw zusammenschließen.",
                MovieGenre.ACTION,
                listOf (personDwayne, personRhys),
                personHeller,
                mutableListOf(),
                R.drawable.fandf,
                "3dw5e01banA"
            ),
            Movie("11",
                "Terminator: Dark Fate",
                "Oktober 2019",
                "Das Computerprogramm Skynet hat sich weiterentwickelt und neue Wege gefunden, die Menschheit zu vernichten. Die alles entscheidende Schlacht findet in Mexiko statt. Hier gerät Dani Ramos mit ihrem Bruder zwischen die Fronten",
                MovieGenre.ACTION,
                listOf (personHanks2, personRhys),
                personHeller,
                mutableListOf(),
                R.drawable.terminator,
                "u6mTPT_vrDc"
            ),
            Movie("12",
                "Alita: Battle Angel",
                "Jänner 2019",
                "Alita ist ein Cyborg, der als Waffe kreiert wurde. Sie kann sich nicht an ihre Vergangenheit erinnern, doch ihr Schöpfer Dr. Ido ist sich sicher, dass sie ein Schicksal zu erfüllen hat: Den Kreislauf aus Tod und Zerstörung zu brechen, den Tiphares hinterlässt. Um diese Mission zu erfüllen, muss sie jedoch selbst kämpfen und töten.",
                MovieGenre.DRAMA,
                listOf (personFeig, personAbrams),
                personRhys,
                mutableListOf(),
                R.drawable.alita,
                "GPr2uDKOGT4"
            ),
            Movie("13",
                "Parasite",
                "Mai 2019",
                "Biopic über den populären Fernsehmoderator Fred Rogers (Tom Hanks), der vor allem mit seiner Kinderserie 'Mr. Rogers' Neighborhood' Berühmtheit erlangte.",
                MovieGenre.DRAMA,
                listOf (personBale, personBeetz),
                personClarke,
                mutableListOf(),
                R.drawable.parasite,
                "9qvaE99iMR0"
            ),
            Movie("14",
                "Drachenzähmen leicht gemacht 3",
                "Jänner 2019",
                "Hicks ist nun Wickingerhäuptling und sorgt mit Astrid in seinem Heimatdorf Berk für Ordnung. Ohnezahn ist zum Anführer der Drachen ernannt wurden. Der Weg an die Spitze ist jedoch kein einfacher, erst recht nicht, als plötzlich eine neue Bedrohung auftaucht, die ihr Bündnis auf eine harte Probe stellt. Da wäre zum einen ein weißer Nachtschatten-Drache und der Ohnezahn den Kopf verdreht.",
                MovieGenre.DRAMA,
                listOf (personGillan, personGolding),
                personHeller,
                mutableListOf(),
                R.drawable.drachenzaehmen,
                "HLoBQ9Fn_iw"
            )
        )
    }

    fun moviesList(): List<Movie> {
        return movies
    }

    fun moviesById(id: String): Movie? {
        return movies.find { it.id == id }
    }

    fun rateMovie(id: String, rating: Review) {
        moviesById(id)?.reviews?.add(rating)
    }
}