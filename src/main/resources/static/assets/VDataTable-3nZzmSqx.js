import{aZ as lt,r as A,by as nt,D as T,I as R,aM as rt,E as ut,al as st,an as it,H as ot,aA as ct,J as dt,K as ft,ap as vt,L as E,a7 as M,O as ee,ad as gt,aq as mt,i as yt,y as bt,aV as se,bo as ht,z as k,bz as X,v as V,R as G,b as f,a2 as $,W as _,bA as he,aa as pe,ae as oe,aH as j,aG as H,aj as re,bB as pt,ai as N,ay as xt,bC as Pt,aS as De,a6 as Q,bD as Y,bE as Z,bh as St,bi as kt,M as wt,bj as It,F as J,V as Vt,B as xe,a3 as Pe,t as Dt,aL as ue,aT as q,aE as Tt,k as Ft,u as U}from"./index-SGO5OOPy.js";import{V as Lt}from"./VSelect-XRxo3SYo.js";import{V as ce}from"./VCheckboxBtn-N82T6j1u.js";import{m as _t,V as Se}from"./VTable-GWFtDMSE.js";import{V as Bt}from"./VDivider-J_lD5GQp.js";function ke(e,l,a){return Object.keys(e).filter(t=>lt(t)&&t.endsWith(l)).reduce((t,n)=>(t[n.slice(0,-l.length)]=r=>e[n](r,a(r)),t),{})}function Ct(){const e=A([]);nt(()=>e.value=[]);function l(a,t){e.value[t]=a}return{refs:e,updateRef:l}}const At=T({activeColor:String,start:{type:[Number,String],default:1},modelValue:{type:Number,default:e=>e.start},disabled:Boolean,length:{type:[Number,String],default:1,validator:e=>e%1===0},totalVisible:[Number,String],firstIcon:{type:R,default:"$first"},prevIcon:{type:R,default:"$prev"},nextIcon:{type:R,default:"$next"},lastIcon:{type:R,default:"$last"},ariaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.root"},pageAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.page"},currentPageAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.currentPage"},firstAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.first"},previousAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.previous"},nextAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.next"},lastAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.last"},ellipsis:{type:String,default:"..."},showFirstLastPage:Boolean,...rt(),...ut(),...st(),...it(),...ot(),...ct(),...dt({tag:"nav"}),...ft(),...vt({variant:"text"})},"VPagination"),Ot=E()({name:"VPagination",props:At(),emits:{"update:modelValue":e=>!0,first:e=>!0,prev:e=>!0,next:e=>!0,last:e=>!0},setup(e,l){let{slots:a,emit:t}=l;const n=M(e,"modelValue"),{t:r,n:d}=ee(),{isRtl:s}=gt(),{themeClasses:u}=mt(e),{width:c}=yt(),o=bt(-1);se(void 0,{scoped:!0});const{resizeRef:v}=ht(h=>{if(!h.length)return;const{target:S,contentRect:w}=h[0],D=S.querySelector(".v-pagination__list > *");if(!D)return;const L=w.width,O=D.offsetWidth+parseFloat(getComputedStyle(D).marginRight)*2;o.value=b(L,O)}),i=k(()=>parseInt(e.length,10)),g=k(()=>parseInt(e.start,10)),p=k(()=>e.totalVisible!=null?parseInt(e.totalVisible,10):o.value>=0?o.value:b(c.value,58));function b(h,S){const w=e.showFirstLastPage?5:3;return Math.max(0,Math.floor(+((h-S*w)/S).toFixed(2)))}const y=k(()=>{if(i.value<=0||isNaN(i.value)||i.value>Number.MAX_SAFE_INTEGER)return[];if(p.value<=0)return[];if(p.value===1)return[n.value];if(i.value<=p.value)return X(i.value,g.value);const h=p.value%2===0,S=h?p.value/2:Math.floor(p.value/2),w=h?S:S+1,D=i.value-S;if(w-n.value>=0)return[...X(Math.max(1,p.value-1),g.value),e.ellipsis,i.value];if(n.value-D>=(h?1:0)){const L=p.value-1,O=i.value-L+g.value;return[g.value,e.ellipsis,...X(L,O)]}else{const L=Math.max(1,p.value-3),O=L===1?n.value:n.value-Math.ceil(L/2)+g.value;return[g.value,e.ellipsis,...X(L,O),e.ellipsis,i.value]}});function m(h,S,w){h.preventDefault(),n.value=S,w&&t(w,S)}const{refs:P,updateRef:I}=Ct();se({VPaginationBtn:{color:V(e,"color"),border:V(e,"border"),density:V(e,"density"),size:V(e,"size"),variant:V(e,"variant"),rounded:V(e,"rounded"),elevation:V(e,"elevation")}});const x=k(()=>y.value.map((h,S)=>{const w=D=>I(D,S);if(typeof h=="string")return{isActive:!1,key:`ellipsis-${S}`,page:h,props:{ref:w,ellipsis:!0,icon:!0,disabled:!0}};{const D=h===n.value;return{isActive:D,key:h,page:d(h),props:{ref:w,ellipsis:!1,icon:!0,disabled:!!e.disabled||+e.length<2,color:D?e.activeColor:e.color,ariaCurrent:D,ariaLabel:r(D?e.currentPageAriaLabel:e.pageAriaLabel,h),onClick:L=>m(L,h)}}}})),F=k(()=>{const h=!!e.disabled||n.value<=g.value,S=!!e.disabled||n.value>=g.value+i.value-1;return{first:e.showFirstLastPage?{icon:s.value?e.lastIcon:e.firstIcon,onClick:w=>m(w,g.value,"first"),disabled:h,ariaLabel:r(e.firstAriaLabel),ariaDisabled:h}:void 0,prev:{icon:s.value?e.nextIcon:e.prevIcon,onClick:w=>m(w,n.value-1,"prev"),disabled:h,ariaLabel:r(e.previousAriaLabel),ariaDisabled:h},next:{icon:s.value?e.prevIcon:e.nextIcon,onClick:w=>m(w,n.value+1,"next"),disabled:S,ariaLabel:r(e.nextAriaLabel),ariaDisabled:S},last:e.showFirstLastPage?{icon:s.value?e.firstIcon:e.lastIcon,onClick:w=>m(w,g.value+i.value-1,"last"),disabled:S,ariaLabel:r(e.lastAriaLabel),ariaDisabled:S}:void 0}});function C(){var S;const h=n.value-g.value;(S=P.value[h])==null||S.$el.focus()}function K(h){h.key===he.left&&!e.disabled&&n.value>+e.start?(n.value=n.value-1,pe(C)):h.key===he.right&&!e.disabled&&n.value<g.value+i.value-1&&(n.value=n.value+1,pe(C))}return G(()=>f(e.tag,{ref:v,class:["v-pagination",u.value,e.class],style:e.style,role:"navigation","aria-label":r(e.ariaLabel),onKeydown:K,"data-test":"v-pagination-root"},{default:()=>[f("ul",{class:"v-pagination__list"},[e.showFirstLastPage&&f("li",{key:"first",class:"v-pagination__first","data-test":"v-pagination-first"},[a.first?a.first(F.value.first):f($,_({_as:"VPaginationBtn"},F.value.first),null)]),f("li",{key:"prev",class:"v-pagination__prev","data-test":"v-pagination-prev"},[a.prev?a.prev(F.value.prev):f($,_({_as:"VPaginationBtn"},F.value.prev),null)]),x.value.map((h,S)=>f("li",{key:h.key,class:["v-pagination__item",{"v-pagination__item--is-active":h.isActive}],"data-test":"v-pagination-item"},[a.item?a.item(h):f($,_({_as:"VPaginationBtn"},h.props),{default:()=>[h.page]})])),f("li",{key:"next",class:"v-pagination__next","data-test":"v-pagination-next"},[a.next?a.next(F.value.next):f($,_({_as:"VPaginationBtn"},F.value.next),null)]),e.showFirstLastPage&&f("li",{key:"last",class:"v-pagination__last","data-test":"v-pagination-last"},[a.last?a.last(F.value.last):f($,_({_as:"VPaginationBtn"},F.value.last),null)])])]})),{}}}),$t=T({page:{type:[Number,String],default:1},itemsPerPage:{type:[Number,String],default:10}},"DataTable-paginate"),Te=Symbol.for("vuetify:data-table-pagination");function Mt(e){const l=M(e,"page",void 0,t=>+(t??1)),a=M(e,"itemsPerPage",void 0,t=>+(t??10));return{page:l,itemsPerPage:a}}function Et(e){const{page:l,itemsPerPage:a,itemsLength:t}=e,n=k(()=>a.value===-1?0:a.value*(l.value-1)),r=k(()=>a.value===-1?t.value:Math.min(t.value,n.value+a.value)),d=k(()=>a.value===-1||t.value===0?1:Math.ceil(t.value/a.value));oe(()=>{l.value>d.value&&(l.value=d.value)});function s(i){a.value=i,l.value=1}function u(){l.value=re(l.value+1,1,d.value)}function c(){l.value=re(l.value-1,1,d.value)}function o(i){l.value=re(i,1,d.value)}const v={page:l,itemsPerPage:a,startIndex:n,stopIndex:r,pageCount:d,itemsLength:t,nextPage:u,prevPage:c,setPage:o,setItemsPerPage:s};return j(Te,v),v}function Rt(){const e=H(Te);if(!e)throw new Error("Missing pagination!");return e}function Nt(e){const{items:l,startIndex:a,stopIndex:t,itemsPerPage:n}=e;return{paginatedItems:k(()=>n.value<=0?l.value:l.value.slice(a.value,t.value))}}const Fe=T({prevIcon:{type:String,default:"$prev"},nextIcon:{type:String,default:"$next"},firstIcon:{type:String,default:"$first"},lastIcon:{type:String,default:"$last"},itemsPerPageText:{type:String,default:"$vuetify.dataFooter.itemsPerPageText"},pageText:{type:String,default:"$vuetify.dataFooter.pageText"},firstPageLabel:{type:String,default:"$vuetify.dataFooter.firstPage"},prevPageLabel:{type:String,default:"$vuetify.dataFooter.prevPage"},nextPageLabel:{type:String,default:"$vuetify.dataFooter.nextPage"},lastPageLabel:{type:String,default:"$vuetify.dataFooter.lastPage"},itemsPerPageOptions:{type:Array,default:()=>[{value:10,title:"10"},{value:25,title:"25"},{value:50,title:"50"},{value:100,title:"100"},{value:-1,title:"$vuetify.dataFooter.itemsPerPageAll"}]},showCurrentPage:Boolean},"VDataTableFooter"),we=E()({name:"VDataTableFooter",props:Fe(),setup(e,l){let{slots:a}=l;const{t}=ee(),{page:n,pageCount:r,startIndex:d,stopIndex:s,itemsLength:u,itemsPerPage:c,setItemsPerPage:o}=Rt(),v=k(()=>e.itemsPerPageOptions.map(i=>typeof i=="number"?{value:i,title:i===-1?t("$vuetify.dataFooter.itemsPerPageAll"):String(i)}:{...i,title:t(i.title)}));return G(()=>{var i;return f("div",{class:"v-data-table-footer"},[(i=a.prepend)==null?void 0:i.call(a),f("div",{class:"v-data-table-footer__items-per-page"},[f("span",null,[t(e.itemsPerPageText)]),f(Lt,{items:v.value,modelValue:c.value,"onUpdate:modelValue":g=>o(Number(g)),density:"compact",variant:"outlined","hide-details":!0},null)]),f("div",{class:"v-data-table-footer__info"},[f("div",null,[t(e.pageText,u.value?d.value+1:0,s.value,u.value)])]),f("div",{class:"v-data-table-footer__pagination"},[f(Ot,{modelValue:n.value,"onUpdate:modelValue":g=>n.value=g,density:"comfortable","first-aria-label":e.firstPageLabel,"last-aria-label":e.lastPageLabel,length:r.value,"next-aria-label":e.nextPageLabel,"previous-aria-label":e.prevPageLabel,rounded:!0,"show-first-last-page":!0,"total-visible":e.showCurrentPage?1:0,variant:"plain"},null)])])}),{}}}),de=pt({align:{type:String,default:"start"},fixed:Boolean,fixedOffset:[Number,String],height:[Number,String],lastFixed:Boolean,noPadding:Boolean,tag:String,width:[Number,String]},(e,l)=>{let{slots:a}=l;const t=e.tag??"td";return f(t,{class:["v-data-table__td",{"v-data-table-column--fixed":e.fixed,"v-data-table-column--last-fixed":e.lastFixed,"v-data-table-column--no-padding":e.noPadding},`v-data-table-column--align-${e.align}`],style:{height:N(e.height),width:N(e.width),left:N(e.fixedOffset||null)}},{default:()=>{var n;return[(n=a.default)==null?void 0:n.call(a)]}})}),Gt=T({headers:Array},"DataTable-header"),Le=Symbol.for("vuetify:data-table-headers"),_e={title:"",sortable:!1},jt={..._e,width:48};function Ht(){const l=(arguments.length>0&&arguments[0]!==void 0?arguments[0]:[]).map(a=>({element:a,priority:0}));return{enqueue:(a,t)=>{let n=!1;for(let r=0;r<l.length;r++)if(l[r].priority>t){l.splice(r,0,{element:a,priority:t}),n=!0;break}n||l.push({element:a,priority:t})},size:()=>l.length,count:()=>{let a=0;if(!l.length)return 0;const t=Math.floor(l[0].priority);for(let n=0;n<l.length;n++)Math.floor(l[n].priority)===t&&(a+=1);return a},dequeue:()=>l.shift()}}function ie(e){let l=arguments.length>1&&arguments[1]!==void 0?arguments[1]:[];if(!e.children)l.push(e);else for(const a of e.children)ie(a,l);return l}function Be(e){let l=arguments.length>1&&arguments[1]!==void 0?arguments[1]:new Set;for(const a of e)a.key&&l.add(a.key),a.children&&Be(a.children,l);return l}function Kt(e){if(e.key){if(e.key==="data-table-group")return _e;if(["data-table-expand","data-table-select"].includes(e.key))return jt}}function fe(e){let l=arguments.length>1&&arguments[1]!==void 0?arguments[1]:0;return e.children?Math.max(l,...e.children.map(a=>fe(a,l+1))):l}function zt(e){let l=!1;function a(r){let d=arguments.length>1&&arguments[1]!==void 0?arguments[1]:!1;if(r)if(d&&(r.fixed=!0),r.fixed)if(r.children)for(let s=r.children.length-1;s>=0;s--)a(r.children[s],!0);else l?isNaN(+r.width)&&Pt(`Multiple fixed columns should have a static width (key: ${r.key})`):r.lastFixed=!0,l=!0;else if(r.children)for(let s=r.children.length-1;s>=0;s--)a(r.children[s]);else l=!1}for(let r=e.length-1;r>=0;r--)a(e[r]);function t(r){let d=arguments.length>1&&arguments[1]!==void 0?arguments[1]:0;if(!r)return d;if(r.children){r.fixedOffset=d;for(const s of r.children)d=t(s,d)}else r.fixed&&(r.fixedOffset=d,d+=parseFloat(r.width||"0")||0);return d}let n=0;for(const r of e)n=t(r,n)}function Wt(e,l){const a=[];let t=0;const n=Ht(e);for(;n.size()>0;){let d=n.count();const s=[];let u=1;for(;d>0;){const{element:c,priority:o}=n.dequeue(),v=l-t-fe(c);if(s.push({...c,rowspan:v??1,colspan:c.children?ie(c).length:1}),c.children)for(const i of c.children){const g=o%1+u/Math.pow(10,t+2);n.enqueue(i,t+v+g)}u+=1,d-=1}t+=1,a.push(s)}return{columns:e.map(d=>ie(d)).flat(),headers:a}}function Ce(e){const l=[];for(const a of e){const t={...Kt(a),...a},n=t.key??(typeof t.value=="string"?t.value:null),r=t.value??n??null,d={...t,key:n,value:r,sortable:t.sortable??(t.key!=null||!!t.sort),children:t.children?Ce(t.children):void 0};l.push(d)}return l}function Ut(e,l){const a=A([]),t=A([]),n=A(),r=A();oe(()=>{var p,b,y;const u=(e.headers||Object.keys(e.items[0]??{}).map(m=>({key:m,title:xt(m)}))).slice(),c=Be(u);(p=l==null?void 0:l.groupBy)!=null&&p.value.length&&!c.has("data-table-group")&&u.unshift({key:"data-table-group",title:"Group"}),(b=l==null?void 0:l.showSelect)!=null&&b.value&&!c.has("data-table-select")&&u.unshift({key:"data-table-select"}),(y=l==null?void 0:l.showExpand)!=null&&y.value&&!c.has("data-table-expand")&&u.push({key:"data-table-expand"});const o=Ce(u);zt(o);const v=Math.max(...o.map(m=>fe(m)))+1,i=Wt(o,v);a.value=i.headers,t.value=i.columns;const g=i.headers.flat(1);n.value=g.reduce((m,P)=>(P.sortable&&P.key&&P.sort&&(m[P.key]=P.sort),m),{}),r.value=g.reduce((m,P)=>(P.key&&P.filter&&(m[P.key]=P.filter),m),{})});const d={headers:a,columns:t,sortFunctions:n,filterFunctions:r};return j(Le,d),d}function te(){const e=H(Le);if(!e)throw new Error("Missing headers!");return e}const qt={showSelectAll:!1,allSelected:()=>[],select:e=>{var t;let{items:l,value:a}=e;return new Set(a?[(t=l[0])==null?void 0:t.value]:[])},selectAll:e=>{let{selected:l}=e;return l}},Ae={showSelectAll:!0,allSelected:e=>{let{currentPage:l}=e;return l},select:e=>{let{items:l,value:a,selected:t}=e;for(const n of l)a?t.add(n.value):t.delete(n.value);return t},selectAll:e=>{let{value:l,currentPage:a,selected:t}=e;return Ae.select({items:a,value:l,selected:t})}},Oe={showSelectAll:!0,allSelected:e=>{let{allItems:l}=e;return l},select:e=>{let{items:l,value:a,selected:t}=e;for(const n of l)a?t.add(n.value):t.delete(n.value);return t},selectAll:e=>{let{value:l,allItems:a,selected:t}=e;return Oe.select({items:a,value:l,selected:t})}},Qt=T({showSelect:Boolean,selectStrategy:{type:[String,Object],default:"page"},modelValue:{type:Array,default:()=>[]},valueComparator:{type:Function,default:De}},"DataTable-select"),$e=Symbol.for("vuetify:data-table-selection");function Jt(e,l){let{allItems:a,currentPage:t}=l;const n=M(e,"modelValue",e.modelValue,y=>new Set(Q(y).map(m=>{var P;return((P=a.value.find(I=>e.valueComparator(m,I.value)))==null?void 0:P.value)??m})),y=>[...y.values()]),r=k(()=>a.value.filter(y=>y.selectable)),d=k(()=>t.value.filter(y=>y.selectable)),s=k(()=>{if(typeof e.selectStrategy=="object")return e.selectStrategy;switch(e.selectStrategy){case"single":return qt;case"all":return Oe;case"page":default:return Ae}});function u(y){return Q(y).every(m=>n.value.has(m.value))}function c(y){return Q(y).some(m=>n.value.has(m.value))}function o(y,m){const P=s.value.select({items:y,value:m,selected:new Set(n.value)});n.value=P}function v(y){o([y],!u([y]))}function i(y){const m=s.value.selectAll({value:y,allItems:r.value,currentPage:d.value,selected:new Set(n.value)});n.value=m}const g=k(()=>n.value.size>0),p=k(()=>{const y=s.value.allSelected({allItems:r.value,currentPage:d.value});return!!y.length&&u(y)}),b={toggleSelect:v,select:o,selectAll:i,isSelected:u,isSomeSelected:c,someSelected:g,allSelected:p,showSelectAll:s.value.showSelectAll};return j($e,b),b}function ae(){const e=H($e);if(!e)throw new Error("Missing selection!");return e}const Xt=T({sortBy:{type:Array,default:()=>[]},customKeySort:Object,multiSort:Boolean,mustSort:Boolean},"DataTable-sort"),Me=Symbol.for("vuetify:data-table-sort");function Zt(e){const l=M(e,"sortBy"),a=V(e,"mustSort"),t=V(e,"multiSort");return{sortBy:l,mustSort:a,multiSort:t}}function Yt(e){const{sortBy:l,mustSort:a,multiSort:t,page:n}=e,r=u=>{if(u.key==null)return;let c=l.value.map(v=>({...v}))??[];const o=c.find(v=>v.key===u.key);o?o.order==="desc"?a.value?o.order="asc":c=c.filter(v=>v.key!==u.key):o.order="desc":t.value?c=[...c,{key:u.key,order:"asc"}]:c=[{key:u.key,order:"asc"}],l.value=c,n&&(n.value=1)};function d(u){return!!l.value.find(c=>c.key===u.key)}const s={sortBy:l,toggleSort:r,isSorted:d};return j(Me,s),s}function ea(){const e=H(Me);if(!e)throw new Error("Missing sort!");return e}function ta(e,l,a,t){const n=ee();return{sortedItems:k(()=>a.value.length?aa(l.value,a.value,n.current.value,{...e.customKeySort,...t==null?void 0:t.value}):l.value)}}function aa(e,l,a,t){const n=new Intl.Collator(a,{sensitivity:"accent",usage:"sort"});return[...e].sort((r,d)=>{for(let s=0;s<l.length;s++){const u=l[s].key,c=l[s].order??"asc";if(c===!1)continue;let o=Y(r.raw,u),v=Y(d.raw,u);if(c==="desc"&&([o,v]=[v,o]),t!=null&&t[u]){const i=t[u](o,v);if(!i)continue;return i}if(o instanceof Date&&v instanceof Date)return o.getTime()-v.getTime();if([o,v]=[o,v].map(i=>i!=null?i.toString().toLocaleLowerCase():i),o!==v)return Z(o)&&Z(v)?0:Z(o)?-1:Z(v)?1:!isNaN(o)&&!isNaN(v)?Number(o)-Number(v):n.compare(o,v)}return 0})}const Ee=T({color:String,sticky:Boolean,multiSort:Boolean,sortAscIcon:{type:R,default:"$sortAsc"},sortDescIcon:{type:R,default:"$sortDesc"},...St()},"VDataTableHeaders"),Ie=E()({name:"VDataTableHeaders",props:Ee(),setup(e,l){let{slots:a}=l;const{toggleSort:t,sortBy:n,isSorted:r}=ea(),{someSelected:d,allSelected:s,selectAll:u,showSelectAll:c}=ae(),{columns:o,headers:v}=te(),{loaderClasses:i}=kt(e);function g(I,x){if(!(!e.sticky&&!I.fixed))return{position:"sticky",left:I.fixed?N(I.fixedOffset):void 0,top:e.sticky?`calc(var(--v-table-header-height) * ${x})`:void 0}}function p(I){const x=n.value.find(F=>F.key===I.key);return x?x.order==="asc"?e.sortAscIcon:e.sortDescIcon:e.sortAscIcon}const{backgroundColorClasses:b,backgroundColorStyles:y}=wt(e,"color"),m=k(()=>({headers:v.value,columns:o.value,toggleSort:t,isSorted:r,sortBy:n.value,someSelected:d.value,allSelected:s.value,selectAll:u,getSortIcon:p})),P=I=>{let{column:x,x:F,y:C}=I;const K=x.key==="data-table-select"||x.key==="data-table-expand";return f(de,_({tag:"th",align:x.align,class:["v-data-table__th",{"v-data-table__th--sortable":x.sortable,"v-data-table__th--sorted":r(x),"v-data-table__th--fixed":x.fixed},i.value],style:{width:N(x.width),minWidth:N(x.minWidth),...g(x,C)},colspan:x.colspan,rowspan:x.rowspan,onClick:x.sortable?()=>t(x):void 0,fixed:x.fixed,lastFixed:x.lastFixed,noPadding:K},x.headerProps),{default:()=>{var w;const h=`header.${x.key}`,S={column:x,selectAll:u,isSorted:r,toggleSort:t,sortBy:n.value,someSelected:d.value,allSelected:s.value,getSortIcon:p};return a[h]?a[h](S):x.key==="data-table-select"?((w=a["header.data-table-select"])==null?void 0:w.call(a,S))??(c&&f(ce,{modelValue:s.value,indeterminate:d.value&&!s.value,"onUpdate:modelValue":u},null)):f("div",{class:"v-data-table-header__content"},[f("span",null,[x.title]),x.sortable&&f(Vt,{key:"icon",class:"v-data-table-header__sort-icon",icon:p(x)},null),e.multiSort&&r(x)&&f("div",{key:"badge",class:["v-data-table-header__sort-badge",...b.value],style:y.value},[n.value.findIndex(D=>D.key===x.key)+1])])}})};G(()=>f(J,null,[a.headers?a.headers(m.value):v.value.map((I,x)=>f("tr",null,[I.map((F,C)=>f(P,{column:F,x:C,y:x},null))])),e.loading&&f("tr",{class:"v-data-table-progress"},[f("th",{colspan:o.value.length},[f(It,{name:"v-data-table-progress",absolute:!0,active:!0,color:typeof e.loading=="boolean"?void 0:e.loading,indeterminate:!0},{default:a.loader})])])]))}}),la=T({groupBy:{type:Array,default:()=>[]}},"DataTable-group"),Re=Symbol.for("vuetify:data-table-group");function na(e){return{groupBy:M(e,"groupBy")}}function ra(e){const{groupBy:l,sortBy:a}=e,t=A(new Set),n=k(()=>l.value.map(c=>({...c,order:c.order??!1})).concat(a.value));function r(c){return t.value.has(c.id)}function d(c){const o=new Set(t.value);r(c)?o.delete(c.id):o.add(c.id),t.value=o}function s(c){function o(v){const i=[];for(const g of v.items)"type"in g&&g.type==="group"?i.push(...o(g)):i.push(g);return i}return o({type:"group",items:c,id:"dummy",key:"dummy",value:"dummy",depth:0})}const u={sortByWithGroups:n,toggleGroup:d,opened:t,groupBy:l,extractRows:s,isGroupOpen:r};return j(Re,u),u}function Ne(){const e=H(Re);if(!e)throw new Error("Missing group!");return e}function ua(e,l){if(!e.length)return[];const a=new Map;for(const t of e){const n=Y(t.raw,l);a.has(n)||a.set(n,[]),a.get(n).push(t)}return a}function Ge(e,l){let a=arguments.length>2&&arguments[2]!==void 0?arguments[2]:0,t=arguments.length>3&&arguments[3]!==void 0?arguments[3]:"root";if(!l.length)return[];const n=ua(e,l[0]),r=[],d=l.slice(1);return n.forEach((s,u)=>{const c=l[0],o=`${t}_${c}_${u}`;r.push({depth:a,id:o,key:c,value:u,items:d.length?Ge(s,d,a+1,o):s,type:"group"})}),r}function je(e,l){const a=[];for(const t of e)"type"in t&&t.type==="group"?(t.value!=null&&a.push(t),(l.has(t.id)||t.value==null)&&a.push(...je(t.items,l))):a.push(t);return a}function sa(e,l,a){return{flatItems:k(()=>{if(!l.value.length)return e.value;const n=Ge(e.value,l.value.map(r=>r.key));return je(n,a.value)})}}const ia=T({item:{type:Object,required:!0}},"VDataTableGroupHeaderRow"),oa=E()({name:"VDataTableGroupHeaderRow",props:ia(),setup(e,l){let{slots:a}=l;const{isGroupOpen:t,toggleGroup:n,extractRows:r}=Ne(),{isSelected:d,isSomeSelected:s,select:u}=ae(),{columns:c}=te(),o=k(()=>r([e.item]));return()=>f("tr",{class:"v-data-table-group-header-row",style:{"--v-data-table-group-header-row-depth":e.item.depth}},[c.value.map(v=>{var i,g;if(v.key==="data-table-group"){const p=t(e.item)?"$expand":"$next",b=()=>n(e.item);return((i=a["data-table-group"])==null?void 0:i.call(a,{item:e.item,count:o.value.length,props:{icon:p,onClick:b}}))??f(de,{class:"v-data-table-group-header-row__column"},{default:()=>[f($,{size:"small",variant:"text",icon:p,onClick:b},null),f("span",null,[e.item.value]),f("span",null,[xe("("),o.value.length,xe(")")])]})}if(v.key==="data-table-select"){const p=d(o.value),b=s(o.value)&&!p,y=m=>u(o.value,m);return((g=a["data-table-select"])==null?void 0:g.call(a,{props:{modelValue:p,indeterminate:b,"onUpdate:modelValue":y}}))??f("td",null,[f(ce,{modelValue:p,indeterminate:b,"onUpdate:modelValue":y},null)])}return f("td",null,null)})])}}),ca=T({expandOnClick:Boolean,showExpand:Boolean,expanded:{type:Array,default:()=>[]}},"DataTable-expand"),He=Symbol.for("vuetify:datatable:expanded");function da(e){const l=V(e,"expandOnClick"),a=M(e,"expanded",e.expanded,s=>new Set(s),s=>[...s.values()]);function t(s,u){const c=new Set(a.value);u?c.add(s.value):c.delete(s.value),a.value=c}function n(s){return a.value.has(s.value)}function r(s){t(s,!n(s))}const d={expand:t,expanded:a,expandOnClick:l,isExpanded:n,toggleExpand:r};return j(He,d),d}function Ke(){const e=H(He);if(!e)throw new Error("foo");return e}const fa=T({index:Number,item:Object,cellProps:[Object,Function],onClick:ue(),onContextmenu:ue(),onDblclick:ue()},"VDataTableRow"),va=E()({name:"VDataTableRow",props:fa(),setup(e,l){let{slots:a}=l;const{isSelected:t,toggleSelect:n}=ae(),{isExpanded:r,toggleExpand:d}=Ke(),{columns:s}=te();G(()=>f("tr",{class:["v-data-table__tr",{"v-data-table__tr--clickable":!!(e.onClick||e.onContextmenu||e.onDblclick)}],onClick:e.onClick,onContextmenu:e.onContextmenu,onDblclick:e.onDblclick},[e.item&&s.value.map((u,c)=>{const o=e.item,v=`item.${u.key}`,i={index:e.index,item:o.raw,internalItem:o,value:Y(o.columns,u.key),column:u,isSelected:t,toggleSelect:n,isExpanded:r,toggleExpand:d},g=typeof e.cellProps=="function"?e.cellProps({index:i.index,item:i.item,internalItem:i.internalItem,value:i.value,column:u}):e.cellProps,p=typeof u.cellProps=="function"?u.cellProps({index:i.index,item:i.item,internalItem:i.internalItem,value:i.value}):u.cellProps;return f(de,_({align:u.align,fixed:u.fixed,fixedOffset:u.fixedOffset,lastFixed:u.lastFixed,noPadding:u.key==="data-table-select"||u.key==="data-table-expand",width:u.width},g,p),{default:()=>{var b,y;return a[v]?a[v](i):u.key==="data-table-select"?((b=a["item.data-table-select"])==null?void 0:b.call(a,i))??f(ce,{disabled:!o.selectable,modelValue:t([o]),onClick:Pe(()=>n(o),["stop"])},null):u.key==="data-table-expand"?((y=a["item.data-table-expand"])==null?void 0:y.call(a,i))??f($,{icon:r(o)?"$collapse":"$expand",size:"small",variant:"text",onClick:Pe(()=>d(o),["stop"])},null):Dt(i.value)}})})]))}}),ze=T({loading:[Boolean,String],loadingText:{type:String,default:"$vuetify.dataIterator.loadingText"},hideNoData:Boolean,items:{type:Array,default:()=>[]},noDataText:{type:String,default:"$vuetify.noDataText"},rowProps:[Object,Function],cellProps:[Object,Function]},"VDataTableRows"),Ve=E()({name:"VDataTableRows",inheritAttrs:!1,props:ze(),setup(e,l){let{attrs:a,slots:t}=l;const{columns:n}=te(),{expandOnClick:r,toggleExpand:d,isExpanded:s}=Ke(),{isSelected:u,toggleSelect:c}=ae(),{toggleGroup:o,isGroupOpen:v}=Ne(),{t:i}=ee();return G(()=>{var g,p;return e.loading&&(!e.items.length||t.loading)?f("tr",{class:"v-data-table-rows-loading",key:"loading"},[f("td",{colspan:n.value.length},[((g=t.loading)==null?void 0:g.call(t))??i(e.loadingText)])]):!e.loading&&!e.items.length&&!e.hideNoData?f("tr",{class:"v-data-table-rows-no-data",key:"no-data"},[f("td",{colspan:n.value.length},[((p=t["no-data"])==null?void 0:p.call(t))??i(e.noDataText)])]):f(J,null,[e.items.map((b,y)=>{var I;if(b.type==="group"){const x={index:y,item:b,columns:n.value,isExpanded:s,toggleExpand:d,isSelected:u,toggleSelect:c,toggleGroup:o,isGroupOpen:v};return t["group-header"]?t["group-header"](x):f(oa,_({key:`group-header_${b.id}`,item:b},ke(a,":group-header",()=>x)),t)}const m={index:y,item:b.raw,internalItem:b,columns:n.value,isExpanded:s,toggleExpand:d,isSelected:u,toggleSelect:c},P={...m,props:_({key:`item_${b.key??b.index}`,onClick:r.value?()=>{d(b)}:void 0,index:y,item:b,cellProps:e.cellProps},ke(a,":row",()=>m),typeof e.rowProps=="function"?e.rowProps({item:m.item,index:m.index,internalItem:m.internalItem}):e.rowProps)};return f(J,{key:P.props.key},[t.item?t.item(P):f(va,P.props,t),s(b)&&((I=t["expanded-row"])==null?void 0:I.call(t,m))])})])}),{}}}),ga=T({items:{type:Array,default:()=>[]},itemValue:{type:[String,Array,Function],default:"id"},itemSelectable:{type:[String,Array,Function],default:null},rowProps:[Object,Function],cellProps:[Object,Function],returnObject:Boolean},"DataTable-items");function ma(e,l,a,t){const n=e.returnObject?l:q(l,e.itemValue),r=q(l,e.itemSelectable,!0),d=t.reduce((s,u)=>(u.key!=null&&(s[u.key]=q(l,u.value)),s),{});return{type:"item",key:e.returnObject?q(l,e.itemValue):n,index:a,value:n,selectable:r,columns:d,raw:l}}function ya(e,l,a){return l.map((t,n)=>ma(e,t,n,a))}function ba(e,l){return{items:k(()=>ya(e,e.items,l.value))}}function ha(e){let{page:l,itemsPerPage:a,sortBy:t,groupBy:n,search:r}=e;const d=Tt("VDataTable"),s=k(()=>({page:l.value,itemsPerPage:a.value,sortBy:t.value,groupBy:n.value,search:r.value}));let u=null;Ft(s,()=>{De(u,s.value)||((u==null?void 0:u.search)!==s.value.search&&(l.value=1),d.emit("update:options",s.value),u=s.value)},{deep:!0,immediate:!0})}const pa=(e,l,a)=>e==null||l==null?-1:e.toString().toLocaleLowerCase().indexOf(l.toString().toLocaleLowerCase()),xa=T({customFilter:Function,customKeyFilter:Object,filterKeys:[Array,String],filterMode:{type:String,default:"intersection"},noFilter:Boolean},"filter");function Pa(e,l,a){var s;const t=[],n=(a==null?void 0:a.default)??pa,r=a!=null&&a.filterKeys?Q(a.filterKeys):!1,d=Object.keys((a==null?void 0:a.customKeyFilter)??{}).length;if(!(e!=null&&e.length))return t;e:for(let u=0;u<e.length;u++){const[c,o=c]=Q(e[u]),v={},i={};let g=-1;if(l&&!(a!=null&&a.noFilter)){if(typeof c=="object"){const y=r||Object.keys(o);for(const m of y){const P=q(o,m,o),I=(s=a==null?void 0:a.customKeyFilter)==null?void 0:s[m];if(g=I?I(P,l,c):n(P,l,c),g!==-1&&g!==!1)I?v[m]=g:i[m]=g;else if((a==null?void 0:a.filterMode)==="every")continue e}}else g=n(c,l,c),g!==-1&&g!==!1&&(i.title=g);const p=Object.keys(i).length,b=Object.keys(v).length;if(!p&&!b||(a==null?void 0:a.filterMode)==="union"&&b!==d&&!p||(a==null?void 0:a.filterMode)==="intersection"&&(b!==d||!p))continue}t.push({index:u,matches:{...i,...v}})}return t}function Sa(e,l,a,t){const n=A([]),r=A(new Map),d=k(()=>t!=null&&t.transform?U(l).map(u=>[u,t.transform(u)]):U(l));oe(()=>{const u=typeof a=="function"?a():U(a),c=typeof u!="string"&&typeof u!="number"?"":String(u),o=Pa(d.value,c,{customKeyFilter:{...e.customKeyFilter,...U(t==null?void 0:t.customKeyFilter)},default:e.customFilter,filterKeys:e.filterKeys,filterMode:e.filterMode,noFilter:e.noFilter}),v=U(l),i=[],g=new Map;o.forEach(p=>{let{index:b,matches:y}=p;const m=v[b];i.push(m),g.set(m.value,y)}),n.value=i,r.value=g});function s(u){return r.value.get(u.value)}return{filteredItems:n,filteredMatches:r,getMatches:s}}const ka=T({...ze(),width:[String,Number],search:String,...ca(),...la(),...Gt(),...ga(),...Qt(),...Xt(),...Ee(),..._t()},"DataTable"),wa=T({...$t(),...ka(),...xa(),...Fe()},"VDataTable"),La=E()({name:"VDataTable",props:wa(),emits:{"update:modelValue":e=>!0,"update:page":e=>!0,"update:itemsPerPage":e=>!0,"update:sortBy":e=>!0,"update:options":e=>!0,"update:groupBy":e=>!0,"update:expanded":e=>!0},setup(e,l){let{attrs:a,slots:t}=l;const{groupBy:n}=na(e),{sortBy:r,multiSort:d,mustSort:s}=Zt(e),{page:u,itemsPerPage:c}=Mt(e),{columns:o,headers:v,sortFunctions:i,filterFunctions:g}=Ut(e,{groupBy:n,showSelect:V(e,"showSelect"),showExpand:V(e,"showExpand")}),{items:p}=ba(e,o),b=V(e,"search"),{filteredItems:y}=Sa(e,p,b,{transform:z=>z.columns,customKeyFilter:g}),{toggleSort:m}=Yt({sortBy:r,multiSort:d,mustSort:s,page:u}),{sortByWithGroups:P,opened:I,extractRows:x,isGroupOpen:F,toggleGroup:C}=ra({groupBy:n,sortBy:r}),{sortedItems:K}=ta(e,y,P,i),{flatItems:h}=sa(K,n,I),S=k(()=>h.value.length),{startIndex:w,stopIndex:D,pageCount:L,setItemsPerPage:O}=Et({page:u,itemsPerPage:c,itemsLength:S}),{paginatedItems:le}=Nt({items:h,startIndex:w,stopIndex:D,itemsPerPage:c}),ne=k(()=>x(le.value)),{isSelected:We,select:Ue,selectAll:qe,toggleSelect:Qe,someSelected:Je,allSelected:Xe}=Jt(e,{allItems:p,currentPage:ne}),{isExpanded:Ze,toggleExpand:Ye}=da(e);ha({page:u,itemsPerPage:c,sortBy:r,groupBy:n,search:b}),se({VDataTableRows:{hideNoData:V(e,"hideNoData"),noDataText:V(e,"noDataText"),loading:V(e,"loading"),loadingText:V(e,"loadingText")}});const B=k(()=>({page:u.value,itemsPerPage:c.value,sortBy:r.value,pageCount:L.value,toggleSort:m,setItemsPerPage:O,someSelected:Je.value,allSelected:Xe.value,isSelected:We,select:Ue,selectAll:qe,toggleSelect:Qe,isExpanded:Ze,toggleExpand:Ye,isGroupOpen:F,toggleGroup:C,items:ne.value.map(z=>z.raw),internalItems:ne.value,groupedItems:le.value,columns:o.value,headers:v.value}));return G(()=>{const z=we.filterProps(e),et=Ie.filterProps(e),tt=Ve.filterProps(e),at=Se.filterProps(e);return f(Se,_({class:["v-data-table",{"v-data-table--show-select":e.showSelect,"v-data-table--loading":e.loading},e.class],style:e.style},at),{top:()=>{var W;return(W=t.top)==null?void 0:W.call(t,B.value)},default:()=>{var W,ve,ge,me,ye,be;return t.default?t.default(B.value):f(J,null,[(W=t.colgroup)==null?void 0:W.call(t,B.value),f("thead",null,[f(Ie,et,t)]),(ve=t.thead)==null?void 0:ve.call(t,B.value),f("tbody",null,[(ge=t["body.prepend"])==null?void 0:ge.call(t,B.value),t.body?t.body(B.value):f(Ve,_(a,tt,{items:le.value}),t),(me=t["body.append"])==null?void 0:me.call(t,B.value)]),(ye=t.tbody)==null?void 0:ye.call(t,B.value),(be=t.tfoot)==null?void 0:be.call(t,B.value)])},bottom:()=>t.bottom?t.bottom(B.value):f(J,null,[f(Bt,null,null),f(we,z,{prepend:t["footer.prepend"]})])})}),{}}});export{La as V};
