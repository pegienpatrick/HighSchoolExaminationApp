import{a as g}from"./axios-G2rPRu76.js";import{X as x,r as w,Y as C,c as _,b as t,w as l,F as v,a4 as B,u as m,o as d,B as u,t as r,e as E,a,a2 as k}from"./index-xVnyt9yu.js";import{V as n,a as e}from"./VRow-gHwNWVPx.js";import{a as f,b as c,V as p}from"./VCard-sd6GJVRG.js";import{V as T}from"./VForm-PYWl0C29.js";/* empty css              */import"./VAvatar-iXQkcGmt.js";import"./VImg-YmpmSzhE.js";import"./form-Fs2--v9g.js";import"./forwardRefs-y8pOSn8h.js";const y=a("p",null,[a("strong",null,"Total :")],-1),F=a("p",null,[a("strong",null,"Year:")],-1),A=a("p",null,[a("strong",null,"Term : ")],-1),N=a("p",null,[a("strong",null,"Created On : ")],-1),$={__name:"viewExaminations",setup(R){const V=x();let h=window.location.protocol+"//"+window.location.hostname+":8080";V.currentRoute.value.query.examinationId;const s=w({data:[]});return g.get(h+"/api/v1/examination/listExaminations",{headers:{Authorization:C.get("Authorization")}}).then(i=>{s.value.data=i.data}),(i,b)=>(d(),_("div",null,[t(n,null,{default:l(()=>[t(e,null,{default:l(()=>[t(f,null,{default:l(()=>[t(c,null,{default:l(()=>[u(" All Examinations ")]),_:1}),t(p,null,{default:l(()=>[t(T,null,{default:l(()=>[t(n,null,{default:l(()=>[t(e,null,{default:l(()=>[y,u(" "+r(m(s).data.length),1)]),_:1})]),_:1}),t(n),t(n,null,{default:l(()=>[t(e)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),(d(!0),_(v,null,B(m(s).data,o=>(d(),E(n,{key:o.num},{default:l(()=>[t(e,null,{default:l(()=>[t(f,null,{default:l(()=>[t(c,null,{default:l(()=>[a("p",null,[a("strong",null,"Form "+r(o.title),1)])]),_:2},1024),t(p,null,{default:l(()=>[t(n,null,{default:l(()=>[t(e,{md:"6",cols:"12"},{default:l(()=>[F,u(" "+r(o.year),1)]),_:2},1024),t(e,{md:"6",cols:"12"},{default:l(()=>[A,u(r(o.term),1)]),_:2},1024),t(e,{md:"6",cols:"12"},{default:l(()=>[N,u(r(o.date),1)]),_:2},1024),t(e,null,{default:l(()=>[t(k,{to:`/viewExam?examinationId=${o.num}`,text:"Open Examination"},null,8,["to"])]),_:2},1024)]),_:2},1024)]),_:2},1024)]),_:2},1024)]),_:2},1024)]),_:2},1024))),128))]))}};export{$ as default};
