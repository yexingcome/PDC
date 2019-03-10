// '业务类型； 1 维护商品 2 删除商品  3 开户 4 修改用户状态 5 销户' 6 维护用户商品授权 7 删除用户商品授权 8 刷新用户及授权, 9 用户分组新增
DDSServiceType = ['业务类型', '维护商品', '删除商品 ', '开户', '修改用户状态', '销户', '维护用户商品', '删除用户商品授权', '刷新用户及授权', '用户分组新增'];
FromInterfacePros = ['平台版本', 'BOSS-BO-V1', 'BOSS-BO-V2'];

function getJsonValueAttr(value, attr, type){
	value = getJsonValueAttrDefault(value, attr, type);
	return value ? value : ''; // undefined
}
function getJsonValueAttrDefault(value, attr, type){
	if( typeof( value ) == 'string' ){
		try {
			value = JSON.parse(value);
		} catch (e) {
			return '数据错误!';
		}
	}
	if( typeof( attr ) == 'string') return value[attr];
	if(attr instanceof Array){
		for (let i = 0; i < attr.length; i++) {
			value = value[attr[i]];
		}
		return value;
	}
}

function getXmlValueAttr(value, attr, type){
	value = getXmlValueAttrDefault(value, attr, type);
	return value ? value : '';
}
function getXmlValueAttrDefault(value, attr, type){
	var reg = new RegExp(`<${attr}>([^$]*)</${attr}>`, "i");
	var r = value.match(reg);
	if(r!=null)return  unescape(r[1]); return null;
}