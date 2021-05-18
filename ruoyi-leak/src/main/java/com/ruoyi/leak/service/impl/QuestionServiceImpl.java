package com.ruoyi.leak.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.enums.DeletedStatus;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.ruoyi.leak.bo.QuestionAddBo;
import com.ruoyi.leak.bo.QuestionQueryBo;
import com.ruoyi.leak.bo.QuestionEditBo;
import com.ruoyi.leak.domain.Question;
import com.ruoyi.leak.mapper.QuestionMapper;
import com.ruoyi.leak.vo.QuestionVo;
import com.ruoyi.leak.service.IQuestionService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 问题信息Service业务层处理
 *
 * @author fanqie
 * @date 2021-05-17
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Override
    public QuestionVo queryById(Long id){
        LambdaQueryWrapper<Question> lqw = Wrappers.lambdaQuery();
        lqw.eq(id != null, Question::getId, id);
        lqw.eq(true, Question::getDeleted, DeletedStatus.VALID.getCode());
        Question question = null;
        List<Question> list = this.list(lqw);
        if (list.size()>0){
            question = list.get(0);
        }
        return BeanUtil.toBean(question, QuestionVo.class);
    }

    @Override
    public List<QuestionVo> queryList(QuestionQueryBo bo) {
        LambdaQueryWrapper<Question> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getExamId() != null, Question::getExamId, bo.getExamId());
        lqw.like(StrUtil.isNotBlank(bo.getExamName()), Question::getExamName, bo.getExamName());
        lqw.eq(bo.getNumber1() != null, Question::getNumber1, bo.getNumber1());
        lqw.eq(bo.getNumber2() != null, Question::getNumber2, bo.getNumber2());
        lqw.eq(bo.getType() != null, Question::getType, bo.getType());
        lqw.eq(StrUtil.isNotBlank(bo.getDescription()), Question::getDescription, bo.getDescription());
        lqw.eq(StrUtil.isNotBlank(bo.getAnswer()), Question::getAnswer, bo.getAnswer());
        lqw.eq(bo.getValue() != null, Question::getValue, bo.getValue());
        lqw.eq(bo.getCategoryId() != null, Question::getCategoryId, bo.getCategoryId());
        lqw.like(StrUtil.isNotBlank(bo.getCategoryName()), Question::getCategoryName, bo.getCategoryName());
        lqw.eq(bo.getLabelId() != null, Question::getLabelId, bo.getLabelId());
        lqw.like(StrUtil.isNotBlank(bo.getLabelName()), Question::getLabelName, bo.getLabelName());
        lqw.eq(StrUtil.isNotBlank(bo.getRoute()), Question::getRoute, bo.getRoute());
        lqw.eq(bo.getSort() != null, Question::getSort, bo.getSort());
        lqw.eq(bo.getDeleted() != null, Question::getDeleted, bo.getDeleted());
        return entity2Vo(this.list(lqw));
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<QuestionVo> entity2Vo(Collection<Question> collection) {
        List<QuestionVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, QuestionVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<Question> page = (Page<Question>)collection;
            Page<QuestionVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(QuestionAddBo bo) {
        Question add = BeanUtil.toBean(bo, Question.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(QuestionEditBo bo) {
        Question update = BeanUtil.toBean(bo, Question.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(Question entity){
        //TODO 做一些数据校验,如唯一约束
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return this.removeByIds(ids);
    }
}
