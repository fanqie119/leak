package com.ruoyi.leak.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;

/**
 * 问题信息对象 question
 * 
 * @author fanqie
 * @date 2021-05-17
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("question")
public class Question implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键自增id */
    @TableId(value = "id")
    private Long id;

    /** 试卷id */
    private Long examId;

    /** 试卷名称 */
    private String examName;

    /** 一级题号 */
    private Long number1;

    /** 二级题号 */
    private Long number2;

    /** 问题类型：0 单选 1 填空 2 判断 3 问答  */
    private Long type;

    /** 问题描述 */
    private String description;

    /** 参考答案 */
    private String answer;

    /** 分值 */
    private Long value;

    /** 分类id */
    private Long categoryId;

    /** 分类名称 */
    private String categoryName;

    /** 标签id */
    private Long labelId;

    /** 标签名称 */
    private String labelName;

    /** 模板文件路径 */
    private String route;

    /** 排序字段 */
    private Long sort;

    /** 备注字段 */
    private String remark;

    /** 数据状态 0 正常 1 删除 */
    private Integer deleted;

}
