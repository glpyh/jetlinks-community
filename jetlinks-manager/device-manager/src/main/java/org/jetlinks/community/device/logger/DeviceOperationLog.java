package org.jetlinks.community.device.logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetlinks.community.device.enums.DeviceLogType;

import java.util.Date;
import java.util.Map;

/**
 * @author bsetfeng
 * @since 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceOperationLog {

    private String id;

    private String deviceId;

    private String productId;

    private DeviceLogType type;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Object content;

    private String orgId;

    public Map<String, Object> toSimpleMap() {

        Map<String, Object> result = (Map) JSON.toJSON(this);
        result.put("type", type.getValue());
        if (getContent() instanceof Map){
            result.put("content", JSON.toJSONString(getContent()));
        }else {
            result.put("content", getContent());
        }
        return result;
    }
}
