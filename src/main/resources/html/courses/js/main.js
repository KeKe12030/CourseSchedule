var $ = mdui.$;
function changeTheme (){
    if($("body").hasClass("mdui-theme-layout-dark")){
        $("body").removeClass("mdui-theme-layout-dark");
        $("body").addClass("mdui-theme-layout-light");
    }else {
        $("body").removeClass("mdui-theme-layout-light");
        $("body").addClass("mdui-theme-layout-dark");
    }
    
}
