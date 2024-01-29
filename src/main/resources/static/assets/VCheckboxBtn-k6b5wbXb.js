import{D as I,I as B,aJ as H,E as $,ag as J,K,L as F,a6 as S,aT as E,z as o,aC as W,b2 as Q,ax as X,v as i,R as A,b as d,bc as Y,y as R,r as Z,ad as p,W as P,T as ee,a_ as le,F as ae,V as te,aD as ne,an as oe,ab as x,P as ue,M as ie,b6 as re,a9 as ce,aS as se}from"./index--uHrWztf.js";import{d as de}from"./VField-A8xS_5ao.js";const M=Symbol.for("vuetify:selection-control-group"),L=I({color:String,disabled:{type:Boolean,default:null},defaultsTarget:String,error:Boolean,id:String,inline:Boolean,falseIcon:B,trueIcon:B,ripple:{type:Boolean,default:!0},multiple:{type:Boolean,default:null},name:String,readonly:{type:Boolean,default:null},modelValue:null,type:String,valueComparator:{type:Function,default:H},...$(),...J(),...K()},"SelectionControlGroup"),ve=I({...L({defaultsTarget:"VSelectionControl"})},"VSelectionControlGroup");F()({name:"VSelectionControlGroup",props:ve(),emits:{"update:modelValue":e=>!0},setup(e,u){let{slots:c}=u;const l=S(e,"modelValue"),t=E(),v=o(()=>e.id||`v-selection-control-group-${t}`),r=o(()=>e.name||v.value),a=new Set;return W(M,{modelValue:l,forceUpdate:()=>{a.forEach(n=>n())},onForceUpdate:n=>{a.add(n),Q(()=>{a.delete(n)})}}),X({[e.defaultsTarget]:{color:i(e,"color"),disabled:i(e,"disabled"),density:i(e,"density"),error:i(e,"error"),inline:i(e,"inline"),modelValue:l,multiple:o(()=>!!e.multiple||e.multiple==null&&Array.isArray(l.value)),name:r,falseIcon:i(e,"falseIcon"),trueIcon:i(e,"trueIcon"),readonly:i(e,"readonly"),ripple:i(e,"ripple"),type:i(e,"type"),valueComparator:i(e,"valueComparator")}}),A(()=>{var n;return d("div",{class:["v-selection-control-group",{"v-selection-control-group--inline":e.inline},e.class],style:e.style,role:e.type==="radio"?"radiogroup":void 0},[(n=c.default)==null?void 0:n.call(c)])}),{}}});const N=I({label:String,baseColor:String,trueValue:null,falseValue:null,value:null,...$(),...L()},"VSelectionControl");function fe(e){const u=ne(M,void 0),{densityClasses:c}=oe(e),l=S(e,"modelValue"),t=o(()=>e.trueValue!==void 0?e.trueValue:e.value!==void 0?e.value:!0),v=o(()=>e.falseValue!==void 0?e.falseValue:!1),r=o(()=>!!e.multiple||e.multiple==null&&Array.isArray(l.value)),a=o({get(){const m=u?u.modelValue.value:l.value;return r.value?x(m).some(s=>e.valueComparator(s,t.value)):e.valueComparator(m,t.value)},set(m){if(e.readonly)return;const s=m?t.value:v.value;let f=s;r.value&&(f=m?[...x(l.value),s]:x(l.value).filter(C=>!e.valueComparator(C,t.value))),u?u.modelValue.value=f:l.value=f}}),{textColorClasses:n,textColorStyles:y}=ue(o(()=>{if(!(e.error||e.disabled))return a.value?e.color:e.baseColor})),{backgroundColorClasses:V,backgroundColorStyles:k}=ie(o(()=>a.value&&!e.error&&!e.disabled?e.color:void 0)),h=o(()=>a.value?e.trueIcon:e.falseIcon);return{group:u,densityClasses:c,trueValue:t,falseValue:v,model:a,textColorClasses:n,textColorStyles:y,backgroundColorClasses:V,backgroundColorStyles:k,icon:h}}const _=F()({name:"VSelectionControl",directives:{Ripple:Y},inheritAttrs:!1,props:N(),emits:{"update:modelValue":e=>!0},setup(e,u){let{attrs:c,slots:l}=u;const{group:t,densityClasses:v,icon:r,model:a,textColorClasses:n,textColorStyles:y,backgroundColorClasses:V,backgroundColorStyles:k,trueValue:h}=fe(e),m=E(),s=o(()=>e.id||`input-${m}`),f=R(!1),C=R(!1),g=Z();t==null||t.onForceUpdate(()=>{g.value&&(g.value.checked=a.value)});function D(b){f.value=!0,re(b.target,":focus-visible")!==!1&&(C.value=!0)}function T(){f.value=!1,C.value=!1}function O(b){e.readonly&&t&&ce(()=>t.forceUpdate()),a.value=b.target.checked}return A(()=>{var G,U;const b=l.label?l.label({label:e.label,props:{for:s.value}}):e.label,[j,q]=p(c),w=d("input",P({ref:g,checked:a.value,disabled:!!(e.readonly||e.disabled),id:s.value,onBlur:T,onFocus:D,onInput:O,"aria-disabled":!!(e.readonly||e.disabled),type:e.type,value:h.value,name:e.name,"aria-checked":e.type==="checkbox"?a.value:void 0},q),null);return d("div",P({class:["v-selection-control",{"v-selection-control--dirty":a.value,"v-selection-control--disabled":e.disabled,"v-selection-control--error":e.error,"v-selection-control--focused":f.value,"v-selection-control--focus-visible":C.value,"v-selection-control--inline":e.inline},v.value,e.class]},j,{style:e.style}),[d("div",{class:["v-selection-control__wrapper",n.value],style:y.value},[(G=l.default)==null?void 0:G.call(l,{backgroundColorClasses:V,backgroundColorStyles:k}),ee(d("div",{class:["v-selection-control__input"]},[((U=l.input)==null?void 0:U.call(l,{model:a,textColorClasses:n,textColorStyles:y,backgroundColorClasses:V,backgroundColorStyles:k,inputNode:w,icon:r.value,props:{onFocus:D,onBlur:T,id:s.value}}))??d(ae,null,[r.value&&d(te,{key:"icon",icon:r.value},null),w])]),[[le("ripple"),e.ripple&&[!e.disabled&&!e.readonly,null,["center","circle"]]]])]),b&&d(de,{for:s.value,clickable:!0,onClick:z=>z.stopPropagation()},{default:()=>[b]})])}),{isFocused:f,input:g}}}),me=I({indeterminate:Boolean,indeterminateIcon:{type:B,default:"$checkboxIndeterminate"},...N({falseIcon:"$checkboxOff",trueIcon:"$checkboxOn"})},"VCheckboxBtn"),Ce=F()({name:"VCheckboxBtn",props:me(),emits:{"update:modelValue":e=>!0,"update:indeterminate":e=>!0},setup(e,u){let{slots:c}=u;const l=S(e,"indeterminate"),t=S(e,"modelValue");function v(n){l.value&&(l.value=!1)}const r=o(()=>l.value?e.indeterminateIcon:e.falseIcon),a=o(()=>l.value?e.indeterminateIcon:e.trueIcon);return A(()=>{const n=se(_.filterProps(e),["modelValue"]);return d(_,P(n,{modelValue:t.value,"onUpdate:modelValue":[y=>t.value=y,v],class:["v-checkbox-btn",e.class],style:e.style,type:"checkbox",falseIcon:r.value,trueIcon:a.value,"aria-checked":l.value?"mixed":void 0}),c)}),{}}});export{Ce as V,me as m};
