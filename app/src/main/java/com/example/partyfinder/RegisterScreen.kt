package com.example.partyfinder

import android.annotation.SuppressLint
import com.example.partyfinder.Data.Register.RegistrationViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.partyfinder.Data.Register.RegisterUIEvent
import com.example.partyfinder.Navigation.PartyUpRouterSam
import com.example.partyfinder.Navigation.Screens
import com.example.partyfinder.ui.theme.PartyFinderTheme

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun RegisterPage(registrationViewModel : RegistrationViewModel = viewModel()) {
    Box(
        modifier = Modifier
            .height(808.dp)
            .width(393.dp)
            .background(color = colorResource(id = R.color.black))
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .padding(top = 60.dp, bottom = 80.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Party\nUp!",
                    style = MaterialTheme.typography.displayMedium,
                    color = colorResource(id = R.color.primary)
                )
                Image(
                    painter = painterResource(id = R.drawable.partyup_logo),
                    contentDescription = "Register Logo",
                    modifier = Modifier
                        .size(120.dp)
                )
            }

            Text(
                text = "Create An Account",
                style = MaterialTheme.typography.titleMedium,
                color = colorResource(id = R.color.primary)
            )

            Spacer(modifier = Modifier.height(32.dp))

            CustomOutlinedTextField(labelValue = "Email",
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon") },
                onTextSelected = {
                    registrationViewModel.onEvent(RegisterUIEvent.EmailChanged(it))
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextFieldComponent(labelValue = "Password",
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
                onTextSelected = {
                    registrationViewModel.onEvent(RegisterUIEvent.PasswordChanged(it))
                }
            )

            CustomCheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    PartyUpRouterSam.navigateTo(Screens.TermsAndConditionsScreen)
                },
                onCheckedChange = {
                    registrationViewModel.onEvent(RegisterUIEvent.PrivacyPolicyCheckBoxClicked(it))
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ButtonComponent(value = "Register",
                onButtonClicked = { registrationViewModel.onEvent(RegisterUIEvent.RegisterButtonClicked) },
                isEnabled = registrationViewModel.registrationUIState.value.policyStatus)

            DividerTextComponent()

            Spacer(modifier = Modifier.height(8.dp))

            ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                PartyUpRouterSam.navigateTo(Screens.LoginScreen)
            })
        }
        if(registrationViewModel.registrationInProgress.value) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colorResource(id = R.color.primary) )
        }
    }
}



@Preview
@Composable
fun PreviewRegisterPage(){
    PartyFinderTheme {
        RegisterPage()
    }
}


