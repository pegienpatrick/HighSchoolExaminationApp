import{x as se,al as ne,bI as ue,D as re,as as ie,a7 as de,H as me,h as y,r as V,aU as ce,w as H,L as fe,a9 as pe,n as e,F as M,P as Q,a1 as W,aV as Z,aa as ve,Q as Ve,U as be,c as G,m as l,u as r,a as w,o as T,b as k,t as L,i as U,a2 as q,a4 as ge,V as ye,a3 as X,l as Y,Z as O,k as we}from"./index-Uh7jaitX.js";import{a as J}from"./axios-G2rPRu76.js";import{V as _e}from"./VDialog-afQCRUHS.js";import{a as ee,b as le,d as K,V as R}from"./VCard--Q3RrOcZ.js";import{V as D,a as c}from"./VRow-YKHVWUPT.js";import{V as j}from"./VForm-Qa0s-xNR.js";import{d as xe,a as ke,u as he,b as Pe}from"./VField-ZFhKK1Ca.js";import{a as Ce}from"./VOverlay-JQMdgNY7.js";import{V as N}from"./VTextField-x5HF6B1a.js";import{V as Re,b as De,a as Ne,c as te}from"./VWindowItem-TkncDn4L.js";import"./VDivider-pTC1ROAL.js";import"./forwardRefs-y8pOSn8h.js";import"./dialog-transition-8h0jTMyV.js";import"./easing-Apq16fr0.js";import"./VAvatar-IC0G5Tcb.js";import"./VImg-3j7UJspv.js";/* empty css              */import"./form-ie-nNZkP.js";import"./index-191e5APl.js";import"./VLabel-q3opiiJh.js";import"./lazy-VLJ9onKy.js";import"./ssrBoot-ye3NbWHl.js";const Be=se({autofocus:Boolean,divider:String,focusAll:Boolean,label:{type:String,default:"$vuetify.input.otp"},length:{type:[Number,String],default:6},modelValue:{type:[Number,String],default:void 0},placeholder:String,type:{type:String,default:"number"},...ne(),...xe(),...ue(ke({variant:"outlined"}),["baseColor","bgColor","class","color","disabled","error","loading","rounded","style","theme","variant"])},"VOtpInput"),Fe=re()({name:"VOtpInput",props:Be(),emits:{finish:t=>!0,"update:focused":t=>!0,"update:modelValue":t=>!0},setup(t,z){let{attrs:$,emit:_,slots:g}=z;const{dimensionStyles:B}=ie(t),{isFocused:E,focus:u,blur:I}=he(t),d=de(t,"modelValue","",o=>String(o).split(""),o=>o.join("")),{t:h}=me(),x=y(()=>Number(t.length)),P=y(()=>Array(x.value).fill(0)),m=V(-1),C=V(),b=V([]),F=y(()=>b.value[m.value]);function s(){if(t.type==="number"&&/[^0-9]/g.test(F.value.value)){F.value.value="";return}const o=d.value.slice(),i=F.value.value;o[m.value]=i;let f=null;m.value>d.value.length?f=d.value.length+1:m.value+1!==x.value&&(f="next"),d.value=o,f&&Z(C.value,f)}function a(o){const i=d.value.slice(),f=m.value;let p=null;["ArrowLeft","ArrowRight","Backspace","Delete"].includes(o.key)&&(o.preventDefault(),o.key==="ArrowLeft"?p="prev":o.key==="ArrowRight"?p="next":["Backspace","Delete"].includes(o.key)&&(i[m.value]="",d.value=i,m.value>0&&o.key==="Backspace"?p="prev":requestAnimationFrame(()=>{var v;(v=b.value[f])==null||v.select()})),requestAnimationFrame(()=>{p!=null&&Z(C.value,p)}))}function A(o,i){var f,p;i.preventDefault(),i.stopPropagation(),d.value=(((f=i==null?void 0:i.clipboardData)==null?void 0:f.getData("Text"))??"").split(""),(p=b.value)==null||p[o].blur()}function n(){d.value=[]}function ae(o,i){u(),m.value=i}function oe(){I(),m.value=-1}return ce({VField:{color:y(()=>t.color),bgColor:y(()=>t.color),baseColor:y(()=>t.baseColor),disabled:y(()=>t.disabled),error:y(()=>t.error),variant:y(()=>t.variant)}},{scoped:!0}),H(d,o=>{o.length===x.value&&_("finish",o.join(""))},{deep:!0}),H(m,o=>{o<0||ve(()=>{var i;(i=b.value[o])==null||i.select()})}),fe(()=>{var f;const[o,i]=pe($);return e("div",Q({class:["v-otp-input",{"v-otp-input--divided":!!t.divider},t.class],style:[t.style]},o),[e("div",{ref:C,class:"v-otp-input__content",style:[B.value]},[P.value.map((p,v)=>e(M,null,[t.divider&&v!==0&&e("span",{class:"v-otp-input__divider"},[t.divider]),e(Pe,{focused:E.value&&t.focusAll||m.value===v,key:v},{...g,loader:void 0,default:()=>e("input",{ref:S=>b.value[v]=S,"aria-label":h(t.label,v+1),autofocus:v===0&&t.autofocus,autocomplete:"one-time-code",class:["v-otp-input__field"],disabled:t.disabled,inputmode:t.type==="number"?"numeric":"text",min:t.type==="number"?0:void 0,maxlength:"1",placeholder:t.placeholder,type:t.type==="number"?"text":t.type,value:d.value[v],onInput:s,onFocus:S=>ae(S,v),onBlur:oe,onKeydown:a,onPaste:S=>A(v,S)},null)})])),e("input",Q({class:"v-otp-input-input",type:"hidden"},i,{value:d.value.join("")}),null),e(Ce,{contained:!0,"content-class":"v-otp-input__loader","model-value":!!t.loading,persistent:!0},{default:()=>{var p;return[((p=g.loader)==null?void 0:p.call(g))??e(W,{color:typeof t.loading=="boolean"?void 0:t.loading,indeterminate:!0,size:"24",width:"2"},null)]}}),(f=g.default)==null?void 0:f.call(g)])])}),{blur:()=>{var o;(o=b.value)==null||o.some(i=>i.blur())},focus:()=>{var o;(o=b.value)==null||o[0].focus()},reset:n,isFocused:E}}}),Se={class:"auth-wrapper d-flex align-center justify-center pa-4"},Ue={class:"auth-wrapper d-flex align-center justify-center pa-4"},Ee=w("p",{class:"mb-0"}," Please Enter your Username and phone to send password reset code. ",-1),Ie=w("div",{class:"d-flex align-center justify-space-between flex-wrap mt-1 mb-4"},null,-1),Ae={class:"text-h6 font-weight-semibold text-error"},Te=w("p",{class:"mb-0"}," Please Enter your Username and email to send password reset code. ",-1),Le={class:"text-h6 font-weight-semibold text-error"},rl={__name:"forgotPassword",setup(t){const z=Ve(),$=be(),_=V($.params.tab),g=[{title:"Email Reset",icon:"ri-mail-fill",tab:"emailReset"},{title:"Sms Reset",icon:"ri-chat-1-fill",tab:"smsReset"}];let B=window.location.protocol+"//"+window.location.hostname+":8080";const E=[s=>!!s||"Phone number is required",s=>/^\d+$/.test(s)||"Phone number should only contain digits",s=>s.length===10||"Phone number should be 10 digits"],u=V({username:"",email:"",phone:"",smsError:"",emailError:"",success:!1,msg:""});let I=!1;V(!1);const d=V(!1),h=V(!1),x=V(""),P=V(""),m=V(""),C=()=>{J.post(B+"/api/v1/user/emailForgotPassword",u.value).then(s=>{console.log(s),u.value.emailError="",u.value.success=!0,u.value.msg=s.data}).catch(s=>{console.log(s),u.value.emailError=JSON.stringify(s.response.data)})},b=()=>{J.post(B+"/api/v1/user/smsForgotPassword",u.value).then(s=>{console.log(s),u.value.smsError="",u.value.success=!0,u.value.msg=s.data}).catch(s=>{console.log(s),u.value.smsError=JSON.stringify(s.response.data)})},F=()=>{J.post(B+"/api/v1/user/passwordReset",{username:u.value.username,resetCode:x.value,newPassword:P.value,confirmPassword:m.value}).then(s=>{console.log(s),alert(s.data),z.push("/login")}).catch(s=>{console.log(s),alert(JSON.stringify(s.response.data))})};return(s,a)=>{const A=we("RouterLink");return T(),G(M,null,[e(_e,{modelValue:r(u).success,"onUpdate:modelValue":a[5]||(a[5]=n=>r(u).success=n)},{default:l(()=>[e(D,null,{default:l(()=>[e(c,{cols:"12"},{default:l(()=>[w("div",Se,[e(ee,null,{default:l(()=>[e(le,null,{default:l(()=>[k(" Reset Password ")]),_:1}),e(j,null,{default:l(()=>[e(K,null,{default:l(()=>[w("p",null,L(r(u).msg),1)]),_:1}),e(R,null,{default:l(()=>[e(j,null,{default:l(()=>[e(D,{class:"mb-3"},{default:l(()=>[e(c,null,{default:l(()=>[e(Fe,{modelValue:r(x),"onUpdate:modelValue":a[0]||(a[0]=n=>U(x)?x.value=n:null),label:"Password Reset Code"},null,8,["modelValue"])]),_:1})]),_:1}),e(D,null,{default:l(()=>[e(c,null,{default:l(()=>[e(N,{modelValue:r(P),"onUpdate:modelValue":a[1]||(a[1]=n=>U(P)?P.value=n:null),type:r(d)?"text":"password","append-inner-icon":r(d)?"ri-eye-off-line":"ri-eye-line",label:"New Password",autocomplete:"on",placeholder:"············","onClick:appendInner":a[2]||(a[2]=n=>d.value=!r(d))},null,8,["modelValue","type","append-inner-icon"])]),_:1})]),_:1}),e(D,null,{default:l(()=>[e(c,null,{default:l(()=>[e(N,{modelValue:r(m),"onUpdate:modelValue":a[3]||(a[3]=n=>U(m)?m.value=n:null),type:r(h)?"text":"password","append-inner-icon":r(h)?"ri-eye-off-line":"ri-eye-line",autocomplete:"on",label:"Confirm New Password",placeholder:"············","onClick:appendInner":a[4]||(a[4]=n=>h.value=!r(h))},null,8,["modelValue","type","append-inner-icon"])]),_:1})]),_:1})]),_:1})]),_:1}),e(R,{class:"d-flex flex-wrap gap-4"},{default:l(()=>[e(q,{onClick:F},{default:l(()=>[k("Reset Password")]),_:1})]),_:1})]),_:1})]),_:1})])]),_:1})]),_:1})]),_:1},8,["modelValue"]),w("div",null,[w("div",Ue,[e(ee,{class:"auth-card pa-4 pt-7","max-width":"448"},{default:l(()=>[e(K,{class:"justify-center"},{default:l(()=>[e(le,{class:"font-weight-semibold text-2xl color-red",color:"error"},{default:l(()=>[k(" Reset Password ")]),_:1})]),_:1}),e(K,null,{default:l(()=>[e(Re,{modelValue:r(_),"onUpdate:modelValue":a[6]||(a[6]=n=>U(_)?_.value=n:null),"show-arrows":""},{default:l(()=>[(T(),G(M,null,ge(g,n=>e(De,{key:n.icon,value:n.tab},{default:l(()=>[e(ye,{size:"20",start:"",icon:n.icon},null,8,["icon"]),k(" "+L(n.title),1)]),_:2},1032,["value"])),64))]),_:1},8,["modelValue"])]),_:1}),e(Ne,{modelValue:r(_),"onUpdate:modelValue":a[13]||(a[13]=n=>U(_)?_.value=n:null),class:"mt-5 disable-tab-transition",touch:!1},{default:l(()=>[e(te,{value:"emailReset"},{default:l(()=>[e(R,{class:"pt-2"},{default:l(()=>[Ee]),_:1}),e(R,null,{default:l(()=>[e(j,{onSubmit:a[9]||(a[9]=()=>(s.preventDefault(),C(),!1))},{default:l(()=>[e(D,null,{default:l(()=>[e(c,{cols:"12"},{default:l(()=>[e(N,{modelValue:r(u).username,"onUpdate:modelValue":a[7]||(a[7]=n=>r(u).username=n),label:"username",type:"text"},null,8,["modelValue"])]),_:1}),e(c,{cols:"12"},{default:l(()=>[e(N,{type:"email",modelValue:r(u).email,"onUpdate:modelValue":a[8]||(a[8]=n=>r(u).email=n),mask:"email",label:"Enter Email"},null,8,["modelValue"]),Ie,e(q,{block:"",type:"submit",onClick:X(C,["prevent"])},{default:l(()=>[k(" Send Reset Code ")]),_:1})]),_:1}),r(I)?(T(),Y(W,{key:0,indeterminate:"",color:"blue",size:"24",style:{position:"absolute","inset-block-start":"50%","inset-inline-start":"50%",transform:"translate(-50%, -50%)"}})):O("",!0),e(c,{cols:"12",class:"text-center text-base"},{default:l(()=>[e(A,{class:"text-primary ms-2",to:"/login"},{default:l(()=>[k(" Back To Login ")]),_:1})]),_:1}),O("",!0),e(c,{cols:"12",class:"text-center"},{default:l(()=>[w("p",Ae,L(r(u).emailError),1)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(te,{value:"smsReset"},{default:l(()=>[e(R,{class:"pt-2"},{default:l(()=>[Te]),_:1}),e(R,null,{default:l(()=>[e(j,{onSubmit:a[12]||(a[12]=()=>(s.preventDefault(),b(),!1))},{default:l(()=>[e(D,null,{default:l(()=>[e(c,{cols:"12"},{default:l(()=>[e(N,{modelValue:r(u).username,"onUpdate:modelValue":a[10]||(a[10]=n=>r(u).username=n),label:"username",type:"text"},null,8,["modelValue"])]),_:1}),e(c,{cols:"12"},{default:l(()=>[e(N,{type:"tel",rules:E,mask:"phone",label:"Phone Number",modelValue:r(u).phone,"onUpdate:modelValue":a[11]||(a[11]=n=>r(u).phone=n)},null,8,["modelValue"])]),_:1}),e(c,null,{default:l(()=>[e(q,{block:"",type:"submit",onClick:X(b,["prevent"])},{default:l(()=>[k(" Send Reset Code ")]),_:1})]),_:1}),r(I)?(T(),Y(W,{key:0,indeterminate:"",color:"blue",size:"24",style:{position:"absolute","inset-block-start":"50%","inset-inline-start":"50%",transform:"translate(-50%, -50%)"}})):O("",!0),e(c,{cols:"12",class:"text-center text-base"},{default:l(()=>[e(A,{class:"text-primary ms-2",to:"/login"},{default:l(()=>[k(" Back To Login ")]),_:1})]),_:1}),O("",!0),e(c,{cols:"12",class:"text-center"},{default:l(()=>[w("p",Le,L(r(u).smsError),1)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1},8,["modelValue"])]),_:1})])])],64)}}};export{rl as default};
