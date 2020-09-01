package simpleweather.model;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import simpleweather.R;
import simpleweather.util.OpenWeatherSingleton;

public class WeatherRAdapter extends RecyclerView.Adapter<WeatherRAdapter.ListItemViewHolder> {

    ArrayList<WeatherModel> weatherModelArrayList;
    public WeatherRAdapter(ArrayList<WeatherModel> weatherModelArrayList){
        this.weatherModelArrayList = weatherModelArrayList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.weekly_weather_item, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        WeatherModel model = weatherModelArrayList.get(position);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        holder.ivWeather.setImageResource(OpenWeatherSingleton.getInstance()
                .getIconFromWeather(model.getWeather()));
        holder.textDate.setText(format.format(model.getDate()));
        holder.textTemp.setText(String.format("%.0f°C",
                Double.parseDouble(model.getTemp())));
    }

    @Override
    public int getItemCount() {
        return weatherModelArrayList.size();
    }

    public class ListItemViewHolder  extends RecyclerView.ViewHolder{
        @BindView(R.id.textDate)
        TextView textDate;

        @BindView(R.id.ivWeather)
        ImageView ivWeather;

        @BindView(R.id.textTemp)
        TextView textTemp;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
