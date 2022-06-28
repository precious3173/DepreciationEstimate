package com.example.depreciationrateestimator;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class ConversionSheet extends Fragment implements DatePickerDialog.OnDateSetListener {
EditText usefulLife1, usefulLife2, usefulLife3, usefulLife4, usefulLife5, usefulLife6, usefulLife7,
        usefulLife8, usefulLife9, usefulLife10,

    cost1, cost2, cost3, cost4,cost5,cost6,cost7,cost8,cost9, cost10,

    residual1, residual2,residual3,residual4,residual5,residual6,residual7,residual8,residual9,residual10,

    depreciationExpense1,depreciationExpense2,depreciationExpense3,depreciationExpense4,depreciationExpense5,
    depreciationExpense6,depreciationExpense7,depreciationExpense8,depreciationExpense9,depreciationExpense10,

    startDate1, startDate2,startDate3,startDate4,startDate5,startDate6,startDate7,startDate8,startDate9,startDate10;


TextView depreciationRate1, depreciationRate2, depreciationRate3, depreciationRate4, depreciationRate5,
        depreciationRate6, depreciationRate7, depreciationRate8,depreciationRate9, depreciationRate10;

    double one, percent, costToString, residualToString;
String depreciateRateToString, depIntToString;
double depreciationR1, depreciationE1;
Button calculate;

    public ConversionSheet() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_conversion_sheet, container, false);


        calculate = v.findViewById(R.id.calculate);
        usefulLife1 = v.findViewById(R.id.useful_life1);
        usefulLife2 = v.findViewById(R.id.useful_life2);
        usefulLife3 = v.findViewById(R.id.useful_life3);
        usefulLife4 = v.findViewById(R.id.useful_life4);
        usefulLife5 = v.findViewById(R.id.useful_life5);
        usefulLife6 = v.findViewById(R.id.useful_life6);
        usefulLife7 = v.findViewById(R.id.useful_life7);
        usefulLife8 = v.findViewById(R.id.useful_life8);
        usefulLife9 = v.findViewById(R.id.useful_life9);
        usefulLife10 = v.findViewById(R.id.useful_life10);

        depreciationRate1 = v.findViewById(R.id.depreciation_rate1);
        depreciationRate2 = v.findViewById(R.id.depreciation_rate2);
        depreciationRate3 = v.findViewById(R.id.depreciation_rate3);
        depreciationRate4 = v.findViewById(R.id.depreciation_rate4);
        depreciationRate5 = v.findViewById(R.id.depreciation_rate5);
        depreciationRate6 = v.findViewById(R.id.depreciation_rate6);
        depreciationRate7 = v.findViewById(R.id.depreciation_rate7);
        depreciationRate8 = v.findViewById(R.id.depreciation_rate8);
        depreciationRate9 = v.findViewById(R.id.depreciation_rate9);
        depreciationRate10 = v.findViewById(R.id.depreciation_rate10);

        cost1 = v.findViewById(R.id.cost1);
        cost2 = v.findViewById(R.id.cost2);
        cost3 = v.findViewById(R.id.cost3);
        cost4 = v.findViewById(R.id.cost4);
        cost5 = v.findViewById(R.id.cost5);
        cost6 = v.findViewById(R.id.cost6);
        cost7 = v.findViewById(R.id.cost7);
        cost8 = v.findViewById(R.id.cost8);
        cost9 = v.findViewById(R.id.cost9);
        cost10 = v.findViewById(R.id.cost10);


        residual1 = v.findViewById(R.id.residual_value1);
        residual2 = v.findViewById(R.id.residual_value2);
        residual3 = v.findViewById(R.id.residual_value3);
        residual4 = v.findViewById(R.id.residual_value4);
        residual5 = v.findViewById(R.id.residual_value5);
        residual6 = v.findViewById(R.id.residual_value6);
        residual7 = v.findViewById(R.id.residual_value7);
        residual8 = v.findViewById(R.id.residual_value8);
        residual9 = v.findViewById(R.id.residual_value9);
        residual10 = v.findViewById(R.id.residual_value10);

        depreciationExpense1 = v.findViewById(R.id.depreciation_expense1);
        depreciationExpense2 = v.findViewById(R.id.depreciation_expense2);
        depreciationExpense3 = v.findViewById(R.id.depreciation_expense3);
        depreciationExpense4 = v.findViewById(R.id.depreciation_expense4);
        depreciationExpense5 = v.findViewById(R.id.depreciation_expense5);
        depreciationExpense6 = v.findViewById(R.id.depreciation_expense6);
        depreciationExpense7 = v.findViewById(R.id.depreciation_expense7);
        depreciationExpense8 = v.findViewById(R.id.depreciation_expense8);
        depreciationExpense9 = v.findViewById(R.id.depreciation_expense9);
        depreciationExpense10 = v.findViewById(R.id.depreciation_expense10);

        startDate1 = v.findViewById(R.id.capitalization_date1);
        one = 1;
        percent = 100;

        if (getArguments() != null) {
            String getFormula = getArguments().getString("formula");

            switch (getFormula) {
                case "Straight-Line":

                    startDate1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            pickDate();

                         // CustomDialogue customDialogue = new CustomDialogue();
                        // customDialogue.show(getActivity().getSupportFragmentManager(), "");
                        }
                    });


                    calculate.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                if ( !usefulLife1.getText().toString().isEmpty() && !cost1.getText().toString().isEmpty()) {
                                   if (residual1.getText().toString().isEmpty()){


                                   }else {
                                  costToString = Double.parseDouble(cost1.getText().toString());
                                  residualToString = Double.parseDouble(residual1.getText().toString());

                                     double depreciationR = one / Double.parseDouble(usefulLife1.getText().toString());

                                     depreciationR1 = depreciationR * percent;

                                     depreciationE1 = costToString - residualToString/Double.parseDouble(usefulLife1.getText().toString());

                                     depreciationExpense1.setText(String.valueOf(depreciationE1) );

                                     depreciationRate1.setText(String.valueOf(depreciationR1));}
                                 }
                                  if ( !usefulLife2.getText().toString().isEmpty() && !cost2.getText().toString().isEmpty()) {
                                      double  costToString = Double.parseDouble(cost2.getText().toString());
                                      double residualToString = Double.parseDouble(residual2.getText().toString());

                                      depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife2.getText().toString());

                                      depreciationExpense2.setText(String.valueOf(depreciationE1));

                            depreciationR1 = one / Double.parseDouble(usefulLife2.getText().toString());


                            depreciationRate2.setText(String.valueOf(depreciationR1));
                        }
                                  if ( !usefulLife3.getText().toString().isEmpty() && !cost3.getText().toString().isEmpty()  ) {

                                        depreciationR1 = one / Double.parseDouble(usefulLife3.getText().toString());


                                        depreciationRate3.setText(String.valueOf(depreciationR1));
                                    }

                                    if ( !usefulLife4.getText().toString().isEmpty() ) {

                                        depreciationR1 = one / Double.parseDouble(usefulLife4.getText().toString());


                                        depreciationRate4.setText(String.valueOf(depreciationR1));
                                    }
                                    if ( !usefulLife5.getText().toString().isEmpty() ) {

                                        depreciationR1 = one / Double.parseDouble(usefulLife5.getText().toString());


                                        depreciationRate5.setText(String.valueOf(depreciationR1));
                                    }

                                    if ( !usefulLife6.getText().toString().isEmpty() ) {

                                        depreciationR1 = one / Double.parseDouble(usefulLife6.getText().toString());


                                        depreciationRate6.setText(String.valueOf(depreciationR1));
                                    }

                                    if ( !usefulLife7.getText().toString().isEmpty() ) {

                                        depreciationR1 = one / Double.parseDouble(usefulLife7.getText().toString());


                                        depreciationRate7.setText(String.valueOf(depreciationR1));
                                    }
                    }
            });
                    break;

                case "Sum-of-the-years'-digits":
                    Toast.makeText(getContext(), "2+2", Toast.LENGTH_SHORT).show();
                    break;
                case "Declining Balance":
                    Toast.makeText(getContext(), "3+3", Toast.LENGTH_SHORT).show();
                    break;
                case "Units of Production":
                    Toast.makeText(getContext(), "4+4b  ", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
        return v;
    }

    private void pickDate() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

   /* @Override
    public void capitalize(String date) {
        if (date != null) {
            startDate1.setText(date);
        } else {

            Toast.makeText(getContext(), "Select date", Toast.LENGTH_SHORT).show();
        }
    }*/

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
       String date = (i1 + 1) + "/" + i2 + "/" + i;
       startDate1.setText(date);
    }
}