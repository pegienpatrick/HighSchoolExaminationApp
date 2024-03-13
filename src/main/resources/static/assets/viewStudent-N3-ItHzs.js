import{a as g}from"./axios-G2rPRu76.js";import{_ as N,Y as D,e as f,w as t,a5 as C,o as _,b as e,B as o,c as V,a as l,t as u,a2 as m,V as k,Z as h}from"./index-K1XzZ2A_.js";import{s as B}from"./sweetalert2.all-UF8kCt7-.js";import{V as i,a as s}from"./VRow-Qf5i2-nC.js";import{a as S,b,V as w}from"./VCard-fvYJ7foH.js";import{V as y}from"./VAlert-HscTSSO4.js";import{V as x}from"./VContainer-kCvi0u3m.js";/* empty css              */import"./VAvatar-HVdCToNH.js";import"./VImg-W4g71V9b.js";const A={data(){return{studentDetails:{},admNo:""}},mounted(){this.fetchStudentDetails(),console.log("mounted"),this.fetchStudentDetails()},methods:{fetchStudentDetails(){const r=window.location.protocol+"//"+window.location.hostname+":8080";this.admNo=this.$route.query.admNo,g.get(r+`/api/v1/student/viewStudent/${this.admNo}`,{headers:{Authorization:D.get("Authorization")}}).then(a=>{console.log(a),this.studentDetails=a.data.body,console.log(this.studentDetails);const d=new Date(this.studentDetails.dateOfBirth),p=String(d.getDate()).padStart(2,"0"),n=String(d.getMonth()+1).padStart(2,"0"),c=d.getFullYear();this.studentDetails.dateOfBirth=`${p}-${n}-${c}`}).catch(a=>{console.error("Error fetching student details:",a),console.log(a),a.response&&(a.response.status===401||a.response.status===403)&&window.open("/login","_blank")})},editStudent(){this.$router.push(`/editStudent?admNo=${this.studentDetails.admNo}`)},deleteStudent(){B.fire({title:"Delete Student",text:"Are you sure you want to delete this student?",icon:"warning",showCancelButton:!0,confirmButtonColor:"#d33",cancelButtonColor:"#3085d6",confirmButtonText:"Yes, delete it!"}).then(r=>{if(r.isConfirmed){const a=window.location.protocol+"//"+window.location.hostname+":8080";g.get(a+`/api/v1/student/deleteStudent/${this.admNo}`,{headers:{Authorization:D.get("Authorization")}}).then(d=>{console.log(d),this.$router.push("/students")})}})}}},v={key:0},F=l("strong",null,"Admission Number:",-1),z=l("strong",null,"Admission Number:",-1),E=l("strong",null,"Surname:",-1),M=l("strong",null,"First Name:",-1),O=l("strong",null,"Other Name:",-1),T=l("strong",null,"Date of Birth:",-1),I=l("strong",null,"Gender:",-1),Y=l("strong",null,"Birth Certificate Number:",-1),R=l("strong",null,"IFMIS Number:",-1),U=l("strong",null,"Stage (Form):",-1),j=l("strong",null,"Stream:",-1),q=l("strong",null,"KCPE Marks:",-1),G=l("strong",null,"Cohort:",-1);function K(r,a,d,p,n,c){return _(),f(C,null,{default:t(()=>[e(x,null,{default:t(()=>[e(i,null,{default:t(()=>[e(s,{cols:"12"},{default:t(()=>[e(S,{elevation:"3"},{default:t(()=>[e(b,{class:"text-h6 font-weight-bold"},{default:t(()=>[o("Student Details")]),_:1}),e(w,null,{default:t(()=>[e(s,{cols:"12"},{default:t(()=>[e(S,{title:"Student Details"},{default:t(()=>[e(w,{class:"d-flex"},{default:t(()=>[n.studentDetails==null?(_(),V("div",v,[e(i,{class:"w-100 d-block"},{default:t(()=>[e(s,null,{default:t(()=>[e(s,null,{default:t(()=>[l("p",null,[F,o(" "+u(this.admNo),1)])]),_:1})]),_:1})]),_:1}),e(i,{class:"w-100 d-block"},{default:t(()=>[e(s,null,{default:t(()=>[e(y,null,{default:t(()=>[o(" Record Not Found ")]),_:1})]),_:1})]),_:1}),e(i,null,{default:t(()=>[e(s,null,{default:t(()=>[e(m,{to:"/searchStudent"},{default:t(()=>[e(k,{icon:"ri-restart-line"}),o(" Search Again ")]),_:1})]),_:1})]),_:1})])):h("",!0),n.studentDetails!=null?(_(),f(i,{key:1},{default:t(()=>[e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[z,o(" "+u(n.studentDetails.admNo),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[E,o(" "+u(n.studentDetails.surname),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[M,o(" "+u(n.studentDetails.firstName),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[O,o(" "+u(n.studentDetails.otherName),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[T,o(" "+u(n.studentDetails.dateOfBirth),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[I,o(" "+u(n.studentDetails.gender),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[Y,o(" "+u(n.studentDetails.birthCertno),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[R,o(" "+u(n.studentDetails.ifmisNo),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[U,o(" "+u(n.studentDetails.stage),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[j,o(" "+u(n.studentDetails.stream),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[q,o(" "+u(n.studentDetails.kcpeMarks),1)])]),_:1}),e(s,{md:"6",cols:"12"},{default:t(()=>[l("p",null,[G,o(" "+u(n.studentDetails.cohort),1)])]),_:1})]),_:1})):h("",!0)]),_:1})]),_:1})]),_:1}),n.studentDetails!=null?(_(),f(i,{key:0,justify:"center"},{default:t(()=>[e(s,null,{default:t(()=>[e(m,{onClick:c.editStudent,color:"primary"},{default:t(()=>[o("Edit Student")]),_:1},8,["onClick"])]),_:1}),e(s),e(s,null,{default:t(()=>[e(m,{onClick:c.deleteStudent,color:"warning"},{default:t(()=>[o("Delete Student")]),_:1},8,["onClick"])]),_:1})]),_:1})):h("",!0)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})}const et=N(A,[["render",K]]);export{et as default};
