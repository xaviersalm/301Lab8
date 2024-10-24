package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *for the first phase it will be
     empty * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This checks if a given city is in the custom list
     *
     * @param city
     * @return Return true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city){
        // is the city in the list?

        for(City inCity : cities){
            if(inCity == city){
                return true;
            }
        }


        return false;
    }

    /**
     * Removes a city if its in the custom list, if the city was not in the list, throws an exception
     *
     * @param city
     * @throws IllegalArgumentException if the city is not in the custom list
     */
    public void deleteCity(City city){
        // deletes the city from the list
        if(hasCity(city) == true){
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException("This city is not in the city list!");
        }

    }

    /**
     * Counts the number of cities in a custom list
     *
     * @return Returns the number of cities in the list
     */
    public int countCities(){
        int i = 0;
        for(City city : cities){
            i++;
        }
        return i;
    }

}
