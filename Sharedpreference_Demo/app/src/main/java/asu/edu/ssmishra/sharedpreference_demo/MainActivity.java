package asu.edu.ssmishra.sharedpreference_demo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    SharedPreferences namePreferences;
    EditText ediName, showName;
    Button setBtn, getBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namePreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ediName = (EditText) findViewById(R.id.editname_id);
        showName = (EditText) findViewById(R.id.showname_id);
        setBtn = (Button) findViewById(R.id.setBtn_id);
        getBtn = (Button) findViewById(R.id.getBtn_id);
        setBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SharedPreferences.Editor nameEditor = namePreferences.edit();
                nameEditor.putString("name", ediName.getText().toString());
                nameEditor.commit();
            }
        });

        getBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String nameValue = namePreferences.getString("name", "");
                showName.setText(nameValue);
            }

        });
    }
}
