import{a as m}from"./axios-G2rPRu76.js";import{r as p,Q as v,R as c,c as i,n as e,m as t,o as n,b as j,a2 as C,u as k,F as x,a4 as y,a as l,t as u}from"./index-Cp0a3j5Z.js";import{V as g,a as V}from"./VRow-e59EUwGS.js";import{a as G,b as R,V as A}from"./VCard-f1nee6yo.js";import{V as S}from"./VDataTable-wuuS0jak.js";import{V as f}from"./VTextField-74eHDJAa.js";/* empty css              */import"./VAvatar-MKe1hS_I.js";import"./VImg-xuUNPkdI.js";import"./VSelect-Jx7iHon2.js";import"./form-xXdqDCjs.js";import"./forwardRefs-y8pOSn8h.js";import"./VMenu-RzLdOBfR.js";import"./index-ogFRjp9r.js";import"./ssrBoot-DBy9na19.js";import"./VDivider-t6YFHrqH.js";import"./VOverlay-x4J7jcA1.js";import"./easing-Apq16fr0.js";import"./lazy-Pl5wsFII.js";import"./dialog-transition-VPrIJniv.js";import"./VCheckboxBtn-z-5o5nyt.js";import"./VLabel-X25Up-Eg.js";import"./VChip-8MtU5gPv.js";import"./VTable-Tng2Nuci.js";import"./VField-thFyAEi-.js";const le={__name:"subjectsGradings",setup(T){const o=p({subjectGradings:[],search:""}),h=v();let d=window.location.protocol+"//"+window.location.hostname+":8080";h.currentRoute.value.query.examinationId,p({data:[]}),m.get(d+"/api/v1/grading/viewGradings",{headers:{Authorization:c.get("Authorization")}}).then(r=>{o.value.subjectGradings=r.data});const _=()=>{console.log(o.value),m.put(d+"/api/v1/grading/updateGrading",o.value,{headers:{Authorization:c.get("Authorization")}}).then(r=>{console.log(r),alert("Saved Successfully")})};return(r,U)=>(n(),i("div",null,[e(g,null,{default:t(()=>[e(V,null,{default:t(()=>[e(G,null,{default:t(()=>[e(R,null,{default:t(()=>[j("Subjects Gradings")]),_:1}),e(g,{style:{float:"inline-end"}},{default:t(()=>[e(V,null,{default:t(()=>[e(C,{text:"Save Changes",class:"f-right",style:{float:"inline-end"},onClick:_})]),_:1})]),_:1}),e(A,null,{default:t(()=>[e(S,{items:k(o).subjectGradings,"items-per-page":20},{body:t(({items:b})=>[(n(!0),i(x,null,y(b,a=>(n(),i("tr",{key:a.id},[l("td",null,u(a.subjectCode),1),l("td",null,u(a.subjectName),1),l("td",null,u(a.subjectRep),1),l("td",null,[e(f,{modelValue:a.amarks,"onUpdate:modelValue":s=>a.amarks=s,placeholder:a.subjectRep+" A"},null,8,["modelValue","onUpdate:modelValue","placeholder"])]),l("td",null,[e(f,{modelValue:a.emarks,"onUpdate:modelValue":s=>a.emarks=s,placeholder:a.subjectRep+" E"},null,8,["modelValue","onUpdate:modelValue","placeholder"])])]))),128))]),_:1},8,["items"])]),_:1})]),_:1})]),_:1})]),_:1})]))}};export{le as default};
