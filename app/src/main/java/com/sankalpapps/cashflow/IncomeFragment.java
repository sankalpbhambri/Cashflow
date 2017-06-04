package com.sankalpapps.cashflow;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment extends Fragment{

    private EditText rentalIncome, miscIncome;
    private TextView totalIncome;
    long totalRent = 0;
    long rent = 0;
    long misRent =0;


    public IncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_income, container, false);
        rentalIncome = (EditText) view.findViewById(R.id.editRentalIncome);
        miscIncome = (EditText) view.findViewById(R.id.editMiscIncome);
        totalIncome = (TextView) view.findViewById(R.id.textTotalIncome);
        rentalIncome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusCha
            -nge(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    try {
                        rent = Long.valueOf(rentalIncome.getText().toString());
                        totalRent += (rent);
                        totalIncome.setText("Total income is "+totalRent);

                    } catch (Exception e) {
                        Log.e("error","error"+e.getMessage());

                    }

                }
                else{
                    totalRent -= (rent);
                    totalIncome.setText("Total income is "+totalRent);

                }
            }
        });
        miscIncome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    try {
                        misRent = Long.valueOf(miscIncome.getText().toString());
                        totalRent += (misRent);
                        totalIncome.setText("Total income is "+totalRent);

                    } catch (Exception e) {
                        Log.e("error","error"+e.getMessage());

                    }

                }
                else{
                    totalRent -= (misRent);
                    totalIncome.setText("Total income is "+totalRent);

                }
            }
        });


        return view;
    }


  }
