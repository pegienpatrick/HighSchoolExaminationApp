import{a as i}from"./axios-G2rPRu76.js";import{r as m,Q as f,R as r,c as g,n as t,m as l,o as _,b as o,a as u,t as c,u as d}from"./index-WKjbL8T9.js";import{a as p,b as S,V as v}from"./VCard-7Z-Nhb6D.js";import{V as n,a as h}from"./VRow-OVTj2QZh.js";import"./VAvatar-CH2A0OSR.js";import"./VImg-mBLNfk7f.js";/* empty css              */const F={__name:"smsStats",setup(V){const e=m({data:"",sent:"",failed:""});f();let s=window.location.protocol+"//"+window.location.hostname+":8080";return m({year:2024,term:"",title:""}),i.get(s+"/api/v1/sms/balance",{headers:{Authorization:r.get("Authorization")}}).then(a=>{console.log(a),e.value.data=a.data}).catch(a=>{console.log(a),e.value.data="Unable to Fetch(check internet)"}),i.get(s+"/api/v1/sms/countFailed",{headers:{Authorization:r.get("Authorization")}}).then(a=>{console.log(a),e.value.failed=a.data}).catch(a=>{console.log(a),e.value.failed="Unable to Fetch(check internet)"}),i.get(s+"/api/v1/sms/countSentToday",{headers:{Authorization:r.get("Authorization")}}).then(a=>{console.log(a),e.value.sent=a.data}).catch(a=>{console.log(a),e.value.sent="Unable to Fetch(check internet)"}),(a,b)=>(_(),g("div",null,[t(p,null,{default:l(()=>[t(S,null,{default:l(()=>[o(" SMS Balance ")]),_:1}),t(v,null,{default:l(()=>[t(n,null,{default:l(()=>[t(h,null,{default:l(()=>[o(" Remaining SMS Credits : "),u("strong",null,c(d(e).data),1)]),_:1})]),_:1}),t(n),t(n,null,{default:l(()=>[t(h,null,{default:l(()=>[o(" SMS Sent Today : "),u("strong",null,c(d(e).sent),1)]),_:1})]),_:1}),t(n,null,{default:l(()=>[t(h,null,{default:l(()=>[o(" Total SMS Failed:"),u("strong",null,c(d(e).failed),1)]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{F as default};
