package com.example.activplay;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button joinButton, hostButton, settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set joinButton's click listener
        joinButton = findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openJoinActivity();
            }
        });

        //set hostButton's click listener
        hostButton = findViewById(R.id.hostButton);
        hostButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHostActivity();
            }
        });
    }

    //go to the join group page
    public void openJoinActivity(){
        Intent intent = new Intent(this, joinActivity.class);
        startActivity(intent);
    }

    //go to the host page
    public void openHostActivity(){
        Intent intent = new Intent(this, hostActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //handle settings click
        if (id == R.id.settingsButton) {
            Intent intent = new Intent(this, settingsMenu.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
