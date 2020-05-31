package com.example.tokyo2020;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.widget.DatePicker;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new DatePickerDialog(getActivity(),this,2020,4,1);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
        ScheduleActivity mainActivity=(ScheduleActivity) getActivity();
        mainActivity.setdate(year,month,dayofMonth);
    }
}
