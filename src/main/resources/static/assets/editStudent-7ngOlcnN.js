import{a as h}from"./axios-G2rPRu76.js";import{X as P,r as m,Y as y,c as j,b as e,w as s,F as G,o as w,a as i,t as A,u as o,e as D,Z as O,B as N,a2 as _,V as S,a1 as L}from"./index-SGO5OOPy.js";import{_ as Y}from"./GuardiansForm-BnEDmlnv.js";import{V as C,a as n}from"./VRow-SKQ4CCOT.js";import{V as q}from"./VAlert-rCG5zR39.js";import{a as F,V as x,b as J}from"./VCard-iwGy2QZm.js";import{V as K}from"./VAvatar-aQ_KeIL1.js";import{V as H}from"./VDivider-J_lD5GQp.js";import{V as X}from"./VForm-7zjsCCKO.js";import{V as u}from"./VTextField-zjRFJMH_.js";import{V as I}from"./VSelect-XRxo3SYo.js";import"./VDialog-qZy5oQNk.js";import"./VOverlay-sta7PfT3.js";import"./easing-Apq16fr0.js";import"./lazy-Dwtquv-K.js";import"./VImg-nJ6DsKWr.js";import"./forwardRefs-y8pOSn8h.js";import"./dialog-transition-H9M13_Jl.js";import"./VTable-GWFtDMSE.js";/* empty css              */import"./form-syYsj1LP.js";import"./VField-JCquXGl7.js";import"./index-vWDdzW97.js";import"./VMenu-Jk-FC-iD.js";import"./ssrBoot-dRiIKdbQ.js";import"./VCheckboxBtn-N82T6j1u.js";import"./VChip-AExESlP7.js";const Z={class:"text-h6 font-weight-semibold text-error"},Q={class:"d-flex flex-column justify-center gap-5"},W={class:"d-flex flex-wrap gap-2"},ee=i("span",{class:"d-none d-sm-block"},"Select new photo",-1),te=i("span",{class:"d-none d-sm-block"},"Reset",-1),ae=i("p",{class:"text-body-1 mb-0"}," Allowed JPG, GIF or PNG. Max size of 800K ",-1),oe={class:"d-none d-sm-block"},De={__name:"editStudent",setup(le){const $=P(),k={admNo:"",surname:"",firstName:"",otherName:"",dateOfBirth:"",birthCertno:"",nemisNo:"",gender:"",stream:"",stage:"",kcpeMarks:"",cohort:""},d=m({registerError:"",dateOfBirth:""});let f=!1;const g=m(),l=m(structuredClone(k));m(!1);const z=r=>{const t=new FileReader,{files:a}=r.target;a&&a.length&&(t.readAsDataURL(a[0]),t.onload=()=>{typeof t.result=="string"&&(l.value.avatarImg=t.result)})},B=()=>{l.value.avatarImg=k.avatarImg};let V=window.location.protocol+"//"+window.location.hostname+":8080";const M=m({admNo:"",name:""}),v=$.currentRoute.value.query.admNo;let b=m({data:0});const T=async()=>{if(console.log(l.value.gender),l.value.gender==""||l.value.gender==null){d.value.registerError="You must select gender";return}f=!0,l.value.dateOfBirth=new Date(d.value.dateOfBirth);try{const r=await h.put(V+`/api/v1/student/updateStudent/${v}`,l.value,{headers:{"Content-Type":"application/json",Authorization:y.get("Authorization")}});f=!1,d.value.registerError="",console.log(M),b.value.data=new Date().getTime(),setTimeout(()=>{b.value.data=0},3e3),console.log("Success:",r.data)}catch(r){if(b.value.data=0,f=!1,console.log(r.response),d.value.registerError=r.response.data,r.response.status==403&&window.open("/","_blank"),r.response.status==400)try{d.value.registerError="";for(const[t,a]of Object.entries(JSON.parse(r.response.data.message).fielderrors))d.value.registerError+=` ${a}
`}catch{d.value.registerError=r.response.data}else d.value.registerError=r.response.data;console.log(d.value.registerError)}};h.get(V+`/api/v1/student/viewStudent/${v}`,{headers:{Authorization:y.get("Authorization")}}).then(r=>{console.log(r);var t=r.data.body;console.log(t);const a=new Date(t.dateOfBirth),c=String(a.getDate()).padStart(2,"0"),E=String(a.getMonth()+1).padStart(2,"0"),U=a.getFullYear();t.dateOfBirth=`${c}-${E}-${U}`,d.value.dateOfBirth=`${U}-${E}-${c}`,console.log(d.value.dateOfBirth),l.value=t}).catch(r=>{console.error("Error fetching student details:",r),console.log(r),r.response&&(r.response.status===401||r.response.status===403)&&window.open("/login","_blank")}),h.get(V+`/api/v1/studentPhoto/getStudentPhoto/${v}`,{responseType:"blob",headers:{Authorization:y.get("Authorization")}}).then(r=>{const t=new Blob([r.data],{type:"application/png"});k.avatarImg=URL.createObjectURL(t),B()});const p=m({success:!1}),R=()=>{console.log(g.value.value);const r=new FormData;r.append("file",g.value.files[0]),console.log(Object.keys(r)),console.log(Object.values(r)),h.post(V+`/api/v1/studentPhoto/uploadStudentPhoto/${v}`,r,{headers:{"Content-Type":"multipart/form-data",Authorization:y.get("Authorization")}}).then(t=>{p.value.success=!0,window.setTimeout(()=>{p.value.success=!1},3e3)})};return(r,t)=>(w(),j(G,null,[e(C,null,{default:s(()=>[e(n,{cols:"12",class:"text-center"},{default:s(()=>[i("p",Z,A(o(d).registerError),1)]),_:1}),o(f)?(w(),D(L,{key:0,indeterminate:"",color:"blue",size:"24",style:{position:"absolute","inset-block-start":"50%","inset-inline-start":"50%",transform:"translate(-50%, -50%)"}})):O("",!0),o(b).data>0?(w(),D(q,{key:1},{default:s(()=>[N(" Updated Successsfully ")]),_:1})):O("",!0),e(n,{cols:"12"},{default:s(()=>[e(F,{title:"Edit Student Details"},{default:s(()=>[e(x,{class:"d-flex"},{default:s(()=>[e(K,{rounded:"lg",size:"100",class:"me-6",image:o(l).avatarImg},null,8,["image"]),i("form",Q,[i("div",W,[e(_,{color:"primary",onClick:t[0]||(t[0]=a=>{var c;return(c=o(g))==null?void 0:c.click()}),variant:"outlined"},{default:s(()=>[e(S,{icon:"ri-upload-cloud-line",class:"d-sm-none"}),ee]),_:1}),i("input",{ref_key:"refInputEl",ref:g,type:"file",name:"file",accept:".jpeg,.png,.jpg,GIF",hidden:"",onInput:z},null,544),e(_,{type:"reset",color:"error",variant:"outlined",onClick:B},{default:s(()=>[te,e(S,{icon:"ri-refresh-line",class:"d-sm-none"})]),_:1})]),ae,e(_,{color:o(p).success?"success":"primary",onClick:R,modelValue:o(p).success,"onUpdate:modelValue":t[1]||(t[1]=a=>o(p).success=a)},{default:s(()=>[e(S,{icon:"ri-upload-cloud-line",class:"d-sm-none"}),i("span",oe,A(o(p).success?"Uploaded Successfully":"Upload photo"),1)]),_:1},8,["color","modelValue"])])]),_:1}),e(H),e(x,{class:"d-flex"},{default:s(()=>[e(X,{class:"mt-6"},{default:s(()=>[e(C,null,{default:s(()=>[e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).admNo,"onUpdate:modelValue":t[2]||(t[2]=a=>o(l).admNo=a),label:"Admission Number",type:"number"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).surname,"onUpdate:modelValue":t[3]||(t[3]=a=>o(l).surname=a),label:"Surname"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).firstName,"onUpdate:modelValue":t[4]||(t[4]=a=>o(l).firstName=a),label:"First Name"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).otherName,"onUpdate:modelValue":t[5]||(t[5]=a=>o(l).otherName=a),label:"Other Name"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(d).dateOfBirth,"onUpdate:modelValue":t[6]||(t[6]=a=>o(d).dateOfBirth=a),label:"Date of Birth",type:"date",placeholder:"YYYY-MM-DD"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(I,{modelValue:o(l).gender,"onUpdate:modelValue":t[7]||(t[7]=a=>o(l).gender=a),label:"Gender",items:["MALE","FEMALE","OTHER"],placeholder:"Select Gender",required:""},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).birthCertno,"onUpdate:modelValue":t[8]||(t[8]=a=>o(l).birthCertno=a),label:"Birth Certificate Number"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).nemisNo,"onUpdate:modelValue":t[9]||(t[9]=a=>o(l).nemisNo=a),label:"nemis Number"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).stage,"onUpdate:modelValue":t[10]||(t[10]=a=>o(l).stage=a),label:"Stage (Form)",type:"number"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(I,{modelValue:o(l).stream,"onUpdate:modelValue":t[11]||(t[11]=a=>o(l).stream=a),label:"Stream",items:["A","B","C"]},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).kcpeMarks,"onUpdate:modelValue":t[12]||(t[12]=a=>o(l).kcpeMarks=a),label:"KCPE Marks",type:"number"},null,8,["modelValue"])]),_:1}),e(n,{md:"6",cols:"12"},{default:s(()=>[e(u,{modelValue:o(l).cohort,"onUpdate:modelValue":t[13]||(t[13]=a=>o(l).cohort=a),label:"Cohort",type:"number"},null,8,["modelValue"])]),_:1}),e(n,{cols:"12",class:"d-flex flex-wrap gap-4"},{default:s(()=>[e(_,{onClick:T},{default:s(()=>[N("Save Changes")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(C,null,{default:s(()=>[e(n,null,{default:s(()=>[e(F,null,{default:s(()=>[e(J,null,{default:s(()=>[N(" Guardians ")]),_:1}),e(x,null,{default:s(()=>[e(Y)]),_:1})]),_:1})]),_:1})]),_:1})],64))}};export{De as default};
