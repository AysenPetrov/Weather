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

    private TextView humidityNow, overcastNow, selectedCity;
    private CheckBox humidity, overcast;
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
                String urlText = "https://wikipedia.org/wiki/" + selectedCity.getText().toString();
                Uri uri = Uri.parse(urlText);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        humidity = findViewById(R.id.humidity);
        overcast = findViewById(R.id.overcast);
        humidityNow = findViewById(R.id.humidityNow);
        humidityNow.setVisibility(View.INVISIBLE);
        overcastNow = findViewById(R.id.overcastNow);
        overcastNow.setVisibility(View.INVISIBLE);
        selectedCity = findViewById(R.id.selectedCity);
        aboutCity = findViewById(R.id.aboutCity);
    }

    private void showWeatherParameters() {
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