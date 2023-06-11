package com.app.limboapp.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.ui.theme.DarkGray
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
    @DrawableRes trailingIconId: Int? = null,
    onTrailingIconClick: () -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    enabled: Boolean = true,
    onKeyboardDone: () -> Unit = {}
) {
    TextField(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .width(300.dp),
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(22.dp),
        placeholder = {
            Text(
                text = hint,
                color = TextWhite,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )
        },
        textStyle = TextStyle(
            color = TextWhite
        ),
        trailingIcon = {
            IconButton(
                onClick = onTrailingIconClick,
                enabled = trailingIconId != null
            ) {
                Image(
                    painter = painterResource(
                        id = trailingIconId ?: R.drawable.transparent_icon
                    ),
                    contentDescription = hint,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(30.dp)
                )
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onAny = {
                onKeyboardDone()
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = TextWhite,
            disabledTextColor = TextWhite,
            backgroundColor = DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        visualTransformation = visualTransformation,
        enabled = enabled
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    var textState by remember { mutableStateOf("") }
    CustomTextField(
        value = textState,
        onValueChange = { textState = it },
        hint = "Preview TextField",
        trailingIconId = R.drawable.gradient_password_visible
    )
}