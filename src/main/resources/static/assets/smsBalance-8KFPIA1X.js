import{a as c}from"./axios-G2rPRu76.js";import{r as u,Q as d,R as _,c as m,n as a,m as t,o as f,b as l,a as r,t as p,u as h}from"./index-2BP_lAh-.js";import{a as g,b as V,V as b}from"./VCard-LeQVuWP8.js";import{V as o,a as n}from"./VRow-xKr1Tf61.js";import"./VAvatar-nprCTEVN.js";import"./VImg-noq4ZFey.js";/* empty css              */const C=r("strong",null,"4093753",-1),w=r("strong",null," TakabaBoys",-1),N={__name:"smsBalance",setup(x){const s=u({data:""});d();let i=window.location.protocol+"//"+window.location.hostname+":8080";return u({year:2024,term:"",title:""}),c.get(i+"/api/v1/sms/balance",{headers:{Authorization:_.get("Authorization")}}).then(e=>{console.log(e),s.value.data=e.data}).catch(e=>{console.log(e),s.value.data="Unable to Fetch(check internet)"}),(e,B)=>(f(),m("div",null,[a(g,null,{default:t(()=>[a(V,null,{default:t(()=>[l(" SMS Balance ")]),_:1}),a(b,null,{default:t(()=>[a(o,null,{default:t(()=>[a(n,null,{default:t(()=>[l(" Remaining SMS Credits : "),r("strong",null,p(h(s).data),1)]),_:1})]),_:1}),a(o,null,{default:t(()=>[a(n,null,{default:t(()=>[l(" To Recharge, top up your Account via ")]),_:1})]),_:1}),a(o,null,{default:t(()=>[a(n,null,{default:t(()=>[l(" Paybill: "),C]),_:1})]),_:1}),a(o,null,{default:t(()=>[a(n,null,{default:t(()=>[l(" Account:"),w]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{N as default};
