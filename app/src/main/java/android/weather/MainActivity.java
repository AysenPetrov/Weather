package android.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    final static String KEY_TO_CITY = "KEY_TO_CITY";
    private final int ACTIVITY_FOR_RESULT_KEY = 1234;
    Button showWeather;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnSpinner();
        setOnShowWeatherButton();
    }

    void setOnSpinner() {
        spinner = findViewById(R.id.spinner);
        final ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.moscow);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.spetersburg);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.yakutsk);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    private void setOnShowWeatherButton() {
        showWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parcel parcel = new Parcel();
                parcel.text = spinner.getSelectedItem().toString();
                Intent intent = new Intent(MainActivity.this, ShowWeatherActivity.class);
                intent.putExtra(KEY_TO_CITY, parcel);
                startActivityForResult(intent, ACTIVITY_FOR_RESULT_KEY);
            }
        });
    }

    private void initViews() {
        showWeather = findViewById(R.id.showWeather);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}