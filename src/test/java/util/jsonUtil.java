package util;

import org.json.JSONArray;
import org.json.JSONObject;

public class jsonUtil {
    public static JSONObject getJSONObjectFromJSONArray(JSONArray jsonArray, String jsonFldName, String jsonFldValue){
        for(Object obj : jsonArray){
            JSONObject jsonObject = (JSONObject) obj;
            if (jsonObject.getString(jsonFldName).trim().equalsIgnoreCase(jsonFldValue))
                return jsonObject;
        }
        return null;
    }
}
