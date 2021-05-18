package com.ruoyi.leak.vo;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 问题信息视图对象 mall_package
 *
 * @author fanqie
 * @date 2021-05-17
 */
@Data
@ApiModel("问题信息视图对象")
public class QuestionVo {
	private static final long serialVersionUID = 1L;

	/** 主键自增id */
	@ApiModelProperty("主键自增id")
	private Long id;

	/** 试卷id */
	@Excel(name = "试卷id")
	@ApiModelProperty("试卷id")
	private Long examId;
	/** 试卷名称 */
	@Excel(name = "试卷名称")
	@ApiModelProperty("试卷名称")
	private String examName;
	/** 一级题号 */
	@Excel(name = "一级题号")
	@ApiModelProperty("一级题号")
	private Long number1;
	/** 二级题号 */
	@Excel(name = "二级题号")
	@ApiModelProperty("二级题号")
	private Long number2;
	/** 问题类型：0 单选 1 填空 2 判断 3 问答  */
	@Excel(name = "问题类型：0 单选 1 填空 2 判断 3 问答 ")
	@ApiModelProperty("问题类型：0 单选 1 填空 2 判断 3 问答 ")
	private Long type;
	/** 问题描述 */
	@Excel(name = "问题描述")
	@ApiModelProperty("问题描述")
	private String description;
	/** 参考答案 */
	@Excel(name = "参考答案")
	@ApiModelProperty("参考答案")
	private String answer;
	/** 分值 */
	@Excel(name = "分值")
	@ApiModelProperty("分值")
	private Long value;
	/** 分类id */
	@Excel(name = "分类id")
	@ApiModelProperty("分类id")
	private Long categoryId;
	/** 分类名称 */
	@Excel(name = "分类名称")
	@ApiModelProperty("分类名称")
	private String categoryName;
	/** 标签id */
	@Excel(name = "标签id")
	@ApiModelProperty("标签id")
	private Long labelId;
	/** 标签名称 */
	@Excel(name = "标签名称")
	@ApiModelProperty("标签名称")
	private String labelName;
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
