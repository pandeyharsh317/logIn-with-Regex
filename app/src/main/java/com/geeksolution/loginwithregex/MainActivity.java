package com.geeksolution.loginwithregex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText et_email, et_password;
    private TextView error_email, error_password;
    private String email, password;
    public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern Password_REGEX = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        error_email = (TextView) findViewById(R.id.error_email);
        error_password = (TextView) findViewById(R.id.error_password);
    }

    public void submit(View view) {
        email = et_email.getText().toString();
        password = et_password.getText().toString();

        if (validateEmail(email) | validatePassword(password)) {
            //Toast.makeText(this, "" + email + password, Toast.LENGTH_SHORT).show();
            if (email.equals("admin@gmail.com") && password.equals("Password@123")) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                et_email.setBackgroundResource(R.drawable.success);
                et_password.setBackgroundResource(R.drawable.success);
            } else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                et_email.setBackgroundResource(R.drawable.error_layout);
                et_password.setBackgroundResource(R.drawable.error_layout);
            }
        }
        validateEmail(email);

        //blank validation for email
        //for password validation
    }


    private boolean validateEmail(String email) {
        if (email.isEmpty()) {
            error_email.setText("Email Field is required");
            et_email.setBackgroundResource(R.drawable.error_layout);
            return false;

        }
        if (!EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
            error_email.setText("Email Field is Required");
            error_email.setText("Invalid Email");
            return false;
        }

        et_email.setBackgroundResource(R.drawable.success);
        error_email.setText("");
        return true;
    }

    private boolean validatePassword(String password) {
        if (password.isEmpty()) {
            error_password.setText("password Field is required");
            et_password.setBackgroundResource(R.drawable.error_layout);
            return false;

        }
        if (!Password_REGEX.matcher(email).matches()) {
            error_password.setText("Invalid password");
            return false;
        }
        et_password.setBackgroundResource(R.drawable.success);
        error_password.setText("");
        return true;
    }
}
