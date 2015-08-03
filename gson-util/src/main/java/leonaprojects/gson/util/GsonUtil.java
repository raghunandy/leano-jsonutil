package leonaprojects.gson.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Map;
import leonaprojects.jsonutil.spec.JsonUtil;
import leonaprojects.jsonutil.spec.JsonUtilException;

/**
 *
 * @author Raghunath Nandyala
 */
public class GsonUtil extends JsonUtil<JsonArray, JsonObject> {

    private static GsonUtil i;

    public static GsonUtil instance() {
        if (i == null) {
            i = new GsonUtil();
        }
        return i;
    }
    private static final Gson gson = new Gson();

    private GsonUtil() {
    }

    
    @Override
    public JsonObject addToJsonObject(JsonObject jsonObject, String key, Object property) {
        JsonPrimitive prim = constructPrimitive(property);

        if (prim != null) {
            jsonObject.add(key, prim);
        } else {
            addToJsonObjectAsJsonTree(jsonObject, property);
        }

        return jsonObject;
    }

    @Override
    public JsonArray addToJsonArray(JsonArray jsonArray, Object element) {
        JsonPrimitive prim = constructPrimitive(element);
        if (prim != null) {
            jsonArray.add(prim);
        } else {
            addToJsonArrayAsJsonTree(jsonArray, element);
        }
        return jsonArray;
    }

    public JsonPrimitive constructPrimitive(Object object) {
        JsonPrimitive prim = null;
        if (object instanceof String) {
            prim = new JsonPrimitive((String) object);
        } else if (object instanceof Number) {
            prim = new JsonPrimitive((Number) object);
        } else if (object instanceof Character) {
            prim = new JsonPrimitive((Character) object);
        } else if (object instanceof Boolean) {
            prim = new JsonPrimitive((Character) object);
        }
        return prim;
    }

    public JsonElement get(Object obj){
        return gson.toJsonTree(obj);
    }
    @Override
    public JsonArray newJsonArray() {
        return new JsonArray();
    }

    @Override
    public JsonObject newJsonObject() {
        return new JsonObject();
    }

}
