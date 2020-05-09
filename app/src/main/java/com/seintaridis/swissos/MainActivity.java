package com.seintaridis.swissos;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
{

    ArrayList<EmergencyNumber> emergencyNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvEmergencyNumbers = (RecyclerView) findViewById(R.id.emergencyNumbers);

        // Initialize contacts
        emergencyNumbers = EmergencyNumber.createEmergencyNumbersList();
        // Create adapter passing in the sample user data
        EmergencyNumbersAdapter adapter = new EmergencyNumbersAdapter(emergencyNumbers);
        // Attach the adapter to the recyclerview to populate items
        rvEmergencyNumbers.setAdapter(adapter);
        // Set layout manager to position the items
        rvEmergencyNumbers.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvEmergencyNumbers.addItemDecoration(itemDecoration);


    }
}
