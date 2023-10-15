package com.example.ejerciciosclasesui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.sharp.Lock
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Ejercicio sencillo donde se muestra el estado, con un botón que aumenta un contador.
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ejemploEstado() {
    var cuenta by remember { mutableStateOf(0) }

    FilledTonalButton(
        onClick = {
            cuenta = Math.random().toInt()
        }
    ) {
        Text(text = cuenta.toString())
    }
}

//
@Preview
@Composable
fun cuadrosTexto(){

    Column {
        CuadroTexto()
        CuadroTextoLargo()
        TextFieldConColores()
        TextFieldConExtraLineas()
        TextFieldControlarVisibilidad()
        EjemploKeyboard()
    }
}


// Ejemplo del TextField y alguno de sus parámetros
@Preview
@Composable
fun CuadroTexto(){
    var texto by remember { mutableStateOf("") }
    OutlinedTextField(value = texto, onValueChange = {
            textoIntroducido -> texto = textoIntroducido
    },
        label = { Text("Mete datos") },
        placeholder = { Text("No hay datos metidos") },
        prefix = { Text(text = "+34") },
        suffix = { Text(text = "ESP") })
}


// Ejercicio que controla la longitud del stirng introducido por teclado.
@Composable
fun CuadroTextoLargo() {
    val maximo = 5
    var texto by remember { mutableStateOf("") }
    var demasiadoLargo by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = texto,
        onValueChange = { nuevoTexto ->
            texto = nuevoTexto
            demasiadoLargo = nuevoTexto.length > maximo;

        },
        supportingText = { Text("${texto.length}/$maximo") },
        label = { Text("Escribe tu nombre") },
        placeholder = { Text("¿Cómo te llamas?") },
        isError = demasiadoLargo,
        leadingIcon = { Icon(
            Icons.Sharp.Star,
            contentDescription = null) },
        trailingIcon = { IconButton(onClick = { texto = "" }) {
            Icon(Icons.Filled.Clear, contentDescription = "")
        }
        }
        ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}


// Ejemplo de implementación de un RadioButton
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun EjemploRadioButton() {
    var estaPulsado by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        RadioButton(
            selected = estaPulsado,
            onClick = {
                estaPulsado = !estaPulsado
            }
        )
        Text(text = "Modo difícil")
    }
}


// Ejercicio 2 del fichero "Ejercicios UI"
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ejemploSwitch(){
    var pulsado by remember{ mutableStateOf(false) }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Switch(checked = pulsado , onCheckedChange = {
            pulsado = !pulsado
        })
        Text(text = if(pulsado) "Activado" else "Desactivado", color = Color(255,192,203))
    }

}


// Ejercicio de las diapositivas de textField
@Composable
fun TextFieldControlarVisibilidad() {
    var texto by remember { mutableStateOf("") }
    var visibilidad by remember { mutableIntStateOf(R.drawable.visibility) }
    var efectoVisual by remember { mutableStateOf(VisualTransformation.None) }

    fun cambioVisibilidad() {
        if(visibilidad == R.drawable.visibility) {
            visibilidad = R.drawable.visibility_off
            efectoVisual = VisualTransformation.None
        }
        else{
            visibilidad = R.drawable.visibility
            efectoVisual = PasswordVisualTransformation()
        }
    }

    OutlinedTextField(
        value = texto,
        onValueChange = { nuevoTexto ->
            texto = nuevoTexto
        },
        label = { Text("Escribe la password") },
        placeholder = { Text("Introduce la contraseña") },
        leadingIcon = { Icon(
            Icons.Sharp.Lock,
            contentDescription = null) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = efectoVisual,
        trailingIcon = { IconButton(onClick = { cambioVisibilidad()}) {
            Icon(painter = painterResource(id = visibilidad), contentDescription = "")
        }
        }
        ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}



@Composable
fun TextFieldConExtraLineas() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = { Text("Escribe un párrafo") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        maxLines = 5, // Permite múltiples líneas
    )
}

@Composable
fun TextFieldConColores() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = { Text("Texto personalizado") },
        colors = TextFieldDefaults.colors(unfocusedTextColor = Color.Red,
        cursorColor = Color.Blue,
        errorTextColor = Color.Yellow,
        focusedTextColor = Color.Cyan)
        ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun EjemploKeyboard() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = { Text("Acciones de teclado") },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                // Acción personalizada cuando se presiona "Buscar" en el teclado
                // Puedes realizar búsquedas u otras acciones aquí.
            }
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
