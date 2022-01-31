package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private TextView linkRegister;
    private Button btnLogin;
    private EditText txtUsername;
    private EditText txtPassword;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        linkRegister = findViewById(R.id.register_link);
        btnLogin = findViewById(R.id.btn_login);
        txtUsername = findViewById(R.id.edt_username);
        txtPassword = findViewById(R.id.edt_password);
        viewModel = new LoginViewModel(getApplicationContext());
//        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        linkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = viewModel.checkValidLogin(txtUsername.getText().toString(), txtPassword.getText().toString());
                if(isValid)
                {
                    Toast.makeText(getBaseContext(), "Successfully Logged In!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Username/Password Wrong! Please Check Again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}