package com.example.activplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class hostMenu extends AppCompatActivity {

    private Button disconnectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_menu);
        String roomName = "Your room name:\n" + getIntent().getStringExtra("roomName");

        //set disconnect button listener
        disconnectButton = findViewById(R.id.disconnectButton);
        disconnectButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                disconnectButtonPress();
            }
        });

        //update textView
        TextView roomNameView = findViewById(R.id.roomNameText);
        roomNameView.setText(roomName);

        //for now just add in a random number :)
        String userCount = "Activ Users:\n" + (int)(Math.random()*(101));
        TextView userCountView = findViewById(R.id.activUsersText);
        userCountView.setText(userCount);
    }


    //next two methods are just for getting to the options menu
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
