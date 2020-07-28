var num=0;
var timer;
var oleft=document.getElementById('left');
var oright=document.getElementById('right');
var onav=document.getElementById('nav');


function gogo(){
	timer=setInterval(function(){
		num++;
		if(num==4)num=0;
		box.style.left=-1000*num+'px';

		for(var i=0;i<nav.children.length;i++){
			nav.children[i].className="";
		}
		nav.children[num].className="current";

	},1000)
}
gogo()
wrap.onmouseenter=function(){
	clearInterval(timer)
}
wrap.onmouseleave=function(){
	gogo()
}

for(var i=0;i<nav.children.length;i++){
				nav.children[i].index=i;
			nav.children[i].onclick=function(){
				var index=this.index;
				num=index;

				box.style.left=-1000*index+'px';

				for(var j=0;j<nav.children.length;j++){
					nav.children[j].className=""

				}
				this.className="current"
             } 
			}


	oright.onclick=function(){
	num++;
	if(num==4)num=0;
	box.style.right=-1000*num+'px';

	for(var i=0;i<nav.children.length;i++){
		nav.children[i].className="";
	}
	nav.children[num].className="current";
}

oleft.onclick=function(){
	num--;
	if(num==-1)num=3;
	box.style.left=-1000*num+'px';
	for(var i=0;i<nav.children.length;i++){
			nav.children[i].className="";
		}
	nav.children[num].className="current";
}

oright.onclick=function(){
	num++;
	if(num==4)num=0;
	box.style.left=-1000*num+'px';

	for(var i=0;i<nav.children.length;i++){
		nav.children[i].className="";
	}
	nav.children[num].className="current";
}
