import{m as h,u as S,a as u}from"./VOverlay-TBYimdhT.js";import{f as p}from"./forwardRefs-y8pOSn8h.js";import{x,aT as O,D as T,a7 as I,aI as k,h as e,r as w,P as d,L as A,n as C}from"./index-WKjbL8T9.js";const R=x({id:String,text:String,...O(h({closeOnBack:!1,location:"end",locationStrategy:"connected",eager:!0,minWidth:0,offset:10,openOnClick:!1,openOnHover:!0,origin:"auto",scrim:!1,scrollStrategy:"reposition",transition:!1}),["absolute","persistent"])},"VTooltip"),F=T()({name:"VTooltip",props:R(),emits:{"update:modelValue":t=>!0},setup(t,v){let{slots:a}=v;const n=I(t,"modelValue"),{scopeId:m}=S(),f=k(),r=e(()=>t.id||`v-tooltip-${f}`),l=w(),g=e(()=>t.location.split(" ").length>1?t.location:t.location+" center"),V=e(()=>t.origin==="auto"||t.origin==="overlap"||t.origin.split(" ").length>1||t.location.split(" ").length>1?t.origin:t.origin+" center"),P=e(()=>t.transition?t.transition:n.value?"scale-transition":"fade-transition"),y=e(()=>d({"aria-describedby":r.value},t.activatorProps));return A(()=>{const b=u.filterProps(t);return C(u,d({ref:l,class:["v-tooltip",t.class],style:t.style,id:r.value},b,{modelValue:n.value,"onUpdate:modelValue":o=>n.value=o,transition:P.value,absolute:!0,location:g.value,origin:V.value,persistent:!0,role:"tooltip",activatorProps:y.value,_disableGlobalStack:!0},m),{activator:a.activator,default:function(){var c;for(var o=arguments.length,s=new Array(o),i=0;i<o;i++)s[i]=arguments[i];return((c=a.default)==null?void 0:c.call(a,...s))??t.text}})}),p({},l)}});export{F as V};
