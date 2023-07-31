package sg.edu.rp.c346.id22019575.mymovies;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> songList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textView3);

        TextView tvSingers = rowView.findViewById(R.id.textView2);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);

        // Obtain the Android Version information based on the position
        Movie current = songList.get(position);

        // Set values to the TextView to display the corresponding information

        tvTitle.setText(current.getTitle());
        tvYear.setText(current.getYear());
        tvSingers.setText(current.getGenre());

        int red = Color.rgb(255, 0, 0);
        int pink = Color.rgb(255,192,203);
        int cyan = Color.rgb(0,255,255);
        int yellow = Color.rgb(255,255,0);
        tvTitle.setTextColor(pink);
        tvYear.setTextColor(cyan);
        if (current.getRate() == 'PG13') {
            ivGender.setImageResource(R.drawable.img);
        } else if (current.getRate() == 'G') {
            ivGender.setImageResource(R.drawable.img_1);
        }else if (current.getRate() == 'PG') {
            ivGender.setImageResource(R.drawable.img_2);
        }else if (current.getRate() == 'NC16') {
            ivGender.setImageResource(R.drawable.img_3);
        }else if (current.getRate() == 'M18') {
            ivGender.setImageResource(R.drawable.img_4);
        }else if (current.getRate() == 'R21') {
            ivGender.setImageResource(R.drawable.img_5);
        }
        tvSingers.setTextColor(red);

        return rowView;
    }

}
