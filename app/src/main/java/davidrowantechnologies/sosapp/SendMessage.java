package davidrowantechnologies.sosapp;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Application;
import android.widget.Toast;
import android.telephony.SmsManager;

public class SendMessage extends AppCompatActivity {
    String phoneNum;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        final messageObject message = new messageObject();
        Button submit = (Button) findViewById(R.id.sendButton);
        final EditText name = (EditText) findViewById(R.id.nameInput);
        final EditText date = (EditText) findViewById(R.id.dateTimeInput);
        final EditText landmark = (EditText) findViewById(R.id.LansdmarksInput);
        final EditText emerInfo = (EditText) findViewById(R.id.emerInput);
        final EditText clothes = (EditText) findViewById(R.id.clothesInput);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                message.setName(name.getText().toString());
                message.setClothes(clothes.getText().toString());
                message.setLandmarks(landmark.getText().toString());
                message.setEmerInfo(emerInfo.getText().toString());
                message.setDate(date.getText().toString());
                sendSMSMessage();
                finish();
            }
        });
        ((myProperties) this.getApplication()).messageList.add(message);

    }

    protected void sendSMSMessage() {
        phoneNum = "2676647452";
        message = "hey";

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.SEND_SMS},
                        70);
            }
        }
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNum, null, message, null, null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 70: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNum, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }
}
