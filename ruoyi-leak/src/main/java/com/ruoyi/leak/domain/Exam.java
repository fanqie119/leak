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
 * 试卷对象 exam
 * 
 * @author fanqie
 * @date 2021-05-17
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("exam")
public class Exam implements Serializable {

private static final long serialVersionUID=1L;


    /** 试卷id */
    @TableId(value = "exam_id")
    private Long examId;

    /** 试卷名称 */
    private String examName;

    /** 试卷类型：0 英语 1 C语言 */
    private Long type;

    /** 模板文件路径 */
    private String route;

    /** 排序字段 */
    private Long sort;

    /** 备注字段 */
    private String remark;

    /** 数据状态 0 正常 1 删除 */
    private Integer deleted;

}
