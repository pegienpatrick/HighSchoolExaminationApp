import{r as c,o as b,e as w,w as l,b as e,a as F,t as _,u as t,a1 as M,Z as k,B as f,a2 as N,a3 as O,Y as h,j as D,c as y,q as C,F as T,a4 as A,V as I}from"./index-K1XzZ2A_.js";import{a as R}from"./axios-G2rPRu76.js";import{a as s,V as v}from"./VRow-Qf5i2-nC.js";import{a as S,V as x}from"./VCard-fvYJ7foH.js";import{V as Y}from"./VAlert-HscTSSO4.js";import{V as L}from"./VForm-Nzm-ahwC.js";import{V as m}from"./VTextField-ENGoE4tP.js";import{V as E}from"./VSelect-L6EK_6il.js";import{V as z,a as G,b as $,c as j}from"./VWindowItem-n5UEqYi1.js";/* empty css              */import"./VAvatar-HVdCToNH.js";import"./VImg-W4g71V9b.js";import"./form-PwF12j7b.js";import"./forwardRefs-y8pOSn8h.js";import"./VField-yoownQBA.js";import"./index-3OtdKGzE.js";import"./easing-imumzmxr.js";import"./VMenu-YZxeOGwf.js";import"./ssrBoot-7VnEo6SR.js";import"./VDivider-7yUbEkf7.js";import"./VOverlay-hefUuoVK.js";import"./lazy-5pnrxZ6V.js";import"./VCheckboxBtn-FVKGWhfF.js";import"./VChip-v5paaWLz.js";const P={class:"text-h6 font-weight-semibold text-error"},q={__name:"RegisterNewStudent",setup(B){const g={admNo:"",surname:"",firstName:"",otherName:"",dateOfBirth:"",birthCertno:"",nemisNo:"",gender:"",stream:"",stage:"",kcpeMarks:"",cohort:""},u=c({registerError:"",dateOfBirth:""});let V=!1;c();const a=c(structuredClone(g));c(!1);const p=()=>{a.value=structuredClone(g)};let n=window.location.protocol+"//"+window.location.hostname+":8080";const i=c({admNo:"",name:""}),U=async()=>{if(console.log(a.value.gender),a.value.gender==""||a.value.gender==null){u.value.registerError="You must select gender";return}V=!0,a.value.dateOfBirth=new Date(u.value.dateOfBirth);try{const d=await R.post(n+"/api/v1/student/registerStudent",a.value,{headers:{"Content-Type":"application/json",Authorization:h.get("Authorization")}});V=!1,i.value.admNo=d.data.admNo,i.value.name=a.value.firstName+" "+a.value.surname,u.value.registerError="",console.log(i),p(),console.log("Success:",d.data)}catch(d){if(V=!1,console.log(d.response),u.value.registerError=d.response.data,d.response.status==403&&window.open("/","_blank"),d.response.status==400)try{u.value.registerError="";for(const[o,r]of Object.entries(JSON.parse(d.response.data.message).fielderrors))u.value.registerError+=` ${r}
`}catch{u.value.registerError=d.response.data}else u.value.registerError=d.response.data;console.log(u.value.registerError)}};return(d,o)=>(b(),w(v,null,{default:l(()=>[e(s,{cols:"12",class:"text-center"},{default:l(()=>[F("p",P,_(t(u).registerError),1)]),_:1}),t(V)?(b(),w(M,{key:0,indeterminate:"",color:"blue",size:"24",style:{position:"absolute","inset-block-start":"50%","inset-inline-start":"50%",transform:"translate(-50%, -50%)"}})):k("",!0),t(i).admNo!=""?(b(),w(s,{key:1,cols:"12"},{default:l(()=>[e(S,{"align-self":"center"},{default:l(()=>[e(x,{class:"d-flex"},{default:l(()=>[e(v,null,{default:l(()=>[e(s,null,{default:l(()=>[e(Y,null,{default:l(()=>[f(" Student saved successfully ")]),_:1})]),_:1}),e(v,{"align-self":"center"},{default:l(()=>[e(s,{"align-self":"center"},{default:l(()=>[f(" Index : "+_(t(i).admNo),1)]),_:1}),e(s,{"align-self":"center"},{default:l(()=>[f(_(t(i).name),1)]),_:1}),e(s,{"align-self":"center"},{default:l(()=>[e(N,{to:`/viewStudent?admNo=${t(i).admNo}`,label:"View Student",color:"primary"},{default:l(()=>[f(" View Student ")]),_:1},8,["to"])]),_:1}),e(s,{"align-self":"center"},{default:l(()=>[e(N,{to:`/editStudent?admNo=${t(i).admNo}`,label:"Guardians",color:"secondary"},{default:l(()=>[f(" Guardians ")]),_:1},8,["to"])]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})):k("",!0),e(s,{cols:"12"},{default:l(()=>[e(S,{title:"Student Details"},{default:l(()=>[e(x,{class:"d-flex"},{default:l(()=>[e(L,{class:"mt-6"},{default:l(()=>[e(v,null,{default:l(()=>[e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).admNo,"onUpdate:modelValue":o[0]||(o[0]=r=>t(a).admNo=r),label:"Admission Number",type:"number"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).surname,"onUpdate:modelValue":o[1]||(o[1]=r=>t(a).surname=r),label:"Surname"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).firstName,"onUpdate:modelValue":o[2]||(o[2]=r=>t(a).firstName=r),label:"First Name"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).otherName,"onUpdate:modelValue":o[3]||(o[3]=r=>t(a).otherName=r),label:"Other Name"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(u).dateOfBirth,"onUpdate:modelValue":o[4]||(o[4]=r=>t(u).dateOfBirth=r),label:"Date of Birth",type:"date",placeholder:"YYYY-MM-DD"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(E,{modelValue:t(a).gender,"onUpdate:modelValue":o[5]||(o[5]=r=>t(a).gender=r),label:"Gender",items:["MALE","FEMALE","OTHER"],placeholder:"Select Gender",required:""},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).birthCertno,"onUpdate:modelValue":o[6]||(o[6]=r=>t(a).birthCertno=r),label:"Birth Certificate Number"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).nemisNo,"onUpdate:modelValue":o[7]||(o[7]=r=>t(a).nemisNo=r),label:"nemis Number"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).stage,"onUpdate:modelValue":o[8]||(o[8]=r=>t(a).stage=r),label:"Stage (Form)",type:"number"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(E,{modelValue:t(a).stream,"onUpdate:modelValue":o[9]||(o[9]=r=>t(a).stream=r),label:"Stream",items:["A","B","C"]},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).kcpeMarks,"onUpdate:modelValue":o[10]||(o[10]=r=>t(a).kcpeMarks=r),label:"KCPE Marks",type:"number"},null,8,["modelValue"])]),_:1}),e(s,{md:"6",cols:"12"},{default:l(()=>[e(m,{modelValue:t(a).cohort,"onUpdate:modelValue":o[11]||(o[11]=r=>t(a).cohort=r),label:"Cohort",type:"number"},null,8,["modelValue"])]),_:1}),e(s,{cols:"12",class:"d-flex flex-wrap gap-4"},{default:l(()=>[e(N,{onClick:U},{default:l(()=>[f("Submit")]),_:1}),e(N,{color:"secondary",variant:"outlined",onClick:O(p,["prevent"])},{default:l(()=>[f(" Reset ")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}))}},ge={__name:"admissions",setup(B){const g=D(),u=c(g.params.tab),V=[{title:"Student Profile",icon:"ri-group-line",tab:"account"}];return(a,p)=>(b(),y("div",null,[e(z,{modelValue:t(u),"onUpdate:modelValue":p[0]||(p[0]=n=>C(u)?u.value=n:null),"show-arrows":""},{default:l(()=>[(b(),y(T,null,A(V,n=>e($,{key:n.icon,value:n.tab},{default:l(()=>[e(I,{size:"20",start:"",icon:n.icon},null,8,["icon"]),f(" "+_(n.title),1)]),_:2},1032,["value"])),64))]),_:1},8,["modelValue"]),e(G,{modelValue:t(u),"onUpdate:modelValue":p[1]||(p[1]=n=>C(u)?u.value=n:null),class:"mt-5 disable-tab-transition",touch:!1},{default:l(()=>[e(j,{value:"account"},{default:l(()=>[e(q)]),_:1})]),_:1},8,["modelValue"])]))}};export{ge as default};
