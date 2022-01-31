package com.example.loginregister;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginViewModel extends ViewModel {
    private Repository userRepository;

    public LoginViewModel(Context context) {

        userRepository = Repository.getInstance(UserDatabase.getAppDatabase(context).userDao());
    }

    boolean checkValidLogin(String username, String password)
    {
        return userRepository.isValidAccount(username, password);
    }
}
