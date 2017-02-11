package davidrowantechnologies.sosapp;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.location.*;

public class MainActivity extends AppCompatActivity {
    boolean startSearchBool= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {

        } else {
            int TAG_CODE_PERMISSION_LOCATION=1;
            ActivityCompat.requestPermissions(this, new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION },
                    TAG_CODE_PERMISSION_LOCATION);

        }
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
                Intent intent  = new Intent(MainActivity.this,findOnMap.class);
                startActivity(intent);
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
                    GPSTracker gps = new GPSTracker(MainActivity.this);
                    if(gps.canGetLocation()) {
                        double latitude = gps.getLatitude();
                        double longitude = gps.getLongitude();

                        // \n is for new line
                        Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();

                    }

                }
                else {
                    startSearch.setBackgroundColor(Color.GREEN);
                    startSearch.setText("Start Searching");
                    startSearch.setTextColor(Color.BLUE);



                }
            }
        });
    }
}
