import{X as i,r as m,c as p,b as e,w as t,o as f,B as r,u as o,a2 as V,V as h}from"./index-o3g7j-pu.js";import{a as _,b as S,V as x}from"./VCard-Pw8zZ9F3.js";import{V as s,a as u}from"./VRow-6qMY-zIc.js";import{V as C}from"./VTextField-hSvIFRYb.js";import"./VAvatar-rbGeQzgj.js";import"./VImg-FqV0TNDi.js";/* empty css              */import"./index-bUpWvayE.js";import"./easing-imumzmxr.js";import"./form-ZbOCXVi8.js";import"./forwardRefs-y8pOSn8h.js";const U={__name:"searchStudent",setup(v){const n=i(),a=m({search:""}),c=()=>{console.log("searching "+a.value.search),a.value.search.length>0&&n.push(`/viewStudent?admNo=${a.value.search}`)};return(w,l)=>(f(),p("div",null,[e(_,null,{default:t(()=>[e(S,null,{default:t(()=>[r(" Search Student ")]),_:1}),e(x,null,{default:t(()=>[e(s,null,{default:t(()=>[e(u,null,{default:t(()=>[e(C,{label:"Enter Student Admission",modelValue:o(a).search,"onUpdate:modelValue":l[0]||(l[0]=d=>o(a).search=d)},null,8,["modelValue"])]),_:1})]),_:1}),e(s,null,{default:t(()=>[e(u,{class:"w-50"},{default:t(()=>[e(V,{text:"Search Student",onClick:c},{default:t(()=>[r(" Search Student "),e(h,{icon:"ri-search-line",class:"p-2"})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{U as default};
