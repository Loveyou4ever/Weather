// JavaScript Document

window.onload = function start(){
	showTitle();
	showWeather();
	showTime();
	showlog();
	logout();
	getInfoForAjax()
}

function showWeather(){
	var flag = true;
	if(flag){
		var width = window.innerWidth;
		var height = window.innerHeight;
		$("#weather1").css({"right":width *0.02+"px","top":height *0.05 + "px"});
		$("#weather2").css({"right":width *0.02+"px","top":height *0.4 + "px"});
		}
	else{
		$("#in_tb").css({"height":"25%","width":"25%"});
		}
	}
	
function showTime() {
		var Mydate = new Date();
		var year = Mydate.getFullYear();
		var month = Mydate.getMonth();
		var day = Mydate.getDate();
		var hour = Mydate.getHours();
		var minute = Mydate.getMinutes();
		var second = Mydate.getSeconds();
		var week = Mydate.getDay();
		var _week = "";
		var _month = "";
		switch(week){
			case 0: _week = "Mon.";break;
			case 1:	_week = "Tues.";break;
			case 2: _week = "Wed.";break;
			case 3: _week = "Thur.";break;
			case 4: _week = "Fri.";break;
			case 5: _week = "Sat.";break;
			case 6: _week = "Sun.";break;
			}
		switch(month){
			case 0: _month = "JAN.";break;
			case 1:	_month = "FEB.";break;
			case 2: _month = "MAR.";break;
			case 3: _month= "APR.";break;
			case 4: _month = "MAY.";break;
			case 5: _month = "JUN.";break;
			case 6: _month = "JUL.";break;
			case 7: _month = "AUG.";break;
			case 8:	_month = "SEP.";break;
			case 9: _month = "OCT.";break;
			case 10: _month = "NOV.";break;
			case 11: _month = "DEC.";break;
		}
		
		hour = cheack(hour);
		minute = cheack(minute);
		second = cheack(second);
		$("#time1").text(day+"   "+_month+"   "+_week+"  "+year);
		$("#time2").text(hour+":"+minute+":"+second);
		setTimeout("showTime()",1000)
	}

function cheack(para){
	if(para<10)
		para = "0"+para;
	return para;
	}



function showTitle(){
	var width = window.innerWidth;
	var height = window.innerHeight;
	$("#title").css("left",width *0.05 + "px");
	$("#title").css("top",height *0.05 + "px");
	var time = document.getElementById("time");
	$("#time").css("left", width *0.1 + "px");
	$("#time").css("top",height *0.8 + "px");
}

// function getInForAjax(){  
//     $.ajax({
// 		url:'UI.php',
//         dataType: 'json',
// 		data:{type:"indoor"},
//         type: 'GET',
//         success: function(data){
// 				alert("succeed to refresh the data!");
//                 },
//          error: function(xhr) {
//                alert("fail to refresh the data!");
// 					}
//          })
//          .done(function(data) {
// 			   $("#in_wet").text(data[wet]+"%");
// 			   $("#in_temp").text(data[temp]+"℃");
// 			   $("#in_light").text(data[light]+"lx");
//          })
// 	setTimeout("getInForAjax()",5000);
// }  

function getInfoForAjax(){  
    $.ajax({
		url:'http://is.snssdk.com/api/news/feed/v51/?category=news_hot&refer=1',
        dataType: 'jsonp',
        type: 'GET',
        success: function(data){
        		var dataJson = data["post_content_hint"];
				console.log(dataJson);
                },
        error: function(xhr) {
               alert("fail to refresh the data!");
					}
         })
         .done(function(data) {
         	$("#in_wet").text(data["post_content_hint"]);
			   // $("#in_wet").text(data[humidity_in]+"%");
			   // $("#in_temp").text(data[temperature_in]+"℃");
			   // $("#in_light").text(data[illumination_in]+"lx");
			   // $("#out_wet").text(data[humidity_out]+"%");
			   // $("#out_temp").text(data[temperature_out]+"℃");
			   // $("#out_light").text(data[illumination_out]+"lx");
         })
	setTimeout("getInfoForAjax()",5000);
}  

function logout(){
	var i = 0;
	var content = [];
	setInterval(function(){
	$("#log").fadeOut(4000,function(){
		$("#log").text(content[i]);
		i = i + 1;
		i = i%4;
		$("#log").show(content[i]);
		})
	},1000)
}

function showlog(){
	var width = window.innerWidth;
	var height = window.innerHeight;
	console.log(width,height);
	$("#l").css({"left":width*0.4+"px","top":height*0.4+"px"})
	}