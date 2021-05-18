import request from '@/utils/request'

// 查询试卷列表
export function listExam(query) {
  return request({
    url: '/leak/exam/list',
    method: 'get',
    params: query
  })
}

// 查询试卷详细
export function getExam(examId) {
  return request({
    url: '/leak/exam/' + examId,
    method: 'get'
  })
}

// 新增试卷
export function addExam(data) {
  return request({
    url: '/leak/exam',
    method: 'post',
    data: data
  })
}

// 修改试卷
export function updateExam(data) {
  return request({
    url: '/leak/exam',
    method: 'put',
    data: data
  })
}

// 删除试卷
export function delExam(examId) {
  return request({
    url: '/leak/exam/' + examId,
    method: 'delete'
  })
}

// 导出试卷
export function exportExam(query) {
  return request({
    url: '/leak/exam/export',
    method: 'get',
    params: query
  })
}