import{a as i}from"./axios-G2rPRu76.js";import{Q as S,r as C,c as x,n as e,m as l,o as A,b as n,u as s,a2 as p,R as f}from"./index-WKjbL8T9.js";import{a as b,b as h,V as v}from"./VCard-7Z-Nhb6D.js";import{V as u,a as r}from"./VRow-OVTj2QZh.js";import{V as w}from"./VTextarea-3AxcCx3g.js";import{V}from"./VLabel-ll7gtFfh.js";import{V as N}from"./VTextField-IrLm8OWS.js";import{V as _}from"./VSelect-OHkD6uXj.js";import"./VAvatar-CH2A0OSR.js";import"./VImg-mBLNfk7f.js";/* empty css              */import"./VField-zZ1l0zML.js";import"./index-o85Hqk3v.js";import"./VInput-9aEGepXD.js";import"./form-y8kNbNCk.js";import"./easing-Apq16fr0.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-QfTuqrl7.js";import"./ssrBoot-WNY3uwVA.js";import"./VDivider-waA0KO__.js";import"./VOverlay-TBYimdhT.js";import"./lazy-b-hiN5pE.js";import"./dialog-transition-ndbJkIK2.js";import"./VCheckboxBtn-G-nkP6-g.js";import"./VChip-nPbsihEe.js";const Z={__name:"composeSMS",setup(T){S();let d=window.location.protocol+"//"+window.location.hostname+":8080";const a=C({admNo:"",phone:"x",form:"",stream:"All",message:""}),c=()=>{i.post(d+"/api/v1/sms/smsGuardians",a.value,{headers:{Authorization:f.get("Authorization")}}).then(o=>{console.log(o),alert(o.data)}).catch(o=>{console.log(o),alert("error sending:"+o.response.data)})},g=()=>{i.post(d+`/api/v1/sms/smsClassGuardians/${a.value.form}/${a.value.stream}`,a.value.message,{headers:{Authorization:f.get("Authorization")}}).then(o=>{console.log(o),alert(o.data)}).catch(o=>{console.log(o),alert("error sending:"+o.response.data)})};return(o,t)=>(A(),x("div",null,[e(b,null,{default:l(()=>[e(h,null,{default:l(()=>[n(" Compose New SMS ")]),_:1}),e(v,null,{default:l(()=>[e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(w,{label:"Type Your Message",counter:"",pages:"",modelValue:s(a).message,"onUpdate:modelValue":t[0]||(t[0]=m=>s(a).message=m)},null,8,["modelValue"])]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(V,null,{default:l(()=>[n(" Select to Individual Student ")]),_:1})]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(N,{label:"Send to a Student",placeholder:"Enter Admission Number",modelValue:s(a).admNo,"onUpdate:modelValue":t[1]||(t[1]=m=>s(a).admNo=m)},null,8,["modelValue"])]),_:1}),e(r,null,{default:l(()=>[e(p,{text:"Send to Admission Number",onClick:c})]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(V,null,{default:l(()=>[n(" Send to a Class or Stream ")]),_:1})]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(_,{label:"Form",items:["1","2","3","4"],modelValue:s(a).form,"onUpdate:modelValue":t[2]||(t[2]=m=>s(a).form=m)},null,8,["modelValue"])]),_:1}),e(r,null,{default:l(()=>[e(_,{label:"Stream",items:["All","A","B","C"],modelValue:s(a).stream,"onUpdate:modelValue":t[3]||(t[3]=m=>s(a).stream=m)},null,8,["modelValue"])]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(r,null,{default:l(()=>[e(p,{width:"100%",text:"Send Message",onClick:g})]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{Z as default};
