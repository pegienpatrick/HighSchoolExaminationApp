import{a as g}from"./axios-G2rPRu76.js";import{_ as x,X as V,r,af as R,e as U,w as t,a5 as y,Y as B,o as k,b as a,B as c,a as d,t as w,a2 as D,V as N}from"./index-xVnyt9yu.js";import{V as f,a as s}from"./VRow-gHwNWVPx.js";import{a as p,b as T,V as m}from"./VCard-sd6GJVRG.js";import{V as q}from"./VContainer-76RWTzxp.js";/* empty css              */import"./VAvatar-iXQkcGmt.js";import"./VImg-YmpmSzhE.js";V();const A={setup(){const _=r({}),h=r(""),n=r(""),e=r({data:"google.com",title:""}),o=r({data:"",stream:""});r(null);const u=V(),v=()=>{o.value.data=u.currentRoute.value.query.stage,o.value.stream=u.currentRoute.value.query.stream,n.value=u.currentRoute.value.query.examinationId;const b=window.location.protocol+"//"+window.location.hostname+":8080"+`/api/v1/reportCard/bulkReportCards/${n.value}/${o.value.data}?stream=${o.value.stream}`;g.get(b,{responseType:"blob",headers:{Authorization:B.get("Authorization")}}).then(i=>{const C=new Blob([i.data],{type:"application/pdf"}),l=document.createElement("a");l.href=URL.createObjectURL(C),l.download=o.value.data+o.value.stream+n.value+" Report Card.pdf",document.body.appendChild(l),document.body.removeChild(l),e.value.data=l.href,e.value.title=l.download}).catch(i=>{console.error("Error fetching PDF:",i)})};return R(()=>{v()}),{studentDetails:_,admNo:h,examinationId:n,pdfUrl:e,loadPdf:v,stage:o}}},I=d("strong",null,"Form :",-1),S=d("strong",null,"Stream : ",-1),z=["download","href"],E=["src","title"];function F(_,h,n,e,o,u){return k(),U(y,null,{default:t(()=>[a(q,null,{default:t(()=>[a(f,null,{default:t(()=>[a(s,{cols:"12"},{default:t(()=>[a(p,{elevation:"3"},{default:t(()=>[a(T,{class:"text-h6 font-weight-bold"},{default:t(()=>[c("Student Report Cards")]),_:1}),a(m,null,{default:t(()=>[a(s,{cols:"12"},{default:t(()=>[a(p,{title:"Reports Cards"},{default:t(()=>[a(m,{class:"d-flex"},{default:t(()=>[a(f,null,{default:t(()=>[a(s,{md:"6",cols:"12"},{default:t(()=>[d("p",null,[I,c(" "+w(e.stage.data),1)])]),_:1}),a(s,{md:"6",cols:"12"},{default:t(()=>[d("p",null,[S,c(" "+w(e.stage.stream),1)])]),_:1})]),_:1})]),_:1}),d("a",{class:"btn btn-primary",color:"success",download:e.pdfUrl.title,href:e.pdfUrl.data},[a(D,{text:"Download"},{default:t(()=>[c(" Download _ "),a(N,{icon:"ri-download-line"})]),_:1})],8,z)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),a(f,null,{default:t(()=>[a(s,null,{default:t(()=>[a(p,null,{default:t(()=>[a(m,null,{default:t(()=>[d("iframe",{src:e.pdfUrl.data,width:"100%",height:"1000",frameborder:"0",title:e.pdfUrl.title},null,8,E)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})}const H=x(A,[["render",F]]);export{H as default};
