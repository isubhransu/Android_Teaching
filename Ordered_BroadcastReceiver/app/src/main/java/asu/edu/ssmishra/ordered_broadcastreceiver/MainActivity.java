package asu.edu.ssmishra.ordered_broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    static final String CUSTOM_INTENT ="asu.edu.ssmishra.ordered_broadcastreceiver.show_taost";

    private final Receiver1 mReceiver = new Receiver1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(CUSTOM_INTENT);
        intentFilter.setPriority(3);
        registerReceiver(mReceiver, intentFilter);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOrderedBroadcast(new Intent(CUSTOM_INTENT),
                        android.Manifest.permission.VIBRATE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }


}
