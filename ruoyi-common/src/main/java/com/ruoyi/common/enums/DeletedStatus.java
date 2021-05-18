package com.ruoyi.common.enums;

/**
 * 数据状态
 *
 * @author fanqie
 * @date 2021-05-17
 */
public enum DeletedStatus {
    /**
     * 正常
     */
    VALID(0, "正常"),
    /**
     * 删除
     */
    DELETED(1, "删除");

    private Integer code;
    private String description;

    DeletedStatus(Integer code, String description){
        this.code = code;
        this.description = description;
    }

    public Integer getCode(){
        return this.code;
    }
}
