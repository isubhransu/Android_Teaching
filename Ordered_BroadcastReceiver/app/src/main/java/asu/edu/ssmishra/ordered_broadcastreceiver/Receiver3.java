package asu.edu.ssmishra.ordered_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

/**
 * Copyright 2015 Subhransu Mishra
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Purpose:
 *
 * @author Subhransu Mishra s.mishra@asu.edu
 *         MS Software Engineering, CIDSE, ASU
 * @version December 02 2015
 */

public class Receiver3 extends BroadcastReceiver {

    private final String TAG = "Receiver2";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "INTENT RECEIVED");

        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);

        Toast.makeText(context, "INTENT RECEIVED by Receiver3", Toast.LENGTH_LONG).show();
    }
}
