<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<body>
		  <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        		修改密码
                    </h4>
                </div>
                <div class="modal-body">
                    <form >
                        <div class="form-group">
                            <label for="old">旧密码</label>
                            <input type="password" class="form-control" id="old" name="old" placeholder="旧密码" required>
                        </div>
                        <div class="form-group">
                            <label for="newpwd">新密码</label>
                            <input type="password" class="form-control" id="newpwd" name="newpwd" placeholder="新密码" required>
                        </div>
                        <div class="form-group">
                            <label for="newagain">确认新密码</label>
                            <input type="password" class="form-control" id="newagain" name="newagain" placeholder="再次输入新密码" required>
                        </div>
                        <span id ="errId" style ="color:red;"></span>
                        <div class="modal-footer">
                            <input id = "Subm" type="button" class="btn btn-success" value="提交">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">关闭
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
        
	</body>
</html>