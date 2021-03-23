$(function () {
    $("#searchBtn").click(function () {
        var blType=$("#blTypeSelect").val();
        var blTitle=$("#blogTitle").val();
        console.log(blTitle)
        console.log(blType)
        location.href='/findBlog?blType='+blType+'&blTitle='+blTitle;
    })
})