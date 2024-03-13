import{a as y,b as C,c as T,d as B}from"./auth-v1-tree-LJQWPJ2l.js";import{l as L}from"./logo-lSNaS3Cd.js";import{a as E}from"./axios-G2rPRu76.js";import{X as N,r as V,C as P,z as D,c as I,b as e,w as t,u as n,o as _,a as r,B as m,a2 as M,e as R,Z as c,t as S,Y as j,l as z,a1 as U}from"./index-da36zxQg.js";import{a as F,d as $,b as H,V as h}from"./VCard-2WKBUKTx.js";import{V as p}from"./VImg-M6_-POrR.js";import{V as A}from"./VForm-aDbuf93v.js";import{V as W,a as u}from"./VRow-ML7Wed7t.js";import{V as b}from"./VTextField-NB5bkSDZ.js";import{V as X}from"./VCheckbox-r414awXh.js";import"./VDivider-saeaGujC.js";import"./VAvatar-tNbxmyAy.js";import"./form-IPn-8Ex9.js";import"./forwardRefs-y8pOSn8h.js";/* empty css              */import"./VField-nvO2FZcE.js";import"./index-RAJRrmaN.js";import"./easing-imumzmxr.js";import"./VCheckboxBtn-P8KvS9GZ.js";const Y={class:"auth-wrapper d-flex align-center justify-center pa-4"},Z={class:"d-flex"},q=["innerHTML"],G=r("h5",{class:"text-h5 font-weight-semibold mb-1"}," Welcome to PExam System! 👋🏻 ",-1),J=r("p",{class:"mb-0"}," Please sign-in to your account ",-1),K={class:"d-flex align-center justify-space-between flex-wrap mt-1 mb-4"},O=r("a",{class:"ms-2 mb-1",href:"javascript:void(0)"}," Forgot Password? ",-1),Q=r("span",null,"New on our System?",-1);const ee={class:"text-h6 font-weight-semibold text-error"},ke={__name:"login",setup(te){const g=N(),o=V({username:"",password:"",remember:!0,loginError:""}),v=P(),x=D(()=>v.global.name.value==="light"?y:C),i=V(!1);let w=window.location.protocol+"//"+window.location.hostname+":8080",d=!1;const f=async()=>{try{d=!0;const s=await E.post(w+"/api/v1/user/login",{username:o.value.username,password:o.value.password});console.log(s.data),j.set("Authorization",s.data.authorization,"7d"),g.push("/"),d=!1}catch(s){console.error("Login failed:",s),s.response.status==500?o.value.loginError=s.response.data.errors:s.response.status==400?o.value.loginError=s.response.data.message:o.value.loginError="Incorrect Login Information",d=!1}};return(s,a)=>{const k=z("RouterLink");return _(),I("div",Y,[e(F,{class:"auth-card pa-4 pt-7","max-width":"448"},{default:t(()=>[e($,{class:"justify-center"},{prepend:t(()=>[r("div",Z,[r("div",{innerHTML:n(L)},null,8,q)])]),default:t(()=>[e(H,{class:"font-weight-semibold text-2xl text-uppercase"},{default:t(()=>[m(" PExam System ")]),_:1})]),_:1}),e(h,{class:"pt-2"},{default:t(()=>[G,J]),_:1}),e(h,null,{default:t(()=>[e(A,{onSubmit:a[4]||(a[4]=()=>{s.preventDefault(),f()})},{default:t(()=>[e(W,null,{default:t(()=>[e(u,{cols:"12"},{default:t(()=>[e(b,{modelValue:o.value.username,"onUpdate:modelValue":a[0]||(a[0]=l=>o.value.username=l),label:"username",type:"text"},null,8,["modelValue"])]),_:1}),e(u,{cols:"12"},{default:t(()=>[e(b,{modelValue:o.value.password,"onUpdate:modelValue":a[1]||(a[1]=l=>o.value.password=l),label:"Password",placeholder:"············",type:i.value?"text":"password","append-inner-icon":i.value?"ri-eye-off-line":"ri-eye-line","onClick:appendInner":a[2]||(a[2]=l=>i.value=!i.value)},null,8,["modelValue","type","append-inner-icon"]),r("div",K,[e(X,{modelValue:o.value.remember,"onUpdate:modelValue":a[3]||(a[3]=l=>o.value.remember=l),label:"Remember me"},null,8,["modelValue"]),O]),e(M,{block:"",type:"submit",to:"/login",onClick:f},{default:t(()=>[m(" Login ")]),_:1})]),_:1}),n(d)?(_(),R(U,{key:0,indeterminate:"",color:"blue",size:"24",style:{position:"absolute","inset-block-start":"50%","inset-inline-start":"50%",transform:"translate(-50%, -50%)"}})):c("",!0),e(u,{cols:"12",class:"text-center text-base"},{default:t(()=>[Q,e(k,{class:"text-primary ms-2",to:"/register"},{default:t(()=>[m(" Create an account ")]),_:1})]),_:1}),c("",!0),e(u,{cols:"12",class:"text-center"},{default:t(()=>[r("p",ee,S(o.value.loginError),1)]),_:1}),c("",!0)]),_:1})]),_:1})]),_:1})]),_:1}),e(p,{class:"auth-footer-start-tree d-none d-md-block",src:n(T),width:250},null,8,["src"]),e(p,{src:n(B),class:"auth-footer-end-tree d-none d-md-block",width:350},null,8,["src"]),e(p,{class:"auth-footer-mask d-none d-md-block",src:n(x)},null,8,["src"])])}}};export{ke as default};
