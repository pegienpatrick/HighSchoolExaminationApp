import{a as p}from"./axios-G2rPRu76.js";import{r as i,X as n,Y as d,c,b as o,w as e,o as f,B as V,u as r}from"./index-SGO5OOPy.js";import{V as h,a as _}from"./VRow-SKQ4CCOT.js";import{a as v,b as g,V as w}from"./VCard-iwGy2QZm.js";import{V as x}from"./VTextField-zjRFJMH_.js";import{V as C}from"./VDataTable-3nZzmSqx.js";/* empty css              */import"./VAvatar-aQ_KeIL1.js";import"./VImg-nJ6DsKWr.js";import"./VField-JCquXGl7.js";import"./index-vWDdzW97.js";import"./form-syYsj1LP.js";import"./easing-Apq16fr0.js";import"./forwardRefs-y8pOSn8h.js";import"./VSelect-XRxo3SYo.js";import"./VMenu-Jk-FC-iD.js";import"./ssrBoot-dRiIKdbQ.js";import"./VDivider-J_lD5GQp.js";import"./VOverlay-sta7PfT3.js";import"./lazy-Dwtquv-K.js";import"./dialog-transition-H9M13_Jl.js";import"./VCheckboxBtn-N82T6j1u.js";import"./VChip-AExESlP7.js";import"./VTable-GWFtDMSE.js";const O={__name:"systemLogs",setup(T){const a=i({data:[],search:""}),m=n();let u=window.location.protocol+"//"+window.location.hostname+":8080";return m.currentRoute.value.query.examinationId,i({data:[]}),p.get(u+"/api/v1/logs/listLogs",{headers:{Authorization:d.get("Authorization")}}).then(s=>{a.value.data=s.data;for(var t=0;t<a.value.data.length;t++){var l=new Date(a.value.data[t].date);a.value.data[t].date=l}}),(s,t)=>(f(),c("div",null,[o(h,null,{default:e(()=>[o(_,null,{default:e(()=>[o(v,null,{default:e(()=>[o(g,null,{default:e(()=>[V("Last 200 Logs")]),_:1}),o(w,null,{default:e(()=>[o(x,{label:"Search",modelValue:r(a).search,"onUpdate:modelValue":t[0]||(t[0]=l=>r(a).search=l)},null,8,["modelValue"]),o(C,{items:r(a).data,search:r(a).search},null,8,["items","search"])]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{O as default};
