package com.example.loginregister;

import android.content.Context;

public class RegisterViewModel {
    private Repository userRepository;

    public RegisterViewModel(Context context) {

        userRepository = Repository.getInstance(UserDatabase.getAppDatabase(context).userDao());
    }

    void createUser(String username, String password)
    {
        userRepository.insertUser(username, password);
    }

    boolean checkUsername(String username)
    {
        return userRepository.checkUsername(username);
    }
}
