package com.example.rentalsystem;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class Add extends AppCompatActivity {
    private RadioGroup radioStatusGroup;
    private Button btnAdd;
    private RadioButton btnHire, btnRent;

    private RadioButton  radioStatusButton ;

    private String[] states  = new String[]{
            "1","2","3","4","5","6","7","8",
            "9","10"
    };
    Realm mRealm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = new TextView(this);
        textView.setText("Add Room");
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLUE);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(textView);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
       // addListenerOnButton();
        mRealm = Realm.getDefaultInstance();

//
    }
    public void add(View view) {
        final Dialog dialog = new Dialog(this);

        radioStatusGroup = (RadioGroup) findViewById(R.id.radioStatus);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnHire = (RadioButton) findViewById(R.id.btnHire);
        btnRent = (RadioButton) findViewById(R.id.btnRent);

        // get selected radio button from radioGroup
        int selectedId = radioStatusGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioStatusButton = (RadioButton) findViewById(selectedId);
        if(btnHire==radioStatusButton){

            Realm realm = null;
            try {
                realm = Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {


                        try {


                            if (!inName.getText().toString().trim().isEmpty()) {
                                Employee employee = new Employee();
                                employee.name = inName.getText().toString().trim();

                                if (!inAge.getText().toString().trim().isEmpty())
                                    employee.age = Integer.parseInt(inAge.getText().toString().trim());


                                String languageKnown = inSkill.getText().toString().trim();

                                if (!languageKnown.isEmpty()) {
                                    Skill skill = realm.where(Skill.class).equalTo(Skill.PROPERTY_SKILL, languageKnown).findFirst();

                                    if (skill == null) {
                                        skill = realm.createObject(Skill.class, languageKnown);
                                        realm.copyToRealm(skill);
                                    }

                                    employee.skills = new RealmList<>();
                                    employee.skills.add(skill);
                                }

                                realm.copyToRealm(employee);
                            }

                        } catch (RealmPrimaryKeyConstraintException e) {

                        }
                    }
                });
            } finally {
                if (realm != null) {
                    realm.close();
                }
            }





        }

        if(btnHire==radioStatusButton){
            dialog.setContentView(R.layout.dialog_addperson);
            dialog.setCancelable(false);
            dialog.show();
            Spinner spin = (Spinner)dialog.findViewById(R.id.spinner);
            ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(Add.this,  android.R.layout.simple_spinner_item, states);
            adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin.setAdapter(adapter_state);
            Button button= (Button) dialog.findViewById(R.id.btnCancelP);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    dialog.dismiss();
                    ;;
                }
            });
        }


    }
}

