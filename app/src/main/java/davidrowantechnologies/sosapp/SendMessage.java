package davidrowantechnologies.sosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Application;
import android.widget.Toast;

public class SendMessage extends AppCompatActivity {

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
                Toast.makeText(SendMessage.this, "Your message has been added, it will be sent!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        ((myProperties) this.getApplication()).messageList.add(message);

    }

}
