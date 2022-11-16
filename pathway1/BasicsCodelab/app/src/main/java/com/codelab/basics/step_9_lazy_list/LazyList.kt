package com.codelab.basics.step_9_lazy_list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.Greeting
import com.codelab.basics.ui.theme.BasicsCodelabTheme

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1_000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Preview
@Composable
fun LazyListPreview() {
    BasicsCodelabTheme {
        Greetings()
    }
}