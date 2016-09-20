package com.example.sai.gotaxi;

import android.support.v4.app.Fragment;

/**
 * Created by chaitanya on 7/12/2016.
 */
public class LastActivity extends SingleFragmentActivity {



    @Override
    protected Fragment createFragment() {
        return new LastFragment();
    }

}
