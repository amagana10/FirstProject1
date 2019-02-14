package com.example.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnLongClickListener/*second way implements View.OnClickListener*/ {
    TextView tvFirstName;
    TextView tvLastName;
    EditText etFirstName;
    EditText etLastName;
    Button btnDisplayName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //old way was to cast and bind views
        tvFirstName = (TextView)findViewById(R.id.tvFirstNameDisplay);

        tvLastName = findViewById(R.id.tvLastNameDisplay);
        etFirstName = findViewById(R.id.etFirstNameInput);
        etLastName = findViewById(R.id.etLastNameInput);
        btnDisplayName = findViewById(R.id.btnSendName);
        etFirstName.addTextChangedListener(this);
        etLastName.addTextChangedListener(this);
        btnDisplayName.setOnLongClickListener(this);

        /*First way to implement button
        btnDisplayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //take actions
            }
        });
        */

        /* second Way to implement button
        btnDisplayName.setOnClickListener(this); */

    }

    public void onButtonClickHandler(View view) {
        switch (view.getId()) {
            case R.id.btnSendName:
                String firstName = etFirstName.getText() != null ? etFirstName.getText().toString(): "";
                String lastName = etLastName.getText() != null ? etLastName.getText().toString():"";
                tvFirstName.setText(firstName);
                tvLastName.setText(lastName);

                break;

            case R.id.btnClearName:
                tvFirstName.setText("");
                tvLastName.setText("");

                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, "String Length = " + s.toString().length(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "Long Click", Toast.LENGTH_SHORT).show();
        return false;
    }
}
