import{Q as L,U as $,r as s,c as g,n as e,m as l,u as t,i as p,o as y,F as k,a4 as A,V as h,b as c,t as T,a as d,a2 as x,R}from"./index-2f9Hlv8R.js";import{a as N}from"./axios-G2rPRu76.js";import{V as j,a as q,b as E,c as O}from"./VWindowItem-2l3a0Pjv.js";import{V as r,a as i}from"./VRow-301CAlQE.js";import{a as U,V as b,b as W}from"./VCard-GztQpVHa.js";import{V as J}from"./VForm-E-eGGIDK.js";import{V as C}from"./VTextField-ZYhTf-ir.js";import"./easing-Apq16fr0.js";import"./index-XqTsq3Jg.js";import"./lazy-15oThlyZ.js";import"./ssrBoot-aTzPBJTS.js";import"./VImg-K_L1p50j.js";/* empty css              */import"./VAvatar-RxVTU4x3.js";import"./form-IbVR8RoE.js";import"./forwardRefs-y8pOSn8h.js";import"./VField-tVuiktfm.js";import"./VLabel-gSMsACBq.js";const M=d("p",{class:"text-base font-weight-medium mt-2"}," Password Requirements: ",-1),Q={class:"d-flex flex-column gap-y-3"},G={class:"font-weight-medium"},H=d("p",null," This could be used incase you forgot to logout on a suspicious device or you suspect your account could have been hacked ",-1),we={__name:"password-settings",setup(K){const z=L();let P=window.location.protocol+"//"+window.location.hostname+":8080";const I=$(),u=s(I.params.tab),B=[{title:"Password Settings",icon:"ri-lock-line",tab:"security"}],m=s(!1),f=s(!1),w=s(!1),V=s(""),v=s(""),_=s(""),F=["Minimum 8 characters long - the more, the better","At least one lowercase character","At least one number, symbol, or whitespace character"],S=()=>{N.get(P+"/api/v1/user/logOutAllDevices",{headers:{"Content-Type":"application/json",Authorization:R.get("Authorization")}}).then(n=>{console.log(n),z.push("/login")})},D=()=>{N.put(P+"/api/v1/user/updatePassword",{oldPassword:V.value,newPassword:v.value,confirmPassword:_.value},{headers:{"Content-Type":"application/json",Authorization:R.get("Authorization")}}).then(n=>{console.log(n),alert(n.data)}).catch(n=>{console.log(n),alert("Error: "+JSON.stringify(n.response.data))})};return(n,a)=>(y(),g("div",null,[e(j,{modelValue:t(u),"onUpdate:modelValue":a[0]||(a[0]=o=>p(u)?u.value=o:null),"show-arrows":""},{default:l(()=>[(y(),g(k,null,A(B,o=>e(E,{key:o.icon,value:o.tab},{default:l(()=>[e(h,{size:"20",start:"",icon:o.icon},null,8,["icon"]),c(" "+T(o.title),1)]),_:2},1032,["value"])),64))]),_:1},8,["modelValue"]),e(q,{modelValue:t(u),"onUpdate:modelValue":a[7]||(a[7]=o=>p(u)?u.value=o:null),class:"mt-5 disable-tab-transition",touch:!1},{default:l(()=>[e(O,{value:"security"},{default:l(()=>[e(r,null,{default:l(()=>[e(i,{cols:"12"},{default:l(()=>[e(U,{title:"Change Password"},{default:l(()=>[e(J,null,{default:l(()=>[e(b,null,{default:l(()=>[e(r,{class:"mb-3"},{default:l(()=>[e(i,{cols:"12",md:"6"},{default:l(()=>[e(C,{modelValue:t(V),"onUpdate:modelValue":a[1]||(a[1]=o=>p(V)?V.value=o:null),type:t(m)?"text":"password","append-inner-icon":t(m)?"ri-eye-off-line":"ri-eye-line",autocomplete:"on",label:"Current Password",placeholder:"············","onClick:appendInner":a[2]||(a[2]=o=>m.value=!t(m))},null,8,["modelValue","type","append-inner-icon"])]),_:1})]),_:1}),e(r,null,{default:l(()=>[e(i,{cols:"12",md:"6"},{default:l(()=>[e(C,{modelValue:t(v),"onUpdate:modelValue":a[3]||(a[3]=o=>p(v)?v.value=o:null),type:t(f)?"text":"password","append-inner-icon":t(f)?"ri-eye-off-line":"ri-eye-line",label:"New Password",autocomplete:"on",placeholder:"············","onClick:appendInner":a[4]||(a[4]=o=>f.value=!t(f))},null,8,["modelValue","type","append-inner-icon"])]),_:1}),e(i,{cols:"12",md:"6"},{default:l(()=>[e(C,{modelValue:t(_),"onUpdate:modelValue":a[5]||(a[5]=o=>p(_)?_.value=o:null),type:t(w)?"text":"password","append-inner-icon":t(w)?"ri-eye-off-line":"ri-eye-line",autocomplete:"on",label:"Confirm New Password",placeholder:"············","onClick:appendInner":a[6]||(a[6]=o=>w.value=!t(w))},null,8,["modelValue","type","append-inner-icon"])]),_:1})]),_:1})]),_:1}),e(b,null,{default:l(()=>[M,d("ul",Q,[(y(),g(k,null,A(F,o=>d("li",{key:o,class:"d-flex"},[d("div",null,[e(h,{size:"7",icon:"ri-checkbox-blank-circle-fill",class:"me-3"})]),d("span",G,T(o),1)])),64))])]),_:1}),e(b,{class:"d-flex flex-wrap gap-4"},{default:l(()=>[e(x,{onClick:D},{default:l(()=>[c("Save changes")]),_:1}),e(x,{type:"reset",color:"secondary",variant:"outlined"},{default:l(()=>[c(" Reset ")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(r,null,{default:l(()=>[e(r,null,{default:l(()=>[e(i,null,{default:l(()=>[e(U,null,{default:l(()=>[e(W,null,{default:l(()=>[c(" Logging out from all devices ")]),_:1}),e(b,null,{default:l(()=>[e(r,null,{default:l(()=>[e(i,null,{default:l(()=>[H]),_:1})]),_:1}),e(r,null,{default:l(()=>[e(i,null,{default:l(()=>[e(x,{color:"error",variant:"outlined",onClick:S},{default:l(()=>[e(h,{icon:"ri-logout-box-r-line"}),c(" Logout Account from All Devices ")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1},8,["modelValue"])]))}};export{we as default};
