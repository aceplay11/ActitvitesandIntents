package com.example.actitvitesandintents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

public class DataEntryActivity extends AppCompatActivity {
    EditText etDataEntry;
    EditText etDataEntry1;
    Intent passIntent;

    int viewFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        etDataEntry = findViewById(R.id.etDataEntry);
        passIntent = getIntent();
        viewFlag = passIntent.getIntExtra("key", 0);
        switch (viewFlag){
            case 0:

                break;
            case 1:
                etDataEntry1 = findViewById(R.id.etDataEntry1);
                etDataEntry1.setVisibility(View.VISIBLE);
        }
    }

    public void onClick(View view) {
        String info = etDataEntry.getText().toString();
        switch(viewFlag){
            case 0:
                passIntent.putExtra("key", info);
            case 1:
                String lastname = etDataEntry1.getText().toString();
                Person passededPerson = new Person(info, lastname);
                //passedIntent

        }

        setResult(222,passIntent);
        finish();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
