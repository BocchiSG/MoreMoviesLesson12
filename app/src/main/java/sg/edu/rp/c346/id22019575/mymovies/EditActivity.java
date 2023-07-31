package sg.edu.rp.c346.id22019575.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    Button btnUpdate, btnDelete;
    Spinner spinner;
    EditText etYear, etSingers, etTitle;
    Movie data;
    TextView tvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnUpdate = findViewById(R.id.update);
        btnDelete = findViewById(R.id.delete);
        spinner = findViewById(R.id.spinner);
        etSingers = findViewById(R.id.singers);
        etTitle = findViewById(R.id.title2);
        etYear = findViewById(R.id.year);
        tvId = findViewById(R.id.id);

        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("data");

        etTitle.setText(data.getTitle());
        etSingers.setText(data.getGenre());
        etYear.setText(data.getYear());
        tvId.setText(data.get_id());
        for (int y = 0; y < spinner.getChildCount(); y++) {
            View view = spinner.getChildAt(y);
            if (view instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) view;
                int radioButtonStars = Integer.parseInt(radioButton.getText().toString());
                if (data.getRate() == radioButtonStars) {
                    radioButton.setChecked(true);
                    break; // Once the matching radio button is found and selected, exit the loop
                }
            }
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setTitle(etTitle.getText().toString());
                data.set_id(Integer.parseInt(tvId.getText().toString()));
                data.setGenre(etSingers.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.get_id());

                finish();
            }
        });
    }
}
