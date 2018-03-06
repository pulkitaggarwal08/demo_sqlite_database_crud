package com.demo_sqlite_crud.pulkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.demo_sqlite_crud.pulkit.activities.AddActivity;
import com.demo_sqlite_crud.pulkit.activities.DeleteActivity;
import com.demo_sqlite_crud.pulkit.activities.ShowallActivity;
import com.demo_sqlite_crud.pulkit.activities.UpdateActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnAdd;
    public Button btnShowall;
    public Button btnUpdate;
    public Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnShowall = (Button) findViewById(R.id.btn_showall);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnDelete = (Button) findViewById(R.id.btn_delete);

        btnAdd.setOnClickListener(this);
        btnShowall.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_add) {
            Intent i = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.btn_showall) {
            Intent i = new Intent(getApplicationContext(), ShowallActivity.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.btn_update) {
            Intent i = new Intent(getApplicationContext(), UpdateActivity.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.btn_delete) {
            Intent i = new Intent(getApplicationContext(), DeleteActivity.class);
            startActivity(i);
        }

    }


}
