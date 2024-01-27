import{D as R,h as L,W as U,ba as X,E as N,ad as G,L as W,ak as J,R as D,b as r,z as h,bD as F,aO as K,y,r as Q,k as I,bw as Y,a9 as Z,bc as p,T as C,aX as ee,F as te,aC as ne,U as re}from"./index-o3g7j-pu.js";const ae=R({transition:{type:[Boolean,String,Object],default:"fade-transition",validator:e=>e!==!0}},"transition"),b=(e,l)=>{let{slots:i}=l;const{transition:n,disabled:c,...v}=e,{component:s=X,...a}=typeof n=="object"?n:{};return L(s,U(typeof n=="string"?{name:c?"":n}:a,v,{disabled:c}),i)};function ie(e){return{aspectStyles:h(()=>{const l=Number(e.aspectRatio);return l?{paddingBottom:String(1/l*100)+"%"}:void 0})}}const $=R({aspectRatio:[String,Number],contentClass:String,inline:Boolean,...N(),...G()},"VResponsive"),O=W()({name:"VResponsive",props:$(),setup(e,l){let{slots:i}=l;const{aspectStyles:n}=ie(e),{dimensionStyles:c}=J(e);return D(()=>{var v;return r("div",{class:["v-responsive",{"v-responsive--inline":e.inline},e.class],style:[c.value,e.style]},[r("div",{class:"v-responsive__sizer",style:n.value},null),(v=i.additional)==null?void 0:v.call(i),i.default&&r("div",{class:["v-responsive__content",e.contentClass]},[i.default()])])}),{}}});function se(e,l){if(!F)return;const i=l.modifiers||{},n=l.value,{handler:c,options:v}=typeof n=="object"?n:{handler:n,options:{}},s=new IntersectionObserver(function(){var g;let a=arguments.length>0&&arguments[0]!==void 0?arguments[0]:[],f=arguments.length>1?arguments[1]:void 0;const d=(g=e._observe)==null?void 0:g[l.instance.$.uid];if(!d)return;const o=a.some(S=>S.isIntersecting);c&&(!i.quiet||d.init)&&(!i.once||o||d.init)&&c(o,a,f),o&&i.once?E(e,l):d.init=!0},v);e._observe=Object(e._observe),e._observe[l.instance.$.uid]={init:!1,observer:s},s.observe(e)}function E(e,l){var n;const i=(n=e._observe)==null?void 0:n[l.instance.$.uid];i&&(i.observer.unobserve(e),delete e._observe[l.instance.$.uid])}const le={mounted:se,unmounted:E},oe=le,ue=R({alt:String,cover:Boolean,draggable:{type:[Boolean,String],default:void 0},eager:Boolean,gradient:String,lazySrc:String,options:{type:Object,default:()=>({root:void 0,rootMargin:void 0,threshold:void 0})},sizes:String,src:{type:[String,Object],default:""},crossorigin:String,referrerpolicy:String,srcset:String,position:String,...$(),...N(),...ae()},"VImg"),ve=W()({name:"VImg",directives:{intersect:oe},props:ue(),emits:{loadstart:e=>!0,load:e=>!0,error:e=>!0},setup(e,l){let{emit:i,slots:n}=l;const c=K("VImg"),v=y(""),s=Q(),a=y(e.eager?"loading":"idle"),f=y(),d=y(),o=h(()=>e.src&&typeof e.src=="object"?{src:e.src.src,srcset:e.srcset||e.src.srcset,lazySrc:e.lazySrc||e.src.lazySrc,aspect:Number(e.aspectRatio||e.src.aspect||0)}:{src:e.src,srcset:e.srcset,lazySrc:e.lazySrc,aspect:Number(e.aspectRatio||0)}),g=h(()=>o.value.aspect||f.value/d.value||0);I(()=>e.src,()=>{S(a.value!=="idle")}),I(g,(t,u)=>{!t&&u&&s.value&&_(s.value)}),Y(()=>S());function S(t){if(!(e.eager&&t)&&!(F&&!t&&!e.eager)){if(a.value="loading",o.value.lazySrc){const u=new Image;u.src=o.value.lazySrc,_(u,null)}o.value.src&&Z(()=>{var u;i("loadstart",((u=s.value)==null?void 0:u.currentSrc)||o.value.src),setTimeout(()=>{var m;if(!c.isUnmounted)if((m=s.value)!=null&&m.complete){if(s.value.naturalWidth||T(),a.value==="error")return;g.value||_(s.value,null),a.value==="loading"&&P()}else g.value||_(s.value),w()})})}}function P(){var t;c.isUnmounted||(w(),_(s.value),a.value="loaded",i("load",((t=s.value)==null?void 0:t.currentSrc)||o.value.src))}function T(){var t;c.isUnmounted||(a.value="error",i("error",((t=s.value)==null?void 0:t.currentSrc)||o.value.src))}function w(){const t=s.value;t&&(v.value=t.currentSrc||t.src)}let z=-1;p(()=>{clearTimeout(z)});function _(t){let u=arguments.length>1&&arguments[1]!==void 0?arguments[1]:100;const m=()=>{if(clearTimeout(z),c.isUnmounted)return;const{naturalHeight:k,naturalWidth:B}=t;k||B?(f.value=B,d.value=k):!t.complete&&a.value==="loading"&&u!=null?z=window.setTimeout(m,u):(t.currentSrc.endsWith(".svg")||t.currentSrc.startsWith("data:image/svg+xml"))&&(f.value=1,d.value=1)};m()}const V=h(()=>({"v-img__img--cover":e.cover,"v-img__img--contain":!e.cover})),M=()=>{var m;if(!o.value.src||a.value==="idle")return null;const t=r("img",{class:["v-img__img",V.value],style:{objectPosition:e.position},src:o.value.src,srcset:o.value.srcset,alt:e.alt,crossorigin:e.crossorigin,referrerpolicy:e.referrerpolicy,draggable:e.draggable,sizes:e.sizes,ref:s,onLoad:P,onError:T},null),u=(m=n.sources)==null?void 0:m.call(n);return r(b,{transition:e.transition,appear:!0},{default:()=>[C(u?r("picture",{class:"v-img__picture"},[u,t]):t,[[re,a.value==="loaded"]])]})},q=()=>r(b,{transition:e.transition},{default:()=>[o.value.lazySrc&&a.value!=="loaded"&&r("img",{class:["v-img__img","v-img__img--preload",V.value],style:{objectPosition:e.position},src:o.value.lazySrc,alt:e.alt,crossorigin:e.crossorigin,referrerpolicy:e.referrerpolicy,draggable:e.draggable},null)]}),x=()=>n.placeholder?r(b,{transition:e.transition,appear:!0},{default:()=>[(a.value==="loading"||a.value==="error"&&!n.error)&&r("div",{class:"v-img__placeholder"},[n.placeholder()])]}):null,A=()=>n.error?r(b,{transition:e.transition,appear:!0},{default:()=>[a.value==="error"&&r("div",{class:"v-img__error"},[n.error()])]}):null,H=()=>e.gradient?r("div",{class:"v-img__gradient",style:{backgroundImage:`linear-gradient(${e.gradient})`}},null):null,j=y(!1);{const t=I(g,u=>{u&&(requestAnimationFrame(()=>{requestAnimationFrame(()=>{j.value=!0})}),t())})}return D(()=>{const t=O.filterProps(e);return C(r(O,U({class:["v-img",{"v-img--booting":!j.value},e.class],style:[{width:ne(e.width==="auto"?f.value:e.width)},e.style]},t,{aspectRatio:g.value,"aria-label":e.alt,role:e.alt?"img":void 0}),{additional:()=>r(te,null,[r(M,null,null),r(q,null,null),r(H,null,null),r(x,null,null),r(A,null,null)]),default:n.default}),[[ee("intersect"),{handler:S,options:e.options},null,{once:!0}]])}),{currentSrc:v,image:s,state:a,naturalWidth:f,naturalHeight:d}}});export{oe as I,b as M,ve as V,ae as m};
