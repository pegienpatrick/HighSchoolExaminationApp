import{a as B}from"./axios-G2rPRu76.js";import{_ as k,X as x,r as C,Y as y,c as d,b as o,w as r,o as u,u as n,a as m,F as A,a4 as D,t as F,a2 as N,B as T}from"./index-WVhmkmZF.js";import{V as p,a as c}from"./VRow-qsllNqOU.js";import{V as h}from"./VSelect-xmc4eIl2.js";import{V as $}from"./VTextField-I18sYzb4.js";import{V as I}from"./VDataTable-GTfkgqep.js";/* empty css              */import"./form-I9H_IUBv.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-51ahmtf-.js";import"./index-nMzItfZQ.js";import"./ssrBoot-YNbh2RHJ.js";import"./VImg-lYzg05eL.js";import"./VAvatar-9kArmvpM.js";import"./VDivider-PtOVpCpU.js";import"./VOverlay-RBq8L-PQ.js";import"./easing-imumzmxr.js";import"./lazy-m7CSEHGx.js";import"./VCheckboxBtn--5Nvab94.js";import"./VField-PtAP2JRC.js";import"./VChip-t0IRBmO3.js";import"./VTable-ZCjYzXs_.js";const O={__name:"students",setup(R){const f=x(),s=C({data:[],headers:[],search:""});let _=window.location.protocol+"//"+window.location.hostname+":8080";B.get(_+"/api/v1/student/allStudents",{headers:{"Content-Type":"application/json",Authorization:y.get("Authorization")}}).then(t=>{console.log(t);let e=t.data;const l=["num","reserved","guardians"];s.value.headers=Object.keys(e[0]).filter(i=>!l.includes(i));for(var a=0;a<e.length;a++){const i=new Date(e[a].dateOfBirth),S=String(i.getDate()).padStart(2,"0"),v=String(i.getMonth()+1).padStart(2,"0"),w=i.getFullYear();e[a].dateOfBirth=`${S}-${v}-${w}`,console.log(e[a].dateOfBirth),l.forEach(b=>{delete e[a][b]})}s.value.data=e}).catch(t=>{console.log(t),(t.response&&t.response.status===401||t.response.status===403)&&window.open("/login","_blank")});let g="";const V=t=>{f.push(`/viewStudent?admNo=${t.admNo}`)};return(t,e)=>(u(),d("div",null,[o(p,null,{default:r(()=>[o(c,null,{default:r(()=>[o(h,{label:"Select Stage (Form)",items:["All","1","2","3","4","Alumini"]})]),_:1}),o(c,null,{default:r(()=>[o(h,{label:"Select Stream ",items:["All","A","B","C"]})]),_:1})]),_:1}),o(p,null,{default:r(()=>[o($,{modelValue:n(s).search,"onUpdate:modelValue":e[0]||(e[0]=l=>n(s).search=l),label:"Search",onInput:n(g)},null,8,["modelValue","onInput"]),o(I,{items:n(s).data,class:"elevation-1 custom-table",striped:"",search:n(s).search},{item:r(({item:l})=>[m("tr",null,[(u(!0),d(A,null,D(n(s).headers,a=>(u(),d("td",{key:a.value},F(l[a]),1))),128)),m("td",null,[o(N,{onClick:a=>V(l)},{default:r(()=>[T("View")]),_:2},1032,["onClick"])])])]),_:1},8,["items","search"])]),_:1})]))}},lt=k(O,[["__scopeId","data-v-423bb586"]]);export{lt as default};
