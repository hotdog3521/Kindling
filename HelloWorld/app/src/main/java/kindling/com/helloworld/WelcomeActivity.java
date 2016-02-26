package kindling.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;


public class WelcomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // basic setup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitle(getString(R.string.app_name));

        //Hiding grey title bar at the top of the screen.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // detect login button click
        ImageButton loginButton = (ImageButton) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // detect signup button click
        ImageButton signupButton = (ImageButton) findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

        // detect playWithoutGame button click
        ImageButton playWithoutAccountButton;
        playWithoutAccountButton = (ImageButton) findViewById(R.id.playWithoutAccountButton);
        playWithoutAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MathGameActivity.class);
                startActivity(intent);
            }
        });
    }
}
