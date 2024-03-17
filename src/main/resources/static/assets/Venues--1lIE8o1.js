import{Q as S,r as C,c as b,a as F,n as e,m as l,u as d,F as y,R as f,o as h,a2 as s,b as i,V as U,a4 as D,l as R,t as x,a3 as $}from"./index-Uh7jaitX.js";import{a as c}from"./axios-G2rPRu76.js";import{s as E}from"./sweetalert2.all-Lv0CwX9J.js";import{V as u,a as t}from"./VRow-YKHVWUPT.js";import{V as I}from"./VDialog-afQCRUHS.js";import{a as w,V as g,b as J,c as L}from"./VCard--Q3RrOcZ.js";import{V as k}from"./VForm-Qa0s-xNR.js";import{V as A}from"./VTextField-x5HF6B1a.js";import{V as p}from"./VSpacer-JNrHPOmG.js";/* empty css              */import"./VOverlay-JQMdgNY7.js";import"./easing-Apq16fr0.js";import"./lazy-VLJ9onKy.js";import"./VImg-3j7UJspv.js";import"./forwardRefs-y8pOSn8h.js";import"./dialog-transition-8h0jTMyV.js";import"./VAvatar-IC0G5Tcb.js";import"./form-ie-nNZkP.js";import"./VField-ZFhKK1Ca.js";import"./index-191e5APl.js";import"./VLabel-q3opiiJh.js";const de={__name:"Venues",setup(O){S();let V=window.location.protocol+"//"+window.location.hostname+":8080";const a=C({show:!1}),v=C(null),T=()=>{console.log(a.value),a.value.show=!0,a.value.name="",a.value.capacity="",a.value.num=null},B=()=>{a.value.num==null?c.post(V+"/api/v1/venue/addVenue",a.value,{headers:{Authorization:f.get("Authorization")}}).then(o=>{console.log(o.data),a.value.show=!1,m()}).catch(o=>{alert(JSON.stringify(o.response.data))}):c.put(V+"/api/v1/venue/updateVenue",a.value,{headers:{Authorization:f.get("Authorization")}}).then(o=>{console.log(o.data),a.value.show=!1,m()}).catch(o=>{alert(JSON.stringify(o.response.data))})},m=()=>{c.get(V+"/api/v1/venue/listVenues",{headers:{Authorization:f.get("Authorization")}}).then(o=>{console.log(o.data),v.value=o.data})};m();const z=o=>{a.value=o,a.value.show=!0},N=o=>{E.fire({title:"Delete Venue "+o.name,text:"Are you sure you want to delete this Venue?",icon:"warning",showCancelButton:!0,confirmButtonColor:"#d33",cancelButtonColor:"#3085d6",confirmButtonText:"Yes, delete it!"}).then(r=>{if(r.isConfirmed){const n=window.location.protocol+"//"+window.location.hostname+":8080";c.delete(n+`/api/v1/venue/deleteVenue/${o.num}`,{headers:{Authorization:f.get("Authorization")}}).then(_=>{console.log(_),m()})}})};return(o,r)=>(h(),b(y,null,[F("div",null,[e(u,null,{default:l(()=>[e(t,null,{default:l(()=>[e(w,null,{default:l(()=>[e(g,null,{default:l(()=>[e(u,null,{default:l(()=>[e(t,null,{default:l(()=>[e(s,{text:"TimeTable Home",to:"/teachingTimeTable"})]),_:1}),e(t,null,{default:l(()=>[e(s,{text:"TimeTable Settings",to:"/timetableSettings"})]),_:1}),e(t,null,{default:l(()=>[e(s,{text:"Venues",to:"/venues"})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(t,null,{default:l(()=>[e(w,null,{default:l(()=>[e(J,null,{default:l(()=>[i(" Learning Venues "),e(u,null,{default:l(()=>[e(t,null,{default:l(()=>[e(s,{onClick:T},{default:l(()=>[e(U,{icon:"ri-add-line"}),i(" Add New Venue ")]),_:1})]),_:1})]),_:1})]),_:1}),e(g,null,{default:l(()=>[e(k,null,{default:l(()=>[e(u,{style:{"font-weight":"bold"}},{default:l(()=>[e(t,null,{default:l(()=>[i(" Venue Name ")]),_:1}),e(t,null,{default:l(()=>[i(" Venue Capacity ")]),_:1}),e(t,null,{default:l(()=>[i(" Edit ")]),_:1}),e(t,null,{default:l(()=>[i(" Delete ")]),_:1})]),_:1}),(h(!0),b(y,null,D(d(v),n=>(h(),R(u,{key:n.num},{default:l(()=>[e(t,null,{default:l(()=>[i(x(n.name),1)]),_:2},1024),e(t,null,{default:l(()=>[i(x(n.capacity),1)]),_:2},1024),e(t,null,{default:l(()=>[e(s,{icon:"ri-edit-line",onClick:_=>z(n)},null,8,["onClick"])]),_:2},1024),e(t,null,{default:l(()=>[e(s,{icon:"ri-eraser-line",color:"error",onClick:_=>N(n)},null,8,["onClick"])]),_:2},1024)]),_:2},1024))),128))]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),e(I,{modelValue:d(a).show,"onUpdate:modelValue":r[2]||(r[2]=n=>d(a).show=n),class:"modal fade small-modal",cols:"12","max-width":"600"},{default:l(()=>[e(u,null,{default:l(()=>[e(t,null,{default:l(()=>[e(w,{title:"Venue Information"},{default:l(()=>[e(g,null,{default:l(()=>[e(k,null,{default:l(()=>[e(u,null,{default:l(()=>[e(t,null,{default:l(()=>[e(A,{label:"Venue Name",modelValue:d(a).name,"onUpdate:modelValue":r[0]||(r[0]=n=>d(a).name=n)},null,8,["modelValue"])]),_:1})]),_:1}),e(p),e(p),e(u,null,{default:l(()=>[e(t,null,{default:l(()=>[e(A,{label:"Venue Capacity",modelValue:d(a).capacity,"onUpdate:modelValue":r[1]||(r[1]=n=>d(a).capacity=n),type:"number"},null,8,["modelValue"])]),_:1})]),_:1}),e(u,null,{default:l(()=>[e(t,null,{default:l(()=>[e(p),e(p)]),_:1})]),_:1}),e(L,null,{default:l(()=>[e(u,null,{default:l(()=>[e(t,{color:"primary"},{default:l(()=>[e(s,{text:"Submit",type:"submit",onClick:$(B,["prevent"]),color:"white",class:"btn btn-primary w-100",style:{background:"blue",color:"white"}},{default:l(()=>[i(" Submit ")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1},8,["modelValue"])],64))}};export{de as default};
