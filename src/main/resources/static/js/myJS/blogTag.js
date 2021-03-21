$(function () {
    $("#addBtn").click(function () {
        var blogTag=$("#blogTagName").val();
        if (blogTag==""){
            layer.msg("博客标签不能为空！");
            return;
        }
        $.ajax({
            type:"post",
            url:"/checkBlTag",
            data:{blogTagName:blogTag},
            success:function (data) {
                if (data==1){
                    $.ajax({
                        type:"post",
                        url:"/addBlTag",
                        data:{bTagName:blogTag},
                        success:function (data) {
                            if (data==0){
                                layer.alert("新增失败，请与管理员联系！");
                                return;
                            }
                            else if (data==1){
                                layer.msg("新增成功了哦！",{time:500},function () {
                                    window.parent.location.reload();
                                });
                            }
                        }
                    })
                }
                else  if (data==0){
                    layer.alert("博客标签已存在，请更换！");
                    return;
                }
            }
        })
    })
})

function del_blogtag(bTagId) {
    layer.confirm("你确定要删除吗？",{btn:["确定","取消"]},function () {
        $.ajax({
            type:"post",
            url:"/delBlogTag",
            data:{blogTagId:bTagId},
            success:function (data) {
               if (data==1){
                   layer.msg("删除成功！",{time:500},function () {
                       window.parent.location.reload();
                   })
               }
               else if (data==0) {
                   layer.alert("删除失败，请与管理员联系！");
                   return;
               }
            }
        })
    })
}

function openTagupdate(bTagId) {
    xadmin.open("编辑博客标签","/findBlTagById?bTagId="+bTagId);
}

function updateBTag(bTagId) {
    var bTagName=$("#blogTagName").val();
    if (bTagName==""){
        layer.msg("标签名称不能为空！");
        return;
    }
    $.ajax({
        type:"post",
        url:"/checkBlTag",
        data:{blogTagName:bTagName},
        success:function (data) {
            if (data==0){
                layer.alert("标签名称已存在,请更换！");
                return;
            }
            else  if (data==1){
                $.ajax({
                    type:"post",
                    url:"/updateBlTag",
                    data:{bTagName:bTagName,bTagId:bTagId},
                    success:function (data) {
                        if (data==0){
                            layer.alert("修改失败，请与管理员联系！");
                            return;
                        }
                        else if (data==1){
                            layer.msg("修改成功！",{time:500},function () {
                                window.parent.location.reload();
                            })
                        }
                    }
                })
            }
        }
    })
}