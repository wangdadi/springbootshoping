/**
 * 从后台获取店铺分类和区域分类   验证表单必输入
 */
$(function(){
    var initUrl='/shopAdmin/getshopinitinfo';
    var registerShopUrl='/shopAdmin/registerShop';
    /**
     * 获取店铺的基本信息
     */
    //alert(initUrl);
    getShopInitInfo();
    function getShopInitInfo() {
        $.getJSON(initUrl,function (data) {
            if (data.success){
                var tempHtml='';
                var tempAreaHtml='';
                data.shopCategoryList.map(function (item,index) {
                    tempHtml+='<option data-id="'+item.shopCategoryId+'">'+item.shopCategoryName+'</option>';
                });
                data.areaList.map(function (item, index) {
                    tempAreaHtml+='<option data-id="'+item.areaId+'">'+item.areaName+'</option>';
                });
                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        });
        $('#submit').click(function () {
            var shop={};
            shop.shopName=$('#shop-name').val();
            shop.shopAddress=$('#shop-address').val();
            shop.phone=$('#shop-phone').val();
            shop.shopDesc=$('#shop-desc').val();
            shop.shopCategory={
                shopCategoryId:$('#shop-category').find('option').not(function () {
                    return !this.selected;
                }).data('id')
            };
            shop.area={
                areaId:$('#area').find('option').not(function () {
                    return !this.selected;
                }).data('id')
            };
            var shopImg=$('#shop-img')[0].files[0];
            var fromData=new FormData();
            fromData.append('shopImg',shopImg);
            fromData.append('shopStr',JSON.stringify(shop));
            var actualKaptcha=$("#j_captcha").val();
            if (actualKaptcha==""){
                $.toast('请输入验证码');
                return;
            } else {
                fromData.append('actualKaptcha',actualKaptcha);
            }
            $.ajax({
                url:registerShopUrl,
                type:'POST',
                data:fromData,
                contentType:false,
                processData:false,
                cache:false,
                success:function (data) {
                    if (data.success){
                        $.toast('注册成功');
                    }else {
                        $.toast('注册失败'+data.errMsg);
                    }
                    /**
                     * 成功或者失败刷新验证码
                     */
                    $("#captcha_img").click();
                }
            })
        })
    }
})