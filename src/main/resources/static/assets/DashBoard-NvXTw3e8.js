import{l as y,o as s,e as a,w as r,b as e,V as h,Z as m,z as g,a as c,t as l,c as x,n as S,u,$ as B,a0 as b}from"./index-o3g7j-pu.js";import{V as v,a as C}from"./VMenu-cCGLK3cW.js";import{V as _,a as q}from"./VCard-Pw8zZ9F3.js";import{V as P}from"./VAvatar-rbGeQzgj.js";import{V as k}from"./VSpacer-xuyDxFha.js";import{V as d,a as f}from"./VRow-6qMY-zIc.js";import"./index-bUpWvayE.js";import"./ssrBoot-MY_GD0BE.js";import"./VImg-FqV0TNDi.js";import"./VDivider-sBH1Wu20.js";import"./VOverlay-AuJcsXDy.js";import"./easing-imumzmxr.js";import"./lazy-hOOnrdiR.js";import"./forwardRefs-y8pOSn8h.js";/* empty css              */const w={__name:"MoreBtn",props:{menuList:{type:Array,required:!1},itemProps:{type:Boolean,required:!1}},setup(o){const t=o;return(i,p)=>{const n=y("IconBtn");return s(),a(n,null,{default:r(()=>[e(h,{icon:"ri-more-2-line"}),t.menuList?(s(),a(v,{key:0,activator:"parent"},{default:r(()=>[e(C,{items:t.menuList,"item-props":t.itemProps},null,8,["items","item-props"])]),_:1})):m("",!0)]),_:1})}}},z={class:"text-h6 mb-1"},L={key:0,class:"d-flex align-center mb-1 flex-wrap"},M={class:"text-h4 me-2"},N={class:"text-body-2"},$={__name:"CardStatisticsVertical",props:{title:{type:String,required:!0},color:{type:String,required:!1,default:"primary"},icon:{type:String,required:!0},stats:{type:String,required:!0},change:{type:Number,required:!0},subtitle:{type:String,required:!0}},setup(o){const t=o,i=g(()=>Math.sign(t.change)===1);return(p,n)=>{const V=w;return s(),a(q,null,{default:r(()=>[e(_,{class:"d-flex align-center"},{default:r(()=>[t.icon?(s(),a(P,{key:0,size:"40",color:t.color,class:"elevation-2"},{default:r(()=>[e(h,{icon:t.icon,size:"24"},null,8,["icon"])]),_:1},8,["color"])):m("",!0),e(k),e(V,{class:"me-n3 mt-n1"})]),_:1}),e(_,null,{default:r(()=>[c("h6",z,l(t.title),1),t.change?(s(),x("div",L,[c("h4",M,l(t.stats),1),c("div",{class:S([u(i)?"text-success":"text-error","text-body-1"])},l(u(i)?`+${t.change}`:t.change)+"% ",3)])):m("",!0),c("div",N,l(t.subtitle),1)]),_:1})]),_:1})}}},U={__name:"DashBoard",setup(o){const t={title:"ExamSystem",color:"primary",icon:"ri-file-word-2-line",stats:"862",change:-18,subtitle:"PExam System"};return(i,p)=>{const n=$;return s(),a(d,{class:"match-height"},{default:r(()=>[e(f,{cols:"12",md:"4"},{default:r(()=>[e(d,{class:"match-height"},{default:r(()=>[e(f,{cols:"12",sm:"6"},{default:r(()=>[e(n,B(b(t)),null,16)]),_:1})]),_:1})]),_:1})]),_:1})}}};export{U as default};
