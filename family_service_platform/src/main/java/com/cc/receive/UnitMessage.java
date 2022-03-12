package com.cc.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/10 - 03 - 10 - 19:30
 * @Description: com.cc.receive
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnitMessage {
    private String buildingCode;
    private Integer unitCount;
}
