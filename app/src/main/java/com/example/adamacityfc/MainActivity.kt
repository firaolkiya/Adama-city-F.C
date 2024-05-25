package com.example.adamacityfc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.adamacityfc.Data.Model.Match
import com.example.adamacityfc.Data.Model.News
import com.example.adamacityfc.Data.Model.Player
import com.example.adamacityfc.Data.Model.Shop
import com.example.adamacityfc.Presentation.ContainerScreen.MainScreen
import com.example.adamacityfc.Presentation.theme.AdamaCityFCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdamaCityFCTheme {

            MainScreen()


            }
        }
    }
}




val matchList: List<Match> = listOf(
    Match(
        matchId = 1,
        matchType = "PREMIER LEAGUE ",
        date = "May 20 2024",
        isPlayed = true,
        othersTeamName = "Jimma Abba Jifar",
        adamaScore = 2,
        othersScore = 1
    ),
    Match(
        matchId = 2,
        matchType = "PREMIER LEAGUE ",
        date = "May 28 2024",
        isPlayed = false,
        othersTeamName = "Wolkite Ketema",
    ),
    Match(
        matchId = 3,
        matchType = "PREMIER LEAGUE ",
        date = "March 17 2024",
        isPlayed = true,
        othersTeamName = "Fasil Ketema",
        adamaScore = 1,
        othersScore = 1
    ),
    Match(
        matchId = 4,
        matchType = "PREMIER LEAGUE ",
        date = "June 2 2024",
        isPlayed = false,
        othersTeamName = "Sidama Buna",

    ),
    Match(
        matchId = 5,
        matchType = "PREMIER LEAGUE ",
        date = "May 15 2024",
        isPlayed = true,
        othersTeamName = "Buna Bank",
        adamaScore = 2,
        othersScore = 2
    ),
    Match(
        matchId = 1,
        matchType = "PREMIER LEAGUE ",
        date = "May 20 2024",
        isPlayed = true,
        othersTeamName = "Jimma Abba Jifar",
        adamaScore = 2,
        othersScore = 1
    ),
    Match(
        matchId = 2,
        matchType = "PREMIER LEAGUE ",
        date = "May 28 2024",
        isPlayed = false,
        othersTeamName = "Wolkite Ketema",
    ),
    Match(
        matchId = 3,
        matchType = "PREMIER LEAGUE ",
        date = "March 17 2024",
        isPlayed = true,
        othersTeamName = "Fasil Ketema",
        adamaScore = 1,
        othersScore = 1
    ),
    Match(
        matchId = 4,
        matchType = "PREMIER LEAGUE ",
        date = "June 2 2024",
        isPlayed = false,
        othersTeamName = "Sidama Buna",

        ),
    Match(
        matchId = 5,
        matchType = "PREMIER LEAGUE ",
        date = "May 15 2024",
        isPlayed = true,
        othersTeamName = "Buna Bank",
        adamaScore = 2,
        othersScore = 2
    ),
    Match(
        matchId = 1,
        matchType = "PREMIER LEAGUE ",
        date = "May 20 2024",
        isPlayed = true,
        othersTeamName = "Jimma Abba Jifar",
        adamaScore = 2,
        othersScore = 1
    ),
    Match(
        matchId = 2,
        matchType = "PREMIER LEAGUE ",
        date = "May 28 2024",
        isPlayed = false,
        othersTeamName = "Wolkite Ketema",
    ),
    Match(
        matchId = 3,
        matchType = "PREMIER LEAGUE ",
        date = "March 17 2024",
        isPlayed = true,
        othersTeamName = "Fasil Ketema",
        adamaScore = 1,
        othersScore = 1
    ),
    Match(
        matchId = 4,
        matchType = "PREMIER LEAGUE ",
        date = "June 2 2024",
        isPlayed = false,
        othersTeamName = "Sidama Buna",

        ),
    Match(
        matchId = 5,
        matchType = "PREMIER LEAGUE ",
        date = "May 15 2024",
        isPlayed = true,
        othersTeamName = "Buna Bank",
        adamaScore = 2,
        othersScore = 2
    ),
    Match(
        matchId = 1,
        matchType = "PREMIER LEAGUE ",
        date = "May 20 2024",
        isPlayed = true,
        othersTeamName = "Jimma Abba Jifar",
        adamaScore = 2,
        othersScore = 1
    ),
    Match(
        matchId = 2,
        matchType = "PREMIER LEAGUE ",
        date = "May 28 2024",
        isPlayed = false,
        othersTeamName = "Wolkite Ketema",
    ),
    Match(
        matchId = 3,
        matchType = "PREMIER LEAGUE ",
        date = "March 17 2024",
        isPlayed = true,
        othersTeamName = "Fasil Ketema",
        adamaScore = 1,
        othersScore = 1
    ),
    Match(
        matchId = 4,
        matchType = "PREMIER LEAGUE ",
        date = "June 2 2024",
        isPlayed = false,
        othersTeamName = "Sidama Buna",

        ),
    Match(
        matchId = 5,
        matchType = "PREMIER LEAGUE ",
        date = "May 15 2024",
        isPlayed = true,
        othersTeamName = "Buna Bank",
        adamaScore = 2,
        othersScore = 2
    )
)

val newsList:List<News> = listOf(
    News(
        owner = "Adama City F.C",
        newsDescription = "The team is ready to take challenges of upcoming matches",
        newsImageId = R.drawable.news,
        postedDate = "yesterday 12 PM"
    ),
    News(
        owner = "Adama City F.C",
        newsDescription = "We are excited announce that our teams jerseys are now available for sale ",
        newsImageId = R.drawable.news2,
        postedDate = "12 days ago"
    ),
    News(
        owner = "Adama City F.C",
        newsDescription = "New player has been added to the roster will be played in thee next game",
        newsImageId = R.drawable.news,
        postedDate = "4 hour ago"
    )
)

val playersList: List<Player> = listOf(
    Player(
        name = "habib mohammed",
        age = 25,
        image =R.drawable.habib ,
        totalPlayed = 14,
        minutes =85.8f,
        goal = 12,
        shirtNumber = 47,
        shootToTarget = 27,
        assists = 12,
        role = "Goal keeper"
    ),
    Player(
        name = "teklemariam shanko",
        age = 25,
        image =R.drawable.taklemariam ,
        totalPlayed = 14,
        minutes =82.8f,
        goal = 14,
        shirtNumber = 24,
        shootToTarget = 27,
        assists = 10,
        role = "Goal keeper"
    ),
    Player(
        name = "Haider Sherefa",
        age = 25,
        image =R.drawable.haider ,
        totalPlayed = 16,
        minutes =85.8f,
        goal = 2,
        shirtNumber = 4,
        shootToTarget = 27,
        assists = 12,
        role = "Midfielders"
    ),
    Player(
        name = "Abubeker Shamil",
        age = 25,
        image =R.drawable.abubaker ,
        totalPlayed = 14,
        minutes =85.8f,
        goal = 12,
        shirtNumber = 47,
        shootToTarget = 27,
        assists = 12,
        role = "Midfielder"
    ),
    Player(
        name = "Ashenafi Elias",
        age = 25,
        image =R.drawable.unknown ,
        totalPlayed = 14,
        minutes =85.8f,
        goal = 12,
        shirtNumber = 47,
        shootToTarget = 5,
        assists = 12,
        role = "Striker"
    ),
    Player(
        name = "Yosef tarekegn",
        age = 20,
        image =R.drawable.unknown ,
        totalPlayed = 14,
        minutes =80.8f,
        goal = 7,
        shirtNumber = 9,
        shootToTarget = 10,
        assists = 6,
        role = "Striker"
    ),
    Player(
        name = "Ayten biniam",
        age = 25,
        image =R.drawable.unknown ,
        totalPlayed = 14,
        minutes =85.8f,
        goal = 12,
        shirtNumber = 47,
        shootToTarget = 5,
        assists = 12,
        role = "Striker"
    ),
    Player(
        name = "Surafel awol",
        age = 20,
        image =R.drawable.unknown ,
        totalPlayed = 14,
        minutes =80.8f,
        goal = 7,
        shirtNumber = 9,
        shootToTarget = 10,
        assists = 6,
        role = "MidFielder"
    ),
    Player(
        name = "Meleku Elias",
        age = 25,
        image =R.drawable.unknown ,
        totalPlayed = 14,
        minutes =85.8f,
        goal = 12,
        shirtNumber = 47,
        shootToTarget = 5,
        assists = 12,
        role = "Defender"
    ),
    Player(
        name = "Jamil Yakob",
        age = 20,
        image =R.drawable.unknown ,
        totalPlayed = 14,
        minutes =80.8f,
        goal = 7,
        shirtNumber = 9,
        shootToTarget = 10,
        assists = 6,
        role = "Defender"
    )
)

val shops:List<Shop> = listOf(
    Shop(
        itemName = "Tshirt",
        itemPrice = 350f,
        itemImage = R.drawable.clubtshirt,
        description = "Adama City F.C Tshirt is beautiful Tshirt"
    ),
    Shop(
        itemName = "White Tshirt",
        itemPrice = 350f,
        itemImage = R.drawable.tshirt2,
        description = "Adama City F.C Tshirt is beautiful Tshirt"
    ),
    Shop(
        itemName = "Black Tshirt",
        itemPrice = 350f,
        itemImage = R.drawable.shirt3,
        description = "Adama City F.C Tshirt is beautiful Tshirt"
    ),
    Shop(
        itemName = "Entertainment",
        itemPrice = 10f,
        itemImage = R.drawable.city,
        description = "Your city"
    ),
    Shop(
        itemName = "Tshirt",
        itemPrice = 350f,
        itemImage = R.drawable.clubtshirt,
        description = "Adama City F.C Tshirt is beautiful Tshirt"
    ),
    Shop(
        itemName = "White Tshirt",
        itemPrice = 350f,
        itemImage = R.drawable.tshirt2,
        description = "Adama City F.C Tshirt is beautiful Tshirt"
    ),
    Shop(
        itemName = "Black Tshirt",
        itemPrice = 350f,
        itemImage = R.drawable.shirt3,
        description = "Adama City F.C Tshirt is beautiful Tshirt"
    ),
    Shop(
        itemName = "Entertainment",
        itemPrice = 10f,
        itemImage = R.drawable.city,
        description = "Your city"
    )
)

fun List<Match>.getFiltered(isPlayed:Boolean):List<Match>{
    return matchList.filter { it.isPlayed==isPlayed }
}