import{j as T,o as g,c as E,a4 as ne,n as e,u as o,a2 as S,F as ie,r as b,h as U,m as a,a as i,b as u,t as B,l as D,Z as p,a3 as v,k as I,a1 as N}from"./index-Cp0a3j5Z.js";import{l as L}from"./logo-lSNaS3Cd.js";import{a as M,b as F,c as j,d as A}from"./auth-v1-tree-EbS1KF2o.js";import{s as G}from"./sweetalert2.all-PSZh9BpD.js";import{a as _}from"./axios-G2rPRu76.js";import{a as $,c as R,b as H,V as y}from"./VCard-f1nee6yo.js";import{V as f}from"./VImg-xuUNPkdI.js";import{a as n,V as z}from"./VRow-e59EUwGS.js";import{V as J}from"./VForm-vHiLR6LN.js";import{V as c}from"./VTextField-74eHDJAa.js";import{V as O}from"./VSelect-Jx7iHon2.js";import{V as Y}from"./VCheckbox-XJAyhic4.js";import{V as Z}from"./VLabel-X25Up-Eg.js";import"./VDivider-t6YFHrqH.js";import"./VAvatar-MKe1hS_I.js";/* empty css              */import"./form-xXdqDCjs.js";import"./forwardRefs-y8pOSn8h.js";import"./VField-thFyAEi-.js";import"./index-ogFRjp9r.js";import"./easing-Apq16fr0.js";import"./VMenu-RzLdOBfR.js";import"./ssrBoot-DBy9na19.js";import"./VOverlay-x4J7jcA1.js";import"./lazy-Pl5wsFII.js";import"./dialog-transition-VPrIJniv.js";import"./VCheckboxBtn-z-5o5nyt.js";import"./VChip-8MtU5gPv.js";const q={class:"auth-wrapper d-flex align-center justify-center pa-4"},K={class:"d-flex"},Q=["innerHTML"],W=i("h5",{class:"text-h5 font-weight-semibold mb-1"}," Success starts here 🚀 ",-1),X=i("p",{class:"mb-0"}," Make your Exam management easy and fun! ",-1),ee={class:"text-h6 font-weight-semibold text-error"},oe={class:"d-flex align-center mt-1 mb-4"},te=i("span",{class:"me-1"},"I agree to",-1),le=i("a",{href:"javascript:void(0)",class:"text-primary"},"privacy policy & terms",-1),ae=i("span",null,"Already have an account?",-1);const Fe={__name:"register",setup(se){const t=b({fullname:"",gender:"",username:"",email:"",phone:"",password:"",confirmPassword:"",privacyPolicies:!1}),x=T();let w=!1;const k=U(()=>x.global.name.value==="light"?M:F),d=b(!1);let V=window.location.protocol+"//"+window.location.hostname+":8080",m=[];_.get(V+"/api/v1/user/possibleGenders").then(r=>{console.log(r),console.log(m),m=r.data,t.value.gender=m[-1]});const C=async()=>{try{(await G.fire({title:"Success!",text:"Your registration was successful.",icon:"success",confirmButtonText:"Go to Login"})).isConfirmed&&(window.location.href="/")}catch(r){console.error("Error displaying SweetAlert:",r)}},h=()=>{if(t.value.password!=t.value.confirmPassword){t.value.registerError="passwords dont match";return}console.log(JSON.stringify(t.value)),_.post(V+"/api/v1/user/registerUser",t.value).then(r=>{console.log(r),t.value={},C()}).catch(r=>{console.log(r),r.response.status==400?t.value.registerError=r.response.data.fielderrors:t.value.registerError=r.response.data})};return(r,l)=>{const P=I("RouterLink");return g(),E("div",q,[e($,{class:"auth-card pa-4 pt-7","max-width":"448"},{default:a(()=>[e(R,{class:"justify-center"},{prepend:a(()=>[i("div",K,[i("div",{innerHTML:o(L)},null,8,Q)])]),default:a(()=>[e(H,{class:"font-weight-semibold text-2xl text-uppercase"},{default:a(()=>[u(" PExam System ")]),_:1})]),_:1}),e(y,{class:"pt-2"},{default:a(()=>[W,X]),_:1}),e(y,null,{default:a(()=>[e(n,{cols:"12",class:"text-center"},{default:a(()=>[i("p",ee,B(o(t).registerError),1)]),_:1}),o(w)?(g(),D(N,{key:0,indeterminate:"",color:"blue",size:"24",style:{position:"absolute","inset-block-start":"50%","inset-inline-start":"50%",transform:"translate(-50%, -50%)"}})):p("",!0),e(J,{onSubmit:l[10]||(l[10]=v(()=>{h()},["prevent"]))},{default:a(()=>[e(z,null,{default:a(()=>[e(n,{cols:"12"},{default:a(()=>[e(c,{modelValue:o(t).fullname,"onUpdate:modelValue":l[0]||(l[0]=s=>o(t).fullname=s),label:"Full name",placeholder:"Full Name"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(O,{"model-value":o(t).gender,"onUpdate:modelValue":l[1]||(l[1]=s=>o(t).gender=s),items:o(m),label:"Gender"},null,8,["model-value","items"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(c,{modelValue:o(t).username,"onUpdate:modelValue":l[2]||(l[2]=s=>o(t).username=s),label:"Username",placeholder:"username"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(c,{modelValue:o(t).email,"onUpdate:modelValue":l[3]||(l[3]=s=>o(t).email=s),label:"Email",placeholder:"ENter email",type:"email"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(c,{modelValue:o(t).phone,"onUpdate:modelValue":l[4]||(l[4]=s=>o(t).phone=s),label:"Phone",placeholder:"Enter Phone",type:"tel"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(c,{modelValue:o(t).password,"onUpdate:modelValue":l[5]||(l[5]=s=>o(t).password=s),label:"Password",placeholder:"············",type:o(d)?"text":"password","append-inner-icon":o(d)?"ri-eye-off-line":"ri-eye-line","onClick:appendInner":l[6]||(l[6]=s=>d.value=!o(d))},null,8,["modelValue","type","append-inner-icon"])]),_:1}),e(n,{cols:"12"},{default:a(()=>[e(c,{modelValue:o(t).confirmPassword,"onUpdate:modelValue":l[7]||(l[7]=s=>o(t).confirmPassword=s),label:"Confirm Password",placeholder:"············",type:o(d)?"text":"password","append-inner-icon":o(d)?"ri-eye-off-line":"ri-eye-line","onClick:appendInner":l[8]||(l[8]=s=>d.value=!o(d))},null,8,["modelValue","type","append-inner-icon"]),i("div",oe,[e(Y,{id:"privacy-policy",modelValue:o(t).privacyPolicies,"onUpdate:modelValue":l[9]||(l[9]=s=>o(t).privacyPolicies=s),inline:""},null,8,["modelValue"]),e(Z,{for:"privacy-policy",style:{opacity:"1"}},{default:a(()=>[te,le]),_:1})]),e(S,{block:"",type:"submit",onClick:v(h,["prevent"])},{default:a(()=>[u(" Sign up ")]),_:1})]),_:1}),e(n,{cols:"12",class:"text-center text-base"},{default:a(()=>[ae,e(P,{class:"text-primary ms-2",to:"login"},{default:a(()=>[u(" Sign in instead ")]),_:1})]),_:1}),p("",!0),p("",!0)]),_:1})]),_:1})]),_:1})]),_:1}),e(f,{class:"auth-footer-start-tree d-none d-md-block",src:o(j),width:250},null,8,["src"]),e(f,{src:o(A),class:"auth-footer-end-tree d-none d-md-block",width:350},null,8,["src"]),e(f,{class:"auth-footer-mask d-none d-md-block",src:o(k)},null,8,["src"])])}}};export{Fe as default};
