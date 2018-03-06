package com.demo_sqlite_crud.pulkit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.demo_sqlite_crud.pulkit.R;
import com.demo_sqlite_crud.pulkit.adapter.CustomAdapter;
import com.demo_sqlite_crud.pulkit.db.SQLController;
import com.demo_sqlite_crud.pulkit.models.Student;
import java.sql.SQLException;
import java.util.List;

public class ShowallActivity extends AppCompatActivity {

    public SQLController sqlController;
    public ListView listView;
    public List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);

        sqlController = new SQLController(this);

        listView = (ListView) findViewById(R.id.listview);

        try {
            sqlController.open();

            list = sqlController.getAllStudents();

            CustomAdapter adapter = new CustomAdapter(this, list);
            listView.setAdapter(adapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
