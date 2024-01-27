import{L as g,E as y,at as M,R as f,b as n,D as A,I as u,ac as P,aa as k,ar as O,ad as w,ae as z,aJ as G,G as Q,af as X,H as $,a$ as q,J as U,K as W,ag as Y,b0 as Z,ah as ee,b1 as ae,ai as te,aj as ne,ak as de,al as ie,aK as le,Q as se,am as re,N as ce,b3 as ue,z as V,T as ve,aX as oe,aL as me,an as be}from"./index-o3g7j-pu.js";import{c as C,V as h}from"./VAvatar-rbGeQzgj.js";import{V as ke}from"./VImg-FqV0TNDi.js";const ge=g()({name:"VCardActions",props:y(),setup(e,i){let{slots:t}=i;return M({VBtn:{slim:!0,variant:"text"}}),f(()=>{var a;return n("div",{class:["v-card-actions",e.class],style:e.style},[(a=t.default)==null?void 0:a.call(t)])}),{}}}),ye=C("v-card-subtitle"),fe=C("v-card-title"),Ce=A({appendAvatar:String,appendIcon:u,prependAvatar:String,prependIcon:u,subtitle:[String,Number],title:[String,Number],...y(),...P()},"VCardItem"),pe=g()({name:"VCardItem",props:Ce(),setup(e,i){let{slots:t}=i;return f(()=>{var s;const a=!!(e.prependAvatar||e.prependIcon),v=!!(a||t.prepend),l=!!(e.appendAvatar||e.appendIcon),o=!!(l||t.append),m=!!(e.title!=null||t.title),b=!!(e.subtitle!=null||t.subtitle);return n("div",{class:["v-card-item",e.class],style:e.style},[v&&n("div",{key:"prepend",class:"v-card-item__prepend"},[t.prepend?n(k,{key:"prepend-defaults",disabled:!a,defaults:{VAvatar:{density:e.density,icon:e.prependIcon,image:e.prependAvatar}}},t.prepend):a&&n(h,{key:"prepend-avatar",density:e.density,icon:e.prependIcon,image:e.prependAvatar},null)]),n("div",{class:"v-card-item__content"},[m&&n(fe,{key:"title"},{default:()=>{var d;return[((d=t.title)==null?void 0:d.call(t))??e.title]}}),b&&n(ye,{key:"subtitle"},{default:()=>{var d;return[((d=t.subtitle)==null?void 0:d.call(t))??e.subtitle]}}),(s=t.default)==null?void 0:s.call(t)]),o&&n("div",{key:"append",class:"v-card-item__append"},[t.append?n(k,{key:"append-defaults",disabled:!l,defaults:{VAvatar:{density:e.density,icon:e.appendIcon,image:e.appendAvatar}}},t.append):l&&n(h,{key:"append-avatar",density:e.density,icon:e.appendIcon,image:e.appendAvatar},null)])])}),{}}}),Ie=C("v-card-text"),Ve=A({appendAvatar:String,appendIcon:u,disabled:Boolean,flat:Boolean,hover:Boolean,image:String,link:{type:Boolean,default:void 0},prependAvatar:String,prependIcon:u,ripple:{type:[Boolean,Object],default:!0},subtitle:[String,Number],text:[String,Number],title:[String,Number],...O(),...y(),...P(),...w(),...z(),...G(),...Q(),...X(),...$(),...q(),...U(),...W(),...Y({variant:"elevated"})},"VCard"),Se=g()({name:"VCard",directives:{Ripple:Z},props:Ve(),setup(e,i){let{attrs:t,slots:a}=i;const{themeClasses:v}=ee(e),{borderClasses:l}=ae(e),{colorClasses:o,colorStyles:m,variantClasses:b}=te(e),{densityClasses:s}=ne(e),{dimensionStyles:d}=de(e),{elevationClasses:S}=ie(e),{loaderClasses:x}=le(e),{locationStyles:L}=se(e),{positionClasses:T}=re(e),{roundedClasses:D}=ce(e),r=ue(e,t),B=V(()=>e.link!==!1&&r.isLink.value),c=V(()=>!e.disabled&&e.link!==!1&&(e.link||r.isClickable.value));return f(()=>{const _=B.value?"a":e.tag,N=!!(a.title||e.title!=null),R=!!(a.subtitle||e.subtitle!=null),E=N||R,j=!!(a.append||e.appendAvatar||e.appendIcon),F=!!(a.prepend||e.prependAvatar||e.prependIcon),H=!!(a.image||e.image),J=E||F||j,K=!!(a.text||e.text!=null);return ve(n(_,{class:["v-card",{"v-card--disabled":e.disabled,"v-card--flat":e.flat,"v-card--hover":e.hover&&!(e.disabled||e.flat),"v-card--link":c.value},v.value,l.value,o.value,s.value,S.value,x.value,T.value,D.value,b.value,e.class],style:[m.value,d.value,L.value,e.style],href:r.href.value,onClick:c.value&&r.navigate,tabindex:e.disabled?-1:void 0},{default:()=>{var p;return[H&&n("div",{key:"image",class:"v-card__image"},[a.image?n(k,{key:"image-defaults",disabled:!e.image,defaults:{VImg:{cover:!0,src:e.image}}},a.image):n(ke,{key:"image-img",cover:!0,src:e.image},null)]),n(me,{name:"v-card",active:!!e.loading,color:typeof e.loading=="boolean"?void 0:e.loading},{default:a.loader}),J&&n(pe,{key:"item",prependAvatar:e.prependAvatar,prependIcon:e.prependIcon,title:e.title,subtitle:e.subtitle,appendAvatar:e.appendAvatar,appendIcon:e.appendIcon},{default:a.item,prepend:a.prepend,title:a.title,subtitle:a.subtitle,append:a.append}),K&&n(Ie,{key:"text"},{default:()=>{var I;return[((I=a.text)==null?void 0:I.call(a))??e.text]}}),(p=a.default)==null?void 0:p.call(a),a.actions&&n(ge,null,{default:a.actions}),be(c.value,"v-card")]}}),[[oe("ripple"),c.value&&e.ripple]])}),{}}});export{Ie as V,Se as a,fe as b,pe as c,ye as d,ge as e};
