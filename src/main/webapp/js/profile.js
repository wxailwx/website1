(function ($) {
    function submit() {
        var user={};
        user.username=$('#username').val();
        user.email=$('#email').val();
        user.college=$('#college').val();
        user.password=$('#password').val();
        $.ajax({
            url:"submitUser.action",
            data:user,
            success:function (data) {
                if(data){
                    alert("提交成功");
                }
                else {
                    alert("提交失败");
                }
            },
            error:function (data) {
                console.log(data);
                alert("提交失败");
            }
        });
    }
    function init() {
        $('#submit').click(function () {
            submit();
        });
    }
    $(init());
})(jQuery);