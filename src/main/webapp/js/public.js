/**
 *
 */

    //HTTPS支持
// if(window.location.protocol!='https:')window.location.replace(window.location.href.replace('http://', 'https://'));
// document.domain = 'kownyou.com';
// if (/iPhone|Android/i.test(navigator.userAgent) && !/type=(singer|album|song)&m?id/i.test(location.hash) && !/type=(topic|toplist|taoge|mymusic)/i.test(location.hash) && !/nomobile=1/.test(location.search)) {
// 	location.href='//m.kownyou.com/';
// }

$('.js_login').on('click',function () {
	var origin = window.location.origin;
	var url = encodeURIComponent(window.location.href);
	window.open(origin+'/login.html?redirect='+url);
})
$('.js_logined').hover(function () {
    $('.popup_user').addClass('drop')
},function () {
    $('.popup_user').removeClass('drop')
})
$('.popup_user').hover(function () {
    $('.popup_user').addClass('drop')
},function () {
    $('.popup_user').removeClass('drop')
})
//解析地址栏中的参数
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

/**
 * 获取URL的path路径
 * @returns {string}
 */
function getRootPath_web() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return localhostPath;
    // return (localhostPath + projectName);
}
/**
 * 初始化switch开关
 */
function initSwitch() {
    var elem = document.querySelector('.js-switch');
    var switchery = new Switchery(elem, {
        color: '#9370db'
    });
}

/*
 * 切换Switchery开关函数
 * * switchElement Switchery对象
 * * checkedBool 选中的状态
 */
function setSwitchery(switchElement, checkedBool) {
    if ((checkedBool && !switchElement.isChecked()) || (!checkedBool && switchElement.isChecked())) {
        switchElement.setPosition(true);
        switchElement.handleOnchange(true);
    }
}

/**
 * 操作列的格式化
 * @param value 所在collumn的当前显示值
 * @param row 整个行的数据 ，对象化，可通过.获取
 * @param index 所在collumn的当前index
 * @returns {string}
 */
function actionFormatter (value, row, index) {
    return '<a class="detail" style="margin: 0 10px" ><i class="fa fa-info-circle fa-2x" title="详情"></i></a>   ' +  '<a class="mod" style="margin: 0 10px"><i class="fa fa-pencil fa-2x" title="修改"></i></a>  ' + '<a class="delete" style="margin: 0 10px"><i class="fa fa-trash-o fa-2x" title="删除"></i></a>';
}

/**
 * 将以base64的图片url数据转换为Blob
 * @param urlData
 *            用url方式表示的base64图片数据
 */
function convertBase64UrlToBlob(urlData){

    var bytes=window.atob(urlData.split(',')[1]);        //去掉url的头，并转换为byte

    //处理异常,将ascii码小于0的转换为大于0
    var ab = new ArrayBuffer(bytes.length);
    var ia = new Uint8Array(ab);
    for (var i = 0; i < bytes.length; i++) {
        ia[i] = bytes.charCodeAt(i);
    }

    return new Blob( [ab] , {type : 'image/png'});
}