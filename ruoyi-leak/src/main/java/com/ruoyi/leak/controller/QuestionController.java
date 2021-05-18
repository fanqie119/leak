package com.ruoyi.leak.controller;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.common.enums.DeletedStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.leak.vo.QuestionVo;
import com.ruoyi.leak.bo.QuestionQueryBo;
import com.ruoyi.leak.bo.QuestionAddBo;
import com.ruoyi.leak.bo.QuestionEditBo;
import com.ruoyi.leak.service.IQuestionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 问题信息Controller
 * 
 * @author fanqie
 * @date 2021-05-17
 */
@Api(value = "问题信息控制器", tags = {"问题信息管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/leak/question")
public class QuestionController extends BaseController {

    private final IQuestionService iQuestionService;

    /**
     * 查询问题信息列表
     */
    @ApiOperation("查询问题信息列表")
    @PreAuthorize("@ss.hasPermi('leak:question:list')")
    @GetMapping("/list")
    public TableDataInfo<QuestionVo> list(QuestionQueryBo bo) {
        bo.setDeleted(DeletedStatus.VALID.getCode());
        startPage();
        List<QuestionVo> list = iQuestionService.queryList(bo);
        return getDataTable(list);
    }

    /**
     * 导出问题信息列表
     */
    @ApiOperation("导出问题信息列表")
    @PreAuthorize("@ss.hasPermi('leak:question:export')")
    @Log(title = "问题信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<QuestionVo> export(QuestionQueryBo bo) {
        List<QuestionVo> list = iQuestionService.queryList(bo);
        ExcelUtil<QuestionVo> util = new ExcelUtil<QuestionVo>(QuestionVo.class);
        return util.exportExcel(list, "问题信息");
    }

    /**
     * 获取问题信息详细信息
     */
    @ApiOperation("获取问题信息详细信息")
    @PreAuthorize("@ss.hasPermi('leak:question:query')")
    @GetMapping("/{id}")
    public AjaxResult<QuestionVo> getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(iQuestionService.queryById(id));
    }

    /**
     * 新增问题信息
     */
    @ApiOperation("新增问题信息")
    @PreAuthorize("@ss.hasPermi('leak:question:add')")
    @Log(title = "问题信息", businessType = BusinessType.INSERT)
    @PostMapping()
    public AjaxResult<Void> add(@RequestBody QuestionAddBo bo) {
        return toAjax(iQuestionService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改问题信息
     */
    @ApiOperation("修改问题信息")
    @PreAuthorize("@ss.hasPermi('leak:question:edit')")
    @Log(title = "问题信息", businessType = BusinessType.UPDATE)
    @PutMapping()
    public AjaxResult<Void> edit(@RequestBody QuestionEditBo bo) {
        return toAjax(iQuestionService.updateByEditBo(bo) ? 1 : 0);
    }

//    /**
//     * 删除问题信息
//     */
//    @ApiOperation("删除问题信息")
//    @PreAuthorize("@ss.hasPermi('leak:question:remove')")
//    @Log(title = "问题信息" , businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
//    public AjaxResult<Void> remove(@PathVariable Long[] ids) {
//        return toAjax(iQuestionService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
//    }

    /**
     * 根据id删除问题信息
     */
    @ApiOperation("删除问题信息")
    @PreAuthorize("@ss.hasPermi('leak:question:remove:id')")
    @Log(title = "问题信息" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult<Void> removeById(@PathVariable Long id) {
        QuestionEditBo questionEditBo = new QuestionEditBo();
        questionEditBo.setId(id);
        questionEditBo.setDeleted(DeletedStatus.DELETED.getCode());
        return toAjax(iQuestionService.updateByEditBo(questionEditBo) ? 1 : 0);
    }
}
