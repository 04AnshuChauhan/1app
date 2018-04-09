package com.anshu.its;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText userPassword, userMail;
    private Button loginButton;
    private TextView LoginPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPassword = (EditText) findViewById(R.id.editPassword);
        userMail = (EditText) findViewById(R.id.editMail);
        loginButton = (Button) findViewById(R.id.btnLogin);
        LoginPage = (TextView) findViewById(R.id.LOGIN);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view) {
            String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                    "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                    "(" + "\\." +

                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"+

                    ")+";
            String email = userMail.getText().toString();


            Matcher matcher= Pattern.compile(validemail).matcher(email);
            if (matcher.matches()){
                Toast.makeText(getApplicationContext(),"Valid email",Toast.LENGTH_LONG).show();
                String validPassword = "ac12345";
                String Password = userPassword.getText().toString();
                Matcher matcher1= Pattern.compile(validPassword).matcher(Password);
                if (matcher1.matches()) {
                    Log.e("d11", Password);
                    Toast.makeText(getApplicationContext(), "Password Match", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Signed In", Toast.LENGTH_LONG).show();
                    getFragmentManager().popBackStack();
                    Welcome();

                } else {
                    userPassword.setError("Password");
                    Toast.makeText(getApplicationContext(), "Password not Match", Toast.LENGTH_LONG).show();
                }

            }
            else {
                Toast.makeText(getApplicationContext(),"Invalid Email-Id",Toast.LENGTH_LONG).show();
            }
        }
        });

    }
    public void Welcome()
    {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }
}