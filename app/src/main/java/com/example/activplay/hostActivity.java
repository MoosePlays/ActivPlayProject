package com.example.activplay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;
import com.spotify.sdk.android.authentication.*;

import static android.text.InputType.TYPE_CLASS_TEXT;


public class hostActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1337;
    private static final String REDIRECT_URI = "google.com";
    private Button createButton;
    private RadioGroup privacySetting;
    private String inText = "";

    AuthenticationRequest.Builder builder = new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI);

    //Todo: find why setScopes() and openLoginActivity() don't work
    //builder.setBuilder(new String[]{"streaming"});

    AuthenticationRequest request = builder.build();

    //AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);

    //spotify credentials
    private static final String CLIENT_ID = "0a5ebc3847e84ef0933b6f72aa3aeb2f";
    private SpotifyAppRemote mSpotifyAppRemote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        //set RadioGroup's click listener
        privacySetting = (RadioGroup) findViewById(R.id.privacyRadioGroup);

        //set createButton's click listener
        createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createButtonPress();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    //spotify stuff
    @Override
    protected void onStart(){
        super.onStart();
        ConnectionParams connectionParams =
                new ConnectionParams.Builder(CLIENT_ID)
                        .setRedirectUri(REDIRECT_URI)
                        .showAuthView(true)
                        .build();

        SpotifyAppRemote.connect(this, connectionParams,
                new Connector.ConnectionListener() {

                    @Override
                    public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                        mSpotifyAppRemote = spotifyAppRemote;
                        Log.d("MainActivity", "Connected! Yay!");

                        // Now you can start interacting with App Remote
                        connected();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.e("MainActivity", throwable.getMessage(), throwable);
                        //Todo: error message if it doesn't connect properly

                    }
                });
    }
    */
    private void connected() {
        //Todo: add functions for modifying play state/playlist stuff here

    }

    @Override
    protected void onStop() {
        super.onStop();
        //Todo: disconnect properly from spotify app
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);

            switch (response.getType()) {
                case TOKEN:
                    //correct response
                    break;

                case ERROR:
                    //error stuff
                    break;

                default:
                    //etc
            }
        }
    }

    //TODO this doesnt seem to be working, but overall hostActivity looks good
    //click function for create button press
    private void createButtonPress() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");

        //set up input:
        final EditText input = new EditText(this);
        //specify the type on input expected
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        //button set up
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                inText = input.getText().toString();
            }
        });

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
}
