import{a as h}from"./axios-G2rPRu76.js";import{_ as M,Q as $,r as w,R as f,c as y,n as e,m as i,o as C,a2 as d,u as l,V as L,b as E}from"./index-Cp0a3j5Z.js";import{V as S,a as m}from"./VRow-e59EUwGS.js";import{V as N}from"./VLabel-X25Up-Eg.js";import{V as z}from"./VSelect-Jx7iHon2.js";import{V as B}from"./VTextField-74eHDJAa.js";import{V as I}from"./VDataTable-wuuS0jak.js";/* empty css              */import"./form-xXdqDCjs.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-RzLdOBfR.js";import"./index-ogFRjp9r.js";import"./ssrBoot-DBy9na19.js";import"./VImg-xuUNPkdI.js";import"./VAvatar-MKe1hS_I.js";import"./VDivider-t6YFHrqH.js";import"./VOverlay-x4J7jcA1.js";import"./easing-Apq16fr0.js";import"./lazy-Pl5wsFII.js";import"./dialog-transition-VPrIJniv.js";import"./VCheckboxBtn-z-5o5nyt.js";import"./VChip-8MtU5gPv.js";import"./VField-thFyAEi-.js";import"./VTable-Tng2Nuci.js";const G={__name:"viewMeritList",setup(T){const x=$(),t=w({data:[],headers:[],search:""});let v=window.location.protocol+"//"+window.location.hostname+":8080",u=x.currentRoute.value.query.exam,n=x.currentRoute.value.query.stage,V=[],g=[],b=[],k=[],_=[];const c=new Map;h.get(v+"/api/v1/subjectSelection/availableSubjects",{headers:{Authorization:f.get("Authorization")}}).then(a=>{console.log(a),_=a.data,_.forEach(o=>{c.set(o.subjectCode,{subjectName:o.subjectName,subjectRep:o.subjectRep})}),console.log(c),console.log(c.get(101))}),h.get(v+`/api/v1/meritList/viewMerit/${u}/${n}`,{headers:{"Content-Type":"application/json",Authorization:f.get("Authorization")}}).then(a=>{console.log(a);let o=a.data;V=o,t.value.data=o,t.value.headers=[{title:"Overall Pos",value:"classRank",key:"classRank"},{title:"Stream",value:"stream",key:"stream"},{title:"Stream Pos",value:"streamRank",key:"streamRank"},{title:"Adm No",value:"admNo",key:"admNo"},{title:"Student Name",value:"studentName",key:"studentName"}],c.forEach((r,p)=>{t.value.headers.push({title:c.get(p).subjectRep,value:"subjectMarks."+p,key:"subjectMarks."+p}),t.value.headers.push({title:"G",value:"subjectGrades."+p,key:"subjectGrades."+p})}),t.value.headers.push({title:"Aggr Points",value:"points",key:"points"}),t.value.headers.push({title:"Aggr Grade",value:"aggregateGrade",key:"aggregateGrade"}),t.value.headers.push({title:"Entry Marks",value:"kcpeMarks",key:"kcpeMarks"}),console.log(t.value.headers)}).catch(a=>{console.log(a),(a.response&&a.response.status===401||a.response.status===403)&&window.open("/login","_blank")});let A="";const s=w({selectedStream:"All"}),R=()=>{if(t.value.data=[],s.value.selectedStream=="All"){t.value.data=V;return}if(s.value.selectedStream=="A"&&g.length>0){t.value.data=g;return}if(s.value.selectedStream=="B"&&b.length>0){t.value.data=b;return}if(s.value.selectedStream=="C"&&k.length>0){t.value.data=k;return}h.get(v+`/api/v1/meritList/viewMerit/${u}/${n}?stream=${s.value.selectedStream}`,{headers:{"Content-Type":"application/json",Authorization:f.get("Authorization")}}).then(a=>{t.value.data=a.data,s.value.selectedStream=="A"&&(g=a.data),s.value.selectedStream=="B"&&(b=a.data),s.value.selectedStream=="C"&&(k=a.data)})},j=()=>{h.get(v+`/api/v1/meritList/printMerit/${u}/${n}?stream=${s.value.selectedStream}`,{responseType:"blob",headers:{Authorization:f.get("Authorization")}}).then(a=>{const o=new Blob([a.data],{type:"application/pdf"}),r=document.createElement("a");r.href=URL.createObjectURL(o),r.download=n+s.value.selectedStream+u+" MeritList.pdf",document.body.appendChild(r),r.click(),document.body.removeChild(r)})};return(a,o)=>(C(),y("div",null,[e(S,null,{default:i(()=>[e(m,null,{default:i(()=>[e(d,{to:`/viewExam?examinationId=${l(u)}&stage=${l(n)}`,text:"Exam Home"},{default:i(()=>[e(L,{icon:"ri-home-line"}),e(N),E(" Exam Home ")]),_:1},8,["to"])]),_:1}),e(m,null,{default:i(()=>[e(d,{to:`/marksSheet?exam=${l(u)}&stage=${l(n)}`,text:"Edit Marks"},null,8,["to"])]),_:1}),e(m,null,{default:i(()=>[e(d,{to:`/generateMeritList?exam=${l(u)}&stage=${l(n)}`,text:"ReGenerate Exam Results"},null,8,["to"])]),_:1}),e(m,null,{default:i(()=>[e(d,{text:"Reports",to:`/viewExamReports?examinationId=${l(u)}&stage=${l(n)}`},null,8,["to"])]),_:1})]),_:1}),e(S,null,{default:i(()=>[e(m,null,{default:i(()=>[e(z,{label:"Select Stream ",items:["All","A","B","C"],modelValue:l(s).selectedStream,"onUpdate:modelValue":o[0]||(o[0]=r=>l(s).selectedStream=r)},null,8,["modelValue"])]),_:1}),e(m,null,{default:i(()=>[e(d,{text:"Fetch Stream MeritList",onClick:R})]),_:1}),e(d,{text:"Download",onClick:j})]),_:1}),e(S,null,{default:i(()=>[e(B,{modelValue:l(t).search,"onUpdate:modelValue":o[1]||(o[1]=r=>l(t).search=r),label:"Search",onInput:l(A)},null,8,["modelValue","onInput"]),e(I,{items:l(t).data,class:"elevation-1 custom-table",striped:"",search:l(t).search,headers:l(t).headers},null,8,["items","search","headers"])]),_:1})]))}},de=M(G,[["__scopeId","data-v-f1399d56"]]);export{de as default};
