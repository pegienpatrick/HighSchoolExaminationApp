import{r as g,j as T,h as E,c as S,n as e,m as a,u as o,o as y,a as i,b as p,t as U,l as B,Z as c,a3 as v,a2 as N,k as L,a1 as M}from"./index-WKjbL8T9.js";import{a as D,b as I,c as j,d as F}from"./auth-v1-tree-Q__A_nzM.js";import{l as G}from"./logo-lSNaS3Cd.js";import{s as $}from"./sweetalert2.all-41Y4Kfy6.js";import{a as _}from"./axios-G2rPRu76.js";import{a as A,d as R,b as H,V as w}from"./VCard-7Z-Nhb6D.js";import{V as f}from"./VImg-mBLNfk7f.js";import{a as n,V as z}from"./VRow-OVTj2QZh.js";import{V as J}from"./VForm-6aTEnKMd.js";import{V as m}from"./VTextField-IrLm8OWS.js";import{V as O}from"./VSelect-OHkD6uXj.js";import{V as Y}from"./VCheckbox-amzyUcbz.js";import{V as Z}from"./VLabel-ll7gtFfh.js";import"./VDivider-waA0KO__.js";import"./VAvatar-CH2A0OSR.js";/* empty css              */import"./form-y8kNbNCk.js";import"./forwardRefs-y8pOSn8h.js";import"./VField-zZ1l0zML.js";import"./index-o85Hqk3v.js";import"./VInput-9aEGepXD.js";import"./easing-Apq16fr0.js";import"./VMenu-QfTuqrl7.js";import"./ssrBoot-WNY3uwVA.js";import"./VOverlay-TBYimdhT.js";import"./lazy-b-hiN5pE.js";import"./dialog-transition-ndbJkIK2.js";import"./VCheckboxBtn-G-nkP6-g.js";import"./VChip-nPbsihEe.js";const q={class:"auth-wrapper d-flex align-center justify-center pa-4"},K={class:"d-flex"},Q=["innerHTML"],W=i("h5",{class:"text-h5 font-weight-semibold mb-1"}," Success starts here 🚀 ",-1),X=i("p",{class:"mb-0"}," Make your Exam management easy and fun! ",-1),ee={class:"text-h6 font-weight-semibold text-error"},oe={class:"d-flex align-center mt-1 mb-4"},te=i("span",{class:"me-1"},"I agree to",-1),le=i("a",{href:"javascript:void(0)",class:"text-primary"},"privacy policy & terms",-1),ae=i("span",null,"Already have an account?",-1);const je={__name:"register",setup(se){const t=g({fullname:"",gender:"",username:"",email:"",phone:"",password:"",confirmPassword:"",privacyPolicies:!1}),x=T();let b=!1;const k=E(()=>x.global.name.value==="light"?D:I),d=g(!1);let V=window.location.protocol+"//"+window.location.hostname+":8080",u=[];_.get(V+"/api/v1/user/possibleGenders").then(r=>{console.log(r),console.log(u),u=r.data,t.value.gender=u[-1]});const C=async()=>{try{(await $.fire({title:"Success!",text:"Your registration was successful.",icon:"success",confirmButtonText:"Go to Login"})).isConfirmed&&(window.location.href="/")}catch(r){console.error("Error displaying SweetAlert:",r)}},h=()=>{if(t.value.password!=t.value.confirmPassword){t.value.registerError="passwords dont match";return}console.log(JSON.stringify(t.value)),_.post(V+"/api/v1/user/registerUser",t.value).then(r=>{console.log(r),t.value={},C()}).catch(r=>{console.log(r),r.response.status==400?t.value.registerError=r.response.data.fielderrors:t.value.registerError=r.response.data})};return(r,l)=>{const P=L("RouterLink");return y(),S("div",q,[e(A,{class:"auth-card pa-4 pt-7","max-width":"448"},{default:a(()=>[e(R,{class:"justify-center"},{prepend:a(()=>[i("div",K,[i("div",{innerHTML:o(G)},null,8,Q)])]),default:a(()=>[e(H,{class:"font-weight-semibold text-2xl text-uppercase"},{default:a(()=>[p(" PExam System ")]),_:1})]),_:1}),e(w,{class:"pt-2"},{default:a(()=>[W,X]),_:1}),e(w,null,{default:a(()=>[e(n,{cols:"12",class:"text-center"},{default:a(()=>[i("p",ee,U(o(t).registerError),1)]),_:1}),o(b)?(y(),B(M,{key:0,indeterminate:"",color:"blue",size:"24",style:{position:"absolute","inset-block-start":"50%","inset-inline-start":"50%",transform:"translate(-50%, -50%)"}})):c("",!0),e(J,{onSubmit:l[10]||(l[10]=v(()=>{h()},["prevent"]))},{default:a(()=>[e(z,null,{default:a(()=>[e(n,{cols:"12"},{default:a(()=>[e(m,{modelValue:o(t).fullname,"onUpdate:modelValue":l[0]||(l[0]=s=>o(t).fullname=s),label:"Full name",placeholder:"Full Name"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(O,{"model-value":o(t).gender,"onUpdate:modelValue":l[1]||(l[1]=s=>o(t).gender=s),items:o(u),label:"Gender"},null,8,["model-value","items"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(m,{modelValue:o(t).username,"onUpdate:modelValue":l[2]||(l[2]=s=>o(t).username=s),label:"Username",placeholder:"username"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(m,{modelValue:o(t).email,"onUpdate:modelValue":l[3]||(l[3]=s=>o(t).email=s),label:"Email",placeholder:"ENter email",type:"email"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(m,{modelValue:o(t).phone,"onUpdate:modelValue":l[4]||(l[4]=s=>o(t).phone=s),label:"Phone",placeholder:"Enter Phone",type:"tel"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(m,{modelValue:o(t).password,"onUpdate:modelValue":l[5]||(l[5]=s=>o(t).password=s),label:"Password",placeholder:"············",type:o(d)?"text":"password","append-inner-icon":o(d)?"ri-eye-off-line":"ri-eye-line","onClick:appendInner":l[6]||(l[6]=s=>d.value=!o(d))},null,8,["modelValue","type","append-inner-icon"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(m,{modelValue:o(t).confirmPassword,"onUpdate:modelValue":l[7]||(l[7]=s=>o(t).confirmPassword=s),label:"Confirm Password",placeholder:"············",type:o(d)?"text":"password","append-inner-icon":o(d)?"ri-eye-off-line":"ri-eye-line","onClick:appendInner":l[8]||(l[8]=s=>d.value=!o(d))},null,8,["modelValue","type","append-inner-icon"]),i("div",oe,[e(Y,{id:"privacy-policy",modelValue:o(t).privacyPolicies,"onUpdate:modelValue":l[9]||(l[9]=s=>o(t).privacyPolicies=s),inline:""},null,8,["modelValue"]),e(Z,{for:"privacy-policy",style:{opacity:"1"}},{default:a(()=>[te,le]),_:1})]),e(N,{block:"",type:"submit",onClick:v(h,["prevent"])},{default:a(()=>[p(" Sign up ")]),_:1})]),_:1}),e(n,{cols:"12",class:"text-center text-base"},{default:a(()=>[ae,e(P,{class:"text-primary ms-2",to:"login"},{default:a(()=>[p(" Sign in instead ")]),_:1})]),_:1}),c("",!0),c("",!0)]),_:1})]),_:1})]),_:1})]),_:1}),e(f,{class:"auth-footer-start-tree d-none d-md-block",src:o(j),width:250},null,8,["src"]),e(f,{src:o(F),class:"auth-footer-end-tree d-none d-md-block",width:350},null,8,["src"]),e(f,{class:"auth-footer-mask d-none d-md-block",src:o(k)},null,8,["src"])])}}};export{je as default};
