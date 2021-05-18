package com.ruoyi.leak.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.ruoyi.leak.bo.ExamAddBo;
import com.ruoyi.leak.bo.ExamQueryBo;
import com.ruoyi.leak.bo.ExamEditBo;
import com.ruoyi.leak.domain.Exam;
import com.ruoyi.leak.mapper.ExamMapper;
import com.ruoyi.leak.vo.ExamVo;
import com.ruoyi.leak.service.IExamService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 试卷Service业务层处理
 *
 * @author fanqie
 * @date 2021-05-17
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {

    @Override
    public ExamVo queryById(Long examId){
        Exam db = this.baseMapper.selectById(examId);
        return BeanUtil.toBean(db, ExamVo.class);
    }

    @Override
    public List<ExamVo> queryList(ExamQueryBo bo) {
        LambdaQueryWrapper<Exam> lqw = Wrappers.lambdaQuery();
        lqw.like(StrUtil.isNotBlank(bo.getExamName()), Exam::getExamName, bo.getExamName());
        lqw.eq(bo.getType() != null, Exam::getType, bo.getType());
        lqw.eq(StrUtil.isNotBlank(bo.getRoute()), Exam::getRoute, bo.getRoute());
        lqw.eq(bo.getSort() != null, Exam::getSort, bo.getSort());
        lqw.eq(bo.getDeleted() != null, Exam::getDeleted, bo.getDeleted());
        return entity2Vo(this.list(lqw));
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<ExamVo> entity2Vo(Collection<Exam> collection) {
        List<ExamVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, ExamVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<Exam> page = (Page<Exam>)collection;
            Page<ExamVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(ExamAddBo bo) {
        Exam add = BeanUtil.toBean(bo, Exam.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(ExamEditBo bo) {
        Exam update = BeanUtil.toBean(bo, Exam.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(Exam entity){
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
