package android.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.Objects;

public class ShowWeatherActivity extends AppCompatActivity {

    private TextView pressureNow, windNow,humidityNow, overcastNow, selectedCity;
    private CheckBox pressure, wind, humidity, overcast;
    private Button aboutCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weather);
        initViews();
        showWeatherParameters();
        getDataFromFirstActivity();
        setOnOpenBrowserBtnClickBehaviour();
    }

    private void setOnOpenBrowserBtnClickBehaviour() {
        aboutCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlText = "https://ru.wikipedia.org/wiki/" + selectedCity.getText().toString();
                Uri uri = Uri.parse(urlText);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        pressure = findViewById(R.id.pressure);
        wind = findViewById(R.id.wind);
        humidity = findViewById(R.id.humidity);
        overcast = findViewById(R.id.overcast);
        pressureNow = findViewById(R.id.pressureNow);
        pressureNow.setVisibility(View.INVISIBLE);
        windNow = findViewById(R.id.windNow);
        windNow.setVisibility(View.INVISIBLE);
        humidityNow = findViewById(R.id.humidityNow);
        humidityNow.setVisibility(View.INVISIBLE);
        overcastNow = findViewById(R.id.overcastNow);
        overcastNow.setVisibility(View.INVISIBLE);
        selectedCity = findViewById(R.id.selectedCity);
        aboutCity = findViewById(R.id.aboutCity);
    }

    private void showWeatherParameters() {

        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pressure.isChecked()) {
                    pressureNow.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Show pressure", Toast.LENGTH_SHORT).show();
                } else {
                    pressureNow.setVisibility(View.INVISIBLE);
                }
            }
        });
        wind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wind.isChecked()) {
                    windNow.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Show wind", Toast.LENGTH_SHORT).show();
                } else {
                   windNow.setVisibility(View.INVISIBLE);
                }
            }
        });
        humidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(humidity.isChecked()) {
                    humidityNow.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Show humidity", Toast.LENGTH_SHORT).show();
                } else {
                    humidityNow.setVisibility(View.INVISIBLE);
                }
            }
        });
        overcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(overcast.isChecked()) {
                    overcastNow.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Show overcast", Toast.LENGTH_SHORT).show();
                } else {
                    overcastNow.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void getDataFromFirstActivity() {
        Serializable serializable = getIntent().getSerializableExtra(MainActivity.KEY_TO_CITY);
        if(serializable != null) {
            Parcel parcel = (Parcel)serializable;
            String text = Objects.requireNonNull(parcel).text;
            selectedCity.setText(text);
        }
    }
}
