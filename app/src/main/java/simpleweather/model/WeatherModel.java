package simpleweather.model;

import java.util.Date;

public class WeatherModel {
    String mWeather;
    String mTemp;
    Date mDate;

    public WeatherModel(String weather, String temp, Date date) {
        mWeather = weather;
        mTemp=temp;
        mDate = date;
    }

    String getWeather(){
        return mWeather;
    }
    String getTemp(){
        return mTemp;
    }
    Date getDate(){
        return mDate;
    }
}
