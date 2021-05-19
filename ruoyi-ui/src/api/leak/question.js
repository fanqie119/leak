import request from '@/utils/request'

// 查询问题信息列表
export function listQuestion(query) {
  return request({
    url: '/leak/question/list',
    method: 'get',
    params: query
  })
}

// 查询问题信息详细
export function getQuestion(id) {
  return request({
    url: '/leak/question/' + id,
    method: 'get'
  })
}

// 新增问题信息
export function addQuestion(data) {
  return request({
    url: '/leak/question',
    method: 'post',
    data: data
  })
}

// 修改问题信息
export function updateQuestion(data) {
  return request({
    url: '/leak/question',
    method: 'put',
    data: data
  })
}

// 删除问题信息
export function delQuestion(id) {
  return request({
    url: '/leak/question/' + id,
    method: 'delete'
  })
}

// 导出问题信息
export function exportQuestion(query) {
  return request({
    url: '/leak/question/export',
    method: 'get',
    params: query
  })
}

// 导出问题信息到word
export function exportQuestionToWord(ids) {
  return request({
    url: '/leak/question/export/word/'+ ids,
    method: 'get',
    responseType: 'blob'
  })
}
