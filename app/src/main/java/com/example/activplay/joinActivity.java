package com.example.activplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.EditText;


public class joinActivity extends AppCompatActivity {

    private Button joinButton;
    private String inName;
    private String inRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //set joinButton's click listener
        joinButton = findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                joinButtonPress();
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.settingsButton) {
            Intent intent = new Intent(this, settingsMenu.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void joinButtonPress() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Room Name");
        builder.setCancelable(true);

        //set up input:
        final EditText input = new EditText(this);
        //specify the type on input expected
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        //button set up
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                inRoom = input.getText().toString();
                openUserMenu(inRoom);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void openUserMenu(String input){
        Intent intent = new Intent(this, userMenu.class);
        intent.putExtra("roomName", input);
        startActivity(intent);
    }
}


