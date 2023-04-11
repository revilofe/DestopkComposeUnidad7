import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

/**
 * Main
 *
 */
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

/**
 * App
 *
 */
@Composable
@Preview
fun App() {
    val todos = remember { mutableStateListOf<String>() }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Kotlin test") },
                    modifier = Modifier.padding(horizontal = 0.dp, vertical = 10.dp),
                )
            },
            modifier = Modifier.padding(10.dp),
        ) {
            todoComposable(todos)
        }
    }
}

/**
 * Todo composable
 *
 * @param todos
 */
@Composable
private fun todoComposable(todos: MutableList<String>) {
    var textTodo by remember { mutableStateOf<String>("") }

    Column() {
        Row(
            modifier = Modifier.fillMaxSize(),
        ) {
            todoList(todos = todos)
            todoInput(
                text = textTodo,
                onValueChange = { textTodo = it },
                onAddClick = { todos.add(textTodo) },
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
            onValueChange = onValueChange,
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = onAddClick,
        ) {
            Text("Add Task")
        }
    }
}

/**
 * Todo list
 *
 * @param todos
 */
@Composable
fun todoList(todos: List<String>) {
    Column(
        modifier = Modifier.fillMaxWidth(0.5F)
            .fillMaxHeight()
            .verticalScroll(
                state = ScrollState(0),
                enabled = true,
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Todo list:",
            style = MaterialTheme.typography.h5,
        )
        for (todoName in todos) {
            todoText(name = todoName)
        }
    }
}

/**
 * Todo text
 *
 * @param name
 */
@Composable
fun todoText(name: String) {
    Text(
        text = name,
        modifier = Modifier.padding(2.dp),
    )
}
