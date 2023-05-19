package com.rcmkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rcmkt.ui.theme.ValueClassConstantBugTheme
import java.math.BigDecimal

@JvmInline
@Immutable
value class Number(val value: BigDecimal)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValueClassConstantBugTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NumberField(
                        value = Number(BigDecimal(10)),
                    )
                }
            }
        }
    }
}

val MaxValue = Number(BigDecimal(1000))

@Composable
fun NumberField(value: Number, maxValue: Number = MaxValue) {
    Text(
        text = "${value.value}",
    )
}