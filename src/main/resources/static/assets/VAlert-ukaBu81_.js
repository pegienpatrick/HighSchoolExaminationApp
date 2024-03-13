import{c as D}from"./VAvatar-BX0ZOUQe.js";import{D as L,I as z,E as $,al as w,am as E,an as F,G as O,ao as R,H as N,J as j,K as p,ap as q,L as G,a7 as H,z as o,aq as J,ar as K,as as M,at as Q,au as W,Q as U,av as X,N as Y,P as Z,v as ee,O as ae,b as t,aw as te,V as le,ax as d,a2 as ne,W as se}from"./index-zYAuA0qV.js";const oe=D("v-alert-title"),re=["success","info","warning","error"],ie=L({border:{type:[Boolean,String],validator:e=>typeof e=="boolean"||["top","end","bottom","start"].includes(e)},borderColor:String,closable:Boolean,closeIcon:{type:z,default:"$close"},closeLabel:{type:String,default:"$vuetify.close"},icon:{type:[Boolean,String,Function,Object],default:null},modelValue:{type:Boolean,default:!0},prominent:Boolean,title:String,text:String,type:{type:String,validator:e=>re.includes(e)},...$(),...w(),...E(),...F(),...O(),...R(),...N(),...j(),...p(),...q({variant:"flat"})},"VAlert"),de=G()({name:"VAlert",props:ie(),emits:{"click:close":e=>!0,"update:modelValue":e=>!0},setup(e,v){let{emit:m,slots:a}=v;const r=H(e,"modelValue"),n=o(()=>{if(e.icon!==!1)return e.type?e.icon??`$${e.type}`:e.icon}),y=o(()=>({color:e.color??e.type,variant:e.variant})),{themeClasses:f}=J(e),{colorClasses:b,colorStyles:k,variantClasses:P}=K(y),{densityClasses:V}=M(e),{dimensionStyles:C}=Q(e),{elevationClasses:g}=W(e),{locationStyles:x}=U(e),{positionClasses:S}=X(e),{roundedClasses:_}=Y(e),{textColorClasses:B,textColorStyles:I}=Z(ee(e,"borderColor")),{t:T}=ae(),i=o(()=>({"aria-label":T(e.closeLabel),onClick(s){r.value=!1,m("click:close",s)}}));return()=>{const s=!!(a.prepend||n.value),h=!!(a.title||e.title),A=!!(a.close||e.closable);return r.value&&t(e.tag,{class:["v-alert",e.border&&{"v-alert--border":!!e.border,[`v-alert--border-${e.border===!0?"start":e.border}`]:!0},{"v-alert--prominent":e.prominent},f.value,b.value,V.value,g.value,S.value,_.value,P.value,e.class],style:[k.value,C.value,x.value,e.style],role:"alert"},{default:()=>{var c,u;return[te(!1,"v-alert"),e.border&&t("div",{key:"border",class:["v-alert__border",B.value],style:I.value},null),s&&t("div",{key:"prepend",class:"v-alert__prepend"},[a.prepend?t(d,{key:"prepend-defaults",disabled:!n.value,defaults:{VIcon:{density:e.density,icon:n.value,size:e.prominent?44:28}}},a.prepend):t(le,{key:"prepend-icon",density:e.density,icon:n.value,size:e.prominent?44:28},null)]),t("div",{class:"v-alert__content"},[h&&t(oe,{key:"title"},{default:()=>{var l;return[((l=a.title)==null?void 0:l.call(a))??e.title]}}),((c=a.text)==null?void 0:c.call(a))??e.text,(u=a.default)==null?void 0:u.call(a)]),a.append&&t("div",{key:"append",class:"v-alert__append"},[a.append()]),A&&t("div",{key:"close",class:"v-alert__close"},[a.close?t(d,{key:"close-defaults",defaults:{VBtn:{icon:e.closeIcon,size:"x-small",variant:"text"}}},{default:()=>{var l;return[(l=a.close)==null?void 0:l.call(a,{props:i.value})]}}):t(ne,se({key:"close-btn",icon:e.closeIcon,size:"x-small",variant:"text"},i.value),null)])]}})}}});export{de as V};
