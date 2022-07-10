package com.example.depreciationrateestimator;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
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
EditText usefulLife, usefulLife1, usefulLife2, usefulLife3, usefulLife4, usefulLife5, usefulLife6, usefulLife7,
        usefulLife8, usefulLife9, usefulLife10,

    cost1, cost2, cost3, cost4,cost5,cost6,cost7,cost8,cost9, cost10,

    residual1, residual2,residual3,residual4,residual5,residual6,residual7,residual8,residual9,residual10,

    depreciationExpense1,depreciationExpense2,depreciationExpense3,depreciationExpense4,depreciationExpense5,
    depreciationExpense6,depreciationExpense7,depreciationExpense8,depreciationExpense9,depreciationExpense10,

  starDate, startDate1, startDate2,startDate3,startDate4,startDate5,startDate6,startDate7,startDate8,startDate9,startDate10,

   endDate, endDate1, endDate2, endDate3, endDate4,endDate5, endDate6, endDate7,endDate8, endDate9,endDate10
    ;


TextView depreciationRate1, depreciationRate2, depreciationRate3, depreciationRate4, depreciationRate5,
        depreciationRate6, depreciationRate7, depreciationRate8,depreciationRate9, depreciationRate10;

    double one, two, percent, costToString, residualToString;
String depreciateRateToString, depIntToString, ratePercent;
double depreciationR1, depreciationE1, usefulLifeToString, depreciationR, acceleratedDepreciation;
Button calculate;

    public ConversionSheet() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_conversion_sheet, container, false);


        // calculate = v.findViewById(R.id.calculate);
        usefulLife = v.findViewById(R.id.useful_life);
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

        starDate = v.findViewById(R.id.capitalization_date);
        startDate1 = v.findViewById(R.id.capitalization_date1);
        startDate2 = v.findViewById(R.id.capitalization_date2);
        startDate3 = v.findViewById(R.id.capitalization_date3);
        startDate4 = v.findViewById(R.id.capitalization_date4);
        startDate5 = v.findViewById(R.id.capitalization_date5);
        startDate6 = v.findViewById(R.id.capitalization_date6);
        startDate7 = v.findViewById(R.id.capitalization_date7);
        startDate8 = v.findViewById(R.id.capitalization_date8);
        startDate9 = v.findViewById(R.id.capitalization_date9);
        startDate10 = v.findViewById(R.id.capitalization_date10);

        endDate = v.findViewById(R.id.end_date);
        endDate1 = v.findViewById(R.id.end_date1);
        endDate2 = v.findViewById(R.id.end_date2);
        endDate3 = v.findViewById(R.id.end_date3);
        endDate4 = v.findViewById(R.id.end_date4);
        endDate5 = v.findViewById(R.id.end_date5);
        endDate6 = v.findViewById(R.id.end_date6);
        endDate7 = v.findViewById(R.id.end_date7);
        endDate8 = v.findViewById(R.id.end_date8);
        endDate9 = v.findViewById(R.id.end_date9);
        endDate10 = v.findViewById(R.id.end_date10);

        one = 1;
        percent = 100;
        two = 2;

        if (getArguments() != null) {
            String getFormula = getArguments().getString("formula");

            switch (getFormula) {
                case "Straight-Line":

                    starDate.setVisibility(View.GONE);

                    startDate1.setVisibility(View.GONE);
                    startDate2.setVisibility(View.GONE);
                    startDate3.setVisibility(View.GONE);
                    startDate4.setVisibility(View.GONE);
                    startDate5.setVisibility(View.GONE);
                    startDate6.setVisibility(View.GONE);
                    startDate7.setVisibility(View.GONE);
                    startDate8.setVisibility(View.GONE);
                    startDate9.setVisibility(View.GONE);
                    startDate10.setVisibility(View.GONE);

                    endDate.setVisibility(View.GONE);

                    endDate1.setVisibility(View.GONE);
                    endDate2.setVisibility(View.GONE);
                    endDate3.setVisibility(View.GONE);
                    endDate4.setVisibility(View.GONE);
                    endDate5.setVisibility(View.GONE);
                    endDate6.setVisibility(View.GONE);
                    endDate7.setVisibility(View.GONE);
                    endDate8.setVisibility(View.GONE);
                    endDate9.setVisibility(View.GONE);
                    endDate10.setVisibility(View.GONE);



                    startDate1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            pickDate();


                        }
                    });

                                // computation of the first row depreciation rate and expense
                                //when value of cost is available

                                usefulLife1.addTextChangedListener(new TextWatcher() {
                                    @Override
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                    }

                                    @Override
                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                        if ( !cost1.getText().toString().isEmpty()) {
                                            // when there is no residual value, expense is calculated by dividing the cost by useful life

                                            if (residual1.getText().toString().isEmpty()){

                                                costToString = Double.parseDouble(cost1.getText().toString());

                                                double depreciationR = one / Double.parseDouble(usefulLife1.getText().toString());

                                                depreciationR1 = depreciationR * percent;
                                                String ratePercent = depreciationR1 + "%";


                                                depreciationE1 = costToString/Double.parseDouble(usefulLife1.getText().toString());

                                                depreciationExpense1.setText(String.valueOf(depreciationE1) );

                                                depreciationRate1.setText(ratePercent);
                                            }else {

                                                // when there is residual value, expense is calculated by substrating cost by residual value and dividing by useful life

                                                costToString = Double.parseDouble(cost1.getText().toString());

                                                residualToString = Double.parseDouble(residual1.getText().toString());

                                                double depreciationR = one / Double.parseDouble(usefulLife1.getText().toString());

                                                depreciationR1 = depreciationR * percent;
                                                ratePercent = depreciationR1 + "%";

                                                depreciationE1 = costToString - residualToString/Double.parseDouble(usefulLife1.getText().toString());

                                                depreciationExpense1.setText(String.valueOf(depreciationE1) );

                                                depreciationRate1.setText(ratePercent);
                                            }
                                        }
                                    }

                                    @Override
                                    public void afterTextChanged(Editable editable) {


                                    }
                                });

                                 // computation of the first row depreciation rate and expense
                                // when the value of useful life is already value

                                cost1.addTextChangedListener(new TextWatcher() {
                                    @Override
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                    }

                                    @Override
                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                        if ( !usefulLife1.getText().toString().isEmpty()) {
                                            // when there is no residual value, expense is calculated by dividing the cost by useful life

                                            if (residual1.getText().toString().isEmpty()){

                                                costToString = Double.parseDouble(cost1.getText().toString());

                                                double depreciationR = one / Double.parseDouble(usefulLife1.getText().toString());

                                                depreciationR1 = depreciationR * percent;
                                                String ratePercent = depreciationR1 + "%";


                                                depreciationE1 = costToString/Double.parseDouble(usefulLife1.getText().toString());

                                                depreciationExpense1.setText(String.valueOf(depreciationE1) );

                                                depreciationRate1.setText(ratePercent);
                                            }else {
                                                // when there is residual value, expense is calculated by substrating cost by residual value and dividing by useful life

                                                costToString = Double.parseDouble(cost1.getText().toString());

                                                residualToString = Double.parseDouble(residual1.getText().toString());

                                                double depreciationR = one / Double.parseDouble(usefulLife1.getText().toString());

                                                depreciationR1 = depreciationR * percent;
                                                ratePercent = depreciationR1 + "%";

                                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife1.getText().toString());

                                                depreciationExpense1.setText(String.valueOf(depreciationE1) );

                                                depreciationRate1.setText(ratePercent);
                                            }
                                        }
                                    }

                                    @Override
                                    public void afterTextChanged(Editable editable) {

                                    }
                                });

                                 // when cost and useful life are inserted before residual value
                                 residual1.addTextChangedListener(new TextWatcher() {
                                     @Override
                                     public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                     }

                                     @Override
                                     public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                         if (!cost1.getText().toString().isEmpty() && !usefulLife1.getText().toString().isEmpty() && !residual1.getText().toString().isEmpty()){

                                         costToString = Double.parseDouble(cost1.getText().toString());

                                         residualToString = Double.parseDouble(residual1.getText().toString());

                                         double depreciationR = one / Double.parseDouble(usefulLife1.getText().toString());

                                         depreciationR1 = depreciationR * percent;
                                         ratePercent = depreciationR1 + "%";

                                         depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife1.getText().toString());

                                         depreciationExpense1.setText(String.valueOf(depreciationE1) );

                                         depreciationRate1.setText(ratePercent);
                                     }

                                     }

                                     @Override
                                     public void afterTextChanged(Editable editable) {

                                     }
                                 });


                                 // calculation for second row
                                 usefulLife2.addTextChangedListener(new TextWatcher() {
                                     @Override
                                     public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                     }

                                     @Override
                                     public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                         if (!cost2.getText().toString().isEmpty()) {
                                             if (residual2.getText().toString().isEmpty()) {

                                                 costToString = Double.parseDouble(cost2.getText().toString());

                                                 double depreciationR = one / Double.parseDouble(usefulLife2.getText().toString());

                                                 depreciationR1 = depreciationR * percent;
                                                 String ratePercent = depreciationR1 + "%";


                                                 depreciationE1 = costToString/Double.parseDouble(usefulLife2.getText().toString());

                                                 depreciationExpense2.setText(String.valueOf(depreciationE1) );

                                                 depreciationRate2.setText(ratePercent);

                                             } else {

                                                 double costToString = Double.parseDouble(cost2.getText().toString());
                                                 double residualToString = Double.parseDouble(residual2.getText().toString());

                                                 depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife2.getText().toString());

                                                 depreciationExpense2.setText(String.valueOf(depreciationE1));

                                                 depreciationR1 = one / Double.parseDouble(usefulLife2.getText().toString());


                                                 depreciationRate2.setText(String.valueOf(depreciationR1));
                                             }
                                         }
                                     }
                                     @Override
                                     public void afterTextChanged(Editable editable) {

                                     }
                                 });


                                 cost2.addTextChangedListener(new TextWatcher() {
                                     @Override
                                     public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                     }

                                     @Override
                                     public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                         if (!usefulLife2.getText().toString().isEmpty()) {
                                             if (residual2.getText().toString().isEmpty()) {

                                                 costToString = Double.parseDouble(cost2.getText().toString());

                                                 double depreciationR = one / Double.parseDouble(usefulLife2.getText().toString());

                                                 depreciationR1 = depreciationR * percent;
                                                 String ratePercent = depreciationR1 + "%";


                                                 depreciationE1 = costToString/Double.parseDouble(usefulLife2.getText().toString());

                                                 depreciationExpense2.setText(String.valueOf(depreciationE1) );

                                                 depreciationRate2.setText(ratePercent);

                                             } else {

                                                 double costToString = Double.parseDouble(cost2.getText().toString());
                                                 double residualToString = Double.parseDouble(residual2.getText().toString());

                                                 depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife2.getText().toString());

                                                 depreciationExpense2.setText(String.valueOf(depreciationE1));

                                                 depreciationR1 = one / Double.parseDouble(usefulLife2.getText().toString());


                                                 depreciationRate2.setText(String.valueOf(depreciationR1));
                                             }
                                         }
                                     }

                                     @Override
                                     public void afterTextChanged(Editable editable) {

                                     }
                                 });


                                 residual2.addTextChangedListener(new TextWatcher() {
                                     @Override
                                     public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                     }

                                     @Override
                                     public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                         if (!cost2.getText().toString().isEmpty() && !usefulLife2.getText().toString().isEmpty()){

                                             costToString = Double.parseDouble(cost2.getText().toString());

                                             residualToString = Double.parseDouble(residual2.getText().toString());

                                             double depreciationR = one / Double.parseDouble(usefulLife2.getText().toString());

                                             depreciationR1 = depreciationR * percent;
                                             ratePercent = depreciationR1 + "%";

                                             depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife2.getText().toString());

                                             depreciationExpense2.setText(String.valueOf(depreciationE1) );

                                             depreciationRate2.setText(ratePercent);
                                         }
                                     }

                                     @Override
                                     public void afterTextChanged(Editable editable) {

                                     }
                                 });


                                 //calculation for row 3
                                  usefulLife3.addTextChangedListener(new TextWatcher() {
                                      @Override
                                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                      }

                                      @Override
                                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                                          if ( !cost3.getText().toString().isEmpty()) {
                                              if (residual3.getText().toString().isEmpty()) {

                                                  costToString = Double.parseDouble(cost3.getText().toString());

                                                  double depreciationR = one / Double.parseDouble(usefulLife3.getText().toString());

                                                  depreciationR1 = depreciationR * percent;
                                                  String ratePercent = depreciationR1 + "%";


                                                  depreciationE1 = costToString/Double.parseDouble(usefulLife3.getText().toString());

                                                  depreciationExpense3.setText(String.valueOf(depreciationE1) );

                                                  depreciationRate3.setText(ratePercent);

                                              } else {

                                                  double costToString = Double.parseDouble(cost3.getText().toString());
                                                  double residualToString = Double.parseDouble(residual3.getText().toString());

                                                  depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife3.getText().toString());

                                                  depreciationExpense3.setText(String.valueOf(depreciationE1));

                                                  depreciationR1 = one / Double.parseDouble(usefulLife3.getText().toString());


                                                  depreciationRate3.setText(String.valueOf(depreciationR1));
                                              }
                                          }

                                      }

                                      @Override
                                      public void afterTextChanged(Editable editable) {

                                      }
                                  });

                                  cost3.addTextChangedListener(new TextWatcher() {
                                      @Override
                                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                      }

                                      @Override
                                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                          if (!usefulLife3.getText().toString().isEmpty()) {
                                              if (residual3.getText().toString().isEmpty()) {

                                                  costToString = Double.parseDouble(cost3.getText().toString());

                                                  double depreciationR = one / Double.parseDouble(usefulLife3.getText().toString());

                                                  depreciationR1 = depreciationR * percent;
                                                  String ratePercent = depreciationR1 + "%";


                                                  depreciationE1 = costToString/Double.parseDouble(usefulLife3.getText().toString());

                                                  depreciationExpense3.setText(String.valueOf(depreciationE1) );

                                                  depreciationRate3.setText(ratePercent);

                                              } else {

                                                  double costToString = Double.parseDouble(cost3.getText().toString());
                                                  double residualToString = Double.parseDouble(residual3.getText().toString());

                                                  depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife3.getText().toString());

                                                  depreciationExpense3.setText(String.valueOf(depreciationE1));

                                                  depreciationR1 = one / Double.parseDouble(usefulLife3.getText().toString());


                                                  depreciationRate3.setText(String.valueOf(depreciationR1));
                                              }
                                          }
                                      }

                                      @Override
                                      public void afterTextChanged(Editable editable) {

                                      }
                                  });

                    residual3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost3.getText().toString().isEmpty() && !usefulLife3.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost3.getText().toString());

                                residualToString = Double.parseDouble(residual3.getText().toString());

                                double depreciationR = one / Double.parseDouble(usefulLife3.getText().toString());

                                depreciationR1 = depreciationR * percent;
                                ratePercent = depreciationR1 + "%";

                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife3.getText().toString());

                                depreciationExpense3.setText(String.valueOf(depreciationE1) );

                                depreciationRate3.setText(ratePercent);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    //calculation for row 4
                    usefulLife4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if ( !cost4.getText().toString().isEmpty()) {
                                if (residual4.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost4.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1) );

                                    depreciationRate4.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost4.getText().toString());
                                    double residualToString = Double.parseDouble(residual4.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife4.getText().toString());


                                    depreciationRate4.setText(String.valueOf(depreciationR1));
                                }
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife4.getText().toString().isEmpty()) {
                                if (residual4.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost4.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1) );

                                    depreciationRate4.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost4.getText().toString());
                                    double residualToString = Double.parseDouble(residual4.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife4.getText().toString());


                                    depreciationRate4.setText(String.valueOf(depreciationR1));
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost4.getText().toString().isEmpty() && !usefulLife4.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost4.getText().toString());

                                residualToString = Double.parseDouble(residual4.getText().toString());

                                double depreciationR = one / Double.parseDouble(usefulLife4.getText().toString());

                                depreciationR1 = depreciationR * percent;
                                ratePercent = depreciationR1 + "%";

                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife4.getText().toString());

                                depreciationExpense4.setText(String.valueOf(depreciationE1) );

                                depreciationRate4.setText(ratePercent);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    //calculation for row 5
                    usefulLife5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if ( !cost5.getText().toString().isEmpty()) {
                                if (residual5.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost5.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1) );

                                    depreciationRate5.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost5.getText().toString());
                                    double residualToString = Double.parseDouble(residual5.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife5.getText().toString());


                                    depreciationRate5.setText(String.valueOf(depreciationR1));
                                }
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife5.getText().toString().isEmpty()) {
                                if (residual5.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost5.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1) );

                                    depreciationRate5.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost5.getText().toString());
                                    double residualToString = Double.parseDouble(residual5.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife5.getText().toString());


                                    depreciationRate5.setText(String.valueOf(depreciationR1));
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost5.getText().toString().isEmpty() && !usefulLife5.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost5.getText().toString());

                                residualToString = Double.parseDouble(residual5.getText().toString());

                                double depreciationR = one / Double.parseDouble(usefulLife5.getText().toString());

                                depreciationR1 = depreciationR * percent;
                                ratePercent = depreciationR1 + "%";

                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife5.getText().toString());

                                depreciationExpense5.setText(String.valueOf(depreciationE1) );

                                depreciationRate5.setText(ratePercent);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    //calculation for row 6
                    usefulLife6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if ( !cost6.getText().toString().isEmpty()) {
                                if (residual6.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost6.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1) );

                                    depreciationRate6.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost6.getText().toString());
                                    double residualToString = Double.parseDouble(residual6.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife6.getText().toString());


                                    depreciationRate3.setText(String.valueOf(depreciationR1));
                                }
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife6.getText().toString().isEmpty()) {
                                if (residual6.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost6.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1) );

                                    depreciationRate6.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost6.getText().toString());
                                    double residualToString = Double.parseDouble(residual6.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife6.getText().toString());


                                    depreciationRate6.setText(String.valueOf(depreciationR1));
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost6.getText().toString().isEmpty() && !usefulLife6.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost6.getText().toString());

                                residualToString = Double.parseDouble(residual6.getText().toString());

                                double depreciationR = one / Double.parseDouble(usefulLife6.getText().toString());

                                depreciationR1 = depreciationR * percent;
                                ratePercent = depreciationR1 + "%";

                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife6.getText().toString());

                                depreciationExpense6.setText(String.valueOf(depreciationE1) );

                                depreciationRate6.setText(ratePercent);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    //calculation for row 7
                    usefulLife7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if ( !cost7.getText().toString().isEmpty()) {
                                if (residual7.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost7.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1) );

                                    depreciationRate7.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost7.getText().toString());
                                    double residualToString = Double.parseDouble(residual7.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife7.getText().toString());


                                    depreciationRate3.setText(String.valueOf(depreciationR1));
                                }
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife7.getText().toString().isEmpty()) {
                                if (residual7.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost7.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1) );

                                    depreciationRate7.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost7.getText().toString());
                                    double residualToString = Double.parseDouble(residual7.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife7.getText().toString());


                                    depreciationRate7.setText(String.valueOf(depreciationR1));
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost7.getText().toString().isEmpty() && !usefulLife7.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost7.getText().toString());

                                residualToString = Double.parseDouble(residual7.getText().toString());

                                double depreciationR = one / Double.parseDouble(usefulLife7.getText().toString());

                                depreciationR1 = depreciationR * percent;
                                ratePercent = depreciationR1 + "%";

                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife7.getText().toString());

                                depreciationExpense7.setText(String.valueOf(depreciationE1) );

                                depreciationRate7.setText(ratePercent);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });



                    //calculation for row 8
                    usefulLife8.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if ( !cost8.getText().toString().isEmpty()) {
                                if (residual8.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost8.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationExpense8.setText(String.valueOf(depreciationE1) );

                                    depreciationRate8.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost8.getText().toString());
                                    double residualToString = Double.parseDouble(residual8.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationExpense8.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife8.getText().toString());


                                    depreciationRate8.setText(String.valueOf(depreciationR1));
                                }
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost8.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife8.getText().toString().isEmpty()) {
                                if (residual8.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost8.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationExpense8.setText(String.valueOf(depreciationE1) );

                                    depreciationRate8.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost8.getText().toString());
                                    double residualToString = Double.parseDouble(residual8.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationExpense8.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife8.getText().toString());


                                    depreciationRate8.setText(String.valueOf(depreciationR1));
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost8.getText().toString().isEmpty() && !usefulLife8.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost8.getText().toString());

                                residualToString = Double.parseDouble(residual8.getText().toString());

                                double depreciationR = one / Double.parseDouble(usefulLife8.getText().toString());

                                depreciationR1 = depreciationR * percent;
                                ratePercent = depreciationR1 + "%";

                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife8.getText().toString());

                                depreciationExpense8.setText(String.valueOf(depreciationE1) );

                                depreciationRate8.setText(ratePercent);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    //calculation for row 9
                    usefulLife9.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if ( !cost9.getText().toString().isEmpty()) {
                                if (residual9.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost9.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1) );

                                    depreciationRate9.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost9.getText().toString());
                                    double residualToString = Double.parseDouble(residual9.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife9.getText().toString());


                                    depreciationRate9.setText(String.valueOf(depreciationR1));
                                }
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost9.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife9.getText().toString().isEmpty()) {
                                if (residual9.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost9.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1) );

                                    depreciationRate9.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost9.getText().toString());
                                    double residualToString = Double.parseDouble(residual9.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife9.getText().toString());


                                    depreciationRate9.setText(String.valueOf(depreciationR1));
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual9.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost9.getText().toString().isEmpty() && !usefulLife9.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost9.getText().toString());

                                residualToString = Double.parseDouble(residual9.getText().toString());

                                double depreciationR = one / Double.parseDouble(usefulLife9.getText().toString());

                                depreciationR1 = depreciationR * percent;
                                ratePercent = depreciationR1 + "%";

                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife9.getText().toString());

                                depreciationExpense9.setText(String.valueOf(depreciationE1) );

                                depreciationRate9.setText(ratePercent);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    //calculation for row 10
                    usefulLife10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if ( !cost10.getText().toString().isEmpty()) {
                                if (residual10.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost10.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1) );

                                    depreciationRate10.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost10.getText().toString());
                                    double residualToString = Double.parseDouble(residual10.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife10.getText().toString());


                                    depreciationRate10.setText(String.valueOf(depreciationR1));
                                }
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife10.getText().toString().isEmpty()) {
                                if (residual10.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost10.getText().toString());

                                    double depreciationR = one / Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationR1 = depreciationR * percent;
                                    String ratePercent = depreciationR1 + "%";


                                    depreciationE1 = costToString/Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1) );

                                    depreciationRate10.setText(ratePercent);

                                } else {

                                    double costToString = Double.parseDouble(cost10.getText().toString());
                                    double residualToString = Double.parseDouble(residual10.getText().toString());

                                    depreciationE1 = (costToString - residualToString) / Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));

                                    depreciationR1 = one / Double.parseDouble(usefulLife10.getText().toString());


                                    depreciationRate10.setText(String.valueOf(depreciationR1));
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost10.getText().toString().isEmpty() && !usefulLife10.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost10.getText().toString());

                                residualToString = Double.parseDouble(residual10.getText().toString());

                                double depreciationR = one / Double.parseDouble(usefulLife10.getText().toString());

                                depreciationR1 = depreciationR * percent;
                                ratePercent = depreciationR1 + "%";

                                depreciationE1 = (costToString - residualToString)/Double.parseDouble(usefulLife10.getText().toString());

                                depreciationExpense10.setText(String.valueOf(depreciationE1) );

                                depreciationRate10.setText(ratePercent);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    break;

                case "Sum-of-the-years'-digits":

                    starDate.setVisibility(View.GONE);

                    startDate1.setVisibility(View.GONE);
                    startDate2.setVisibility(View.GONE);
                    startDate3.setVisibility(View.GONE);
                    startDate4.setVisibility(View.GONE);
                    startDate5.setVisibility(View.GONE);
                    startDate6.setVisibility(View.GONE);
                    startDate7.setVisibility(View.GONE);
                    startDate8.setVisibility(View.GONE);
                    startDate9.setVisibility(View.GONE);
                    startDate10.setVisibility(View.GONE);

                    endDate.setVisibility(View.GONE);

                    endDate1.setVisibility(View.GONE);
                    endDate2.setVisibility(View.GONE);
                    endDate3.setVisibility(View.GONE);
                    endDate4.setVisibility(View.GONE);
                    endDate5.setVisibility(View.GONE);
                    endDate6.setVisibility(View.GONE);
                    endDate7.setVisibility(View.GONE);
                    endDate8.setVisibility(View.GONE);
                    endDate9.setVisibility(View.GONE);
                    endDate10.setVisibility(View.GONE);

                    cost2.setFocusable(false);
                    cost3.setFocusable(false);
                    cost4.setFocusable(false);
                    cost5.setFocusable(false);
                    cost6.setFocusable(false);
                    cost7.setFocusable(false);
                    cost8.setFocusable(false);
                    cost9.setFocusable(false);
                    cost10.setFocusable(false);
                    usefulLife2.setFocusable(false);
                    usefulLife3.setFocusable(false);
                    usefulLife4.setFocusable(false);
                    usefulLife5.setFocusable(false);
                    usefulLife6.setFocusable(false);
                    usefulLife7.setFocusable(false);
                    usefulLife8.setFocusable(false);
                    usefulLife9.setFocusable(false);
                    usefulLife10.setFocusable(false);



                    usefulLife1.addTextChangedListener(new TextWatcher() {
                               @Override
                               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                               }

                               @Override
                               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                   {
                                       if (!cost1.getText().toString().isEmpty() && !usefulLife1.getText().toString().isEmpty()) {
                                                 if(residual1.getText().toString().isEmpty()){
                                           costToString = Double.parseDouble(cost1.getText().toString());
                                           usefulLifeToString = Double.parseDouble(usefulLife1.getText().toString());
                                           depreciationR = usefulLifeToString * (usefulLifeToString + one) / two;
                                           depreciationR1 = usefulLifeToString / depreciationR;
                                           acceleratedDepreciation = depreciationR1 * percent;
                                           ratePercent = acceleratedDepreciation + " % ";

                                           depreciationRate1.setText(ratePercent);

                                           depreciationE1 = depreciationR1 * costToString;

                                           depreciationExpense1.setText(String.valueOf(depreciationE1));

                                           // value will be calculated based on useful life

                                           for (int a = 0; a < usefulLifeToString; a++) {

                                               double first = usefulLifeToString - one;
                                               cost2.setText(cost1.getText().toString());
                                               usefulLife2.setText(String.valueOf(first));

                                               depreciationR1 = first / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate2.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense2.setText(String.valueOf(depreciationE1));

                                               double second = first - one;
                                               cost3.setText(cost2.getText().toString());
                                               usefulLife3.setText(String.valueOf(second));

                                               depreciationR1 = second / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate3.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense3.setText(String.valueOf(depreciationE1));

                                               double third = second - one;
                                               cost4.setText(cost3.getText().toString());
                                               usefulLife4.setText(String.valueOf(third));

                                               depreciationR1 = third / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate4.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense4.setText(String.valueOf(depreciationE1));

                                               double fourth = third - one;
                                               cost5.setText(cost4.getText().toString());
                                               usefulLife5.setText(String.valueOf(fourth));

                                               depreciationR1 = fourth / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate5.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense5.setText(String.valueOf(depreciationE1));

                                               double fifth = fourth - one;
                                               cost6.setText(cost5.getText().toString());
                                               usefulLife6.setText(String.valueOf(fifth));

                                               depreciationR1 = fifth / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate6.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense6.setText(String.valueOf(depreciationE1));

                                               double sixth = fifth - one;
                                               cost7.setText(cost6.getText().toString());
                                               usefulLife7.setText(String.valueOf(sixth));

                                               depreciationR1 = sixth / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate7.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense7.setText(String.valueOf(depreciationE1));

                                               double seventh = sixth - one;
                                               cost8.setText(cost7.getText().toString());
                                               usefulLife8.setText(String.valueOf(seventh));

                                               depreciationR1 = seventh / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate8.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense8.setText(String.valueOf(depreciationE1));


                                               double eighth = seventh - one;
                                               cost9.setText(cost8.getText().toString());
                                               usefulLife9.setText(String.valueOf(eighth));

                                               depreciationR1 = eighth / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate9.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense9.setText(String.valueOf(depreciationE1));


                                               double ninth = eighth - one;
                                               cost10.setText(cost9.getText().toString());
                                               usefulLife10.setText(String.valueOf(ninth));

                                               depreciationR1 = ninth / depreciationR;
                                               acceleratedDepreciation = depreciationR1 * percent;
                                               ratePercent = acceleratedDepreciation + " % ";

                                               depreciationRate10.setText(ratePercent);

                                               depreciationE1 = depreciationR1 * costToString;

                                               depreciationExpense10.setText(String.valueOf(depreciationE1));

                                           } } else {
                                                     costToString = Double.parseDouble(cost1.getText().toString());
                                                     residualToString = Double.parseDouble(residual1.getText().toString());
                                                     usefulLifeToString = Double.parseDouble(usefulLife1.getText().toString());
                                                     depreciationR = usefulLifeToString * (usefulLifeToString + one) / two;
                                                     depreciationR1 = usefulLifeToString / depreciationR;
                                                     acceleratedDepreciation = depreciationR1 * percent;
                                                     ratePercent = acceleratedDepreciation + " % ";

                                                     depreciationRate1.setText(ratePercent);

                                                     depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                     depreciationExpense1.setText(String.valueOf(depreciationE1));

                                                     for (int a = 0; a < usefulLifeToString; a++) {

                                                         double first = usefulLifeToString - one;
                                                         cost2.setText(cost1.getText().toString());
                                                         residual2.setText(residual1.getText().toString());
                                                         usefulLife2.setText(String.valueOf(first));

                                                         depreciationR1 = first / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate2.setText(ratePercent);

                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense2.setText(String.valueOf(depreciationE1));

                                                         double second = first - one;
                                                         cost3.setText(cost2.getText().toString());
                                                         residual3.setText(residual2.getText().toString());
                                                         usefulLife3.setText(String.valueOf(second));

                                                         depreciationR1 = second / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate3.setText(ratePercent);

                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense3.setText(String.valueOf(depreciationE1));

                                                         double third = second - one;
                                                         cost4.setText(cost3.getText().toString());
                                                         residual4.setText(residual3.getText().toString());
                                                         usefulLife4.setText(String.valueOf(third));

                                                         depreciationR1 = third / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate4.setText(ratePercent);


                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense4.setText(String.valueOf(depreciationE1));

                                                         double fourth = third - one;
                                                         cost5.setText(cost4.getText().toString());
                                                         residual5.setText(residual4.getText().toString());
                                                         usefulLife5.setText(String.valueOf(fourth));

                                                         depreciationR1 = fourth / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate5.setText(ratePercent);

                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense5.setText(String.valueOf(depreciationE1));

                                                         double fifth = fourth - one;
                                                         cost6.setText(cost5.getText().toString());
                                                         residual6.setText(residual5.getText().toString());
                                                         usefulLife6.setText(String.valueOf(fifth));

                                                         depreciationR1 = fifth / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate6.setText(ratePercent);

                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense6.setText(String.valueOf(depreciationE1));

                                                         double sixth = fifth - one;
                                                         cost7.setText(cost6.getText().toString());
                                                         residual7.setText(residual6.getText().toString());
                                                         usefulLife7.setText(String.valueOf(sixth));

                                                         depreciationR1 = sixth / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate7.setText(ratePercent);

                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense7.setText(String.valueOf(depreciationE1));

                                                         double seventh = sixth - one;
                                                         cost8.setText(cost7.getText().toString());
                                                         residual8.setText(residual7.getText().toString());
                                                         usefulLife8.setText(String.valueOf(seventh));

                                                         depreciationR1 = seventh / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate8.setText(ratePercent);

                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense8.setText(String.valueOf(depreciationE1));


                                                         double eighth = seventh - one;
                                                         cost9.setText(cost8.getText().toString());
                                                         residual9.setText(residual8.getText().toString());
                                                         usefulLife9.setText(String.valueOf(eighth));

                                                         depreciationR1 = eighth / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate9.setText(ratePercent);

                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense9.setText(String.valueOf(depreciationE1));


                                                         double ninth = eighth - one;
                                                         cost10.setText(cost9.getText().toString());
                                                         residual10.setText(residual9.getText().toString());
                                                         usefulLife10.setText(String.valueOf(ninth));

                                                         depreciationR1 = ninth / depreciationR;
                                                         acceleratedDepreciation = depreciationR1 * percent;
                                                         ratePercent = acceleratedDepreciation + " % ";

                                                         depreciationRate10.setText(ratePercent);

                                                         depreciationE1 = depreciationR1 * (costToString - residualToString);

                                                         depreciationExpense10.setText(String.valueOf(depreciationE1));
                                                     }

                                                 }

                                       } else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}


                                   }
                               }
                               @Override
                               public void afterTextChanged(Editable editable) {

                               }
                           });

                        cost1.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                if (!cost1.getText().toString().isEmpty() && !usefulLife1.getText().toString().isEmpty()) {
                                    if(residual1.getText().toString().isEmpty()){
                                        costToString = Double.parseDouble(cost1.getText().toString());
                                        usefulLifeToString = Double.parseDouble(usefulLife1.getText().toString());
                                        depreciationR = usefulLifeToString * (usefulLifeToString + one) / two;
                                        depreciationR1 = usefulLifeToString / depreciationR;
                                        acceleratedDepreciation = depreciationR1 * percent;
                                        ratePercent = acceleratedDepreciation + " % ";

                                        depreciationRate1.setText(ratePercent);

                                        depreciationE1 = depreciationR1 * costToString;

                                        depreciationExpense1.setText(String.valueOf(depreciationE1));

                                        // value will be calculated based on useful life

                                        for (int a = 0; a < usefulLifeToString; a++) {

                                            double first = usefulLifeToString - one;
                                            cost2.setText(cost1.getText().toString());
                                            usefulLife2.setText(String.valueOf(first));

                                            depreciationR1 = first / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate2.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense2.setText(String.valueOf(depreciationE1));

                                            double second = first - one;
                                            cost3.setText(cost2.getText().toString());
                                            usefulLife3.setText(String.valueOf(second));

                                            depreciationR1 = second / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate3.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense3.setText(String.valueOf(depreciationE1));

                                            double third = second - one;
                                            cost4.setText(cost3.getText().toString());
                                            usefulLife4.setText(String.valueOf(third));

                                            depreciationR1 = third / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate4.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense4.setText(String.valueOf(depreciationE1));

                                            double fourth = third - one;
                                            cost5.setText(cost4.getText().toString());
                                            usefulLife5.setText(String.valueOf(fourth));

                                            depreciationR1 = fourth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate5.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense5.setText(String.valueOf(depreciationE1));

                                            double fifth = fourth - one;
                                            cost6.setText(cost5.getText().toString());
                                            usefulLife6.setText(String.valueOf(fifth));

                                            depreciationR1 = fifth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate6.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense6.setText(String.valueOf(depreciationE1));

                                            double sixth = fifth - one;
                                            cost7.setText(cost6.getText().toString());
                                            usefulLife7.setText(String.valueOf(sixth));

                                            depreciationR1 = sixth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate7.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense7.setText(String.valueOf(depreciationE1));

                                            double seventh = sixth - one;
                                            cost8.setText(cost7.getText().toString());
                                            usefulLife8.setText(String.valueOf(seventh));

                                            depreciationR1 = seventh / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate8.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense8.setText(String.valueOf(depreciationE1));


                                            double eighth = seventh - one;
                                            cost9.setText(cost8.getText().toString());
                                            usefulLife9.setText(String.valueOf(eighth));

                                            depreciationR1 = eighth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate9.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense9.setText(String.valueOf(depreciationE1));


                                            double ninth = eighth - one;
                                            cost10.setText(cost9.getText().toString());
                                            usefulLife10.setText(String.valueOf(ninth));

                                            depreciationR1 = ninth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate10.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * costToString;

                                            depreciationExpense10.setText(String.valueOf(depreciationE1));

                                        } } else {
                                        costToString = Double.parseDouble(cost1.getText().toString());
                                        residualToString = Double.parseDouble(residual1.getText().toString());
                                        usefulLifeToString = Double.parseDouble(usefulLife1.getText().toString());
                                        depreciationR = usefulLifeToString * (usefulLifeToString + one) / two;
                                        depreciationR1 = usefulLifeToString / depreciationR;
                                        acceleratedDepreciation = depreciationR1 * percent;
                                        ratePercent = acceleratedDepreciation + " % ";

                                        depreciationRate1.setText(ratePercent);

                                        depreciationE1 = depreciationR1 * (costToString - residualToString);

                                        depreciationExpense1.setText(String.valueOf(depreciationE1));

                                        for (int a = 0; a < usefulLifeToString; a++) {

                                            double first = usefulLifeToString - one;
                                            cost2.setText(cost1.getText().toString());
                                            residual2.setText(residual1.getText().toString());
                                            usefulLife2.setText(String.valueOf(first));

                                            depreciationR1 = first / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate2.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense2.setText(String.valueOf(depreciationE1));

                                            double second = first - one;
                                            cost3.setText(cost2.getText().toString());
                                            residual3.setText(residual2.getText().toString());
                                            usefulLife3.setText(String.valueOf(second));

                                            depreciationR1 = second / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate3.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense3.setText(String.valueOf(depreciationE1));

                                            double third = second - one;
                                            cost4.setText(cost3.getText().toString());
                                            residual4.setText(residual3.getText().toString());
                                            usefulLife4.setText(String.valueOf(third));

                                            depreciationR1 = third / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate4.setText(ratePercent);


                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense4.setText(String.valueOf(depreciationE1));

                                            double fourth = third - one;
                                            cost5.setText(cost4.getText().toString());
                                            residual5.setText(residual4.getText().toString());
                                            usefulLife5.setText(String.valueOf(fourth));

                                            depreciationR1 = fourth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate5.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense5.setText(String.valueOf(depreciationE1));

                                            double fifth = fourth - one;
                                            cost6.setText(cost5.getText().toString());
                                            residual6.setText(residual5.getText().toString());
                                            usefulLife6.setText(String.valueOf(fifth));

                                            depreciationR1 = fifth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate6.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense6.setText(String.valueOf(depreciationE1));

                                            double sixth = fifth - one;
                                            cost7.setText(cost6.getText().toString());
                                            residual7.setText(residual6.getText().toString());
                                            usefulLife7.setText(String.valueOf(sixth));

                                            depreciationR1 = sixth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate7.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense7.setText(String.valueOf(depreciationE1));

                                            double seventh = sixth - one;
                                            cost8.setText(cost7.getText().toString());
                                            residual8.setText(residual7.getText().toString());
                                            usefulLife8.setText(String.valueOf(seventh));

                                            depreciationR1 = seventh / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate8.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense8.setText(String.valueOf(depreciationE1));


                                            double eighth = seventh - one;
                                            cost9.setText(cost8.getText().toString());
                                            residual9.setText(residual8.getText().toString());
                                            usefulLife9.setText(String.valueOf(eighth));

                                            depreciationR1 = eighth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate9.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense9.setText(String.valueOf(depreciationE1));


                                            double ninth = eighth - one;
                                            cost10.setText(cost9.getText().toString());
                                            residual10.setText(residual9.getText().toString());
                                            usefulLife10.setText(String.valueOf(ninth));

                                            depreciationR1 = ninth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate10.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense10.setText(String.valueOf(depreciationE1));
                                        }

                                    }

                                } else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}


                            }


                            @Override
                            public void afterTextChanged(Editable editable) {

                            }
                        });


                        residual1.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                if (!cost1.getText().toString().isEmpty() && !usefulLife1.getText().toString().isEmpty()) {

                                        costToString = Double.parseDouble(cost1.getText().toString());
                                        residualToString = Double.parseDouble(residual1.getText().toString());
                                        usefulLifeToString = Double.parseDouble(usefulLife1.getText().toString());
                                        depreciationR = usefulLifeToString * (usefulLifeToString + one) / two;
                                        depreciationR1 = usefulLifeToString / depreciationR;
                                        acceleratedDepreciation = depreciationR1 * percent;
                                        ratePercent = acceleratedDepreciation + " % ";

                                        depreciationRate1.setText(ratePercent);

                                        depreciationE1 = depreciationR1 * (costToString - residualToString);

                                        depreciationExpense1.setText(String.valueOf(depreciationE1));

                                        for (int a = 0; a < usefulLifeToString; a++) {

                                            double first = usefulLifeToString - one;
                                            cost2.setText(cost1.getText().toString());
                                            residual2.setText(residual1.getText().toString());
                                            usefulLife2.setText(String.valueOf(first));

                                            depreciationR1 = first / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate2.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense2.setText(String.valueOf(depreciationE1));

                                            double second = first - one;
                                            cost3.setText(cost2.getText().toString());
                                            residual3.setText(residual2.getText().toString());
                                            usefulLife3.setText(String.valueOf(second));

                                            depreciationR1 = second / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate3.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense3.setText(String.valueOf(depreciationE1));

                                            double third = second - one;
                                            cost4.setText(cost3.getText().toString());
                                            residual4.setText(residual3.getText().toString());
                                            usefulLife4.setText(String.valueOf(third));

                                            depreciationR1 = third / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate4.setText(ratePercent);


                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense4.setText(String.valueOf(depreciationE1));

                                            double fourth = third - one;
                                            cost5.setText(cost4.getText().toString());
                                            residual5.setText(residual4.getText().toString());
                                            usefulLife5.setText(String.valueOf(fourth));

                                            depreciationR1 = fourth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate5.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense5.setText(String.valueOf(depreciationE1));

                                            double fifth = fourth - one;
                                            cost6.setText(cost5.getText().toString());
                                            residual6.setText(residual5.getText().toString());
                                            usefulLife6.setText(String.valueOf(fifth));

                                            depreciationR1 = fifth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate6.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense6.setText(String.valueOf(depreciationE1));

                                            double sixth = fifth - one;
                                            cost7.setText(cost6.getText().toString());
                                            residual7.setText(residual6.getText().toString());
                                            usefulLife7.setText(String.valueOf(sixth));

                                            depreciationR1 = sixth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate7.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense7.setText(String.valueOf(depreciationE1));

                                            double seventh = sixth - one;
                                            cost8.setText(cost7.getText().toString());
                                            residual8.setText(residual7.getText().toString());
                                            usefulLife8.setText(String.valueOf(seventh));

                                            depreciationR1 = seventh / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate8.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense8.setText(String.valueOf(depreciationE1));


                                            double eighth = seventh - one;
                                            cost9.setText(cost8.getText().toString());
                                            residual9.setText(residual8.getText().toString());
                                            usefulLife9.setText(String.valueOf(eighth));

                                            depreciationR1 = eighth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate9.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense9.setText(String.valueOf(depreciationE1));


                                            double ninth = eighth - one;
                                            cost10.setText(cost9.getText().toString());
                                            residual10.setText(residual9.getText().toString());
                                            usefulLife10.setText(String.valueOf(ninth));

                                            depreciationR1 = ninth / depreciationR;
                                            acceleratedDepreciation = depreciationR1 * percent;
                                            ratePercent = acceleratedDepreciation + " % ";

                                            depreciationRate10.setText(ratePercent);

                                            depreciationE1 = depreciationR1 * (costToString - residualToString);

                                            depreciationExpense10.setText(String.valueOf(depreciationE1));
                                        }



                                } else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}


                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                            }
                        });
                    break;

                case "Declining Balance":

                    starDate.setVisibility(View.GONE);

                    startDate1.setVisibility(View.GONE);
                    startDate2.setVisibility(View.GONE);
                    startDate3.setVisibility(View.GONE);
                    startDate4.setVisibility(View.GONE);
                    startDate5.setVisibility(View.GONE);
                    startDate6.setVisibility(View.GONE);
                    startDate7.setVisibility(View.GONE);
                    startDate8.setVisibility(View.GONE);
                    startDate9.setVisibility(View.GONE);
                    startDate10.setVisibility(View.GONE);

                    endDate.setVisibility(View.GONE);

                    endDate1.setVisibility(View.GONE);
                    endDate2.setVisibility(View.GONE);
                    endDate3.setVisibility(View.GONE);
                    endDate4.setVisibility(View.GONE);
                    endDate5.setVisibility(View.GONE);
                    endDate6.setVisibility(View.GONE);
                    endDate7.setVisibility(View.GONE);
                    endDate8.setVisibility(View.GONE);
                    endDate9.setVisibility(View.GONE);
                    endDate10.setVisibility(View.GONE);

                    usefulLife1.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost1.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost1.getText().toString());
                                double depreciationR = one / Double.parseDouble(usefulLife1.getText().toString());
                                depreciationR1 = depreciationR * percent;
                                double acceleratedDepreciation = two * depreciationR1;
                                String ratePercent = acceleratedDepreciation + " % ";

                                depreciationRate1.setText(ratePercent);

                                depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                depreciationExpense1.setText(String.valueOf(depreciationE1));


                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost1.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!usefulLife1.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost1.getText().toString());
                                double depreciationR = one / Double.parseDouble(usefulLife1.getText().toString());
                                depreciationR1 = depreciationR * percent;
                                double acceleratedDepreciation = two * depreciationR1;
                                String ratePercent = acceleratedDepreciation + " % ";

                                depreciationRate1.setText(ratePercent);

                                depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                depreciationExpense1.setText(String.valueOf(depreciationE1));
                            }

                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });



                    usefulLife2.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1,  int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost2.getText().toString().isEmpty()){

                                    costToString = Double.parseDouble(cost2.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife2.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate2.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense2.setText(String.valueOf(depreciationE1));


                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost2.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!usefulLife2.getText().toString().isEmpty()){

                                    costToString = Double.parseDouble(cost2.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife2.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate2.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense2.setText(String.valueOf(depreciationE1));

                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }


                    });


                    usefulLife3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost3.getText().toString().isEmpty()){


                                    costToString = Double.parseDouble(cost3.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife3.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate3.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense3.setText(String.valueOf(depreciationE1));
                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                                if (!usefulLife3.getText().toString().isEmpty()) {
                                    costToString = Double.parseDouble(cost3.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife3.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate1.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense1.setText(String.valueOf(depreciationE1));


                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    usefulLife4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost4.getText().toString().isEmpty()){

                                    costToString = Double.parseDouble(cost4.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife4.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate4.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));


                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!usefulLife4.getText().toString().isEmpty()){

                                    costToString = Double.parseDouble(cost4.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife4.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate4.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));

                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    usefulLife5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost5.getText().toString().isEmpty()){


                                    costToString = Double.parseDouble(cost5.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife5.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate5.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));


                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!usefulLife5.getText().toString().isEmpty()){


                                    costToString = Double.parseDouble(cost5.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife5.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate5.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));


                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });



                    usefulLife6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost6.getText().toString().isEmpty()){


                                    costToString = Double.parseDouble(cost6.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife6.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate6.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));

                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!usefulLife6.getText().toString().isEmpty()){


                                    costToString = Double.parseDouble(cost6.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife6.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate6.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));
                                }


                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });



                    usefulLife7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost7.getText().toString().isEmpty()){

                               
                                    costToString = Double.parseDouble(cost7.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife7.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate7.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));
                                }

                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!usefulLife7.getText().toString().isEmpty()){


                                    costToString = Double.parseDouble(cost7.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife7.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate7.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));

                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    usefulLife8.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost8.getText().toString().isEmpty()){


                                    costToString = Double.parseDouble(cost8.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife8.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate8.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense8.setText(String.valueOf(depreciationE1));



                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost8.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!usefulLife8.getText().toString().isEmpty()){

                                
                                    costToString = Double.parseDouble(cost8.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife8.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate8.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense8.setText(String.valueOf(depreciationE1));
                          
                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                   
           
                    usefulLife9.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost9.getText().toString().isEmpty()){

                                
                                    costToString = Double.parseDouble(cost9.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife9.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate9.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));
                               
                          
                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost9.addTextChangedListener(new TextWatcher() {
                                                     @Override
                                                     public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                     }

                                                     @Override
                                                     public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                         if (!usefulLife9.getText().toString().isEmpty()) {


                                                             costToString = Double.parseDouble(cost9.getText().toString());
                                                             double depreciationR = one / Double.parseDouble(usefulLife9.getText().toString());
                                                             depreciationR1 = depreciationR * percent;
                                                             double acceleratedDepreciation = two * depreciationR1;
                                                             String ratePercent = acceleratedDepreciation + " % ";

                                                             depreciationRate9.setText(ratePercent);

                                                             depreciationE1 = (acceleratedDepreciation / percent) * costToString;

                                                             depreciationExpense9.setText(String.valueOf(depreciationE1));

                                                         } else {
                                                             Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                                                         }
                                                     }

                                                     @Override
                                                     public void afterTextChanged(Editable editable) {

                                                     }
                                                 });


                    usefulLife10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!cost10.getText().toString().isEmpty()){

                                
                                    costToString = Double.parseDouble(cost10.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife10.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate10.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));

                            }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    cost10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if(!usefulLife10.getText().toString().isEmpty()){

                                    costToString = Double.parseDouble(cost10.getText().toString());
                                    double depreciationR = one / Double.parseDouble(usefulLife10.getText().toString());
                                    depreciationR1 = depreciationR * percent;
                                    double acceleratedDepreciation = two * depreciationR1;
                                    String ratePercent = acceleratedDepreciation + " % ";

                                    depreciationRate10.setText(ratePercent);

                                    depreciationE1 = (acceleratedDepreciation/percent) * costToString;

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));


                       }
                            else{Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();}
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                   
                    break;

                case "Units of Production":


                    endDate.setVisibility(View.GONE);

                    endDate1.setVisibility(View.GONE);
                    endDate2.setVisibility(View.GONE);
                    endDate3.setVisibility(View.GONE);
                    endDate4.setVisibility(View.GONE);
                    endDate5.setVisibility(View.GONE);
                    endDate6.setVisibility(View.GONE);
                    endDate7.setVisibility(View.GONE);
                    endDate8.setVisibility(View.GONE);
                    endDate9.setVisibility(View.GONE);
                    endDate10.setVisibility(View.GONE);


                    usefulLife.setText("Estimated Unit Production");
                    starDate.setText("Unit Produced");


                          usefulLife1.addTextChangedListener(new TextWatcher() {
                              @Override
                              public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                              }

                              @Override
                              public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                                  if (!cost1.getText().toString().isEmpty() && !startDate1.getText().toString().isEmpty()) {
                                      if (residual1.getText().toString().isEmpty()) {

                                          costToString = Double.parseDouble(cost1.getText().toString());
                                          double depreciationR = costToString / Double.parseDouble(usefulLife1.getText().toString());

                                          depreciationR1 = depreciationR * percent;

                                          String ratePercent = depreciationR1 + " % ";

                                          depreciationRate1.setText(ratePercent);

                                          depreciationE1 = depreciationR * Double.parseDouble(startDate1.getText().toString());

                                          depreciationExpense1.setText(String.valueOf(depreciationE1));
                                      } else {

                                          costToString = Double.parseDouble(cost1.getText().toString());
                                          residualToString = Double.parseDouble(residual1.getText().toString());

                                          double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife1.getText().toString());

                                          depreciationR1 = depreciationR * percent;

                                          String ratePercent = depreciationR1 + " % ";

                                          depreciationRate1.setText(ratePercent);

                                          depreciationE1 = depreciationR * Double.parseDouble(startDate1.getText().toString());

                                          depreciationExpense1.setText(String.valueOf(depreciationE1));
                                      }
                                  } else {
                                      Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                                  }

                              }

                              @Override
                              public void afterTextChanged(Editable editable) {

                              }
                          });


                          cost1.addTextChangedListener(new TextWatcher() {
                              @Override
                              public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                              }

                              @Override
                              public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                  if (!usefulLife1.getText().toString().isEmpty() && !startDate1.getText().toString().isEmpty()) {
                                      if (residual1.getText().toString().isEmpty()) {

                                          costToString = Double.parseDouble(cost1.getText().toString());
                                          double depreciationR = costToString / Double.parseDouble(usefulLife1.getText().toString());

                                          depreciationR1 = depreciationR * percent;

                                          String ratePercent = depreciationR1 + " % ";

                                          depreciationRate1.setText(ratePercent);

                                          depreciationE1 = depreciationR * Double.parseDouble(startDate1.getText().toString());

                                          depreciationExpense1.setText(String.valueOf(depreciationE1));
                                      } else {

                                          costToString = Double.parseDouble(cost1.getText().toString());
                                          residualToString = Double.parseDouble(residual1.getText().toString());

                                          double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife1.getText().toString());

                                          depreciationR1 = depreciationR * percent;

                                          String ratePercent = depreciationR1 + " % ";

                                          depreciationRate1.setText(ratePercent);

                                          depreciationE1 = depreciationR * Double.parseDouble(startDate1.getText().toString());

                                          depreciationExpense1.setText(String.valueOf(depreciationE1));
                                      }
                                  } else {
                                      Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                                  }

                              }

                              @Override
                              public void afterTextChanged(Editable editable) {

                              }
                          });

                          residual1.addTextChangedListener(new TextWatcher() {
                              @Override
                              public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                              }

                              @Override
                              public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                  if (!usefulLife1.getText().toString().isEmpty() && !cost1.getText().toString().isEmpty() && !startDate1.getText().toString().isEmpty()){

                                      costToString = Double.parseDouble(cost1.getText().toString());
                                      residualToString = Double.parseDouble(residual1.getText().toString());

                                      double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife1.getText().toString());

                                      depreciationR1 = depreciationR * percent;

                                      String ratePercent = depreciationR1 + " % ";

                                      depreciationRate1.setText(ratePercent);

                                      depreciationE1 = depreciationR * Double.parseDouble(startDate1.getText().toString());

                                      depreciationExpense1.setText(String.valueOf(depreciationE1));
                                  }
                              }

                              @Override
                              public void afterTextChanged(Editable editable) {

                              }
                          });


                          startDate1.addTextChangedListener(new TextWatcher() {
                              @Override
                              public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                              }

                              @Override
                              public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                  if (!usefulLife1.getText().toString().isEmpty() && !cost1.getText().toString().isEmpty()) {
                                      if (residual1.getText().toString().isEmpty()) {

                                          costToString = Double.parseDouble(cost1.getText().toString());
                                          double depreciationR = costToString / Double.parseDouble(usefulLife1.getText().toString());

                                          depreciationR1 = depreciationR * percent;

                                          String ratePercent = depreciationR1 + " % ";

                                          depreciationRate1.setText(ratePercent);

                                          depreciationE1 = depreciationR * Double.parseDouble(startDate1.getText().toString());

                                          depreciationExpense1.setText(String.valueOf(depreciationE1));
                                      } else {

                                          costToString = Double.parseDouble(cost1.getText().toString());
                                          residualToString = Double.parseDouble(residual1.getText().toString());

                                          double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife1.getText().toString());

                                          depreciationR1 = depreciationR * percent;

                                          String ratePercent = depreciationR1 + " % ";

                                          depreciationRate1.setText(ratePercent);

                                          depreciationE1 = depreciationR * Double.parseDouble(startDate1.getText().toString());

                                          depreciationExpense1.setText(String.valueOf(depreciationE1));
                                      }
                                  } else {
                                      Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                                  }
                              }

                              @Override
                              public void afterTextChanged(Editable editable) {

                              }
                          });
                    usefulLife2.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost2.getText().toString().isEmpty() && !startDate2.getText().toString().isEmpty()) {
                                if (residual2.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost2.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife2.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate2.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate2.getText().toString());

                                    depreciationExpense2.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost2.getText().toString());
                                    residualToString = Double.parseDouble(residual2.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife2.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate2.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate2.getText().toString());

                                    depreciationExpense2.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost2.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife2.getText().toString().isEmpty() & !startDate2.getText().toString().isEmpty()) {
                                if (residual2.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost2.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife2.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate2.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate2.getText().toString());

                                    depreciationExpense2.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost2.getText().toString());
                                    residualToString = Double.parseDouble(residual2.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife2.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate2.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate2.getText().toString());

                                    depreciationExpense2.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual2.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife2.getText().toString().isEmpty() && !cost2.getText().toString().isEmpty() && !startDate2.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost2.getText().toString());
                                residualToString = Double.parseDouble(residual2.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife2.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate2.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate2.getText().toString());

                                depreciationExpense2.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    startDate2.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!usefulLife2.getText().toString().isEmpty() & !cost2.getText().toString().isEmpty()) {
                                if (residual2.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost2.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife2.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate2.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate2.getText().toString());

                                    depreciationExpense2.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost2.getText().toString());
                                    residualToString = Double.parseDouble(residual2.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife2.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate2.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate2.getText().toString());

                                    depreciationExpense2.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    usefulLife3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost3.getText().toString().isEmpty() && !startDate3.getText().toString().isEmpty()) {
                                if (residual3.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost3.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife3.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate3.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate3.getText().toString());

                                    depreciationExpense3.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost3.getText().toString());
                                    residualToString = Double.parseDouble(residual3.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife3.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate3.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate3.getText().toString());

                                    depreciationExpense3.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife3.getText().toString().isEmpty() && !startDate3.getText().toString().isEmpty()) {
                                if (residual3.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost3.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife3.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate3.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate3.getText().toString());

                                    depreciationExpense3.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost3.getText().toString());
                                    residualToString = Double.parseDouble(residual3.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife3.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate3.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate3.getText().toString());

                                    depreciationExpense3.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife3.getText().toString().isEmpty() && !cost3.getText().toString().isEmpty() & !startDate3.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost3.getText().toString());
                                residualToString = Double.parseDouble(residual3.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife3.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate3.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate3.getText().toString());

                                depreciationExpense3.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    startDate3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife3.getText().toString().isEmpty() && !cost3.getText().toString().isEmpty()) {
                                if (residual3.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost3.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife3.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate3.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate3.getText().toString());

                                    depreciationExpense3.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost3.getText().toString());
                                    residualToString = Double.parseDouble(residual3.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife3.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate3.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate3.getText().toString());

                                    depreciationExpense3.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                    usefulLife4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost4.getText().toString().isEmpty() && !startDate4.getText().toString().isEmpty()) {
                                if (residual4.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost4.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate4.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost4.getText().toString());
                                    residualToString = Double.parseDouble(residual4.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate4.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife4.getText().toString().isEmpty() && !startDate4.getText().toString().isEmpty()) {
                                if (residual4.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost4.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate4.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost4.getText().toString());
                                    residualToString = Double.parseDouble(residual4.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate4.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife4.getText().toString().isEmpty() && !cost4.getText().toString().isEmpty() && !startDate4.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost4.getText().toString());
                                residualToString = Double.parseDouble(residual4.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife4.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate4.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate4.getText().toString());

                                depreciationExpense4.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    startDate4.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!usefulLife4.getText().toString().isEmpty() && !cost4.getText().toString().isEmpty()) {
                                if (residual4.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost4.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate4.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost4.getText().toString());
                                    residualToString = Double.parseDouble(residual4.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife4.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate4.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate4.getText().toString());

                                    depreciationExpense4.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                    usefulLife5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost5.getText().toString().isEmpty() && !startDate5.getText().toString().isEmpty()) {
                                if (residual5.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost5.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate5.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost5.getText().toString());
                                    residualToString = Double.parseDouble(residual5.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate5.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife5.getText().toString().isEmpty() && !startDate5.getText().toString().isEmpty()) {
                                if (residual5.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost5.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate5.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost5.getText().toString());
                                    residualToString = Double.parseDouble(residual5.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate5.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife5.getText().toString().isEmpty() && !cost5.getText().toString().isEmpty() && !startDate5.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost5.getText().toString());
                                residualToString = Double.parseDouble(residual5.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife5.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate5.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate5.getText().toString());

                                depreciationExpense5.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    startDate5.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!cost5.getText().toString().isEmpty() && !usefulLife5.getText().toString().isEmpty()) {
                                if (residual5.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost5.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate5.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost5.getText().toString());
                                    residualToString = Double.parseDouble(residual5.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife5.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";


                                    depreciationRate5.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate5.getText().toString());

                                    depreciationExpense5.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                    usefulLife6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost6.getText().toString().isEmpty() && !startDate6.getText().toString().isEmpty()) {
                                if (residual6.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost6.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate6.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost6.getText().toString());
                                    residualToString = Double.parseDouble(residual6.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate6.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife6.getText().toString().isEmpty() && !startDate6.getText().toString().isEmpty()) {
                                if (residual6.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost6.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate6.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost6.getText().toString());
                                    residualToString = Double.parseDouble(residual6.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate6.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife6.getText().toString().isEmpty() && !cost6.getText().toString().isEmpty() && !startDate6.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost6.getText().toString());
                                residualToString = Double.parseDouble(residual6.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife6.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate6.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate6.getText().toString());

                                depreciationExpense6.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    startDate6.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!usefulLife6.getText().toString().isEmpty() && !cost6.getText().toString().isEmpty()) {
                                if (residual6.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost6.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate6.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost6.getText().toString());
                                    residualToString = Double.parseDouble(residual6.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife6.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate6.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate6.getText().toString());

                                    depreciationExpense6.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    usefulLife7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost7.getText().toString().isEmpty() && !startDate7.getText().toString().isEmpty()) {
                                if (residual7.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost7.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate7.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost7.getText().toString());
                                    residualToString = Double.parseDouble(residual7.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate7.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife7.getText().toString().isEmpty() && !startDate7.getText().toString().isEmpty()) {
                                if (residual7.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost7.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate7.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost7.getText().toString());
                                    residualToString = Double.parseDouble(residual7.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate1.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife7.getText().toString().isEmpty() && !cost7.getText().toString().isEmpty() && !startDate7.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost7.getText().toString());
                                residualToString = Double.parseDouble(residual7.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife7.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate7.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate7.getText().toString());

                                depreciationExpense7.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    startDate7.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife7.getText().toString().isEmpty() && !cost7.getText().toString().isEmpty()) {
                                if (residual7.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost7.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate7.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost7.getText().toString());
                                    residualToString = Double.parseDouble(residual7.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife7.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate1.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate7.getText().toString());

                                    depreciationExpense7.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                    usefulLife8.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost8.getText().toString().isEmpty() && !startDate8.getText().toString().isEmpty()) {
                                if (residual8.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost8.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate8.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate8.getText().toString());

                                    depreciationExpense8.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost8.getText().toString());
                                    residualToString = Double.parseDouble(residual8.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate8.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate8.getText().toString());

                                    depreciationExpense8.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost8.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife8.getText().toString().isEmpty() && !startDate8.getText().toString().isEmpty()) {
                                if (residual8.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost8.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate8.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate8.getText().toString());

                                    depreciationExpense8.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost8.getText().toString());
                                    residualToString = Double.parseDouble(residual8.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate8.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate8.getText().toString());

                                    depreciationExpense1.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual8.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife8.getText().toString().isEmpty() && !cost8.getText().toString().isEmpty() && !startDate8.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost8.getText().toString());
                                residualToString = Double.parseDouble(residual8.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife8.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate8.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate8.getText().toString());

                                depreciationExpense8.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    startDate8.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife8.getText().toString().isEmpty() && !cost8.getText().toString().isEmpty()) {
                                if (residual8.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost8.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate8.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate8.getText().toString());

                                    depreciationExpense8.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost8.getText().toString());
                                    residualToString = Double.parseDouble(residual8.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife8.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate8.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate8.getText().toString());

                                    depreciationExpense1.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                    usefulLife9.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost9.getText().toString().isEmpty() && !startDate9.getText().toString().isEmpty()) {
                                if (residual9.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost9.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate9.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost9.getText().toString());
                                    residualToString = Double.parseDouble(residual9.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate9.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost9.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife9.getText().toString().isEmpty() && !startDate9.getText().toString().isEmpty()) {
                                if (residual9.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost9.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate9.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost9.getText().toString());
                                    residualToString = Double.parseDouble(residual9.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate9.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual9.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife9.getText().toString().isEmpty() && !cost9.getText().toString().isEmpty() & !startDate9.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost9.getText().toString());
                                residualToString = Double.parseDouble(residual9.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife9.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate9.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate9.getText().toString());

                                depreciationExpense9.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    startDate9.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost9.getText().toString().isEmpty() && !usefulLife9.getText().toString().isEmpty()) {
                                if (residual9.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost9.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate9.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost9.getText().toString());
                                    residualToString = Double.parseDouble(residual9.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife9.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate9.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate9.getText().toString());

                                    depreciationExpense9.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                    usefulLife10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                            if (!cost10.getText().toString().isEmpty() && !startDate10.getText().toString().isEmpty()) {
                                if (residual10.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost10.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate10.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost10.getText().toString());
                                    residualToString = Double.parseDouble(residual10.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate10.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });


                    cost10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife10.getText().toString().isEmpty() && !startDate10.getText().toString().isEmpty()) {
                                if (residual10.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost10.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate10.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost10.getText().toString());
                                    residualToString = Double.parseDouble(residual10.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate10.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    residual10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            if (!usefulLife10.getText().toString().isEmpty() && !cost10.getText().toString().isEmpty() && !startDate10.getText().toString().isEmpty()){

                                costToString = Double.parseDouble(cost10.getText().toString());
                                residualToString = Double.parseDouble(residual10.getText().toString());

                                double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife10.getText().toString());

                                depreciationR1 = depreciationR * percent;

                                String ratePercent = depreciationR1 + " % ";

                                depreciationRate10.setText(ratePercent);

                                depreciationE1 = depreciationR * Double.parseDouble(startDate10.getText().toString());

                                depreciationExpense10.setText(String.valueOf(depreciationE1));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });

                    startDate10.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }


                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            if (!cost10.getText().toString().isEmpty() && !usefulLife10.getText().toString().isEmpty()) {
                                if (residual10.getText().toString().isEmpty()) {

                                    costToString = Double.parseDouble(cost10.getText().toString());
                                    double depreciationR = costToString / Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate10.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));
                                } else {

                                    costToString = Double.parseDouble(cost10.getText().toString());
                                    residualToString = Double.parseDouble(residual10.getText().toString());

                                    double depreciationR = (costToString - residualToString)/ Double.parseDouble(usefulLife10.getText().toString());

                                    depreciationR1 = depreciationR * percent;

                                    String ratePercent = depreciationR1 + " % ";

                                    depreciationRate10.setText(ratePercent);

                                    depreciationE1 = depreciationR * Double.parseDouble(startDate10.getText().toString());

                                    depreciationExpense10.setText(String.valueOf(depreciationE1));
                                }
                            } else {
                                Toast.makeText(getContext(), "Please enter value", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
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


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
       String date = (i1 + 1) + "/" + i2 + "/" + i;
       startDate1.setText(date);

       startDate1.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {

               if(i2 == 1) {
                   int usefulLifeToStr = Integer.parseInt(usefulLife1.getText().toString());
                   int day = i2 + 30;
                   String Edate = (i1+ 1) + "/" + day + "/" + (i + usefulLifeToStr) ;

                   endDate1.setText(Edate);
               }
           }
       });
       usefulLife1.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int a, int a1, int a2) {


           }

           @Override
           public void onTextChanged(CharSequence charSequence, int a, int a1, int a2) {
               if(i2 == 1) {
                   int usefulLifeToStr = Integer.parseInt(usefulLife1.getText().toString());
                   int day = i2 + 30;
                   String Edate = (i1+ 1) + "/" + day + "/" + (i + usefulLifeToStr) ;

                   endDate1.setText(Edate);
               }
           }

           @Override
           public void afterTextChanged(Editable editable) {



           }
       });


    }
}