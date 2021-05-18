package com.ruoyi.leak.service;

import com.ruoyi.leak.domain.Exam;
import com.ruoyi.leak.vo.ExamVo;
import com.ruoyi.leak.bo.ExamQueryBo;
import com.ruoyi.leak.bo.ExamAddBo;
import com.ruoyi.leak.bo.ExamEditBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * 试卷Service接口
 *
 * @author fanqie
 * @date 2021-05-17
 */
public interface IExamService extends IService<Exam> {
	/**
	 * 查询单个
	 * @return
	 */
	ExamVo queryById(Long examId);

	/**
	 * 查询列表
	 */
	List<ExamVo> queryList(ExamQueryBo bo);

	/**
	 * 根据新增业务对象插入试卷
	 * @param bo 试卷新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(ExamAddBo bo);

	/**
	 * 根据编辑业务对象修改试卷
	 * @param bo 试卷编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(ExamEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
