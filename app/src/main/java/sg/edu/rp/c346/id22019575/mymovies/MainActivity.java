package sg.edu.rp.c346.id22019575.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShowList;
    EditText etTitle, etGenre, etYear;
    Spinner rate;
    ArrayList<Movie> al;
    ArrayAdapter<Movie> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.insert);
        btnShowList = findViewById(R.id.showList);
        etGenre = findViewById(R.id.textInputGenre);
        etTitle = findViewById(R.id.textInputTitle);
        etYear = findViewById(R.id.year);
        rate = findViewById(R.id.spinner);

        String[] spinnerItems = {"G", "PG", "PG13", "NC16", "M18", "R21"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rate.setAdapter(adapter);
        rate.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        al = new ArrayList<Movie>();
        aa = new ArrayAdapter<Movie>(this,
                android.R.layout.simple_list_item_1, al);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                String task = etTitle.getText().toString();
                int date = Integer.parseInt(etYear.getText().toString());
                String singers = etGenre.getText().toString();
                int rating = Integer.parseInt(rate.toString());

                db.insertTask(task, date, singers, rating);
                db.close();



            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie target = al.get(0);

                Intent i = new Intent(MainActivity.this,
                        ListviewActivity.class);
                i.putExtra("data", (CharSequence) target);
                startActivity(i);

            }
        });


    }
}