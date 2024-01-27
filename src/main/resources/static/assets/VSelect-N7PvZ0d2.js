import{m as Be,V as fe}from"./VTextField-hSvIFRYb.js";import{D as G,aF as De,E as oe,aT as _e,J as Ve,K as be,ag as Ce,L as le,ah as Se,aU as Fe,at as Le,v as Q,R as se,b as i,I as ne,aM as me,ar as Oe,ac as Ee,ae as Me,aY as He,H as ze,a$ as Ue,as as Ke,b0 as Ne,O as Pe,b1 as $e,ai as qe,aj as Ge,al as je,N as We,b2 as Xe,a7 as re,aZ as Ye,b3 as Je,z as T,T as he,aX as Ze,an as Qe,V as X,aa as ee,U as el,F as q,W as $,au as Ie,k as J,i as ll,y as z,ax as pe,r as Y,b4 as we,aA as ue,b5 as al,a9 as tl,a8 as Te,ad as nl,aO as ol,ak as sl,b6 as il,aC as te,b7 as ul,aP as cl,b8 as rl,B as dl,aG as vl,b9 as ge}from"./index-o3g7j-pu.js";import{u as fl}from"./form-ZbOCXVi8.js";import{f as ml}from"./forwardRefs-y8pOSn8h.js";import{m as hl,e as pl,u as gl,V as yl,a as kl,b as ye}from"./VMenu-cCGLK3cW.js";import{m as Vl}from"./VImg-FqV0TNDi.js";import{g as bl}from"./VOverlay-AuJcsXDy.js";import{V as Cl}from"./VCheckboxBtn-R6FB8e_f.js";import{b as Sl}from"./index-bUpWvayE.js";import{V as ke}from"./VAvatar-rbGeQzgj.js";const xe=Symbol.for("vuetify:v-chip-group"),Pl=G({column:Boolean,filter:Boolean,valueComparator:{type:Function,default:De},...oe(),..._e({selectedClass:"v-chip--selected"}),...Ve(),...be(),...Ce({variant:"tonal"})},"VChipGroup");le()({name:"VChipGroup",props:Pl(),emits:{"update:modelValue":e=>!0},setup(e,v){let{slots:a}=v;const{themeClasses:d}=Se(e),{isSelected:t,select:f,next:y,prev:u,selected:s}=Fe(e,xe);return Le({VChip:{color:Q(e,"color"),disabled:Q(e,"disabled"),filter:Q(e,"filter"),variant:Q(e,"variant")}}),se(()=>i(e.tag,{class:["v-chip-group",{"v-chip-group--column":e.column},d.value,e.class],style:e.style},{default:()=>{var p;return[(p=a.default)==null?void 0:p.call(a,{isSelected:t,select:f,next:y,prev:u,selected:s.value})]}})),{}}});const Il=G({activeClass:String,appendAvatar:String,appendIcon:ne,closable:Boolean,closeIcon:{type:ne,default:"$delete"},closeLabel:{type:String,default:"$vuetify.close"},draggable:Boolean,filter:Boolean,filterIcon:{type:String,default:"$complete"},label:Boolean,link:{type:Boolean,default:void 0},pill:Boolean,prependAvatar:String,prependIcon:ne,ripple:{type:[Boolean,Object],default:!0},text:String,modelValue:{type:Boolean,default:!0},onClick:me(),onClickOnce:me(),...Oe(),...oe(),...Ee(),...Me(),...He(),...ze(),...Ue(),...Ke(),...Ve({tag:"span"}),...be(),...Ce({variant:"tonal"})},"VChip"),wl=le()({name:"VChip",directives:{Ripple:Ne},props:Il(),emits:{"click:close":e=>!0,"update:modelValue":e=>!0,"group:selected":e=>!0,click:e=>!0},setup(e,v){let{attrs:a,emit:d,slots:t}=v;const{t:f}=Pe(),{borderClasses:y}=$e(e),{colorClasses:u,colorStyles:s,variantClasses:p}=qe(e),{densityClasses:x}=Ge(e),{elevationClasses:R}=je(e),{roundedClasses:r}=We(e),{sizeClasses:b}=Xe(e),{themeClasses:C}=Se(e),S=re(e,"modelValue"),n=Ye(e,xe,!1),g=Je(e,a),w=T(()=>e.link!==!1&&g.isLink.value),B=T(()=>!e.disabled&&e.link!==!1&&(!!n||e.link||g.isClickable.value)),D=T(()=>({"aria-label":f(e.closeLabel),onClick(m){m.stopPropagation(),S.value=!1,d("click:close",m)}}));function U(m){var F;d("click",m),B.value&&((F=g.navigate)==null||F.call(g,m),n==null||n.toggle())}function Z(m){(m.key==="Enter"||m.key===" ")&&(m.preventDefault(),U(m))}return()=>{const m=g.isLink.value?"a":e.tag,F=!!(e.appendIcon||e.appendAvatar),O=!!(F||t.append),E=!!(t.close||e.closable),M=!!(t.filter||e.filter)&&n,j=!!(e.prependIcon||e.prependAvatar),H=!!(j||t.prepend),K=!n||n.isSelected.value;return S.value&&he(i(m,{class:["v-chip",{"v-chip--disabled":e.disabled,"v-chip--label":e.label,"v-chip--link":B.value,"v-chip--filter":M,"v-chip--pill":e.pill},C.value,y.value,K?u.value:void 0,x.value,R.value,r.value,b.value,p.value,n==null?void 0:n.selectedClass.value,e.class],style:[K?s.value:void 0,e.style],disabled:e.disabled||void 0,draggable:e.draggable,href:g.href.value,tabindex:B.value?0:void 0,onClick:U,onKeydown:B.value&&!w.value&&Z},{default:()=>{var L;return[Qe(B.value,"v-chip"),M&&i(Sl,{key:"filter"},{default:()=>[he(i("div",{class:"v-chip__filter"},[t.filter?i(ee,{key:"filter-defaults",disabled:!e.filterIcon,defaults:{VIcon:{icon:e.filterIcon}}},t.filter):i(X,{key:"filter-icon",icon:e.filterIcon},null)]),[[el,n.isSelected.value]])]}),H&&i("div",{key:"prepend",class:"v-chip__prepend"},[t.prepend?i(ee,{key:"prepend-defaults",disabled:!j,defaults:{VAvatar:{image:e.prependAvatar,start:!0},VIcon:{icon:e.prependIcon,start:!0}}},t.prepend):i(q,null,[e.prependIcon&&i(X,{key:"prepend-icon",icon:e.prependIcon,start:!0},null),e.prependAvatar&&i(ke,{key:"prepend-avatar",image:e.prependAvatar,start:!0},null)])]),i("div",{class:"v-chip__content"},[((L=t.default)==null?void 0:L.call(t,{isSelected:n==null?void 0:n.isSelected.value,selectedClass:n==null?void 0:n.selectedClass.value,select:n==null?void 0:n.select,toggle:n==null?void 0:n.toggle,value:n==null?void 0:n.value.value,disabled:e.disabled}))??e.text]),O&&i("div",{key:"append",class:"v-chip__append"},[t.append?i(ee,{key:"append-defaults",disabled:!F,defaults:{VAvatar:{end:!0,image:e.appendAvatar},VIcon:{end:!0,icon:e.appendIcon}}},t.append):i(q,null,[e.appendIcon&&i(X,{key:"append-icon",end:!0,icon:e.appendIcon},null),e.appendAvatar&&i(ke,{key:"append-avatar",end:!0,image:e.appendAvatar},null)])]),E&&i("button",$({key:"close",class:"v-chip__close"},D.value),[t.close?i(ee,{key:"close-defaults",defaults:{VIcon:{icon:e.closeIcon,size:"x-small"}}},t.close):i(X,{key:"close-icon",icon:e.closeIcon,size:"x-small"},null)])]}}),[[Ze("ripple"),B.value&&e.ripple,null]])}}}),Tl=G({renderless:Boolean,...oe()},"VVirtualScrollItem"),xl=le()({name:"VVirtualScrollItem",inheritAttrs:!1,props:Tl(),emits:{"update:height":e=>!0},setup(e,v){let{attrs:a,emit:d,slots:t}=v;const{resizeRef:f,contentRect:y}=Ie(void 0,"border");J(()=>{var u;return(u=y.value)==null?void 0:u.height},u=>{u!=null&&d("update:height",u)}),se(()=>{var u,s;return e.renderless?i(q,null,[(u=t.default)==null?void 0:u.call(t,{itemRef:f})]):i("div",$({ref:f,class:["v-virtual-scroll__item",e.class],style:e.style},a),[(s=t.default)==null?void 0:s.call(t)])})}}),Al=-1,Rl=1,ce=100,Bl=G({itemHeight:{type:[Number,String],default:null},height:[Number,String]},"virtual");function Dl(e,v){const a=ll(),d=z(0);pe(()=>{d.value=parseFloat(e.itemHeight||0)});const t=z(0),f=z(Math.ceil((parseInt(e.height)||a.height.value)/(d.value||16))||1),y=z(0),u=z(0),s=Y(),p=Y();let x=0;const{resizeRef:R,contentRect:r}=Ie();pe(()=>{R.value=s.value});const b=T(()=>{var l;return s.value===document.documentElement?a.height.value:((l=r.value)==null?void 0:l.height)||parseInt(e.height)||0}),C=T(()=>!!(s.value&&p.value&&b.value&&d.value));let S=Array.from({length:v.value.length}),n=Array.from({length:v.value.length});const g=z(0);let w=-1;function B(l){return S[l]||d.value}const D=al(()=>{const l=performance.now();n[0]=0;const c=v.value.length;for(let P=1;P<=c-1;P++)n[P]=(n[P-1]||0)+B(P-1);g.value=Math.max(g.value,performance.now()-l)},g),U=J(C,l=>{l&&(U(),x=p.value.offsetTop,D.immediate(),L(),~w&&tl(()=>{Te&&window.requestAnimationFrame(()=>{ae(w),w=-1})}))});J(b,(l,c)=>{c&&L()}),we(()=>{D.clear()});function Z(l,c){const P=S[l],I=d.value;d.value=I?Math.min(d.value,c):c,(P!==c||I!==d.value)&&(S[l]=c,D())}function m(l){return l=ue(l,0,v.value.length-1),n[l]||0}function F(l){return _l(n,l)}let O=0,E=0,M=0;function j(){if(!s.value||!p.value)return;const l=s.value.scrollTop,c=performance.now();c-M>500?(E=Math.sign(l-O),x=p.value.offsetTop):E=l-O,O=l,M=c,L()}function H(){!s.value||!p.value||(E=0,M=0,L())}let K=-1;function L(){cancelAnimationFrame(K),K=requestAnimationFrame(ie)}function ie(){if(!s.value||!b.value)return;const l=O-x,c=Math.sign(E),P=Math.max(0,l-ce),I=ue(F(P),0,v.value.length),h=l+b.value+ce,k=ue(F(h)+1,I+1,v.value.length);if((c!==Al||I<t.value)&&(c!==Rl||k>f.value)){const V=m(t.value)-m(I),_=m(k)-m(f.value);Math.max(V,_)>ce?(t.value=I,f.value=k):(I<=0&&(t.value=I),k>=v.value.length&&(f.value=k))}y.value=m(t.value),u.value=m(v.value.length)-m(f.value)}function ae(l){const c=m(l);!s.value||l&&!c?w=l:s.value.scrollTop=c}const o=T(()=>v.value.slice(t.value,f.value).map((l,c)=>({raw:l,index:c+t.value})));return J(v,()=>{S=Array.from({length:v.value.length}),n=Array.from({length:v.value.length}),D.immediate(),L()},{deep:!0}),{containerRef:s,markerRef:p,computedItems:o,paddingTop:y,paddingBottom:u,scrollToIndex:ae,handleScroll:j,handleScrollend:H,handleItemResize:Z}}function _l(e,v){let a=e.length-1,d=0,t=0,f=null,y=-1;if(e[a]<v)return a;for(;d<=a;)if(t=d+a>>1,f=e[t],f>v)a=t-1;else if(f<v)y=t,d=t+1;else return f===v?t:d;return y}const Fl=G({items:{type:Array,default:()=>[]},renderless:Boolean,...Bl(),...oe(),...nl()},"VVirtualScroll"),Ll=le()({name:"VVirtualScroll",props:Fl(),setup(e,v){let{slots:a}=v;const d=ol("VVirtualScroll"),{dimensionStyles:t}=sl(e),{containerRef:f,markerRef:y,handleScroll:u,handleScrollend:s,handleItemResize:p,scrollToIndex:x,paddingTop:R,paddingBottom:r,computedItems:b}=Dl(e,Q(e,"items"));return il(()=>e.renderless,()=>{function C(){var g,w;const n=(arguments.length>0&&arguments[0]!==void 0?arguments[0]:!1)?"addEventListener":"removeEventListener";f.value===document.documentElement?(document[n]("scroll",u,{passive:!0}),document[n]("scrollend",s)):((g=f.value)==null||g[n]("scroll",u,{passive:!0}),(w=f.value)==null||w[n]("scrollend",s))}ul(()=>{f.value=bl(d.vnode.el,!0),C(!0)}),we(C)}),se(()=>{const C=b.value.map(S=>i(xl,{key:S.index,renderless:e.renderless,"onUpdate:height":n=>p(S.index,n)},{default:n=>{var g;return(g=a.default)==null?void 0:g.call(a,{item:S.raw,index:S.index,...n})}}));return e.renderless?i(q,null,[i("div",{ref:y,class:"v-virtual-scroll__spacer",style:{paddingTop:te(R.value)}},null),C,i("div",{class:"v-virtual-scroll__spacer",style:{paddingBottom:te(r.value)}},null)]):i("div",{ref:f,class:["v-virtual-scroll",e.class],onScrollPassive:u,onScrollend:s,style:[t.value,e.style]},[i("div",{ref:y,class:"v-virtual-scroll__container",style:{paddingTop:te(R.value),paddingBottom:te(r.value)}},[C])])}),{scrollToIndex:x}}});function Ol(e,v){const a=z(!1);let d;function t(u){cancelAnimationFrame(d),a.value=!0,d=requestAnimationFrame(()=>{d=requestAnimationFrame(()=>{a.value=!1})})}async function f(){await new Promise(u=>requestAnimationFrame(u)),await new Promise(u=>requestAnimationFrame(u)),await new Promise(u=>requestAnimationFrame(u)),await new Promise(u=>{if(a.value){const s=J(a,()=>{s(),u()})}else u()})}async function y(u){var x,R;if(u.key==="Tab"&&((x=v.value)==null||x.focus()),!["PageDown","PageUp","Home","End"].includes(u.key))return;const s=(R=e.value)==null?void 0:R.$el;if(!s)return;(u.key==="Home"||u.key==="End")&&s.scrollTo({top:u.key==="Home"?0:s.scrollHeight,behavior:"smooth"}),await f();const p=s.querySelectorAll(":scope > :not(.v-virtual-scroll__spacer)");if(u.key==="PageDown"||u.key==="Home"){const r=s.getBoundingClientRect().top;for(const b of p)if(b.getBoundingClientRect().top>=r){b.focus();break}}else{const r=s.getBoundingClientRect().bottom;for(const b of[...p].reverse())if(b.getBoundingClientRect().bottom<=r){b.focus();break}}}return{onListScroll:t,onListKeydown:y}}const El=G({chips:Boolean,closableChips:Boolean,closeText:{type:String,default:"$vuetify.close"},openText:{type:String,default:"$vuetify.open"},eager:Boolean,hideNoData:Boolean,hideSelected:Boolean,menu:Boolean,menuIcon:{type:ne,default:"$dropdown"},menuProps:{type:Object},multiple:Boolean,noDataText:{type:String,default:"$vuetify.noDataText"},openOnClear:Boolean,itemColor:String,...hl({itemChildren:!1})},"Select"),Ml=G({...El(),...cl(Be({modelValue:null,role:"combobox"}),["validationValue","dirty","appendInnerIcon"]),...Vl({transition:{component:pl}})},"VSelect"),Xl=le()({name:"VSelect",props:Ml(),emits:{"update:focused":e=>!0,"update:modelValue":e=>!0,"update:menu":e=>!0},setup(e,v){let{slots:a}=v;const{t:d}=Pe(),t=Y(),f=Y(),y=Y(),u=re(e,"menu"),s=T({get:()=>u.value,set:o=>{var l;u.value&&!o&&((l=f.value)!=null&&l.ΨopenChildren)||(u.value=o)}}),{items:p,transformIn:x,transformOut:R}=gl(e),r=re(e,"modelValue",[],o=>x(o===null?[null]:vl(o)),o=>{const l=R(o);return e.multiple?l:l[0]??null}),b=T(()=>typeof e.counterValue=="function"?e.counterValue(r.value):typeof e.counterValue=="number"?e.counterValue:r.value.length),C=fl(),S=T(()=>r.value.map(o=>o.value)),n=z(!1),g=T(()=>s.value?e.closeText:e.openText);let w="",B;const D=T(()=>e.hideSelected?p.value.filter(o=>!r.value.some(l=>l===o)):p.value),U=T(()=>e.hideNoData&&!p.value.length||e.readonly||(C==null?void 0:C.isReadonly.value)),Z=T(()=>{var o;return{...e.menuProps,activatorProps:{...((o=e.menuProps)==null?void 0:o.activatorProps)||{},"aria-haspopup":"listbox"}}}),m=Y(),{onListScroll:F,onListKeydown:O}=Ol(m,t);function E(o){e.openOnClear&&(s.value=!0)}function M(){U.value||(s.value=!s.value)}function j(o){var h,k;if(!o.key||e.readonly||C!=null&&C.isReadonly.value)return;["Enter"," ","ArrowDown","ArrowUp","Home","End"].includes(o.key)&&o.preventDefault(),["Enter","ArrowDown"," "].includes(o.key)&&(s.value=!0),["Escape","Tab"].includes(o.key)&&(s.value=!1),o.key==="Home"?(h=m.value)==null||h.focus("first"):o.key==="End"&&((k=m.value)==null||k.focus("last"));const l=1e3;function c(V){const _=V.key.length===1,A=!V.ctrlKey&&!V.metaKey&&!V.altKey;return _&&A}if(e.multiple||!c(o))return;const P=performance.now();P-B>l&&(w=""),w+=o.key.toLowerCase(),B=P;const I=p.value.find(V=>V.title.toLowerCase().startsWith(w));I!==void 0&&(r.value=[I])}function H(o){if(e.multiple){const l=r.value.findIndex(c=>e.valueComparator(c.value,o.value));if(l===-1)r.value=[...r.value,o];else{const c=[...r.value];c.splice(l,1),r.value=c}}else r.value=[o],s.value=!1}function K(o){var l;(l=m.value)!=null&&l.$el.contains(o.relatedTarget)||(s.value=!1)}function L(){var o;n.value&&((o=t.value)==null||o.focus())}function ie(o){n.value=!0}function ae(o){if(o==null)r.value=[];else if(ge(t.value,":autofill")||ge(t.value,":-webkit-autofill")){const l=p.value.find(c=>c.title===o);l&&H(l)}else t.value&&(t.value.value="")}return J(s,()=>{if(!e.hideSelected&&s.value&&r.value.length){const o=D.value.findIndex(l=>r.value.some(c=>e.valueComparator(c.value,l.value)));Te&&window.requestAnimationFrame(()=>{var l;o>=0&&((l=y.value)==null||l.scrollToIndex(o))})}}),se(()=>{const o=!!(e.chips||a.chip),l=!!(!e.hideNoData||D.value.length||a["prepend-item"]||a["append-item"]||a["no-data"]),c=r.value.length>0,P=fe.filterProps(e),I=c||!n.value&&e.label&&!e.persistentPlaceholder?void 0:e.placeholder;return i(fe,$({ref:t},P,{modelValue:r.value.map(h=>h.props.value).join(", "),"onUpdate:modelValue":ae,focused:n.value,"onUpdate:focused":h=>n.value=h,validationValue:r.externalValue,counterValue:b.value,dirty:c,class:["v-select",{"v-select--active-menu":s.value,"v-select--chips":!!e.chips,[`v-select--${e.multiple?"multiple":"single"}`]:!0,"v-select--selected":r.value.length,"v-select--selection-slot":!!a.selection},e.class],style:e.style,inputmode:"none",placeholder:I,"onClick:clear":E,"onMousedown:control":M,onBlur:K,onKeydown:j,"aria-label":d(g.value),title:d(g.value)}),{...a,default:()=>i(q,null,[i(yl,$({ref:f,modelValue:s.value,"onUpdate:modelValue":h=>s.value=h,activator:"parent",contentClass:"v-select__content",disabled:U.value,eager:e.eager,maxHeight:310,openOnClick:!1,closeOnContentClick:!1,transition:e.transition,onAfterLeave:L},Z.value),{default:()=>[l&&i(kl,{ref:m,selected:S.value,selectStrategy:e.multiple?"independent":"single-independent",onMousedown:h=>h.preventDefault(),onKeydown:O,onFocusin:ie,onScrollPassive:F,tabindex:"-1",color:e.itemColor??e.color},{default:()=>{var h,k,V;return[(h=a["prepend-item"])==null?void 0:h.call(a),!D.value.length&&!e.hideNoData&&(((k=a["no-data"])==null?void 0:k.call(a))??i(ye,{title:d(e.noDataText)},null)),i(Ll,{ref:y,renderless:!0,items:D.value},{default:_=>{var ve;let{item:A,index:W,itemRef:N}=_;const de=$(A.props,{ref:N,key:W,onClick:()=>H(A)});return((ve=a.item)==null?void 0:ve.call(a,{item:A,index:W,props:de}))??i(ye,$(de,{role:"option"}),{prepend:Ae=>{let{isSelected:Re}=Ae;return i(q,null,[e.multiple&&!e.hideSelected?i(Cl,{key:A.value,modelValue:Re,ripple:!1,tabindex:"-1"},null):void 0,A.props.prependIcon&&i(X,{icon:A.props.prependIcon},null)])}})}}),(V=a["append-item"])==null?void 0:V.call(a)]}})]}),r.value.map((h,k)=>{function V(N){N.stopPropagation(),N.preventDefault(),H(h)}const _={"onClick:close":V,onMousedown(N){N.preventDefault(),N.stopPropagation()},modelValue:!0,"onUpdate:modelValue":void 0},A=o?!!a.chip:!!a.selection,W=A?rl(o?a.chip({item:h,index:k,props:_}):a.selection({item:h,index:k})):void 0;if(!(A&&!W))return i("div",{key:h.value,class:"v-select__selection"},[o?a.chip?i(ee,{key:"chip-defaults",defaults:{VChip:{closable:e.closableChips,size:"small",text:h.title}}},{default:()=>[W]}):i(wl,$({key:"chip",closable:e.closableChips,size:"small",text:h.title,disabled:h.props.disabled},_),null):W??i("span",{class:"v-select__selection-text"},[h.title,e.multiple&&k<r.value.length-1&&i("span",{class:"v-select__selection-comma"},[dl(",")])])])})]),"append-inner":function(){var _;for(var h=arguments.length,k=new Array(h),V=0;V<h;V++)k[V]=arguments[V];return i(q,null,[(_=a["append-inner"])==null?void 0:_.call(a,...k),e.menuIcon?i(X,{class:"v-select__menu-icon",icon:e.menuIcon},null):void 0])}})}),ml({isFocused:n,menu:s,select:H},t)}});export{Xl as V,wl as a};
