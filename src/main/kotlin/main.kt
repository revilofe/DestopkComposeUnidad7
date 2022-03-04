import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

/**
 * App
 *
 */
@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
/*
    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
 */

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Kotlin spain") },
                    modifier = Modifier.padding(horizontal = 0.dp, vertical = 10.dp)
                )
            },
            modifier = Modifier.padding(10.dp)
        ) {
            todoInput(
                text = text,
                onValueChange = { text = it },
                onAddClick = {},
            )
        }
    }

}

/**
 * Todo input
 *
 * @param text
 * @param modifier
 * @param onValueChange
 * @param onAddClick
 * @receiver
 * @receiver
 */
@Composable
fun todoInput(
    text: String,
    modifier: Modifier = Modifier,
    onValueChange: (text: String) -> Unit,
    onAddClick: () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = text,
            label = { Text("Task name") },
            onValueChange = onValueChange
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = onAddClick
        ) {
            Text("Add Task")
        }
    }
}


/**
 * Main
 *
 */
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
