import{a as P}from"./axios-G2rPRu76.js";import{x as ae,D as te,a7 as W,bi as oe,r as i,h as B,aI as ue,L as ne,a9 as de,n as e,P as I,F as $,V as ie,bj as re,a1 as se,_ as ce,Q as me,ac as fe,c as L,m as l,R as U,o as V,a2 as h,b as Ve,l as y,a4 as pe,Z as D,W as ve,X as _e,a as N}from"./index-WKjbL8T9.js";import{V as d,a as u}from"./VRow-OVTj2QZh.js";import{a as j,V as z,b as R}from"./VCard-7Z-Nhb6D.js";import{V as be}from"./VForm-6aTEnKMd.js";import{V as F}from"./VSelect-OHkD6uXj.js";import{V as he}from"./VTextField-IrLm8OWS.js";import{d as ge}from"./index-o85Hqk3v.js";import{m as ke,u as we,V as H}from"./VInput-9aEGepXD.js";import{a as ye,b as M}from"./VCheckboxBtn-G-nkP6-g.js";/* empty css              */import"./VAvatar-CH2A0OSR.js";import"./VImg-mBLNfk7f.js";import"./form-y8kNbNCk.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-QfTuqrl7.js";import"./ssrBoot-WNY3uwVA.js";import"./VDivider-waA0KO__.js";import"./VOverlay-TBYimdhT.js";import"./easing-Apq16fr0.js";import"./lazy-b-hiN5pE.js";import"./dialog-transition-ndbJkIK2.js";import"./VChip-nPbsihEe.js";import"./VField-zZ1l0zML.js";import"./VLabel-ll7gtFfh.js";const Ce=ae({indeterminate:Boolean,inset:Boolean,flat:Boolean,loading:{type:[Boolean,String],default:!1},...ke(),...ye()},"VSwitch"),T=te()({name:"VSwitch",inheritAttrs:!1,props:Ce(),emits:{"update:focused":t=>!0,"update:modelValue":t=>!0,"update:indeterminate":t=>!0},setup(t,p){let{attrs:v,slots:r}=p;const s=W(t,"indeterminate"),c=W(t,"modelValue"),{loaderClasses:_}=oe(t),{isFocused:A,focus:n,blur:m}=we(t),a=i(),o=B(()=>typeof t.loading=="string"&&t.loading!==""?t.loading:t.color),E=ue(),G=B(()=>t.id||`switch-${E}`);function J(){s.value&&(s.value=!1)}function Q(g){var k,w;g.stopPropagation(),g.preventDefault(),(w=(k=a.value)==null?void 0:k.input)==null||w.click()}return ne(()=>{const[g,k]=de(v),w=H.filterProps(t),X=M.filterProps(t);return e(H,I({class:["v-switch",{"v-switch--inset":t.inset},{"v-switch--indeterminate":s.value},_.value,t.class]},g,w,{modelValue:c.value,"onUpdate:modelValue":C=>c.value=C,id:G.value,focused:A.value,style:t.style}),{...r,default:C=>{let{id:Z,messagesId:q,isDisabled:K,isReadonly:O,isValid:Y}=C;return e(M,I({ref:a},X,{modelValue:c.value,"onUpdate:modelValue":[b=>c.value=b,J],id:Z.value,"aria-describedby":q.value,type:"checkbox","aria-checked":s.value?"mixed":void 0,disabled:K.value,readonly:O.value,onFocus:n,onBlur:m},k),{...r,default:b=>{let{backgroundColorClasses:x,backgroundColorStyles:f}=b;return e("div",{class:["v-switch__track",...x.value],style:f.value,onClick:Q},null)},input:b=>{let{inputNode:x,icon:f,backgroundColorClasses:ee,backgroundColorStyles:le}=b;return e($,null,[x,e("div",{class:["v-switch__thumb",{"v-switch__thumb--filled":f||t.loading},t.inset?void 0:ee.value],style:t.inset?void 0:le.value},[e(ge,null,{default:()=>[t.loading?e(re,{name:"v-switch",active:!0,color:Y.value===!1?void 0:o.value},{default:S=>r.loader?r.loader(S):e(se,{active:S.isActive,color:S.color,indeterminate:!0,size:"16",width:"2"},null)}):f&&e(ie,{key:f,icon:f,size:"x-small"},null)]})])])}})}})}),{}}}),xe=t=>(ve("data-v-98fba312"),t=t(),_e(),t),Se=xe(()=>N("p",null,[N("strong",null,"Subjects")],-1)),Pe={__name:"subjectPerWeek",setup(t){me();let p=window.location.protocol+"//"+window.location.hostname+":8080";i(!1),i({top:0,left:0}),i({optionals:[],optionalsReadable:new Map}),i({data:[],filtered:[],search:""});const v=i({data:null}),r=i({grade:"1",stream:"A"});i({data:[]});const s=()=>{P.get(p+`/api/v1/subjectPerWeek/getForGrade/${r.value.grade}`,{headers:{Authorization:U.get("Authorization")}}).then(n=>{console.log(n),v.value.data=n.data})},c=n=>{P.put(p+"/api/v1/subjectPerWeek/updateSubjectPerWeek",n,{headers:{Authorization:U.get("Authorization")}}).then(m=>{console.log(m),n.success=!0,window.setTimeout(()=>{n.success=null},2e3)})};fe(()=>{});const _=i(null);return(()=>{P.get(p+"/api/v1/venue/listVenues",{headers:{Authorization:U.get("Authorization")}}).then(n=>{console.log(n.data),_.value=n.data})})(),(n,m)=>(V(),L("div",null,[e(d,null,{default:l(()=>[e(u,null,{default:l(()=>[e(j,null,{default:l(()=>[e(z,null,{default:l(()=>[e(d,null,{default:l(()=>[e(u,null,{default:l(()=>[e(h,{text:"TimeTable Home",to:"/teachingTimeTable"})]),_:1}),e(u,null,{default:l(()=>[e(h,{text:"TimeTable Settings",to:"/timetableSettings"})]),_:1}),e(u,null,{default:l(()=>[e(h,{text:"Venues",to:"/venues"})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(d,null,{default:l(()=>[e(u,null,{default:l(()=>[e(j,null,{default:l(()=>[e(R,null,{default:l(()=>[Ve(" Lessons Per Week ")]),_:1}),e(z,null,{default:l(()=>[e(be,null,{default:l(()=>[e(d,null,{default:l(()=>[e(u,null,{default:l(()=>[e(F,{label:"Form (stage)",items:["1","2","3","4"],modelValue:r.value.grade,"onUpdate:modelValue":m[0]||(m[0]=a=>r.value.grade=a)},null,8,["modelValue"])]),_:1})]),_:1}),e(d,null,{default:l(()=>[e(h,{text:"Load Lessons",class:"w-100",color:"secondary",onClick:s})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(d,null,{default:l(()=>[e(u,null,{default:l(()=>[v.value.data!=null?(V(),y(j,{key:0},{default:l(()=>[e(R,null,{default:l(()=>[Se]),_:1}),e(z,null,{default:l(()=>[(V(!0),L($,null,pe(v.value.data,a=>(V(),y(d,{key:a.subjectCode,align:"center",style:{padding:"20px"}},{default:l(()=>[e(u,{"min-width":"500",style:{"min-inline-size":"200px"}},{default:l(()=>[e(he,{modelValue:a.lessonsPerWeek,"onUpdate:modelValue":o=>a.lessonsPerWeek=o,label:"F"+a.grade+" "+a.subjectName+" Lessons Per Week",outlined:"",dense:"","solo-inverted":""},null,8,["modelValue","onUpdate:modelValue","label"])]),_:2},1024),e(u,{style:{"min-inline-size":"200px"},"min-width":"500"},{default:l(()=>[e(T,{label:"Join Streams",modelValue:a.joinStreams,"onUpdate:modelValue":o=>a.joinStreams=o},null,8,["modelValue","onUpdate:modelValue"])]),_:2},1024),e(u,{style:{"min-inline-size":"200px"},"min-width":"500"},{default:l(()=>[e(d,null,{default:l(()=>[e(T,{label:"Has Double",modelValue:a.hasDouble,"onUpdate:modelValue":o=>a.hasDouble=o},null,8,["modelValue","onUpdate:modelValue"])]),_:2},1024),a.hasDouble?(V(),y(d,{key:0},{default:l(()=>[e(u,null,{default:l(()=>[e(F,{label:"F"+a.grade+" "+a.subjectName+" Double Venue",modelValue:a.doubleVenue,"onUpdate:modelValue":o=>a.doubleVenue=o,items:_.value,"item-title":"name"},null,8,["label","modelValue","onUpdate:modelValue","items"])]),_:2},1024)]),_:2},1024)):D("",!0)]),_:2},1024),e(u,{style:{"min-inline-size":"200px"}},{default:l(()=>[e(d,null,{default:l(()=>[e(T,{label:"Has Dedicated Venue",modelValue:a.hasDedicatedVenue,"onUpdate:modelValue":o=>a.hasDedicatedVenue=o},null,8,["modelValue","onUpdate:modelValue"])]),_:2},1024),a.hasDedicatedVenue?(V(),y(d,{key:0},{default:l(()=>[e(u,null,{default:l(()=>[e(F,{label:"F"+a.grade+" "+a.subjectName+" Dedicated Venue",modelValue:a.dedicatedVenues,"onUpdate:modelValue":o=>a.dedicatedVenues=o,items:_.value,"item-title":"name"},null,8,["label","modelValue","onUpdate:modelValue","items"])]),_:2},1024)]),_:2},1024)):D("",!0)]),_:2},1024),e(u,{style:{"min-inline-size":"200px"}},{default:l(()=>[e(h,{text:a.success==null?"Update":"Updated",color:a.success==null?"primary":"success",onClick:o=>c(a)},null,8,["text","color","onClick"])]),_:2},1024)]),_:2},1024))),128))]),_:1})]),_:1})):D("",!0)]),_:1})]),_:1})]))}},Ye=ce(Pe,[["__scopeId","data-v-98fba312"]]);export{Ye as default};
