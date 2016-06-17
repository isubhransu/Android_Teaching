package edu.asu.msse.ssmishr2.waypointmanipulation;
/**
 * Copyright 2015 Subhransu Mishra
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Purpose: This is for educational purpose only. Prof. Tim Lindquist and TA Sachin Dheeraj have right to execute and evaluate the software.
 *
 * @author Subhransu Mishra s.mishra@asu.edu
 *         MS Software Engineering, CIDSE, ASU
 * @version February 01 2015
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText longitude;
    EditText latitude;
    EditText name;
    EditText address;
    EditText category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        longitude = (EditText) findViewById(R.id.longitude);
        latitude = (EditText) findViewById(R.id.LatitudeEnter);
        name = (EditText) findViewById(R.id.editText2);
        address = (EditText) findViewById(R.id.EnterAddress);
        category = (EditText) findViewById(R.id.EnterCategory);
    }


    public void ondisplayClicked(View v) {

        String getlongitude = longitude.getText().toString();
        String getlatitude = latitude.getText().toString();
        String getname = name.getText().toString();
        String getaddress = address.getText().toString();
        String getcategory = category.getText().toString();

        Double getlongitudeint = Double.valueOf(longitude.getText().toString());
        Double getlatitudeint = Double.valueOf(latitude.getText().toString());


        TextView Showwaypoint = (TextView)findViewById(R.id.textView);


        if(name.getText().toString().trim().equals("")){
        Showwaypoint.setText("Please fill all the fields");
        }else if(getlongitudeint<-90 || getlongitudeint>90){
        Showwaypoint.setText("Please enter correct value of Longitude");
        }else if(getlatitudeint<-180 || getlatitudeint>180){
        Showwaypoint.setText("Please enter correct value of Latitude");
        }else {
            Showwaypoint.setText("The " + getname + " is located at longitude " + getlongitude + " and latitude " + getlatitude + " And its in " + getaddress + " and its a " + getcategory);
        }
    }


    /**

    public void onmapviewClicked(View v){
        float displaylongitude = Integer.parseInt(longitude.getText().toString());
        float displaylatitude = Integer.parseInt(latitude.getText().toString());

        String uri = String.format(java.util.Locale.ENGLISH, "geo:%f,%f", displaylatitude, displaylongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(uri));
        startActivity(intent);
    }
    */


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
