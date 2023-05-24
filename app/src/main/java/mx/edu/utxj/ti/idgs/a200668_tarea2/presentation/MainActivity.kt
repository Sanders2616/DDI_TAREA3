/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package mx.edu.utxj.ti.idgs.a200668_tarea2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import mx.edu.utxj.ti.idgs.a200668_tarea2.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackgroundImage()
        }
    }
}

@Composable
fun BackgroundImage() {
    Box(modifier = Modifier.fillMaxSize()) {
        val backgroundImage = painterResource(R.drawable.sandy_img3)
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        AnimatedText("Holi Crayoli")
    }
}

@Composable
fun AnimatedText(text: String) {
    var isVisible by remember { mutableStateOf(true) }

    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 100)
    )

    AnimatedVisibility(visible = isVisible) {
        Text(
            text = text,
            fontSize = 40.sp,
            color = Color.Magenta,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize()
                .alpha(alpha)
                .padding(top = 50.dp)
        )
    }

    LaunchedEffect(key1 = isVisible) {
        isVisible = !isVisible
    }
}
