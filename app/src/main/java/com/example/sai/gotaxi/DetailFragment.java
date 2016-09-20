package com.example.sai.gotaxi;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;

/**
 * Created by chaitanya on 7/12/2016.
 */
public class DetailFragment extends Fragment {

    private EditText mNameField;
    private EditText mNumberField;
    private EditText mAddressField;
    private TextClock textClock;
    private Button mSubmitButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);

        mNameField = (EditText) v.findViewById(R.id.client_name);

        mNumberField = (EditText) v.findViewById(R.id.client_number);

        mAddressField = (EditText) v.findViewById(R.id.client_address);
        textClock = (TextClock) v.findViewById(R.id.textClock);


        mSubmitButton = (Button) v.findViewById(R.id.details_submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(getActivity(),new String[] {Manifest.permission.SEND_SMS},1);

                SmsManager smsManager = SmsManager.getDefault();


                smsManager.sendTextMessage("+13377660032" , null, getTaxi(), null, null);

                Intent intent = new Intent(getActivity(), LastActivity.class);
                startActivity(intent);

            }
        });


        return v;
    }

    private String getTaxi() {
       return mNameField.getText() + " " + "needs a ride from this address:" + " " + mAddressField.getText()
               + " " + "and contact number of client is" + mNumberField.getText()
               + " " + "time of booking:" + " " + textClock.getText() ;


        }

}
