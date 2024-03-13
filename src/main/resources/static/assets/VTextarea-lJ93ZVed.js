import{x as Z,D as ee,a7 as te,h as y,r as v,s as ae,ad as ne,ac as le,w as m,ae as oe,L as ie,a9 as ue,n as l,P as R,F as S,N as _,af as re,ag as se,aa as b,ab as ce,ah as de,ai as fe}from"./index-2BP_lAh-.js";import"./VTextField-vshtD9Ps.js";import{m as ve,f as me,V as xe,a as ge}from"./VField-2KSXPk5K.js";import{m as he,u as we,V as D}from"./VInput-fOfT7lUm.js";import{f as Ve}from"./forwardRefs-y8pOSn8h.js";import{I as ye}from"./VImg-noq4ZFey.js";const Fe=Z({autoGrow:Boolean,autofocus:Boolean,counter:[Boolean,Number,String],counterValue:Function,prefix:String,placeholder:String,persistentPlaceholder:Boolean,persistentCounter:Boolean,noResize:Boolean,rows:{type:[Number,String],default:5,validator:e=>!isNaN(parseFloat(e))},maxRows:{type:[Number,String],validator:e=>!isNaN(parseFloat(e))},suffix:String,modelModifiers:Object,...he(),...ve()},"VTextarea"),be=ee()({name:"VTextarea",directives:{Intersect:ye},inheritAttrs:!1,props:Fe(),emits:{"click:control":e=>!0,"mousedown:control":e=>!0,"update:focused":e=>!0,"update:modelValue":e=>!0},setup(e,G){let{attrs:F,emit:M,slots:u}=G;const o=te(e,"modelValue"),{isFocused:f,focus:E,blur:U}=we(e),O=y(()=>typeof e.counterValue=="function"?e.counterValue(o.value):(o.value||"").toString().length),p=y(()=>{if(F.maxlength)return F.maxlength;if(!(!e.counter||typeof e.counter!="number"&&typeof e.counter!="string"))return e.counter});function $(t,n){var a,i;!e.autofocus||!t||(i=(a=n[0].target)==null?void 0:a.focus)==null||i.call(a)}const N=v(),x=v(),B=ae(""),g=v(),j=y(()=>e.persistentPlaceholder||f.value||e.active);function P(){var t;g.value!==document.activeElement&&((t=g.value)==null||t.focus()),f.value||E()}function L(t){P(),M("click:control",t)}function q(t){M("mousedown:control",t)}function J(t){t.stopPropagation(),P(),b(()=>{o.value="",ce(e["onClick:clear"],t)})}function K(t){var a;const n=t.target;if(o.value=n.value,(a=e.modelModifiers)!=null&&a.trim){const i=[n.selectionStart,n.selectionEnd];b(()=>{n.selectionStart=i[0],n.selectionEnd=i[1]})}}const c=v(),h=v(+e.rows),C=y(()=>["plain","underlined"].includes(e.variant));ne(()=>{e.autoGrow||(h.value=+e.rows)});function d(){e.autoGrow&&b(()=>{if(!c.value||!x.value)return;const t=getComputedStyle(c.value),n=getComputedStyle(x.value.$el),a=parseFloat(t.getPropertyValue("--v-field-padding-top"))+parseFloat(t.getPropertyValue("--v-input-padding-top"))+parseFloat(t.getPropertyValue("--v-field-padding-bottom")),i=c.value.scrollHeight,w=parseFloat(t.lineHeight),I=Math.max(parseFloat(e.rows)*w+a,parseFloat(n.getPropertyValue("--v-input-control-height"))),k=parseFloat(e.maxRows)*w+a||1/0,s=fe(i??0,I,k);h.value=Math.floor((s-a)/w),B.value=de(s)})}le(d),m(o,d),m(()=>e.rows,d),m(()=>e.maxRows,d),m(()=>e.density,d);let r;return m(c,t=>{t?(r=new ResizeObserver(d),r.observe(c.value)):r==null||r.disconnect()}),oe(()=>{r==null||r.disconnect()}),ie(()=>{const t=!!(u.counter||e.counter||e.counterValue),n=!!(t||u.details),[a,i]=ue(F),{modelValue:w,...I}=D.filterProps(e),k=me(e);return l(D,R({ref:N,modelValue:o.value,"onUpdate:modelValue":s=>o.value=s,class:["v-textarea v-text-field",{"v-textarea--prefixed":e.prefix,"v-textarea--suffixed":e.suffix,"v-text-field--prefixed":e.prefix,"v-text-field--suffixed":e.suffix,"v-textarea--auto-grow":e.autoGrow,"v-textarea--no-resize":e.noResize||e.autoGrow,"v-input--plain-underlined":C.value},e.class],style:e.style},a,I,{centerAffix:h.value===1&&!C.value,focused:f.value}),{...u,default:s=>{let{id:V,isDisabled:H,isDirty:z,isReadonly:Q,isValid:W}=s;return l(xe,R({ref:x,style:{"--v-textarea-control-height":B.value},onClick:L,onMousedown:q,"onClick:clear":J,"onClick:prependInner":e["onClick:prependInner"],"onClick:appendInner":e["onClick:appendInner"]},k,{id:V.value,active:j.value||z.value,centerAffix:h.value===1&&!C.value,dirty:z.value||e.dirty,disabled:H.value,focused:f.value,error:W.value===!1}),{...u,default:X=>{let{props:{class:A,...T}}=X;return l(S,null,[e.prefix&&l("span",{class:"v-text-field__prefix"},[e.prefix]),_(l("textarea",R({ref:g,class:A,value:o.value,onInput:K,autofocus:e.autofocus,readonly:Q.value,disabled:H.value,placeholder:e.placeholder,rows:e.rows,name:e.name,onFocus:P,onBlur:U},T,i),null),[[re("intersect"),{handler:$},null,{once:!0}]]),e.autoGrow&&_(l("textarea",{class:[A,"v-textarea__sizer"],id:`${T.id}-sizer`,"onUpdate:modelValue":Y=>o.value=Y,ref:c,readonly:!0,"aria-hidden":"true"},null),[[se,o.value]]),e.suffix&&l("span",{class:"v-text-field__suffix"},[e.suffix])])}})},details:n?s=>{var V;return l(S,null,[(V=u.details)==null?void 0:V.call(u,s),t&&l(S,null,[l("span",null,null),l(ge,{active:e.persistentCounter||f.value,value:O.value,max:p.value},u.counter)])])}:void 0})}),Ve({},N,x,g)}});export{be as V};
