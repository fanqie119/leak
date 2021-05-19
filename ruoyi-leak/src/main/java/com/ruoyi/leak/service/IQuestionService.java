package com.ruoyi.leak.service;

import com.ruoyi.leak.domain.Question;
import com.ruoyi.leak.vo.QuestionVo;
import com.ruoyi.leak.bo.QuestionQueryBo;
import com.ruoyi.leak.bo.QuestionAddBo;
import com.ruoyi.leak.bo.QuestionEditBo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * 问题信息Service接口
 *
 * @author fanqie
 * @date 2021-05-17
 */
public interface IQuestionService extends IService<Question> {
	/**
	 * 查询单个
	 * @return
	 */
	QuestionVo queryById(Long id);

	/**
	 * 查询列表
	 */
	List<QuestionVo> queryList(QuestionQueryBo bo);

	/**
	 * 根据新增业务对象插入问题信息
	 * @param bo 问题信息新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(QuestionAddBo bo);

	/**
	 * 根据编辑业务对象修改问题信息
	 * @param bo 问题信息编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(QuestionEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);


	/**
	 * 根据ids列表查询问题信息
	 * @param ids
	 * @return
	 */
    List<Question> selectByIds(Long[] ids);
}
