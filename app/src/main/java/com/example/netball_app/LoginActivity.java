package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Name;
    EditText Password;
    TextView Info;
    Button Login;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.textView);
        Login = (Button) findViewById(R.id.btnLogin);

        Login.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);

    }

    //get id of view, basically an if statement, but cleaner
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                User user = new User(null, null);
                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
                startActivity(new Intent(this, HomeActivity.class));


                break;
        }
    }
}



