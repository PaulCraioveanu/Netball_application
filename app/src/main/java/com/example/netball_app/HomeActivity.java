package com.example.netball_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Profile;
    Button idBtnLogout;
    EditText etName, etUsername, etEmail;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);

        idBtnLogout = (Button) findViewById(R.id.idBtnLogout);
        idBtnLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

        //test
        Profile = (Button) findViewById(R.id.Profilebtn);
        //test

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (authenticate() == true){
            displayUserDetails();

        }

    }

    private boolean authenticate(){

        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails (){
        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
        etEmail.setText(user.email);
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