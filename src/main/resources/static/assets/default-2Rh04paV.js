import{_ as rt,o as k,c as tt,a as T,b as V,t as P,i as Bt,r as C,u as R,d as bt,e as nt,f as Nt,w as et,s as Vt,h as $t,j as yt,k as j,l as I,m as f,n as i,V as x,p as U,q as M,v as wt,F as Dt,x as _t,I as Ot,y as St,z as jt,A as Ut,B as Tt,C as Kt,D as Lt,E as qt,G as Ft,H as zt,J as Gt,K as Jt,L as Yt,M as Qt,N as Zt,O as te,P as lt,Q as ee,R as ot,S as X,T as Rt,U as Wt,W as Xt,X as xt,Y as ne}from"./index-2BP_lAh-.js";import{V as re}from"./VTooltip-LPHjr0PH.js";import{a as at}from"./avatar-1-nH9r29IQ.js";import{a as it}from"./axios-G2rPRu76.js";import{V as st}from"./VAvatar-nprCTEVN.js";import{m as le,M as oe,V as ct}from"./VImg-noq4ZFey.js";import{V as ae,a as ie,b as F,c as z,d as se}from"./VMenu-QWZbat62.js";import{V as ut}from"./VDivider-unEwWr4n.js";import{l as kt}from"./logo-lSNaS3Cd.js";import{V as ce}from"./VSpacer-cUySo4_u.js";import"./VOverlay-vCK72WMx.js";import"./easing-Apq16fr0.js";import"./lazy-CnP97q8J.js";import"./forwardRefs-y8pOSn8h.js";import"./index-QAR5VDvd.js";import"./ssrBoot-qj21oVFS.js";import"./dialog-transition-zP723b51.js";/* empty css              */const ue={},he={class:"h-100 d-flex align-center justify-space-between"},de={class:"d-flex align-center"},fe=T("a",{href:"https://pegien.co.ke",target:"_blank",rel:"noopener noreferrer",class:"text-primary ms-1"},"Patrick",-1);function ve(t,e){return k(),tt("div",he,[T("span",de,[V(" © "+P(new Date().getFullYear())+" Made By ",1),fe])])}const pe=rt(ue,[["render",ve]]);function Q(t){return typeof t=="function"?t():R(t)}typeof WorkerGlobalScope<"u"&&globalThis instanceof WorkerGlobalScope;const me=()=>{};function ge(t,e){function n(...l){return new Promise((a,s)=>{Promise.resolve(t(()=>e.apply(this,l),{fn:e,thisArg:this,args:l})).then(a).catch(s)})}return n}const Ht=t=>t();function be(t=Ht){const e=C(!0);function n(){e.value=!1}function l(){e.value=!0}const a=(...s)=>{e.value&&t(...s)};return{isActive:bt(e),pause:n,resume:l,eventFilter:a}}function ye(...t){if(t.length!==1)return nt(...t);const e=t[0];return typeof e=="function"?bt(Nt(()=>({get:e,set:me}))):C(e)}function we(t,e,n={}){const{eventFilter:l=Ht,...a}=n;return et(t,ge(l,e),a)}function ht(t,e,n={}){const{eventFilter:l,...a}=n,{eventFilter:s,pause:o,resume:c,isActive:r}=be(l);return{stop:we(t,e,{...a,eventFilter:s}),pause:o,resume:c,isActive:r}}function _e(t,e,...[n]){const{flush:l="sync",deep:a=!1,immediate:s=!0,direction:o="both",transform:c={}}=n||{},r=[],h="ltr"in c&&c.ltr||(p=>p),u="rtl"in c&&c.rtl||(p=>p);return(o==="both"||o==="ltr")&&r.push(ht(t,p=>{r.forEach(y=>y.pause()),e.value=h(p),r.forEach(y=>y.resume())},{flush:l,deep:a,immediate:s})),(o==="both"||o==="rtl")&&r.push(ht(e,p=>{r.forEach(y=>y.pause()),t.value=u(p),r.forEach(y=>y.resume())},{flush:l,deep:a,immediate:s})),()=>{r.forEach(p=>p.stop())}}function Se(t=!1,e={}){const{truthyValue:n=!0,falsyValue:l=!1}=e,a=Bt(t),s=C(t);function o(c){if(arguments.length)return s.value=c,s.value;{const r=Q(n);return s.value=s.value===r?Q(l):r,s.value}}return a?o:[s,o]}function Te(t,e){const n=Vt(h()),l=ye(t),a=$t({get(){var u;const m=l.value;let p=e!=null&&e.getIndexOf?e.getIndexOf(n.value,m):m.indexOf(n.value);return p<0&&(p=(u=e==null?void 0:e.fallbackIndex)!=null?u:0),p},set(u){s(u)}});function s(u){const m=l.value,p=m.length,y=(u%p+p)%p,d=m[y];return n.value=d,d}function o(u=1){return s(a.value+u)}function c(u=1){return o(u)}function r(u=1){return o(-u)}function h(){var u,m;return(m=Q((u=e==null?void 0:e.initialValue)!=null?u:Q(t)[0]))!=null?m:void 0}return et(l,()=>s(a.value)),{state:n,index:a,next:c,prev:r}}const Le={class:"text-capitalize"},Ye={__name:"ThemeSwitcher",props:{themes:{type:Array,required:!0}},setup(t){const e=t,{name:n,global:l}=yt(),{state:a,next:s,index:o}=Te(e.themes.map(r=>r.name),{initialValue:n}),c=()=>{l.name.value=s()};return et(()=>l.name.value,r=>{a.value=r}),(r,h)=>{const u=j("IconBtn");return k(),I(u,{onClick:c},{default:f(()=>[i(x,{icon:e.themes[R(o)].icon},null,8,["icon"]),i(re,{activator:"parent","open-delay":"1000","scroll-strategy":"close"},{default:f(()=>[T("span",Le,P(R(a)),1)]),_:1})]),_:1})}}},Re={__name:"NavbarThemeSwitcher",setup(t){const e=[{name:"light",icon:"ri-sun-line"},{name:"dark",icon:"ri-moon-clear-line"}];return(n,l)=>{const a=Ye;return k(),I(a,{themes:e})}}},We={class:"nav-item-title"},Xe={class:"nav-group-children-wrapper"},xe={class:"nav-group-children"},N={__name:"VerticalNavGroup",props:{item:{type:Object,required:!0}},setup(t){const e=C(!1);return(n,l)=>(k(),tt("li",{class:U(["nav-group",R(e)&&"open"])},[T("div",{class:"nav-group-label",onClick:l[0]||(l[0]=a=>e.value=!R(e))},[i(x,{icon:t.item.icon||"ri-checkbox-blank-circle-line",class:"nav-item-icon"},null,8,["icon"]),T("span",We,P(t.item.title),1),T("span",{class:U(["nav-item-badge",t.item.badgeClass])},P(t.item.badgeContent),3),i(x,{icon:"ri-arrow-right-s-line",class:"nav-group-arrow"})]),T("div",Xe,[T("ul",xe,[M(n.$slots,"default")])])],2))}},ke={class:"nav-item-title"},_={__name:"VerticalNavLink",props:{item:{type:null,required:!0}},setup(t){return(e,n)=>(k(),tt("li",{class:U(["nav-link",{disabled:t.item.disable}])},[(k(),I(wt(t.item.to?"RouterLink":"a"),{to:t.item.to,href:t.item.href,target:t.item.target},{default:f(()=>[i(x,{icon:t.item.icon||"ri-checkbox-blank-circle-line",class:"nav-item-icon"},null,8,["icon"]),T("span",ke,P(t.item.title),1),T("span",{class:U(["nav-item-badge",t.item.badgeClass])},P(t.item.badgeContent),3)]),_:1},8,["to","href","target"]))],2))}},He={__name:"NavItems",setup(t){return(e,n)=>(k(),tt(Dt,null,[i(_,{item:{title:"DashBoard",to:"/dashboard",icon:"ri-home-line"}}),i(N,{item:{title:"Admin",icon:"ri-settings-4-line"}},{default:f(()=>[i(_,{item:{title:"All Users",to:"/users",icon:"ri-user-line"}}),i(_,{item:{title:"System Logs",to:"/systemLogs",icon:"ri-file-list-2-line"}}),i(_,{item:{title:"Import Students",to:"/importStudents",icon:"ri-file-list-2-line"}})]),_:1}),i(N,{item:{title:"Students",icon:"ri-user-3-line"}},{default:f(()=>[i(_,{item:{title:"Admissions",to:"/admissions",icon:"ri-add-circle-line"}}),i(_,{item:{title:"View Students",to:"/students",icon:"ri-eye-line"}}),i(_,{item:{title:"search Student",to:"/searchStudent",icon:"ri-search-line"}}),i(_,{item:{title:"Students Subjects",to:"/studentsubjects",icon:"ri-article-line"}})]),_:1}),i(N,{item:{title:"Examinations",icon:"ri-pencil-line"}},{default:f(()=>[i(_,{item:{title:"Create Examination",to:"/createExam",icon:"ri-pencil-line"}}),i(_,{item:{title:"view Examinations",to:"/viewTerms",icon:"ri-book-line"}}),i(_,{item:{title:"Subjects Grading",to:"/subjectsGrading",icon:"ri-book-2-line"}})]),_:1}),i(N,{item:{title:"SMS Service",icon:"ri-message-2-line"}},{default:f(()=>[i(_,{item:{title:"Sms Stats",to:"/smsStats",icon:"ri-book-2-line"}}),i(_,{item:{title:"Send SMS",to:"/composeSMS",icon:"ri-send-plane-2-line"}}),i(_,{item:{title:"SMS Logs",to:"/smsLogs",icon:"ri-file-list-2-line"}}),i(_,{item:{title:"SMS Balance",to:"/smsBalance",icon:"ri-money-dollar-box-line"}})]),_:1}),i(N,{item:{title:"TimeTables",icon:"ri-time-line"}},{default:f(()=>[i(_,{item:{title:"Exams TimeTables",to:"/examTimeTable",icon:"ri-pencil-line"}}),i(_,{item:{title:"Teaching Timetables",to:"/teachingTimeTable",icon:"ri-book-line"}}),i(_,{item:{title:"Subject Teachers",to:"/subjectTeachers",icon:"ri-ruler-line"}}),i(_,{item:{title:"Venues",to:"/venues",icon:"ri-school-line"}})]),_:1}),i(N,{item:{title:"User Profile",icon:"ri-user-line"}},{default:f(()=>[i(_,{item:{title:"Edit Profile",to:"/profile",icon:"ri-pencil-line"}}),i(_,{item:{title:"Change Password",to:"/profilePassword",icon:"ri-lock-password-line"}}),i(_,{item:{title:"Notifications",to:"/notifications",icon:"ri-notification-line"}})]),_:1})],64))}},Ee=_t({bordered:Boolean,color:String,content:[Number,String],dot:Boolean,floating:Boolean,icon:Ot,inline:Boolean,label:{type:String,default:"$vuetify.badge"},max:[Number,String],modelValue:{type:Boolean,default:!0},offsetX:[Number,String],offsetY:[Number,String],textColor:String,...St(),...jt({location:"top end"}),...Ut(),...Tt(),...Kt(),...le({transition:"scale-rotate-transition"})},"VBadge"),dt=Lt()({name:"VBadge",inheritAttrs:!1,props:Ee(),setup(t,e){const{backgroundColorClasses:n,backgroundColorStyles:l}=qt(nt(t,"color")),{roundedClasses:a}=Ft(t),{t:s}=zt(),{textColorClasses:o,textColorStyles:c}=Gt(nt(t,"textColor")),{themeClasses:r}=yt(),{locationStyles:h}=Jt(t,!0,u=>(t.floating?t.dot?2:4:t.dot?8:12)+(["top","bottom"].includes(u)?+(t.offsetY??0):["left","right"].includes(u)?+(t.offsetX??0):0));return Yt(()=>{const u=Number(t.content),m=!t.max||isNaN(u)?t.content:u<=+t.max?u:`${t.max}+`,[p,y]=Qt(e.attrs,["aria-atomic","aria-label","aria-live","role","title"]);return i(t.tag,lt({class:["v-badge",{"v-badge--bordered":t.bordered,"v-badge--dot":t.dot,"v-badge--floating":t.floating,"v-badge--inline":t.inline},t.class]},y,{style:t.style}),{default:()=>{var d,v;return[i("div",{class:"v-badge__wrapper"},[(v=(d=e.slots).default)==null?void 0:v.call(d),i(oe,{transition:t.transition},{default:()=>{var L,b;return[Zt(i("span",lt({class:["v-badge__badge",r.value,n.value,a.value,o.value],style:[l.value,c.value,t.inline?{}:h.value],"aria-atomic":"true","aria-label":s(t.label,u),"aria-live":"polite",role:"status"},p),[t.dot?void 0:e.slots.badge?(b=(L=e.slots).badge)==null?void 0:b.call(L):t.icon?i(x,{icon:t.icon},null):m]),[[te,t.modelValue]])]}})])]}})}),{}}}),Ae=_t({start:Boolean,end:Boolean,...St(),...Tt()},"VListItemAction"),Pe=Lt()({name:"VListItemAction",props:Ae(),setup(t,e){let{slots:n}=e;return Yt(()=>i(t.tag,{class:["v-list-item-action",{"v-list-item-action--start":t.start,"v-list-item-action--end":t.end},t.class],style:t.style},n)),{}}}),Ce={__name:"UserProfile",setup(t){const e=ee();let n=window.location.protocol+"//"+window.location.hostname+":8080";const l={userInfo:{}},a=()=>{console.log("Checking User"),it.get(n+"/api/v1/user/checkUser",{headers:{"Content-Type":"application/json",Authorization:ot.get("Authorization")}}).then(o=>{l.userInfo=o.data}).catch(o=>{console.log(o),(o.response&&o.response.status===401||o.response.status===403)&&(console.log("Current Path : "+e.currentRoute.value.fullPath),e.currentRoute.value.path!="/register"&&e.currentRoute.value.path!="/forgotPassword"&&e.currentRoute.value.path!="/login"&&e.push("/login"))})};window.setInterval(a,8e3),a();const s=()=>{it.get(n+"/api/v1/user/logOut",{headers:{"Content-Type":"application/json",Authorization:ot.get("Authorization")}}).then(o=>{console.log(o),e.push("/login")})};return(o,c)=>(k(),I(dt,{dot:"",location:"bottom right","offset-x":"3","offset-y":"3",color:"success",bordered:""},{default:f(()=>[i(st,{class:"cursor-pointer",color:"primary",variant:"tonal"},{default:f(()=>[i(ct,{src:R(at)},null,8,["src"]),i(ae,{activator:"parent",width:"230",location:"bottom end",offset:"14px"},{default:f(()=>[i(ie,null,{default:f(()=>[i(F,null,{prepend:f(()=>[i(Pe,{start:""},{default:f(()=>[i(dt,{dot:"",location:"bottom right","offset-x":"3","offset-y":"3",color:"success"},{default:f(()=>[i(st,{color:"primary",variant:"tonal"},{default:f(()=>[i(ct,{src:R(at)},null,8,["src"])]),_:1})]),_:1})]),_:1})]),default:f(()=>[i(z,{class:"font-weight-semibold"},{default:f(()=>[V(P(l.userInfo.username),1)]),_:1}),i(se,null,{default:f(()=>[V(P(l.userInfo.fname),1)]),_:1})]),_:1}),i(ut,{class:"my-2"}),i(F,{link:"",to:"/profile"},{prepend:f(()=>[i(x,{class:"me-2",icon:"ri-user-line",size:"22"})]),default:f(()=>[i(z,null,{default:f(()=>[V("Profile")]),_:1})]),_:1}),i(F,{link:"",to:"/profilePassword"},{prepend:f(()=>[i(x,{class:"me-2",icon:"ri-settings-4-line",size:"22"})]),default:f(()=>[i(z,null,{default:f(()=>[V("Password Settings")]),_:1})]),_:1}),i(ut,{class:"my-2"}),i(F,{onClick:s},{prepend:f(()=>[i(x,{class:"me-2",icon:"ri-logout-box-r-line",size:"22"})]),default:f(()=>[i(z,null,{default:f(()=>[V("Logout")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}))}};/*!
 * perfect-scrollbar v1.5.3
 * Copyright 2021 Hyunje Jun, MDBootstrap and Contributors
 * Licensed under MIT
 */function H(t){return getComputedStyle(t)}function Y(t,e){for(var n in e){var l=e[n];typeof l=="number"&&(l=l+"px"),t.style[n]=l}return t}function G(t){var e=document.createElement("div");return e.className=t,e}var ft=typeof Element<"u"&&(Element.prototype.matches||Element.prototype.webkitMatchesSelector||Element.prototype.mozMatchesSelector||Element.prototype.msMatchesSelector);function A(t,e){if(!ft)throw new Error("No element matching method supported");return ft.call(t,e)}function D(t){t.remove?t.remove():t.parentNode&&t.parentNode.removeChild(t)}function vt(t,e){return Array.prototype.filter.call(t.children,function(n){return A(n,e)})}var S={main:"ps",rtl:"ps__rtl",element:{thumb:function(t){return"ps__thumb-"+t},rail:function(t){return"ps__rail-"+t},consuming:"ps__child--consume"},state:{focus:"ps--focus",clicking:"ps--clicking",active:function(t){return"ps--active-"+t},scrolling:function(t){return"ps--scrolling-"+t}}},Et={x:null,y:null};function At(t,e){var n=t.element.classList,l=S.state.scrolling(e);n.contains(l)?clearTimeout(Et[e]):n.add(l)}function Pt(t,e){Et[e]=setTimeout(function(){return t.isAlive&&t.element.classList.remove(S.state.scrolling(e))},t.settings.scrollingThreshold)}function Me(t,e){At(t,e),Pt(t,e)}var K=function(e){this.element=e,this.handlers={}},Ct={isEmpty:{configurable:!0}};K.prototype.bind=function(e,n){typeof this.handlers[e]>"u"&&(this.handlers[e]=[]),this.handlers[e].push(n),this.element.addEventListener(e,n,!1)};K.prototype.unbind=function(e,n){var l=this;this.handlers[e]=this.handlers[e].filter(function(a){return n&&a!==n?!0:(l.element.removeEventListener(e,a,!1),!1)})};K.prototype.unbindAll=function(){for(var e in this.handlers)this.unbind(e)};Ct.isEmpty.get=function(){var t=this;return Object.keys(this.handlers).every(function(e){return t.handlers[e].length===0})};Object.defineProperties(K.prototype,Ct);var O=function(){this.eventElements=[]};O.prototype.eventElement=function(e){var n=this.eventElements.filter(function(l){return l.element===e})[0];return n||(n=new K(e),this.eventElements.push(n)),n};O.prototype.bind=function(e,n,l){this.eventElement(e).bind(n,l)};O.prototype.unbind=function(e,n,l){var a=this.eventElement(e);a.unbind(n,l),a.isEmpty&&this.eventElements.splice(this.eventElements.indexOf(a),1)};O.prototype.unbindAll=function(){this.eventElements.forEach(function(e){return e.unbindAll()}),this.eventElements=[]};O.prototype.once=function(e,n,l){var a=this.eventElement(e),s=function(o){a.unbind(n,s),l(o)};a.bind(n,s)};function J(t){if(typeof window.CustomEvent=="function")return new CustomEvent(t);var e=document.createEvent("CustomEvent");return e.initCustomEvent(t,!1,!1,void 0),e}function Z(t,e,n,l,a){l===void 0&&(l=!0),a===void 0&&(a=!1);var s;if(e==="top")s=["contentHeight","containerHeight","scrollTop","y","up","down"];else if(e==="left")s=["contentWidth","containerWidth","scrollLeft","x","left","right"];else throw new Error("A proper axis should be provided");Ie(t,n,s,l,a)}function Ie(t,e,n,l,a){var s=n[0],o=n[1],c=n[2],r=n[3],h=n[4],u=n[5];l===void 0&&(l=!0),a===void 0&&(a=!1);var m=t.element;t.reach[r]=null,m[c]<1&&(t.reach[r]="start"),m[c]>t[s]-t[o]-1&&(t.reach[r]="end"),e&&(m.dispatchEvent(J("ps-scroll-"+r)),e<0?m.dispatchEvent(J("ps-scroll-"+h)):e>0&&m.dispatchEvent(J("ps-scroll-"+u)),l&&Me(t,r)),t.reach[r]&&(e||a)&&m.dispatchEvent(J("ps-"+r+"-reach-"+t.reach[r]))}function w(t){return parseInt(t,10)||0}function Be(t){return A(t,"input,[contenteditable]")||A(t,"select,[contenteditable]")||A(t,"textarea,[contenteditable]")||A(t,"button,[contenteditable]")}function Ne(t){var e=H(t);return w(e.width)+w(e.paddingLeft)+w(e.paddingRight)+w(e.borderLeftWidth)+w(e.borderRightWidth)}var $={isWebKit:typeof document<"u"&&"WebkitAppearance"in document.documentElement.style,supportsTouch:typeof window<"u"&&("ontouchstart"in window||"maxTouchPoints"in window.navigator&&window.navigator.maxTouchPoints>0||window.DocumentTouch&&document instanceof window.DocumentTouch),supportsIePointer:typeof navigator<"u"&&navigator.msMaxTouchPoints,isChrome:typeof navigator<"u"&&/Chrome/i.test(navigator&&navigator.userAgent)};function E(t){var e=t.element,n=Math.floor(e.scrollTop),l=e.getBoundingClientRect();t.containerWidth=Math.round(l.width),t.containerHeight=Math.round(l.height),t.contentWidth=e.scrollWidth,t.contentHeight=e.scrollHeight,e.contains(t.scrollbarXRail)||(vt(e,S.element.rail("x")).forEach(function(a){return D(a)}),e.appendChild(t.scrollbarXRail)),e.contains(t.scrollbarYRail)||(vt(e,S.element.rail("y")).forEach(function(a){return D(a)}),e.appendChild(t.scrollbarYRail)),!t.settings.suppressScrollX&&t.containerWidth+t.settings.scrollXMarginOffset<t.contentWidth?(t.scrollbarXActive=!0,t.railXWidth=t.containerWidth-t.railXMarginWidth,t.railXRatio=t.containerWidth/t.railXWidth,t.scrollbarXWidth=pt(t,w(t.railXWidth*t.containerWidth/t.contentWidth)),t.scrollbarXLeft=w((t.negativeScrollAdjustment+e.scrollLeft)*(t.railXWidth-t.scrollbarXWidth)/(t.contentWidth-t.containerWidth))):t.scrollbarXActive=!1,!t.settings.suppressScrollY&&t.containerHeight+t.settings.scrollYMarginOffset<t.contentHeight?(t.scrollbarYActive=!0,t.railYHeight=t.containerHeight-t.railYMarginHeight,t.railYRatio=t.containerHeight/t.railYHeight,t.scrollbarYHeight=pt(t,w(t.railYHeight*t.containerHeight/t.contentHeight)),t.scrollbarYTop=w(n*(t.railYHeight-t.scrollbarYHeight)/(t.contentHeight-t.containerHeight))):t.scrollbarYActive=!1,t.scrollbarXLeft>=t.railXWidth-t.scrollbarXWidth&&(t.scrollbarXLeft=t.railXWidth-t.scrollbarXWidth),t.scrollbarYTop>=t.railYHeight-t.scrollbarYHeight&&(t.scrollbarYTop=t.railYHeight-t.scrollbarYHeight),Ve(e,t),t.scrollbarXActive?e.classList.add(S.state.active("x")):(e.classList.remove(S.state.active("x")),t.scrollbarXWidth=0,t.scrollbarXLeft=0,e.scrollLeft=t.isRtl===!0?t.contentWidth:0),t.scrollbarYActive?e.classList.add(S.state.active("y")):(e.classList.remove(S.state.active("y")),t.scrollbarYHeight=0,t.scrollbarYTop=0,e.scrollTop=0)}function pt(t,e){return t.settings.minScrollbarLength&&(e=Math.max(e,t.settings.minScrollbarLength)),t.settings.maxScrollbarLength&&(e=Math.min(e,t.settings.maxScrollbarLength)),e}function Ve(t,e){var n={width:e.railXWidth},l=Math.floor(t.scrollTop);e.isRtl?n.left=e.negativeScrollAdjustment+t.scrollLeft+e.containerWidth-e.contentWidth:n.left=t.scrollLeft,e.isScrollbarXUsingBottom?n.bottom=e.scrollbarXBottom-l:n.top=e.scrollbarXTop+l,Y(e.scrollbarXRail,n);var a={top:l,height:e.railYHeight};e.isScrollbarYUsingRight?e.isRtl?a.right=e.contentWidth-(e.negativeScrollAdjustment+t.scrollLeft)-e.scrollbarYRight-e.scrollbarYOuterWidth-9:a.right=e.scrollbarYRight-t.scrollLeft:e.isRtl?a.left=e.negativeScrollAdjustment+t.scrollLeft+e.containerWidth*2-e.contentWidth-e.scrollbarYLeft-e.scrollbarYOuterWidth:a.left=e.scrollbarYLeft+t.scrollLeft,Y(e.scrollbarYRail,a),Y(e.scrollbarX,{left:e.scrollbarXLeft,width:e.scrollbarXWidth-e.railBorderXWidth}),Y(e.scrollbarY,{top:e.scrollbarYTop,height:e.scrollbarYHeight-e.railBorderYWidth})}function $e(t){t.element,t.event.bind(t.scrollbarY,"mousedown",function(e){return e.stopPropagation()}),t.event.bind(t.scrollbarYRail,"mousedown",function(e){var n=e.pageY-window.pageYOffset-t.scrollbarYRail.getBoundingClientRect().top,l=n>t.scrollbarYTop?1:-1;t.element.scrollTop+=l*t.containerHeight,E(t),e.stopPropagation()}),t.event.bind(t.scrollbarX,"mousedown",function(e){return e.stopPropagation()}),t.event.bind(t.scrollbarXRail,"mousedown",function(e){var n=e.pageX-window.pageXOffset-t.scrollbarXRail.getBoundingClientRect().left,l=n>t.scrollbarXLeft?1:-1;t.element.scrollLeft+=l*t.containerWidth,E(t),e.stopPropagation()})}function De(t){mt(t,["containerWidth","contentWidth","pageX","railXWidth","scrollbarX","scrollbarXWidth","scrollLeft","x","scrollbarXRail"]),mt(t,["containerHeight","contentHeight","pageY","railYHeight","scrollbarY","scrollbarYHeight","scrollTop","y","scrollbarYRail"])}function mt(t,e){var n=e[0],l=e[1],a=e[2],s=e[3],o=e[4],c=e[5],r=e[6],h=e[7],u=e[8],m=t.element,p=null,y=null,d=null;function v(g){g.touches&&g.touches[0]&&(g[a]=g.touches[0].pageY),m[r]=p+d*(g[a]-y),At(t,h),E(t),g.stopPropagation(),g.type.startsWith("touch")&&g.changedTouches.length>1&&g.preventDefault()}function L(){Pt(t,h),t[u].classList.remove(S.state.clicking),t.event.unbind(t.ownerDocument,"mousemove",v)}function b(g,W){p=m[r],W&&g.touches&&(g[a]=g.touches[0].pageY),y=g[a],d=(t[l]-t[n])/(t[s]-t[c]),W?t.event.bind(t.ownerDocument,"touchmove",v):(t.event.bind(t.ownerDocument,"mousemove",v),t.event.once(t.ownerDocument,"mouseup",L),g.preventDefault()),t[u].classList.add(S.state.clicking),g.stopPropagation()}t.event.bind(t[o],"mousedown",function(g){b(g)}),t.event.bind(t[o],"touchstart",function(g){b(g,!0)})}function Oe(t){var e=t.element,n=function(){return A(e,":hover")},l=function(){return A(t.scrollbarX,":focus")||A(t.scrollbarY,":focus")};function a(s,o){var c=Math.floor(e.scrollTop);if(s===0){if(!t.scrollbarYActive)return!1;if(c===0&&o>0||c>=t.contentHeight-t.containerHeight&&o<0)return!t.settings.wheelPropagation}var r=e.scrollLeft;if(o===0){if(!t.scrollbarXActive)return!1;if(r===0&&s<0||r>=t.contentWidth-t.containerWidth&&s>0)return!t.settings.wheelPropagation}return!0}t.event.bind(t.ownerDocument,"keydown",function(s){if(!(s.isDefaultPrevented&&s.isDefaultPrevented()||s.defaultPrevented)&&!(!n()&&!l())){var o=document.activeElement?document.activeElement:t.ownerDocument.activeElement;if(o){if(o.tagName==="IFRAME")o=o.contentDocument.activeElement;else for(;o.shadowRoot;)o=o.shadowRoot.activeElement;if(Be(o))return}var c=0,r=0;switch(s.which){case 37:s.metaKey?c=-t.contentWidth:s.altKey?c=-t.containerWidth:c=-30;break;case 38:s.metaKey?r=t.contentHeight:s.altKey?r=t.containerHeight:r=30;break;case 39:s.metaKey?c=t.contentWidth:s.altKey?c=t.containerWidth:c=30;break;case 40:s.metaKey?r=-t.contentHeight:s.altKey?r=-t.containerHeight:r=-30;break;case 32:s.shiftKey?r=t.containerHeight:r=-t.containerHeight;break;case 33:r=t.containerHeight;break;case 34:r=-t.containerHeight;break;case 36:r=t.contentHeight;break;case 35:r=-t.contentHeight;break;default:return}t.settings.suppressScrollX&&c!==0||t.settings.suppressScrollY&&r!==0||(e.scrollTop-=r,e.scrollLeft+=c,E(t),a(c,r)&&s.preventDefault())}})}function je(t){var e=t.element;function n(o,c){var r=Math.floor(e.scrollTop),h=e.scrollTop===0,u=r+e.offsetHeight===e.scrollHeight,m=e.scrollLeft===0,p=e.scrollLeft+e.offsetWidth===e.scrollWidth,y;return Math.abs(c)>Math.abs(o)?y=h||u:y=m||p,y?!t.settings.wheelPropagation:!0}function l(o){var c=o.deltaX,r=-1*o.deltaY;return(typeof c>"u"||typeof r>"u")&&(c=-1*o.wheelDeltaX/6,r=o.wheelDeltaY/6),o.deltaMode&&o.deltaMode===1&&(c*=10,r*=10),c!==c&&r!==r&&(c=0,r=o.wheelDelta),o.shiftKey?[-r,-c]:[c,r]}function a(o,c,r){if(!$.isWebKit&&e.querySelector("select:focus"))return!0;if(!e.contains(o))return!1;for(var h=o;h&&h!==e;){if(h.classList.contains(S.element.consuming))return!0;var u=H(h);if(r&&u.overflowY.match(/(scroll|auto)/)){var m=h.scrollHeight-h.clientHeight;if(m>0&&(h.scrollTop>0&&r<0||h.scrollTop<m&&r>0))return!0}if(c&&u.overflowX.match(/(scroll|auto)/)){var p=h.scrollWidth-h.clientWidth;if(p>0&&(h.scrollLeft>0&&c<0||h.scrollLeft<p&&c>0))return!0}h=h.parentNode}return!1}function s(o){var c=l(o),r=c[0],h=c[1];if(!a(o.target,r,h)){var u=!1;t.settings.useBothWheelAxes?t.scrollbarYActive&&!t.scrollbarXActive?(h?e.scrollTop-=h*t.settings.wheelSpeed:e.scrollTop+=r*t.settings.wheelSpeed,u=!0):t.scrollbarXActive&&!t.scrollbarYActive&&(r?e.scrollLeft+=r*t.settings.wheelSpeed:e.scrollLeft-=h*t.settings.wheelSpeed,u=!0):(e.scrollTop-=h*t.settings.wheelSpeed,e.scrollLeft+=r*t.settings.wheelSpeed),E(t),u=u||n(r,h),u&&!o.ctrlKey&&(o.stopPropagation(),o.preventDefault())}}typeof window.onwheel<"u"?t.event.bind(e,"wheel",s):typeof window.onmousewheel<"u"&&t.event.bind(e,"mousewheel",s)}function Ue(t){if(!$.supportsTouch&&!$.supportsIePointer)return;var e=t.element;function n(d,v){var L=Math.floor(e.scrollTop),b=e.scrollLeft,g=Math.abs(d),W=Math.abs(v);if(W>g){if(v<0&&L===t.contentHeight-t.containerHeight||v>0&&L===0)return window.scrollY===0&&v>0&&$.isChrome}else if(g>W&&(d<0&&b===t.contentWidth-t.containerWidth||d>0&&b===0))return!0;return!0}function l(d,v){e.scrollTop-=v,e.scrollLeft-=d,E(t)}var a={},s=0,o={},c=null;function r(d){return d.targetTouches?d.targetTouches[0]:d}function h(d){return d.pointerType&&d.pointerType==="pen"&&d.buttons===0?!1:!!(d.targetTouches&&d.targetTouches.length===1||d.pointerType&&d.pointerType!=="mouse"&&d.pointerType!==d.MSPOINTER_TYPE_MOUSE)}function u(d){if(h(d)){var v=r(d);a.pageX=v.pageX,a.pageY=v.pageY,s=new Date().getTime(),c!==null&&clearInterval(c)}}function m(d,v,L){if(!e.contains(d))return!1;for(var b=d;b&&b!==e;){if(b.classList.contains(S.element.consuming))return!0;var g=H(b);if(L&&g.overflowY.match(/(scroll|auto)/)){var W=b.scrollHeight-b.clientHeight;if(W>0&&(b.scrollTop>0&&L<0||b.scrollTop<W&&L>0))return!0}if(v&&g.overflowX.match(/(scroll|auto)/)){var B=b.scrollWidth-b.clientWidth;if(B>0&&(b.scrollLeft>0&&v<0||b.scrollLeft<B&&v>0))return!0}b=b.parentNode}return!1}function p(d){if(h(d)){var v=r(d),L={pageX:v.pageX,pageY:v.pageY},b=L.pageX-a.pageX,g=L.pageY-a.pageY;if(m(d.target,b,g))return;l(b,g),a=L;var W=new Date().getTime(),B=W-s;B>0&&(o.x=b/B,o.y=g/B,s=W),n(b,g)&&d.preventDefault()}}function y(){t.settings.swipeEasing&&(clearInterval(c),c=setInterval(function(){if(t.isInitialized){clearInterval(c);return}if(!o.x&&!o.y){clearInterval(c);return}if(Math.abs(o.x)<.01&&Math.abs(o.y)<.01){clearInterval(c);return}if(!t.element){clearInterval(c);return}l(o.x*30,o.y*30),o.x*=.8,o.y*=.8},10))}$.supportsTouch?(t.event.bind(e,"touchstart",u),t.event.bind(e,"touchmove",p),t.event.bind(e,"touchend",y)):$.supportsIePointer&&(window.PointerEvent?(t.event.bind(e,"pointerdown",u),t.event.bind(e,"pointermove",p),t.event.bind(e,"pointerup",y)):window.MSPointerEvent&&(t.event.bind(e,"MSPointerDown",u),t.event.bind(e,"MSPointerMove",p),t.event.bind(e,"MSPointerUp",y)))}var Ke=function(){return{handlers:["click-rail","drag-thumb","keyboard","wheel","touch"],maxScrollbarLength:null,minScrollbarLength:null,scrollingThreshold:1e3,scrollXMarginOffset:0,scrollYMarginOffset:0,suppressScrollX:!1,suppressScrollY:!1,swipeEasing:!0,useBothWheelAxes:!1,wheelPropagation:!0,wheelSpeed:1}},qe={"click-rail":$e,"drag-thumb":De,keyboard:Oe,wheel:je,touch:Ue},q=function(e,n){var l=this;if(n===void 0&&(n={}),typeof e=="string"&&(e=document.querySelector(e)),!e||!e.nodeName)throw new Error("no element is specified to initialize PerfectScrollbar");this.element=e,e.classList.add(S.main),this.settings=Ke();for(var a in n)this.settings[a]=n[a];this.containerWidth=null,this.containerHeight=null,this.contentWidth=null,this.contentHeight=null;var s=function(){return e.classList.add(S.state.focus)},o=function(){return e.classList.remove(S.state.focus)};this.isRtl=H(e).direction==="rtl",this.isRtl===!0&&e.classList.add(S.rtl),this.isNegativeScroll=function(){var h=e.scrollLeft,u=null;return e.scrollLeft=-1,u=e.scrollLeft<0,e.scrollLeft=h,u}(),this.negativeScrollAdjustment=this.isNegativeScroll?e.scrollWidth-e.clientWidth:0,this.event=new O,this.ownerDocument=e.ownerDocument||document,this.scrollbarXRail=G(S.element.rail("x")),e.appendChild(this.scrollbarXRail),this.scrollbarX=G(S.element.thumb("x")),this.scrollbarXRail.appendChild(this.scrollbarX),this.scrollbarX.setAttribute("tabindex",0),this.event.bind(this.scrollbarX,"focus",s),this.event.bind(this.scrollbarX,"blur",o),this.scrollbarXActive=null,this.scrollbarXWidth=null,this.scrollbarXLeft=null;var c=H(this.scrollbarXRail);this.scrollbarXBottom=parseInt(c.bottom,10),isNaN(this.scrollbarXBottom)?(this.isScrollbarXUsingBottom=!1,this.scrollbarXTop=w(c.top)):this.isScrollbarXUsingBottom=!0,this.railBorderXWidth=w(c.borderLeftWidth)+w(c.borderRightWidth),Y(this.scrollbarXRail,{display:"block"}),this.railXMarginWidth=w(c.marginLeft)+w(c.marginRight),Y(this.scrollbarXRail,{display:""}),this.railXWidth=null,this.railXRatio=null,this.scrollbarYRail=G(S.element.rail("y")),e.appendChild(this.scrollbarYRail),this.scrollbarY=G(S.element.thumb("y")),this.scrollbarYRail.appendChild(this.scrollbarY),this.scrollbarY.setAttribute("tabindex",0),this.event.bind(this.scrollbarY,"focus",s),this.event.bind(this.scrollbarY,"blur",o),this.scrollbarYActive=null,this.scrollbarYHeight=null,this.scrollbarYTop=null;var r=H(this.scrollbarYRail);this.scrollbarYRight=parseInt(r.right,10),isNaN(this.scrollbarYRight)?(this.isScrollbarYUsingRight=!1,this.scrollbarYLeft=w(r.left)):this.isScrollbarYUsingRight=!0,this.scrollbarYOuterWidth=this.isRtl?Ne(this.scrollbarY):null,this.railBorderYWidth=w(r.borderTopWidth)+w(r.borderBottomWidth),Y(this.scrollbarYRail,{display:"block"}),this.railYMarginHeight=w(r.marginTop)+w(r.marginBottom),Y(this.scrollbarYRail,{display:""}),this.railYHeight=null,this.railYRatio=null,this.reach={x:e.scrollLeft<=0?"start":e.scrollLeft>=this.contentWidth-this.containerWidth?"end":null,y:e.scrollTop<=0?"start":e.scrollTop>=this.contentHeight-this.containerHeight?"end":null},this.isAlive=!0,this.settings.handlers.forEach(function(h){return qe[h](l)}),this.lastScrollTop=Math.floor(e.scrollTop),this.lastScrollLeft=e.scrollLeft,this.event.bind(this.element,"scroll",function(h){return l.onScroll(h)}),E(this)};q.prototype.update=function(){this.isAlive&&(this.negativeScrollAdjustment=this.isNegativeScroll?this.element.scrollWidth-this.element.clientWidth:0,Y(this.scrollbarXRail,{display:"block"}),Y(this.scrollbarYRail,{display:"block"}),this.railXMarginWidth=w(H(this.scrollbarXRail).marginLeft)+w(H(this.scrollbarXRail).marginRight),this.railYMarginHeight=w(H(this.scrollbarYRail).marginTop)+w(H(this.scrollbarYRail).marginBottom),Y(this.scrollbarXRail,{display:"none"}),Y(this.scrollbarYRail,{display:"none"}),E(this),Z(this,"top",0,!1,!0),Z(this,"left",0,!1,!0),Y(this.scrollbarXRail,{display:""}),Y(this.scrollbarYRail,{display:""}))};q.prototype.onScroll=function(e){this.isAlive&&(E(this),Z(this,"top",this.element.scrollTop-this.lastScrollTop),Z(this,"left",this.element.scrollLeft-this.lastScrollLeft),this.lastScrollTop=Math.floor(this.element.scrollTop),this.lastScrollLeft=this.element.scrollLeft)};q.prototype.destroy=function(){this.isAlive&&(this.event.unbindAll(),D(this.scrollbarX),D(this.scrollbarY),D(this.scrollbarXRail),D(this.scrollbarYRail),this.removePsClasses(),this.element=null,this.scrollbarX=null,this.scrollbarY=null,this.scrollbarXRail=null,this.scrollbarYRail=null,this.isAlive=!1)};q.prototype.removePsClasses=function(){this.element.className=this.element.className.split(" ").filter(function(e){return!e.match(/^ps([-_].+|)$/)}).join(" ")};const gt=["scroll","ps-scroll-y","ps-scroll-x","ps-scroll-up","ps-scroll-down","ps-scroll-left","ps-scroll-right","ps-y-reach-start","ps-y-reach-end","ps-x-reach-start","ps-x-reach-end"];var Fe={name:"PerfectScrollbar",props:{options:{type:Object,required:!1,default:()=>{}},tag:{type:String,required:!1,default:"div"},watchOptions:{type:Boolean,required:!1,default:!1}},emits:gt,data(){return{ps:null}},watch:{watchOptions(t){!t&&this.watcher?this.watcher():this.createWatcher()}},mounted(){this.create(),this.watchOptions&&this.createWatcher()},updated(){this.$nextTick(()=>{this.update()})},beforeUnmount(){this.destroy()},methods:{create(){this.ps&&this.$isServer||(this.ps=new q(this.$el,this.options),gt.forEach(t=>{this.ps.element.addEventListener(t,e=>this.$emit(t,e))}))},createWatcher(){this.watcher=this.$watch("options",()=>{this.destroy(),this.create()},{deep:!0})},update(){this.ps&&this.ps.update()},destroy(){this.ps&&(this.ps.destroy(),this.ps=null)}},render(){return X(this.tag,{class:"ps"},this.$slots.default&&this.$slots.default())}};const Mt=t=>(Xt("data-v-98bc1ac5"),t=t(),xt(),t),ze={class:"nav-header"},Ge=["innerHTML"],Je=Mt(()=>T("h1",{class:"font-weight-medium leading-normal text-xl text-uppercase"}," PExam System ",-1)),Qe=Mt(()=>T("div",{class:"vertical-nav-items-shadow"},null,-1)),Ze={__name:"VerticalNav",props:{tag:{type:null,required:!1,default:"aside"},isOverlayNavActive:{type:Boolean,required:!0},toggleIsOverlayNavActive:{type:Function,required:!0}},setup(t){const e=t,{mdAndDown:n}=Rt(),l=C(),a=Wt();et(()=>a.path,()=>{e.toggleIsOverlayNavActive(!1)});const s=C(!1),o=r=>s.value=r,c=r=>{s.value=r.target.scrollTop>0};return(r,h)=>{const u=j("RouterLink");return k(),I(wt(e.tag),{ref_key:"refNav",ref:l,class:U(["layout-vertical-nav",[{visible:t.isOverlayNavActive,scrolled:R(s),"overlay-nav":R(n)}]])},{default:f(()=>[T("div",ze,[M(r.$slots,"nav-header",{},()=>[i(u,{to:"/",class:"app-logo app-title-wrapper"},{default:f(()=>[T("div",{class:"d-flex",innerHTML:R(kt)},null,8,Ge),Je]),_:1})],!0)]),M(r.$slots,"before-nav-items",{},()=>[Qe],!0),M(r.$slots,"nav-items",{updateIsVerticalNavScrolled:o},()=>[i(R(Fe),{tag:"ul",class:"nav-items",options:{wheelPropagation:!1},onPsScrollY:c},{default:f(()=>[M(r.$slots,"default",{},void 0,!0)]),_:3})],!0),M(r.$slots,"after-nav-items",{},void 0,!0)]),_:3},8,["class"])}}},tn=rt(Ze,[["__scopeId","data-v-98bc1ac5"]]),en=ne({setup(t,{slots:e}){const n=C(!1),l=C(!1),a=Se(n),s=Wt(),{mdAndDown:o}=Rt();return _e(n,l),()=>{var p,y,d;const c=X(tn,{isOverlayNavActive:n.value,toggleIsOverlayNavActive:a},{"nav-header":()=>{var v;return(v=e["vertical-nav-header"])==null?void 0:v.call(e,{toggleIsOverlayNavActive:a})},"before-nav-items":()=>{var v;return(v=e["before-vertical-nav-items"])==null?void 0:v.call(e)},default:()=>{var v;return(v=e["vertical-nav-content"])==null?void 0:v.call(e)},"after-nav-items":()=>{var v;return(v=e["after-vertical-nav-items"])==null?void 0:v.call(e)}}),r=X("header",{class:["layout-navbar navbar-blur"]},[X("div",{class:"navbar-content-container"},(p=e.navbar)==null?void 0:p.call(e,{toggleVerticalOverlayNavActive:a}))]),h=X("main",{class:"layout-page-content"},X("div",{class:"page-content-container"},(y=e.default)==null?void 0:y.call(e))),u=X("footer",{class:"layout-footer"},[X("div",{class:"footer-content-container"},(d=e.footer)==null?void 0:d.call(e))]),m=X("div",{class:["layout-overlay",{visible:l.value}],onClick:()=>{l.value=!l.value}});return X("div",{class:["layout-wrapper layout-nav-type-vertical layout-navbar-static layout-footer-static layout-content-width-fluid",o.value&&"layout-overlay-nav",s.meta.layoutWrapperClasses]},[c,X("div",{class:"layout-content-wrapper"},[r,h,u]),m])}}}),It=t=>(Xt("data-v-55c5739a"),t=t(),xt(),t),nn={class:"d-flex h-100 align-center"},rn=It(()=>T("div",{class:"d-flex align-center cursor-pointer",style:{"user-select":"none"}},null,-1)),ln=["innerHTML"],on=It(()=>T("h1",{class:"font-weight-medium leading-normal text-xl text-uppercase"}," PExam System ",-1)),an={__name:"DefaultLayoutWithVerticalNav",setup(t){return(e,n)=>{const l=j("IconBtn"),a=j("RouterLink");return k(),I(en,null,{navbar:f(({toggleVerticalOverlayNavActive:s})=>[T("div",nn,[i(l,{class:"ms-n3 d-lg-none",onClick:o=>s(!0)},{default:f(()=>[i(x,{icon:"ri-menu-line"})]),_:2},1032,["onClick"]),rn,i(ce),i(l,{class:"me-2",to:"/notifications"},{default:f(()=>[i(x,{icon:"ri-notification-line"})]),_:1}),i(Re,{class:"me-2"}),i(Ce)])]),"vertical-nav-header":f(({toggleIsOverlayNavActive:s})=>[i(a,{to:"/",class:"app-logo app-title-wrapper"},{default:f(()=>[T("div",{class:"d-flex",innerHTML:R(kt)},null,8,ln),on]),_:1}),i(l,{class:"d-block d-lg-none",onClick:o=>s(!1)},{default:f(()=>[i(x,{icon:"ri-close-line"})]),_:2},1032,["onClick"])]),"vertical-nav-content":f(()=>[i(He)]),footer:f(()=>[i(pe)]),default:f(()=>[M(e.$slots,"default",{},void 0,!0)]),_:3})}}},sn=rt(an,[["__scopeId","data-v-55c5739a"]]),Wn={__name:"default",setup(t){return(e,n)=>{const l=j("RouterView");return k(),I(sn,null,{default:f(()=>[i(l)]),_:1})}}};export{Wn as default};
