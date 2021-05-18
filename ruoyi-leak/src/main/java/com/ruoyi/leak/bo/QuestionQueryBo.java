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
 * 问题信息分页查询对象 question
 *
 * @author fanqie
 * @date 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("问题信息分页查询对象")
public class QuestionQueryBo extends BaseEntity {

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


	/** 试卷id */
	@ApiModelProperty("试卷id")
	private Long examId;
	/** 试卷名称 */
	@ApiModelProperty("试卷名称")
	private String examName;
	/** 一级题号 */
	@ApiModelProperty("一级题号")
	private Long number1;
	/** 二级题号 */
	@ApiModelProperty("二级题号")
	private Long number2;
	/** 问题类型：0 单选 1 填空 2 判断 3 问答  */
	@ApiModelProperty("问题类型：0 单选 1 填空 2 判断 3 问答 ")
	private Long type;
	/** 问题描述 */
	@ApiModelProperty("问题描述")
	private String description;
	/** 参考答案 */
	@ApiModelProperty("参考答案")
	private String answer;
	/** 分值 */
	@ApiModelProperty("分值")
	private Long value;
	/** 分类id */
	@ApiModelProperty("分类id")
	private Long categoryId;
	/** 分类名称 */
	@ApiModelProperty("分类名称")
	private String categoryName;
	/** 标签id */
	@ApiModelProperty("标签id")
	private Long labelId;
	/** 标签名称 */
	@ApiModelProperty("标签名称")
	private String labelName;
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
