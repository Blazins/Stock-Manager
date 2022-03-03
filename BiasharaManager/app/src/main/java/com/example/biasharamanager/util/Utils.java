package com.example.biasharamanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String formatDate(Date date){
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        simpleDateFormat.applyPattern("EEE, MMM, d");

        return simpleDateFormat.format(date);

    }
    /*
    Fragment - reusable portion of a user interface
    Hosted by another fragment/activity
    Flexibility
     */

}
