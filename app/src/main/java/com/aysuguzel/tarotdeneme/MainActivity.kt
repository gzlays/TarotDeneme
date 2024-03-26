package com.aysuguzel.tarotdeneme

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aysuguzel.tarotdeneme.ui.theme.TarotDenemeTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarotDenemeTheme {
                // A surface container using the 'background' color from the theme
                Surface() {
                    SayfaGecisleri()
                }
            }
        }
    }
}


@Composable
fun SayfaGecisleri() {
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = "greeting"){
        composable("greeting"){
            Greeting(navController=navController)

        }
        composable("detay_sayfa/{tarotCards}", arguments = listOf(
            navArgument("tarotCards"){type= NavType.StringType}
        )) {
            val json=it.arguments?.getString("tarotCards")
            val tarotCards= Gson().fromJson(json, Tarots::class.java)
            Detay(tarotCards =tarotCards)
        }
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(navController: NavController) {

    val tarotStrings = mutableListOf(
        stringResource(id = R.string.sun),
        stringResource(id = R.string.fool),
        stringResource(id = R.string.high),
        stringResource(id = R.string.magician),
        stringResource(id = R.string.high),
        stringResource(id = R.string.emperor),
        stringResource(id = R.string.lovers),
        stringResource(id = R.string.chariot),
        stringResource(id = R.string.hermit),
        stringResource(id = R.string.justice),
        stringResource(id = R.string.wheel),
        stringResource(id = R.string.strength),
        stringResource(id = R.string.death),
        stringResource(id = R.string.devil),
        stringResource(id = R.string.hangedman),
        stringResource(id = R.string.temperance),
        stringResource(id = R.string.moon),
        stringResource(id = R.string.star),
        stringResource(id = R.string.tower),
        stringResource(id = R.string.judgement),
        stringResource(id = R.string.world),
    )
    val tarotCards= remember {
        mutableStateListOf<Tarots>()
    }
    LaunchedEffect(key1 = true) {
        val y1 = Tarots(1, "The Sun", "${R.drawable.thesun}", tarotStrings[0])
        val y2 = Tarots(2, "The Fool", "${R.drawable.thefool}", tarotStrings[1])
        val y3 = Tarots(3, "The High Priestess", "${R.drawable.highpriestess}", tarotStrings[2])
        val y4 = Tarots(4, "The Magician", "${R.drawable.magician}", tarotStrings[3])
        val y5 = Tarots(5, "The Emperor", "${R.drawable.emperor}", tarotStrings[4])
        val y6 = Tarots(6, "The Lovers", "${R.drawable.lovers}", tarotStrings[5])
        val y7 = Tarots(7, "The Chariot", "${R.drawable.chariot}", tarotStrings[6])
        val y8 = Tarots(8, "The Hermit", "${R.drawable.hermit}", tarotStrings[7])
        val y9 = Tarots(9, "Justice", "${R.drawable.justice}", tarotStrings[8])
        val y10 = Tarots(10, "Wheel Of Fortune", "${R.drawable.wheel_of_fortune}", tarotStrings[9])
        val y11 = Tarots(11, "Strength", "${R.drawable.strength}", tarotStrings[10])
        val y12 = Tarots(12, "Death", "${R.drawable.death}", tarotStrings[11])
        val y13 = Tarots(13, "The Devil", "${R.drawable.the_devil}", tarotStrings[12])
        val y14 = Tarots(14, "The Hanged Man", "${R.drawable.the_hanged_man}", tarotStrings[13])
        val y15 = Tarots(15, "Temperance", "${R.drawable.temperance}", tarotStrings[14])
        val y16 = Tarots(16, "The Moon", "${R.drawable.the_moon}", tarotStrings[15])
        val y17 = Tarots(17, "The Star", "${R.drawable.the_star}", tarotStrings[16])
        val y18 = Tarots(18, "The Tower", "${R.drawable.the_tower}", tarotStrings[17])
        val y19 = Tarots(19, "Judgement", "${R.drawable.judgement}", tarotStrings[18])
        val y20 = Tarots(20, "World", "${R.drawable.the_world}", tarotStrings[19])

        tarotCards.add(y1)
        tarotCards.add(y2)
        tarotCards.add(y3)
        tarotCards.add(y4)
        tarotCards.add(y5)
        tarotCards.add(y6)
        tarotCards.add(y7)
        tarotCards.add(y8)
        tarotCards.add(y9)
        tarotCards.add(y10)
        tarotCards.add(y11)
        tarotCards.add(y12)
        tarotCards.add(y13)
        tarotCards.add(y14)
        tarotCards.add(y15)
        tarotCards.add(y16)
        tarotCards.add(y17)
        tarotCards.add(y18)
        tarotCards.add(y19)
        tarotCards.add(y20)
    }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "TAROTS" , fontFamily = FontFamily.Serif)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.topbar),
                    titleContentColor = colorResource(id = R.color.textbeyaz)
                )
            )
        }


    ){
        Column(modifier = Modifier.background(colorResource(id = R.color.topbar))) {

            Spacer(modifier = Modifier.size(30.dp))

            LazyVerticalGrid(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.SpaceEvenly,
                columns = GridCells.Adaptive(minSize = 128.dp),
                modifier = Modifier.padding(it)
            )
            {
                items(tarotCards) { yarrak ->
                    Card(modifier = Modifier
                        .background(colorResource(id = R.color.topbar))
                        .padding(10.dp)
                        .size(width =30.dp, height = 180.dp)
                        .clickable {
                            val tarotJson = Gson().toJson(yarrak)
                            navController.navigate(
                                "detay_sayfa/$tarotJson"
                            )
                        }) {
                        val activity = (LocalContext.current as Activity)
                        Image(
                            bitmap = ImageBitmap.imageResource(
                                id = activity.resources.getIdentifier(
                                    yarrak.tarot_resim_adi,
                                    "drawable",
                                    activity.packageName
                                )
                            ),
                            contentDescription = "", modifier = Modifier.size(220.dp)
                        )
                    }


                    /*Row() {
                    val activity = (LocalContext.current as Activity)
                    Image(
                        bitmap = ImageBitmap.imageResource(
                            id = activity.resources.getIdentifier(
                                yarrak.tarot_resim_adi,
                                "drawable",
                                activity.packageName
                            )
                        ),
                        contentDescription = "", modifier = Modifier.size(220.dp)
                    )

                }*/
                }
            }
        }
    }









   /* Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "TAROTS" , fontFamily = FontFamily.Serif)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.topbar),
                    titleContentColor = colorResource(id = R.color.textbeyaz)
                )
                )
        }
        
        
    ) {padding ->
        LazyColumn(
            modifier = Modifier
                .background(color = Color(36, 21, 71, 223))
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            items(tarotCards){yarrak ->
                Dondurme(yarrak)
            }
        }
    }*/

}


/*
@Composable
fun Dondurme(
    tarot : Tarots
) {

    var rotated by remember {
        mutableStateOf(false)
    }

    val rotar by animateFloatAsState(
        targetValue =
        if (rotated) 180f else 0f,
        animationSpec = tween(600),
        label = ""
    )


    Card(modifier = Modifier
        .size(width = 350.dp, height = 580.dp)
        .fillMaxSize()
        .graphicsLayer {
            rotationY = rotar
            cameraDistance = 10 * density
        }
        .clickable { rotated = !rotated },

        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.topbar)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        if (!rotated) {
            Onyuz(
                tarot.tarot_resim_adi
            )
        } else {
            Arkayuz(
                rotar,
                tarot.tarot_aciklama
            )
        }

    }
}



@Composable
fun Onyuz(
    image : String
) {
    Column {
        Image(painter = painterResource(id = image.toInt()), contentDescription = "",
            modifier = Modifier
                .fillMaxSize())
    }
}


@Composable
fun Arkayuz(
    rotar : Float,
    aciklama : String
){
     Column (
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier
             .fillMaxSize()
     ){
         Row(){
             Text(text = "Sır - Güneş",fontSize = 50.sp,
                 fontFamily = FontFamily.Serif,
                 color= colorResource(id = R.color.textbeyaz),
                 modifier = Modifier
                     .padding(start = 0.dp)
                     .graphicsLayer {
                         rotationY = rotar
                     }
                 )
         }
         Spacer(modifier = Modifier.size(30.dp))

         Row ( modifier = Modifier
             ){
             Text(text = aciklama,
                 fontFamily = FontFamily.Serif,
                 color=colorResource(id = R.color.textbeyaz),
                 modifier = Modifier
                     .padding(all = 11.dp)
                     .graphicsLayer {
                         rotationY = rotar
                     })

         }
    }
}
*/


@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    TarotDenemeTheme {
        SayfaGecisleri()
    }
}