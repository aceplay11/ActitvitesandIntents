package com.example.actitvitesandintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG_MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStartExplicitActivity:
                startExplicitActivity();

                break;

            case R.id.btnStartImplicitActivity:
                startImplicitActivity();

                break;

            case R.id.btnStartActivityForSingleString:
                startActivityForSingleString();
                break;

            case R.id.btnStartActivityForParcel:
                startActivityForParcel();
                break;
        }


    }

    private void startActivityForParcel() {
        Intent startActionForParcel = new Intent(this, DataEntryActivity.class);
        startActionForParcel.putExtra(String.valueOf(startActionForParcel), 1);
        startActivityForResult(startActionForParcel, 112);
    }

    private void startActivityForSingleString() {
        Intent startActionForSingleResult = new Intent(this, DataEntryActivity.class);
        startActivityForResult(startActionForSingleResult, 111);
    }

    private void startImplicitActivity() {
        Intent implicitIntent = new Intent(this, ImplicitActivity.class);
        implicitIntent.setAction("fire.implicit.activity");
        startActivity(implicitIntent);
    }

    private void startExplicitActivity() {
        Intent explicitIntent = new Intent(this, Activity2.class);
        startActivity(explicitIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case 111:
                String passedvalue = data.getStringExtra("key");
                Log.d(TAG, "OnActivity" + passedvalue);

                break;
            case 112:
                if (data != null) {

                    Bundle passedBundle = data.getExtras();
                    if (passedBundle != null) {
                        Person person = passedBundle.getParcelable("person");
                        if (person != null)
                            Log.d(TAG, "onActivityResult" + person.getFirstName() + " " + person.getLastName());
                    }
                }


                break;
        }
    }
}



