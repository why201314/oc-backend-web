package jp.co.intellisea.oc.web.sales.common;
import com.alibaba.fastjson.JSONObject;

public class WarningMessage {
    private final JSONObject jsonObject = new JSONObject();

    public WarningMessage(String message) {
        jsonObject.put("code", 500);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "warning");
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}

