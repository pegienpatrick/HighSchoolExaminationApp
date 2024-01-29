import{a as V}from"./axios-G2rPRu76.js";import{_ as A,X as C,r as d,Y as b,c as z,b as e,w as t,o as R,B as i,t as f,u as o,a2 as T}from"./index-xVnyt9yu.js";import{V as n,a as s}from"./VRow-gHwNWVPx.js";import{a as S,b as w,V as j}from"./VCard-sd6GJVRG.js";import{V as B}from"./VForm-PYWl0C29.js";import{V as E}from"./VSelect-ILe0HWJq.js";import{V as I}from"./VTextField-CtPzkPC5.js";import{V as M}from"./VDataTable-Kad4Al3N.js";/* empty css              */import"./VAvatar-iXQkcGmt.js";import"./VImg-YmpmSzhE.js";import"./form-Fs2--v9g.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-yxDCCHIV.js";import"./index-yfIYSuHd.js";import"./ssrBoot-GX8WHyxq.js";import"./VDivider-IGpMMh-l.js";import"./VOverlay-0I2wVsb2.js";import"./easing-imumzmxr.js";import"./lazy-YeCD7kcS.js";import"./VCheckboxBtn--yVtLh1Z.js";import"./VField-2MQrz8bF.js";import"./VChip--5OHLTbF.js";import"./VTable-SC0E6epR.js";const N={__name:"marksSheet",setup($){const k=C();let h=window.location.protocol+"//"+window.location.hostname+":8080",_=k.currentRoute.value.query.exam,v=k.currentRoute.value.query.stage;const g=d({data:"All"}),y=d({data:[],showForm:!1}),c=d({year:2024,term:"",title:""});d({data:[]});const u=d({data:[],filtered:[],search:""});V.get(h+`/api/v1/examination/viewExamination/${_}`,{headers:{Authorization:b.get("Authorization")}}).then(r=>{c.value=r.data});const m=d({data:[]});let x=[];const p=new Map;return V.get(h+"/api/v1/subjectSelection/availableSubjects",{headers:{Authorization:b.get("Authorization")}}).then(r=>{console.log(r),x=r.data,x.forEach(a=>{p.set(a.subjectCode,{subjectName:a.subjectName,subjectRep:a.subjectRep})}),console.log(p),console.log(p.get(101))}),V.get(h+`/api/v1/marks/viewMarksSheet/${_}/${v}`,{headers:{Authorization:b.get("Authorization")}}).then(r=>{console.log(r);var l=Object.keys(r.data[0]);console.log(l);for(var a=0;a<l.length-1;a++)l[a]!="examination"&&m.value.data.push({title:l[a],value:l[a],align:"center",show:!0,type:1,key:l[a]});for(var l=Object.keys(r.data[0].marks),a=0;a<l.length;a++)m.value.data.push({title:p.get(parseInt(l[a])).subjectName+"("+l[a]+")",value:"marks."+l[a]+".marks",show:!1,type:2,key:"marks."+l[a]+".marks",sortable:!0});console.log(m.value.data),u.value.data=r.data,u.value.filtered=r.data,y.value.data=m}),(r,a)=>(R(),z("div",null,[e(n,null,{default:t(()=>[e(s,null,{default:t(()=>[e(S,null,{default:t(()=>[e(w,null,{default:t(()=>[i(" Exarm Information ")]),_:1}),e(j,null,{default:t(()=>[e(B,null,{default:t(()=>[e(n,null,{default:t(()=>[e(s,{md:"6",cols:"12"},{default:t(()=>[i(f(o(c).title),1)]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[i(" Year : "+f(o(c).year),1)]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[i(" Form "+f(o(v)),1)]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[i(" Term "+f(o(c).term),1)]),_:1})]),_:1}),e(n,null,{default:t(()=>[e(s,null,{default:t(()=>[e(E,{label:"Stream",placeholder:"Select Stream",items:["All","A","B","C"],value:"All",modelValue:o(g).data,"onUpdate:modelValue":a[0]||(a[0]=l=>o(g).data=l)},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(n,null,{default:t(()=>[e(s,null,{default:t(()=>[e(S,null,{default:t(()=>[e(w,null,{default:t(()=>[e(n,null,{default:t(()=>[e(s,null,{default:t(()=>[e(T,{text:"Edit Marks",to:`/editMarksSheet?exam=${o(_)}&stage=${o(v)}`},null,8,["to"])]),_:1})]),_:1})]),_:1}),e(j,null,{default:t(()=>[e(s,null,{default:t(()=>[e(I,{modelValue:o(u).search,"onUpdate:modelValue":a[1]||(a[1]=l=>o(u).search=l),label:"Search",clearable:""},null,8,["modelValue"])]),_:1}),e(M,{items:o(u).filtered,search:o(u).search,class:"elevation-1",striped:"","items-per-page":o(g).data=="All"?10:o(u).filtered.length,headers:o(m).data},null,8,["items","search","items-per-page","headers"])]),_:1})]),_:1})]),_:1})]),_:1})]))}},de=A(N,[["__scopeId","data-v-d9ec4906"]]);export{de as default};
