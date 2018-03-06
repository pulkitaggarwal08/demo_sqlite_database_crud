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

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {

    private SQLController sqlController;
    private EditText et_rollno;
    public Button btn_delete, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        sqlController = new SQLController(this);

        et_rollno = (EditText) findViewById(R.id.et_rollno);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        btn_delete.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_delete) {
            try {
                sqlController.open();

                sqlController.deleteStudent(Integer.parseInt(et_rollno.getText().toString()));

                Toast.makeText(getApplicationContext(), "Delete successfully", Toast.LENGTH_SHORT).show();

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
