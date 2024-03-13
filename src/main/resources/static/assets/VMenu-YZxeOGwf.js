import{L as T,b as m,W as D,b7 as oe,D as L,aD as _,y as E,aC as $,b8 as M,r as A,a6 as z,z as p,b9 as Se,aR as et,aT as Ce,ba as tt,I as B,E as H,J as q,v as V,R as j,a8 as U,T as we,U as nt,aP as re,av as ke,ag as Ve,ah as Pe,ai as Ae,H as Ie,bb as at,K as Le,ak as xe,bc as lt,bd as st,k as Oe,al as Te,be as Be,am as it,an as Ee,ao as Me,ap as De,N as Fe,bf as ot,a_ as rt,ar as ut,F as ue,V as ce,P as ct,aJ as dt,aQ as I,aS as te,M as vt,ax as ft,bg as Q,a9 as mt,aa as de,bh as yt}from"./index-K1XzZ2A_.js";import{V as gt}from"./index-3OtdKGzE.js";import{u as pt}from"./ssrBoot-7VnEo6SR.js";import{M as ht}from"./VImg-W4g71V9b.js";import{c as _e,V as ve}from"./VAvatar-HVdCToNH.js";import{V as bt}from"./VDivider-7yUbEkf7.js";import{m as St,u as Ct,a as fe,V as me}from"./VOverlay-hefUuoVK.js";import{f as wt}from"./forwardRefs-y8pOSn8h.js";import{a as K,d as kt,s as ye,b as Vt,g as Pt,n as At}from"./easing-imumzmxr.js";const It=L({target:[Object,Array]},"v-dialog-transition"),Lt=T()({name:"VDialogTransition",props:It(),setup(e,s){let{slots:t}=s;const n={onBeforeEnter(l){l.style.pointerEvents="none",l.style.visibility="hidden"},async onEnter(l,a){var u;await new Promise(c=>requestAnimationFrame(c)),await new Promise(c=>requestAnimationFrame(c)),l.style.visibility="";const{x:i,y:o,sx:f,sy:y,speed:g}=pe(e.target,l),r=K(l,[{transform:`translate(${i}px, ${o}px) scale(${f}, ${y})`,opacity:0},{}],{duration:225*g,easing:kt});(u=ge(l))==null||u.forEach(c=>{K(c,[{opacity:0},{opacity:0,offset:.33},{}],{duration:225*2*g,easing:ye})}),r.finished.then(()=>a())},onAfterEnter(l){l.style.removeProperty("pointer-events")},onBeforeLeave(l){l.style.pointerEvents="none"},async onLeave(l,a){var u;await new Promise(c=>requestAnimationFrame(c));const{x:i,y:o,sx:f,sy:y,speed:g}=pe(e.target,l);K(l,[{},{transform:`translate(${i}px, ${o}px) scale(${f}, ${y})`,opacity:0}],{duration:125*g,easing:Vt}).finished.then(()=>a()),(u=ge(l))==null||u.forEach(c=>{K(c,[{},{opacity:0,offset:.2},{opacity:0}],{duration:125*2*g,easing:ye})})},onAfterLeave(l){l.style.removeProperty("pointer-events")}};return()=>e.target?m(oe,D({name:"dialog-transition"},n,{css:!1}),t):m(oe,{name:"dialog-transition"},t)}});function ge(e){var t;const s=(t=e.querySelector(":scope > .v-card, :scope > .v-sheet, :scope > .v-list"))==null?void 0:t.children;return s&&[...s]}function pe(e,s){const t=Pt(e),n=At(s),[l,a]=getComputedStyle(s).transformOrigin.split(" ").map(b=>parseFloat(b)),[i,o]=getComputedStyle(s).getPropertyValue("--v-overlay-anchor-origin").split(" ");let f=t.left+t.width/2;i==="left"||o==="left"?f-=t.width/2:(i==="right"||o==="right")&&(f+=t.width/2);let y=t.top+t.height/2;i==="top"||o==="top"?y-=t.height/2:(i==="bottom"||o==="bottom")&&(y+=t.height/2);const g=t.width/n.width,r=t.height/n.height,u=Math.max(1,g,r),c=g/u||0,v=r/u||0,d=n.width*n.height/(window.innerWidth*window.innerHeight),h=d>.12?Math.min(1.5,(d-.12)*10+1):1;return{x:f-(l+n.left),y:y-(a+n.top),sx:c,sy:v,speed:h}}const Z=Symbol.for("vuetify:list");function $e(){const e=_(Z,{hasPrepend:E(!1),updateHasPrepend:()=>null}),s={hasPrepend:E(!1),updateHasPrepend:t=>{t&&(s.hasPrepend.value=t)}};return $(Z,s),e}function je(){return _(Z,null)}const xt={open:e=>{let{id:s,value:t,opened:n,parents:l}=e;if(t){const a=new Set;a.add(s);let i=l.get(s);for(;i!=null;)a.add(i),i=l.get(i);return a}else return n.delete(s),n},select:()=>null},Ge={open:e=>{let{id:s,value:t,opened:n,parents:l}=e;if(t){let a=l.get(s);for(n.add(s);a!=null&&a!==s;)n.add(a),a=l.get(a);return n}else n.delete(s);return n},select:()=>null},Ot={open:Ge.open,select:e=>{let{id:s,value:t,opened:n,parents:l}=e;if(!t)return n;const a=[];let i=l.get(s);for(;i!=null;)a.push(i),i=l.get(i);return new Set(a)}},ne=e=>{const s={select:t=>{let{id:n,value:l,selected:a}=t;if(n=M(n),e&&!l){const i=Array.from(a.entries()).reduce((o,f)=>{let[y,g]=f;return g==="on"?[...o,y]:o},[]);if(i.length===1&&i[0]===n)return a}return a.set(n,l?"on":"off"),a},in:(t,n,l)=>{let a=new Map;for(const i of t||[])a=s.select({id:i,value:!0,selected:new Map(a),children:n,parents:l});return a},out:t=>{const n=[];for(const[l,a]of t.entries())a==="on"&&n.push(l);return n}};return s},Ne=e=>{const s=ne(e);return{select:n=>{let{selected:l,id:a,...i}=n;a=M(a);const o=l.has(a)?new Map([[a,l.get(a)]]):new Map;return s.select({...i,id:a,selected:o})},in:(n,l,a)=>{let i=new Map;return n!=null&&n.length&&(i=s.in(n.slice(0,1),l,a)),i},out:(n,l,a)=>s.out(n,l,a)}},Tt=e=>{const s=ne(e);return{select:n=>{let{id:l,selected:a,children:i,...o}=n;return l=M(l),i.has(l)?a:s.select({id:l,selected:a,children:i,...o})},in:s.in,out:s.out}},Bt=e=>{const s=Ne(e);return{select:n=>{let{id:l,selected:a,children:i,...o}=n;return l=M(l),i.has(l)?a:s.select({id:l,selected:a,children:i,...o})},in:s.in,out:s.out}},Et=e=>{const s={select:t=>{let{id:n,value:l,selected:a,children:i,parents:o}=t;n=M(n);const f=new Map(a),y=[n];for(;y.length;){const r=y.shift();a.set(r,l?"on":"off"),i.has(r)&&y.push(...i.get(r))}let g=o.get(n);for(;g;){const r=i.get(g),u=r.every(v=>a.get(v)==="on"),c=r.every(v=>!a.has(v)||a.get(v)==="off");a.set(g,u?"on":c?"off":"indeterminate"),g=o.get(g)}return e&&!l&&Array.from(a.entries()).reduce((u,c)=>{let[v,d]=c;return d==="on"?[...u,v]:u},[]).length===0?f:a},in:(t,n,l)=>{let a=new Map;for(const i of t||[])a=s.select({id:i,value:!0,selected:new Map(a),children:n,parents:l});return a},out:(t,n)=>{const l=[];for(const[a,i]of t.entries())i==="on"&&!n.has(a)&&l.push(a);return l}};return s},F=Symbol.for("vuetify:nested"),Re={id:E(),root:{register:()=>null,unregister:()=>null,parents:A(new Map),children:A(new Map),open:()=>null,openOnSelect:()=>null,select:()=>null,opened:A(new Set),selected:A(new Map),selectedValues:A([])}},Mt=L({selectStrategy:[String,Function],openStrategy:[String,Object],opened:Array,selected:Array,mandatory:Boolean},"nested"),Dt=e=>{let s=!1;const t=A(new Map),n=A(new Map),l=z(e,"opened",e.opened,r=>new Set(r),r=>[...r.values()]),a=p(()=>{if(typeof e.selectStrategy=="object")return e.selectStrategy;switch(e.selectStrategy){case"single-leaf":return Bt(e.mandatory);case"leaf":return Tt(e.mandatory);case"independent":return ne(e.mandatory);case"single-independent":return Ne(e.mandatory);case"classic":default:return Et(e.mandatory)}}),i=p(()=>{if(typeof e.openStrategy=="object")return e.openStrategy;switch(e.openStrategy){case"list":return Ot;case"single":return xt;case"multiple":default:return Ge}}),o=z(e,"selected",e.selected,r=>a.value.in(r,t.value,n.value),r=>a.value.out(r,t.value,n.value));Se(()=>{s=!0});function f(r){const u=[];let c=r;for(;c!=null;)u.unshift(c),c=n.value.get(c);return u}const y=et("nested"),g={id:E(),root:{opened:l,selected:o,selectedValues:p(()=>{const r=[];for(const[u,c]of o.value.entries())c==="on"&&r.push(u);return r}),register:(r,u,c)=>{u&&r!==u&&n.value.set(r,u),c&&t.value.set(r,[]),u!=null&&t.value.set(u,[...t.value.get(u)||[],r])},unregister:r=>{if(s)return;t.value.delete(r);const u=n.value.get(r);if(u){const c=t.value.get(u)??[];t.value.set(u,c.filter(v=>v!==r))}n.value.delete(r),l.value.delete(r)},open:(r,u,c)=>{y.emit("click:open",{id:r,value:u,path:f(r),event:c});const v=i.value.open({id:r,value:u,opened:new Set(l.value),children:t.value,parents:n.value,event:c});v&&(l.value=v)},openOnSelect:(r,u,c)=>{const v=i.value.select({id:r,value:u,selected:new Map(o.value),opened:new Set(l.value),children:t.value,parents:n.value,event:c});v&&(l.value=v)},select:(r,u,c)=>{y.emit("click:select",{id:r,value:u,path:f(r),event:c});const v=a.value.select({id:r,value:u,selected:new Map(o.value),children:t.value,parents:n.value,event:c});v&&(o.value=v),g.root.openOnSelect(r,u,c)},children:t,parents:n}};return $(F,g),g.root},Ke=(e,s)=>{const t=_(F,Re),n=Symbol(Ce()),l=p(()=>e.value!==void 0?e.value:n),a={...t,id:l,open:(i,o)=>t.root.open(l.value,i,o),openOnSelect:(i,o)=>t.root.openOnSelect(l.value,i,o),isOpen:p(()=>t.root.opened.value.has(l.value)),parent:p(()=>t.root.parents.value.get(l.value)),select:(i,o)=>t.root.select(l.value,i,o),isSelected:p(()=>t.root.selected.value.get(M(l.value))==="on"),isIndeterminate:p(()=>t.root.selected.value.get(l.value)==="indeterminate"),isLeaf:p(()=>!t.root.children.value.get(l.value)),isGroupActivator:t.isGroupActivator};return!t.isGroupActivator&&t.root.register(l.value,t.id.value,s),Se(()=>{!t.isGroupActivator&&t.root.unregister(l.value)}),s&&$(F,a),a},Ft=()=>{const e=_(F,Re);$(F,{...e,isGroupActivator:!0})},_t=tt({name:"VListGroupActivator",setup(e,s){let{slots:t}=s;return Ft(),()=>{var n;return(n=t.default)==null?void 0:n.call(t)}}}),$t=L({activeColor:String,baseColor:String,color:String,collapseIcon:{type:B,default:"$collapse"},expandIcon:{type:B,default:"$expand"},prependIcon:B,appendIcon:B,fluid:Boolean,subgroup:Boolean,title:String,value:null,...H(),...q()},"VListGroup"),he=T()({name:"VListGroup",props:$t(),setup(e,s){let{slots:t}=s;const{isOpen:n,open:l,id:a}=Ke(V(e,"value"),!0),i=p(()=>`v-list-group--id-${String(a.value)}`),o=je(),{isBooted:f}=pt();function y(c){l(!n.value,c)}const g=p(()=>({onClick:y,class:"v-list-group__header",id:i.value})),r=p(()=>n.value?e.collapseIcon:e.expandIcon),u=p(()=>({VListItem:{active:n.value,activeColor:e.activeColor,baseColor:e.baseColor,color:e.color,prependIcon:e.prependIcon||e.subgroup&&r.value,appendIcon:e.appendIcon||!e.subgroup&&r.value,title:e.title,value:e.value}}));return j(()=>m(e.tag,{class:["v-list-group",{"v-list-group--prepend":o==null?void 0:o.hasPrepend.value,"v-list-group--fluid":e.fluid,"v-list-group--subgroup":e.subgroup,"v-list-group--open":n.value},e.class],style:e.style},{default:()=>[t.activator&&m(U,{defaults:u.value},{default:()=>[m(_t,null,{default:()=>[t.activator({props:g.value,isOpen:n.value})]})]}),m(ht,{transition:{component:gt},disabled:!f.value},{default:()=>{var c;return[we(m("div",{class:"v-list-group__items",role:"group","aria-labelledby":i.value},[(c=t.default)==null?void 0:c.call(t)]),[[nt,n.value]])]}})]})),{}}}),jt=_e("v-list-item-subtitle"),Gt=_e("v-list-item-title"),Nt=L({active:{type:Boolean,default:void 0},activeClass:String,activeColor:String,appendAvatar:String,appendIcon:B,baseColor:String,disabled:Boolean,lines:String,link:{type:Boolean,default:void 0},nav:Boolean,prependAvatar:String,prependIcon:B,ripple:{type:[Boolean,Object],default:!0},slim:Boolean,subtitle:[String,Number],title:[String,Number],value:null,onClick:re(),onClickOnce:re(),...ke(),...H(),...Ve(),...Pe(),...Ae(),...Ie(),...at(),...q(),...Le(),...xe({variant:"text"})},"VListItem"),be=T()({name:"VListItem",directives:{Ripple:lt},props:Nt(),emits:{click:e=>!0},setup(e,s){let{attrs:t,slots:n,emit:l}=s;const a=st(e,t),i=p(()=>e.value===void 0?a.href.value:e.value),{select:o,isSelected:f,isIndeterminate:y,isGroupActivator:g,root:r,parent:u,openOnSelect:c}=Ke(i,!1),v=je(),d=p(()=>{var S;return e.active!==!1&&(e.active||((S=a.isActive)==null?void 0:S.value)||f.value)}),h=p(()=>e.link!==!1&&a.isLink.value),b=p(()=>!e.disabled&&e.link!==!1&&(e.link||a.isClickable.value||e.value!=null&&!!v)),C=p(()=>e.rounded||e.nav),w=p(()=>e.color??e.activeColor),x=p(()=>({color:d.value?w.value??e.baseColor:e.baseColor,variant:e.variant}));Oe(()=>{var S;return(S=a.isActive)==null?void 0:S.value},S=>{S&&u.value!=null&&r.open(u.value,!0),S&&c(S)},{immediate:!0});const{themeClasses:G}=Te(e),{borderClasses:W}=Be(e),{colorClasses:J,colorStyles:O,variantClasses:k}=it(x),{densityClasses:N}=Ee(e),{dimensionStyles:We}=Me(e),{elevationClasses:Je}=De(e),{roundedClasses:Xe}=Fe(C),Ye=p(()=>e.lines?`v-list-item--${e.lines}-line`:void 0),X=p(()=>({isActive:d.value,select:o,isSelected:f.value,isIndeterminate:y.value}));function ae(S){var R;l("click",S),!(g||!b.value)&&((R=a.navigate)==null||R.call(a,S),e.value!=null&&o(!f.value,S))}function ze(S){(S.key==="Enter"||S.key===" ")&&(S.preventDefault(),ae(S))}return j(()=>{const S=h.value?"a":e.tag,R=n.title||e.title!=null,Qe=n.subtitle||e.subtitle!=null,le=!!(e.appendAvatar||e.appendIcon),Ze=!!(le||n.append),se=!!(e.prependAvatar||e.prependIcon),Y=!!(se||n.prepend);return v==null||v.updateHasPrepend(Y),e.activeColor&&ot("active-color",["color","base-color"]),we(m(S,{class:["v-list-item",{"v-list-item--active":d.value,"v-list-item--disabled":e.disabled,"v-list-item--link":b.value,"v-list-item--nav":e.nav,"v-list-item--prepend":!Y&&(v==null?void 0:v.hasPrepend.value),"v-list-item--slim":e.slim,[`${e.activeClass}`]:e.activeClass&&d.value},G.value,W.value,J.value,N.value,Je.value,Ye.value,Xe.value,k.value,e.class],style:[O.value,We.value,e.style],href:a.href.value,tabindex:b.value?v?-2:0:void 0,onClick:ae,onKeydown:b.value&&!h.value&&ze},{default:()=>{var ie;return[ut(b.value||d.value,"v-list-item"),Y&&m("div",{key:"prepend",class:"v-list-item__prepend"},[n.prepend?m(U,{key:"prepend-defaults",disabled:!se,defaults:{VAvatar:{density:e.density,image:e.prependAvatar},VIcon:{density:e.density,icon:e.prependIcon},VListItemAction:{start:!0}}},{default:()=>{var P;return[(P=n.prepend)==null?void 0:P.call(n,X.value)]}}):m(ue,null,[e.prependAvatar&&m(ve,{key:"prepend-avatar",density:e.density,image:e.prependAvatar},null),e.prependIcon&&m(ce,{key:"prepend-icon",density:e.density,icon:e.prependIcon},null)]),m("div",{class:"v-list-item__spacer"},null)]),m("div",{class:"v-list-item__content","data-no-activator":""},[R&&m(Gt,{key:"title"},{default:()=>{var P;return[((P=n.title)==null?void 0:P.call(n,{title:e.title}))??e.title]}}),Qe&&m(jt,{key:"subtitle"},{default:()=>{var P;return[((P=n.subtitle)==null?void 0:P.call(n,{subtitle:e.subtitle}))??e.subtitle]}}),(ie=n.default)==null?void 0:ie.call(n,X.value)]),Ze&&m("div",{key:"append",class:"v-list-item__append"},[n.append?m(U,{key:"append-defaults",disabled:!le,defaults:{VAvatar:{density:e.density,image:e.appendAvatar},VIcon:{density:e.density,icon:e.appendIcon},VListItemAction:{end:!0}}},{default:()=>{var P;return[(P=n.append)==null?void 0:P.call(n,X.value)]}}):m(ue,null,[e.appendIcon&&m(ce,{key:"append-icon",density:e.density,icon:e.appendIcon},null),e.appendAvatar&&m(ve,{key:"append-avatar",density:e.density,image:e.appendAvatar},null)]),m("div",{class:"v-list-item__spacer"},null)])]}}),[[rt("ripple"),b.value&&e.ripple]])}),{}}}),Rt=L({color:String,inset:Boolean,sticky:Boolean,title:String,...H(),...q()},"VListSubheader"),Kt=T()({name:"VListSubheader",props:Rt(),setup(e,s){let{slots:t}=s;const{textColorClasses:n,textColorStyles:l}=ct(V(e,"color"));return j(()=>{const a=!!(t.default||e.title);return m(e.tag,{class:["v-list-subheader",{"v-list-subheader--inset":e.inset,"v-list-subheader--sticky":e.sticky},n.value,e.class],style:[{textColorStyles:l},e.style]},{default:()=>{var i;return[a&&m("div",{class:"v-list-subheader__text"},[((i=t.default)==null?void 0:i.call(t))??e.title])]}})}),{}}}),Ut=L({items:Array,returnObject:Boolean},"VListChildren"),Ue=T()({name:"VListChildren",props:Ut(),setup(e,s){let{slots:t}=s;return $e(),()=>{var n,l;return((n=t.default)==null?void 0:n.call(t))??((l=e.items)==null?void 0:l.map(a=>{var u,c;let{children:i,props:o,type:f,raw:y}=a;if(f==="divider")return((u=t.divider)==null?void 0:u.call(t,{props:o}))??m(bt,o,null);if(f==="subheader")return((c=t.subheader)==null?void 0:c.call(t,{props:o}))??m(Kt,o,null);const g={subtitle:t.subtitle?v=>{var d;return(d=t.subtitle)==null?void 0:d.call(t,{...v,item:y})}:void 0,prepend:t.prepend?v=>{var d;return(d=t.prepend)==null?void 0:d.call(t,{...v,item:y})}:void 0,append:t.append?v=>{var d;return(d=t.append)==null?void 0:d.call(t,{...v,item:y})}:void 0,title:t.title?v=>{var d;return(d=t.title)==null?void 0:d.call(t,{...v,item:y})}:void 0},r=he.filterProps(o);return i?m(he,D({value:o==null?void 0:o.value},r),{activator:v=>{let{props:d}=v;const h={...o,...d,value:e.returnObject?y:o.value};return t.header?t.header({props:h}):m(be,h,g)},default:()=>m(Ue,{items:i},t)}):t.item?t.item({props:o}):m(be,D(o,{value:e.returnObject?y:o.value}),g)}))}}}),Ht=L({items:{type:Array,default:()=>[]},itemTitle:{type:[String,Array,Function],default:"title"},itemValue:{type:[String,Array,Function],default:"value"},itemChildren:{type:[Boolean,String,Array,Function],default:"children"},itemProps:{type:[Boolean,String,Array,Function],default:"props"},returnObject:Boolean,valueComparator:{type:Function,default:dt}},"list-items");function ee(e,s){const t=I(s,e.itemTitle,s),n=I(s,e.itemValue,t),l=I(s,e.itemChildren),a=e.itemProps===!0?typeof s=="object"&&s!=null&&!Array.isArray(s)?"children"in s?te(s,["children"]):s:void 0:I(s,e.itemProps),i={title:t,value:n,...a};return{title:String(i.title??""),value:i.value,props:i,children:Array.isArray(l)?He(e,l):void 0,raw:s}}function He(e,s){const t=[];for(const n of s)t.push(ee(e,n));return t}function on(e){const s=p(()=>He(e,e.items)),t=p(()=>s.value.some(a=>a.value===null));function n(a){return t.value||(a=a.filter(i=>i!==null)),a.map(i=>e.returnObject&&typeof i=="string"?ee(e,i):s.value.find(o=>e.valueComparator(i,o.value))||ee(e,i))}function l(a){return e.returnObject?a.map(i=>{let{raw:o}=i;return o}):a.map(i=>{let{value:o}=i;return o})}return{items:s,transformIn:n,transformOut:l}}function qt(e){return typeof e=="string"||typeof e=="number"||typeof e=="boolean"}function Wt(e,s){const t=I(s,e.itemType,"item"),n=qt(s)?s:I(s,e.itemTitle),l=I(s,e.itemValue,void 0),a=I(s,e.itemChildren),i=e.itemProps===!0?te(s,["children"]):I(s,e.itemProps),o={title:n,value:l,...i};return{type:t,title:o.title,value:o.value,props:o,children:t==="item"&&a?qe(e,a):void 0,raw:s}}function qe(e,s){const t=[];for(const n of s)t.push(Wt(e,n));return t}function Jt(e){return{items:p(()=>qe(e,e.items))}}const Xt=L({baseColor:String,activeColor:String,activeClass:String,bgColor:String,disabled:Boolean,lines:{type:[Boolean,String],default:"one"},slim:Boolean,nav:Boolean,...Mt({selectStrategy:"single-leaf",openStrategy:"list"}),...ke(),...H(),...Ve(),...Pe(),...Ae(),itemType:{type:String,default:"type"},...Ht(),...Ie(),...q(),...Le(),...xe({variant:"text"})},"VList"),rn=T()({name:"VList",props:Xt(),emits:{"update:selected":e=>!0,"update:opened":e=>!0,"click:open":e=>!0,"click:select":e=>!0},setup(e,s){let{slots:t}=s;const{items:n}=Jt(e),{themeClasses:l}=Te(e),{backgroundColorClasses:a,backgroundColorStyles:i}=vt(V(e,"bgColor")),{borderClasses:o}=Be(e),{densityClasses:f}=Ee(e),{dimensionStyles:y}=Me(e),{elevationClasses:g}=De(e),{roundedClasses:r}=Fe(e),{open:u,select:c}=Dt(e),v=p(()=>e.lines?`v-list--${e.lines}-line`:void 0),d=V(e,"activeColor"),h=V(e,"baseColor"),b=V(e,"color");$e(),ft({VListGroup:{activeColor:d,baseColor:h,color:b},VListItem:{activeClass:V(e,"activeClass"),activeColor:d,baseColor:h,color:b,density:V(e,"density"),disabled:V(e,"disabled"),lines:V(e,"lines"),nav:V(e,"nav"),slim:V(e,"slim"),variant:V(e,"variant")}});const C=E(!1),w=A();function x(k){C.value=!0}function G(k){C.value=!1}function W(k){var N;!C.value&&!(k.relatedTarget&&((N=w.value)!=null&&N.contains(k.relatedTarget)))&&O()}function J(k){if(w.value){if(k.key==="ArrowDown")O("next");else if(k.key==="ArrowUp")O("prev");else if(k.key==="Home")O("first");else if(k.key==="End")O("last");else return;k.preventDefault()}}function O(k){if(w.value)return Q(w.value,k)}return j(()=>m(e.tag,{ref:w,class:["v-list",{"v-list--disabled":e.disabled,"v-list--nav":e.nav},l.value,a.value,o.value,f.value,g.value,v.value,r.value,e.class],style:[i.value,y.value,e.style],tabindex:e.disabled||C.value?-1:0,role:"listbox","aria-activedescendant":void 0,onFocusin:x,onFocusout:G,onFocus:W,onKeydown:J},{default:()=>[m(Ue,{items:n.value,returnObject:e.returnObject},t)]})),{open:u,select:c,focus:O}}}),Yt=L({id:String,...te(St({closeDelay:250,closeOnContentClick:!0,locationStrategy:"connected",openDelay:300,scrim:!1,scrollStrategy:"reposition",transition:{component:Lt}}),["absolute"])},"VMenu"),un=T()({name:"VMenu",props:Yt(),emits:{"update:modelValue":e=>!0},setup(e,s){let{slots:t}=s;const n=z(e,"modelValue"),{scopeId:l}=Ct(),a=Ce(),i=p(()=>e.id||`v-menu-${a}`),o=A(),f=_(fe,null),y=E(0);$(fe,{register(){++y.value},unregister(){--y.value},closeParents(){setTimeout(()=>{y.value||(n.value=!1,f==null||f.closeParents())},40)}});async function g(d){var C,w,x;const h=d.relatedTarget,b=d.target;await mt(),n.value&&h!==b&&((C=o.value)!=null&&C.contentEl)&&((w=o.value)!=null&&w.globalTop)&&![document,o.value.contentEl].includes(b)&&!o.value.contentEl.contains(b)&&((x=de(o.value.contentEl)[0])==null||x.focus())}Oe(n,d=>{d?(f==null||f.register(),document.addEventListener("focusin",g,{once:!0})):(f==null||f.unregister(),document.removeEventListener("focusin",g))});function r(){f==null||f.closeParents()}function u(d){var h,b,C;e.disabled||d.key==="Tab"&&(yt(de((h=o.value)==null?void 0:h.contentEl,!1),d.shiftKey?"prev":"next",x=>x.tabIndex>=0)||(n.value=!1,(C=(b=o.value)==null?void 0:b.activatorEl)==null||C.focus()))}function c(d){var b;if(e.disabled)return;const h=(b=o.value)==null?void 0:b.contentEl;h&&n.value?d.key==="ArrowDown"?(d.preventDefault(),Q(h,"next")):d.key==="ArrowUp"&&(d.preventDefault(),Q(h,"prev")):["ArrowDown","ArrowUp"].includes(d.key)&&(n.value=!0,d.preventDefault(),setTimeout(()=>setTimeout(()=>c(d))))}const v=p(()=>D({"aria-haspopup":"menu","aria-expanded":String(n.value),"aria-owns":i.value,onKeydown:c},e.activatorProps));return j(()=>{const d=me.filterProps(e);return m(me,D({ref:o,class:["v-menu",e.class],style:e.style},d,{modelValue:n.value,"onUpdate:modelValue":h=>n.value=h,absolute:!0,activatorProps:v.value,"onClick:outside":r,onKeydown:u},l),{activator:t.activator,default:function(){for(var h=arguments.length,b=new Array(h),C=0;C<h;C++)b[C]=arguments[C];return m(U,{root:"VMenu"},{default:()=>{var w;return[(w=t.default)==null?void 0:w.call(t,...b)]}})}})}),wt({id:i,ΨopenChildren:y},o)}});export{un as V,rn as a,be as b,Gt as c,jt as d,Lt as e,Ht as m,on as u};
