//验证输入框是否为空
$.fn.required = function(errmsg,errctn){
		var value = $(this).val();
		if(value ==""||value == null)
		{
			$(errctn).text(errmsg);
			$(this).focus();
			return false;
		}else{
			$(errctn).text(" ");
			return true;
		}
};

//验证输入框是否是整数且在最大数和最小数之间
$.fn.intRange = function(min,max,errmsg,errctn){
	var value = $(this).val();
	var trr = /^[1-9]\d*$/;//正则表达式声明
	var te= trr.test(value);
	if(te){
		var n = parseInt(value);
		if(value.length >= min &&value.length <= max){
			$(errctn).text("");
			return true;
		}else{
			$(errctn).text(errmsg);
			return false;
		}
	}else{
		$(errctn).text(errmsg);
		return false;
	}
	
};
//验证密码是否符合条件
$.fn.lenstr = function(errmsg,errctn){
	var value = $(this).val();
	if(value.length >6 && value.length <16){
		$(errctn).text("6~16个字符，区分大小写");
		return true;
	}else{
		$(errctn).text(errmsg);
		$(this).focus();
		return false;
	}
};

//验证两次输入的密码是否一致
$.fn.confirm = function(pw,errmsg,errctn){
	var vcode = $(this).val();
	if(vcode==pw){
		$(errctn).text("请再次填写密码");
		return true;
	}else{
		$(errctn).text(errmsg);
		return false;
	}
};


