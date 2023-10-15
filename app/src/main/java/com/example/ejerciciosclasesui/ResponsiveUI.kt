package com.example.ejerciciosclasesui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ejerciciosclasesui.ui.theme.EjerciciosClasesUITheme

class ResponsiveUI : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjerciciosClasesUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Primera forma, usando los tamaños de la pantalla
                   /* val windowSizeClass = calculateWindowSizeClass(activity = this)
                    UIResponsiveTamanyoVentana(esColumna
                    = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact)*/
                   // Segunda forma, usando la configuración del dispositivo.
                    val configuration = LocalConfiguration.current
                    UIResponsiveBooleano(esFila = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
                }
                }
            }
        }
    }



@Composable
fun FilaImagen(){
    Row(Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.zgz),
            contentDescription = "",
            Modifier
                .padding(16.dp)
                .weight(1f)
                .fillMaxSize())
        Text("Real zaragoza el mejor equipo del mundo", Modifier
            .weight(1f)
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center))
    }
}


@Composable
fun ColumnaImagen(){
    Column(Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.zgz),
            contentDescription = "",
            Modifier
                .padding(16.dp)
                .weight(1f)
                .fillMaxSize())
        Text("Real zaragoza el mejor equipo del mundo", Modifier
            .weight(1f)
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center))
    }
    
}


@Composable
fun TextoEImagen(modificadorDado : Modifier){
    Image(painter = painterResource(id = R.drawable.zgz),
        contentDescription = "",
        modificadorDado
            .padding(16.dp)
            .fillMaxSize())
    Text("Real zaragoza el mejor equipo del mundo", modificadorDado
        .fillMaxSize()
        .wrapContentSize(align = Alignment.Center))
}
@Composable
fun UIResponsiveBooleano(esFila: Boolean) {
    if(esFila){
            Row {
                TextoEImagen(modificadorDado = Modifier.weight(1f))
            }
        }
    else{
        Column{
            TextoEImagen(modificadorDado = Modifier.weight(1f))
        }
    }
}

@Composable
fun UIResponsiveTamanyoVentana(esColumna: Boolean) {
    if(esColumna){
        ColumnaImagen()
    }
    else{
        FilaImagen()

    }
}

