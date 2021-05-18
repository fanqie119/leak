package com.ruoyi.leak.vo;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 试卷视图对象 mall_package
 *
 * @author fanqie
 * @date 2021-05-17
 */
@Data
@ApiModel("试卷视图对象")
public class ExamVo {
	private static final long serialVersionUID = 1L;

	/** 试卷id */
	@ApiModelProperty("试卷id")
	private Long examId;

	/** 试卷名称 */
	@Excel(name = "试卷名称")
	@ApiModelProperty("试卷名称")
	private String examName;
	/** 试卷类型：0 英语 1 C语言 */
	@Excel(name = "试卷类型：0 英语 1 C语言")
	@ApiModelProperty("试卷类型：0 英语 1 C语言")
	private Long type;
	/** 模板文件路径 */
	@Excel(name = "模板文件路径")
	@ApiModelProperty("模板文件路径")
	private String route;
	/** 排序字段 */
	@Excel(name = "排序字段")
	@ApiModelProperty("排序字段")
	private Long sort;
	/** 备注字段 */
	@Excel(name = "备注字段")
	@ApiModelProperty("备注字段")
	private String remark;
	/** 数据状态 0 正常 1 删除 */
	@Excel(name = "数据状态 0 正常 1 删除")
	@ApiModelProperty("数据状态 0 正常 1 删除")
	private Integer deleted;

}
