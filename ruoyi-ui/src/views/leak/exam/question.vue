<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="试卷id" prop="examId">
        <el-input
          v-model="queryParams.examId"
          placeholder="请输入试卷id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
-->
      </el-form-item>
      <el-form-item label="试卷名称" prop="examName" >
        <el-input
          v-model="queryParams.examName"
          placeholder="请输入试卷名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
          :disabled="true"
        />
      </el-form-item>
      <el-form-item label="一级题号" prop="number1">
        <el-input
          v-model="queryParams.number1"
          placeholder="请输入一级题号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二级题号" prop="number2">
        <el-input
          v-model="queryParams.number2"
          placeholder="请输入二级题号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="问题类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择问题类型" clearable size="small">
          <el-option
            v-for="dict in typeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
<!--
      <el-form-item label="分值" prop="value">
        <el-input
          v-model="queryParams.value"
          placeholder="请输入分值"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分类id" prop="categoryId">
        <el-input
          v-model="queryParams.categoryId"
          placeholder="请输入分类id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分类名称" prop="categoryName">
        <el-input
          v-model="queryParams.categoryName"
          placeholder="请输入分类名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="标签id" prop="labelId">
        <el-input
          v-model="queryParams.labelId"
          placeholder="请输入标签id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="标签名称" prop="labelName">
        <el-input
          v-model="queryParams.labelName"
          placeholder="请输入标签名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="模板文件路径" prop="route">
        <el-input
          v-model="queryParams.route"
          placeholder="请输入模板文件路径"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排序字段" prop="sort">
        <el-input
          v-model="queryParams.sort"
          placeholder="请输入排序字段"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数据状态" prop="deleted">
        <el-select v-model="queryParams.deleted" placeholder="请选择数据状态" clearable size="small">
          <el-option
            v-for="dict in deletedOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['leak:question:add']"
        >新增</el-button>
      </el-col>
<!--
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['leak:question:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['leak:question:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['leak:question:export']"
        >导出</el-button>
      </el-col>
-->

      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExportWord"
          v-hasPermi="['leak:question:export:word']"
        >导出word</el-button>
      </el-col>

      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="questionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="主键自增id" align="center" prop="id" v-if="false"/>
      <el-table-column label="试卷id" align="center" prop="examId" />
-->
      <el-table-column label="试卷名称" align="center" prop="examName" />
      <el-table-column label="一级题号" align="center" prop="number1" />
      <el-table-column label="二级题号" align="center" prop="number2" />
      <el-table-column label="问题类型" align="center" prop="type" :formatter="typeFormat" />
      <el-table-column label="问题描述" align="center" prop="description" />
<!--
      <el-table-column label="参考答案" align="center" prop="answer" />
      <el-table-column label="分值" align="center" prop="value" />
      <el-table-column label="分类id" align="center" prop="categoryId" />
      <el-table-column label="分类名称" align="center" prop="categoryName" />
      <el-table-column label="标签id" align="center" prop="labelId" />
      <el-table-column label="标签名称" align="center" prop="labelName" />
      <el-table-column label="模板文件路径" align="center" prop="route" />
      <el-table-column label="排序字段" align="center" prop="sort" />
      <el-table-column label="备注字段" align="center" prop="remark" />
      <el-table-column label="数据状态" align="center" prop="deleted" :formatter="deletedFormat" />
-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['leak:question:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['leak:question:remove:id']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改问题信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-form-item label="试卷id" prop="examId" v-if="false">
          <el-input v-model="form.examId" placeholder="请输入试卷id" />
        </el-form-item>
        <el-form-item label="试卷名称" prop="examName" v-if="false">
          <el-input v-model="form.examName" placeholder="请输入试卷名称" />
        </el-form-item>

        <el-form-item label="一级题号" prop="number1">
          <el-input v-model="form.number1" placeholder="请输入一级题号" />
        </el-form-item>
        <el-form-item label="二级题号" prop="number2">
          <el-input v-model="form.number2" placeholder="请输入二级题号" />
        </el-form-item>
        <el-form-item label="问题类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择问题类型">
            <el-option
              v-for="dict in typeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="问题描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
<!--
        <el-form-item label="参考答案" prop="answer">
           <el-input v-model="form.answer" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="分值" prop="value">
          <el-input v-model="form.value" placeholder="请输入分值" />
        </el-form-item>
        <el-form-item label="分类id" prop="categoryId">
          <el-input v-model="form.categoryId" placeholder="请输入分类id" />
        </el-form-item>
        <el-form-item label="分类名称" prop="categoryName">
          <el-input v-model="form.categoryName" placeholder="请输入分类名称" />
        </el-form-item>
        <el-form-item label="标签id" prop="labelId">
          <el-input v-model="form.labelId" placeholder="请输入标签id" />
        </el-form-item>
        <el-form-item label="标签名称" prop="labelName">
          <el-input v-model="form.labelName" placeholder="请输入标签名称" />
        </el-form-item>
        <el-form-item label="模板文件路径" prop="route">
          <el-input v-model="form.route" placeholder="请输入模板文件路径" />
        </el-form-item>
        <el-form-item label="排序字段" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序字段" />
        </el-form-item>
        <el-form-item label="备注字段" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="数据状态">
          <el-radio-group v-model="form.deleted">
            <el-radio
              v-for="dict in deletedOptions"
              :key="dict.dictValue"
              :label="parseInt(dict.dictValue)"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listQuestion, getQuestion, delQuestion, addQuestion, updateQuestion, exportQuestion, exportQuestionToWord } from "@/api/leak/question";
import { getExam } from "@/api/leak/exam";
import Editor from '@/components/Editor';

export default {
  name: "Question",
  components: {
    Editor,
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 问题信息表格数据
      questionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 问题类型：0 单选 1 填空 2 判断 3 问答 字典
      typeOptions: [],
      // 数据状态 0 正常 1 删除字典
      deletedOptions: [],
      // 查询参数
      queryParams: {
        examId: undefined,
        examName: undefined,
        number1: undefined,
        number2: undefined,
        type: undefined,
        description: undefined,
        answer: undefined,
        value: undefined,
        categoryId: undefined,
        categoryName: undefined,
        labelId: undefined,
        labelName: undefined,
        route: undefined,
        sort: undefined,
        deleted: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        examId: [
          { required: true, message: "试卷id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    const examId = this.$route.params && this.$route.params.examId;
    this.getExam(examId);
    this.getList();
    this.getDicts("question_type").then(response => {
      this.typeOptions = response.data;
    });
    this.getDicts("sys_deleted").then(response => {
      this.deletedOptions = response.data;
    });
  },
  methods: {
   /** 查询试卷信息详细 */
      getExam(examId) {
        getExam(examId).then(response => {
          console.log(response)
          this.queryParams.examId = response.data.examId;
          this.queryParams.examName = response.data.examName;
          this.defaultExamName = response.data.examName;
          this.getList();
        });
      },

    /** 查询问题信息列表 */
    getList() {
      this.loading = true;
      this.queryParams.examId = this.$route.params && this.$route.params.examId;
      listQuestion(this.queryParams).then(response => {
        this.questionList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 问题类型：0 单选 1 填空 2 判断 3 问答 字典翻译
    typeFormat(row, column) {
      return this.selectDictLabel(this.typeOptions, row.type);
    },
    // 数据状态 0 正常 1 删除字典翻译
    deletedFormat(row, column) {
      return this.selectDictLabel(this.deletedOptions, row.deleted);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: undefined,
        examId: undefined,
        examName: undefined,
        number1: undefined,
        number2: undefined,
        type: undefined,
        description: undefined,
        answer: undefined,
        value: undefined,
        categoryId: undefined,
        categoryName: undefined,
        labelId: undefined,
        labelName: undefined,
        route: undefined,
        sort: undefined,
        remark: undefined,
        deleted: 0
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加问题信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getQuestion(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改问题信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          console.log(this.form);
          console.log(this.$route.params && this.$route.params.examId);
          this.form.examId = this.$route.params && this.$route.params.examId;
          this.form.examName = this.queryParams.examName;
          if (this.form.id != null) {
            updateQuestion(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addQuestion(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除问题信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delQuestion(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },

    /** 导出word按钮操作 */
    handleExportWord() {
      const ids = this.ids;
      this.$confirm('是否确认导出所选问题信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportQuestionToWord(ids);
        }).then(response => {
          console.log(response)
          debugger
          this.msgSuccess("导出成功");
          const blobUrl = window.URL.createObjectURL(response);
          const title = 'out_leak.docx';
          const a = document.createElement('a');
          a.style.display = 'none';
          a.download = title;
          a.href = blobUrl;
          a.click();
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有问题信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportQuestion(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
