package sg.edu.rp.c346.id22019575.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Movie> al;
    CustomAdapter customAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv = findViewById(R.id.lv);
        button = findViewById(R.id.button);

        Intent i = getIntent();
        al = (ArrayList<Movie>) i.getSerializableExtra("data");

        customAdapter = new CustomAdapter(this, R.layout.rows, al);
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = al.get(position);
                Intent i = new Intent(ListviewActivity.this, EditActivity.class);
                i.putExtra("data", (CharSequence) movie);
                startActivity(i);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoviesWithPG13Rating();
            }
        });
    }

    private void showMoviesWithPG13Rating() {
        ArrayList<Movie> pg13Movies = new ArrayList<>();

        for (Movie movie : al) {
            if ("PG13".equals(movie.getRate())) {
                pg13Movies.add(movie);
            }
        }

        customAdapter.clear();
        customAdapter.addAll(pg13Movies);
        customAdapter.notifyDataSetChanged();
    }
}
