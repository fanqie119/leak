package com.ruoyi.leak.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 试卷分页查询对象 exam
 *
 * @author fanqie
 * @date 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("试卷分页查询对象")
public class ExamQueryBo extends BaseEntity {

	/** 分页大小 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/** 当前页数 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/** 排序列 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/** 排序的方向desc或者asc */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


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
	/** 数据状态 0 正常 1 删除 */
	@ApiModelProperty("数据状态 0 正常 1 删除")
	private Integer deleted;

}
