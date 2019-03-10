$(function() {
	laydate({
		elem : '#_id_qCreateTimeStart',
		format : 'YYYY-MM-DD hh:mm:ss',
		// min : laydate.now(),
		// max : '2099-06-16 23:59:59',
		istime : true,
		istoday : false,
		choose : syncQCreateTime,
	});
	laydate({
		elem : '#_id_qCreateTimeEnd',
		format : 'YYYY-MM-DD hh:mm:ss',
		istime : true,
		istoday : false,
		choose : syncQCreateTime
	});
	
	$(document).on("click","#laydate_clear", function(){
		syncQCreateTime();
	});
});

function syncQCreateTime(dt){
	vm.q.qCreateTimeStart = document.getElementById('_id_qCreateTimeStart').value;
	vm.q.qCreateTimeEnd = document.getElementById('_id_qCreateTimeEnd').value;
	console.log(dt)
	if(vm.q.qCreateTimeStart != null && vm.q.qCreateTimeStart !='' && vm.q.qCreateTimeEnd != null && vm.q.qCreateTimeEnd !='' ){
		if(vm.q.qCreateTimeStart > vm.q.qCreateTimeEnd){
			alert("开始时间不能小于结束时间！")
			if(dt == vm.q.qCreateTimeStart){
				vm.q.qCreateTimeStart = '';
			}
			if(dt == vm.q.qCreateTimeEnd){
				vm.q.qCreateTimeEnd = '';
			}
		}
	}
}
