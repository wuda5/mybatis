package com.demo.biz.entity.base;

import java.io.Serializable;
import lombok.Data;

@Data
public class Role implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

    private static final long serialVersionUID = 1L;
}