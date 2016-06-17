package asu.edu.ssmishra.broadcastreciever_example;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);

    private BroadcastReceiver reciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
            Toast.makeText(getBaseContext(), "ACTION_TIME_TICK intent recieved",
                    Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onResume() {
        this.registerReceiver(reciever, filter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        this.unregisterReceiver(reciever);
        super.onPause();
    }
}
