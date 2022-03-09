package com.cc.returnjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/08 - 03 - 08 - 19:30
 * @Description: com.cc.returnjson
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnObject {
    private Integer code=200;
    private String message="ok";
    private Object result;

    public ReturnObject(String message, Object result) {
        this.message = message;
        this.result = result;
    }

    public ReturnObject(Object result) {
        this.result = result;
    }
}
