$(function() {
	vm.loadPlat();
	$("#jqGrid").jqGrid({
		url : baseURL + 'dds/ddsrouteconfig/list',
		datatype : "json",
		colModel : [ {
			label : 'id',
			name : 'id',
			index : 'id',
			width : 50,
			key : true
		}, {
			label : '源平台',
			name : 'sourcePlatName',
			index : 'source_plat_id',
			width : 80
		}, {
			label : '目标平台',
			name : 'targetPlatName',
			index : 'target_plat_id',
			width : 80
		}, {
			label : '源平台协议',
			name : 'soruceInterfacepro',
			index : 'soruce_interfacepro',
			width : 80
		}, {
			label : '目标平台协议',
			name : 'targetInterfacepro',
			index : 'target_interfacepro',
			width : 80
		}, {
			label : '状态',
			name : 'status',
			index : 'status',
			width : 80,
			formatter : function(value, options, row) {
				if (value == 1) {
					return '<span class="label label-success">启用</span>';
				} else if (value == 0) {
					return '<span class="label label-danger">禁用</span>';
				}
			}
		}, {
			label : '创建时间',
			name : 'createTime',
			index : 'create_time',
			width : 80
		} ],
		viewrecords : true,
		height : 385,
		rowNum : 10,
		rowList : [ 10, 30, 50 ],
		rownumbers : true,
		rownumWidth : 25,
		autowidth : true,
		multiselect : true,
		pager : "#jqGridPager",
		jsonReader : {
			root : "page.list",
			page : "page.currPage",
			total : "page.totalPage",
			records : "page.totalCount"
		},
		prmNames : {
			page : "page",
			rows : "limit",
			order : "order"
		},
		gridComplete : function() {
			// 隐藏grid底部滚动条
			$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
				"overflow-x" : "hidden"
			});
		}
	});
});

var vm = new Vue({
	el : '#rrapp',
	data : {
		showList : true,
		title : null,
		sourcePlatId : [],
		targetPlatId : [],
		ddsRouteConfig : {}
	},
	methods : {
		query : function() {
			vm.reload();
		},
		loadPlat : function() {
			var url = "dds/ddsplatconfig/listAll";
			$.ajax({
				type : "GET",
				url : baseURL + url,
				contentType : "application/json",
				data : JSON.stringify(),
				success : function(result) {
					if (result.code == 0) {
						vm.sourcePlatId = result.allPlat;
						vm.targetPlatId = result.allPlat;
					}
				},
				dataType : "json"
			});
		},
		add : function() {
			vm.showList = false;
			vm.title = "新增";
			vm.ddsRouteConfig = {};
		},
		update : function(event) {
			var id = getSelectedRow();
			if (id == null) {
				return;
			}
			vm.showList = false;
			vm.title = "修改";

			vm.getInfo(id)
		},
		saveOrUpdate : function(event) {
			var url = vm.ddsRouteConfig.id == null ? "dds/ddsrouteconfig/save"
					: "dds/ddsrouteconfig/update";
			$.ajax({
				type : "POST",
				url : baseURL + url,
				contentType : "application/json",
				data : JSON.stringify(vm.ddsRouteConfig),
				success : function(r) {
					if (r.code === 0) {
						alert('操作成功', function(index) {
							vm.reload();
						});
					} else {
						alert(r.msg);
					}
				}
			});
		},
		del : function(event) {
			var ids = getSelectedRows();
			if (ids == null) {
				return;
			}

			confirm('确定要删除选中的记录？', function() {
				$.ajax({
					type : "POST",
					url : baseURL + "dds/ddsrouteconfig/delete",
					contentType : "application/json",
					data : JSON.stringify(ids),
					success : function(r) {
						if (r.code == 0) {
							alert('操作成功', function(index) {
								$("#jqGrid").trigger("reloadGrid");
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo : function(id) {
			$.get(baseURL + "dds/ddsrouteconfig/info/" + id, function(r) {
				vm.ddsRouteConfig = r.ddsRouteConfig;
			});
		},
		reload : function(event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
				page : page
			}).trigger("reloadGrid");
		}
	}
});