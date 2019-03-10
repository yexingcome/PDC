$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'dds/ddsarea/list',
        datatype: "json",
        colModel: [			
//			{ label: 'id', name: 'id', index: 'ID', width: 50, key: true },
			{ label: '名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '开始区域码', name: 'startArea', index: 'start_area', width: 80 }, 			
			{ label: '结束区域码', name: 'endArea', index: 'end_area', width: 80 }, 			
//			{ label: '', name: 'createTime', index: 'create_time', width: 80 }, 			
//			{ label: '', name: 'modifyTime', index: 'modify_time', width: 80 }, 			
//			{ label: '父级区域ID', name: 'parentId', index: 'parent_id', width: 80 }, 			
//			{ label: '', name: 'idsFullPath', index: 'ids_full_path', width: 80 }, 			
			{ label: '业务区标识', name: 'branchNo', index: 'branch_no', width: 80 }, 			
			{ label: '业务区名称', name: 'branchName', index: 'branch_name', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			areaCode : null,
		},
		showList: true,
		title: null,
		ddsArea: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		empty: function () {
			vm.q = {
					areaCode : null,
				}
			vm.query();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.ddsArea = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.ddsArea.id == null ? "dds/ddsarea/save" : "dds/ddsarea/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.ddsArea),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "dds/ddsarea/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "dds/ddsarea/info/"+id, function(r){
                vm.ddsArea = r.ddsArea;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData: vm.q,
                page:page
            }).trigger("reloadGrid");
		}
	}
});