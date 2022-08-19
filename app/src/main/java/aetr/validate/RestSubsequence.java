package aetr.validate;

import aetr.Data.RestTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RestSubsequence {
    private List<Rest> restList;
    private RestTime part;

    public RestSubsequence(List<RestTime> list) {
        long prevD_t1 = 0;
        long prevW_t0 = 0;
        long prevW_t1 = 0;
        int kD = 0;
        restList = new ArrayList<>();
        for (RestTime restTime : list) {
            if(restTime.t1 - restTime.t0 < Time.DAY.val()){
                addDailyRest(restTime, prevD_t1);
                kD++;
                if(kD > 3){
                    throw new WeeklyRestException("Article 8 (5)", new RuntimeException());
                }
            }
            else{
                restList.add(new WeeklyRest(restTime.t0, restTime.t1, restTime.w0, restTime.w1, prevW_t0, prevW_t1));
                prevW_t0 = restTime.t0;
                prevW_t1 = restTime.t1;
                kD = 0;
            }
            prevD_t1 = restTime.t1;
        }
    }

    private void addDailyRest(RestTime restTime, long prev_t1){
        long t0 = restTime.t0;
        long t1 = restTime.t1;
        if (t1 - t0 >= Time.DAYpart.val() && t1 - t0 < Time.DAYreduced.val()) {
            if(part != null){
                throw new DailyRestException("Article 1 (o) i", new RuntimeException());
            }
            part = restTime;
        }
        else if (t1 - t0 >= Time.DAYreduced.val() && t1 - t0 < Time.DAY.val()) {
            {
                long dt = 0;
                if (part != null) {
                    dt = t0 - part.t1;
                    t0 = part.t0;
                    part = null;
                }
                restList.add(new DailyRest(t0, t1, dt, prev_t1));
            }
        }
    }

    public void validate() {
        for(Rest rest: restList){
            rest.validate();
        }
    }
}
