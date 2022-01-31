package com.example.loginregister;

import androidx.lifecycle.LiveData;

public class Repository {

    private final DaoInterface userAccountDao;
    private static Repository instance;
    private LiveData<User> userAccountLiveData;

    private Repository(DaoInterface userAccountDao)
    {
        this.userAccountDao = userAccountDao;
    }

    public static Repository getInstance(DaoInterface userAccountDao)
    {
        if(instance == null)
        {
            instance = new Repository(userAccountDao);
        }
        return instance;
    }

    public boolean isValidAccount(String username, final String password)
    {

        User userAccount = userAccountDao.getAccount(username);
        if (userAccount != null) {
            return userAccount.getPassword().equals(password);
        }else {
            return false;
        }
    }

    public boolean checkUsername(String username){
        User userAccount = userAccountDao.getAccount(username);
        if (userAccount != null) {
            return true;
        }else {
            return false;
        }
    }

    public void insertUser(String username, String password)
    {
        User account = new User(username, password);
        userAccountDao.insert(account);
    }
}