import{D as oe,a6 as ue,L as ie,O as re,a7 as se,z as p,a8 as U,r as k,k as de,R as ce,a9 as fe,b as t,W as w,F as I,aa as me,ab as pe,X as ve,c as j,w as a,o as z,B as d,u as f,a2 as Ve,a3 as he,e as ye,t as B,Z as L,a as Ce,Y as ke}from"./index-SGO5OOPy.js";import{a as ge}from"./axios-G2rPRu76.js";import{V as v,a as s}from"./VRow-SKQ4CCOT.js";import{a as _e,b as Fe,V as Se}from"./VCard-iwGy2QZm.js";import{V as be}from"./VForm-7zjsCCKO.js";import{m as we,a as Ie,u as ze,b as O,f as Be,c as Pe,d as Re}from"./VField-JCquXGl7.js";import{f as Ae}from"./forwardRefs-y8pOSn8h.js";import{V as De}from"./VChip-AExESlP7.js";/* empty css              */import"./VAvatar-aQ_KeIL1.js";import"./VImg-nJ6DsKWr.js";import"./form-syYsj1LP.js";import"./index-vWDdzW97.js";import"./easing-Apq16fr0.js";const Ne=oe({chips:Boolean,counter:Boolean,counterSizeString:{type:String,default:"$vuetify.fileInput.counterSize"},counterString:{type:String,default:"$vuetify.fileInput.counter"},multiple:Boolean,showSize:{type:[Boolean,Number],default:!1,validator:e=>typeof e=="boolean"||[1e3,1024].includes(e)},...we({prependIcon:"$file"}),modelValue:{type:Array,default:()=>[],validator:e=>ue(e).every(V=>V!=null&&typeof V=="object")},...Ie({clearable:!0})},"VFileInput"),xe=ie()({name:"VFileInput",inheritAttrs:!1,props:Ne(),emits:{"click:control":e=>!0,"mousedown:control":e=>!0,"update:focused":e=>!0,"update:modelValue":e=>!0},setup(e,V){let{attrs:u,emit:g,slots:o}=V;const{t:r}=re(),n=se(e,"modelValue"),{isFocused:_,focus:G,blur:W}=ze(e),P=p(()=>typeof e.showSize!="boolean"?e.showSize:void 0),R=p(()=>(n.value??[]).reduce((l,i)=>{let{size:h=0}=i;return l+h},0)),A=p(()=>U(R.value,P.value)),S=p(()=>(n.value??[]).map(l=>{const{name:i="",size:h=0}=l;return e.showSize?`${i} (${U(h,P.value)})`:i})),X=p(()=>{var i;const l=((i=n.value)==null?void 0:i.length)??0;return e.showSize?r(e.counterSizeString,l,A.value):r(e.counterString,l)}),D=k(),N=k(),m=k(),Y=p(()=>_.value||e.active),x=p(()=>["plain","underlined"].includes(e.variant));function b(){var l;m.value!==document.activeElement&&((l=m.value)==null||l.focus()),_.value||G()}function Z(l){$(l)}function q(l){g("mousedown:control",l)}function $(l){var i;(i=m.value)==null||i.click(),g("click:control",l)}function H(l){l.stopPropagation(),b(),me(()=>{n.value=[],pe(e["onClick:clear"],l)})}return de(n,l=>{(!Array.isArray(l)||!l.length)&&m.value&&(m.value.value="")}),ce(()=>{const l=!!(o.counter||e.counter),i=!!(l||o.details),[h,J]=fe(u),{modelValue:Ee,...K}=O.filterProps(e),Q=Be(e);return t(O,w({ref:D,modelValue:n.value,"onUpdate:modelValue":y=>n.value=y,class:["v-file-input",{"v-file-input--chips":!!e.chips,"v-input--plain-underlined":x.value},e.class],style:e.style,"onClick:prepend":Z},h,K,{centerAffix:!x.value,focused:_.value}),{...o,default:y=>{let{id:F,isDisabled:C,isDirty:M,isReadonly:E,isValid:ee}=y;return t(Pe,w({ref:N,"prepend-icon":e.prependIcon,onMousedown:q,onClick:$,"onClick:clear":H,"onClick:prependInner":e["onClick:prependInner"],"onClick:appendInner":e["onClick:appendInner"]},Q,{id:F.value,active:Y.value||M.value,dirty:M.value,disabled:C.value,focused:_.value,error:ee.value===!1}),{...o,default:te=>{var T;let{props:{class:le,...ae}}=te;return t(I,null,[t("input",w({ref:m,type:"file",readonly:E.value,disabled:C.value,multiple:e.multiple,name:e.name,onClick:c=>{c.stopPropagation(),E.value&&c.preventDefault(),b()},onChange:c=>{if(!c.target)return;const ne=c.target;n.value=[...ne.files??[]]},onFocus:b,onBlur:W},ae,J),null),t("div",{class:le},[!!((T=n.value)!=null&&T.length)&&(o.selection?o.selection({fileNames:S.value,totalBytes:R.value,totalBytesReadable:A.value}):e.chips?S.value.map(c=>t(De,{key:c,size:"small",color:e.color},{default:()=>[c]})):S.value.join(", "))])])}})},details:i?y=>{var F,C;return t(I,null,[(F=o.details)==null?void 0:F.call(o,y),l&&t(I,null,[t("span",null,null),t(Re,{active:!!((C=n.value)!=null&&C.length),value:X.value},o.counter)])])}:void 0})}),Ae({},D,N,m)}}),$e=Ce("h3",{"align-center":""}," Import Csv File with this Format ",-1),Me={key:1},Qe={__name:"importStudents",setup(e){ve();let V=window.location.protocol+"//"+window.location.hostname+":8080";k({year:2024,term:"",title:""});const u=k({file:[],res:""}),g=o=>{const r=new FormData;r.append("file",u.value.file[0]),ge.post(V+"/api/v1/import/importStudents",r,{headers:{"Content-Type":"multipart/form-data",Authorization:ke.get("Authorization")}}).then(n=>{console.log("File uploaded successfully:",n),u.value.res=n.data}).catch(n=>{console.error("Error uploading file:",n),u.value.res=n.response.data})};return(o,r)=>(z(),j("div",null,[t(v,null,{default:a(()=>[t(s,null,{default:a(()=>[t(_e,null,{default:a(()=>[t(Fe,null,{default:a(()=>[d(" Import Students ")]),_:1}),t(Se,null,{default:a(()=>[t(be,{onSubmit:r[2]||(r[2]=n=>{o.preventDefault(),o.submitform()})},{default:a(()=>[$e,t(v,null,{default:a(()=>[t(s,null,{default:a(()=>[d(" Adm No ( int ) ")]),_:1}),t(s,null,{default:a(()=>[d(" Student Name(first,second,surname) ")]),_:1}),t(s,null,{default:a(()=>[d(" Gender ")]),_:1}),t(s,null,{default:a(()=>[d(" Form (number) ")]),_:1}),t(s,null,{default:a(()=>[d(" Stream ")]),_:1})]),_:1}),t(v),t(v,null,{default:a(()=>[t(s,null,{default:a(()=>[t(xe,{label:"Select Csv File",placeholder:"Select Csv File",accept:".csv",name:"file",modelValue:f(u).file,"onUpdate:modelValue":r[0]||(r[0]=n=>f(u).file=n)},null,8,["modelValue"])]),_:1}),t(s,null,{default:a(()=>[t(Ve,{text:"Import Csv",type:"submit",onClick:r[1]||(r[1]=he(n=>g(this),["prevent"]))})]),_:1})]),_:1})]),_:1}),f(u).res.split(",").length==1?(z(),ye(v,{key:0},{default:a(()=>[t(s,null,{default:a(()=>[d(" Errors : "+B(f(u).res),1)]),_:1})]),_:1})):L("",!0),f(u).res.split(",").length>1?(z(),j("div",Me,[t(v,null,{default:a(()=>[t(s,null,{default:a(()=>[d(B(f(u).res.split(",")[0]),1)]),_:1})]),_:1}),t(v,null,{default:a(()=>[t(s,null,{default:a(()=>[d(B(f(u).res.replace(f(u).res.split(",")[0],"")),1)]),_:1})]),_:1})])):L("",!0)]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{Qe as default};
