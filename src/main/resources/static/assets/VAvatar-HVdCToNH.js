import{L as m,aH as y,bB as V,E as o,h as f,D as k,I as C,ag as P,H as S,aw as h,J as z,K as A,ak as I,al as R,am as b,an as x,N as B,bi as D,R as T,b as u,V as F,ar as H}from"./index-K1XzZ2A_.js";import{V as N}from"./VImg-W4g71V9b.js";function J(a){let l=arguments.length>1&&arguments[1]!==void 0?arguments[1]:"div",e=arguments.length>2?arguments[2]:void 0;return m()({name:e??y(V(a.replace(/__/g,"-"))),props:{tag:{type:String,default:l},...o()},setup(t,r){let{slots:s}=r;return()=>{var n;return f(t.tag,{class:[a,t.class],style:t.style},(n=s.default)==null?void 0:n.call(s))}}})}const _=k({start:Boolean,end:Boolean,icon:C,image:String,text:String,...o(),...P(),...S(),...h(),...z(),...A(),...I({variant:"flat"})},"VAvatar"),K=m()({name:"VAvatar",props:_(),setup(a,l){let{slots:e}=l;const{themeClasses:t}=R(a),{colorClasses:r,colorStyles:s,variantClasses:n}=b(a),{densityClasses:c}=x(a),{roundedClasses:v}=B(a),{sizeClasses:g,sizeStyles:d}=D(a);return T(()=>u(a.tag,{class:["v-avatar",{"v-avatar--start":a.start,"v-avatar--end":a.end},t.value,r.value,c.value,v.value,g.value,n.value,a.class],style:[s.value,d.value,a.style]},{default:()=>{var i;return[a.image?u(N,{key:"image",src:a.image,alt:"",cover:!0},null):a.icon?u(F,{key:"icon",icon:a.icon},null):((i=e.default)==null?void 0:i.call(e))??a.text,H(!1,"v-avatar")]}})),{}}});export{K as V,J as c};
