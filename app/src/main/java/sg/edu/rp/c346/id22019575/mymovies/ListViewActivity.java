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
    Movie data;
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
        data = (Movie) i.getSerializableExtra("data");

        al = new ArrayList<Movie>();
        //aa = new ArrayAdapter<Song>(this,
        //       android.R.layout.simple_list_item_1, al);
        //lv.setAdapter(aa);
        customAdapter = new CustomAdapter(this, R.layout.rows, al);
        lv.setAdapter(customAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = al.get(position);
                Intent i = new Intent(ListviewActivity.this,
                        EditActivity.class);
                i.putExtra("data", (CharSequence) song);
                startActivity(i);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show only songs with 5 stars
                showSongsWithFiveStars();
            }
        });

    }

    private void showSongsWithFiveStars() {
        al.clear();
        for (Movie movie : al) {
            if (movie.getRate() == "PG13") {
                al.add(movie);
            }
        }
        customAdapter.notifyDataSetChanged();
    }

}
