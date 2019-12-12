(function ($) {
    function submit() {
        var user={};
        user.username=$('#username').text();
        user.password=$('#password').text();
        user.usercase=$('#usercase').text();
        console.log(user);
        $.ajax({
            url:"submitUser.action",
            data:user,
            success:function (data) {
                if(data){
                    alert("提交成功");
                    location.reload();
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