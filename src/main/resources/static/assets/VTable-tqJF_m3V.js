import{D as h,E as m,al as b,J as d,K as v,L as f,aq as c,as as u,R as g,b as t,ai as x}from"./index-zYAuA0qV.js";const T=h({fixedHeader:Boolean,fixedFooter:Boolean,height:[Number,String],hover:Boolean,...m(),...b(),...d(),...v()},"VTable"),k=f()({name:"VTable",props:T(),setup(a,r){let{slots:e,emit:y}=r;const{themeClasses:i}=c(a),{densityClasses:n}=u(a);return g(()=>t(a.tag,{class:["v-table",{"v-table--fixed-height":!!a.height,"v-table--fixed-header":a.fixedHeader,"v-table--fixed-footer":a.fixedFooter,"v-table--has-top":!!e.top,"v-table--has-bottom":!!e.bottom,"v-table--hover":a.hover},i.value,n.value,a.class],style:a.style},{default:()=>{var o,s,l;return[(o=e.top)==null?void 0:o.call(e),e.default?t("div",{class:"v-table__wrapper",style:{height:x(a.height)}},[t("table",null,[e.default()])]):(s=e.wrapper)==null?void 0:s.call(e),(l=e.bottom)==null?void 0:l.call(e)]}})),{}}});export{k as V,T as m};
