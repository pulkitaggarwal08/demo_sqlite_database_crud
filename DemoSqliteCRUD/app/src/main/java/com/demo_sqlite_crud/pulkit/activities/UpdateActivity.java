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

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etRollno;
    private EditText etName;
    private EditText etPhone;
    public Button btnUpdate;
    public Button btnCancel;
    private SQLController sqlController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        sqlController = new SQLController(this);

        etRollno = (EditText) findViewById(R.id.et_add_rollno);
        etName = (EditText) findViewById(R.id.et_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        btnUpdate.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_update) {
            try {
                sqlController.open();

                sqlController.updateStudent(Integer.parseInt(
                        etRollno.getText().toString())
                        , etName.getText().toString()
                        , etPhone.getText().toString());

                Toast.makeText(getApplicationContext(), "Update successfully", Toast.LENGTH_SHORT).show();

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
