(function ($) {
    var user={};
    function searchUserByName() {
        user.username=$('#name').val();
        $.ajax({
            url:"findUser.action",
            type:"post",
            data:user,
            success:function (data) {
                if(data!=null){
                    console.log(data.username);
                    console.log(data.id);
                    console.log(data.college);
                }
            },
            error:function () {
                console.log("error in selectUserByName");
            }
        });
    }
    function init() {
        $('#searchUserByName').click(function () {
            searchUserByName();
        });
    }
    $(init);
})(jQuery);