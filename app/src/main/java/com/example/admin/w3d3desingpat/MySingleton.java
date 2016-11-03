package com.example.admin.w3d3desingpat;

import java.util.Date;

/**
 * Created by admin on 11/2/2016.
 */

public class MySingleton {
    private Date date;

    private MySingleton() {
        date = new Date();
    }

    private static class MySingletonHolder {
        public static final MySingleton instance = new MySingleton();
    }

    public static MySingleton getIntance(){
        return MySingletonHolder.instance;
    }

    public Date getDate() {
        return date;
    }
}
