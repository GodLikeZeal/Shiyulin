/**
 * 自定义轮播封装
 * Created by Zeal on 2017/11/28.
 */
(function($) {

    $.fn.slider = function(options) {

        //this指向当前的选择器


        var config = {
            index: 0,  //当前的页数
            size:4,  //每一页显示的内容大小
            auto:false,
            timer: null,
            speed: 3000,
            min: 0.3, //和css中的样式对应
            max: 1
        };

        var opts = $.extend(config, options);

        var init = function(){
            var size=opts.size;
            var leng = $('.playlist__item').length;
            var page_length =  Math.ceil(leng/size);  //总页数
            $('.mod_slide_switch').html('');
            for(var i=1;i<=page_length;i++) {
                $('.mod_slide_switch').append('<a href="javascript:;" tabindex="-1" class="js_jump slide_switch__item " ><i class="slide_switch__bg"></i><i class="icon_txt">'+i+'</i></a>')
            }
            $('.mod_slide_switch').find('a').eq(0).addClass('slide_switch__item--current');
        }

        init();

        //核心方法，把当前index的图片和icon显示，把除此之外的图片和icon隐藏
        var core = function() {
            var size=opts.size;
            var leng = $('.playlist__item').length;
            var page_length =  Math.ceil(leng/size)-1;  //总页数
            var curpage = $('.mod_slide_switch').find('.icon_txt').text().trim();
            if (opts.index > page_length) {
                opts.index = 0;
            } else if (opts.index < 0) {
                opts.index = page_length;
            }
            var index = opts.index;
            //小圆点联动
            $('.mod_slide_switch').find('a').removeClass('slide_switch__item--current');
            $('.mod_slide_switch').find('a').eq(index).addClass('slide_switch__item--current');
            //先将内容显示出来
            $('.playlist__item').hide();
            for(var i=index*size;i<(index+1)*size;i++){
                // $('.playlist__item').eq(i-4).addClass('animated fadeOutLeftBig');
                // $('.playlist__item').eq(i).addClass('animated fadeInRightBig');
                $('.playlist__item').eq(i).show();
            }


            //$(".mod_slide_switch span").eq(opts.index).addClass("active").siblings("span").removeClass("active");
            //$(".slider_img a").eq(opts.index).css("display", "block").stop().animate({ "opacity": opts.max }, 1000).siblings("a").css({ "display": "none", "opacity": opts.min });
        };
        //左边
        $(this).find(".slide_action__btn--left").bind("click", function() {
            --opts.index;
            core();
        });

        //右边
        $(this).find(".slide_action__btn--right").bind("click", function() {
            ++opts.index;
            core();
        });

        //每个icon分配事件
        $(this).find(".mod_slide_switch a").on("click", function() {
            var index = $(this).index();
            opts.index = index;
            core();
        });


        if (opts.auto) {

            //定时器

            var start = function () {
                opts.timer = setInterval(function () {
                    ++opts.index;
                    core();
                }, opts.speed);
            }


            $(this).hover(function () {
                clearInterval(opts.timer);
            }, function () {
                start();
            });


            start();
        }

    }
}(jQuery));