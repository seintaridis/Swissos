package com.seintaridis.swissos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import static com.seintaridis.swissos.EmergencyNumbersAdapter.ExtraIntents.EMERGENCY;

public class EmergencyNumberActivity extends AppCompatActivity
{
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_number);
        textView = findViewById(R.id.textView);

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(EMERGENCY.name()))
        {
            EmergencyNumber emergencyNumber = (EmergencyNumber) getIntent().getSerializableExtra(EMERGENCY.name());
            textView.setText(emergencyNumber.getPhoneNumber());
        }
    }
}
