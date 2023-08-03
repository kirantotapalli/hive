package com.android.hive.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.android.hive.R
import com.android.hive.domain.UserUseCase
import com.android.hive.model.Response
import com.android.hive.repository.PasswordResponse
import com.android.hive.repository.SaveResponse
import com.android.hive.screens.Routes
import com.android.hive.utils.SharedPreferencesUtil
import com.android.hive.utils.USER_PASSWORD
import com.android.hive.utils.isValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val useCase: UserUseCase) : ViewModel() {
    private val _passwordResult = MutableLiveData<SaveResponse>()
    val passwordResult: LiveData<SaveResponse> get() = _passwordResult

    private val _passwordInfo = MutableLiveData<PasswordResponse>()
    val passwordInfo: LiveData<PasswordResponse> get() = _passwordInfo

    private var isPassword = false


    /**
     * check password.
     *
     * @param password String
     * @param navController NavHostController
     * @param context Context
     */
    fun checkPassword(password: String, navController: NavHostController, context: Context) {
        if (isValidPassword(password)) {
            viewModelScope.launch {
                _passwordResult.postValue(
                    useCase.savePassword(password)
                )
            }
            moveToLastScreen(navController)
        } else {
            _passwordResult.value =
                Response.Failure(context.getString(R.string.str_password_validation))
        }
    }

    /**
     * This function will move to First screen.
     */
    fun moveToFirstScreen(navController: NavHostController) {
        navController.navigate(Routes.FirstPage.route) {
            popUpTo(0)
            launchSingleTop = true
        }
    }

    /**
     * This function will move to Second screen.
     */
    fun moveToSecondScreen(navController: NavHostController) {
        navController.navigate(Routes.SecondPage.route)
    }

    /**
     * This function will move to Last screen.
     */
    private fun moveToLastScreen(navController: NavHostController) {
        navController.navigate(Routes.LastPage.route) {
            popUpTo(0)
            launchSingleTop = true
        }
    }

    /**
     * This function will fetch the password from the shared preferences.
     */
    fun getPasswordInfo(){
        viewModelScope.launch {
            _passwordInfo.postValue(useCase.getPassword())
        }
    }

    /**
     * This function will clear the password from the shared preferences.
     */
    fun onClearButtonClick() {
        viewModelScope.launch {
            _passwordResult.postValue(useCase.savePassword(""))
        }
    }
    /**
     * This function checks the password.
     */
    fun isPasswordExist(context: Context): Boolean {
        val pass = SharedPreferencesUtil.getEncryptedSharedPreferences(context)
            .getString(USER_PASSWORD, "")
        return pass.toString().isNotEmpty()
    }
}
