$(function () {
    $("#addBtn").click(function () {
        var bType=$("#blogTypeName").val();
        if(bType==""){
            layer.msg("博客类别不能为空！");
            return;
        }
        $.ajax({
            type:'post',
            url:'/checkBType?blogType='+bType,
            success:function (data) {
                if (data==0){
                    layer.alert("博客类别已存在，请更换！");
                }
                else if (data==1){
                    $.ajax({
                        type:'post',
                        url:'/addBlogType?bTypeName='+bType,
                        success:function (row) {
                            if (row==0){
                                layer.alert("博客类别新增失败，请与管理员联系！");
                            }
                            else if (row==1){
                                layer.msg("添加成功！");
                                setTimeout("myReload()",1000);
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
                url:'/delBlogType?bTypeId='+bTypeId,
                success:function (data) {
                    if (data==0){
                        layer.alert("删除失败,请与管理员联系！");
                        return;
                    }
                    else if (data==1){
                        layer.msg("删除成功！");
                        setTimeout('myReloadTwo()',1000)
                        return;
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
    alert(bTypeId);
    var bTypeName=$("#blogTypeName").val();
    alert(bTypeName);
    if (bTypeName==""){
        layer.msg("类别名称不能为空！");
        return;
    }
    $.ajax({
        type:'post',
        url:'/checkBType?blogType='+bTypeName,
        success:function (data) {
            if (data==0){
                layer.alert("博客类别已存在，请更换！");
            }
            else if (data==1){
                $.ajax({
                    type:'post',
                    url:'/updateBlogType?bTypeId='+bTypeId+'&bTypeName='+bTypeName,
                    success:function (row) {
                        if (row==0){
                            layer.alert("博客类别修改失败，请与管理员联系！");
                        }
                        else if (row==1){
                            layer.msg("修改成功！");
                            setTimeout("myReload()",1000);
                        }
                    }
                })
            }
        }
    })
}

