package com.example.ejerciciosclasesui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ComponenteCuadrado() {
    Column(Modifier.fillMaxSize()) {
        // Para asignar el mismo espacio a cada componente,
        // se usa el modificador de peso.
        Row(Modifier.weight(1f)) {
            ComponenteCuadrado(
                titulo = stringResource(R.string.primer_titulo),
                desc = stringResource(R.string.primera_desc),
                color = colorResource(id = R.color.primer_color),
                modifier = Modifier.weight(1f)
            )
            ComponenteCuadrado(
                titulo = stringResource(R.string.segundo_titulo),
                desc = stringResource(R.string.segunda_desc),
                color = colorResource(id = R.color.segundo_color),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComponenteCuadrado(
                titulo = stringResource(R.string.tercer_titulo),
                desc = stringResource(R.string.tercera_desc),
                color = colorResource(id = R.color.tercer_color),
                modifier = Modifier.weight(1f)
            )
            ComponenteCuadrado(
                titulo = stringResource(R.string.cuarto_titulo),
                desc = stringResource(R.string.cuarta_desc),
                color = colorResource(id = R.color.cuarto_color),
                modifier = Modifier.weight(1f)
            )
        }
    }
}


/*
 * Con este componente puedo reutilizar esa parte de la UI que aparece más de una vez.
 * Hay que identificar qué es común (alineación del texto, por ejemplo) y que es diferente.
 * Lo que es diferente se ofrece como parámetro de entrada.
 */
@Composable
private fun ComponenteCuadrado(
    titulo: String,
    desc: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = titulo,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = desc,
            textAlign = TextAlign.Justify
        )
    }
}