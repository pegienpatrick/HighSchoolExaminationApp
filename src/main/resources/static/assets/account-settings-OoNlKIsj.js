import{Q as F,r as c,R as v,l as w,m as l,o as x,n as e,a as u,t as A,u as s,a1 as P,Z as C,b as k,V,a2 as h}from"./index-2BP_lAh-.js";import{a as _}from"./axios-G2rPRu76.js";import{V as I,a as i}from"./VRow-xKr1Tf61.js";import{V as j}from"./VAlert-2aCyTCZg.js";import{a as L,b as N,V as S}from"./VCard-LeQVuWP8.js";import{V as z}from"./VSpacer-cUySo4_u.js";import{V as O}from"./VAvatar-nprCTEVN.js";import{V as B}from"./VDivider-unEwWr4n.js";import{V as G}from"./VForm-N6boVIal.js";import{V as b}from"./VTextField-vshtD9Ps.js";import{V as M}from"./VSelect-Eu2mWPD8.js";/* empty css              */import"./VImg-noq4ZFey.js";import"./form-v140H6Iy.js";import"./forwardRefs-y8pOSn8h.js";import"./VField-2KSXPk5K.js";import"./index-QAR5VDvd.js";import"./VLabel-PkvqaiGN.js";import"./VInput-fOfT7lUm.js";import"./easing-Apq16fr0.js";import"./VMenu-QWZbat62.js";import"./ssrBoot-qj21oVFS.js";import"./VOverlay-vCK72WMx.js";import"./lazy-CnP97q8J.js";import"./dialog-transition-zP723b51.js";import"./VCheckboxBtn-qa1S9f3S.js";import"./VChip-JOpZ6GZf.js";const J={class:"text-h6 font-weight-semibold text-error"},$={class:"d-flex flex-column justify-center gap-5"},q={class:"d-flex flex-wrap gap-2"},H=u("span",{class:"d-none d-sm-block"},"Select new photo",-1),K=u("span",{class:"d-none d-sm-block"},"Reset",-1),Q=u("p",{class:"text-body-1 mb-0"}," Allowed JPG, GIF or PNG. Max size of 800K ",-1),Y={class:"d-none d-sm-block"},Ee={__name:"account-settings",setup(Z){F();const y={avatarImg:""},n=c({registerError:"",dateOfBirth:""});let m=!1;const p=c(),a=c(structuredClone(y));c(!1);const T=o=>{const t=new FileReader,{files:r}=o.target;r&&r.length&&(t.readAsDataURL(r[0]),t.onload=()=>{typeof t.result=="string"&&(a.value.avatarImg=t.result)})},E=()=>{a.value.avatarImg=y.avatarImg};let f=window.location.protocol+"//"+window.location.hostname+":8080",g=c({data:0});const R=async()=>{if(a.value.fullname=a.value.fname,console.log(a.value.gender),a.value.gender==""||a.value.gender==null){n.value.registerError="You must select gender";return}m=!0;try{const o=await _.put(f+"/api/v1/user/updateUser",a.value,{headers:{"Content-Type":"application/json",Authorization:v.get("Authorization")}});m=!1,n.value.registerError="",g.value.data=new Date().getTime(),setTimeout(()=>{g.value.data=0},3e3),console.log("Success:",o.data)}catch(o){if(g.value.data=0,m=!1,console.log(o.response),n.value.registerError=o.response.data,o.response.status==403&&window.open("/","_blank"),o.response.status==400)try{n.value.registerError="";for(const[t,r]of Object.entries(JSON.parse(o.response.data.message).fielderrors))n.value.registerError+=` ${r}
`}catch{n.value.registerError=o.response.data}else n.value.registerError=o.response.data;console.log(n.value.registerError)}};_.get(f+"/api/v1/user/userInfo",{headers:{Authorization:v.get("Authorization")}}).then(o=>{console.log(o),a.value=o.data}).catch(o=>{console.error("Error fetching student details:",o),console.log(o),o.response&&(o.response.status===401||o.response.status===403)&&window.open("/login","_blank")}),_.get(f+"/api/v1/UserPhoto/getUserPhoto",{responseType:"blob",headers:{Authorization:v.get("Authorization")}}).then(o=>{const t=new Blob([o.data],{type:"application/png"});y.avatarImg=URL.createObjectURL(t),E()});const d=c({success:!1}),D=()=>{console.log(p.value.value);const o=new FormData;o.append("file",p.value.files[0]),console.log(Object.keys(o)),console.log(Object.values(o)),_.post(f+"/api/v1/UserPhoto/uploadUserPhoto",o,{headers:{"Content-Type":"multipart/form-data",Authorization:v.get("Authorization")}}).then(t=>{d.value.success=!0,window.setTimeout(()=>{d.value.success=!1},3e3)})};return(o,t)=>(x(),w(I,null,{default:l(()=>[e(i,{cols:"12",class:"text-center"},{default:l(()=>[u("p",J,A(s(n).registerError),1)]),_:1}),s(m)?(x(),w(P,{key:0,indeterminate:"",color:"blue",size:"24",style:{position:"absolute","inset-block-start":"50%","inset-inline-start":"50%",transform:"translate(-50%, -50%)"}})):C("",!0),s(g).data>0?(x(),w(j,{key:1},{default:l(()=>[k(" Updated Successsfully ")]),_:1})):C("",!0),e(i,{cols:"12"},{default:l(()=>[e(L,null,{default:l(()=>[e(N,null,{default:l(()=>[e(V,{icon:"ri-group-line"}),k(" Edit Account Details ")]),_:1}),e(z),e(z),e(S,{class:"d-flex"},{default:l(()=>[e(O,{rounded:"lg",size:"100",class:"me-6",image:s(a).avatarImg},null,8,["image"]),u("form",$,[u("div",q,[e(h,{color:"primary",onClick:t[0]||(t[0]=r=>{var U;return(U=s(p))==null?void 0:U.click()}),variant:"outlined"},{default:l(()=>[e(V,{icon:"ri-upload-cloud-line",class:"d-sm-none"}),H]),_:1}),u("input",{ref_key:"refInputEl",ref:p,type:"file",name:"file",accept:".jpeg,.png,.jpg,GIF",hidden:"",onInput:T},null,544),e(h,{type:"reset",color:"error",variant:"outlined",onClick:E},{default:l(()=>[K,e(V,{icon:"ri-refresh-line",class:"d-sm-none"})]),_:1})]),Q,e(h,{color:s(d).success?"success":"primary",onClick:D,modelValue:s(d).success,"onUpdate:modelValue":t[1]||(t[1]=r=>s(d).success=r)},{default:l(()=>[e(V,{icon:"ri-upload-cloud-line",class:"d-sm-none"}),u("span",Y,A(s(d).success?"Uploaded Successfully":"Upload photo"),1)]),_:1},8,["color","modelValue"])])]),_:1}),e(B),e(S,{class:"d-flex"},{default:l(()=>[e(G,{class:"mt-6"},{default:l(()=>[e(I,null,{default:l(()=>[e(i,{md:"6",cols:"12"},{default:l(()=>[e(b,{modelValue:s(a).fname,"onUpdate:modelValue":t[2]||(t[2]=r=>s(a).fname=r),label:"Full Name",type:"text"},null,8,["modelValue"])]),_:1}),e(i,{md:"6",cols:"12"},{default:l(()=>[e(b,{modelValue:s(a).username,"onUpdate:modelValue":t[3]||(t[3]=r=>s(a).username=r),label:"Username"},null,8,["modelValue"])]),_:1}),e(i,{md:"6",cols:"12"},{default:l(()=>[e(M,{modelValue:s(a).gender,"onUpdate:modelValue":t[4]||(t[4]=r=>s(a).gender=r),label:"Gender",items:["MALE","FEMALE","OTHER"],placeholder:"Select Gender",required:""},null,8,["modelValue"])]),_:1}),e(i,{md:"6",cols:"12"},{default:l(()=>[e(b,{modelValue:s(a).email,"onUpdate:modelValue":t[5]||(t[5]=r=>s(a).email=r),label:"Email",type:"email"},null,8,["modelValue"])]),_:1}),e(i,{md:"6",cols:"12"},{default:l(()=>[e(b,{modelValue:s(a).phone,"onUpdate:modelValue":t[6]||(t[6]=r=>s(a).phone=r),label:"Phone",type:"tel"},null,8,["modelValue"])]),_:1}),e(i,{cols:"12",class:"d-flex flex-wrap gap-4"},{default:l(()=>[e(h,{onClick:R},{default:l(()=>[k("Save Changes")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}))}};export{Ee as default};
