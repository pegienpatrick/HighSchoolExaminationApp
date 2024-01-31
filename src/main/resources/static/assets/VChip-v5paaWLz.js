import{D as G,aJ as U,E as L,aW as Q,J as E,K as R,ak as z,L as T,al as w,aX as Y,ax as Z,v as r,R as ee,b as l,I as y,aP as B,av as ae,ag as le,ai as te,a$ as ne,H as se,bb as ie,aw as ce,bc as de,O as oe,be as ue,am as re,an as ve,ap as fe,N as me,bi as pe,a6 as ke,b0 as be,bd as he,z as C,T as _,a_ as ye,ar as Ce,V as v,a8 as f,U as Ve,F as x,W as Ie}from"./index-K1XzZ2A_.js";import{b as ge}from"./index-3OtdKGzE.js";import{V as D}from"./VAvatar-HVdCToNH.js";const F=Symbol.for("vuetify:v-chip-group"),Pe=G({column:Boolean,filter:Boolean,valueComparator:{type:Function,default:U},...L(),...Q({selectedClass:"v-chip--selected"}),...E(),...R(),...z({variant:"tonal"})},"VChipGroup");T()({name:"VChipGroup",props:Pe(),emits:{"update:modelValue":e=>!0},setup(e,m){let{slots:c}=m;const{themeClasses:o}=w(e),{isSelected:t,select:p,next:k,prev:b,selected:h}=Y(e,F);return Z({VChip:{color:r(e,"color"),disabled:r(e,"disabled"),filter:r(e,"filter"),variant:r(e,"variant")}}),ee(()=>l(e.tag,{class:["v-chip-group",{"v-chip-group--column":e.column},o.value,e.class],style:e.style},{default:()=>{var u;return[(u=c.default)==null?void 0:u.call(c,{isSelected:t,select:p,next:k,prev:b,selected:h.value})]}})),{}}});const Se=G({activeClass:String,appendAvatar:String,appendIcon:y,closable:Boolean,closeIcon:{type:y,default:"$delete"},closeLabel:{type:String,default:"$vuetify.close"},draggable:Boolean,filter:Boolean,filterIcon:{type:String,default:"$complete"},label:Boolean,link:{type:Boolean,default:void 0},pill:Boolean,prependAvatar:String,prependIcon:y,ripple:{type:[Boolean,Object],default:!0},text:String,modelValue:{type:Boolean,default:!0},onClick:B(),onClickOnce:B(),...ae(),...L(),...le(),...te(),...ne(),...se(),...ie(),...ce(),...E({tag:"span"}),...R(),...z({variant:"tonal"})},"VChip"),xe=T()({name:"VChip",directives:{Ripple:de},props:Se(),emits:{"click:close":e=>!0,"update:modelValue":e=>!0,"group:selected":e=>!0,click:e=>!0},setup(e,m){let{attrs:c,emit:o,slots:t}=m;const{t:p}=oe(),{borderClasses:k}=ue(e),{colorClasses:b,colorStyles:h,variantClasses:u}=re(e),{densityClasses:O}=ve(e),{elevationClasses:$}=fe(e),{roundedClasses:K}=me(e),{sizeClasses:M}=pe(e),{themeClasses:J}=w(e),V=ke(e,"modelValue"),a=be(e,F,!1),s=he(e,c),N=C(()=>e.link!==!1&&s.isLink.value),i=C(()=>!e.disabled&&e.link!==!1&&(!!a||e.link||s.isClickable.value)),W=C(()=>({"aria-label":p(e.closeLabel),onClick(n){n.stopPropagation(),V.value=!1,o("click:close",n)}}));function I(n){var d;o("click",n),i.value&&((d=s.navigate)==null||d.call(s,n),a==null||a.toggle())}function X(n){(n.key==="Enter"||n.key===" ")&&(n.preventDefault(),I(n))}return()=>{const n=s.isLink.value?"a":e.tag,d=!!(e.appendIcon||e.appendAvatar),j=!!(d||t.append),q=!!(t.close||e.closable),g=!!(t.filter||e.filter)&&a,P=!!(e.prependIcon||e.prependAvatar),H=!!(P||t.prepend),S=!a||a.isSelected.value;return V.value&&_(l(n,{class:["v-chip",{"v-chip--disabled":e.disabled,"v-chip--label":e.label,"v-chip--link":i.value,"v-chip--filter":g,"v-chip--pill":e.pill},J.value,k.value,S?b.value:void 0,O.value,$.value,K.value,M.value,u.value,a==null?void 0:a.selectedClass.value,e.class],style:[S?h.value:void 0,e.style],disabled:e.disabled||void 0,draggable:e.draggable,href:s.href.value,tabindex:i.value?0:void 0,onClick:I,onKeydown:i.value&&!N.value&&X},{default:()=>{var A;return[Ce(i.value,"v-chip"),g&&l(ge,{key:"filter"},{default:()=>[_(l("div",{class:"v-chip__filter"},[t.filter?l(f,{key:"filter-defaults",disabled:!e.filterIcon,defaults:{VIcon:{icon:e.filterIcon}}},t.filter):l(v,{key:"filter-icon",icon:e.filterIcon},null)]),[[Ve,a.isSelected.value]])]}),H&&l("div",{key:"prepend",class:"v-chip__prepend"},[t.prepend?l(f,{key:"prepend-defaults",disabled:!P,defaults:{VAvatar:{image:e.prependAvatar,start:!0},VIcon:{icon:e.prependIcon,start:!0}}},t.prepend):l(x,null,[e.prependIcon&&l(v,{key:"prepend-icon",icon:e.prependIcon,start:!0},null),e.prependAvatar&&l(D,{key:"prepend-avatar",image:e.prependAvatar,start:!0},null)])]),l("div",{class:"v-chip__content"},[((A=t.default)==null?void 0:A.call(t,{isSelected:a==null?void 0:a.isSelected.value,selectedClass:a==null?void 0:a.selectedClass.value,select:a==null?void 0:a.select,toggle:a==null?void 0:a.toggle,value:a==null?void 0:a.value.value,disabled:e.disabled}))??e.text]),j&&l("div",{key:"append",class:"v-chip__append"},[t.append?l(f,{key:"append-defaults",disabled:!d,defaults:{VAvatar:{end:!0,image:e.appendAvatar},VIcon:{end:!0,icon:e.appendIcon}}},t.append):l(x,null,[e.appendIcon&&l(v,{key:"append-icon",end:!0,icon:e.appendIcon},null),e.appendAvatar&&l(D,{key:"append-avatar",end:!0,image:e.appendAvatar},null)])]),q&&l("button",Ie({key:"close",class:"v-chip__close"},W.value),[t.close?l(f,{key:"close-defaults",defaults:{VIcon:{icon:e.closeIcon,size:"x-small"}}},t.close):l(v,{key:"close-icon",icon:e.closeIcon,size:"x-small"},null)])]}}),[[ye("ripple"),i.value&&e.ripple,null]])}}});export{xe as V};
