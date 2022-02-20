package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.util.Patterns;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.filament.View;

public class RegisterActivity extends AppCompatActivity {
    EditText FirstName, LastName, Email, Password, Password2;
    final int MIN_PASSWORD_LENGTH = 6;

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
        FirstName = findViewById(R.id.firstname);
        LastName = findViewById(R.id.lastname);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Password2 = findViewById(R.id.password2);

    }

    boolean validateInput() {
        if (FirstName.getText().toString().equals("")) {
            FirstName.setError("Please enter your First Name");
        }

        if (LastName.getText().toString().equals("")) {
            LastName.setError("Please enter your Last Name");
        }

        if (Email.getText().toString().equals("")) {
            Email.setError("Please enter your Email");
        }

        if (Password.getText().toString().equals("")) {
            Password.setError("Please enter your Password");
        }

        if (Password2.getText().toString().equals("")) {
            Password2.setError("Please enter the same password");
        }

        if (!isEmailValid(Email.getText().toString())) {
            Email.setError("Please enter a valid email");
            return false;
        }

        if (Password.getText().length() < MIN_PASSWORD_LENGTH) {
            Password.setError("Password should be more than" + MIN_PASSWORD_LENGTH);
            return false;
        }

        if (!Password.getText().toString().equals(Password2.getText().toString())) {
            Password2.setError("Passwords do not match");
            return false;

        }
        return true;
    }
}

