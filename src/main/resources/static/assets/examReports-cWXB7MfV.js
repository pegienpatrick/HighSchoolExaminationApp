import{a as h}from"./axios-G2rPRu76.js";import{X as v,r as R,Y as w,c as k,b as t,w as e,o as B,B as u,t as m,u as a,a2 as S,a as o}from"./index-WVhmkmZF.js";import{V as n,a as l}from"./VRow-qsllNqOU.js";import{a as _,b as c,V}from"./VCard-TLPCC7Wu.js";import{V as b}from"./VForm-7e7r4mv3.js";import{V as T}from"./VTextField-I18sYzb4.js";import{V as y}from"./VSelect-xmc4eIl2.js";/* empty css              */import"./VAvatar-9kArmvpM.js";import"./VImg-lYzg05eL.js";import"./form-I9H_IUBv.js";import"./forwardRefs-y8pOSn8h.js";import"./VField-PtAP2JRC.js";import"./index-nMzItfZQ.js";import"./easing-imumzmxr.js";import"./VMenu-51ahmtf-.js";import"./ssrBoot-YNbh2RHJ.js";import"./VDivider-PtOVpCpU.js";import"./VOverlay-RBq8L-PQ.js";import"./lazy-m7CSEHGx.js";import"./VCheckboxBtn--5Nvab94.js";import"./VChip-t0IRBmO3.js";const N=o("p",null,[o("strong",null,"Title :")],-1),E=o("p",null,[o("strong",null,"Year:")],-1),F=o("p",null,[o("strong",null,"Term : ")],-1),$=o("p",null,[o("strong",null,"Created On : ")],-1),I=o("p",null,[o("strong",null,"Form : ")],-1),ut={__name:"examReports",setup(U){const p=v();let C=window.location.protocol+"//"+window.location.hostname+":8080",x=p.currentRoute.value.query.examinationId,g=p.currentRoute.value.query.stage;const d=R({year:2024,term:"",title:""}),s=R({selectedStream:"All",selectedAdm:""});h.get(C+`/api/v1/examination/viewExamination/${x}`,{headers:{Authorization:w.get("Authorization")}}).then(f=>{d.value=f.data});const A=()=>{p.push(`/studentReportCard?examinationId=${x}&admNo=${s.value.selectedAdm}`)};return(f,r)=>(B(),k("div",null,[t(n,null,{default:e(()=>[t(l,null,{default:e(()=>[t(_,null,{default:e(()=>[t(c,null,{default:e(()=>[u(" Exam Reports ")]),_:1}),t(V,null,{default:e(()=>[t(b,null,{default:e(()=>[t(n,null,{default:e(()=>[t(l,null,{default:e(()=>[N,u(" "+m(a(d).title),1)]),_:1})]),_:1}),t(n,null,{default:e(()=>[t(l,{md:"6",cols:"12"},{default:e(()=>[E,u(" "+m(a(d).year),1)]),_:1}),t(l,{md:"6",cols:"12"},{default:e(()=>[F,u(m(a(d).term),1)]),_:1}),t(l,{md:"6",cols:"12"},{default:e(()=>[$,u(m(a(d).date),1)]),_:1}),t(l,{md:"6",cols:"12"},{default:e(()=>[I,u(m(a(g)),1)]),_:1})]),_:1}),t(n,null,{default:e(()=>[t(l)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),t(n,null,{default:e(()=>[t(l,null,{default:e(()=>[t(_,null,{default:e(()=>[t(c,null,{default:e(()=>[u(" Student Reports ")]),_:1}),t(V,null,{default:e(()=>[t(n,null,{default:e(()=>[t(l,null,{default:e(()=>[t(T,{label:"Enter Student Admission Number",modelValue:a(s).selectedAdm,"onUpdate:modelValue":r[0]||(r[0]=i=>a(s).selectedAdm=i)},null,8,["modelValue"])]),_:1}),t(l,null,{default:e(()=>[t(S,{text:"Open Student Report",onClick:A})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),t(n,null,{default:e(()=>[t(l,null,{default:e(()=>[t(_,null,{default:e(()=>[t(c,null,{default:e(()=>[u(" Bulk Reports ")]),_:1}),t(V,null,{default:e(()=>[t(n,null,{default:e(()=>[t(l,null,{default:e(()=>[t(y,{label:"Select Stream ",items:["All","A","B","C"],modelValue:a(s).selectedStream,"onUpdate:modelValue":r[1]||(r[1]=i=>a(s).selectedStream=i)},null,8,["modelValue"])]),_:1}),t(l,null,{default:e(()=>[t(S,{text:"Fetch Students Reports",onClick:r[2]||(r[2]=i=>f.bulkReports())})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{ut as default};
