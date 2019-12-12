(function ($) {
    var user={};
    function loginUser() {
        user.username=$('#usernameLogin').val();
        user.password=$('#passwordLogin').val();
        $.ajax({
            url:"login.action",
            type:"post",
            data:user,
            async:false,
            success:function (data) {
                if(data==false){
                    alert("用户或者密码错误!");
                }
                else{
                    alert("登陆成功！");
                    window.location.href="index.jsp";
                }
            },
            error:function () {
                alert("登陆失败！");
            }
        });

    }
    function signUser() {
        var password = $('#passwordSign').val();
        var repassword = $('#rePasswordSign').val();
        console.log(password);
        console.log(repassword);
        if(password != repassword)
        {
            alert("密码不一致!"+password+" "+repassword);
            return;
        }
        user.username=$('#usernameSign').val();
        user.password=$('#passwordSign').val();
        $.ajax({
            url:"sign.action",
            type:"post",
            data:user ,
            success:function (data) {
                if(data){
                    alert("注册成功");
                }
                else {
                    alert("用户名重复！注册失败！");
                }
            },
            error:function (data) {
                alert("注册失败！");
            }
        });
    }
    function init() {
        $('#login').click(function () {
            loginUser();
        });
        $('#sign').click(function () {
            signUser();
        });
    }
    $(init);
})(jQuery);