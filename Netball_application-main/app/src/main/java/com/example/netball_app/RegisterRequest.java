package com.example.netball_app;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://netball-app.000webhostapp.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String name, String email, String password, int age, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
        params.put("age", age + "");
    }

    @Nullable
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
