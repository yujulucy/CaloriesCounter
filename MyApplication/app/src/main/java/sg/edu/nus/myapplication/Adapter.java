package sg.edu.nus.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UX305 on 2016/6/6.
 */
public class Adapter extends ArrayAdapter<Data> {
    private Activity activity;
    int id;
    ArrayList<Data> data;

    public Adapter(Activity context, int resource, ArrayList<Data> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.id = resource;
        this.data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(id, null);
        }

        Data food = data.get(position);
        TextView id = convertView.findViewById(R.id.tvId);
        TextView name = convertView.findViewById(R.id.tvName);
        TextView calories = convertView.findViewById(R.id.tvCalories);
        TextView protein = convertView.findViewById(R.id.tvProtein);
        TextView fat = convertView.findViewById(R.id.tvFat);
        TextView carbo = convertView.findViewById(R.id.tvCarbo);
        TextView sodium = convertView.findViewById(R.id.tvSod);

        tvId.setText(data.getId());
        tvName.setText(data.getName());
        tvCalories.setText(data.getCalories());
        tvProtein.setText(data.getProtein());
        tvFat.setText(data.getFat());
        tvCarbo.setText(data.getCarbo());
        tvSod.setText(data.getSod());
        return convertView;
    }
}
