import{m as S,u as h,V as u}from"./VOverlay-RBq8L-PQ.js";import{f as p}from"./forwardRefs-y8pOSn8h.js";import{D as O,aT as T,L as x,a7 as R,aU as U,z as e,r as k,W as d,R as w,b as A}from"./index-WVhmkmZF.js";const C=O({id:String,text:String,...T(S({closeOnBack:!1,location:"end",locationStrategy:"connected",eager:!0,minWidth:0,offset:10,openOnClick:!1,openOnHover:!0,origin:"auto",scrim:!1,scrollStrategy:"reposition",transition:!1}),["absolute","persistent"])},"VTooltip"),B=x()({name:"VTooltip",props:C(),emits:{"update:modelValue":t=>!0},setup(t,v){let{slots:o}=v;const n=R(t,"modelValue"),{scopeId:m}=h(),f=U(),r=e(()=>t.id||`v-tooltip-${f}`),l=k(),g=e(()=>t.location.split(" ").length>1?t.location:t.location+" center"),V=e(()=>t.origin==="auto"||t.origin==="overlap"||t.origin.split(" ").length>1||t.location.split(" ").length>1?t.origin:t.origin+" center"),P=e(()=>t.transition?t.transition:n.value?"scale-transition":"fade-transition"),y=e(()=>d({"aria-describedby":r.value},t.activatorProps));return w(()=>{const b=u.filterProps(t);return A(u,d({ref:l,class:["v-tooltip",t.class],style:t.style,id:r.value},b,{modelValue:n.value,"onUpdate:modelValue":a=>n.value=a,transition:P.value,absolute:!0,location:g.value,origin:V.value,persistent:!0,role:"tooltip",activatorProps:y.value,_disableGlobalStack:!0},m),{activator:o.activator,default:function(){var c;for(var a=arguments.length,s=new Array(a),i=0;i<a;i++)s[i]=arguments[i];return((c=o.default)==null?void 0:c.call(o,...s))??t.text}})}),p({},l)}});export{B as V};
