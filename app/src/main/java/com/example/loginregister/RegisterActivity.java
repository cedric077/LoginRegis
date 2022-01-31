package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnRegister;
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsername = findViewById(R.id.edt_username);
        txtPassword = findViewById(R.id.edt_password);
        btnRegister = findViewById(R.id.btn_regis);
        viewModel = new RegisterViewModel(getApplicationContext());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("fyz", "regis");
                if (txtUsername == null || txtUsername.getText().toString().equals("")){
                    txtUsername.setError("Enter Username");
                    txtUsername.requestFocus();
                    Log.d("fyz", "no username");
                } else if (txtPassword == null || txtPassword.getText().toString().equals("")){
                    txtPassword.setError("Enter Password");
                    txtPassword.requestFocus();
                    Log.d("fyz", "no password");
                }
                else {
                    boolean login = viewModel.checkUsername(txtUsername.getText().toString());

                    if (login != true) {
                        viewModel.createUser(txtUsername.getText().toString(), txtPassword.getText().toString());
                        Toast.makeText(RegisterActivity.this, "Success to Register", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Register Fail!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}