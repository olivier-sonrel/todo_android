package com.olivier.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddTodoActivity extends AppCompatActivity {

    EditText etName = null;
    Button btnAdd = null;
    Button btnCancel = null;
    Spinner spUrgency = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);
        spUrgency = findViewById(R.id.spUrgency);

    }
}