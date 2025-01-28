import{a as C}from"./axios-G2rPRu76.js";import{_ as D,Q as E,r as d,ac as P,c as b,n as l,m as o,ad as Q,o as m,b as $,a2 as w,l as x,F as y,a4 as F,t as S,Z as W,R as k,k as Z,W as q,X as G,a as U}from"./index-Cp0a3j5Z.js";import{V as i,a as c}from"./VRow-e59EUwGS.js";import{V as H,a as J,c as K,b as O}from"./VMenu-RzLdOBfR.js";import{a as I,b as A,V as B}from"./VCard-f1nee6yo.js";import{V as ee}from"./VForm-vHiLR6LN.js";import{V as z}from"./VSelect-Jx7iHon2.js";import{V as L}from"./VTextField-74eHDJAa.js";/* empty css              */import"./index-ogFRjp9r.js";import"./ssrBoot-DBy9na19.js";import"./VImg-xuUNPkdI.js";import"./VAvatar-MKe1hS_I.js";import"./VDivider-t6YFHrqH.js";import"./VOverlay-x4J7jcA1.js";import"./easing-Apq16fr0.js";import"./lazy-Pl5wsFII.js";import"./forwardRefs-y8pOSn8h.js";import"./dialog-transition-VPrIJniv.js";import"./form-xXdqDCjs.js";import"./VCheckboxBtn-z-5o5nyt.js";import"./VLabel-X25Up-Eg.js";import"./VChip-8MtU5gPv.js";import"./VField-thFyAEi-.js";const le=f=>(q("data-v-6111da4f"),f=f(),G(),f),ae=le(()=>U("p",null,[U("strong",null,"Teachers")],-1)),te={__name:"subjectTeachers",setup(f){E();let g=window.location.protocol+"//"+window.location.hostname+":8080";const h=d(!1),v=d({top:0,left:0});d({optionals:[],optionalsReadable:new Map}),d({data:[],filtered:[],search:""});const r=d({data:null}),p=d({grade:"1",stream:"A"});d({data:[]});const s=d({data:[],allTeachers:[],filtered:[]}),Y=()=>{C.get(g+"/api/v1/subjectTeacher/allTeachers",{headers:{Authorization:k.get("Authorization")}}).then(t=>{console.log(t),s.value.allTeachers=t.data,s.value.data=[];for(const a in s.value.allTeachers)s.value.data.push({key:a,value:a,title:s.value.allTeachers[a],text:s.value.allTeachers[a]})})},M=()=>{C.get(g+`/api/v1/subjectTeacher/viewSubjectTeachers/${p.value.grade}/${p.value.stream}`,{headers:{Authorization:k.get("Authorization")}}).then(t=>{console.log(t),r.value.data=t.data,Y()})},j=t=>{console.log(t),C.put(g+"/api/v1/subjectTeacher/updateSubjectTeacher",t,{headers:{Authorization:k.get("Authorization")}}).then(a=>{console.log(a),t.success=!0,window.setTimeout(()=>{t.success=null},2e3)})};P(()=>{});const u=d({searchText:"",menu:!1,positionX:0,positionY:0,subjectTeacher:{}});s.value.data;const R=(t,a)=>{a.teacher=t.value},X=(t,a)=>{const n=t.$el.getBoundingClientRect();u.value.positionX=n.left,u.value.positionY=n.top,u.value.offsetY=n.top,u.value.subjectTeacher=a,u.value.menu=!0,u.value.searchText=t.$el.value,console.log(u.value);const e=n.left,T=n.top+40;v.value={top:T,left:e},h.value=!0,console.log(v.value)},N=(t,a)=>{var n=t[0];const e=n.$el.getBoundingClientRect();u.value.positionX=e.left,u.value.positionY=e.top+window.scrollY+42,u.value.subjectTeacher=a,u.value.menu=!0,u.value.searchText=n.$el.value,console.log(u.value),v.value={top:u.value.positionY,left:u.value.positionX},h.value=!0,console.log(v.value)},V=t=>{console.log(t),s.value.filtered=[],u.value.searchText=t;for(const n in s.value.data){var a=s.value.data[n];a.title.toLowerCase().includes(t.toLowerCase())&&s.value.filtered.push(a)}};return(t,a)=>{const n=Z("v-list-item-content");return m(),b("div",null,[l(i,null,{default:o(()=>[l(c,null,{default:o(()=>[l(I,null,{default:o(()=>[l(A,null,{default:o(()=>[$(" Subject Teachers ")]),_:1}),l(B,null,{default:o(()=>[l(ee,null,{default:o(()=>[l(i,null,{default:o(()=>[l(c,null,{default:o(()=>[l(z,{label:"Form (stage)",items:["1","2","3","4"],modelValue:p.value.grade,"onUpdate:modelValue":a[0]||(a[0]=e=>p.value.grade=e)},null,8,["modelValue"])]),_:1}),l(c,null,{default:o(()=>[l(z,{label:"Stream",items:["A","B","C"],modelValue:p.value.stream,"onUpdate:modelValue":a[1]||(a[1]=e=>p.value.stream=e)},null,8,["modelValue"])]),_:1})]),_:1}),l(i,null,{default:o(()=>[l(w,{text:"Load Subject Teachers",class:"w-100",color:"secondary",onClick:M})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),l(i,null,{default:o(()=>[l(c,null,{default:o(()=>[r.value.data!=null?(m(),x(I,{key:0},{default:o(()=>[l(A,null,{default:o(()=>[ae,l(i,null,{default:o(()=>[l(c,null,{default:o(()=>[l(L,{modelValue:r.value.data.classTeacher.teacher,"onUpdate:modelValue":a[2]||(a[2]=e=>r.value.data.classTeacher.teacher=e),value:s.value.allTeachers[r.value.data.classTeacher.teacher],label:"Class Teacher",outlined:"",dense:"","solo-inverted":"",ref:"classTeacherTextField",onFocus:a[3]||(a[3]=e=>{X(t.$refs.classTeacherTextField,r.value.data.classTeacher),V(t.$refs.classTeacherTextField.value)}),clearable:"",onInput:a[4]||(a[4]=e=>V(t.$refs.classTeacherTextField.value))},null,8,["modelValue","value"])]),_:1})]),_:1}),l(i,null,{default:o(()=>[l(c,null,{default:o(()=>[l(w,{text:r.value.data.classTeacher.success==null?"Update Class Teacher":"Updated",color:r.value.data.classTeacher.success==null?"primary":"secondary",onClick:a[5]||(a[5]=e=>j(r.value.data.classTeacher))},null,8,["text","color"])]),_:1})]),_:1})]),_:1}),l(B,null,{default:o(()=>[(m(!0),b(y,null,F(r.value.data.subjectTeachers,(e,T)=>(m(),x(i,{key:e.subjectCode},{default:o(()=>[l(c,null,{default:o(()=>[$(S(console.log(e.teacher))+" ",1),l(L,{modelValue:e.teacher,"onUpdate:modelValue":_=>e.teacher=_,value:s.value.allTeachers[e.teacher],label:T+" Teacher",outlined:"",dense:"","solo-inverted":"",ref_for:!0,ref:`subject${e.subjectCode}`,onFocus:_=>{N(t.$refs["subject"+e.subjectCode],e),V(t.$refs["subject"+e.subjectCode][0].value)},clearable:"",onInput:_=>V(t.$refs["subject"+e.subjectCode][0].value)},null,8,["modelValue","onUpdate:modelValue","value","label","onFocus","onInput"])]),_:2},1024),l(c,null,{default:o(()=>[l(w,{text:e.success==null?"Update":"Updated",color:e.success==null?"primary":"success",onClick:_=>j(e)},null,8,["text","color","onClick"])]),_:2},1024)]),_:2},1024))),128))]),_:1})]),_:1})):W("",!0)]),_:1})]),_:1}),l(H,{modelValue:h.value,"onUpdate:modelValue":a[6]||(a[6]=e=>h.value=e),style:Q({position:"absolute",top:v.value.top+"px",left:v.value.left+"px"}),class:"w-75"},{default:o(()=>[l(J,null,{default:o(()=>[(m(!0),b(y,null,F(s.value.filtered,e=>(m(),x(O,{key:e.title,onClick:T=>R(e,u.value.subjectTeacher)},{default:o(()=>[l(n,null,{default:o(()=>[l(K,null,{default:o(()=>[$(S(e.title),1)]),_:2},1024)]),_:2},1024)]),_:2},1032,["onClick"]))),128))]),_:1})]),_:1},8,["modelValue","style"])])}}},ye=D(te,[["__scopeId","data-v-6111da4f"]]);export{ye as default};
