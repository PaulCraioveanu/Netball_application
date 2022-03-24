package com.example.netball_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements android.view.View.OnClickListener{
    EditText etName;
    EditText etUsername;
    EditText etPassword;
    EditText etAge;
    Button bRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewInitializations();
    }

    void viewInitializations() {
        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etAge = findViewById(R.id.etAge);
        bRegister = findViewById(R.id.Registerbutton);
        bRegister.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(android.view.View view) {
        switch (view.getId()) {
            case R.id.Registerbutton:

                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                User user = new User(name, age, username, password);

                registerUser(user);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
    private void registerUser(User user){
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeUserDataInBackground(user, returnedUser -> startActivity(new Intent(RegisterActivity.this, LoginActivity.class)));
    }

}

