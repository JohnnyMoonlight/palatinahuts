(function(){"use strict";var t={2136:function(t,e,n){var i=n(144),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-container",[n("v-app",{attrs:{id:"app"}},[n("v-navigation-drawer",{staticClass:"pt-4",attrs:{app:"",permanent:""}},[n("v-list-item",[n("v-list-item-content",[n("v-list-item-title",{staticClass:"text-h6"},[t._v(" Von Hütte zu Hütte ")]),n("v-list-item-subtitle",[t._v(" Wandern im Pfälzerwald ")])],1)],1),n("v-divider"),t._l(t.navigationItems,(function(e){return n("div",{key:e.text},[n("v-list-item",{attrs:{id:e.id,to:e.path}},[n("v-list-item-icon",[n("v-icon",[t._v(t._s(e.icon))])],1),n("v-list-item-title",[t._v(t._s(e.text))])],1),n("b-tooltip",{attrs:{delay:"250",hide:"100",target:e.id}},[t._v(t._s(e.tooltip)+" ")])],1)}))],2),n("v-main",[t._l(t.navigationItems,(function(t){return n("div",{key:t.text})})),n("router-view")],2)],1)],1)},r=[],a={setup(){},data:()=>({navigationItems:[{path:"/map",id:"map_navigator",icon:"mdi-map",text:"Karte",tooltip:"Hütten auf einer Kartenansicht"},{path:"/huts",id:"huts",icon:"mdi-view-list",text:"Liste",tooltip:"Hütten in Listenform"},{path:"/hutmanagement",id:"hutmanagement",icon:"mdi-home-outline",text:"Neue Hütte erstellen",tooltip:"Hütten hinzufügen"},{path:"/moderation",id:"moderation",icon:"mdi-file-find",text:"Moderation",tooltip:"Inhalte moderieren"},{path:"/settings",id:"settings_navigator",icon:"mdi-wrench",text:"Einstellungen",tooltip:"Einstellungen ändern"},{path:"/about",id:"about_navigator",icon:"mdi-information-outline",text:"Info",tooltip:"Über App und Author"}]})},u=a,l=n(1001),s=n(3453),c=n.n(s),f=n(7524),d=n(9846),p=n(1418),m=n(6428),v=n(7620),h=n(5192),g=n(459),b=n(7877),y=n(7429),_=(0,l.Z)(u,o,r,!1,null,null,null),w=_.exports;c()(_,{VApp:f.Z,VContainer:d.Z,VDivider:p.Z,VIcon:m.Z,VListItem:v.Z,VListItemContent:h.km,VListItemIcon:g.Z,VListItemSubtitle:h.oZ,VListItemTitle:h.V9,VMain:b.Z,VNavigationDrawer:y.Z});var k=n(9132);i["default"].use(k.Z);var x=new k.Z({}),C=n(8345);i["default"].use(C.Z);const O=[{path:"/about",name:"about",component:()=>n.e(443).then(n.bind(n,9030))},{path:"/huts",name:"huhutstmanagement",component:()=>n.e(443).then(n.bind(n,4469))},{path:"/hutmanagement",name:"hutmanagement",component:()=>n.e(443).then(n.bind(n,2365))},{path:"/moderation",name:"moderation",component:()=>n.e(443).then(n.bind(n,9612))},{path:"/map",name:"map",component:()=>n.e(443).then(n.bind(n,1090))}],E=new C.Z({routes:O});var Z=E,I=n(5069),V=n(3017);n(44);i["default"].config.productionTip=!1,i["default"].use(I.XG7),i["default"].use(V.X),new i["default"]({vuetify:x,router:Z,render:t=>t(w)}).$mount("#app")}},e={};function n(i){var o=e[i];if(void 0!==o)return o.exports;var r=e[i]={exports:{}};return t[i].call(r.exports,r,r.exports,n),r.exports}n.m=t,function(){var t=[];n.O=function(e,i,o,r){if(!i){var a=1/0;for(c=0;c<t.length;c++){i=t[c][0],o=t[c][1],r=t[c][2];for(var u=!0,l=0;l<i.length;l++)(!1&r||a>=r)&&Object.keys(n.O).every((function(t){return n.O[t](i[l])}))?i.splice(l--,1):(u=!1,r<a&&(a=r));if(u){t.splice(c--,1);var s=o();void 0!==s&&(e=s)}}return e}r=r||0;for(var c=t.length;c>0&&t[c-1][2]>r;c--)t[c]=t[c-1];t[c]=[i,o,r]}}(),function(){n.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return n.d(e,{a:e}),e}}(),function(){n.d=function(t,e){for(var i in e)n.o(e,i)&&!n.o(t,i)&&Object.defineProperty(t,i,{enumerable:!0,get:e[i]})}}(),function(){n.f={},n.e=function(t){return Promise.all(Object.keys(n.f).reduce((function(e,i){return n.f[i](t,e),e}),[]))}}(),function(){n.u=function(t){return"js/about.4d5bbd66.js"}}(),function(){n.miniCssF=function(t){return"css/about.97e32d86.css"}}(),function(){n.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(t){if("object"===typeof window)return window}}()}(),function(){n.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)}}(),function(){var t={},e="palatine_huts:";n.l=function(i,o,r,a){if(t[i])t[i].push(o);else{var u,l;if(void 0!==r)for(var s=document.getElementsByTagName("script"),c=0;c<s.length;c++){var f=s[c];if(f.getAttribute("src")==i||f.getAttribute("data-webpack")==e+r){u=f;break}}u||(l=!0,u=document.createElement("script"),u.charset="utf-8",u.timeout=120,n.nc&&u.setAttribute("nonce",n.nc),u.setAttribute("data-webpack",e+r),u.src=i),t[i]=[o];var d=function(e,n){u.onerror=u.onload=null,clearTimeout(p);var o=t[i];if(delete t[i],u.parentNode&&u.parentNode.removeChild(u),o&&o.forEach((function(t){return t(n)})),e)return e(n)},p=setTimeout(d.bind(null,void 0,{type:"timeout",target:u}),12e4);u.onerror=d.bind(null,u.onerror),u.onload=d.bind(null,u.onload),l&&document.head.appendChild(u)}}}(),function(){n.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})}}(),function(){n.p="/"}(),function(){var t=function(t,e,n,i){var o=document.createElement("link");o.rel="stylesheet",o.type="text/css";var r=function(r){if(o.onerror=o.onload=null,"load"===r.type)n();else{var a=r&&("load"===r.type?"missing":r.type),u=r&&r.target&&r.target.href||e,l=new Error("Loading CSS chunk "+t+" failed.\n("+u+")");l.code="CSS_CHUNK_LOAD_FAILED",l.type=a,l.request=u,o.parentNode.removeChild(o),i(l)}};return o.onerror=o.onload=r,o.href=e,document.head.appendChild(o),o},e=function(t,e){for(var n=document.getElementsByTagName("link"),i=0;i<n.length;i++){var o=n[i],r=o.getAttribute("data-href")||o.getAttribute("href");if("stylesheet"===o.rel&&(r===t||r===e))return o}var a=document.getElementsByTagName("style");for(i=0;i<a.length;i++){o=a[i],r=o.getAttribute("data-href");if(r===t||r===e)return o}},i=function(i){return new Promise((function(o,r){var a=n.miniCssF(i),u=n.p+a;if(e(a,u))return o();t(i,u,o,r)}))},o={143:0};n.f.miniCss=function(t,e){var n={443:1};o[t]?e.push(o[t]):0!==o[t]&&n[t]&&e.push(o[t]=i(t).then((function(){o[t]=0}),(function(e){throw delete o[t],e})))}}(),function(){var t={143:0};n.f.j=function(e,i){var o=n.o(t,e)?t[e]:void 0;if(0!==o)if(o)i.push(o[2]);else{var r=new Promise((function(n,i){o=t[e]=[n,i]}));i.push(o[2]=r);var a=n.p+n.u(e),u=new Error,l=function(i){if(n.o(t,e)&&(o=t[e],0!==o&&(t[e]=void 0),o)){var r=i&&("load"===i.type?"missing":i.type),a=i&&i.target&&i.target.src;u.message="Loading chunk "+e+" failed.\n("+r+": "+a+")",u.name="ChunkLoadError",u.type=r,u.request=a,o[1](u)}};n.l(a,l,"chunk-"+e,e)}},n.O.j=function(e){return 0===t[e]};var e=function(e,i){var o,r,a=i[0],u=i[1],l=i[2],s=0;if(a.some((function(e){return 0!==t[e]}))){for(o in u)n.o(u,o)&&(n.m[o]=u[o]);if(l)var c=l(n)}for(e&&e(i);s<a.length;s++)r=a[s],n.o(t,r)&&t[r]&&t[r][0](),t[r]=0;return n.O(c)},i=self["webpackChunkpalatine_huts"]=self["webpackChunkpalatine_huts"]||[];i.forEach(e.bind(null,0)),i.push=e.bind(null,i.push.bind(i))}();var i=n.O(void 0,[998],(function(){return n(2136)}));i=n.O(i)})();
//# sourceMappingURL=app.2cf191db.js.map