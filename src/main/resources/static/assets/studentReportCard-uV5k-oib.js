import{a as N}from"./axios-G2rPRu76.js";import{_ as S,Q as A,r as f,ac as B,l as D,m as t,a5 as z,R as k,o as h,n as e,b as n,c as E,a as o,t as _,a2 as x,V as R,Z as y}from"./index-2BP_lAh-.js";import{V as r,a as l}from"./VRow-xKr1Tf61.js";import{a as w,b as T,V as b}from"./VCard-LeQVuWP8.js";import{V as F}from"./VAlert-2aCyTCZg.js";import{V as I}from"./VContainer-z7RhW0vu.js";/* empty css              */import"./VAvatar-nprCTEVN.js";import"./VImg-noq4ZFey.js";A();const q={setup(){const i=f({admNo:""}),u=f(""),c=f(""),a=f({data:"",title:""});f(null);const m=A(),v=()=>{m.go(-1)},g=()=>{const C=window.location.protocol+"//"+window.location.hostname+":8080";u.value=m.currentRoute.value.query.admNo,c.value=m.currentRoute.value.query.examinationId,N.get(C+`/api/v1/student/viewStudent/${u.value}`,{headers:{Authorization:k.get("Authorization")}}).then(d=>{i.value=d.data.body}).catch(d=>{console.error("Error fetching student details:",d),d.response&&(d.response.status===401||d.response.status===403)&&window.open("/login","_blank")})},V=()=>{const d=window.location.protocol+"//"+window.location.hostname+":8080"+`/api/v1/reportCard/viewReportCard/${c.value}/${u.value}`;N.get(d,{responseType:"blob",headers:{Authorization:k.get("Authorization")}}).then(p=>{const U=new Blob([p.data],{type:"application/pdf"}),s=document.createElement("a");s.href=URL.createObjectURL(U),s.download=i.value.admNo+i.value.name+c+" Report Card.pdf",document.body.appendChild(s),document.body.removeChild(s),a.value.data=s.href,a.value.title=s.download}).catch(p=>{console.error("Error fetching PDF:",p)})};return B(()=>{g(),V()}),{studentDetails:i,admNo:u,examinationId:c,pdfUrl:a,fetchStudentDetails:g,loadPdf:V,searchAgain:v}}},L={key:0},O=o("strong",null,"Admission Number:",-1),P=o("strong",null,"Admission Number:",-1),j=o("strong",null,"Surname:",-1),M=o("strong",null,"First Name:",-1),Q=o("strong",null,"Other Name:",-1),Z=["download","href"],G=["src","title"];function H(i,u,c,a,m,v){return h(),D(z,null,{default:t(()=>[e(I,null,{default:t(()=>[e(r,null,{default:t(()=>[e(l,{cols:"12"},{default:t(()=>[e(w,{elevation:"3"},{default:t(()=>[e(T,{class:"text-h6 font-weight-bold"},{default:t(()=>[n("Student Report Card")]),_:1}),e(b,null,{default:t(()=>[e(l,{cols:"12"},{default:t(()=>[e(w,{title:"Student Details"},{default:t(()=>[e(b,{class:"d-flex"},{default:t(()=>[a.studentDetails==null?(h(),E("div",L,[e(r,{class:"w-100 d-block"},{default:t(()=>[e(l,null,{default:t(()=>[e(l,null,{default:t(()=>[o("p",null,[O,n(" "+_(this.admNo),1)])]),_:1})]),_:1})]),_:1}),e(r,{class:"w-100 d-block"},{default:t(()=>[e(l,null,{default:t(()=>[e(F,null,{default:t(()=>[n(" Record Not Found ")]),_:1})]),_:1})]),_:1}),e(r,null,{default:t(()=>[e(l,null,{default:t(()=>[e(x,{onClick:a.searchAgain},{default:t(()=>[e(R,{icon:"ri-restart-line"}),n(" Search Again ")]),_:1},8,["onClick"])]),_:1})]),_:1})])):y("",!0),a.studentDetails!=null?(h(),D(r,{key:1},{default:t(()=>[e(l,{md:"6",cols:"12"},{default:t(()=>[o("p",null,[P,n(" "+_(a.studentDetails.admNo),1)])]),_:1}),e(l,{md:"6",cols:"12"},{default:t(()=>[o("p",null,[j,n(" "+_(a.studentDetails.surname),1)])]),_:1}),e(l,{md:"6",cols:"12"},{default:t(()=>[o("p",null,[M,n(" "+_(a.studentDetails.firstName),1)])]),_:1}),e(l,{md:"6",cols:"12"},{default:t(()=>[o("p",null,[Q,n(" "+_(a.studentDetails.otherName),1)])]),_:1})]),_:1})):y("",!0)]),_:1}),o("a",{class:"btn btn-primary",color:"success",download:a.pdfUrl.title,href:a.pdfUrl.data},[e(x,{text:"Download"},{default:t(()=>[n(" Download _ "),e(R,{icon:"ri-download-line"})]),_:1})],8,Z)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(r,null,{default:t(()=>[e(l,null,{default:t(()=>[e(w,null,{default:t(()=>[e(b,null,{default:t(()=>[o("iframe",{src:a.pdfUrl.data,width:"100%",height:"1000",frameborder:"0",title:a.pdfUrl.title},null,8,G)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})}const ot=S(q,[["render",H]]);export{ot as default};
