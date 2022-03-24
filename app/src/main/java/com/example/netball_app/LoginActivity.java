package com.example.netball_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Username;
    EditText Password;
    Button Login;
    UserLocalStore userLocalStore;
    TextView Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);
        Register = findViewById(R.id.textView);

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);

    }

    //get id of view, basically an if statement, but cleaner
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                User user = new User(username, password);


                authenticate(user);

                break;
            case R.id.textView:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }
    }
    private void authenticate(User user){
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.fetchUserDataInBackground(user, returnedUser -> {
            if (returnedUser == null){
                showErrorMessage();
            }else{
                logUserin(returnedUser);
            }
        });
    }
    private void showErrorMessage(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LoginActivity.this);
        dialogBuilder.setMessage("Details are incorrect");
        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.show();
    }
    private void logUserin(User returnedUser){
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);

        startActivity(new Intent(this, HomeActivity.class));
    }
}



