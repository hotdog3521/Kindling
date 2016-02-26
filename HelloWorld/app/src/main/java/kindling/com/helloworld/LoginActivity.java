package kindling.com.helloworld;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import database.tasks.AuthTask;
import helper.StringFunctions;
import model.kindling.Application;
import model.kindling.User;

public class LoginActivity extends ActionBarActivity {

    // EditText fields
    EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // basic setup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getString(R.string.login));

        //Hiding grey title bar at the top of the screen.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Font path
        String fontPath = "fonts/Souses.otf";

        usernameEditText = (EditText) findViewById(R.id.username_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        //Loading Font Face

        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);


        usernameEditText.setTypeface(tf);
        passwordEditText.setTypeface(tf);


        // Login Button should send us to Matching.
        ImageButton loginButton = (ImageButton) findViewById(R.id.actualLoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the login information is valid.
                if (invalidFields()) {
                    Toast.makeText(getApplicationContext(),
                            R.string.invalid_input, Toast.LENGTH_SHORT).show();
                    return;
                }

                // Make user to send from information given
                User sendU = new User(usernameEditText.getText().toString());
                sendU.setPassword(passwordEditText.getText().toString());

//                // Send user
//                AuthTask at = new AuthTask(sendU);
//                Thread t = new Thread(at);
//                t.start();
//                try {
//                    t.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                User returned = at.getResult();
//
//                // If failed, show toast and leave
//                if (returned == null) {
//                    Toast.makeText(getApplicationContext(),
//                            R.string.auth_fail, Toast.LENGTH_LONG).show();
//                    return;
//                }

                // initialize application with a user
                Application.initApplication(sendU);

                Intent intent = new Intent(v.getContext(), MatchingActivity.class);
                startActivity(intent);
            }
        });

    }

    // Checks if the Fields are filled with invalid text
    private boolean invalidFields() {
        // Input invalid if Username is only whitespace or password is empty
        return StringFunctions.isWhiteSpace(usernameEditText.getText().toString()) ||
                passwordEditText.getText().toString().isEmpty();
    }
}
