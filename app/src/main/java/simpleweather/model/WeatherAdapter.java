package simpleweather.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import simpleweather.R;

public class WeatherAdapter extends ArrayAdapter<WeatherModel> {
    public WeatherAdapter(Context context, List<WeatherModel> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WeatherModel weather = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.weekly_weather_item, parent, false);
        }
        return convertView;
    }
}
