$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'dds/ddsauthservice/list',
        datatype: "json",
        colModel: [			
 			{
			label : 'id',
			name : 'id',
			index : 'id',
			width : 50,
			key : true,
			hidden : true
		},
	 		 {
				label : 'userId',
				name : 'jsonvalue',
				width : 80,
				sortable : false, 
				formatter : function(value, options, row) {
					return (row.frominterfacepro == "BOSS-BO-V2" ? getJsonValueAttr( value, 'userId') : getXmlValueAttr(value, 'userId'));
				}
			}, 
			{
				label : 'keyNO',
				name : 'jsonvalue',
				width : 80,
				sortable : false,
				formatter : function(value, options, row) {
					return (row.frominterfacepro == "BOSS-BO-V2" ? getJsonValueAttr( value, 'keyNO') : getXmlValueAttr(value, 'keyNO'));
				}
			}, 		
			{
			label : '业务类型',
			name : 'serviceType',
			index : 'service_type',
			width : 40,
			formatter : function(value, options, row) {
				return DDSServiceType[value];
			}
		}, 	{
			label : '平台版本',
			name : 'frominterfacepro',
			index : 'frominterfacepro',
			width : 40
		},		
			{
			label : '创建时间',
			name : 'createTime',
			index : 'create_time',
			width : 40
		}			
        ],
		viewrecords: true,
        height: 500,
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
			qJsonvalue : null,
			qServiceType: '',
			qCreateTimeStart : null,
			qCreateTimeEnd : null,
				
		},
		showList: true,
		title: null,
		ddsAuthService: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		empty: function () {
			vm.q = {
					qJsonvalue : null,
					qServiceType: '',
					qCreateTimeStart : null,
					qCreateTimeEnd : null,
				}
			vm.query();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.ddsAuthService = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "详情";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.ddsAuthService.id == null ? "dds/ddsauthservice/save" : "dds/ddsauthservice/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.ddsAuthService),
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
				    url: baseURL + "dds/ddsauthservice/delete",
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
			$.get(baseURL + "dds/ddsauthservice/info/"+id, function(r){
                vm.ddsAuthService = r.ddsAuthService;
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
	},
	filters : {
		showType : function(value) {
			return DDSServiceType[value];
		}
	}
});