td = document.getElementsByTagName("td");
tr = document.getElementsByTagName("tr");
MineNumCOLOR = ["red", "orange", "yellow", "lightgreen", "blue", "purple", "aqua", "black"];
var startime;
var interval;
var check_interval = 0; //처음에 지뢰를 선택하면 시간이 안 멈추기 때문에
var mineNum;

function sendPost(action, param) {
	var form = document.createElement('form');
	form.setAttribute('method', 'post');
	form.setAttribute('action', action);
	document.charset = "utf-8";
	
		var hiddenField = document.createElement('input');
		hiddenField.setAttribute('type', 'hidden');
		hiddenField.setAttribute('name', 'time');
		hiddenField.setAttribute('value', param);
		form.appendChild(hiddenField);
		
		var hiddenField = document.createElement('input');
		hiddenField.setAttribute('type', 'hidden');
		hiddenField.setAttribute('name', 'level');
		if(td.length == 9*9)
			hiddenField.setAttribute('value', '1');
		else if(td.length == 16*16)
			hiddenField.setAttribute('value', '2');
		else if(td.length == 30*16)
			hiddenField.setAttribute('value', '3');
		form.appendChild(hiddenField);
	
	document.body.appendChild(form);
	form.submit();
}

function setMineAtBoard(mine) {
	mineNum = mine.length;
 	for (var i = 0; i < td.length; i++) {
    	if (mine.indexOf(i) !== -1) {
      		td[i].classList.add("mine");
    	}
  	}
}

function AroundArray(idx){
	row = tr.length;
	col = td.length / tr.length;
	
	if(idx == 0) return [1, col, col + 1];
	if(idx == col - 1) return [col - 2, 2 * col - 2, 2 * col - 1];
	if(idx == col * (row - 1)) return [col * (row - 2), col * (row - 2) + 1, col * (row - 1) + 1];
	if(idx == col * row - 1) return [col * (row - 1) - 2, col * (row - 1) - 1, col * row - 2];
	if(0 < idx && idx < col - 1) return [idx - 1, idx + 1, idx + col - 1, idx + col, idx + col + 1];
	if(col * (row - 1) < idx && idx < col * row - 1) return [idx - col - 1, idx - col, idx - col + 1, idx - 1, idx + 1];
	if(idx % col == 0) return [idx - col, idx - col + 1, idx + 1, idx + col, idx + col + 1];
	if(idx % col == col - 1) return [idx - col - 1, idx - col, idx - 1, idx + col - 1, idx + col];
	return [idx - col - 1, idx - col, idx - col + 1, idx - 1, idx + 1, idx + col - 1, idx + col, idx + col + 1];
}

function tableEvent(){
	for(var i = 0; i < td.length; i++){
		tdEvent(i, AroundArray(i));
	}
}

var click_event = function(){
		clickTd(target, aroundArray);
	}
function tdEvent(target, aroundArray){
	leftmine = document.getElementById("leftmine");
	td[target].addEventListener("click", function(){
		clickTd(target, aroundArray);
		if (document.getElementById("time").name == 0 && check_interval == 0){
			time = new Date();
			startime = time.getTime();
			document.getElementById("time").name = 1;
			interval = setInterval(getTime, 1000);
		}
		var find = 0;
		for (var i = 0; i < td.length; i++) {
    		if (td[i].dataset.isOpen == "true") {
      			++find;
    		}
  		}
  		if(find == td.length - mineNum && check_interval != 1){
  			alert("====GAME SUCCESS[1]====");
  			
  			console.log("1:start");
  			var t_time = document.getElementById('time').value;
  			sendPost('ProcessTime', t_time);
  			console.log("1:finish");
  			
  			clearInterval(interval);
			check_interval = 1;
  		}
	});
	td[target].addEventListener("auxclick", function(){
		if(td[target].dataset.isOpen == "true") return;
		if(td[target].className == "flag" || td[target].className == "mine flag"){
			td[target].classList.remove("flag");
			td[target].innerHTML = "";
			leftmine.value = ++leftmine.value;
		}
		else{
			td[target].classList.add("flag");
			td[target].innerHTML = "🚩";
			leftmine.value = --leftmine.value;
		}
		if (document.getElementById("time").name == 0 && check_interval == 0){
			time = new Date();
			startime = time.getTime();
			document.getElementById("time").name = 1;
			interval = setInterval(getTime, 1000);
		}
		find = 0;
		for (var i = 0; i < td.length; i++) {
    		if (td[i].dataset.isOpen == "true") {
      			++find;
    		}
  		}
  		if(find == td.length - mineNum && check_interval != 1){
  			alert("====GAME SUCCESS[2]====");
  			
  			console.log("2:start");
  			var t_time = document.getElementById('time').value;
  			sendPost('ProcessTime', t_time);
  			console.log("2:finish");
  			
  			clearInterval(interval);
			check_interval = 1;
  		}
	});
}

function clickTd(target, aroundArray){
	if(td[target].className != "flag" && td[target].className != "mine flag"){
		var cnt = 0;
		for(var i = 0; i < aroundArray.length; i++){
			if(td[aroundArray[i]].classList.contains("mine"))
				cnt++;
		}
		if(td[target].className == "mine"){
			td[target].innerHTML = '💣';
			alert("====GAME OVER====\nNow you can check where the mines were");
			clearInterval(interval);
			check_interval = 1;
		}
		else if(cnt == 0){
			td[target].style.backgroundColor = "rgb(143, 145, 250)";
			for(var j = 0; j < aroundArray.length; j++){
				if(td[aroundArray[j]].dataset.isOpen != "true"){
					td[aroundArray[j]].dataset.isOpen = "true";
					clickTd(aroundArray[j], AroundArray(aroundArray[j]));
				}
			}
			if(aroundArray.length == 0){
				if(td[target].dataset.isOpen != "true"){
					td[target].dataset.isOpen = "true";
				}
			}
			td[target].dataset.isOpen = "true";
		}
		else {
			td[target].dataset.isOpen = "true";
			td[target].style.color = MineNumCOLOR[cnt - 1];
			td[target].innerHTML = cnt;
		}
	}
}

function getTime(){
	time = new Date();
	current = time.getTime();
	timetag = document.getElementById("time");
	timetag.value = parseInt((current - startime) / 1000);
}


