import{a as y}from"./axios-G2rPRu76.js";import{_ as Z,X as J,r as h,Y as S,c as _,b as e,w as a,o as c,a2 as i,u as o,V as B,B as d,t as g,F as T,a4 as L,e as D,a as U,Z as j,p as K,m as P}from"./index-zYAuA0qV.js";import{V as m,a as s}from"./VRow-7mHl22X1.js";import{V as Q}from"./VLabel-H24OS9-G.js";import{a as $,b as F,V as M}from"./VCard-Mp1410Mc.js";import{V as H}from"./VForm-8SLQ-6iH.js";import{V as W}from"./VSelect-4nlBnCuk.js";import{V as ee}from"./VDialog-3VbpmMDW.js";import{V as ae}from"./VCheckbox-FySYAVU3.js";import{V as q}from"./VTextField-JQu1_MM5.js";import{V as te}from"./VDataTable-qyJ_490b.js";/* empty css              */import"./VAvatar-BX0ZOUQe.js";import"./VImg-XJYe2yvh.js";import"./form-5RZ1SEPf.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-AAQK7vOC.js";import"./index-Dx9PTrLH.js";import"./ssrBoot-sA4uMkfL.js";import"./VDivider-AOx8292S.js";import"./VOverlay-fwCDSazt.js";import"./easing-Apq16fr0.js";import"./lazy-p-tG6HZU.js";import"./dialog-transition-BhwFHhVk.js";import"./VCheckboxBtn-HguwSvFI.js";import"./VChip-LZhjDHi2.js";import"./VField-pvgEwNC3.js";import"./VTable-tqJF_m3V.js";const le=C=>(K("data-v-16f07bcb"),C=C(),P(),C),oe=le(()=>U("p",null,[U("strong",null,"Marks")],-1)),re={key:0},se={__name:"editMarksSheet",setup(C){const z=J();let V=window.location.protocol+"//"+window.location.hostname+":8080",p=z.currentRoute.value.query.exam,f=z.currentRoute.value.query.stage;const b=h({data:"All"}),k=h({data:[],showForm:!1}),A=h({year:2024,term:"",title:""}),x=h({data:[]}),v=h({data:[],filtered:[],search:""});y.get(V+`/api/v1/examination/viewExamination/${p}`,{headers:{Authorization:S.get("Authorization")}}).then(r=>{A.value=r.data});const n=h({data:[],visible:[]});let I=[];const w=new Map;y.get(V+"/api/v1/subjectSelection/availableSubjects",{headers:{Authorization:S.get("Authorization")}}).then(r=>{console.log(r),I=r.data,I.forEach(l=>{w.set(l.subjectCode,{subjectName:l.subjectName,subjectRep:l.subjectRep})}),console.log(w),console.log(w.get(101))}),y.get(V+`/api/v1/marks/viewMarksSheet/${p}/${f}`,{headers:{Authorization:S.get("Authorization")}}).then(r=>{console.log(r);var t=Object.keys(r.data[0]);console.log(t);for(var l=0;l<t.length-1;l++)t[l]!="examination"&&n.value.data.push({title:t[l],value:t[l],align:"center",show:!0,type:1,key:t[l]});for(var t=Object.keys(r.data[0].marks),l=0;l<t.length;l++)n.value.data.push({title:w.get(parseInt(t[l])).subjectName+"("+t[l]+")",value:t[l],show:!1,type:2,key:"marks."+t[l]+".marks"});console.log(n.value.data),v.value.data=r.data,v.value.filtered=r.data,k.value.data=n,E()});const O=r=>{y.put(V+"/api/v1/marks/updateMarks",r,{headers:{Authorization:S.get("Authorization")}}).then(l=>{console.log(l)}).catch(l=>{console.log(l),x.value.data.push(r)})},Y=async()=>{for(var r=[],l=0;l<x.value.data.length;l++){const t=x.value.data[l];try{const u=await y.put(V+"/api/v1/marks/updateMarks",t,{headers:{Authorization:S.get("Authorization")}});(u.status===200||u.ok)&&r.push(l)}catch(u){console.error(u)}}r.reverse().forEach(t=>{x.value.data.splice(t,1)})},G=()=>{k.value.showForm=!0},R=()=>{k.value.showForm=!1},E=()=>{n.value.visible=[];for(const r in n.value.data)n.value.data[r].show&&n.value.visible.push(n.value.data[r]);console.log(n.value.visible)},X=()=>{R(),E()};return(r,l)=>(c(),_("div",null,[e(m,null,{default:a(()=>[e(s,null,{default:a(()=>[e(i,{to:`/viewExam?examinationId=${o(p)}&stage=${o(f)}`,text:"Exam Home"},{default:a(()=>[e(B,{icon:"ri-home-line"}),e(Q),d(" Exam Home ")]),_:1},8,["to"])]),_:1}),e(s,null,{default:a(()=>[e(i,{to:`/marksSheet?exam=${o(p)}&stage=${o(f)}`,text:"view Marks"},null,8,["to"])]),_:1}),e(s,null,{default:a(()=>[e(i,{text:"View Merit List",to:`/viewMeritList?exam=${o(p)}&stage=${o(f)}`},null,8,["to"])]),_:1}),e(s,null,{default:a(()=>[e(i,{to:`/generateMeritList?exam=${o(p)}&stage=${o(f)}`,text:"Generate Exam Results"},null,8,["to"])]),_:1}),e(s,null,{default:a(()=>[e(i,{text:"Reports",to:`/viewExamReports?examinationId=${o(p)}&stage=${o(f)}`},null,8,["to"])]),_:1})]),_:1}),e(m,null,{default:a(()=>[e(s,null,{default:a(()=>[e($,null,{default:a(()=>[e(F,null,{default:a(()=>[d(" Exarm Information ")]),_:1}),e(M,null,{default:a(()=>[e(H,null,{default:a(()=>[e(m,null,{default:a(()=>[e(s,{md:"6",cols:"12"},{default:a(()=>[d(g(o(A).title),1)]),_:1}),e(s,{md:"6",cols:"12"},{default:a(()=>[d(" Year : "+g(o(A).year),1)]),_:1}),e(s,{md:"6",cols:"12"},{default:a(()=>[d(" Form "+g(o(f)),1)]),_:1}),e(s,{md:"6",cols:"12"},{default:a(()=>[d(" Term "+g(o(A).term),1)]),_:1})]),_:1}),e(m,null,{default:a(()=>[e(s,null,{default:a(()=>[e(W,{label:"Stream",placeholder:"Select Stream",items:["All","A","B","C"],value:"All",modelValue:o(b).data,"onUpdate:modelValue":l[0]||(l[0]=t=>o(b).data=t)},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(m,null,{default:a(()=>[e(s,null,{default:a(()=>[e($,null,{default:a(()=>[e(F,null,{default:a(()=>[e(m,null,{default:a(()=>[e(s,null,{default:a(()=>[oe,d("(Auto Saving) ")]),_:1}),e(s,null,{default:a(()=>[e(m,null,{default:a(()=>[d(g(o(x).data.length)+" Unsaved Changes ",1)]),_:1}),e(m,null,{default:a(()=>[e(i,{text:"Save unsaved Updates",onClick:Y})]),_:1})]),_:1}),e(s,null,{default:a(()=>[e(i,{color:"success",onClick:G},{default:a(()=>[d("viewable Columns")]),_:1})]),_:1})]),_:1})]),_:1}),e(ee,{modelValue:o(k).showForm,"onUpdate:modelValue":l[1]||(l[1]=t=>o(k).showForm=t),"max-width":"600"},{default:a(()=>[e($,null,{default:a(()=>[e(F,null,{default:a(()=>[d(" Form "),e(i,{icon:"",onClick:R,style:{float:"inline-end"},color:"error"},{default:a(()=>[e(B,null,{default:a(()=>[d("ri-close-line")]),_:1})]),_:1})]),_:1}),e(M,null,{default:a(()=>[e(H,null,{default:a(()=>[(c(!0),_(T,null,L(o(n).data,t=>(c(),D(m,{key:t.value},{default:a(()=>[U("span",null,[e(ae,{label:t.title,"v-text":t.title,modelValue:t.show,"onUpdate:modelValue":u=>t.show=u},null,8,["label","v-text","modelValue","onUpdate:modelValue"])])]),_:2},1024))),128))]),_:1})]),_:1}),e(i,{onClick:X,color:"primary",bg:"success","background-color":"primary",text:"Submit"})]),_:1})]),_:1},8,["modelValue"]),e(M,null,{default:a(()=>[e(s,null,{default:a(()=>[e(q,{modelValue:o(v).search,"onUpdate:modelValue":l[2]||(l[2]=t=>o(v).search=t),label:"Search",clearable:""},null,8,["modelValue"])]),_:1}),e(te,{items:o(v).filtered,search:o(v).search,class:"elevation-1",striped:"","items-per-page":o(b).data=="All"?10:o(v).filtered.length,headers:o(n).visible},{item:a(({item:t})=>[o(b).data=="All"||o(b).data==t.stream?(c(),_("tr",{key:t.admNo},[(c(!0),_(T,null,L(o(n).visible,u=>(c(),_("td",{key:u.key,align:"center",width:160,dense:"",style:{"inline-size":"2rem"}},[u.type==1?(c(),_("span",re,g(t[u.key]),1)):j("",!0),u.type==2?(c(),D(q,{key:1,modelValue:t.marks[u.value].marks,"onUpdate:modelValue":N=>t.marks[u.value].marks=N,label:o(w).get(t.marks[u.value].subjectCode).subjectRep+"("+t.admNo+")",onChange:N=>O(t.marks[u.value])},null,8,["modelValue","onUpdate:modelValue","label","onChange"])):j("",!0)]))),128))])):j("",!0)]),_:1},8,["items","search","items-per-page","headers"])]),_:1})]),_:1})]),_:1})]),_:1})]))}},Re=Z(se,[["__scopeId","data-v-16f07bcb"]]);export{Re as default};
