import{k as b,o as r,l,m as s,n as e,V as v,Z as x,h as C,a as m,t as p,c as S,p as B,u as n,Q as k,r as h,R as q,$ as f,a0 as g}from"./index-WKjbL8T9.js";import{V as w,a as A}from"./VMenu-QfTuqrl7.js";import{V as y,a as z}from"./VCard-7Z-Nhb6D.js";import{V as P}from"./VAvatar-CH2A0OSR.js";import{V as L}from"./VSpacer-7g7b_z3V.js";import{a as M}from"./axios-G2rPRu76.js";import{V,a as d}from"./VRow-OVTj2QZh.js";import"./index-o85Hqk3v.js";import"./ssrBoot-WNY3uwVA.js";import"./VImg-mBLNfk7f.js";import"./VDivider-waA0KO__.js";import"./VOverlay-TBYimdhT.js";import"./easing-Apq16fr0.js";import"./lazy-b-hiN5pE.js";import"./forwardRefs-y8pOSn8h.js";import"./dialog-transition-ndbJkIK2.js";/* empty css              */const N={__name:"MoreBtn",props:{menuList:{type:Array,required:!1},itemProps:{type:Boolean,required:!1}},setup(c){const t=c;return(o,u)=>{const i=b("IconBtn");return r(),l(i,null,{default:s(()=>[e(v,{icon:"ri-more-2-line"}),t.menuList?(r(),l(w,{key:0,activator:"parent"},{default:s(()=>[e(A,{items:t.menuList,"item-props":t.itemProps},null,8,["items","item-props"])]),_:1})):x("",!0)]),_:1})}}},R={class:"text-h6 mb-1"},$={key:0,class:"d-flex align-center mb-1 flex-wrap"},E={class:"text-h4 me-2"},I={class:"text-body-2"},U={__name:"CardStatisticsVertical",props:{title:{type:String,required:!0},color:{type:String,required:!1,default:"primary"},icon:{type:String,required:!0},stats:{type:String,required:!0},change:{type:Number,required:!0},subtitle:{type:String,required:!0}},setup(c){const t=c,o=C(()=>Math.sign(t.change)===1);return(u,i)=>{const a=N;return r(),l(z,null,{default:s(()=>[e(y,{class:"d-flex align-center"},{default:s(()=>[t.icon?(r(),l(P,{key:0,size:"40",color:t.color,class:"elevation-2"},{default:s(()=>[e(v,{icon:t.icon,size:"24"},null,8,["icon"])]),_:1},8,["color"])):x("",!0),e(L),e(a,{class:"me-n3 mt-n1"})]),_:1}),e(y,null,{default:s(()=>[m("h6",R,p(t.title),1),t.change?(r(),S("div",$,[m("h4",E,p(t.stats),1),m("div",{class:B([n(o)?"text-success":"text-error","text-body-1"])},p(n(o)?`+${t.change}`:t.change)+"% ",3)])):x("",!0),m("div",I,p(t.subtitle),1)]),_:1})]),_:1})}}},ot={__name:"DashBoard",setup(c){k();let t=window.location.protocol+"//"+window.location.hostname+":8080";const o=h({title:"Students",subtitle:"All Students",icon:"ri-contacts-line",stats:"862",change:100,color:"primary"}),u=h({title:"Users",subtitle:"All Users",icon:"ri-user-line",stats:"862",change:100,color:"primary"}),i=h({title:"Examinations",subtitle:"All Examinations",icon:"ri-bar-chart-2-line",stats:"862",change:100,color:"primary"});return M.get(t+"/api/v1/dashboard/stats",{headers:{"Content-Type":"application/json",Authorization:q.get("Authorization")}}).then(a=>{console.log(a),o.value.stats=a.data.students+"",u.value.stats=a.data.users+"",i.value.stats=a.data.exams+""}),(a,D)=>{const _=U;return r(),l(V,{class:"match-height"},{default:s(()=>[e(d,{cols:"12"},{default:s(()=>[e(V,{class:"match-height"},{default:s(()=>[e(d,{cols:"12",sm:"4"},{default:s(()=>[e(_,f(g(n(o))),null,16)]),_:1}),e(d,{cols:"12",sm:"4"},{default:s(()=>[e(_,f(g(n(u))),null,16)]),_:1}),e(d,{cols:"12",sm:"4"},{default:s(()=>[e(_,f(g(n(i))),null,16)]),_:1})]),_:1})]),_:1})]),_:1})}}};export{ot as default};
