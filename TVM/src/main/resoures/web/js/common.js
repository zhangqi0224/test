
//获取当前时间
function mytime() {
	var time2 = new Date().format("yyyy-MM-dd <br> hh:mm:ss");
	$('#show').html(time2);
	setTimeout(mytime, 1000)
}
Date.prototype.format = function (fmt) {
	var o = {
		"M+": this.getMonth() + 1,                 //月份 
		"d+": this.getDate(),                    //日 
		"h+": this.getHours(),                   //小时 
		"m+": this.getMinutes(),                 //分 
		"s+": this.getSeconds(),                 //秒 
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度 
		"S": this.getMilliseconds()             //毫秒 
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
// 倒计时跳转页面
var i = 130;
function onload() {
	var time = document.getElementById('time');
	i--;
	time.innerHTML = i ;
	setTimeout("onload()", 1100);
	if (i == 0) {
		window.location.href = "index.html";
		clearInterval(intervalid);
	}
}

