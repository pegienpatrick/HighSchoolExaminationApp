import{D as I,I as B,aS as z,E as _,al as J,K,L as F,a7 as S,aJ as E,z as o,aH as W,b1 as Q,aV as X,v as i,R as A,b as d,aO as Y,y as R,r as Z,a9 as p,W as P,T as ee,ag as le,F as ae,V as te,aG as ne,as as oe,a6 as x,P as ue,M as ie,ba as re,aa as ce,aU as se}from"./index-SGO5OOPy.js";import{V as de}from"./VField-JCquXGl7.js";const M=Symbol.for("vuetify:selection-control-group"),O=I({color:String,disabled:{type:Boolean,default:null},defaultsTarget:String,error:Boolean,id:String,inline:Boolean,falseIcon:B,trueIcon:B,ripple:{type:Boolean,default:!0},multiple:{type:Boolean,default:null},name:String,readonly:{type:Boolean,default:null},modelValue:null,type:String,valueComparator:{type:Function,default:z},..._(),...J(),...K()},"SelectionControlGroup"),ve=I({...O({defaultsTarget:"VSelectionControl"})},"VSelectionControlGroup");F()({name:"VSelectionControlGroup",props:ve(),emits:{"update:modelValue":e=>!0},setup(e,u){let{slots:c}=u;const l=S(e,"modelValue"),t=E(),v=o(()=>e.id||`v-selection-control-group-${t}`),r=o(()=>e.name||v.value),a=new Set;return W(M,{modelValue:l,forceUpdate:()=>{a.forEach(n=>n())},onForceUpdate:n=>{a.add(n),Q(()=>{a.delete(n)})}}),X({[e.defaultsTarget]:{color:i(e,"color"),disabled:i(e,"disabled"),density:i(e,"density"),error:i(e,"error"),inline:i(e,"inline"),modelValue:l,multiple:o(()=>!!e.multiple||e.multiple==null&&Array.isArray(l.value)),name:r,falseIcon:i(e,"falseIcon"),trueIcon:i(e,"trueIcon"),readonly:i(e,"readonly"),ripple:i(e,"ripple"),type:i(e,"type"),valueComparator:i(e,"valueComparator")}}),A(()=>{var n;return d("div",{class:["v-selection-control-group",{"v-selection-control-group--inline":e.inline},e.class],style:e.style,role:e.type==="radio"?"radiogroup":void 0},[(n=c.default)==null?void 0:n.call(c)])}),{}}});const H=I({label:String,baseColor:String,trueValue:null,falseValue:null,value:null,..._(),...O()},"VSelectionControl");function fe(e){const u=ne(M,void 0),{densityClasses:c}=oe(e),l=S(e,"modelValue"),t=o(()=>e.trueValue!==void 0?e.trueValue:e.value!==void 0?e.value:!0),v=o(()=>e.falseValue!==void 0?e.falseValue:!1),r=o(()=>!!e.multiple||e.multiple==null&&Array.isArray(l.value)),a=o({get(){const m=u?u.modelValue.value:l.value;return r.value?x(m).some(s=>e.valueComparator(s,t.value)):e.valueComparator(m,t.value)},set(m){if(e.readonly)return;const s=m?t.value:v.value;let f=s;r.value&&(f=m?[...x(l.value),s]:x(l.value).filter(b=>!e.valueComparator(b,t.value))),u?u.modelValue.value=f:l.value=f}}),{textColorClasses:n,textColorStyles:y}=ue(o(()=>{if(!(e.error||e.disabled))return a.value?e.color:e.baseColor})),{backgroundColorClasses:C,backgroundColorStyles:k}=ie(o(()=>a.value&&!e.error&&!e.disabled?e.color:void 0)),h=o(()=>a.value?e.trueIcon:e.falseIcon);return{group:u,densityClasses:c,trueValue:t,falseValue:v,model:a,textColorClasses:n,textColorStyles:y,backgroundColorClasses:C,backgroundColorStyles:k,icon:h}}const $=F()({name:"VSelectionControl",directives:{Ripple:Y},inheritAttrs:!1,props:H(),emits:{"update:modelValue":e=>!0},setup(e,u){let{attrs:c,slots:l}=u;const{group:t,densityClasses:v,icon:r,model:a,textColorClasses:n,textColorStyles:y,backgroundColorClasses:C,backgroundColorStyles:k,trueValue:h}=fe(e),m=E(),s=o(()=>e.id||`input-${m}`),f=R(!1),b=R(!1),g=Z();t==null||t.onForceUpdate(()=>{g.value&&(g.value.checked=a.value)});function D(V){f.value=!0,re(V.target,":focus-visible")!==!1&&(b.value=!0)}function G(){f.value=!1,b.value=!1}function L(V){e.readonly&&t&&ce(()=>t.forceUpdate()),a.value=V.target.checked}return A(()=>{var U,w;const V=l.label?l.label({label:e.label,props:{for:s.value}}):e.label,[N,j]=p(c),T=d("input",P({ref:g,checked:a.value,disabled:!!(e.readonly||e.disabled),id:s.value,onBlur:G,onFocus:D,onInput:L,"aria-disabled":!!(e.readonly||e.disabled),type:e.type,value:h.value,name:e.name,"aria-checked":e.type==="checkbox"?a.value:void 0},j),null);return d("div",P({class:["v-selection-control",{"v-selection-control--dirty":a.value,"v-selection-control--disabled":e.disabled,"v-selection-control--error":e.error,"v-selection-control--focused":f.value,"v-selection-control--focus-visible":b.value,"v-selection-control--inline":e.inline},v.value,e.class]},N,{style:e.style}),[d("div",{class:["v-selection-control__wrapper",n.value],style:y.value},[(U=l.default)==null?void 0:U.call(l,{backgroundColorClasses:C,backgroundColorStyles:k}),ee(d("div",{class:["v-selection-control__input"]},[((w=l.input)==null?void 0:w.call(l,{model:a,textColorClasses:n,textColorStyles:y,backgroundColorClasses:C,backgroundColorStyles:k,inputNode:T,icon:r.value,props:{onFocus:D,onBlur:G,id:s.value}}))??d(ae,null,[r.value&&d(te,{key:"icon",icon:r.value},null),T])]),[[le("ripple"),e.ripple&&[!e.disabled&&!e.readonly,null,["center","circle"]]]])]),V&&d(de,{for:s.value,clickable:!0,onClick:q=>q.stopPropagation()},{default:()=>[V]})])}),{isFocused:f,input:g}}}),me=I({indeterminate:Boolean,indeterminateIcon:{type:B,default:"$checkboxIndeterminate"},...H({falseIcon:"$checkboxOff",trueIcon:"$checkboxOn"})},"VCheckboxBtn"),be=F()({name:"VCheckboxBtn",props:me(),emits:{"update:modelValue":e=>!0,"update:indeterminate":e=>!0},setup(e,u){let{slots:c}=u;const l=S(e,"indeterminate"),t=S(e,"modelValue");function v(n){l.value&&(l.value=!1)}const r=o(()=>l.value?e.indeterminateIcon:e.falseIcon),a=o(()=>l.value?e.indeterminateIcon:e.trueIcon);return A(()=>{const n=se($.filterProps(e),["modelValue"]);return d($,P(n,{modelValue:t.value,"onUpdate:modelValue":[y=>t.value=y,v],class:["v-checkbox-btn",e.class],style:e.style,type:"checkbox",falseIcon:r.value,trueIcon:a.value,"aria-checked":l.value?"mixed":void 0}),c)}),{}}});export{be as V,me as m};
