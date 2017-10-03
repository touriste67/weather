package com.touriste67.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vincent on 14/08/2017.
 */

public class WeatherData {

    public class Coord {
        public float lon;
        public float lat;
    }

    public Coord coord;

    public class Weather {
        public int id;
        public String rain;
        public String description;
        public String icon;
    }


    public Weather[] weather;

    public String base;

    public class Main {
        public float temp;
        public int pressure;
        public int humidity;
        public float temp_min;
        public float temp_max;
    }

    Main main;

    int visibility;

    public class Wind {
        float speed;
        int deg;
    }

    public class Rain {
        @SerializedName("3h")
        float _3h;
    }

    public Rain rain;

    public class Clouds {
        int all;
    }

    public Clouds clouds;

    public int dt;

    public class Sys {
        public int type;
        public int id;
        public float message;
        public String country;
        public int sunrise;
        public int sunset;
    }

    public Sys sys;

    public int id;

    public String name;

    public int cod;

//    {
//        "coord":{"lon":-0.13,"lat":51.51},
//        "weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],
//        "base":"stations",
//        "main":{"temp":291.96,"pressure":1014,"humidity":64,"temp_min":291.15,"temp_max":293.15},
//        "visibility":10000,"wind":{"speed":2.1,"deg":300},
//        "rain":{"3h":0.35},
//        "clouds":{"all":20},
//        "dt":1502790600,
//        "sys":{"type":1,"id":5091,"message":0.0044,"country":"GB","sunrise":1502772411,"sunset":1502824908},
//        "id":2643743,
//        "name":"London",
//        "cod":200
//    }

}
