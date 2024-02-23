package com.example.basiccalculatorapp.ui.screens.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccalculatorapp.data.CalculatorButton
import com.example.basiccalculatorapp.ui.utils.ButtonsFontSize

@Composable
fun PrimaryButtonsPane(
    buttonsFontSize: ButtonsFontSize,
    onClickAction: (CalculatorButton) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Clear,
                CalculatorButton.Symbol("("),
                CalculatorButton.Symbol(")"),
                CalculatorButton.Symbol("+"),
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Symbol("1"),
                CalculatorButton.Symbol("2"),
                CalculatorButton.Symbol("3"),
                CalculatorButton.Symbol("-"),
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Symbol("4"),
                CalculatorButton.Symbol("5"),
                CalculatorButton.Symbol("6"),
                CalculatorButton.Symbol("*"),
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Symbol("7"),
                CalculatorButton.Symbol("8"),
                CalculatorButton.Symbol("9"),
                CalculatorButton.Symbol("/"),
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.Symbol("."),
                CalculatorButton.Symbol("0"),
                CalculatorButton.Symbol(","),
                CalculatorButton.Equals
            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
    }
}

@Composable
fun SecondaryButtonsPane(
    buttonsFontSize: ButtonsFontSize,
    onClickAction: (CalculatorButton) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.MathematicalFunction(
                    "sin",
                    "sin(",
                    "sin("
                ),
                CalculatorButton.MathematicalFunction(
                    "cos",
                    "cos(",
                    "cos("
                ),
                CalculatorButton.MathematicalFunction(
                    "tan",
                    "tan(",
                    "tan("
                ),
            ),
            modifier = Modifier.weight(1F)
            )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.MathematicalFunction(
                    "sqrt",
                    "sqrt(",
                    "sqrt("
                ),
                CalculatorButton.MathematicalFunction(
                    "xʸ",
                    "^(",
                    "^("
                ),
                CalculatorButton.MathematicalFunction(
                    "ln",
                    "log(",
                    "log("
                )
            ),
            modifier = Modifier.weight(1F)
            )
        RowOfButtons(
            buttonsFontSize = buttonsFontSize,
            onClickAction = onClickAction,
            buttons = listOf(
                CalculatorButton.MathematicalFunction(
                    "logₓy",
                    "logₓy(",
                    "logB("
                ),
                CalculatorButton.Symbol("e"),
                CalculatorButton.Symbol("π")
            ),
            modifier = Modifier.weight(1F)
        )
    }
}
@Composable
fun RowOfButtons(
    buttonsFontSize: ButtonsFontSize,
    onClickAction: (CalculatorButton) -> Unit,
    buttons: List<CalculatorButton>,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        buttons.forEach { button: CalculatorButton->
            Button(
                onClick = { onClickAction(button) },
                modifier = Modifier
                    .clip(CircleShape)
                    .weight(1F)
                    .fillMaxHeight()
                    .padding(4.dp)
            ) {
                Text(
                    text = button.buttonText,
                    fontSize =
                        if (buttonsFontSize == ButtonsFontSize.Expanded) 32.sp
                        else 12.sp
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrimaryButtonsPanePreview() {
    PrimaryButtonsPane(
        buttonsFontSize = ButtonsFontSize.Expanded,
        onClickAction = {_->},
        modifier = Modifier.fillMaxWidth()
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SecondaryButtonsPanePreview() {
    SecondaryButtonsPane(
        buttonsFontSize = ButtonsFontSize.Expanded,
        onClickAction = {_->},
        modifier = Modifier.fillMaxWidth()
    )
}
