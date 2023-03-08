package com.example.basictemplate.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@ToString
public class Result {
    private Boolean success;//响应是否成功

    private Integer code;//响应码

    private String message;//返回消息

    public Result(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
