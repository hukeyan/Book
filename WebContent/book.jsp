<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="js/jquery-easyui-1.4.3/themes/icon.css"type="text/css"></link>
<link rel="stylesheet" href="js/jquery-easyui-1.4.3/themes/default/easyui.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	chazhao();
	$("#booktype").combobox({
		url: 'selectbooktype',
		method: 'post',
		valueField:'c_Id',    
	    textField:'c_Name'  
	})
})
function chazhao() {
		var booktype=$("#booktype").combobox("getValue");
		if(booktype=="请选择"){
			booktype="";
		}
	$("#dg").datagrid({
		url: 'selectbook',
		method: 'post',
		pagination:true,
		nowrap:false,
		singleSelect:true,
		queryParams:{
			c_Id:booktype,
			b_Name:$("#b_Name").textbox('getValue'),
			KS_price:$("#kaishi").textbox('getValue'),
			JS_price:$("#jieshu").textbox('getValue'),
		}
	});
	$("#frm").form("reset");
}

//操作列
function formatterOPUser(value, row, index) {
	return "<a href='javascript:void(0)' style='cursor: pointer;' onclick='updateInfo(" + index + ")'>编辑</a> <a href='javascript:void(0)' style='cursor: pointer;' onclick='deleteInfo(" + index + ")'>删除</a>";
}
//书籍分类
function formatterClassName(value, row, index) {
	return row.booktype.c_Name;
}
//打开修改框
function updateInfo(index){
	$("#booktypes").combobox({
		url: 'selectbooktype',
		method: 'post',
		valueField:'c_Id',    
	    textField:'c_Name'  
	})
	var data = $("#dg").datagrid("getData"); 
    var row = data.rows[index];
    $("#update-fm").form("load",row);
  	$("#booktypes").combobox("setValue",row.booktype.c_Id);
    $("#update").window("open");  
}
//提交修改信息
function  subimtUpdatefm() {
	var flag=$("#update-fm").form("validate");
	var b_Name=$("#b_Names").textbox('getValue');
	var b_Price=$("#b_Prices").textbox('getValue');
	var b_Author=$("#b_Authors").textbox('getValue');
	var b_Introduce=$("#b_Introduces").textbox('getValue');
	var c_id=$("#booktypes").combobox('getValue');
	var data = $("#dg").datagrid("getSelected");
	if(flag){
		$.post("updatebook",{
			B_Id:data.b_Id,
			B_Name:b_Name,
			B_Price:b_Price,
			B_Author:b_Author,
			B_Introduce:b_Introduce,
			C_Id:c_id
		},function(i){
			if(i>0){
				$.messager.alert("提示","修改成功！");
				$("#update").window("close");
				$("#dg").datagrid("reload");
			}else{
				$.messager.alert("提示","修改失败！");
			}
		},"json")
	}
}
//打开添加框
function addInfo(){
	$("#add-fm").form("clear");
	var booktype=$("#booktypess").combobox("getValue");
	if(booktype=="请选择"){
		booktype="";
	}
	$("#booktypess").combobox({
		url: 'selectbooktype',
		method: 'post',
		valueField:'c_Id',    
	    textField:'c_Name'  
	})
  	$("#add").window("open");
}
//提交添加信息
function subimtAddfm() {
	var flag=$("#add-fm").form("validate");
	var b_Name=$("#b_Namess").textbox('getValue');
	var b_Price=$("#b_Pricess").textbox('getValue');
	var b_Author=$("#b_Authorss").textbox('getValue');
	var b_Introduce=$("#b_Introducess").textbox('getValue');
	var c_id=$("#booktypess").combobox('getValue');
	if(flag){
		$.post("insertbook",{
			B_Name:b_Name,
			B_Price:b_Price,
			B_Author:b_Author,
			B_Introduce:b_Introduce,
			C_Id:c_id
		},function(i){
			if(i>0){
				$.messager.alert("提示","添加成功！");
				$("#add").window("close");
				$("#dg").datagrid("reload");
			}else{
				$.messager.alert("提示","添加失败！");
			}
		},"json")
	}
}
//删除信息
function deleteInfo(index) {
	var data = $("#dg").datagrid("getData"); 
    var row = data.rows[index]; 
	$.messager.confirm('确认', '您想要删除:'+row.b_Name+':该书籍吗？', function(r){
		if (r){
			$.post("delbook",{
				B_Id:row.b_Id,
			},function(i){
				if(i>0){
					$.messager.alert("提示","删除成功！");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("提示","删除失败！");
				}
			},"json")
		}
	});
}
//取消按钮
function exitfm(){
	$("#add").window("close");
	 $("#update").window("close");  
}
</script>
</head>
<body>
<!--数据表格-->
	<table class="easyui-datagrid" id="dg" title="书籍列表"data-options="toolbar:'#usertb',pageSize:10">
		<thead>
			<tr>
				<th data-options="field:'ss',checkbox:true"></th>
				<th data-options="field:'b_Id',width:100">书籍号</th>
				<th data-options="field:'b_Name',width:100">书籍名</th>
				<th data-options="field:'b_Price',width:100">书籍价格</th>
				<th data-options="field:'b_Author',width:100">书籍作者</th>
				<th data-options="field:'b_Introduce',width:200">书籍介绍</th>
				<th data-options="field:'booktype',width:100,formatter:formatterClassName">书籍分类</th>
				<th data-options="field:'setUserAction',width:120,align:'center',formatter:formatterOPUser">操作</th>
			</tr>
		</thead>
	</table>
	<!--多条件工具条-->
	<div id="usertb" style="padding:5px; height:auto">
		<div style="margin-bottom:5px">
		<form class="easyui-from" id="frm">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addInfo()">添加书籍</a>
			书籍名: <input class="easyui-textbox" id="b_Name" style="width:80px">
			书籍价格: <input class="easyui-textbox" id="kaishi"   />-<input class="easyui-textbox" id="jieshu"/>
			书籍分类: <select id="booktype" class="easyui-combobox"  style="width:120px;">
						<option >请选择</option>
					</select> 
			<a href="javascript:void(0)" class="easyui-linkbutton"iconCls="icon-search" onclick="chazhao()">查找</a>
		</form>
		</div>
	</div>
	<!--编辑信息-->
	<div id="update" class="easyui-window" title="编辑书籍" style="width:300px;height:300px" data-options="iconCls:'icon-save',modal:true,closed:true">
			<form id="update-fm" class="easyui-form" style="text-align: center;">
				书籍名称：<input type="text" class="easyui-textbox" id="b_Names" name="b_Name" style="width:120px" ><br /> 
				书籍价格：<input type="text" class="easyui-textbox" id="b_Prices" name="b_Price" style="width:120px" ><br />  
				书籍作者：<input type="text" class="easyui-textbox" id="b_Authors" name="b_Author" style="width:120px"><br />
				书籍介绍：<input type="text" class="easyui-textbox" id="b_Introduces" name="b_Introduce" style="width:120px"><br />
				书籍类别：<select id="booktypes" class="easyui-combobox" style="width:120px;">
				 </select><br/>
				&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="subimtUpdatefm()">提交</a>
				&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="exitfm()">取消</a>
			</form>
	</div>
	<!--添加信息-->
	<div id="add" class="easyui-window" title="添加书籍" style="width:300px;height:300px" data-options="iconCls:'icon-save',modal:true,closed:true">
			<form id="add-fm" class="easyui-form" style="text-align: center;">
				书籍名称：<input type="text" class="easyui-textbox" id="b_Namess" name="b_Name" style="width:120px" ><br /> 
				书籍价格：<input type="text" class="easyui-textbox" id="b_Pricess" name="b_Price" style="width:120px" ><br />  
				书籍作者：<input type="text" class="easyui-textbox" id="b_Authorss" name="b_Author" style="width:120px"><br />
				书籍介绍：<input type="text" class="easyui-textbox" id="b_Introducess" name="b_Introduce" style="width:120px"><br />
				书籍类别：<select id="booktypess" class="easyui-combobox" style="width:120px;">
							<option >请选择</option>
				 </select><br/>
				&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="subimtAddfm()">提交</a>
				&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="exitfm()">取消</a>
			</form>
	</div>
</body>
</html>