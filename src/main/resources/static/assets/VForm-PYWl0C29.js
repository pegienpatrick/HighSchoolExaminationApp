import{D as p,E as b,L as v,r as F,R as V,b as y}from"./index-xVnyt9yu.js";import{m as R,c as h}from"./form-Fs2--v9g.js";import{f as P}from"./forwardRefs-y8pOSn8h.js";const k=p({...b(),...R()},"VForm"),g=v()({name:"VForm",props:k(),emits:{"update:modelValue":r=>!0,submit:r=>!0},setup(r,f){let{slots:n,emit:i}=f;const a=h(r),s=F();function l(t){t.preventDefault(),a.reset()}function u(t){const o=t,e=a.validate();o.then=e.then.bind(e),o.catch=e.catch.bind(e),o.finally=e.finally.bind(e),i("submit",o),o.defaultPrevented||e.then(c=>{var m;let{valid:d}=c;d&&((m=s.value)==null||m.submit())}),o.preventDefault()}return V(()=>{var t;return y("form",{ref:s,class:["v-form",r.class],style:r.style,novalidate:!0,onReset:l,onSubmit:u},[(t=n.default)==null?void 0:t.call(n,a)])}),P(a,s)}});export{g as V};
