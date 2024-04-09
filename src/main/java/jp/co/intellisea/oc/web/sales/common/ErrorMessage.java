package jp.co.intellisea.oc.web.sales.common;
import com.alibaba.fastjson.JSONObject;
public class ErrorMessage {
    private final JSONObject jsonObject = new JSONObject();

    public ErrorMessage(String message) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}