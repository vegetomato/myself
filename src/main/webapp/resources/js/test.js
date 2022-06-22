console.log('뽈롱');

//즉시 실행함수
(function(){
	console.log("즉시 실행한다.");
})();

//객체 정의 
var obj = {
	"bno" : "1",
	"reply" : "안녕하세요?",
	"replyer" : "작성자"
}

console.log(obj);

console.log(obj.bno);
console.log(obj.reply);
console.log(obj.replyer);

function myObjFun(bno, reply, replyer){
	return {
		"bno" : bno,
		// String bno;
		"reply" : reply,
		// String reply;
		"replyer" : replyer,
		// String replyer;
		add : function(){
			console.log("?????????????")
			/* void add(){
				system.out.println("??????????");
			}*/
		}
	};
}

let reply = myObjFun(10,"안뇨옹","테스터");
console.log(reply);