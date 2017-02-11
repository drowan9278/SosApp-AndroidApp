package davidrowantechnologies.sosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        final int interval=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button vibrate = (Button) findViewById(R.id.vibrateBut);
        Button noise = (Button) findViewById(R.id.noiseBut);
        Button enter = (Button) findViewById(R.id.enterInt);
        final EditText intervalTime = (EditText) findViewById(R.id.timeInt);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp;
                temp=intervalTime.getText().toString();
                //interval=Integer.parseInt(temp);

            }
        });
        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        noise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void vibrate()
    {

    }
    public void noise()
    {

    }
    public int UpdateInterval(int interval) {
        return 1;
    }
}
