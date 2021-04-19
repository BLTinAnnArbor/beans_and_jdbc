let cartArr = [];
let cartStr="";

function turnGreen(){
	
	this.classList.remove("unit");
	this.classList.add("unit-clicked");
	
}
function addSeat( seatId){
			
			cartArr.push(seatId);
			cartStr="";
			cartArr.forEach(function(seat){
				let seatStr = "<li>"+seat+"</li>";
				cartStr += seatStr;
			})
			var btnStr = '<button class="btn btn-primary">Add to Cart</button>';
			if (cartArr.length>= 1){
				cartStr += btnStr;
			}
			document.getElementById("cartList").innerHTML = cartStr;
			console.log("tried to add to cart list");
		
}
function removeSeat(seatId){
	var forRemoval;
	for(i=0; i<cartArr.length; i++){
		if (cartArr[i] == seatId){
			forRemoval=i;
			console.log("found seat for removal");
		}
		else{
			console.log("NO SEAT for removal");
		}
	}

	console.log("found for removal: "+forRemoval);
	cartArr.splice(forRemoval,1);
	
	cartStr="";
			cartArr.forEach(function(seat){
				let seatStr = "<li>"+seat+"</li>";
				cartStr += seatStr;
			})
			var btnStr = '<button class="btn btn-primary">Add to Cart</button>';
			if (cartArr.length>= 1){
				cartStr += btnStr;
			}
			document.getElementById("cartList").innerHTML = cartStr;
	
}
function clickSeat(){	
	var target = event.target;
	console.log("cartArr"+cartArr);
	console.log("cartStr"+cartStr);
	
	if(target.className.match("unit")){
		target.classList.add("clicked");
		target.classList.remove("unit");
		console.log("the class was clicked ");
		
		var seatId = target.getAttribute('id');
		addSeat(seatId);
	}
	else if(target.className.match("clicked")){
		console.log("this contains class 'clicked' ");
		target.classList.add("unit");
		target.classList.remove("clicked");
		
		var seatId = target.getAttribute('id');
		removeSeat(seatId);

	}
}


document.getElementById("body").addEventListener("click", clickSeat);
for(i=0; i<5; i++){
	let rowArr = ["a","b","c","d","e"];
	for(n=1; n<=14; n++){
		let rowStr = rowArr[i] + n;
		console.log(rowStr);
		var el = document.getElementById(rowStr);

	}
	
}
document.getElementById()

function printMsg(){
	var target = event.target;
	var targetId= target.getAttribute('id');
	var targetClasses = target.classList;
	console.log("you clicked: "+ targetId);
	console.log("classes: "+ targetClasses);
}