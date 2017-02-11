package davidrowantechnologies.sosapp;

import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener {
    //GoogleAPIClient needed for location and networking
    GoogleApiClient mGoogleApiClient;
    Location lastLocal;
    LocationRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API).build();
        }

    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lastLocal = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (lastLocal != null) {
            ((myProperties) this.getApplication()).setxCord(lastLocal.getLatitude());
            ((myProperties) this.getApplication()).setyCord(lastLocal.getLongitude());
        }
        if(((myProperties) this.getApplication()).isSearching()) {
            //I am very unsure about this line
            //Specifically the last argument, and whether this should be called from a seperate method
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, request, (LocationListener) this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        // TODO: Handle disconnections
        // GoogleApiClient will automatically attempt to
        // restore the connection. Applications should disable
        // UI components that require the service, and wait for
        // a call to onConnected(Bundle) to re-enable them.
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // TODO: Handle failed connections
        // Called when there was an error connecting
        // the client to the service.
    }

    //May have to tinker with these settings
    protected void createLocationRequest() {
        request = new LocationRequest();
        request.setInterval(20000);
        request.setFastestInterval(5000);
        request.setPriority(request.PRIORITY_HIGH_ACCURACY);
    }
}