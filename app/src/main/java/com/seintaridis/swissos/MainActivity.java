package com.seintaridis.swissos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

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

    private void showMap(Uri uri)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    public void onClickAddressButton(View view)
    {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("geo")
                .path("0,0")
                .query("1220 Geneva, Switzerland");
        Uri addressUri = builder.build();
        showMap(addressUri);
    }
}
