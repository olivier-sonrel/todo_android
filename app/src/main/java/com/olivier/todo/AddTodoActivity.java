package com.olivier.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTodoActivity extends AppCompatActivity {

    private static final int RESULT_OK = 1;
    private static final int RESULT_CANCELED = 0;


    private EditText etName;
    private Button btnAdd;
    private Button btnCancel;
    private Spinner spUrgency;
    private Context context;
    private String[] urgencies;
    private Todo todo;

    public static String[] getUrgencies(){

        return new String[]{
                "Low Urgency",
                "Normal Urgency",
                "Hard Urgency"
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);
        spUrgency = findViewById(R.id.spUrgency);

        urgencies = getUrgencies();

        context = getApplicationContext();

        final List<String> urgenciesList = new ArrayList<>(Arrays.asList(urgencies));

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(context , R.layout.spinner_item , urgenciesList);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spUrgency.setAdapter(spinnerArrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                if (name.length() >= 3){
                    String urgency = spUrgency.getSelectedItem().toString();

                    todo = new Todo(name, urgency);

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("todo", todo);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    /* TODO Toast*/
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                setResult(RESULT_CANCELED, resultIntent);
                finish();
            }
        });

    }
}