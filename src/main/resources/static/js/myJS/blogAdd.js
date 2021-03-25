$(function () {
    $("#addBlogBtn").click(function () {
        var bTitle=$("#blogTitle").val();
        var bPhoto=$("#blogPhoto").val();
        var blogtype=$("#blogtype").val();
        var blogTag=$("#blogTag").val();
        var blogflag=$("#blogflag").val();
        var blogCnt=$("#blogCnt").val();
        if (bTitle==""){
            layer.msg("博客标题不能为空！");
            return;
        }
        if (bPhoto==""){
            layer.msg("博客首图地址不能为空！");
            return;
        }
        if(blogtype==""){
            layer.msg("请选择博客类别！");
            return;
        }
        if (blogTag==""){
            layer.msg("请选择博客标签！");
            return;
        }
        if (blogflag==""){
            layer.msg("请选择博客标记！");
            return;
        }
        if (blogCnt==""){
            layer.msg("博客内容不能为空！");
            return;
        }
        $.ajax({
            type:"post",
            url:"/addBlog",
            data:{blogTitle:bTitle,blogPhoto:bPhoto,bTypeId:blogtype,}
        })
    })
})