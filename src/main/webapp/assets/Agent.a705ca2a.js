import{C as e,A as l,p as a,a as o,w as t,r as s,o as d,c as i,f as n,i as u,h as r}from"./vendor.f97b600a.js";import{g as c,o as p,p as b,q as m,r as g,s as h,a as f,b as v,c as y,h as V,j as w,t as k,v as _,u as j,k as x,l as E,m as C,n as S}from"./index.5b164984.js";import{d as D}from"./download.ea7975ab.js";import"./index.9688d811.js";const N={name:"basetable",methods:{getLvl:e=>e<=102?"0转"+e:e<=210?"1转"+(e-102+14):e<=338?"2转"+(e-210+14):e<=459?"3转"+(e-338+59):"飞升"+(e-459+139)},setup(){const a=e({value1:"",value2:"",pageNum:1,pageSize:10}),o=l([]),s=l([]),d=l([]),i=l([]),n=l([]),u=l([]),r=l([]),N=l([]),U=l([]),I=l(0),O=l(null),q=l([]),A=l("");p().then((e=>{A.value=e.data}));const G=()=>{m(a).then((e=>{u.value=e.data,I.value=e.data.total}))};G();g(a).then((e=>{q.value=e.data}));const P=(e,l)=>{console.log(l),h(l).then((e=>{G()}))},T=(e,l)=>{f(a).then((e=>{s.value=e.data,F.value=!0}))},z=(e,l)=>{v(a).then((e=>{d.value=e.data,H.value=!0}))},$=(e,l)=>{V(a).then((e=>{n.value=e.data,R.value=!0}))},B=l(null),M=l(!1),F=l(!1),H=l(!1),L=l(!1),R=l(!1),J=l(!1),K=l(!1),Q=l(!1),W=l(!1);l(!1);const X=l(!1),Y=l(!1);let Z=e({agentName:"",userName:"",password:"",tel:"",qid:"",agentId:"",jurisdiction:""}),ee=e({role_id:"",rolename:"",type:"坐骑"}),le=e({rgid:"",goodsname:"",value:"",role_id:""}),ae=e({babyage:0,babyid:2001,babyname:"多少的宝宝",childSex:1,daode:0,mingqi:0,naili:0,neili:0,outcome:null,panni:0,parts:"-1|-1|-1|-1",pilao:0,qingmi:0,qizhi:0,roleid:11,talents:"1=1|2=1|3=1",wanxing:0,wenbao:0,xiaoxin:0,yangyujin:0,zhili:0}),oe=e({assistance:"",baoactive:0,baoap:"",baoid:0,baoname:"",baoquality:"",baoreply:"0",baoshot:"0",baospeed:"0",baotype:"",equipment:0,fushis:null,fusum:0,gethard:"",goodskill:"",kangxing:"",lingbaoexe:0,lingbaolvl:0,lingbaoqihe:0,operation:null,resistshot:"0",roleid:0,skills:null,skillsum:0,skin:"",tianfuskill:""}),te=e({bone:0,exp:0,gradeexp:0,live:0,mid:0,mountid:0,mountlvl:0,mountname:"",mountskill:[],moveGrade:null,othrersid:null,power:0,Proficiency:0,roleid:0,sid:null,sid3:null,sid4:null,sid5:null,spri:0,useNumber:0}),se=e({sid:"",grade:"",turnRount:0,summoningname:"",friendliness:0,openSeal:1,lx:"",skill:"",nds:""});const de=e(null);let ie=-1;const ne=l(!1),ue=l(!1);return{upAgentSendGood:()=>{let e={Value1:A.value};console.log(e),b(e).then((e=>{200===e.code?t.success("修改成功！"):t.success("错误")}))},agent:Z,goodsTableData:o,query:a,tableData:u,pageTotal:I,editVisible:J,form:ee,handleSearch:()=>{a.pageNum=1,G()},handlePageChange:e=>{a.pageNum=e,G()},handleDelete:(e,l,a)=>{Object.keys(ee).forEach((e=>{ee[e]=l[e]})),D("/api/report",{roleId:ee.role_id,type:a})},handleEdit:(e,l)=>{ie=e,Object.keys(le).forEach((e=>{console.log(l[e]),le[e]=l[e]})),console.log(le),J.value=!0},saveEdit:()=>{J.value=!1,E({roleId:ee.role_id}).then((e=>{(e.code=200)?t.success("成功更改满级"):t.success("修改失败")})),Object.keys(ee).forEach((e=>{u.value[ie][e]=ee[e]}))},handleSizeChange:e=>{console.log(`每页 ${e} 条`),a.pageSize=e,G()},handleSelectionChange:e=>{console.log(`选择了 ${e} 条`)},clearVisible:ne,clearInfo:(e,l)=>{ie=e,Object.keys(ee).forEach((e=>{console.log(l[e]),ee[e]=l[e]})),ne.value=!0},pwdUpVisible:Y,doClearInfo:()=>{ne.value=!1,C({roleId:ee.role_id,type:ee.type,roleName:ee.rolename}).then((e=>{(e.code=200)?t.success("删除"+ee.type+"信息成功,该角色已被踢下线"):t.success("修改失败")})),Object.keys(ee).forEach((e=>{u.value[ie][e]=ee[e]}))},options:[{value:"坐骑",label:"坐骑"},{value:"召唤兽",label:"召唤兽"},{value:"灵宝",label:"灵宝"},{value:"物品",label:"物品"}],fullVisible:ue,fullInfo:(e,l)=>{ie=e,Object.keys(ee).forEach((e=>{console.log(l[e]),ee[e]=l[e]})),ue.value=!0},doFullInfo:()=>{ue.value=!1,S({roleId:ee.role_id,type:ee.type,rolename:ee.rolename}).then((e=>{(e.code=200)?t.success("删除"+ee.type+"信息成功,该角色已被踢下线"):t.success("修改失败")})),Object.keys(ee).forEach((e=>{u.value[ie][e]=ee[e]}))},getUserGood:c,areas:q,deleteAgent:(e,l)=>{P(e,l)},goodsVisible:M,mountHandleEdit:(e,l)=>{ie=e,console.log(l),Object.keys(te).forEach((e=>{te[e]=l[e]})),console.log(te),Q.value=!0},mount:te,mountEditVisible:Q,saveMountEdit:()=>{y(te).then((e=>{(e.code=200)?t.success("修改成功"):t.success("修改失败"),this.petEditVisible=!1}))},lingVisible:L,lingEditVisible:W,babyVisible:R,getBabyData:(e,l)=>{Object.keys(ee).forEach((e=>{console.log(l[e]),ee[e]=l[e]})),a.value1=ee.role_id,$()},upPwdData:de,upPwd:()=>{console.log(N),N&&(Z.jurisdiction=N.value.join("|")),_(Z).then((e=>{(e.code=200)?t.success("修改成功"):t.success("修改失败"),Y.value=!1,G()}))},lx:O,nds:r,skill:U,savePetEdit:()=>{r&&(se.nds=r.value.join("|")),x(se).then((e=>{(e.code=200)?t.success("修改成功"):t.success("修改失败"),this.petEditVisible=!1}))},mountTableData:d,mountVisible:H,getMountData:(e,l)=>{Object.keys(ee).forEach((e=>{console.log(l[e]),ee[e]=l[e]})),a.value1=ee.role_id,z()},lingTableData:i,babyTableData:n,ling:oe,baby:ae,saveBabyEdit:()=>{w(ae).then((e=>{(e.code=200)?t.success("修改成功"):t.success("修改失败"),this.petEditVisible=!1}))},updateShow:(e,l)=>{if(Object.keys(Z).forEach((e=>{Z[e]=l[e]})),Z.jurisdiction){let e=Z.jurisdiction.split("|");N.value=e}Y.value=!0,console.log(Z)},getGoodsdata:(e,l)=>{Object.keys(ee).forEach((e=>{console.log(l[e]),ee[e]=l[e]})),a.value1=ee.role_id,c(a).then((e=>{o.value=e.data,M.value=!0}))},goods:le,saveGoodEdit:()=>{J.value=!1,j(le).then((e=>{(e.code=200)?t.success("修改成功"):t.success("修改失败")})),Object.keys(ee).forEach((e=>{u.value[ie][e]=ee[e]}))},getPetData:(e,l)=>{Object.keys(ee).forEach((e=>{console.log(l[e]),ee[e]=l[e]})),a.value1=ee.role_id,T()},petVisible:F,petTableData:s,petEditVisible:K,pet:se,agentVisible:X,rules:{userName:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}],qid:[{required:!0,message:"请选择区域",trigger:"blur"}]},agentShow:()=>{X.value=!0},insetAgent:()=>{N&&(Z.jurisdiction=N.value.join("|")),console.log(1111),B.value.validate((e=>{if(!e)return t.error("请填写完整信息"),!1;k(Z).then((e=>{200===e.code?(t({message:"请求成功",type:"success",duration:1500,customClass:"element-error-message-zindex"}),G(),X.value=!1):t.error(e.message)})).catch((e=>{}))}))},jurisdiction:N,vAddAgent:B,agentGoodsIdsData:A}}},U=u();a("data-v-950d1a66");const I={class:"crumbs"},O=n("i",{class:"el-icon-lx-cascades"},null,-1),q=r(" 代理 "),A={class:"container"},G={class:"handle-box"},P={style:{"margin-top":"10px"}},T={style:{width:"50%"}},z={style:{width:"49%"}},$=r("修改"),B={class:"handle-box"},M=r("新增代理"),F=r("删除"),H=r("修改信息"),L={class:"dialog-footer"},R=r("取 消"),J=r("修改"),K={class:"dialog-footer"},Q=r("取 消"),W=r("新增");o();const X=U(((e,l,a,o,t,u)=>{const r=s("el-breadcrumb-item"),c=s("el-breadcrumb"),p=s("el-alert"),b=s("el-input"),m=s("el-button"),g=s("el-table-column"),h=s("el-table"),f=s("el-form-item"),v=s("el-checkbox"),y=s("el-checkbox-group"),V=s("el-form"),w=s("el-dialog");return d(),i("div",null,[n("div",I,[n(c,{separator:"/"},{default:U((()=>[n(r,null,{default:U((()=>[O,q])),_:1})])),_:1})]),n("div",A,[n("div",G,[n(p,{title:"代理可发送物品设置",type:"success",description:"物品id|物品id......",closable:!1,"show-icon":""}),n("div",P,[n("div",T,[n(b,{type:"textarea",rows:5,placeholder:"设置代理可发送的物品id",modelValue:o.agentGoodsIdsData,"onUpdate:modelValue":l[1]||(l[1]=e=>o.agentGoodsIdsData=e)},null,8,["modelValue"])]),n("div",z,[n(m,{type:"primary",onClick:o.upAgentSendGood},{default:U((()=>[$])),_:1},8,["onClick"])])])]),n("div",B,[n(m,{type:"primary",icon:"el-icon-search",onClick:o.agentShow},{default:U((()=>[M])),_:1},8,["onClick"])]),n(h,{data:o.tableData,border:"",class:"table",ref:"multipleTable","header-cell-class-name":"table-header",onSelectionChange:o.handleSelectionChange},{default:U((()=>[n(g,{type:"selection",width:"55"}),n(g,{width:"50px",prop:"agentId",label:"代理id"}),n(g,{width:"150px",prop:"userName",label:"代理名称"}),n(g,{width:"150px",prop:"password",label:"代理密码"}),n(g,{width:"150px",prop:"tel",label:"联系方式"}),n(g,{width:"150px",prop:"jurisdiction",label:"权限"}),n(g,{label:"功能列表"},{default:U((e=>[n(m,{style:{float:"left"},type:"primary",onClick:l=>o.deleteAgent(e.$index,e.row)},{default:U((()=>[F])),_:2},1032,["onClick"]),n(m,{style:{float:"left"},type:"primary",onClick:l=>o.updateShow(e.$index,e.row)},{default:U((()=>[H])),_:2},1032,["onClick"])])),_:1})])),_:1},8,["data","onSelectionChange"])]),n(w,{title:"修改",modelValue:o.pwdUpVisible,"onUpdate:modelValue":l[7]||(l[7]=e=>o.pwdUpVisible=e),width:"30%"},{footer:U((()=>[n("span",L,[n(m,{onClick:l[5]||(l[5]=e=>o.pwdUpVisible=!1)},{default:U((()=>[R])),_:1}),n(m,{type:"primary",onClick:l[6]||(l[6]=e=>o.upPwd("agent"))},{default:U((()=>[J])),_:1})])])),default:U((()=>[n(V,{"label-width":"100px"},{default:U((()=>[n(f,{label:"代理账号",prop:"userName"},{default:U((()=>[n(b,{modelValue:o.agent.userName,"onUpdate:modelValue":l[2]||(l[2]=e=>o.agent.userName=e),disabled:""},null,8,["modelValue"])])),_:1}),n(f,{label:"代理密码",prop:"password"},{default:U((()=>[n(b,{modelValue:o.agent.password,"onUpdate:modelValue":l[3]||(l[3]=e=>o.agent.password=e)},null,8,["modelValue"])])),_:1}),n(f,{label:"权限"},{default:U((()=>[n(y,{modelValue:o.jurisdiction,"onUpdate:modelValue":l[4]||(l[4]=e=>o.jurisdiction=e),max:4},{default:U((()=>[n(v,{label:"充值"}),n(v,{label:"物品"})])),_:1},8,["modelValue"])])),_:1})])),_:1})])),_:1},8,["modelValue"]),n(w,{title:"新增代理",modelValue:o.agentVisible,"onUpdate:modelValue":l[14]||(l[14]=e=>o.agentVisible=e),width:"30%"},{footer:U((()=>[n("span",K,[n(m,{onClick:l[12]||(l[12]=e=>o.agentVisible=!1)},{default:U((()=>[Q])),_:1}),n(m,{type:"primary",onClick:l[13]||(l[13]=e=>o.insetAgent("agent"))},{default:U((()=>[W])),_:1})])])),default:U((()=>[n(V,{"label-width":"100px",model:o.agent,rules:o.rules,ref:"vAddAgent"},{default:U((()=>[n(f,{label:"代理账号",prop:"userName"},{default:U((()=>[n(b,{modelValue:o.agent.userName,"onUpdate:modelValue":l[8]||(l[8]=e=>o.agent.userName=e)},null,8,["modelValue"])])),_:1}),n(f,{label:"代理密码",prop:"password"},{default:U((()=>[n(b,{modelValue:o.agent.password,"onUpdate:modelValue":l[9]||(l[9]=e=>o.agent.password=e)},null,8,["modelValue"])])),_:1}),n(f,{label:"联系方式"},{default:U((()=>[n(b,{modelValue:o.agent.tel,"onUpdate:modelValue":l[10]||(l[10]=e=>o.agent.tel=e)},null,8,["modelValue"])])),_:1}),n(f,{label:"权限"},{default:U((()=>[n(y,{modelValue:o.jurisdiction,"onUpdate:modelValue":l[11]||(l[11]=e=>o.jurisdiction=e),max:4},{default:U((()=>[n(v,{label:"充值"}),n(v,{label:"物品"})])),_:1},8,["modelValue"])])),_:1})])),_:1},8,["model","rules"])])),_:1},8,["modelValue"])])}));N.render=X,N.__scopeId="data-v-950d1a66";export default N;
