var UUI = function () {


    $(".menu-custom ul li").find("ul").parent('li').addClass("has-submenu");
    $('.left-menu .has-submenu > a').on('click', function (e) {

        e.preventDefault();

        $(this).next('.left-menu ul').find('> li').slideToggle();

        if ($(this).parent("li").parent("ul").hasClass(".left-menu ul") && $(".left-menu ul > li > a").hasClass("nav-open")) {
            $(".left-menu ul > li > a.nav-open").next('ul').find('> ').slideToggle();
            $(".left-menu ul > li > a.nav-open").removeClass("nav-open");
        }

        $(this).toggleClass('nav-open');
    });

    $(".header-menu ul li").hover(function () {
        $(this).addClass("hover");
        $('ul:first', this).css('display', 'block');
    }, function () {
        $(this).removeClass("hover");
        $('ul:first', this).css('display', 'none');
    });


    require(['jquery.nicescroll.min'], function () {
        $(".sidebar-left-inner").niceScroll({styler: "fb", cursorcolor: "#dadada", cursorwidth: '3', cursorborderradius: '0', background: '', cursorborder: ''});

        $("html").niceScroll({styler: "fb", cursorcolor: "#dadada", cursorwidth: '6', cursorborderradius: '0', background: '', cursorborder: '', zindex: '1000'});


        $('#btn-accident-global').click(function () {
            window.location.href = '/accident';
            return false;
        });

        $('#btn-wish-global').click(function () {
            window.location.href = '/wish';
            return false;
        });

        $('#btn-groups-global').click(function () {
            window.location.href = '/groups';
            return false;
        });

        $('#btn-groups-add').click(function () {
            window.location.href = '/group';
            return false;
        });

        $(".glyphicon").click(function () {
            var $this = $(this);
            if ($this.hasClass(".glyphicon-check")) {
                $this.removeClass(".glyphicon-check");
                $this.addClass(".glyphicon-unchecked");
            }
            if ($this.hasClass(".glyphicon-unchecked")) {
                $this.removeClass(".glyphicon-unchecked");
                $this.addClass(".glyphicon-check");
            }
        });

    });


}();