import{r as C,o as k,c as tt,a as _,b as a,V as W,t as P,n as U,u as R,d as M,e as I,w as d,f as bt,F as Nt,h as x,_ as rt,i as yt,j as wt,k as et,l as j,p as _t,m as St,q as $t,s as Tt,v as nt,x as Bt,y as Vt,z as Dt,A as Ot,B,C as Lt,D as Yt,I as Ut,E as Wt,G as jt,H as Kt,J as Rt,K as qt,L as Xt,M as Ft,N as zt,O as Gt,P as Jt,Q as Qt,R as xt,S as Zt,T as te,U as ee,W as lt,X as ne,Y as ot}from"./index-zYAuA0qV.js";import{l as kt}from"./logo-lSNaS3Cd.js";import{V as re}from"./VTooltip-dQI1pVal.js";import{a as st}from"./avatar-1-nH9r29IQ.js";import{a as at}from"./axios-G2rPRu76.js";import{V as it}from"./VAvatar-BX0ZOUQe.js";import{m as le,M as oe,V as ct}from"./VImg-XJYe2yvh.js";import{V as se,a as ae,b as F,c as z,d as ie}from"./VMenu-AAQK7vOC.js";import{V as ut}from"./VDivider-AOx8292S.js";import{V as ce}from"./VSpacer-d2N9ElYO.js";import"./VOverlay-fwCDSazt.js";import"./easing-Apq16fr0.js";import"./lazy-p-tG6HZU.js";import"./forwardRefs-y8pOSn8h.js";import"./index-Dx9PTrLH.js";import"./ssrBoot-sA4uMkfL.js";import"./dialog-transition-BhwFHhVk.js";/* empty css              */const ue={class:"nav-item-title"},he={class:"nav-group-children-wrapper"},de={class:"nav-group-children"},$={__name:"VerticalNavGroup",props:{item:{type:Object,required:!0}},setup(t){const e=C(!1);return(n,l)=>(k(),tt("li",{class:U(["nav-group",R(e)&&"open"])},[_("div",{class:"nav-group-label",onClick:l[0]||(l[0]=s=>e.value=!R(e))},[a(W,{icon:t.item.icon||"ri-checkbox-blank-circle-line",class:"nav-item-icon"},null,8,["icon"]),_("span",ue,P(t.item.title),1),_("span",{class:U(["nav-item-badge",t.item.badgeClass])},P(t.item.badgeContent),3),a(W,{icon:"ri-arrow-right-s-line",class:"nav-group-arrow"})]),_("div",he,[_("ul",de,[M(n.$slots,"default")])])],2))}},fe={class:"nav-item-title"},S={__name:"VerticalNavLink",props:{item:{type:null,required:!0}},setup(t){return(e,n)=>(k(),tt("li",{class:U(["nav-link",{disabled:t.item.disable}])},[(k(),I(bt(t.item.to?"RouterLink":"a"),{to:t.item.to,href:t.item.href,target:t.item.target},{default:d(()=>[a(W,{icon:t.item.icon||"ri-checkbox-blank-circle-line",class:"nav-item-icon"},null,8,["icon"]),_("span",fe,P(t.item.title),1),_("span",{class:U(["nav-item-badge",t.item.badgeClass])},P(t.item.badgeContent),3)]),_:1},8,["to","href","target"]))],2))}},pe={__name:"NavItems",setup(t){return(e,n)=>(k(),tt(Nt,null,[a($,{item:{title:"Admin",icon:"ri-settings-4-line"}},{default:d(()=>[a(S,{item:{title:"All Users",to:"/users",icon:"ri-user-line"}}),a(S,{item:{title:"System Logs",to:"/systemLogs",icon:"ri-file-list-2-line"}}),a(S,{item:{title:"Import Students",to:"/importStudents",icon:"ri-file-list-2-line"}})]),_:1}),a($,{item:{title:"Students",icon:"ri-user-3-line"}},{default:d(()=>[a(S,{item:{title:"Admissions",to:"/admissions",icon:"ri-add-circle-line"}}),a(S,{item:{title:"View Students",to:"/students",icon:"ri-eye-line"}}),a(S,{item:{title:"search Student",to:"/searchStudent",icon:"ri-search-line"}}),a(S,{item:{title:"Students Subjects",to:"/studentsubjects",icon:"ri-article-line"}})]),_:1}),a($,{item:{title:"Examinations",icon:"ri-pencil-line"}},{default:d(()=>[a(S,{item:{title:"Create Examination",to:"/createExam",icon:"ri-pencil-line"}}),a(S,{item:{title:"view Examinations",to:"/viewTerms",icon:"ri-book-line"}}),a(S,{item:{title:"Subjects Grading",to:"/subjectsGrading",icon:"ri-book-2-line"}})]),_:1}),a($,{item:{title:"SMS Service",icon:"ri-message-2-line"}},{default:d(()=>[a(S,{item:{title:"Sms Stats",to:"/smsStats",icon:"ri-book-2-line"}}),a(S,{item:{title:"Send SMS",to:"/composeSMS",icon:"ri-send-plane-2-line"}}),a(S,{item:{title:"SMS Logs",to:"/smsLogs",icon:"ri-file-list-2-line"}}),a(S,{item:{title:"SMS Balance",to:"/smsBalance",icon:"ri-money-dollar-box-line"}})]),_:1}),a($,{item:{title:"TimeTables",icon:"ri-time-line"}},{default:d(()=>[a(S,{item:{title:"Exams TimeTables",to:"/Users",icon:"ri-pencil-line"}}),a(S,{item:{title:"Class Timetables",to:"/Users",icon:"ri-book-line"}}),a(S,{item:{title:"Subject Teachers",to:"/subjectTeachers",icon:"ri-ruler-line"}})]),_:1}),a($,{item:{title:"User Profile",icon:"ri-user-line"}},{default:d(()=>[a(S,{item:{title:"Edit Profile",to:"/profile",icon:"ri-pencil-line"}}),a(S,{item:{title:"Change Password",to:"/profilePassword",icon:"ri-lock-password-line"}}),a(S,{item:{title:"Notifications",to:"/notifications",icon:"ri-notification-line"}})]),_:1})],64))}};/*!
 * perfect-scrollbar v1.5.3
 * Copyright 2021 Hyunje Jun, MDBootstrap and Contributors
 * Licensed under MIT
 */function H(t){return getComputedStyle(t)}function Y(t,e){for(var n in e){var l=e[n];typeof l=="number"&&(l=l+"px"),t.style[n]=l}return t}function G(t){var e=document.createElement("div");return e.className=t,e}var ht=typeof Element<"u"&&(Element.prototype.matches||Element.prototype.webkitMatchesSelector||Element.prototype.mozMatchesSelector||Element.prototype.msMatchesSelector);function A(t,e){if(!ht)throw new Error("No element matching method supported");return ht.call(t,e)}function D(t){t.remove?t.remove():t.parentNode&&t.parentNode.removeChild(t)}function dt(t,e){return Array.prototype.filter.call(t.children,function(n){return A(n,e)})}var T={main:"ps",rtl:"ps__rtl",element:{thumb:function(t){return"ps__thumb-"+t},rail:function(t){return"ps__rail-"+t},consuming:"ps__child--consume"},state:{focus:"ps--focus",clicking:"ps--clicking",active:function(t){return"ps--active-"+t},scrolling:function(t){return"ps--scrolling-"+t}}},Ht={x:null,y:null};function Et(t,e){var n=t.element.classList,l=T.state.scrolling(e);n.contains(l)?clearTimeout(Ht[e]):n.add(l)}function At(t,e){Ht[e]=setTimeout(function(){return t.isAlive&&t.element.classList.remove(T.state.scrolling(e))},t.settings.scrollingThreshold)}function ve(t,e){Et(t,e),At(t,e)}var K=function(e){this.element=e,this.handlers={}},Ct={isEmpty:{configurable:!0}};K.prototype.bind=function(e,n){typeof this.handlers[e]>"u"&&(this.handlers[e]=[]),this.handlers[e].push(n),this.element.addEventListener(e,n,!1)};K.prototype.unbind=function(e,n){var l=this;this.handlers[e]=this.handlers[e].filter(function(s){return n&&s!==n?!0:(l.element.removeEventListener(e,s,!1),!1)})};K.prototype.unbindAll=function(){for(var e in this.handlers)this.unbind(e)};Ct.isEmpty.get=function(){var t=this;return Object.keys(this.handlers).every(function(e){return t.handlers[e].length===0})};Object.defineProperties(K.prototype,Ct);var O=function(){this.eventElements=[]};O.prototype.eventElement=function(e){var n=this.eventElements.filter(function(l){return l.element===e})[0];return n||(n=new K(e),this.eventElements.push(n)),n};O.prototype.bind=function(e,n,l){this.eventElement(e).bind(n,l)};O.prototype.unbind=function(e,n,l){var s=this.eventElement(e);s.unbind(n,l),s.isEmpty&&this.eventElements.splice(this.eventElements.indexOf(s),1)};O.prototype.unbindAll=function(){this.eventElements.forEach(function(e){return e.unbindAll()}),this.eventElements=[]};O.prototype.once=function(e,n,l){var s=this.eventElement(e),i=function(o){s.unbind(n,i),l(o)};s.bind(n,i)};function J(t){if(typeof window.CustomEvent=="function")return new CustomEvent(t);var e=document.createEvent("CustomEvent");return e.initCustomEvent(t,!1,!1,void 0),e}function Q(t,e,n,l,s){l===void 0&&(l=!0),s===void 0&&(s=!1);var i;if(e==="top")i=["contentHeight","containerHeight","scrollTop","y","up","down"];else if(e==="left")i=["contentWidth","containerWidth","scrollLeft","x","left","right"];else throw new Error("A proper axis should be provided");me(t,n,i,l,s)}function me(t,e,n,l,s){var i=n[0],o=n[1],c=n[2],r=n[3],h=n[4],u=n[5];l===void 0&&(l=!0),s===void 0&&(s=!1);var m=t.element;t.reach[r]=null,m[c]<1&&(t.reach[r]="start"),m[c]>t[i]-t[o]-1&&(t.reach[r]="end"),e&&(m.dispatchEvent(J("ps-scroll-"+r)),e<0?m.dispatchEvent(J("ps-scroll-"+h)):e>0&&m.dispatchEvent(J("ps-scroll-"+u)),l&&ve(t,r)),t.reach[r]&&(e||s)&&m.dispatchEvent(J("ps-"+r+"-reach-"+t.reach[r]))}function w(t){return parseInt(t,10)||0}function ge(t){return A(t,"input,[contenteditable]")||A(t,"select,[contenteditable]")||A(t,"textarea,[contenteditable]")||A(t,"button,[contenteditable]")}function be(t){var e=H(t);return w(e.width)+w(e.paddingLeft)+w(e.paddingRight)+w(e.borderLeftWidth)+w(e.borderRightWidth)}var V={isWebKit:typeof document<"u"&&"WebkitAppearance"in document.documentElement.style,supportsTouch:typeof window<"u"&&("ontouchstart"in window||"maxTouchPoints"in window.navigator&&window.navigator.maxTouchPoints>0||window.DocumentTouch&&document instanceof window.DocumentTouch),supportsIePointer:typeof navigator<"u"&&navigator.msMaxTouchPoints,isChrome:typeof navigator<"u"&&/Chrome/i.test(navigator&&navigator.userAgent)};function E(t){var e=t.element,n=Math.floor(e.scrollTop),l=e.getBoundingClientRect();t.containerWidth=Math.round(l.width),t.containerHeight=Math.round(l.height),t.contentWidth=e.scrollWidth,t.contentHeight=e.scrollHeight,e.contains(t.scrollbarXRail)||(dt(e,T.element.rail("x")).forEach(function(s){return D(s)}),e.appendChild(t.scrollbarXRail)),e.contains(t.scrollbarYRail)||(dt(e,T.element.rail("y")).forEach(function(s){return D(s)}),e.appendChild(t.scrollbarYRail)),!t.settings.suppressScrollX&&t.containerWidth+t.settings.scrollXMarginOffset<t.contentWidth?(t.scrollbarXActive=!0,t.railXWidth=t.containerWidth-t.railXMarginWidth,t.railXRatio=t.containerWidth/t.railXWidth,t.scrollbarXWidth=ft(t,w(t.railXWidth*t.containerWidth/t.contentWidth)),t.scrollbarXLeft=w((t.negativeScrollAdjustment+e.scrollLeft)*(t.railXWidth-t.scrollbarXWidth)/(t.contentWidth-t.containerWidth))):t.scrollbarXActive=!1,!t.settings.suppressScrollY&&t.containerHeight+t.settings.scrollYMarginOffset<t.contentHeight?(t.scrollbarYActive=!0,t.railYHeight=t.containerHeight-t.railYMarginHeight,t.railYRatio=t.containerHeight/t.railYHeight,t.scrollbarYHeight=ft(t,w(t.railYHeight*t.containerHeight/t.contentHeight)),t.scrollbarYTop=w(n*(t.railYHeight-t.scrollbarYHeight)/(t.contentHeight-t.containerHeight))):t.scrollbarYActive=!1,t.scrollbarXLeft>=t.railXWidth-t.scrollbarXWidth&&(t.scrollbarXLeft=t.railXWidth-t.scrollbarXWidth),t.scrollbarYTop>=t.railYHeight-t.scrollbarYHeight&&(t.scrollbarYTop=t.railYHeight-t.scrollbarYHeight),ye(e,t),t.scrollbarXActive?e.classList.add(T.state.active("x")):(e.classList.remove(T.state.active("x")),t.scrollbarXWidth=0,t.scrollbarXLeft=0,e.scrollLeft=t.isRtl===!0?t.contentWidth:0),t.scrollbarYActive?e.classList.add(T.state.active("y")):(e.classList.remove(T.state.active("y")),t.scrollbarYHeight=0,t.scrollbarYTop=0,e.scrollTop=0)}function ft(t,e){return t.settings.minScrollbarLength&&(e=Math.max(e,t.settings.minScrollbarLength)),t.settings.maxScrollbarLength&&(e=Math.min(e,t.settings.maxScrollbarLength)),e}function ye(t,e){var n={width:e.railXWidth},l=Math.floor(t.scrollTop);e.isRtl?n.left=e.negativeScrollAdjustment+t.scrollLeft+e.containerWidth-e.contentWidth:n.left=t.scrollLeft,e.isScrollbarXUsingBottom?n.bottom=e.scrollbarXBottom-l:n.top=e.scrollbarXTop+l,Y(e.scrollbarXRail,n);var s={top:l,height:e.railYHeight};e.isScrollbarYUsingRight?e.isRtl?s.right=e.contentWidth-(e.negativeScrollAdjustment+t.scrollLeft)-e.scrollbarYRight-e.scrollbarYOuterWidth-9:s.right=e.scrollbarYRight-t.scrollLeft:e.isRtl?s.left=e.negativeScrollAdjustment+t.scrollLeft+e.containerWidth*2-e.contentWidth-e.scrollbarYLeft-e.scrollbarYOuterWidth:s.left=e.scrollbarYLeft+t.scrollLeft,Y(e.scrollbarYRail,s),Y(e.scrollbarX,{left:e.scrollbarXLeft,width:e.scrollbarXWidth-e.railBorderXWidth}),Y(e.scrollbarY,{top:e.scrollbarYTop,height:e.scrollbarYHeight-e.railBorderYWidth})}function we(t){t.element,t.event.bind(t.scrollbarY,"mousedown",function(e){return e.stopPropagation()}),t.event.bind(t.scrollbarYRail,"mousedown",function(e){var n=e.pageY-window.pageYOffset-t.scrollbarYRail.getBoundingClientRect().top,l=n>t.scrollbarYTop?1:-1;t.element.scrollTop+=l*t.containerHeight,E(t),e.stopPropagation()}),t.event.bind(t.scrollbarX,"mousedown",function(e){return e.stopPropagation()}),t.event.bind(t.scrollbarXRail,"mousedown",function(e){var n=e.pageX-window.pageXOffset-t.scrollbarXRail.getBoundingClientRect().left,l=n>t.scrollbarXLeft?1:-1;t.element.scrollLeft+=l*t.containerWidth,E(t),e.stopPropagation()})}function _e(t){pt(t,["containerWidth","contentWidth","pageX","railXWidth","scrollbarX","scrollbarXWidth","scrollLeft","x","scrollbarXRail"]),pt(t,["containerHeight","contentHeight","pageY","railYHeight","scrollbarY","scrollbarYHeight","scrollTop","y","scrollbarYRail"])}function pt(t,e){var n=e[0],l=e[1],s=e[2],i=e[3],o=e[4],c=e[5],r=e[6],h=e[7],u=e[8],m=t.element,v=null,y=null,f=null;function p(g){g.touches&&g.touches[0]&&(g[s]=g.touches[0].pageY),m[r]=v+f*(g[s]-y),Et(t,h),E(t),g.stopPropagation(),g.type.startsWith("touch")&&g.changedTouches.length>1&&g.preventDefault()}function L(){At(t,h),t[u].classList.remove(T.state.clicking),t.event.unbind(t.ownerDocument,"mousemove",p)}function b(g,X){v=m[r],X&&g.touches&&(g[s]=g.touches[0].pageY),y=g[s],f=(t[l]-t[n])/(t[i]-t[c]),X?t.event.bind(t.ownerDocument,"touchmove",p):(t.event.bind(t.ownerDocument,"mousemove",p),t.event.once(t.ownerDocument,"mouseup",L),g.preventDefault()),t[u].classList.add(T.state.clicking),g.stopPropagation()}t.event.bind(t[o],"mousedown",function(g){b(g)}),t.event.bind(t[o],"touchstart",function(g){b(g,!0)})}function Se(t){var e=t.element,n=function(){return A(e,":hover")},l=function(){return A(t.scrollbarX,":focus")||A(t.scrollbarY,":focus")};function s(i,o){var c=Math.floor(e.scrollTop);if(i===0){if(!t.scrollbarYActive)return!1;if(c===0&&o>0||c>=t.contentHeight-t.containerHeight&&o<0)return!t.settings.wheelPropagation}var r=e.scrollLeft;if(o===0){if(!t.scrollbarXActive)return!1;if(r===0&&i<0||r>=t.contentWidth-t.containerWidth&&i>0)return!t.settings.wheelPropagation}return!0}t.event.bind(t.ownerDocument,"keydown",function(i){if(!(i.isDefaultPrevented&&i.isDefaultPrevented()||i.defaultPrevented)&&!(!n()&&!l())){var o=document.activeElement?document.activeElement:t.ownerDocument.activeElement;if(o){if(o.tagName==="IFRAME")o=o.contentDocument.activeElement;else for(;o.shadowRoot;)o=o.shadowRoot.activeElement;if(ge(o))return}var c=0,r=0;switch(i.which){case 37:i.metaKey?c=-t.contentWidth:i.altKey?c=-t.containerWidth:c=-30;break;case 38:i.metaKey?r=t.contentHeight:i.altKey?r=t.containerHeight:r=30;break;case 39:i.metaKey?c=t.contentWidth:i.altKey?c=t.containerWidth:c=30;break;case 40:i.metaKey?r=-t.contentHeight:i.altKey?r=-t.containerHeight:r=-30;break;case 32:i.shiftKey?r=t.containerHeight:r=-t.containerHeight;break;case 33:r=t.containerHeight;break;case 34:r=-t.containerHeight;break;case 36:r=t.contentHeight;break;case 35:r=-t.contentHeight;break;default:return}t.settings.suppressScrollX&&c!==0||t.settings.suppressScrollY&&r!==0||(e.scrollTop-=r,e.scrollLeft+=c,E(t),s(c,r)&&i.preventDefault())}})}function Te(t){var e=t.element;function n(o,c){var r=Math.floor(e.scrollTop),h=e.scrollTop===0,u=r+e.offsetHeight===e.scrollHeight,m=e.scrollLeft===0,v=e.scrollLeft+e.offsetWidth===e.scrollWidth,y;return Math.abs(c)>Math.abs(o)?y=h||u:y=m||v,y?!t.settings.wheelPropagation:!0}function l(o){var c=o.deltaX,r=-1*o.deltaY;return(typeof c>"u"||typeof r>"u")&&(c=-1*o.wheelDeltaX/6,r=o.wheelDeltaY/6),o.deltaMode&&o.deltaMode===1&&(c*=10,r*=10),c!==c&&r!==r&&(c=0,r=o.wheelDelta),o.shiftKey?[-r,-c]:[c,r]}function s(o,c,r){if(!V.isWebKit&&e.querySelector("select:focus"))return!0;if(!e.contains(o))return!1;for(var h=o;h&&h!==e;){if(h.classList.contains(T.element.consuming))return!0;var u=H(h);if(r&&u.overflowY.match(/(scroll|auto)/)){var m=h.scrollHeight-h.clientHeight;if(m>0&&(h.scrollTop>0&&r<0||h.scrollTop<m&&r>0))return!0}if(c&&u.overflowX.match(/(scroll|auto)/)){var v=h.scrollWidth-h.clientWidth;if(v>0&&(h.scrollLeft>0&&c<0||h.scrollLeft<v&&c>0))return!0}h=h.parentNode}return!1}function i(o){var c=l(o),r=c[0],h=c[1];if(!s(o.target,r,h)){var u=!1;t.settings.useBothWheelAxes?t.scrollbarYActive&&!t.scrollbarXActive?(h?e.scrollTop-=h*t.settings.wheelSpeed:e.scrollTop+=r*t.settings.wheelSpeed,u=!0):t.scrollbarXActive&&!t.scrollbarYActive&&(r?e.scrollLeft+=r*t.settings.wheelSpeed:e.scrollLeft-=h*t.settings.wheelSpeed,u=!0):(e.scrollTop-=h*t.settings.wheelSpeed,e.scrollLeft+=r*t.settings.wheelSpeed),E(t),u=u||n(r,h),u&&!o.ctrlKey&&(o.stopPropagation(),o.preventDefault())}}typeof window.onwheel<"u"?t.event.bind(e,"wheel",i):typeof window.onmousewheel<"u"&&t.event.bind(e,"mousewheel",i)}function Le(t){if(!V.supportsTouch&&!V.supportsIePointer)return;var e=t.element;function n(f,p){var L=Math.floor(e.scrollTop),b=e.scrollLeft,g=Math.abs(f),X=Math.abs(p);if(X>g){if(p<0&&L===t.contentHeight-t.containerHeight||p>0&&L===0)return window.scrollY===0&&p>0&&V.isChrome}else if(g>X&&(f<0&&b===t.contentWidth-t.containerWidth||f>0&&b===0))return!0;return!0}function l(f,p){e.scrollTop-=p,e.scrollLeft-=f,E(t)}var s={},i=0,o={},c=null;function r(f){return f.targetTouches?f.targetTouches[0]:f}function h(f){return f.pointerType&&f.pointerType==="pen"&&f.buttons===0?!1:!!(f.targetTouches&&f.targetTouches.length===1||f.pointerType&&f.pointerType!=="mouse"&&f.pointerType!==f.MSPOINTER_TYPE_MOUSE)}function u(f){if(h(f)){var p=r(f);s.pageX=p.pageX,s.pageY=p.pageY,i=new Date().getTime(),c!==null&&clearInterval(c)}}function m(f,p,L){if(!e.contains(f))return!1;for(var b=f;b&&b!==e;){if(b.classList.contains(T.element.consuming))return!0;var g=H(b);if(L&&g.overflowY.match(/(scroll|auto)/)){var X=b.scrollHeight-b.clientHeight;if(X>0&&(b.scrollTop>0&&L<0||b.scrollTop<X&&L>0))return!0}if(p&&g.overflowX.match(/(scroll|auto)/)){var N=b.scrollWidth-b.clientWidth;if(N>0&&(b.scrollLeft>0&&p<0||b.scrollLeft<N&&p>0))return!0}b=b.parentNode}return!1}function v(f){if(h(f)){var p=r(f),L={pageX:p.pageX,pageY:p.pageY},b=L.pageX-s.pageX,g=L.pageY-s.pageY;if(m(f.target,b,g))return;l(b,g),s=L;var X=new Date().getTime(),N=X-i;N>0&&(o.x=b/N,o.y=g/N,i=X),n(b,g)&&f.preventDefault()}}function y(){t.settings.swipeEasing&&(clearInterval(c),c=setInterval(function(){if(t.isInitialized){clearInterval(c);return}if(!o.x&&!o.y){clearInterval(c);return}if(Math.abs(o.x)<.01&&Math.abs(o.y)<.01){clearInterval(c);return}if(!t.element){clearInterval(c);return}l(o.x*30,o.y*30),o.x*=.8,o.y*=.8},10))}V.supportsTouch?(t.event.bind(e,"touchstart",u),t.event.bind(e,"touchmove",v),t.event.bind(e,"touchend",y)):V.supportsIePointer&&(window.PointerEvent?(t.event.bind(e,"pointerdown",u),t.event.bind(e,"pointermove",v),t.event.bind(e,"pointerup",y)):window.MSPointerEvent&&(t.event.bind(e,"MSPointerDown",u),t.event.bind(e,"MSPointerMove",v),t.event.bind(e,"MSPointerUp",y)))}var Ye=function(){return{handlers:["click-rail","drag-thumb","keyboard","wheel","touch"],maxScrollbarLength:null,minScrollbarLength:null,scrollingThreshold:1e3,scrollXMarginOffset:0,scrollYMarginOffset:0,suppressScrollX:!1,suppressScrollY:!1,swipeEasing:!0,useBothWheelAxes:!1,wheelPropagation:!0,wheelSpeed:1}},We={"click-rail":we,"drag-thumb":_e,keyboard:Se,wheel:Te,touch:Le},q=function(e,n){var l=this;if(n===void 0&&(n={}),typeof e=="string"&&(e=document.querySelector(e)),!e||!e.nodeName)throw new Error("no element is specified to initialize PerfectScrollbar");this.element=e,e.classList.add(T.main),this.settings=Ye();for(var s in n)this.settings[s]=n[s];this.containerWidth=null,this.containerHeight=null,this.contentWidth=null,this.contentHeight=null;var i=function(){return e.classList.add(T.state.focus)},o=function(){return e.classList.remove(T.state.focus)};this.isRtl=H(e).direction==="rtl",this.isRtl===!0&&e.classList.add(T.rtl),this.isNegativeScroll=function(){var h=e.scrollLeft,u=null;return e.scrollLeft=-1,u=e.scrollLeft<0,e.scrollLeft=h,u}(),this.negativeScrollAdjustment=this.isNegativeScroll?e.scrollWidth-e.clientWidth:0,this.event=new O,this.ownerDocument=e.ownerDocument||document,this.scrollbarXRail=G(T.element.rail("x")),e.appendChild(this.scrollbarXRail),this.scrollbarX=G(T.element.thumb("x")),this.scrollbarXRail.appendChild(this.scrollbarX),this.scrollbarX.setAttribute("tabindex",0),this.event.bind(this.scrollbarX,"focus",i),this.event.bind(this.scrollbarX,"blur",o),this.scrollbarXActive=null,this.scrollbarXWidth=null,this.scrollbarXLeft=null;var c=H(this.scrollbarXRail);this.scrollbarXBottom=parseInt(c.bottom,10),isNaN(this.scrollbarXBottom)?(this.isScrollbarXUsingBottom=!1,this.scrollbarXTop=w(c.top)):this.isScrollbarXUsingBottom=!0,this.railBorderXWidth=w(c.borderLeftWidth)+w(c.borderRightWidth),Y(this.scrollbarXRail,{display:"block"}),this.railXMarginWidth=w(c.marginLeft)+w(c.marginRight),Y(this.scrollbarXRail,{display:""}),this.railXWidth=null,this.railXRatio=null,this.scrollbarYRail=G(T.element.rail("y")),e.appendChild(this.scrollbarYRail),this.scrollbarY=G(T.element.thumb("y")),this.scrollbarYRail.appendChild(this.scrollbarY),this.scrollbarY.setAttribute("tabindex",0),this.event.bind(this.scrollbarY,"focus",i),this.event.bind(this.scrollbarY,"blur",o),this.scrollbarYActive=null,this.scrollbarYHeight=null,this.scrollbarYTop=null;var r=H(this.scrollbarYRail);this.scrollbarYRight=parseInt(r.right,10),isNaN(this.scrollbarYRight)?(this.isScrollbarYUsingRight=!1,this.scrollbarYLeft=w(r.left)):this.isScrollbarYUsingRight=!0,this.scrollbarYOuterWidth=this.isRtl?be(this.scrollbarY):null,this.railBorderYWidth=w(r.borderTopWidth)+w(r.borderBottomWidth),Y(this.scrollbarYRail,{display:"block"}),this.railYMarginHeight=w(r.marginTop)+w(r.marginBottom),Y(this.scrollbarYRail,{display:""}),this.railYHeight=null,this.railYRatio=null,this.reach={x:e.scrollLeft<=0?"start":e.scrollLeft>=this.contentWidth-this.containerWidth?"end":null,y:e.scrollTop<=0?"start":e.scrollTop>=this.contentHeight-this.containerHeight?"end":null},this.isAlive=!0,this.settings.handlers.forEach(function(h){return We[h](l)}),this.lastScrollTop=Math.floor(e.scrollTop),this.lastScrollLeft=e.scrollLeft,this.event.bind(this.element,"scroll",function(h){return l.onScroll(h)}),E(this)};q.prototype.update=function(){this.isAlive&&(this.negativeScrollAdjustment=this.isNegativeScroll?this.element.scrollWidth-this.element.clientWidth:0,Y(this.scrollbarXRail,{display:"block"}),Y(this.scrollbarYRail,{display:"block"}),this.railXMarginWidth=w(H(this.scrollbarXRail).marginLeft)+w(H(this.scrollbarXRail).marginRight),this.railYMarginHeight=w(H(this.scrollbarYRail).marginTop)+w(H(this.scrollbarYRail).marginBottom),Y(this.scrollbarXRail,{display:"none"}),Y(this.scrollbarYRail,{display:"none"}),E(this),Q(this,"top",0,!1,!0),Q(this,"left",0,!1,!0),Y(this.scrollbarXRail,{display:""}),Y(this.scrollbarYRail,{display:""}))};q.prototype.onScroll=function(e){this.isAlive&&(E(this),Q(this,"top",this.element.scrollTop-this.lastScrollTop),Q(this,"left",this.element.scrollLeft-this.lastScrollLeft),this.lastScrollTop=Math.floor(this.element.scrollTop),this.lastScrollLeft=this.element.scrollLeft)};q.prototype.destroy=function(){this.isAlive&&(this.event.unbindAll(),D(this.scrollbarX),D(this.scrollbarY),D(this.scrollbarXRail),D(this.scrollbarYRail),this.removePsClasses(),this.element=null,this.scrollbarX=null,this.scrollbarY=null,this.scrollbarXRail=null,this.scrollbarYRail=null,this.isAlive=!1)};q.prototype.removePsClasses=function(){this.element.className=this.element.className.split(" ").filter(function(e){return!e.match(/^ps([-_].+|)$/)}).join(" ")};const vt=["scroll","ps-scroll-y","ps-scroll-x","ps-scroll-up","ps-scroll-down","ps-scroll-left","ps-scroll-right","ps-y-reach-start","ps-y-reach-end","ps-x-reach-start","ps-x-reach-end"];var Re={name:"PerfectScrollbar",props:{options:{type:Object,required:!1,default:()=>{}},tag:{type:String,required:!1,default:"div"},watchOptions:{type:Boolean,required:!1,default:!1}},emits:vt,data(){return{ps:null}},watch:{watchOptions(t){!t&&this.watcher?this.watcher():this.createWatcher()}},mounted(){this.create(),this.watchOptions&&this.createWatcher()},updated(){this.$nextTick(()=>{this.update()})},beforeUnmount(){this.destroy()},methods:{create(){this.ps&&this.$isServer||(this.ps=new q(this.$el,this.options),vt.forEach(t=>{this.ps.element.addEventListener(t,e=>this.$emit(t,e))}))},createWatcher(){this.watcher=this.$watch("options",()=>{this.destroy(),this.create()},{deep:!0})},update(){this.ps&&this.ps.update()},destroy(){this.ps&&(this.ps.destroy(),this.ps=null)}},render(){return x(this.tag,{class:"ps"},this.$slots.default&&this.$slots.default())}};const Pt=t=>(_t("data-v-98bc1ac5"),t=t(),St(),t),Xe={class:"nav-header"},xe=["innerHTML"],ke=Pt(()=>_("h1",{class:"font-weight-medium leading-normal text-xl text-uppercase"}," PExam System ",-1)),He=Pt(()=>_("div",{class:"vertical-nav-items-shadow"},null,-1)),Ee={__name:"VerticalNav",props:{tag:{type:null,required:!1,default:"aside"},isOverlayNavActive:{type:Boolean,required:!0},toggleIsOverlayNavActive:{type:Function,required:!0}},setup(t){const e=t,{mdAndDown:n}=yt(),l=C(),s=wt();et(()=>s.path,()=>{e.toggleIsOverlayNavActive(!1)});const i=C(!1),o=r=>i.value=r,c=r=>{i.value=r.target.scrollTop>0};return(r,h)=>{const u=j("RouterLink");return k(),I(bt(e.tag),{ref_key:"refNav",ref:l,class:U(["layout-vertical-nav",[{visible:t.isOverlayNavActive,scrolled:R(i),"overlay-nav":R(n)}]])},{default:d(()=>[_("div",Xe,[M(r.$slots,"nav-header",{},()=>[a(u,{to:"/",class:"app-logo app-title-wrapper"},{default:d(()=>[_("div",{class:"d-flex",innerHTML:R(kt)},null,8,xe),ke]),_:1})],!0)]),M(r.$slots,"before-nav-items",{},()=>[He],!0),M(r.$slots,"nav-items",{updateIsVerticalNavScrolled:o},()=>[a(R(Re),{tag:"ul",class:"nav-items",options:{wheelPropagation:!1},onPsScrollY:c},{default:d(()=>[M(r.$slots,"default",{},void 0,!0)]),_:3})],!0),M(r.$slots,"after-nav-items",{},void 0,!0)]),_:3},8,["class"])}}},Ae=rt(Ee,[["__scopeId","data-v-98bc1ac5"]]);function Z(t){return typeof t=="function"?t():R(t)}typeof WorkerGlobalScope<"u"&&globalThis instanceof WorkerGlobalScope;const Ce=()=>{};function Pe(t,e){function n(...l){return new Promise((s,i)=>{Promise.resolve(t(()=>e.apply(this,l),{fn:e,thisArg:this,args:l})).then(s).catch(i)})}return n}const Mt=t=>t();function Me(t=Mt){const e=C(!0);function n(){e.value=!1}function l(){e.value=!0}const s=(...i)=>{e.value&&t(...i)};return{isActive:Tt(e),pause:n,resume:l,eventFilter:s}}function Ie(...t){if(t.length!==1)return nt(...t);const e=t[0];return typeof e=="function"?Tt(Bt(()=>({get:e,set:Ce}))):C(e)}function Ne(t,e,n={}){const{eventFilter:l=Mt,...s}=n;return et(t,Pe(l,e),s)}function mt(t,e,n={}){const{eventFilter:l,...s}=n,{eventFilter:i,pause:o,resume:c,isActive:r}=Me(l);return{stop:Ne(t,e,{...s,eventFilter:i}),pause:o,resume:c,isActive:r}}function $e(t,e,...[n]){const{flush:l="sync",deep:s=!1,immediate:i=!0,direction:o="both",transform:c={}}=n||{},r=[],h="ltr"in c&&c.ltr||(v=>v),u="rtl"in c&&c.rtl||(v=>v);return(o==="both"||o==="ltr")&&r.push(mt(t,v=>{r.forEach(y=>y.pause()),e.value=h(v),r.forEach(y=>y.resume())},{flush:l,deep:s,immediate:i})),(o==="both"||o==="rtl")&&r.push(mt(e,v=>{r.forEach(y=>y.pause()),t.value=u(v),r.forEach(y=>y.resume())},{flush:l,deep:s,immediate:i})),()=>{r.forEach(v=>v.stop())}}function Be(t=!1,e={}){const{truthyValue:n=!0,falsyValue:l=!1}=e,s=$t(t),i=C(t);function o(c){if(arguments.length)return i.value=c,i.value;{const r=Z(n);return i.value=i.value===r?Z(l):r,i.value}}return s?o:[i,o]}function Ve(t,e){const n=Vt(h()),l=Ie(t),s=Dt({get(){var u;const m=l.value;let v=e!=null&&e.getIndexOf?e.getIndexOf(n.value,m):m.indexOf(n.value);return v<0&&(v=(u=e==null?void 0:e.fallbackIndex)!=null?u:0),v},set(u){i(u)}});function i(u){const m=l.value,v=m.length,y=(u%v+v)%v,f=m[y];return n.value=f,f}function o(u=1){return i(s.value+u)}function c(u=1){return o(u)}function r(u=1){return o(-u)}function h(){var u,m;return(m=Z((u=e==null?void 0:e.initialValue)!=null?u:Z(t)[0]))!=null?m:void 0}return et(l,()=>i(s.value)),{state:n,index:s,next:c,prev:r}}const De=Ot({setup(t,{slots:e}){const n=C(!1),l=C(!1),s=Be(n),i=wt(),{mdAndDown:o}=yt();return $e(n,l),()=>{var v,y,f;const c=x(Ae,{isOverlayNavActive:n.value,toggleIsOverlayNavActive:s},{"nav-header":()=>{var p;return(p=e["vertical-nav-header"])==null?void 0:p.call(e,{toggleIsOverlayNavActive:s})},"before-nav-items":()=>{var p;return(p=e["before-vertical-nav-items"])==null?void 0:p.call(e)},default:()=>{var p;return(p=e["vertical-nav-content"])==null?void 0:p.call(e)},"after-nav-items":()=>{var p;return(p=e["after-vertical-nav-items"])==null?void 0:p.call(e)}}),r=x("header",{class:["layout-navbar navbar-blur"]},[x("div",{class:"navbar-content-container"},(v=e.navbar)==null?void 0:v.call(e,{toggleVerticalOverlayNavActive:s}))]),h=x("main",{class:"layout-page-content"},x("div",{class:"page-content-container"},(y=e.default)==null?void 0:y.call(e))),u=x("footer",{class:"layout-footer"},[x("div",{class:"footer-content-container"},(f=e.footer)==null?void 0:f.call(e))]),m=x("div",{class:["layout-overlay",{visible:l.value}],onClick:()=>{l.value=!l.value}});return x("div",{class:["layout-wrapper layout-nav-type-vertical layout-navbar-static layout-footer-static layout-content-width-fluid",o.value&&"layout-overlay-nav",i.meta.layoutWrapperClasses]},[c,x("div",{class:"layout-content-wrapper"},[r,h,u]),m])}}}),Oe={},Ue={class:"h-100 d-flex align-center justify-space-between"},je={class:"d-flex align-center"},Ke=_("a",{href:"https://pegien.co.ke",target:"_blank",rel:"noopener noreferrer",class:"text-primary ms-1"},"Patrick",-1);function qe(t,e){return k(),tt("div",Ue,[_("span",je,[B(" © "+P(new Date().getFullYear())+" Made By ",1),Ke])])}const Fe=rt(Oe,[["render",qe]]),ze={class:"text-capitalize"},Ge={__name:"ThemeSwitcher",props:{themes:{type:Array,required:!0}},setup(t){const e=t,{name:n,global:l}=Lt(),{state:s,next:i,index:o}=Ve(e.themes.map(r=>r.name),{initialValue:n}),c=()=>{l.name.value=i()};return et(()=>l.name.value,r=>{s.value=r}),(r,h)=>{const u=j("IconBtn");return k(),I(u,{onClick:c},{default:d(()=>[a(W,{icon:e.themes[R(o)].icon},null,8,["icon"]),a(re,{activator:"parent","open-delay":"1000","scroll-strategy":"close"},{default:d(()=>[_("span",ze,P(R(s)),1)]),_:1})]),_:1})}}},Je={__name:"NavbarThemeSwitcher",setup(t){const e=[{name:"light",icon:"ri-sun-line"},{name:"dark",icon:"ri-moon-clear-line"}];return(n,l)=>{const s=Ge;return k(),I(s,{themes:e})}}},Qe=Yt({bordered:Boolean,color:String,content:[Number,String],dot:Boolean,floating:Boolean,icon:Ut,inline:Boolean,label:{type:String,default:"$vuetify.badge"},max:[Number,String],modelValue:{type:Boolean,default:!0},offsetX:[Number,String],offsetY:[Number,String],textColor:String,...Wt(),...jt({location:"top end"}),...Kt(),...Rt(),...qt(),...le({transition:"scale-rotate-transition"})},"VBadge"),gt=Xt()({name:"VBadge",inheritAttrs:!1,props:Qe(),setup(t,e){const{backgroundColorClasses:n,backgroundColorStyles:l}=Ft(nt(t,"color")),{roundedClasses:s}=zt(t),{t:i}=Gt(),{textColorClasses:o,textColorStyles:c}=Jt(nt(t,"textColor")),{themeClasses:r}=Lt(),{locationStyles:h}=Qt(t,!0,u=>(t.floating?t.dot?2:4:t.dot?8:12)+(["top","bottom"].includes(u)?+(t.offsetY??0):["left","right"].includes(u)?+(t.offsetX??0):0));return xt(()=>{const u=Number(t.content),m=!t.max||isNaN(u)?t.content:u<=+t.max?u:`${t.max}+`,[v,y]=Zt(e.attrs,["aria-atomic","aria-label","aria-live","role","title"]);return a(t.tag,lt({class:["v-badge",{"v-badge--bordered":t.bordered,"v-badge--dot":t.dot,"v-badge--floating":t.floating,"v-badge--inline":t.inline},t.class]},y,{style:t.style}),{default:()=>{var f,p;return[a("div",{class:"v-badge__wrapper"},[(p=(f=e.slots).default)==null?void 0:p.call(f),a(oe,{transition:t.transition},{default:()=>{var L,b;return[te(a("span",lt({class:["v-badge__badge",r.value,n.value,s.value,o.value],style:[l.value,c.value,t.inline?{}:h.value],"aria-atomic":"true","aria-label":i(t.label,u),"aria-live":"polite",role:"status"},v),[t.dot?void 0:e.slots.badge?(b=(L=e.slots).badge)==null?void 0:b.call(L):t.icon?a(W,{icon:t.icon},null):m]),[[ee,t.modelValue]])]}})])]}})}),{}}}),Ze=Yt({start:Boolean,end:Boolean,...Wt(),...Rt()},"VListItemAction"),tn=Xt()({name:"VListItemAction",props:Ze(),setup(t,e){let{slots:n}=e;return xt(()=>a(t.tag,{class:["v-list-item-action",{"v-list-item-action--start":t.start,"v-list-item-action--end":t.end},t.class],style:t.style},n)),{}}}),en={__name:"UserProfile",setup(t){const e=ne();let n=window.location.protocol+"//"+window.location.hostname+":8080";const l={userInfo:{}},s=()=>{console.log("Checking User"),at.get(n+"/api/v1/user/checkUser",{headers:{"Content-Type":"application/json",Authorization:ot.get("Authorization")}}).then(o=>{l.userInfo=o.data}).catch(o=>{console.log(o),(o.response&&o.response.status===401||o.response.status===403)&&e.push("/login")})};window.setInterval(s,8e3);const i=()=>{at.get(n+"/api/v1/user/logOut",{headers:{"Content-Type":"application/json",Authorization:ot.get("Authorization")}}).then(o=>{console.log(o),e.push("/login")})};return(o,c)=>(k(),I(gt,{dot:"",location:"bottom right","offset-x":"3","offset-y":"3",color:"success",bordered:""},{default:d(()=>[a(it,{class:"cursor-pointer",color:"primary",variant:"tonal"},{default:d(()=>[a(ct,{src:R(st)},null,8,["src"]),a(se,{activator:"parent",width:"230",location:"bottom end",offset:"14px"},{default:d(()=>[a(ae,null,{default:d(()=>[a(F,null,{prepend:d(()=>[a(tn,{start:""},{default:d(()=>[a(gt,{dot:"",location:"bottom right","offset-x":"3","offset-y":"3",color:"success"},{default:d(()=>[a(it,{color:"primary",variant:"tonal"},{default:d(()=>[a(ct,{src:R(st)},null,8,["src"])]),_:1})]),_:1})]),_:1})]),default:d(()=>[a(z,{class:"font-weight-semibold"},{default:d(()=>[B(P(l.userInfo.username),1)]),_:1}),a(ie,null,{default:d(()=>[B(P(l.userInfo.fname),1)]),_:1})]),_:1}),a(ut,{class:"my-2"}),a(F,{link:"",to:"/profile"},{prepend:d(()=>[a(W,{class:"me-2",icon:"ri-user-line",size:"22"})]),default:d(()=>[a(z,null,{default:d(()=>[B("Profile")]),_:1})]),_:1}),a(F,{link:"",to:"/profilePassword"},{prepend:d(()=>[a(W,{class:"me-2",icon:"ri-settings-4-line",size:"22"})]),default:d(()=>[a(z,null,{default:d(()=>[B("Password Settings")]),_:1})]),_:1}),a(ut,{class:"my-2"}),a(F,{onClick:i},{prepend:d(()=>[a(W,{class:"me-2",icon:"ri-logout-box-r-line",size:"22"})]),default:d(()=>[a(z,null,{default:d(()=>[B("Logout")]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})]),_:1}))}},It=t=>(_t("data-v-37c8ad79"),t=t(),St(),t),nn={class:"d-flex h-100 align-center"},rn={class:"d-flex align-center cursor-pointer",style:{"user-select":"none"}},ln=It(()=>_("span",{class:"d-none d-md-flex align-center text-disabled"},[_("span",{class:"me-3"},"Search"),_("span",{class:"meta-key"},"⌘K")],-1)),on=["innerHTML"],sn=It(()=>_("h1",{class:"font-weight-medium leading-normal text-xl text-uppercase"}," PExam System ",-1)),an={__name:"DefaultLayoutWithVerticalNav",setup(t){return(e,n)=>{const l=j("IconBtn"),s=j("RouterLink");return k(),I(De,null,{navbar:d(({toggleVerticalOverlayNavActive:i})=>[_("div",nn,[a(l,{class:"ms-n3 d-lg-none",onClick:o=>i(!0)},{default:d(()=>[a(W,{icon:"ri-menu-line"})]),_:2},1032,["onClick"]),_("div",rn,[a(l,null,{default:d(()=>[a(W,{icon:"ri-search-line"})]),_:1}),ln]),a(ce),a(l,{class:"me-2"},{default:d(()=>[a(W,{icon:"ri-notification-line"})]),_:1}),a(Je,{class:"me-2"}),a(en)])]),"vertical-nav-header":d(({toggleIsOverlayNavActive:i})=>[a(s,{to:"/",class:"app-logo app-title-wrapper"},{default:d(()=>[_("div",{class:"d-flex",innerHTML:R(kt)},null,8,on),sn]),_:1}),a(l,{class:"d-block d-lg-none",onClick:o=>i(!1)},{default:d(()=>[a(W,{icon:"ri-close-line"})]),_:2},1032,["onClick"])]),"vertical-nav-content":d(()=>[a(pe)]),footer:d(()=>[a(Fe)]),default:d(()=>[M(e.$slots,"default",{},void 0,!0)]),_:3})}}},cn=rt(an,[["__scopeId","data-v-37c8ad79"]]),Xn={__name:"default",setup(t){return(e,n)=>{const l=j("RouterView");return k(),I(cn,null,{default:d(()=>[a(l)]),_:1})}}};export{Xn as default};
