import{D as p,a7 as F,z as v,y as M,r as c,k as b,aH as B,v as k,aG as w}from"./index-SGO5OOPy.js";const m=Symbol.for("vuetify:form"),O=p({disabled:Boolean,fastFail:Boolean,readonly:Boolean,modelValue:{type:Boolean,default:null},validateOn:{type:String,default:"input"}},"form");function R(r){const n=F(r,"modelValue"),d=v(()=>r.disabled),f=v(()=>r.readonly),o=M(!1),a=c([]),i=c([]);async function g(){const e=[];let s=!0;i.value=[],o.value=!0;for(const t of a.value){const l=await t.validate();if(l.length>0&&(s=!1,e.push({id:t.id,errorMessages:l})),!s&&r.fastFail)break}return i.value=e,o.value=!1,{valid:s,errors:i.value}}function V(){a.value.forEach(e=>e.reset())}function y(){a.value.forEach(e=>e.resetValidation())}return b(a,()=>{let e=0,s=0;const t=[];for(const l of a.value)l.isValid===!1?(s++,t.push({id:l.id,errorMessages:l.errorMessages})):l.isValid===!0&&e++;i.value=t,n.value=s>0?!1:e===a.value.length?!0:null},{deep:!0}),B(m,{register:e=>{let{id:s,validate:t,reset:l,resetValidation:u}=e;a.value.some(h=>h.id===s),a.value.push({id:s,validate:t,reset:l,resetValidation:u,isValid:null,errorMessages:[]})},unregister:e=>{a.value=a.value.filter(s=>s.id!==e)},update:(e,s,t)=>{const l=a.value.find(u=>u.id===e);l&&(l.isValid=s,l.errorMessages=t)},isDisabled:d,isReadonly:f,isValidating:o,isValid:n,items:a,validateOn:k(r,"validateOn")}),{errors:i,isDisabled:d,isReadonly:f,isValidating:o,isValid:n,items:a,validate:g,reset:V,resetValidation:y}}function x(){return w(m,null)}export{R as c,O as m,x as u};
