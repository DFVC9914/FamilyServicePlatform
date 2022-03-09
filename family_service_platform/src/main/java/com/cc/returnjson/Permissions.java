package com.cc.returnjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/08 - 03 - 08 - 20:11
 * @Description: com.cc.returnjson
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permissions {
    private List<Permission> permissions;
}
