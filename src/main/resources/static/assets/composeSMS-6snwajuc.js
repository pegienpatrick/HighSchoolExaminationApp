import{a as i}from"./axios-G2rPRu76.js";import{Q as S,r as C,c as x,n as e,m as l,o as A,b as n,u as s,a2 as p,R as f}from"./index-2BP_lAh-.js";import{a as b,b as h,V as v}from"./VCard-LeQVuWP8.js";import{V as u,a as r}from"./VRow-xKr1Tf61.js";import{V as w}from"./VTextarea-lJ93ZVed.js";import{V}from"./VLabel-PkvqaiGN.js";import{V as N}from"./VTextField-vshtD9Ps.js";import{V as _}from"./VSelect-Eu2mWPD8.js";import"./VAvatar-nprCTEVN.js";import"./VImg-noq4ZFey.js";/* empty css              */import"./VField-2KSXPk5K.js";import"./index-QAR5VDvd.js";import"./VInput-fOfT7lUm.js";import"./form-v140H6Iy.js";import"./easing-Apq16fr0.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-QWZbat62.js";import"./ssrBoot-qj21oVFS.js";import"./VDivider-unEwWr4n.js";import"./VOverlay-vCK72WMx.js";import"./lazy-CnP97q8J.js";import"./dialog-transition-zP723b51.js";import"./VCheckboxBtn-qa1S9f3S.js";import"./VChip-JOpZ6GZf.js";const Z={__name:"composeSMS",setup(T){S();let d=window.location.protocol+"//"+window.location.hostname+":8080";const a=C({admNo:"",phone:"x",form:"",stream:"All",message:""}),c=()=>{i.post(d+"/api/v1/sms/smsGuardians",a.value,{headers:{Authorization:f.get("Authorization")}}).then(o=>{console.log(o),alert(o.data)}).catch(o=>{console.log(o),alert("error sending:"+o.response.data)})},g=()=>{i.post(d+`/api/v1/sms/smsClassGuardians/${a.value.form}/${a.value.stream}`,a.value.message,{headers:{Authorization:f.get("Authorization")}}).then(o=>{console.log(o),alert(o.data)}).catch(o=>{console.log(o),alert("error sending:"+o.response.data)})};return(o,t)=>(A(),x("div",null,[e(b,null,{default:l(()=>[e(h,null,{default:l(()=>[n(" Compose New SMS ")]),_:1}),e(v,null,{default:l(()=>[e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(w,{label:"Type Your Message",counter:"",pages:"",modelValue:s(a).message,"onUpdate:modelValue":t[0]||(t[0]=m=>s(a).message=m)},null,8,["modelValue"])]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(V,null,{default:l(()=>[n(" Select to Individual Student ")]),_:1})]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(N,{label:"Send to a Student",placeholder:"Enter Admission Number",modelValue:s(a).admNo,"onUpdate:modelValue":t[1]||(t[1]=m=>s(a).admNo=m)},null,8,["modelValue"])]),_:1}),e(r,null,{default:l(()=>[e(p,{text:"Send to Admission Number",onClick:c})]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(V,null,{default:l(()=>[n(" Send to a Class or Stream ")]),_:1})]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(_,{label:"Form",items:["1","2","3","4"],modelValue:s(a).form,"onUpdate:modelValue":t[2]||(t[2]=m=>s(a).form=m)},null,8,["modelValue"])]),_:1}),e(r,null,{default:l(()=>[e(_,{label:"Stream",items:["All","A","B","C"],modelValue:s(a).stream,"onUpdate:modelValue":t[3]||(t[3]=m=>s(a).stream=m)},null,8,["modelValue"])]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(p,{width:"100%",text:"Send Message",onClick:g})]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{Z as default};
