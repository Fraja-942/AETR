package aetr.Data;

import org.json.simple.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RestTime {
    public long t0, t1;
    public  long w0, w1;
    public RestTime(JSONObject obj0, JSONObject obj1) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd MM yyyy HH:mm");
        Calendar c0 = Calendar.getInstance();
        c0.setTime(df.parse((String)obj0.get("t1")));
        t0 = c0.getTimeInMillis();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(df.parse((String)obj1.get("t0")));
        t1 = c1.getTimeInMillis();
        c0.set(Calendar.HOUR_OF_DAY, 0);
        c0.set(Calendar.MINUTE, 0);
        c0.set(Calendar.SECOND, 0);
        int d = c0.get(Calendar.DAY_OF_WEEK);
        c0.roll(Calendar.DAY_OF_WEEK, 2 - d);
        w0 = c0.getTimeInMillis();
        c0.roll(Calendar.DAY_OF_WEEK, 7);
        w1 = c0.getTimeInMillis();
    }
}
