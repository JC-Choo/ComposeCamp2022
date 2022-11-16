package com.codelab.basics

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.step_8_state_hoisting.MyApp
import com.codelab.basics.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp(Modifier.fillMaxSize())
            }
        }
    }
}

//@Composable
//fun MyApp(
//    modifier: Modifier = Modifier,
//    names: List<String> = listOf("World", "Compose")
//) {
//    Column(modifier = modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}

@Composable
fun Greeting(name: String) {
//    val expanded = remember { mutableStateOf(false) }
////    val extraPadding = if (expanded.value) 48.dp else 0.dp
//    /** 상태값 저장 -> 스크롤 시 돌아와도 상태 값 저장 */
////    val expanded = rememberSaveable { mutableStateOf(false) }
//    /** 기본 애니메이션 적용 */
////    val extraPadding by animateDpAsState(
////        targetValue = if (expanded.value) 48.dp else 0.dp
////    )
//    /** 스프링 애니메이션 적용 */
//    val extraPadding by animateDpAsState(
//        targetValue = if (expanded.value) 48.dp else 0.dp,
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy, // 제동
//            stiffness = Spring.StiffnessLow // 단단함, 뻣뻣함
//        )
//    )
//
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(bottom = extraPadding.coerceAtLeast(0.dp)) // coerce : 강요하다, 억지로 시키다.
//            ) {
//                Text(text = "Hello, ")
//                Text(
//                    text = name,
//                    style = MaterialTheme.typography.headlineMedium.copy(
//                        fontWeight = FontWeight.ExtraBold
//                    )
//                )
//            }
//            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
//                Text(text = if (expanded.value) "Show less" else "Show more")
//            }
//        }
//    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy. pdding theme elit, sed do bouncy.").repeat(4)
                )
            }
        }
        IconButton(onClick = { expanded = !expanded}) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(id = R.string.show_less)
                } else {
                    stringResource(id = R.string.show_more)
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        Greeting("Android")
//        MyApp()
    }
}