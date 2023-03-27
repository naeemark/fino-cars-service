package com.naeemark.fcs.utils;

import com.naeemark.fcs.models.Car;

public class TestUtil {

    public static Car getCar() {
        return new Car(
                164,
                "Lincoln",
                "2011 Lincoln MKX",
                2011,
                "Lincoln 3.7L 6 Cylinder 305 hp 280 ft-lbs",
                "Car",
                "Gasoline",
                "Front-wheel drive",
                "Automatic transmission",
                6,
                "6 Speed Automatic Select Shift",
                305,
                19,
                26,
                138,
                173,
                134,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Blue_Audi_RS6_C5_sedan_fl.jpg/400px-Blue_Audi_RS6_C5_sedan_fl.jpg"
        );
    }
}
