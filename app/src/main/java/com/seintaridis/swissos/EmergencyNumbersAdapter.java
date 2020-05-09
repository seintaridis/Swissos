package com.seintaridis.swissos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class EmergencyNumbersAdapter extends RecyclerView.Adapter<EmergencyNumbersAdapter.NumberViewHolder>
{
    private static final String TAG = EmergencyNumbersAdapter.class.getSimpleName();

    private List<EmergencyNumber> mEmergencyNumbers;


    public EmergencyNumbersAdapter(List<EmergencyNumber> emergencyNumbers)
    {
        mEmergencyNumbers = emergencyNumbers;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public EmergencyNumbersAdapter.NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View emergencyNumberItemView = inflater.inflate(R.layout.emergency_number_list_item, parent, false);

        // Return a new holder instance
        NumberViewHolder viewHolder = new NumberViewHolder(context, emergencyNumberItemView);
        return viewHolder;
    }


    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EmergencyNumbersAdapter.NumberViewHolder viewHolder, int position)
    {
        // Get the data model based on position
        EmergencyNumber emergencyNumber = mEmergencyNumbers.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(emergencyNumber.getLabel());

        Button button = viewHolder.messageButton;
        button.setText(emergencyNumber.getPhoneNumber());


        //    button.setText(emergencyNumber.isOnline() ? "Message" : "Offline");
        //  button.setEnabled(emergencyNumber.isOnline());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount()
    {
        return mEmergencyNumbers.size();
    }


    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView nameTextView;
        public Button messageButton;
        private Context context;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public NumberViewHolder(Context context, View itemView)
        {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            this.nameTextView = (TextView) itemView.findViewById(R.id.emergency_number_label);
            this.messageButton = (Button) itemView.findViewById(R.id.emergency_number_button);

            this.messageButton.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    EmergencyNumber emergencyNumber = mEmergencyNumbers.get(getAdapterPosition());
                    // We can access the data within the views
                    System.out.println(emergencyNumber.getPhoneNumber());

                    dialPhoneNumber(emergencyNumber.getPhoneNumber());


                }
            });

            this.context = context;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION)
            { // Check if an item was deleted, but the user clicked it before the UI removed it
                EmergencyNumber emergencyNumber = mEmergencyNumbers.get(position);
                // We can access the data within the views
                dialPhoneNumber(emergencyNumber.getPhoneNumber());
            }
        }


        public void dialPhoneNumber(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        }
    }
}
