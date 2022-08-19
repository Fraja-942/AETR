package aetr.Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RestTimeList {
    public List<RestTime> getRestTimeList(JSONArray json) throws ParseException {
        List<RestTime> list = new ArrayList<>();
        JSONObject obj0 = (JSONObject) json.get(0);
        for(int i = 1; i < json.size(); i++){
            JSONObject obj1 = (JSONObject) json.get(i);
            RestTime rest = new RestTime(obj0, obj1);
            list.add(rest);
            obj0 = obj1;
        }
        return list;
    }
}
