import{m as G,a as H,u as J,V as _,f as K,b as Q,c as X}from"./VField-pvgEwNC3.js";import{f as Y}from"./forwardRefs-y8pOSn8h.js";import{D as Z,L as $,a7 as ee,z as v,r as x,R as te,a9 as ne,b as n,W as V,T as le,ag as ae,F as g,bt as ue,aa as S,ab as ie}from"./index-zYAuA0qV.js";import{I as oe}from"./VImg-XJYe2yvh.js";const re=["color","file","time","date","datetime-local","week","month"],se=Z({autofocus:Boolean,counter:[Boolean,Number,String],counterValue:[Number,Function],prefix:String,placeholder:String,persistentPlaceholder:Boolean,persistentCounter:Boolean,suffix:String,role:String,type:{type:String,default:"text"},modelModifiers:Object,...G(),...H()},"VTextField"),xe=$()({name:"VTextField",directives:{Intersect:oe},inheritAttrs:!1,props:se(),emits:{"click:control":e=>!0,"mousedown:control":e=>!0,"update:focused":e=>!0,"update:modelValue":e=>!0},setup(e,w){let{attrs:m,emit:y,slots:l}=w;const i=ee(e,"modelValue"),{isFocused:r,focus:D,blur:R}=J(e),T=v(()=>typeof e.counterValue=="function"?e.counterValue(i.value):typeof e.counterValue=="number"?e.counterValue:(i.value??"").toString().length),p=v(()=>{if(m.maxlength)return m.maxlength;if(!(!e.counter||typeof e.counter!="number"&&typeof e.counter!="string"))return e.counter}),C=v(()=>["plain","underlined"].includes(e.variant));function A(t,a){var u,o;!e.autofocus||!t||(o=(u=a[0].target)==null?void 0:u.focus)==null||o.call(u)}const F=x(),h=x(),s=x(),B=v(()=>re.includes(e.type)||e.persistentPlaceholder||r.value||e.active);function d(){var t;s.value!==document.activeElement&&((t=s.value)==null||t.focus()),r.value||D()}function M(t){y("mousedown:control",t),t.target!==s.value&&(d(),t.preventDefault())}function N(t){d(),y("click:control",t)}function E(t){t.stopPropagation(),d(),S(()=>{i.value=null,ie(e["onClick:clear"],t)})}function z(t){var u;const a=t.target;if(i.value=a.value,(u=e.modelModifiers)!=null&&u.trim&&["text","search","password","tel","url"].includes(e.type)){const o=[a.selectionStart,a.selectionEnd];S(()=>{a.selectionStart=o[0],a.selectionEnd=o[1]})}}return te(()=>{const t=!!(l.counter||e.counter!==!1&&e.counter!=null),a=!!(t||l.details),[u,o]=ne(m),{modelValue:ce,...O}=_.filterProps(e),U=K(e);return n(_,V({ref:F,modelValue:i.value,"onUpdate:modelValue":c=>i.value=c,class:["v-text-field",{"v-text-field--prefixed":e.prefix,"v-text-field--suffixed":e.suffix,"v-input--plain-underlined":C.value},e.class],style:e.style},u,O,{centerAffix:!C.value,focused:r.value}),{...l,default:c=>{let{id:f,isDisabled:k,isDirty:P,isReadonly:j,isValid:L}=c;return n(Q,V({ref:h,onMousedown:M,onClick:N,"onClick:clear":E,"onClick:prependInner":e["onClick:prependInner"],"onClick:appendInner":e["onClick:appendInner"],role:e.role},U,{id:f.value,active:B.value||P.value,dirty:P.value||e.dirty,disabled:k.value,focused:r.value,error:L.value===!1}),{...l,default:W=>{let{props:{class:b,...q}}=W;const I=le(n("input",V({ref:s,value:i.value,onInput:z,autofocus:e.autofocus,readonly:j.value,disabled:k.value,name:e.name,placeholder:e.placeholder,size:1,type:e.type,onFocus:d,onBlur:R},q,o),null),[[ae("intersect"),{handler:A},null,{once:!0}]]);return n(g,null,[e.prefix&&n("span",{class:"v-text-field__prefix"},[n("span",{class:"v-text-field__prefix__text"},[e.prefix])]),l.default?n("div",{class:b,"data-no-activator":""},[l.default(),I]):ue(I,{class:b}),e.suffix&&n("span",{class:"v-text-field__suffix"},[n("span",{class:"v-text-field__suffix__text"},[e.suffix])])])}})},details:a?c=>{var f;return n(g,null,[(f=l.details)==null?void 0:f.call(l,c),t&&n(g,null,[n("span",null,null),n(X,{active:e.persistentCounter||r.value,value:T.value,max:p.value},l.counter)])])}:void 0})}),Y({},F,h,s)}});export{xe as V,se as m};
