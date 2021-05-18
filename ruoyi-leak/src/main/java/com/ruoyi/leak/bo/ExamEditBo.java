package com.ruoyi.leak.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;


/**
 * 试卷编辑对象 exam
 *
 * @author fanqie
 * @date 2021-05-17
 */
@Data
@ApiModel("试卷编辑对象")
public class ExamEditBo {


    /** 试卷id */
    @ApiModelProperty("试卷id")
    private Long examId;

    /** 试卷名称 */
    @ApiModelProperty("试卷名称")
    private String examName;

    /** 试卷类型：0 英语 1 C语言 */
    @ApiModelProperty("试卷类型：0 英语 1 C语言")
    private Long type;

    /** 模板文件路径 */
    @ApiModelProperty("模板文件路径")
    private String route;

    /** 排序字段 */
    @ApiModelProperty("排序字段")
    private Long sort;

    /** 备注字段 */
    @ApiModelProperty("备注字段")
    private String remark;

    /** 数据状态 0 正常 1 删除 */
    @ApiModelProperty("数据状态 0 正常 1 删除")
    private Integer deleted;
}
