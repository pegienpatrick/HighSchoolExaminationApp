import{_ as M,Q as T,r as c,R as V,c as p,n as a,m as o,o as i,b as F,u,F as O,a4 as q,t as D,Z as g,l as y,a3 as E,a2 as G,W as L,X as Q,a as R}from"./index-2BP_lAh-.js";import{a as h}from"./axios-G2rPRu76.js";import{V as A,a as m}from"./VRow-xKr1Tf61.js";import{a as U,b as z,V as I}from"./VCard-LeQVuWP8.js";import{V as W}from"./VForm-N6boVIal.js";import{V as S}from"./VSelect-Eu2mWPD8.js";import{V as X}from"./VTextField-vshtD9Ps.js";import{V as Z}from"./VDataTable-B73U__Cq.js";/* empty css              */import"./VAvatar-nprCTEVN.js";import"./VImg-noq4ZFey.js";import"./form-v140H6Iy.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-QWZbat62.js";import"./index-QAR5VDvd.js";import"./ssrBoot-qj21oVFS.js";import"./VDivider-unEwWr4n.js";import"./VOverlay-vCK72WMx.js";import"./easing-Apq16fr0.js";import"./lazy-CnP97q8J.js";import"./dialog-transition-zP723b51.js";import"./VCheckboxBtn-qa1S9f3S.js";import"./VLabel-PkvqaiGN.js";import"./VChip-JOpZ6GZf.js";import"./VField-2KSXPk5K.js";import"./VInput-fOfT7lUm.js";import"./VTable-VRqjCfuz.js";const $=b=>(L("data-v-d1f0a274"),b=b(),Q(),b),H=$(()=>R("p",null,[R("strong",null,"Marks")],-1)),J={key:0},K={__name:"studentsubjects",setup(b){const w=T();let v=window.location.protocol+"//"+window.location.hostname+":8080";w.currentRoute.value.query.exam,w.currentRoute.value.query.stage;const r=c({optionals:[],optionalsReadable:new Map}),j=c({data:[],filtered:[],search:""}),_=c({data:[]});h.get(v+"/api/v1/subjectSelection/optionalSubjects",{headers:{Authorization:V.get("Authorization")}}).then(s=>{console.log(s),r.value.optionals=s.data;for(const e in r.value.optionals){var l=[];l.push({title:"None",value:-1});for(const t in r.value.optionals[e])l.push({title:r.value.optionals[e][t].subjectName,value:parseInt(r.value.optionals[e][t].subjectCode)});console.log(e),r.value.optionalsReadable.set(e,l)}console.log(r.value.optionals),console.log(r.value.optionalsReadable)});const d=c({data:[]});let C=[];const k=new Map;h.get(v+"/api/v1/subjectSelection/availableSubjects",{headers:{Authorization:V.get("Authorization")}}).then(s=>{console.log(s),C=s.data,C.forEach(l=>{k.set(l.subjectCode,{subjectName:l.subjectName,subjectRep:l.subjectRep})}),console.log(k),console.log(k.get(101))}),h.get(v+"/api/v1/subjectSelection/studentSelections",{headers:{Authorization:V.get("Authorization")}}).then(s=>{console.log(s),_.value.data=s.data;var l;l=Object.keys(_.value.data[0]);for(var e=0;e<l.length-1;e++)d.value.data.push({title:l[e],value:l[e],align:"center",key:l[e],type:1});for(var t=Object.keys(s.data[0].subjectSelection),e=0;e<t.length;e++){var n=t[e],N="   "+n+"  (Select One)  ";n=="hasSelected"&&(N="Subjects"),n!="studentId"&&d.value.data.push({title:N,value:n,key:"subjectSelection."+n,type:2})}d.value.data.push({title:"Action",value:"action"})});const B=s=>{console.log(s),h.put(v+"/api/v1/subjectSelection/updateSelection",s.subjectSelection,{headers:{Authorization:V.get("Authorization")}}).then(l=>{console.log(l),s.success=!0,window.setTimeout(()=>{s.success=null},2e3)})},f=c({grade:"All",stream:"All"}),x=()=>{console.log("grading")};return(s,l)=>(i(),p("div",null,[a(A,null,{default:o(()=>[a(m,null,{default:o(()=>[a(U,null,{default:o(()=>[a(z,null,{default:o(()=>[F(" Subjects Selections ")]),_:1}),a(I,null,{default:o(()=>[a(W,null,{default:o(()=>[a(A,null,{default:o(()=>[a(m,null,{default:o(()=>[a(S,{label:"Form (stage)",placeholder:"",items:["All","1","2","3","4"],modelValue:u(f).grade,"onUpdate:modelValue":l[0]||(l[0]=e=>u(f).grade=e),"onClick:append":x},null,8,["modelValue"])]),_:1}),a(m,null,{default:o(()=>[a(S,{label:"Stream",placeholder:"Select Stream",items:["All","A","B","C"],modelValue:u(f).stream,"onUpdate:modelValue":l[1]||(l[1]=e=>u(f).stream=e),onChange:x},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),a(A,null,{default:o(()=>[a(m,null,{default:o(()=>[a(U,null,{default:o(()=>[a(z,null,{default:o(()=>[H]),_:1}),a(I,null,{default:o(()=>[a(m,null,{default:o(()=>[a(X,{modelValue:u(j).search,"onUpdate:modelValue":l[2]||(l[2]=e=>u(j).search=e),label:"Search",clearable:""},null,8,["modelValue"])]),_:1}),a(Z,{items:u(_).data,search:u(j).search,class:"elevation-1 w-100 d-block",striped:"","items-per-page":20,headers:u(d).data},{item:o(({item:e})=>[(i(),p("tr",{key:e.admNo},[(i(!0),p(O,null,q(u(d).data,t=>(i(),p("td",{key:t.key,align:"center"},[t.type==1?(i(),p("span",J,D(e[t.key]),1)):g("",!0),t.type==2&&t.title=="Subjects"&&t.title!="Action"?(i(),y(S,{key:1,modelValue:e.subjectSelection[t.value],"onUpdate:modelValue":n=>e.subjectSelection[t.value]=n,label:e.admNo+"("+t.title,class:"w-100 inputMarks",items:[{title:"All",value:!1},{title:"Selection",value:!0}]},null,8,["modelValue","onUpdate:modelValue","label"])):g("",!0),t.type==2&&t.title!="Subjects"&&t.title!="Action"?(i(),y(S,{key:2,modelValue:e.subjectSelection[t.value],"onUpdate:modelValue":n=>e.subjectSelection[t.value]=n,class:"w-100",label:e.admNo+"("+t.title,items:u(r).optionalsReadable.get(t.value)},null,8,["modelValue","onUpdate:modelValue","label","items"])):g("",!0),t.title=="Action"?(i(),y(G,{key:3,color:e.success!=null?"success":"primary",text:e.success!=null?"Updated":"Update",onClick:E(n=>B(e),["prevent"])},null,8,["color","text","onClick"])):g("",!0)]))),128))]))]),_:1},8,["items","search","headers"])]),_:1})]),_:1})]),_:1})]),_:1})]))}},Ae=M(K,[["__scopeId","data-v-d1f0a274"]]);export{Ae as default};
