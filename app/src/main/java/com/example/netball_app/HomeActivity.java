package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button idBtnLogout;
    EditText etName;
    EditText etUsername;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        idBtnLogout = findViewById(R.id.idBtnLogout);
        idBtnLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

        //test
        Button profile = findViewById(R.id.Profilebtn);
        //test

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (authenticate()){
            displayUserDetails();

        }else
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));

    }

    private boolean authenticate(){

        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails (){
        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.idBtnLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent(this, FirstActivity.class));

                break;
        }
    }
}