package com.ruoyi.leak.controller;

import java.util.List;
import java.util.Arrays;

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
import com.ruoyi.leak.vo.ExamVo;
import com.ruoyi.leak.bo.ExamQueryBo;
import com.ruoyi.leak.bo.ExamAddBo;
import com.ruoyi.leak.bo.ExamEditBo;
import com.ruoyi.leak.service.IExamService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 试卷Controller
 * 
 * @author fanqie
 * @date 2021-05-17
 */
@Api(value = "试卷控制器", tags = {"试卷管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/leak/exam")
public class ExamController extends BaseController {

    private final IExamService iExamService;

    /**
     * 查询试卷列表
     */
    @ApiOperation("查询试卷列表")
    @PreAuthorize("@ss.hasPermi('leak:exam:list')")
    @GetMapping("/list")
    public TableDataInfo<ExamVo> list(ExamQueryBo bo) {
        startPage();
        List<ExamVo> list = iExamService.queryList(bo);
        return getDataTable(list);
    }

    /**
     * 导出试卷列表
     */
    @ApiOperation("导出试卷列表")
    @PreAuthorize("@ss.hasPermi('leak:exam:export')")
    @Log(title = "试卷", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<ExamVo> export(ExamQueryBo bo) {
        List<ExamVo> list = iExamService.queryList(bo);
        ExcelUtil<ExamVo> util = new ExcelUtil<ExamVo>(ExamVo.class);
        return util.exportExcel(list, "试卷");
    }

    /**
     * 获取试卷详细信息
     */
    @ApiOperation("获取试卷详细信息")
    @PreAuthorize("@ss.hasPermi('leak:exam:query')")
    @GetMapping("/{examId}")
    public AjaxResult<ExamVo> getInfo(@PathVariable("examId" ) Long examId) {
        return AjaxResult.success(iExamService.queryById(examId));
    }

    /**
     * 新增试卷
     */
    @ApiOperation("新增试卷")
    @PreAuthorize("@ss.hasPermi('leak:exam:add')")
    @Log(title = "试卷", businessType = BusinessType.INSERT)
    @PostMapping()
    public AjaxResult<Void> add(@RequestBody ExamAddBo bo) {
        return toAjax(iExamService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改试卷
     */
    @ApiOperation("修改试卷")
    @PreAuthorize("@ss.hasPermi('leak:exam:edit')")
    @Log(title = "试卷", businessType = BusinessType.UPDATE)
    @PutMapping()
    public AjaxResult<Void> edit(@RequestBody ExamEditBo bo) {
        return toAjax(iExamService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除试卷
     */
    @ApiOperation("删除试卷")
    @PreAuthorize("@ss.hasPermi('leak:exam:remove')")
    @Log(title = "试卷" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{examIds}")
    public AjaxResult<Void> remove(@PathVariable Long[] examIds) {
        return toAjax(iExamService.deleteWithValidByIds(Arrays.asList(examIds), true) ? 1 : 0);
    }
}
