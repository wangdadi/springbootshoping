function changeVerifyCode(img) {
    /**
     * this.src='/defaultKaptcha?d='+new Date()*1
     * 不使用点击事件也可以这样   后面添加参数起到清除缓存作用
     * @type {string}
     */
    img.src="/defaultKaptcha?"+Math.floor(Math.random()*100);
}