package com.example.rentalsystem;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Services extends AppCompatActivity{
    EditText erate, wrate, tvrate, prate, irate;
    String eupdated, wupdated, tvupdated, pupdated, iupdated;
    Button btnAdd, btnClear;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Electricity = "elecKey";
    public static final String Water = "waterKey";
    public static final String Television = "tvKey";
    public static final String Telephone = "phoneKey";
    public static final String Internet = "netKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = new TextView(this);
        textView.setText("Services");
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLUE);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(textView);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        erate= (EditText)findViewById(R.id.electricity_rate);
        wrate= (EditText)findViewById(R.id.water_rate);
        tvrate= (EditText)findViewById(R.id.tv_rate);
        prate= (EditText)findViewById(R.id.phone__rate);
        irate= (EditText)findViewById(R.id.net_rate);
        btnAdd=(Button) findViewById(R.id.btnAddS);
        btnClear=(Button) findViewById(R.id.btnClear);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        if (sharedpreferences.contains(Electricity)) {
            erate.setText(sharedpreferences.getString(Electricity, ""));
        }
        if (sharedpreferences.contains(Water)) {
            wrate.setText(sharedpreferences.getString(Water, ""));

        }
        if (sharedpreferences.contains(Telephone)) {
            tvrate.setText(sharedpreferences.getString(Telephone, ""));

        }if (sharedpreferences.contains(Television)) {
            prate.setText(sharedpreferences.getString(Television, ""));

        }if (sharedpreferences.contains(Internet)) {
            irate.setText(sharedpreferences.getString(Internet, ""));

        }
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                eupdated=erate.getText().toString();
                wupdated=wrate.getText().toString();
                tvupdated=tvrate.getText().toString();
                pupdated=prate.getText().toString();
                iupdated=irate.getText().toString();



                if ((eupdated.matches("")) && (wupdated.matches("")) && (tvupdated.matches("")) && (pupdated.matches("")) && (iupdated.matches("")))
                {
                    Snackbar.make(view, "All fields empty! Nothing to Save", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else
                {
                    sharedpreferences = getSharedPreferences(MyPREFERENCES,
                            Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(Electricity, eupdated);
                    editor.putString(Water, wupdated);
                    editor.putString(Television, tvupdated);
                    editor.putString(Telephone, pupdated);
                    editor.putString(Internet, iupdated);

                    editor.commit();
                    Snackbar.make(view, "Rates Updated", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                erate.setText("");
                wrate.setText("");
                tvrate.setText("");
                prate.setText("");
                irate.setText("");
                erate.setText("");

                    sharedpreferences = getSharedPreferences(MyPREFERENCES,
                            Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(Electricity, "");
                    editor.putString(Water, "");
                    editor.putString(Television, "");
                    editor.putString(Telephone,"");
                    editor.putString(Internet, "");

                    editor.commit();
                    Snackbar.make(view, "Rates Cleared", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

        });

    }





//                buttonA.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View view) {
//
//                        SRate = dialog.findViewById(R.id.srate);
//
//
//                        checkSName = selecteditem;
//                        checkSRate = SRate.getText().toString();
//                        checkSUnit = val;
//                        Pattern ps = Pattern.compile("[+-]?[0-9][0-9]*");
//
//                        Matcher ms = ps.matcher(checkSRate);
//                        if ((checkSRate.matches(""))) {
//                            SRate.requestFocus();
//                            SRate.setError("Cannot be empty");
//                        } else {
//                            if ((ms.matches()) == false) {
//                                SRate.requestFocus();
//                                SRate.setError("Farm name should contain numbers only.");
//                            } else {
//                                realm.beginTransaction();  //open the database
//                                //database operation
//                                Number currentIdNum = realm.where(services.class).max("service_id");
//                                int nextId;
//                                if (currentIdNum == null) {
//                                    nextId = 1;
//                                } else {
//                                    nextId = currentIdNum.intValue() + 1;
//                                }
//                                services obj = realm.createObject(services.class, nextId);  //this will create a
//                                //                            information object which will be inserted in dtabase
//                                obj.setService_name(checkSName);
//                                obj.setService_rate(Integer.parseInt(checkSRate));
//                                obj.setService_unit(checkSUnit);
//
//                                RealmResults<services> results = realm.where(services.class).findAll();
//
//                                textView = (TextView) findViewById(R.id.textView);
//                                textView.setText("");
//                                for (services service : results) {
//                                    textView.append(" Service name:  " + service.getService_name() + "  Service Rate:  " + service.getService_rate() + " " + service.getService_unit());
//                                }
//
//
//
//                                realm.commitTransaction();
//                                Snackbar.make(view, "Service Added", Snackbar.LENGTH_LONG)
//                                        .setAction("Action", null).show();
//                                dialog.dismiss();
//                            }
//                        }
//                    }
//
//                });
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
    }