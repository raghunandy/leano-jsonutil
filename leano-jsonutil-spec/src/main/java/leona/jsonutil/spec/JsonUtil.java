package leona.jsonutil.spec;

/**
 *
 * A general Json Util specification interface.
 *
 * @author Raghunath Nandyala
 * @param <JsonArray> Generic JsonArray
 * @param <JsonObject> Generic JsonObject
 */
public abstract class JsonUtil<JsonArray, JsonObject> {

    public JsonArray toJsonArray(Object... dataArray) {
        return appendToJsonArray(newJsonArray(), dataArray);
    }
    
    public JsonObject toJsonObjet(Object... evenNumberedKeyValuePair) {
        return appendToJsonObject(newJsonObject(), evenNumberedKeyValuePair);
    }
    
    public abstract JsonObject mergeInto(JsonObject det, JsonObject in);

    public JsonArray appendToJsonArray(JsonArray destArray, Object... dataArray) {
        for (Object datai : dataArray) {

            addToJsonArray(destArray, datai);
        }
        return destArray;
    }

    public JsonObject appendToJsonObject(JsonObject destJsonObject, Object... evenNumberedKeyValuePair) {
        if(evenNumberedKeyValuePair.length%2!=0){
            throw new JsonUtilException("JsonObject Require Even Params:"+evenNumberedKeyValuePair.length);
        }
        for (int i = 0; i < evenNumberedKeyValuePair.length; i += 2) {
            String key = evenNumberedKeyValuePair[i].toString();
            Object obj = evenNumberedKeyValuePair[i + 1];
            addToJsonObject(destJsonObject, key, obj);
        }
        return destJsonObject;
    }

    

    public abstract JsonObject addToJsonObject(JsonObject jsonObject, String key, Object property);

    public abstract JsonArray addToJsonArray(JsonArray jsonArray, Object element);

    public abstract JsonArray newJsonArray();

    public abstract JsonObject newJsonObject();

    public abstract Object formAJsonTreeFromObject(Object javaBean);
    
    

    

}
