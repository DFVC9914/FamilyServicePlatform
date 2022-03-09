package com.cc.returnjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/08 - 03 - 08 - 20:12
 * @Description: com.cc.returnjson
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserInfo {
    private String name;
    private String avatar="/avatar2.jpg";
    private Permissions role;

}
