/*
 * 地址列表
 * id 唯一的标识 不能重复
 * name 显示的名称，默认 未知链接
 * address 跳转链接
 * imgUrl 页面图片显示地址
 * parentId 对应navlist的id
 * desc 页面弹框提示
 **/
var addressList = [
 {
    id: 0,
    name: '项目审计管理系统',
    address: 'https://meta.linkcook.cn/pams/admin/#/login?redirect=%2Fdashboard',
    imgUrl: '	https://fridge.linkcook.cn/main/icon/pams.png',
    parentId: 1
  },

    {
    id: 22,
    name: 'Jenkins',
    address: 'https://fridge.linkcook.cn:8080/jenkins/',
    imgUrl: '	https://fridge.linkcook.cn/main/icon/yunjenkins.png',
    parentId: 1,
   
  },
  {
    id: 17,
    name: 'gerrit',
    address: 'https://fridge.linkcook.cn:8082/dashboard/self',
    imgUrl: '	https://fridge.linkcook.cn/main/icon/gerrit.png',
    parentId: 1
  }
  ,
  {
    id: 3,
    name: '挂单',
    address: 'http://hritnew.haier.net/views/index.html',
    imgUrl: '',
    parentId: 2,
	desc: '<div>配置标签的提示:</div><div>1、1</div><div>2、2</div><div>3、3</div><div>4、4</div>'
  },
  {
    id: 4,
    name: '蓝湖',
    address: 'https://lanhuapp.com/web/?code=0116C7iA0oZC8d1UrNgA0WHriA06C7ig&state=#/item/project/board/detail?pid=1e011d68-6b67-4858-a5ae-3f73dec3958a&project_id=1e011d68-6b67-4858-a5ae-3f73dec3958a&image_id=1fe6e493-4b75-422a-b7df-deb19cfb37d0',
    imgUrl: '',
    parentId: 2
  },
  {
    id: 5,
    name: 'bugJira',
    address: 'http://10.162.195.47:8084/',
    imgUrl: 'https://fridge.linkcook.cn/main/icon/jira.png',
    parentId: 1
  }
  ,
  {
    id: 20,
    name: 'Yapi',
    address: 'https://fridge.linkcook.cn:3000/',
    imgUrl: 'https://fridge.linkcook.cn/main/icon/yapi.png',
    parentId: 1
  }
  ,
    {
    id: 23,
    name: 'maven',
    address: 'http://10.162.195.142:8085/#browse/search=keyword%3Dspstorage:bb6c6ef9796dac83b6db5b0fd391f641:48c7a679aa67976b389405b728fb8143',
    imgUrl: 'https://devapi.linkcook.cn/oss_dev/production/skrd/platform/210F6153245353.png',
    parentId: 1
  }
  ,
 {
    id: 25,
    name: 'XWiKi',
    address: 'http://fridge.linkcook.cn:8090/xwiki/bin/view/Main/',
    imgUrl: '	https://fridge.linkcook.cn/main/icon/xwiki.png',
    parentId: 1,
  },
  {
    id: 6,
    name: 'gitlab',
    address: 'https://fridge.linkcook.cn:8083/',
    imgUrl: 'https://fridge.linkcook.cn/main/icon/gitlab.png',
    parentId: 1
  }
  ,
  {
    id: 7,
    name: '海智慧首页',
    address: 'https://p.haier.net/portal/pages/index',
    imgUrl: '',
    parentId: 2
  }
  ,
  {
    id: 8,
    name: '配置文件管理',
    address: 'https://line.linkcook.cn/extend-web/versions/admin',
    imgUrl: 'https://fridge.linkcook.cn/main/icon/xml.png',
    parentId: 1
  }
  ,
  {
    id: 21,
    name: 'haier bugly',
    address: 'https://line.linkcook.cn/refrigerator-admin-ui/#/login?redirect=%2Flog%2FFridgeErrorLog',
    imgUrl: 'https://devapi.linkcook.cn/oss_dev/production/skrd/platform/ota.png',
    parentId: 1,
    desc: '<div>账号：19031303 </div>   <div> 密码：123456</div> '
  }
  ,
  {
    id: 1,
    name: 'LDAP密码修改',
    address: 'https://fridge.linkcook.cn:3699/',
    imgUrl: '	https://fridge.linkcook.cn/main/icon/psw.png',
    parentId: 1
  }
  ,
  {
    id: 24,
    name: 'pixso',
    address: 'https://pdd.haier.net/app/recent',
    imgUrl: 'img/leishaocong.jpg',
    parentId: 1
  }
  ,
  {
    id: 9,
    name: '优家埋点查询',
    address: 'https://data.haier.net/unicorneye/#/login',
    imgUrl: '',
    parentId: 1
  }
  ,
  {
    id: 10,
    name: 'uplus-api库说明',
    address: 'http://101.200.241.211/component/uplusapi/current/',
    imgUrl: '',
    parentId: 3
  }
  ,
  {
    id: 11,
    name: '智慧家庭管理后台',
    address: 'http://fangzhencms.xcook.cn/umanager/a/login;JSESSIONID=ebc2e963f9c54942b971bc81e2991f3a',
    imgUrl: '',
    parentId: 1
  }
  ,
  {
    id: 12,
    name: 'OTA流程上报',
    address: 'http://123.206.93.45:7777/ota-report/ota',
    imgUrl: '',
    parentId: 1
  }
  ,
  {
    id: 13,
    name: '设备控制SDK',
    address: 'http://os.uhome.haier.net/doc/doc/vLP02f3CF',
    imgUrl: '',
    parentId: 3
  }
  ,
  {
    id: 14,
    name: 'git文档地址',
    address: 'http://svn.linkcook.cn:3000/',
    imgUrl: '',
    parentId: 1
  }
  ,
  {
    id: 15,
    name: 'ant design mobile',
    address: 'https://mobile.ant.design/',
    imgUrl: '',
    parentId: 3
  }
  ,
  {
    id: 16,
    name: '应用商城管理后台',
    address: 'https://enxcook.linkcook.cn/fridge-app-store-admin-ui/#/login?redirect=%2Fdashboard',
    imgUrl: '',
    parentId: 1
  }
  ,
  {
    id: 18,
    name: '西安ftp',
    address: 'ftp://10.181.246.110',
    imgUrl: '',
    parentId: 1,
    desc: '<div>地址：ftp://10.181.246.110</div>  <div>端口：21</div>   <div>账号：xaftp  </div>   <div>密码：xaftp@haier.com</div>'
  }
  ,
  {
    id: 19,
    name: '青岛ftp',
    address: 'ftp://10.180.109.54',
    imgUrl: '',
    parentId: 1,
    desc: '<div> 地址：ftp://ftp.linkcook.cn </div>  <div>账号：ftpuser </div>   <div> 密码：Haier@ftp</div> '
  }
];
