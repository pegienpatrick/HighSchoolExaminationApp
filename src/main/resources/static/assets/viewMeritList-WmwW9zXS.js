import{a as v}from"./axios-G2rPRu76.js";import{_ as M,X as k,r as A,Y as h,c as x,b as s,w as i,o as R,u as o,a2 as B}from"./index-WVhmkmZF.js";import{V as j,a as w}from"./VRow-qsllNqOU.js";import{V as N}from"./VSelect-xmc4eIl2.js";import{V as z}from"./VTextField-I18sYzb4.js";import{V as L}from"./VDataTable-GTfkgqep.js";/* empty css              */import"./form-I9H_IUBv.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-51ahmtf-.js";import"./index-nMzItfZQ.js";import"./ssrBoot-YNbh2RHJ.js";import"./VImg-lYzg05eL.js";import"./VAvatar-9kArmvpM.js";import"./VDivider-PtOVpCpU.js";import"./VOverlay-RBq8L-PQ.js";import"./easing-imumzmxr.js";import"./lazy-m7CSEHGx.js";import"./VCheckboxBtn--5Nvab94.js";import"./VField-PtAP2JRC.js";import"./VChip-t0IRBmO3.js";import"./VTable-ZCjYzXs_.js";const I={__name:"viewMeritList",setup($){const f=k(),e=A({data:[],headers:[],search:""});let n=window.location.protocol+"//"+window.location.hostname+":8080",g=f.currentRoute.value.query.exam,b=f.currentRoute.value.query.stage,S=[],d=[],m=[],c=[],V=[];const r=new Map;v.get(n+"/api/v1/subjectSelection/availableSubjects",{headers:{Authorization:h.get("Authorization")}}).then(t=>{console.log(t),V=t.data,V.forEach(a=>{r.set(a.subjectCode,{subjectName:a.subjectName,subjectRep:a.subjectRep})}),console.log(r),console.log(r.get(101))}),v.get(n+`/api/v1/meritList/viewMerit/${g}/${b}`,{headers:{"Content-Type":"application/json",Authorization:h.get("Authorization")}}).then(t=>{console.log(t);let a=t.data;S=a,e.value.data=a,e.value.headers=[{title:"Overall Pos",value:"classRank"},{title:"Stream",value:"stream"},{title:"Stream Pos",value:"streamRank"},{title:"Adm No",value:"admNo"},{title:"Student Name",value:"studentName"}],r.forEach((u,p)=>{e.value.headers.push({title:r.get(p).subjectRep,value:"subjectMarks."+p}),e.value.headers.push({title:"G",value:"subjectGrades."+p})}),e.value.headers.push({title:"Aggr Points",value:"points"}),e.value.headers.push({title:"Aggr Grade",value:"aggregateGrade"}),e.value.headers.push({title:"Entry Marks",value:"kcpeMarks"}),console.log(e.value.headers)}).catch(t=>{console.log(t),(t.response&&t.response.status===401||t.response.status===403)&&window.open("/login","_blank")});let _="";const l=A({selectedStream:"All"}),C=()=>{if(e.value.data=[],l.value.selectedStream=="All"){e.value.data=S;return}if(l.value.selectedStream=="A"&&d.length>0){e.value.data=d;return}if(l.value.selectedStream=="B"&&m.length>0){e.value.data=m;return}if(l.value.selectedStream=="C"&&c.length>0){e.value.data=c;return}v.get(n+`/api/v1/meritList/viewMerit/${g}/${b}?stream=${l.value.selectedStream}`,{headers:{"Content-Type":"application/json",Authorization:h.get("Authorization")}}).then(t=>{e.value.data=t.data,l.value.selectedStream=="A"&&(d=t.data),l.value.selectedStream=="B"&&(m=t.data),l.value.selectedStream=="C"&&(c=t.data)})};return(t,a)=>(R(),x("div",null,[s(j,null,{default:i(()=>[s(w,null,{default:i(()=>[s(N,{label:"Select Stream ",items:["All","A","B","C"],modelValue:o(l).selectedStream,"onUpdate:modelValue":a[0]||(a[0]=u=>o(l).selectedStream=u)},null,8,["modelValue"])]),_:1}),s(w,null,{default:i(()=>[s(B,{text:"Fetch Stream MeritList",onClick:C})]),_:1})]),_:1}),s(j,null,{default:i(()=>[s(z,{modelValue:o(e).search,"onUpdate:modelValue":a[1]||(a[1]=u=>o(e).search=u),label:"Search",onInput:o(_)},null,8,["modelValue","onInput"]),s(L,{items:o(e).data,class:"elevation-1 custom-table",striped:"",search:o(e).search,headers:o(e).headers},null,8,["items","search","headers"])]),_:1})]))}},se=M(I,[["__scopeId","data-v-4b41b2ba"]]);export{se as default};
