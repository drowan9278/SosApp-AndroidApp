package davidrowantechnologies.sosapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean startSearchBool= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendMessage = (Button) findViewById(R.id.msgSent); // Takes to send message activity
        Button findMap = (Button) findViewById(R.id.findMap); //needs activity
        Button settings = (Button) findViewById(R.id.setBut); //needs activity
        Button guidelines = (Button) findViewById(R.id.guideBut); // needs activity
        final Button startSearch = (Button) findViewById(R.id.startSearch); //a button that should turn colors when clicked
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SendMessage.class);
                startActivity(intent);
            }
        });

        findMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        guidelines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startSearchBool = !startSearchBool;
                if(startSearchBool){
                    startSearch.setBackgroundColor(Color.RED);
                    startSearch.setText("Stop Searching");
                    startSearch.setTextColor(Color.BLACK);
                }
                else {
                    startSearch.setBackgroundColor(Color.GREEN);
                    startSearch.setText("Start Searching");
                    startSearch.setTextColor(Color.BLUE);

                    GPSTracker gps = new GPSTracker(MainActivity.this);
                    if(gps.canGetLocation()) {
                        double latitude = gps.getLatitude();
                        double longitude = gps.getLongitude();

                        // \n is for new line
                        Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}
