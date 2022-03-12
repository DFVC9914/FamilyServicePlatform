package com.cc.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/11 - 03 - 11 - 19:08
 * @Description: com.cc.receive
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CellMessage {
    private String unitCode;
    private Integer startFloor;
    private Integer stopFloor;
    private Integer startCellId;
    private Integer stopCellId;

}
