$(function () {
    $("#addBtn").click(function () {
        var bType=$("#blogTypeName").val();
        if(bType==""){
            layer.msg("博客类别不能为空！");
            return;
        }
        $.ajax({
            type:'post',
            url:'/checkBType',
            data:{blogType:bType},
            success:function (data) {
                if (data==0){
                    layer.alert("博客类别已存在，请更换！");
                    return;
                }
                else if (data==1){
                    $.ajax({
                        type:'post',
                        url:'/addBlogType',
                        data:{bTypeName:bType},
                        success:function (row) {
                            if (row==0){
                                layer.alert("博客类别新增失败，请与管理员联系！");
                                return;
                            }
                            else if (row==1){
                                layer.msg("添加成功！",{time:500},function () {
                                    window.parent.location.reload();
                                });
                            }
                        }
                    })
                }
            }
        })
    })
})

function  del_blogtype(bTypeId) {
    layer.confirm('你确定要删除吗？',
        {btn:['确定','取消']},
        function () {
            $.ajax({
                type:'post',
                url:'/delBlogType',
                data:{bTypeId:bTypeId},
                success:function (data) {
                    if (data==0){
                        layer.alert("删除失败,请与管理员联系！");
                        return;
                    }
                    else if (data==1){
                        layer.msg("删除成功！",{time:500},function () {
                            location.reload();
                        });
                    }
                }
            })
        }
    )

}

function  openBlogupdate(bTypeId) {
    xadmin.open('编辑博客类别','/findBlogTypeById?bTypeId='+bTypeId);
}

function updateBType(bTypeId) {
    var bTypeName=$("#blogTypeName").val();
    if (bTypeName==""){
        layer.msg("类别名称不能为空！");
        return;
    }
    $.ajax({
        type:'post',
        url:'/checkBType',
        data:{blogType:bTypeName},
        success:function (data) {
            if (data==0){
                layer.alert("博客类别已存在，请更换！");
                return;
            }
            else if (data==1){
                $.ajax({
                    type:'post',
                    url:'/updateBlogType',
                    data:{bTypeId:bTypeId,bTypeName:bTypeName},
                    success:function (row) {
                        if (row==0){
                            layer.alert("博客类别修改失败，请与管理员联系！");
                            return;
                        }
                        else if (row==1){
                            layer.msg("修改成功！",{time:500},function () {
                                window.parent.location.reload();
                            });
                        }
                    }
                })
            }
        }
    })
}

