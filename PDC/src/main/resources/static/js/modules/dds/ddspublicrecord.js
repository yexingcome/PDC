$(function() {
	vm.loadPlat();
	$("#jqGrid").jqGrid({
		url : baseURL + 'dds/ddspublicrecord/list',
		datatype : "json",
		colModel : [ {
			label : '源平台',
			name : 'sourceName',
			index : 'sourceName',
			width : 60
		}, {
			label : '目标平台',
			name : 'targetName',
			index : 'targetName',
			width : 60
		}, {
			label : '业务类型',
			name : 'businessType',
			index : 'business_type',
			width : 80,
			formatter : function(value, options, row) {
				if (value == 1) {
					return '<span>商品维护</span>';
				} else if (value == 2) {
					return '<span>商品删除</span>';
				}else if (value == 3) {
					return '<span>开户</span>';
				}else if (value == 4) {
					return '<span>修改用户状态</span>';
				}else if (value == 5) {
					return '<span>销户</span>';
				}else if (value == 6) {
					return '<span>维护用户商品授权</span>';
				}else if (value == 7) {
					return '<span>删除用户商品授权</span>';
				}else if (value == 8) {
					return '<span>刷新用户及授权</span>';
				}else if (value == 9) {
					return '<span>互动用户分组</span>';
				}
			}
		},{
			label : '发布状态',
			name : 'status',
			index : 'status',
			width : 80,
			formatter : function(value, options, row) {
				if (value == -1) {
					return '<span class="label-default">未发布</span>';
				} else if (value == 0) {
					return '<span class="label label-primary">发布中</span>';
				}else if (value == 1) {
					return '<span class="label label-danger">发布失败</span>';
				}else if (value == 2) {
					return '<span class="label label-success">发布成功</span>';
				}
			}
		}, {
			label : '创建时间',
			name : 'createTime',
			index : 'create_time',
			width : 90
		}, {
			label : '发布时间',
			name : 'publicTime',
			index : 'public_time',
			width : 90
		}, {
			label : '回复时间',
			name : 'replayTime',
			index : 'replay_time',
			width : 90
		}, {
			label : '回复内容',
			name : 'replayMess',
			index : 'replay_mess',
			width : 90
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

var vm = new Vue(
		{
			el : '#rrapp',
			data : {
				q : {
					status : '',
					businessType:'',
					sourcePlatId:'',
					targetPlatId:'',
					productid:'',
					keyno:'',
					userid:'',
					qCreateTimeStart : null,
					qCreateTimeEnd : null,
				},
				showList : true,
				title : null,
				sourcePlat : [],
				targetPlat : [],
				ddsPublicRecord : {},
				selstatus : [{id : '', name : '请选择状态'}, {id : '-1', name : '未发布'}, {id : '0', name : '发布中'}, {id : '1', name : '发布失败'}, {id : '2', name : '发布成功'}],
				business : [{id : '', name : '请选择业务类型'}, {id : '1', name : '商品维护'}, {id : '2', name : '商品删除'}, {id : '3', name : '开户'}, {id : '4', name : '修改用户状态'}, {id : '5', name : '销户'}, {id : '6', name : '维护用户商品授权'}, {id : '7', name : '删除用户商品授权'}, {id : '8', name : '刷新用户及授权'}, {id : '9', name : '互动用户分组'}],
			},
			methods : {
				query : function() {
					vm.reload();
				},
				empty: function () {
					vm.q = {
							status : '',
							businessType:'',
							sourcePlatId:'',
							targetPlatId:'',
							productid:'',
							keyno:'',
							userid:'',
							qCreateTimeStart : null,
							qCreateTimeEnd : null,
						}
					vm.query();
				},
				add : function() {
					vm.showList = false;
					vm.title = "新增";
					vm.ddsPublicRecord = {};
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
					var url = vm.ddsPublicRecord.id == null ? "dds/ddspublicrecord/save"
							: "dds/ddspublicrecord/update";
					$.ajax({
						type : "POST",
						url : baseURL + url,
						contentType : "application/json",
						data : JSON.stringify(vm.ddsPublicRecord),
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
				republish : function(event) {
					var ids = getSelectedRows();
					if (ids == null) {
						return;
					}

					confirm('确定要发布选中的记录？', function() {
						$.ajax({
							type : "POST",
							url : baseURL + "dds/ddspublicrecord/republish",
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
				del : function(event) {
					var ids = getSelectedRows();
					if (ids == null) {
						return;
					}

					confirm('确定要删除选中的记录？', function() {
						$.ajax({
							type : "POST",
							url : baseURL + "dds/ddspublicrecord/delete",
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
					$.get(baseURL + "dds/ddspublicrecord/info/" + id, function(
							r) {
						vm.ddsPublicRecord = r.ddsPublicRecord;
					});
				},
				loadPlat: function (){
					var url = "dds/ddsplatconfig/listAll";
					$.ajax({
						type : "GET",
						url : baseURL + url,
						contentType : "application/json",
						data : JSON.stringify(),
						success : function(result) {
							if (result.code == 0) {
								vm.sourcePlat = result.allPlat;
								vm.targetPlat = result.allPlat;
							}
						},
						dataType : "json"
					});
				},
				reload : function(event) {
					vm.showList = true;
					var page = $("#jqGrid").jqGrid('getGridParam', 'page');
					$("#jqGrid").jqGrid('setGridParam', {
						postData : {
							'status' : vm.q.status,
							'businessType':vm.q.businessType,
							'sourcePlatId':vm.q.sourcePlatId,
							'targetPlatId':vm.q.targetPlatId,
							'productid':vm.q.productid,
							'keyno':vm.q.keyno,
							'userid':vm.q.userid,
							'qCreateTimeStart' : vm.q.qCreateTimeStart,
							'qCreateTimeEnd' : vm.q.qCreateTimeEnd,
						},
						page : 1
					}).trigger("reloadGrid");
				}
			}
		});