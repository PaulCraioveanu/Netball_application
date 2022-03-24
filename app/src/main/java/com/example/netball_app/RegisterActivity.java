package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.filament.View;

public class RegisterActivity extends AppCompatActivity implements android.view.View.OnClickListener{
    EditText etName, etUsername, etEmail, etPassword, etAge;
    final int MIN_PASSWORD_LENGTH = 6;
    Button bRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewInitializations();
    }

    boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    void viewInitializations() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAge = findViewById(R.id.etAge);
        bRegister = (Button) findViewById(R.id.Registerbutton);
        bRegister.setOnClickListener(this);

    }


    boolean validateInput() {
        if (etName.getText().toString().equals("")) {
            etName.setError("Please enter your First Name");
        }

        if (etEmail.getText().toString().equals("")) {
            etEmail.setError("Please enter your Email");
        }

        if (etPassword.getText().toString().equals("")) {
            etPassword.setError("Please enter your Password");
        }

        if (etAge.getText().toString().equals("")) {
            etAge.setError("Please enter a number");
        }

        if (!isEmailValid(etEmail.getText().toString())) {
            etEmail.setError("Please enter a valid email");
            return false;
        }

        if (etPassword.getText().length() < MIN_PASSWORD_LENGTH) {
            etPassword.setError("Password should be more than" + MIN_PASSWORD_LENGTH);
            return false;
        }
        return true;
    }

    @Override
    public void onClick(android.view.View view) {
        switch (view.getId()) {
            case R.id.Registerbutton:

                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                User registeredData = new User(name, age, username, email, password);

                break;

        }
    }

}

