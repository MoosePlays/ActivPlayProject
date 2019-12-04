package com.example.activplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class userMenu extends AppCompatActivity {

    private Button disconnectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);
        String roomName = "Connected to:\n" + getIntent().getStringExtra("roomName");

        //set disconnectButton listener
        disconnectButton = findViewById(R.id.disconnectButton);
        disconnectButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                disconnectButtonPress();
            }
        });

        //update textView
        TextView textView = findViewById(R.id.roomNameText);
        textView.setText(roomName);

        //now playing stuff:
        String currentSong = "Now Playing\n" + "Sicko Mode"; //"sicko mode" will be substituted with the actual song playing
        TextView nowPlaying = findViewById(R.id.nowPlaying);
        nowPlaying.setText(currentSong);
    }

    //all this is just for the options menu
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.settingsButton) {
            Intent intent = new Intent(this, settingsMenu.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void disconnectButtonPress(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
