package com.demo_sqlite_crud.pulkit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demo_sqlite_crud.pulkit.MainActivity;
import com.demo_sqlite_crud.pulkit.R;
import com.demo_sqlite_crud.pulkit.db.SQLController;

import java.sql.SQLException;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAddRollno;
    private EditText etAddName;
    private EditText etAddPhone;
    public Button btnAddSave;
    public Button btnAddCancel;
    private SQLController sqlController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        sqlController = new SQLController(this);

        etAddRollno = (EditText) findViewById(R.id.et_add_rollno);
        etAddName = (EditText) findViewById(R.id.et_name);
        etAddPhone = (EditText) findViewById(R.id.et_phone);
        btnAddSave = (Button) findViewById(R.id.btn_save);
        btnAddCancel = (Button) findViewById(R.id.btn_cancel);

        btnAddSave.setOnClickListener(this);
        btnAddCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_save) {
            try {
                sqlController.open();

                sqlController.addStudent(Integer.parseInt(
                        etAddRollno.getText().toString())
                        , etAddName.getText().toString()
                        , etAddPhone.getText().toString());

                Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (view.getId() == R.id.btn_cancel) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

    }
}
