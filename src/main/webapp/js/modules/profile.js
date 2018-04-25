define("js/v4/profile.js", function (l) {
    function a(i) {
        return U.trim(i).entityReplace().myEncode()
    }

    function t(i) {
        var l = parseInt(i / 60, 10), a = i % 60;
        return (10 > l ? "0" + l : l) + ":" + (10 > a ? "0" + a : a)
    }

    function s(i, l) {
        if (!i)return !!l && l(null), void 0;
        var a = "//c.y.qq.com/rsc/fcgi-bin/fcg_get_qqhead_image.fcg?jump=0&uinlist=" + i + "&rnd=" + Math.random();
        T.jsonp({
            url: a, charset: "utf-8", success: function (i) {
                var a = [];
                U.each(i.data.urllist, function (i, l) {
                    a.push({uin: l.uin, url: l.url.replace("http://", window.location.protocol + "//")})
                }), i.data.urllist = a, !!l && l(i)
            }, error: function () {
                !!l && l(null)
            }
        })
    }

    function n(i) {
        i && i.length && (i.length > 20 && (i.length = 20), s(i.join(","), function (l) {
            var a = U(".need_avatar");
            l && l.data && l.data.urllist.length > 0 ? U.each(l.data.urllist, function (i, l) {
                a[i] && (a[i].src = l.url, U(a[i]).removeClass("need_avatar"))
            }) : U.each(i, function (i, l) {
                a[i].src = N.user.getQzoneUserImage(l, 100)
            })
        }))
    }

    function e(i) {
        var t = function (i) {
            {
                var l, a = "";
                Array.prototype.join
            }
            a += "";
            var i = i.data;
            return a += '\r\n	<div class="section_inner">\r\n		<div class="profile__cover_link">\r\n			<img src="' + (null == (l = i.avatarUrl.replace("http://", window.location.protocol + "//")) ? "" : _.escape(l)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/person_300.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (l = i.name) ? "" : _.escape(l)) + '" class="profile__cover" id="profileHead">\r\n		</div>\r\n            <h1 class="profile__tit">\r\n                <span class="profile__name js_emopr">' + (null == (l = i.name) ? "" : _.escape(l)) + "</span>" + (null == (l = i.vipstr) ? "" : l) + '\r\n            </h1>\r\n            <ul class="mod_user_statistic">\r\n                <li class="user_statistic__item">\r\n                    <a href="javascript:;" class="js_tab" data-tab="focus_singer" data-stat="y_new.profile.header.focus_click"><strong class="user_statistic__number js_num_follow"></strong><span class="user_statistic__tit">关注</span></a>\r\n                </li>\r\n                <li class="user_statistic__item user_statistic__item--last">\r\n                    <a href="javascript:;" class="js_tab" data-tab="fans" data-stat="y_new.profile.header.fans_click"><strong class="user_statistic__number js_num_fans"></strong><span class="user_statistic__tit">粉丝</span></a>\r\n                </li>\r\n            </ul>\r\n	    ', i.isStateHost ? (a += "\r\n		    ", a += i.islock ? '\r\n		    <button class="btn_unlock sprite js_btn_lock" title="主页非公开" data-status="' + (null == (l = i.islock) ? "" : l) + '"><span class="icon_txt">主页非公开</span></button>\r\n		    ' : '\r\n		    <button class="btn_lock sprite js_btn_lock" title="主页已公开" data-status="' + (null == (l = i.islock) ? "" : l) + '"><span class="icon_txt">主页已公开</span></button>\r\n		    ', a += "\r\n	    ") : (a += "\r\n		    ", a += i.followflag ? '\r\n		    <button class="mod_btn mod_profile__btn_focus js_follow_user" data-id="' + (null == (l = i.encrypt_uin || i.uin) ? "" : l) + '" data-follow="' + (null == (l = i.followflag) ? "" : l) + '"><i class="mod_btn__icon_yes"></i>已关注</button>\r\n		    ' : '\r\n		    <button class="mod_btn mod_profile__btn_focus js_follow_user" data-id="' + (null == (l = i.encrypt_uin || i.uin) ? "" : l) + '" data-follow="' + (null == (l = i.followflag) ? "" : l) + '"><i class="mod_btn__icon_new"></i>关注</button>\r\n		    ', a += "\r\n	    "), a += "\r\n        </div>"
        }, s = location.protocol + "//c.y.qq.com/rsc/fcgi-bin/fcg_get_profile_homepage.fcg";
        T.jsonp({
            url: s,
            data: {cid: 205360838, ct: 20, userid: L, reqfrom: 1, reqtype: 0},
            charset: "utf-8",
            success: function (s) {
                function n() {
                    var i = U(".js_emopr");
                    U.each(i, function (i, l) {
                        var a = U(l).html();
                        U(l).html(emopr(a.unescapeHTML())), U(l).removeClass("js_emopr")
                    })
                }

                if (0 != s.code)return N.popup.show(s.msg, 3e3, 1), !1;
                s = s.data;
                for (var e = null, r = null, _ = s.mymusic.length, o = 0; _ > o; o++) {
                    var c = s.mymusic[o].type, d = s.mymusic[o];
                    switch (c) {
                        case 1:
                            e = d;
                            break;
                        case 3:
                            r = d;
                            break;
                        case 2:
                    }
                }
                if (num_map = {
                        fansnum: s.creator.nums.fansnum,
                        follownum: s.creator.nums.follownum,
                        favalbumnum: e ? e.num1 : 0,
                        favdirnum: e ? e.num2 : 0,
                        favsongnum: e ? e.num0 : 0,
                        selfdirnum: s.mydiss.num
                    }, !r || !H)if (H) {
                    var u = A.getUin(),
                        m = "//c.y.qq.com/shop/fcgi-bin/fcg_get_order?from=1&cmd=sales_album&type=1&guest_uin=&callback=callback_2&start=0&num=1&uin=" + u + "&" + (new Date).getTime();
                    N.jQueryAjax.jsonp({
                        url: m,
                        data: {},
                        jsonpCallback: "callback_2",
                        charset: "utf-8",
                        success: function (i) {
                            return 1e3 == i.code ? (U("#buy_tab").hide(), void 0) : (0 == i.data.total && 0 == i.data.peri_total && 0 == i.data.song_total && (U("#buy_tab").hide(), location.href = "https://y.qq.com/portal/profile.html#sub=song&tab=like&"), void 0)
                        },
                        error: function () {
                        }
                    })
                } else U("#buy_tab").hide();
                var p = "";
                if (s.creator.lvinfo)for (var g = 0, h = s.creator.lvinfo.length; h > g; g++) {
                    var d = s.creator.lvinfo[g], f = d.iconurl.replace(/\/pc\//gi, "/mac/").replace(".png", "@2x.png"),
                        v = -1 != f.indexOf("/mac/n"), y = location.protocol + "//y.qq.com/portal/vipportal/index.html";
                    -1 != f.indexOf("xvip") || -1 != f.indexOf("xz") ? y = location.protocol + "//xing.qq.com/" : -1 != f.indexOf("sui") && (y = location.protocol + "//y.qq.com/vip/fufeibao/index.html"), p += '<a href="' + y + '" rel="noopener nofollow" target="_blank"><img src="' + f + '" class="lv_icon' + (v ? " lv_icon_ns" : "") + '"/></a>'
                }
                var b = {
                    avatarUrl: s.creator.headpic,
                    name: a(s.creator.nick),
                    vipstr: p,
                    isStateHost: H,
                    islock: s.creator.islock,
                    uin: s.creator.uin,
                    followflag: s.creator.isfollow
                };
                return W = e ? e.id : 0, U("#before_page").remove(), U("#cgi_none_box").hide(), U(".js_user_data").html(t({data: b})).show(), s.creator.ifpic && U("#profileHead").after('<img src="' + s.creator.ifpic + '?max_age=2592000" class="profile__icon">'), l.load("//y.gtimg.cn/music/portal/emoticons/emoji.js?max_age=2592000", function () {
                    n()
                }), H || (U("#create_tab").text("创建的歌单"), U("#buy_tab").text("数字专辑")), s.creator.islock && !H ? (U("#nopub_tab").show(), U("#locked").html('<div class="main"><div class="lock_txt"><i class="lock_txt__symbol"></i><p>页面主人设置了仅对自己可见</p></div></div>').show(), !1) : (U("#index_tab").show(), U("div.main").show(), V.like_song = e ? e.num0 : 0, V.like_playlist = e ? e.num2 : 0, V.like_album = e ? e.num1 : 0, V.focus = s.creator.nums.follownum, V.fans = s.creator.nums.fansnum, U('.mod_tab__item[data-tab="like_song"]', U("#like_box")).text("歌曲 " + V.like_song), U('.mod_tab__item[data-tab="like_playlist"]', U("#like_box")).text("歌单 " + V.like_playlist), U('.mod_tab__item[data-tab="like_album"]', U("#like_box")).text("专辑 " + V.like_album), U(".js_user_data .js_num_follow").text(s.creator.nums.follownum), U(".js_user_data .js_num_fans").text(s.creator.nums.fansnum), "mv" != N.util.getParameterNew("sub") && T.jsonp({
                    url: "//c.y.qq.com/mv/fcgi-bin/fcg_mv_getlistinfo.fcg?utf8=1&uin=" + L + "&rnd=" + Math.random(),
                    charset: "utf-8",
                    success: function (i) {
                        i && 0 == i.code && (V.like_mv = parseInt(i.num), U('.mod_tab__item[data-tab="like_mv"]', U("#like_box")).text("MV " + i.num))
                    },
                    error: function () {
                    }
                }), i && i(), void 0)
            },
            error: function () {
                U("#before_page").remove(), U("#cgi_none_box").show()
            }
        })
    }

    function r(i, l, a) {
        setTimeout(function () {
            var s = N.user.getUin();
            return 10001 > s ? (N.widget.user.openLogin(), void 0) : (F && F.type == i ? a && a(F.data[l - 1], F.count, F.pagesize) : "song" == i ? T.jsonp({
                url: "//c.y.qq.com/qzone/fcg-bin/fcg_ucc_getcdinfo_byids_cp.fcg?type=1&json=1&utf8=1&onlysong=1&nosign=1&song_begin=" + (l - 1) * Q.like_song.per_page + "&song_num=" + Q.like_song.per_page + (H ? "&ctx=1" : "") + "&disstid=" + W + "&_=" + +new Date,
                charset: "utf-8",
                success: function (i) {
                    i && 0 == i.code && i.songlist ? (ownerUin = i.uin, U.each(i.songlist, function (i, l) {
                        var a = i + 1;
                        l.playTime = t(l.interval), l.songmid || (l.songtype = 11), l.disstid = W, l.index = 10 > a ? "0" + a : a;
                        var s = [];
                        U.each(l.singer, function (i, l) {
                            s.push(l.name)
                        })
                    }), a && a(i, i.total_song_num, Q.like_song.per_page)) : a(null)
                },
                error: function () {
                }
            }) : "playlist" == i || "album" == i ? T.jsonp({
                url: location.protocol + "//c.y.qq.com/fav/fcgi-bin/fcg_get_profile_order_asset.fcg",
                data: {
                    ct: 20,
                    cid: 205360956,
                    userid: L,
                    reqtype: "playlist" == i ? 3 : 2,
                    sin: (l - 1) * Q["like_" + i].per_page,
                    ein: l * Q["like_" + i].per_page
                },
                charset: "utf-8",
                success: function (t) {
                    if (t && 0 == t.code) {
                        var t = t.data, s = t["album" == i ? "albumlist" : "cdlist"];
                        s && 0 == s.length && l > 1 ? r(i, l - 1, a) : a && a(t, "playlist" == i ? t.totaldiss : t.totalalbum, Q["like_" + i].per_page, l)
                    } else I.show("获取数据失败！当前网络繁忙，请稍后重试。", 3e3, 1)
                },
                error: function () {
                    I.show("获取数据失败！当前网络繁忙，请稍后重试。", 3e3, 1)
                }
            }) : "mv" == i && T.jsonp({
                    url: "//c.y.qq.com/mv/fcgi-bin/fcg_mv_getlistinfo.fcg?utf8=1&uin=" + L + "&rnd=" + Math.random(),
                    charset: "utf-8",
                    success: function (t) {
                        if (t && 0 == t.code) {
                            for (V.like_mv = parseInt(t.num), U('.mod_tab__item[data-tab="like_mv"]', U("#like_box")).text("MV " + t.num), F = {
                                type: i,
                                data: [],
                                count: t.mvlist.length,
                                pagesize: X
                            }; t.mvlist.length;)F.data.push({mvlist: t.mvlist.splice(0, X), total_num: t.num});
                            t.mvlist.length <= 0 && F.data.push({mvlist: [], total_num: 0});
                            for (var s = l; s > 0 && !F.data[s - 1]; s--);
                            l = s, a && a(F.data[l - 1] || F.data[0], F.count, F.pagesize, l)
                        } else!t || -1e3 != t.code && 1e3 != t.code ? I.show("获取数据失败！当前网络繁忙，请稍后重试。", 3e3, 1) : N.widget.user.openLogin()
                    },
                    error: function () {
                        I.show("获取数据失败！当前网络繁忙，请稍后重试。", 3e3, 1)
                    }
                }), void 0)
        }, 0)
    }

    function o(i, l) {
        i = i in E ? i : "like", l = l || E[i]["default"] || "other", N.util.updateHash({tab: i, sub: l})
    }

    function c(a, t, s, n) {
        function e() {
            var i = "#" + t + ("" == s ? "" : "_" + s) + "_box";
            setTimeout(function () {
                r.total_num > r.per_page ? l.async("js/common/music/pager.js", function () {
                    U(".js_pager", U(i)).pager({
                        container: i,
                        total: r.total_num,
                        per: r.per_page,
                        cur: r.cur_page,
                        index: 3,
                        ns: r,
                        callback: function (i) {
                            r.cur_page = i, u(t, s, i), document.documentElement.scrollTop = document.body.scrollTop = 415
                        }
                    })
                }) : U(".js_pager", U(i)).hide()
            }, 0)
        }

        s = s || "";
        var r = Q[t + (s ? "_" + s : "")];
        if ("buy" == t) {
            if ("album" == s) {
                if (!a.data.albumlist || a.data.albumlist.length <= 0)return U("#buy_album_box").html(B({})), void 0;
                r.total_num = a.data.total;
                var o = function (l) {
                    {
                        var a, t = "";
                        Array.prototype.join
                    }
                    t += '<div class="mod_playlist js_list">\r\n    <ul class="playlist__header">\r\n        <li class="playlist__header_name">专辑</li>\r\n        <li class="playlist__header_author">歌手</li>\r\n        <li class="playlist__header_other">发行时间</li>\r\n    </ul>\r\n    <ul class="playlist__list">\r\n        ';
                    var s = l.list;
                    for (i = 0; i < s.length; i++) {
                        var n = s[i];
                        t += '\r\n        <li class="playlist__item" data-albummid="' + (null == (a = n.albummid) ? "" : a) + '" onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n            <div class="playlist__item_box">\r\n                <div class="playlist__cover mod_cover">\r\n                    <a href="' + (null == (a = N.util.getAlbumUrl(n)) ? "" : a) + '" class="js_album" data-albummid="' + (null == (a = n.albummid) ? "" : a) + '">\r\n                        <img src="' + (null == (a = N.util.getAlbumPic({
                                mid: n.albummid,
                                type: 300
                            })) ? "" : _.escape(a)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/album_300.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = n.album_name) ? "" : _.escape(a)) + '" class="playlist__pic"/>\r\n                        <i class="mod_cover__icon_play js_play" data-stat="y_new.profile.digital_album.play"></i>\r\n                    </a>\r\n                </div>\r\n                <h4 class="playlist__title">\r\n                    <span class="playlist__title_txt">\r\n                        <a href="' + (null == (a = N.util.getAlbumUrl(n)) ? "" : a) + '" class="js_album" data-albummid="' + (null == (a = n.albummid) ? "" : a) + '" title="' + (null == (a = n.album_name) ? "" : _.escape(a)) + '">\r\n                            ' + (null == (a = n.album_name) ? "" : _.escape(a)) + '\r\n                        </a>\r\n                    </span>\r\n                </h4>\r\n                <div class="playlist__author">\r\n                    <a href="' + (null == (a = N.util.getSingerUrl(n)) ? "" : a) + '" class="js_singer" data-singermid="' + (null == (a = n.singermid) ? "" : a) + '" title="' + (null == (a = n.singer) ? "" : _.escape(a)) + '">' + (null == (a = n.singer) ? "" : _.escape(a)) + '</a>\r\n                </div>\r\n                <div class="playlist__other">' + (null == (a = N.util.toYMDString(1e3 * n.time)) ? "" : a) + '</div>\r\n                <a href="javascript:;" class="btn_operate_menu js_albumlist_more" data-type="2" data-mid="' + (null == (a = n.albummid) ? "" : a) + '" data-stat="y_new.profile.digital_album.more">\r\n                    <span class="icon_txt">更多</span>\r\n                </a>\r\n            </div>\r\n        </li>\r\n        '
                    }
                    return t += "\r\n    </ul>\r\n</div>"
                };
                l.async("js/common/html/albumlist.js", function (i) {
                    r.init = !0, i.init({
                        container: U("#buy_album_box"),
                        specilData: a.data.albumlist,
                        from: 0,
                        specialTpl: o,
                        reportType: N.reportMap.profile,
                        callback: function () {
                            e()
                        }
                    })
                })
            } else if ("song" == s) {
                if (!a.data.total || a.data.total <= 0)return U("#buy_song_box").html(B({})), void 0;
                r.total_num = a.data.total;
                var c = function (l) {
                    {
                        var a, t = "";
                        Array.prototype.join
                    }
                    t += '<div class="mod_songlist_toolbar">\r\n	<a href="javascript:;" class="mod_btn_green js_all_play" data-stat="y_new.profile.like.song.playall"><i class="mod_btn_green__icon_play"></i>播放全部</a>\r\n	<a href="javascript:;" class="mod_btn js_all_fav" data-stat="y_new.profile.like.song.addall"><i class="mod_btn__icon_add"></i>添加到</a>\r\n	<a href="javascript:;" class="mod_btn js_all_down" data-stat="y_new.profile.like.song.downloadall"><i class="mod_btn__icon_down"></i>下载</a>\r\n</div>\r\n<div class="mod_songlist">\r\n	<ul class="songlist__header">\r\n	    <li class="songlist__edit songlist__edit--check sprite">\r\n		<input type="checkbox" class="songlist__checkbox js_check_all"/>\r\n	    </li>\r\n		<li class="songlist__header_name">歌曲</li>\r\n		<li class="songlist__header_author">歌手</li>\r\n		<li class="songlist__header_album">专辑</li>\r\n		<li class="songlist__header_time">时长</li>\r\n	</ul>\r\n	<ul class="songlist__list">\r\n';
                    var s = l.list;
                    for (i = 0; i < s.length; i++) {
                        t += '\r\n	<li mid="' + (null == (a = s[i].songid) ? "" : a) + '" ix="' + (null == (a = s[i].ix) ? "" : a) + '">\r\n		<div class="songlist__item', s[i].disabled && (t += " songlist__item--disable "), t += "", i % 2 && (t += " songlist__item--even "), t += '" onmouseover="this.className=(this.className+\' songlist__item--hover\')" onmouseout="this.className=this.className.replace(/ songlist__item--hover/, \'\')">\r\n		    <div class="songlist__edit songlist__edit--check sprite">\r\n			<input type="checkbox" class="songlist__checkbox"/>\r\n		    </div>\r\n		    <div class="songlist__songname">\r\n		    ', 1 == s[i].isonly && (t += '\r\n			<i class="songlist__icon songlist__icon_exclusive sprite" title="独家"></i>\r\n		    '), t += "\r\n		    ", s[i].vid && (t += ' \r\n			<a href="' + (null == (a = N.util.getMvUrl(s[i].vid)) ? "" : a) + '" class="songlist__icon songlist__icon_mv sprite" rel="noopener" target="_blank" title="MV"><span class="icon_txt">MV</span></a>\r\n		    '), t += ' \r\n			<span class="songlist__songname_txt"><a href="' + (null == (a = N.util.getSongUrl(s[i])) ? "" : a) + '" class="js_song" title="' + (null == (a = s[i].songname) ? "" : _.escape(a)) + " " + (null == (a = s[i].songsubtitle || s[i].albumdesc) ? "" : _.escape(a)) + '">' + (null == (a = s[i].songname) ? "" : _.escape(a)) + '<span class="songlist__song_txt">' + (null == (a = s[i].songsubtitle || s[i].albumdesc) ? "" : _.escape(a)) + '</span></a></span>\r\n			<div class="mod_list_menu">\r\n			    <a href="javascript:;" class="list_menu__item list_menu__play js_play" title="播放">\r\n				<i class="list_menu__icon_play"></i>\r\n				<span class="icon_txt">播放</span>\r\n			    </a>\r\n			    <a href="javascript:;" class="list_menu__item list_menu__add js_fav" title="添加到歌单" aria-haspopup="true">\r\n				<i class="list_menu__icon_add"></i>\r\n				<span class="icon_txt">添加到歌单</span>\r\n			    </a>\r\n			    <a href="javascript:;" class="list_menu__item list_menu__down js_down" title="下载" aria-haspopup="true">\r\n				<i class="list_menu__icon_down"></i>\r\n				<span class="icon_txt">下载</span>\r\n			    </a>\r\n			    <a href="javascript:;" class="list_menu__item list_menu__share js_share" title="分享" aria-haspopup="true">\r\n				<i class="list_menu__icon_share"></i>\r\n				<span class="icon_txt">分享</span>\r\n			    </a>\r\n			</div>\r\n		    </div>\r\n		    <div class="songlist__artist">\r\n			';
                        for (var n = 0, e = s[i].singer.length; e > n; n++) {
                            var r = s[i].singer[n];
                            t += "\r\n			", n > 0 && (t += "/"), t += '\r\n			<a href="' + (null == (a = N.util.getSingerUrl(r)) ? "" : a) + '" data-singermid="' + (null == (a = r.mid) ? "" : a) + '" data-singerid="' + (null == (a = r.id) ? "" : a) + '" title="' + (null == (a = r.name) ? "" : _.escape(a)) + '" class="singer_name">' + (null == (a = r.name) ? "" : _.escape(a)) + "</a>\r\n			"
                        }
                        t += '\r\n		    </div>\r\n		    <div class="songlist__album">\r\n			<a data-albummid="' + (null == (a = s[i].albummid) ? "" : a) + '" data-albumid="' + (null == (a = s[i].albumid) ? "" : a) + '" href="' + (null == (a = N.util.getAlbumUrl(s[i])) ? "" : a) + '" title="' + (null == (a = s[i].albumname) ? "" : _.escape(a)) + '" class="album_name">' + (null == (a = s[i].albumname) ? "" : _.escape(a)) + '</a>\r\n		    </div>\r\n		    <div class="songlist__time">' + (null == (a = s[i].playTime) ? "" : a) + '</div>\r\n		    <div class="songlist__other">\r\n			', 1 == s[i].action.soso && (t += '\r\n			<a href="javascript:;" class="icon_sosomusic sprite">无版权</a>\r\n			'), t += '\r\n		    </div>\r\n                    <a href="javascript:;" class="songlist__delete js_delfav_song" ', s[i].songmid && "" != s[i].songmid || (t += 'data-type="11"'), t += ' data-id="' + (null == (a = s[i].songid) ? "" : a) + '" title="删除"><span class="icon_txt">删除</span></a>\r\n		</div>\r\n	</li>\r\n'
                    }
                    return t += "\r\n	</ul>\r\n</div>"
                };
                l.async("js/common/html/songlist.js", function (i) {
                    r.init = !0, i.init({
                        container: U("#buy_song_box"),
                        specilData: a.data.songlist,
                        specialTpl: c,
                        reportType: N.reportMap.profile,
                        callback: function () {
                            e(), U(".js_delfav_song").hide()
                        }
                    })
                })
            } else if ("peri" == s) {
                var d = function (i) {
                    {
                        var l, a = "";
                        Array.prototype.join
                    }
                    a += '<div class="mod_playlist no_more js_list">\r\n    <ul class="playlist__list">\r\n        ';
                    for (var t = i.orderlst, s = 0; s < t.length; s++) {
                        var n = t[s];
                        a += '\r\n        <li class="playlist__item">\r\n            <div class="playlist__item_box">\r\n                <div class="playlist__cover mod_cover">\r\n                    <a href="' + (null == (l = n.goodsbuyurl) ? "" : l) + '">\r\n                        <img src="' + (null == (l = n.cover_pic) ? "" : _.escape(l)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/album_300.png?max_age=31536000\';this.onerror=null;" class="playlist__pic"/>\r\n                    </a>\r\n                </div>\r\n                <h4 class="playlist__title">\r\n                    <span class="playlist__title_txt">\r\n                        <a href="' + (null == (l = n.goodsbuyurl) ? "" : l) + '">' + (null == (l = n.goodstitle) ? "" : _.escape(l)) + '</a>\r\n                    </span>\r\n                </h4>\r\n                <div class="playlist__author">\r\n					';
                        for (var e = [], r = [], o = 0; o < n.singers.length; o++) {
                            var c = n.singers[o];
                            e.push(c.singer_name), r.push(c.singer_mid)
                        }
                        e = e.join(","), a += '\r\n					<a href="javascritp:;" data-target="_blank" data-mid="' + (null == (l = 1 == r.length ? r[0] : "") ? "" : _.escape(l)) + '" class="js_singer" title="' + (null == (l = e) ? "" : _.escape(l)) + '">' + (null == (l = e) ? "" : _.escape(l)) + "</a>\r\n                </div>\r\n                </a>\r\n            </div>\r\n        </li>\r\n        "
                    }
                    return a += "\r\n    </ul>\r\n</div>"
                };
                if (!a.data.total || a.data.total <= 0)return U("#buy_peri_box").html(B({})), void 0;
                U("#buy_peri_box").html(d(a.data))
            }
        } else if ("create" == t) {
            if (!a.data || !a.data.disslist || a.data.disslist.length <= 0)return U("#create_box").html(B({})), void 0;
            r.total_num = a.data.totoal;
            var o = function (l) {
                {
                    var a, t = "";
                    Array.prototype.join
                }
                t += '		   <div class="playlist_toolbar">\r\n			', l.list.isStateHost && (t += '\r\n			    <button class="mod_btn js_create_new" data-stat="y_new.profile.create_playlist.create_new"><i class="mod_btn__icon_new"></i>新建歌单</button>\r\n			    <button class="mod_btn js_import" data-stat="y_new.profile.create_playlist.import"><i class="mod_btn__icon_input"></i>导入歌单</button>\r\n			    <button class="mod_btn js_recover" data-stat="y_new.profile.create_playlist.recover"><i class="mod_btn__icon_recovery"></i>恢复歌单</button>\r\n			'), t += '\r\n			    <div class="style_switch" aria-label="排列方式">\r\n				<a href="javascript:;" class="style_switch__item' + (null == (a = "mod_playlist" == l.list.showtype ? " style_switch__item--select" : "") ? "" : a) + '" title="上图下文" data-type="mod_playlist" data-tab="create" data-stat="y_new.profile.create_playlist.pic_mod"><i class="icon_style_pic sprite"></i><span class="icon_txt">上图下文</span></a>\r\n				<a href="javascript:;" class="style_switch__item' + (null == (a = "mod_playlist_text" == l.list.showtype ? " style_switch__item--select" : "") ? "" : a) + '" title="列表" data-type="mod_playlist_text" data-tab="create" data-stat="y_new.profile.create_playlist.list_mod"><i class="icon_style_list sprite"></i><span class="icon_txt">列表</span></a>\r\n			    </div>\r\n		    </div>\r\n\r\n                    <div class="mod_playlist_text js_list" style="display:' + (null == (a = "mod_playlist" == l.list.showtype ? "none" : "") ? "" : a) + ';">\r\n                        <ul class="playlist__header">\r\n			    <li class="playlist__header_name">歌单</li>\r\n			    <li class="playlist__header_number">曲目数</li>\r\n			    <li class="playlist__header_other">收听</li>\r\n                        </ul>\r\n                        <ul class="playlist__list">\r\n			';
                var s = {201: ".love", 205: ".qzone", 206: ".upload"}, n = {
                    201: "//y.gtimg.cn/mediastyle/global/img/cover_like.png",
                    205: "//y.gtimg.cn/mediastyle/global/img/cover_qzone.png",
                    206: "//y.gtimg.cn/mediastyle/global/img/cover_upload.png"
                }, e = l.list.list.slice(0, Q.create.per_page);
                for (i = 0; i < e.length; i++) {
                    var r = e[i];
                    (l.list.isStateHost || 206 != r.dirid) && (t += '\r\n                            <li class="playlist__item', i % 2 && (t += " playlist__item--even "), t += '" data-disstid="' + (null == (a = r.tid || 0) ? "" : a) + '" data-uin="' + (null == (a = l.list.hostuin) ? "" : a) + '" data-dirid="' + (null == (a = r.dirid) ? "" : a) + '" onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n                                <div class="playlist__cover">\r\n				', 205 == r.dirid || 206 == r.dirid ? t += '\r\n					<a href="//y.qq.com/portal/mymusic.html#stat=y_new.profile.create_playlist' + (null == (a = s[r.dirid]) ? "" : a) + ".click&dirid=" + (null == (a = r.dirid) ? "" : a) + "&hostuin=" + (null == (a = l.list.hostuin) ? "" : a) + '" onclick="setStatCookie&&setStatCookie();">\r\n						<img src="' + (null == (a = n[r.dirid]) ? "" : a) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = r.diss_name) ? "" : _.escape(a)) + '" class="playlist__pic"/>\r\n					</a>\r\n				' : (t += '\r\n					<a href="' + (null == (a = N.util.getPlaylistUrl(r.tid || l.list.myFavDissId)) ? "" : a) + "#stat=y_new.profile.create_playlist", 201 == r.dirid && (t += "" + (null == (a = s[r.dirid]) ? "" : a)), t += ".click&dirid=" + (null == (a = r.dirid) ? "" : a) + '" onclick="setStatCookie&&setStatCookie();" class="js_playlist"  data-disstid="' + (null == (a = r.tid || 0) ? "" : a) + '" data-dirid="' + (null == (a = r.dirid) ? "" : a) + '" data-stat="y_new.profile.create_playlist.click">\r\n						<img src="', t += 201 == r.dirid ? "" + (null == (a = n[r.dirid]) ? "" : a) : "" + (null == (a = r.diss_cover.replace(/\/90/g, "/300")) ? "" : _.escape(a)), t += '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = r.diss_name) ? "" : _.escape(a)) + '" class="playlist__pic"/>\r\n					</a>\r\n				'), t += '\r\n				</div>\r\n                                <h4 class="playlist__title">\r\n					<span class="playlist__title_txt">\r\n					', 205 == r.dirid || 206 == r.dirid ? t += '\r\n						<a href="//y.qq.com/portal/mymusic.html#stat=y_new.profile.create_playlist' + (null == (a = s[r.dirid]) ? "" : a) + ".click&dirid=" + (null == (a = r.dirid) ? "" : a) + "&hostuin=" + (null == (a = l.list.hostuin) ? "" : a) + '" onclick="setStatCookie&&setStatCookie();" title="' + (null == (a = r.diss_name) ? "" : _.escape(a)) + '">' + (null == (a = r.diss_name) ? "" : _.escape(a)) + "</a>\r\n					" : (t += '\r\n						<a href="' + (null == (a = N.util.getPlaylistUrl(r.tid || l.list.myFavDissId)) ? "" : a) + "#stat=y_new.profile.create_playlist", 201 == r.dirid && (t += "" + (null == (a = s[r.dirid]) ? "" : a)), t += ".click&dirid=" + (null == (a = r.dirid) ? "" : a) + '" onclick="setStatCookie&&setStatCookie();" class="js_playlist" data-stat="y_new.profile.create_playlist.click"  data-disstid="' + (null == (a = r.tid || 0) ? "" : a) + '" data-dirid="' + (null == (a = r.dirid) ? "" : a) + '" title="' + (null == (a = r.diss_name) ? "" : _.escape(a)) + '">' + (null == (a = r.diss_name) ? "" : _.escape(a)) + "</a>\r\n					"), t += '\r\n					</span>\r\n				</h4>\r\n                                <div class="mod_list_menu">\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__play js_play"  data-stat="y_new.profile.create_playlist', (201 == r.dirid || 205 == r.dirid || 206 == r.dirid) && (t += "" + (null == (a = s[r.dirid]) ? "" : a)), t += '.play" title="播放">\r\n                                        <i class="list_menu__icon_play"></i>\r\n                                        <span class="icon_txt">播放</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__add js_fav" title="添加到歌单">\r\n                                        <i class="list_menu__icon_add"></i>\r\n                                        <span class="icon_txt">添加到歌单</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__down js_down" title="下载">\r\n                                        <i class="list_menu__icon_down"></i>\r\n                                        <span class="icon_txt">下载</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__share js_share" title="分享">\r\n                                        <i class="list_menu__icon_share"></i>\r\n                                        <span class="icon_txt">分享</span>\r\n                                    </a>\r\n                                </div>\r\n                                <div class="playlist__number">\r\n                                    ' + (null == (a = r.song_cnt) ? "" : a) + '首\r\n                                </div>\r\n				    <div class="playlist__other">\r\n				    ', parseInt(r.listen_num, 10) > 0 && (t += "\r\n					" + (null == (a = parseInt(r.listen_num, 10) >= 1e4 ? ((r.listen_num / 1e4).toFixed(1) + "万").replace(".0万", "万") : r.listen_num) ? "" : a) + "\r\n				    "), t += '\r\n				    </div>\r\n				    <a href="javascript:;" class="playlist__delete js_delcreate_gedan" data-dirid="' + (null == (a = r.dirid) ? "" : a) + '" style="display:', (r.dirid >= 201 && r.dirid <= 206 || !l.list.isStateHost) && (t += "none"), t += ';"><span class="icon_txt">删除</span></a>\r\n                            </li>\r\n			')
                }
                t += '\r\n                        </ul>\r\n                    </div>\r\n\r\n		    <div class="mod_playlist js_list" style="display:' + (null == (a = "mod_playlist_text" == l.list.showtype ? "none" : "") ? "" : a) + ';">\r\n                        <ul class="playlist__header">\r\n			    <li class="playlist__header_name">歌单</li>\r\n			    <li class="playlist__header_number">曲目数</li>\r\n			    <li class="playlist__header_author">编辑</li>\r\n			    <li class="playlist__header_other">收听</li>\r\n                        </ul>\r\n                        <ul class="playlist__list">\r\n			';
                var e = l.list.list.slice(0, Q.create.per_page);
                for (i = 0; i < e.length; i++) {
                    var r = e[i];
                    (l.list.isStateHost || 206 != r.dirid) && (t += '\r\n                            <li class="playlist__item" data-disstid="' + (null == (a = r.tid || 0) ? "" : a) + '" data-dirid="' + (null == (a = r.dirid) ? "" : a) + '" data-uin="' + (null == (a = l.list.hostuin) ? "" : a) + '" onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n                                <div class="playlist__item_box">\r\n                                <div class="playlist__cover mod_cover">\r\n				', 205 == r.dirid || 206 == r.dirid ? t += '\r\n					<a href="//y.qq.com/portal/mymusic.html#stat=y_new.profile.create_playlist' + (null == (a = s[r.dirid]) ? "" : a) + ".click&dirid=" + (null == (a = r.dirid) ? "" : a) + "&hostuin=" + (null == (a = l.list.hostuin) ? "" : a) + '" onclick="setStatCookie&&setStatCookie();">\r\n						<img src="' + (null == (a = n[r.dirid]) ? "" : a) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = r.diss_name) ? "" : _.escape(a)) + '" class="playlist__pic"/>\r\n						<i class="mod_cover__icon_play js_play" data-stat="y_new.profile.create_playlist' + (null == (a = s[r.dirid]) ? "" : a) + '.play"></i>\r\n					</a>\r\n				' : (t += '\r\n					<a href="' + (null == (a = N.util.getPlaylistUrl(r.tid || l.list.myFavDissId)) ? "" : a) + "#stat=y_new.profile.create_playlist", 201 == r.dirid && (t += "" + (null == (a = s[r.dirid]) ? "" : a)), t += ".click&dirid=" + (null == (a = r.dirid) ? "" : a) + '" onclick="setStatCookie&&setStatCookie();" class="js_playlist" data-stat="y_new.profile.create_playlist.click"  data-disstid="' + (null == (a = r.tid || 0) ? "" : a) + '" data-dirid="' + (null == (a = r.dirid) ? "" : a) + '">\r\n						<img src="', t += 201 == r.dirid ? "" + (null == (a = n[r.dirid]) ? "" : a) : "" + (null == (a = r.diss_cover.replace(/\/90/g, "/300")) ? "" : _.escape(a)), t += '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = r.diss_name) ? "" : _.escape(a)) + '" class="playlist__pic"/>\r\n						<i class="mod_cover__icon_play js_play" data-stat="y_new.profile.create_playlist', 201 == r.dirid && (t += "" + (null == (a = s[r.dirid]) ? "" : a)), t += '.play"></i>\r\n					</a>\r\n				'), t += '\r\n				</div>\r\n                                <h4 class="playlist__title">\r\n					<span class="playlist__title_txt">\r\n					', 205 == r.dirid || 206 == r.dirid ? t += '\r\n						<a href="//y.qq.com/portal/mymusic.html#stat=y_new.profile.create_playlist' + (null == (a = s[r.dirid]) ? "" : a) + ".click&dirid=" + (null == (a = r.dirid) ? "" : a) + "&hostuin=" + (null == (a = l.list.hostuin) ? "" : a) + '" onclick="setStatCookie&&setStatCookie();" title="' + (null == (a = r.diss_name) ? "" : _.escape(a)) + '">' + (null == (a = r.diss_name) ? "" : _.escape(a)) + "</a>\r\n					" : (t += '\r\n						<a href="' + (null == (a = N.util.getPlaylistUrl(r.tid || l.list.myFavDissId)) ? "" : a) + "#stat=y_new.profile.create_playlist", 201 == r.dirid && (t += "" + (null == (a = s[r.dirid]) ? "" : a)), t += ".click&dirid=" + (null == (a = r.dirid) ? "" : a) + '" onclick="setStatCookie&&setStatCookie();" class="js_playlist" data-stat="y_new.profile.create_playlist.click" data-disstid="' + (null == (a = r.tid || 0) ? "" : a) + '" data-dirid="' + (null == (a = r.dirid) ? "" : a) + '" title="' + (null == (a = r.diss_name) ? "" : _.escape(a)) + '">' + (null == (a = r.diss_name) ? "" : _.escape(a)) + "</a>\r\n					"), t += '\r\n					</span>\r\n				</h4>\r\n                                <div class="playlist__number">\r\n                                    ' + (null == (a = r.song_cnt) ? "" : a) + '首\r\n                                </div>\r\n                                <div class="playlist__author">\r\n                                    <a>' + (null == (a = U(".profile__name").html()) ? "" : a) + '</a>\r\n                                </div>\r\n\r\n				    <div class="playlist__other">\r\n				    ', parseInt(r.listen_num, 10) > 0 && (t += "\r\n					" + (null == (a = parseInt(r.listen_num, 10) >= 1e4 ? ((r.listen_num / 1e4).toFixed(1) + "万").replace(".0万", "万") : r.listen_num) ? "" : a) + "\r\n				    "), t += "\r\n				    </div>\r\n				", 205 == r.dirid || 206 == r.dirid ? t += '\r\n					<a href="javascript:;" class="btn_operate_menu js_playlist_more_dirid" data-type="4" data-stat="y_new.profile.create_playlist' + (null == (a = s[r.dirid]) ? "" : a) + '.pic_mod_more" data-id="' + (null == (a = r.dirid) ? "" : a) + '"><span class="icon_txt">更多</span></a>\r\n				' : (t += '\r\n					<a href="javascript:;" class="btn_operate_menu js_playlist_more" data-type="3" data-id="' + (null == (a = r.tid || 0) ? "" : a) + '" ', l.list.isStateHost && (t += 'data-dirid="' + (null == (a = r.dirid) ? "" : a) + '" '), t += 'data-stat="y_new.profile.create_playlist', 201 == r.dirid && (t += "" + (null == (a = s[r.dirid]) ? "" : a)), t += '.pic_mod_more" ', 201 != r.dirid && (t += 'data-delete="delcreate_gedan"'), t += '><span class="icon_txt">更多</span></a>\r\n				'), t += "\r\n				</div>\r\n                            </li>\r\n			")
                }
                return t += "\r\n                        </ul>\r\n                    </div>"
            };
            l.async("js/common/html/taogelist.js", function (i) {
                r.init = !0;
                var l = Q.create.showtype;
                i.init({
                    lazyload: !1,
                    container: U("#create_box"),
                    specilData: {
                        list: a.data.disslist,
                        hostname: a.data.hostname,
                        hostuin: a.data.hostuin,
                        showtype: l,
                        isStateHost: H,
                        myFavDissId: W
                    },
                    specialTpl: o,
                    reportType: N.reportMap.profile,
                    callback: function () {
                        e(), H || (U(".js_delcreate_gedan").hide(), U('[data-delete="delcreate_gedan"]').removeAttr("data-delete"))
                    }
                })
            })
        } else if ("fans" == t) {
            if (!a.list || a.list.length <= 0)return U("#fans_box").html(B({desc: "还没有粉丝... "})), void 0;
            r.total_num = a.total;
            var o = Y;
            r.init = !0, G.init({
                container: U("#fans_box"),
                specilData: a.list,
                specialTpl: o,
                reportType: N.reportMap.profile,
                callback: function () {
                    e(), n && n()
                }
            })
        } else if ("focus" == t) {
            if ("singer" == s) {
                if (!a.list || a.list.length <= 0)return U("#focus_singer_box").html(B({desc: '什么也没有，去看看<a href="/portal/singer_list.html">热门歌手</a>！'})).show(), void 0;
                r.total_num = a.num;
                var o = Y;
                r.init = !0, G.init({
                    container: U("#focus_singer_box"),
                    specilData: a.list,
                    specialTpl: o,
                    reportType: N.reportMap.profile,
                    callback: function () {
                        e(), n && n()
                    }
                })
            } else if ("user" == s) {
                if (!a.list || a.list.length <= 0)return U("#focus_user_box").html(B({desc: "没有关注任何用户... "})).show(), void 0;
                r.total_num = a.total;
                var o = Y;
                r.init = !0, G.init({
                    container: U("#focus_user_box"),
                    specilData: a.list,
                    specialTpl: o,
                    reportType: N.reportMap.profile,
                    callback: function () {
                        e(), n && n()
                    }
                })
            }
        } else if ("like" == t) {
            if ("song" == s) {
                if (!a || !a.songlist || a.songlist.length <= 0)return U("#like_song_box").html(B({})), void 0;
                var m = function (l) {
                    {
                        var a, t = "";
                        Array.prototype.join
                    }
                    t += '\r\n<div class="mod_songlist_toolbar">\r\n	<a href="javascript:;" class="mod_btn_green js_all_play" data-stat="y_new.profile.like.song.playall"><i class="mod_btn_green__icon_play"></i>播放全部</a>\r\n	<a href="javascript:;" class="mod_btn js_all_fav" data-stat="y_new.profile.like.song.addall"><i class="mod_btn__icon_add"></i>添加到</a>\r\n	<a href="javascript:;" class="mod_btn js_all_down" data-stat="y_new.profile.like.song.downloadall"><i class="mod_btn__icon_down"></i>下载</a>\r\n	<a href="javascript:;" class="mod_btn js_batch" data-stat="y_new.profile.like.song.batch"><i class="mod_btn__icon_batch"></i>批量操作</a>\r\n</div>\r\n<div class="mod_songlist">\r\n	<ul class="songlist__header">\r\n	    <li class="songlist__edit songlist__edit--check sprite">\r\n		<input type="checkbox" class="songlist__checkbox js_check_all"/>\r\n	    </li>\r\n		<li class="songlist__header_name">歌曲</li>\r\n		<li class="songlist__header_author">歌手</li>\r\n		<li class="songlist__header_album">专辑</li>\r\n		<li class="songlist__header_time">时长</li>\r\n	</ul>\r\n	<ul class="songlist__list">\r\n';
                    var s = l.list;
                    for (i = 0; i < s.length; i++) {
                        t += '\r\n	<li mid="' + (null == (a = s[i].songid) ? "" : a) + '" ix="' + (null == (a = s[i].ix) ? "" : a) + '">\r\n		<div class="songlist__item', s[i].disabled && (t += " songlist__item--disable "), t += "", i % 2 && (t += " songlist__item--even "), t += '" onmouseover="this.className=(this.className+\' songlist__item--hover\')" onmouseout="this.className=this.className.replace(/ songlist__item--hover/, \'\')">\r\n		    <div class="songlist__edit songlist__edit--check sprite">\r\n			<input type="checkbox" class="songlist__checkbox"/>\r\n		    </div>\r\n		    <div class="songlist__songname">\r\n		    ', 1 == s[i].isonly && (t += '\r\n			<i class="songlist__icon songlist__icon_exclusive sprite" title="独家"></i>\r\n		    '), t += "\r\n		    ", s[i].vid && (t += ' \r\n			<a href="' + (null == (a = N.util.getMvUrl(s[i].vid)) ? "" : a) + '" class="songlist__icon songlist__icon_mv sprite" rel="noopener" target="_blank" title="MV"><span class="icon_txt">MV</span></a>\r\n		    '), t += ' \r\n			<span class="songlist__songname_txt"><a href="' + (null == (a = N.util.getSongUrl(s[i])) ? "" : a) + '" class="js_song" title="' + (null == (a = s[i].songname) ? "" : _.escape(a)) + " " + (null == (a = s[i].songsubtitle || s[i].albumdesc) ? "" : _.escape(a)) + '">' + (null == (a = s[i].songname) ? "" : _.escape(a)) + '<span class="songlist__song_txt">' + (null == (a = s[i].songsubtitle || s[i].albumdesc) ? "" : _.escape(a)) + '</span></a></span>\r\n			<div class="mod_list_menu">\r\n			    <a href="javascript:;" class="list_menu__item list_menu__play js_play" title="播放">\r\n				<i class="list_menu__icon_play"></i>\r\n				<span class="icon_txt">播放</span>\r\n			    </a>\r\n			    <a href="javascript:;" class="list_menu__item list_menu__add js_fav" title="添加到歌单" aria-haspopup="true">\r\n				<i class="list_menu__icon_add"></i>\r\n				<span class="icon_txt">添加到歌单</span>\r\n			    </a>\r\n			    <a href="javascript:;" class="list_menu__item list_menu__down js_down" title="下载" aria-haspopup="true">\r\n				<i class="list_menu__icon_down"></i>\r\n				<span class="icon_txt">下载</span>\r\n			    </a>\r\n			    <a href="javascript:;" class="list_menu__item list_menu__share js_share" title="分享" aria-haspopup="true">\r\n				<i class="list_menu__icon_share"></i>\r\n				<span class="icon_txt">分享</span>\r\n			    </a>\r\n			</div>\r\n		    </div>\r\n		    <div class="songlist__artist">\r\n			';
                        for (var n = 0, e = s[i].singer.length; e > n; n++) {
                            var r = s[i].singer[n];
                            t += "\r\n			", n > 0 && (t += "/"), t += '\r\n			<a href="' + (null == (a = N.util.getSingerUrl(r)) ? "" : a) + '" data-singermid="' + (null == (a = r.mid) ? "" : a) + '" data-singerid="' + (null == (a = r.id) ? "" : a) + '" title="' + (null == (a = r.name) ? "" : _.escape(a)) + '" class="singer_name">' + (null == (a = r.name) ? "" : _.escape(a)) + "</a>\r\n			"
                        }
                        t += '\r\n		    </div>\r\n		    <div class="songlist__album">\r\n			<a data-albummid="' + (null == (a = s[i].albummid) ? "" : a) + '" data-albumid="' + (null == (a = s[i].albumid) ? "" : a) + '" href="' + (null == (a = N.util.getAlbumUrl(s[i])) ? "" : a) + '" title="' + (null == (a = s[i].albumname) ? "" : _.escape(a)) + '" class="album_name">' + (null == (a = s[i].albumname) ? "" : _.escape(a)) + '</a>\r\n		    </div>\r\n		    <div class="songlist__time">' + (null == (a = s[i].playTime) ? "" : a) + '</div>\r\n		    <div class="songlist__other">\r\n			', 1 == s[i].action.soso && (t += '\r\n			<a href="javascript:;" class="icon_sosomusic sprite">无版权</a>\r\n			'), t += '\r\n		    </div>\r\n                    <a href="javascript:;" class="songlist__delete js_delfav_song" ', s[i].songmid && "" != s[i].songmid || (t += 'data-type="11"'), t += ' data-id="' + (null == (a = s[i].songid) ? "" : a) + '" title="删除"><span class="icon_txt">删除</span></a>\r\n		</div>\r\n	</li>\r\n'
                    }
                    return t += "\r\n	</ul>\r\n</div>"
                };
                U.each(a.songlist, function (i) {
                    a.songlist[i].disstid = W
                }), l.async("js/common/html/songlist.js", function (i) {
                    i.init({
                        container: U("#like_song_box"),
                        specilData: a.songlist,
                        specialTpl: m,
                        reportType: N.reportMap.profile,
                        callback: function () {
                            e(), U(".js_delfav_song").show(), H || U(".js_delfav_song").hide()
                        }
                    })
                })
            } else if ("playlist" == s) {
                if (!a.cdlist || a.cdlist.length <= 0)return U("#like_playlist_box").html(B({})), void 0;
                r.total_num = a.totaldiss;
                var o = function (l) {
                    {
                        var a, t = "";
                        Array.prototype.join
                    }
                    t += '		   \r\n		    <div class="style_switch" aria-label="排列方式">\r\n			<a href="javascript:;" class="style_switch__item' + (null == (a = "mod_playlist" == l.list.showtype ? " style_switch__item--select" : "") ? "" : a) + '" title="上图下文" data-type="mod_playlist" data-tab="like_playlist" data-stat="y_new.profile.like.playlist.pic_mod"><i class="icon_style_pic sprite"></i><span class="icon_txt">上图下文</span></a>\r\n			<a href="javascript:;" class="style_switch__item' + (null == (a = "mod_playlist_text" == l.list.showtype ? " style_switch__item--select" : "") ? "" : a) + '" title="列表" data-type="mod_playlist_text" data-tab="like_playlist" data-stat="y_new.profile.like.playlist.list_mod"><i class="icon_style_list sprite"></i><span class="icon_txt">列表</span></a>\r\n		    </div>\r\n\r\n                    <div class="mod_playlist_text js_list" style="display:' + (null == (a = "mod_playlist" == l.list.showtype ? "none" : "") ? "" : a) + ';">\r\n                        <ul class="playlist__header">\r\n			    <li class="playlist__header_name">歌单</li>\r\n			    <li class="playlist__header_number">曲目数</li>\r\n			    <li class="playlist__header_author">创建人</li>\r\n			    <li class="playlist__header_other">收听</li>\r\n                        </ul>\r\n                        <ul class="playlist__list">\r\n			';
                    var s = l.list.list.slice(0, Q.like_playlist.per_page);
                    for (i = 0; i < s.length; i++) {
                        var n = s[i];
                        t += "\r\n			", 10 != n.dirtype ? (t += '\r\n                            <li class="playlist__item', i % 2 && (t += " playlist__item--even "), t += '" data-disstid="' + (null == (a = n.dissid) ? "" : a) + '" onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n                                <div class="playlist__cover"><a href="' + (null == (a = N.util.getPlaylistUrl(n.dissid)) ? "" : a) + '" class="js_playlist"  data-disstid="' + (null == (a = n.dissid) ? "" : a) + '"><img src="' + (null == (a = n.logo.indexOf("cover_love_300.jpg") > -1 ? "//y.gtimg.cn/mediastyle/global/img/cover_like.png" : n.logo.replace(/\/90/g, "/300")) ? "" : _.escape(a)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = n.dissname) ? "" : _.escape(a)) + '" class="playlist__pic"/></a></div>\r\n                                <h4 class="playlist__title"><span class="playlist__title_txt"><a href="' + (null == (a = N.util.getPlaylistUrl(n.dissid)) ? "" : a) + '" class="js_playlist"  data-disstid="' + (null == (a = n.dissid) ? "" : a) + '" title="' + (null == (a = n.dissname) ? "" : _.escape(a)) + '">' + (null == (a = n.dissname) ? "" : _.escape(a)) + '</a></span></h4>\r\n                                <div class="mod_list_menu">\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__play js_play" data-stat="y_new.profile.like.playlist.play" title="播放">\r\n                                        <i class="list_menu__icon_play"></i>\r\n                                        <span class="icon_txt">播放</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__add js_fav" title="添加到歌单">\r\n                                        <i class="list_menu__icon_add"></i>\r\n                                        <span class="icon_txt">添加到歌单</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__down js_down" title="下载">\r\n                                        <i class="list_menu__icon_down"></i>\r\n                                        <span class="icon_txt">下载</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__share js_share" title="分享">\r\n                                        <i class="list_menu__icon_share"></i>\r\n                                        <span class="icon_txt">分享</span>\r\n                                    </a>\r\n                                </div>\r\n                                <div class="playlist__number">\r\n                                    ' + (null == (a = n.songnum) ? "" : _.escape(a)) + '首\r\n                                </div>\r\n                                <div class="playlist__author">\r\n                                    <a title="' + (null == (a = n.nickname) ? "" : _.escape(a)) + '" class="js_user" href="//y.qq.com/portal/profile.html?uin=' + (null == (a = n.encrypt_uin || n.uin) ? "" : a) + '" data-uin="' + (null == (a = n.encrypt_uin || n.uin) ? "" : a) + '">' + (null == (a = n.nickname) ? "" : _.escape(a)) + '</a>\r\n                                </div>\r\n				    <div class="playlist__other">\r\n					' + (null == (a = parseInt(n.listennum, 10) >= 1e4 ? ((n.listennum / 1e4).toFixed(1) + "万").replace(".0万", "万") : n.listennum) ? "" : a) + '\r\n				    </div>\r\n				    <a href="javascript:;" class="playlist__delete js_delfav_gedan" data-id="' + (null == (a = n.dissid) ? "" : a) + '"><span class="icon_txt">删除</span></a>\r\n                            </li>\r\n			') : (t += '\r\n			    <li class="playlist__item--disable playlist__item', i % 2 && (t += " playlist__item--even "), t += '"  onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n                                <div class="playlist__cover"><img src="' + (null == (a = n.logo.indexOf("cover_love_300.jpg") > -1 ? "//y.gtimg.cn/mediastyle/global/img/cover_like.png" : n.logo.replace(/\/90/g, "/300")) ? "" : _.escape(a)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000\';this.onerror=null;" alt="此歌单已被创建者删除" class="playlist__pic"/></div>\r\n                                <h4 class="playlist__title"><span class="playlist__title_txt">此歌单已被创建者删除</span></h4>\r\n                                <div class="mod_list_menu">\r\n                                </div>\r\n                                <div class="playlist__number">\r\n                                    0首\r\n                                </div>\r\n                                <div class="playlist__author">\r\n                                    <a></a>\r\n                                </div>\r\n				    <div class="playlist__other">\r\n					' + (null == (a = parseInt(n.listennum, 10) >= 1e4 ? ((n.listennum / 1e4).toFixed(1) + "万").replace(".0万", "万") : n.listennum) ? "" : a) + '\r\n				    </div>\r\n				    <a href="javascript:;" class="playlist__delete js_delfav_gedan" data-id="' + (null == (a = n.dissid) ? "" : a) + '"><span class="icon_txt">删除</span></a>\r\n                            </li>\r\n			'), t += "\r\n			"
                    }
                    t += '\r\n                        </ul>\r\n                    </div>\r\n\r\n		    <div class="mod_playlist js_list" style="display:' + (null == (a = "mod_playlist_text" == l.list.showtype ? "none" : "") ? "" : a) + ';">\r\n                        <ul class="playlist__header">\r\n			    <li class="playlist__header_name">歌单</li>\r\n			    <li class="playlist__header_number">曲目数</li>\r\n			    <li class="playlist__header_author">编辑</li>\r\n			    <li class="playlist__header_other">收听</li>\r\n                        </ul>\r\n                        <ul class="playlist__list">\r\n			';
                    var s = l.list.list.slice(0, Q.like_playlist.per_page);
                    for (i = 0; i < s.length; i++) {
                        var n = s[i];
                        t += "\r\n			", t += 10 != n.dirtype ? '\r\n                            <li class="playlist__item" data-disstid="' + (null == (a = n.dissid) ? "" : a) + '" onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n                                <div class="playlist__item_box">\r\n                                <div class="playlist__cover mod_cover"><a href="' + (null == (a = N.util.getPlaylistUrl(n.dissid)) ? "" : a) + '" class="js_playlist"  data-disstid="' + (null == (a = n.dissid) ? "" : a) + '" ><img src="' + (null == (a = n.logo.indexOf("cover_love_300.jpg") > -1 ? "//y.gtimg.cn/mediastyle/global/img/cover_like.png" : n.logo.replace(/\/90/g, "/300")) ? "" : _.escape(a)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = n.dissname) ? "" : _.escape(a)) + '" class="playlist__pic"/><i class="mod_cover__icon_play js_play" data-stat="y_new.profile.like.playlist.play"></i></a></div>\r\n                                <h4 class="playlist__title"><span class="playlist__title_txt"><a href="' + (null == (a = N.util.getPlaylistUrl(n.dissid)) ? "" : a) + '" class="js_playlist"  data-disstid="' + (null == (a = n.dissid) ? "" : a) + '"  title="' + (null == (a = n.dissname) ? "" : _.escape(a)) + '">' + (null == (a = n.dissname) ? "" : _.escape(a)) + '</a></span></h4>\r\n                                <div class="playlist__number">\r\n                                    ' + (null == (a = n.songnum) ? "" : a) + '首\r\n                                </div>\r\n                                <div class="playlist__author">\r\n                                    <a title="' + (null == (a = n.nickname) ? "" : _.escape(a)) + '" class="js_user" href="//y.qq.com/portal/profile.html?uin=' + (null == (a = n.encrypt_uin || n.uin) ? "" : a) + '" data-uin="' + (null == (a = n.encrypt_uin || n.uin) ? "" : a) + '">' + (null == (a = n.nickname) ? "" : _.escape(a)) + '</a>\r\n                                </div>\r\n				    <div class="playlist__other">\r\n					' + (null == (a = parseInt(n.listennum, 10) >= 1e4 ? ((n.listennum / 1e4).toFixed(1) + "万").replace(".0万", "万") : n.listennum) ? "" : a) + '\r\n				    </div>\r\n                            <a href="javascript:;" class="btn_operate_menu js_playlist_more" data-type="3" data-id="' + (null == (a = n.dissid) ? "" : a) + '" data-delete="delfav_gedan" data-stat="y_new.profile.like.playlist.pic_mod_more"><span class="icon_txt">更多</span></a>\r\n				</div>\r\n                            </li>	\r\n			' : '	\r\n			    <li class="playlist__item playlist__item--disable" onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n                                <div class="playlist__item_box">\r\n                                <div class="playlist__cover mod_cover"><img src="' + (null == (a = n.logo.indexOf("cover_love_300.jpg") > -1 ? "//y.gtimg.cn/mediastyle/global/img/cover_like.png" : n.logo.replace(/\/90/g, "/300")) ? "" : _.escape(a)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/cover_playlist.png?max_age=31536000\';this.onerror=null;" alt="此歌单已被创建者删除" class="playlist__pic"/></div>\r\n                                <h4 class="playlist__title"><span class="playlist__title_txt">此歌单已被创建者删除</span></h4>\r\n                                <div class="playlist__number">\r\n                                    0首\r\n                                </div>\r\n                                <div class="playlist__author">\r\n                                    <a></a>\r\n                                </div>\r\n				    <div class="playlist__other">\r\n					' + (null == (a = parseInt(n.listennum, 10) >= 1e4 ? ((n.listennum / 1e4).toFixed(1) + "万").replace(".0万", "万") : n.listennum) ? "" : a) + '\r\n				    </div>\r\n                            <a href="javascript:;" class="btn_operate_menu js_playlist_more" data-type="3" data-id="' + (null == (a = n.dissid) ? "" : a) + '" data-delete="delfav_gedan" data-stat="y_new.profile.like.playlist.pic_mod_more"><span class="icon_txt">更多</span></a>\r\n				</div>\r\n                            </li>\r\n			', t += "\r\n			"
                    }
                    return t += "\r\n                        </ul>\r\n                    </div>"
                };
                l.async("js/common/html/taogelist.js", function (i) {
                    r.init = !0;
                    var l = Q.like_playlist.showtype;
                    i.init({
                        container: U("#like_playlist_box"),
                        specilData: {list: a.cdlist, showtype: l},
                        specialTpl: o,
                        reportType: N.reportMap.profile,
                        callback: function () {
                            e(), H || (U(".js_delfav_gedan").hide(), U('[data-delete="delfav_gedan"]').removeAttr("data-delete"))
                        }
                    })
                })
            } else if ("album" == s) {
                if (!a.albumlist || a.albumlist.length <= 0)return U("#like_album_box").html(B({})), void 0;
                r.total_num = a.totalalbum;
                var o = function (l) {
                    {
                        var a, t = "";
                        Array.prototype.join
                    }
                    t += '		      \r\n		    <div class="style_switch" aria-label="排列方式">\r\n			<a href="javascript:;" class="style_switch__item' + (null == (a = "mod_playlist" == l.list.showtype ? " style_switch__item--select" : "") ? "" : a) + '" title="上图下文" data-type="mod_playlist" data-tab="like_album" data-stat="y_new.profile.like.album.pic_mod"><i class="icon_style_pic sprite"></i><span class="icon_txt">上图下文</span></a>\r\n			<a href="javascript:;" class="style_switch__item' + (null == (a = "mod_playlist_text" == l.list.showtype ? " style_switch__item--select" : "") ? "" : a) + '" title="列表" data-type="mod_playlist_text"  data-tab="like_album"data-stat="y_new.profile.like.album.list_mod"><i class="icon_style_list sprite"></i><span class="icon_txt">列表</span></a>\r\n		    </div>\r\n\r\n                    <div class="mod_playlist_text js_list" style="display:' + (null == (a = "mod_playlist" == l.list.showtype ? "none" : "") ? "" : a) + ';">\r\n                        <ul class="playlist__header">\r\n			    <li class="playlist__header_name">专辑</li>\r\n			    <li class="playlist__header_number">曲目数</li>\r\n			    <li class="playlist__header_author">歌手</li>\r\n			    <li class="playlist__header_other">发行时间</li>\r\n                        </ul>\r\n                        <ul class="playlist__list">\r\n			';
                    var s = l.list.list;
                    for (i = 0; i < s.length; i++) {
                        var n = s[i];
                        t += '\r\n                            <li class="playlist__item', i % 2 && (t += " playlist__item--even "), t += '" data-albummid="' + (null == (a = n.albummid) ? "" : a) + '" onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n                                <div class="playlist__cover"><a href="' + (null == (a = N.util.getAlbumUrl(n)) ? "" : a) + '" class="js_album"  data-albummid="' + (null == (a = n.albummid) ? "" : a) + '"><img src="' + (null == (a = N.util.getAlbumPic({
                                mid: n.albummid,
                                type: 300
                            })) ? "" : a) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/album_300.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = n.albumname) ? "" : _.escape(a)) + '" class="playlist__pic"/></a></div>\r\n                                <h4 class="playlist__title"><span class="playlist__title_txt"><a href="' + (null == (a = N.util.getAlbumUrl(n)) ? "" : a) + '" class="js_album"  data-albummid="' + (null == (a = n.albummid) ? "" : a) + '" title="' + (null == (a = n.albumname) ? "" : _.escape(a)) + '">' + (null == (a = n.albumname) ? "" : _.escape(a)) + '</a></span></h4>\r\n                                <div class="mod_list_menu">\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__play js_play" title="播放" data-stat="y_new.profile.like.album.play">\r\n                                        <i class="list_menu__icon_play"></i>\r\n                                        <span class="icon_txt">播放</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__add js_fav" title="添加到歌单">\r\n                                        <i class="list_menu__icon_add"></i>\r\n                                        <span class="icon_txt">添加到歌单</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__down js_down" title="下载">\r\n                                        <i class="list_menu__icon_down"></i>\r\n                                        <span class="icon_txt">下载</span>\r\n                                    </a>\r\n                                    <a href="javascript:;" class="list_menu__item list_menu__share js_share" title="分享">\r\n                                        <i class="list_menu__icon_share"></i>\r\n                                        <span class="icon_txt">分享</span>\r\n                                    </a>\r\n                                </div>\r\n                                <div class="playlist__number">\r\n                                    ' + (null == (a = n.songnum) ? "" : _.escape(a)) + '首\r\n                                </div>\r\n                                <div class="playlist__author">\r\n                                    <a href="' + (null == (a = N.util.getSingerUrl(n)) ? "" : a) + '" class="js_singer" data-singermid="' + (null == (a = n.singermid) ? "" : a) + '" title="' + (null == (a = n.singername) ? "" : _.escape(a)) + '">' + (null == (a = n.singername) ? "" : _.escape(a)) + '</a>\r\n                                </div>\r\n				    <div class="playlist__other">\r\n					' + (null == (a = N.util.toYMDString(1e3 * n.pubtime)) ? "" : a) + '\r\n				    </div>\r\n				    <a href="javascript:;" class="playlist__delete js_delfav_album" data-mid="' + (null == (a = n.albummid) ? "" : a) + '" data-id="' + (null == (a = n.albumid) ? "" : a) + '"><span class="icon_txt">删除</span></a>\r\n                            </li>\r\n			'
                    }
                    t += '\r\n                        </ul>\r\n                    </div>\r\n\r\n		    <div class="mod_playlist js_list" style="display:' + (null == (a = "mod_playlist_text" == l.list.showtype ? "none" : "") ? "" : a) + ';">\r\n                        <ul class="playlist__header">\r\n			    <li class="playlist__header_name">专辑</li>\r\n			    <li class="playlist__header_number">曲目数</li>\r\n			    <li class="playlist__header_author">歌手</li>\r\n			    <li class="playlist__header_other">发行时间</li>\r\n                        </ul>\r\n                        <ul class="playlist__list">\r\n			';
                    var s = l.list.list;
                    for (i = 0; i < s.length; i++) {
                        var n = s[i];
                        t += '\r\n                            <li class="playlist__item" data-albummid="' + (null == (a = n.albummid) ? "" : a) + '" onmouseover="this.className=(this.className+\' playlist__item--hover\')" onmouseout="this.className=this.className.replace(/ playlist__item--hover/, \'\')">\r\n                                <div class="playlist__item_box">\r\n                                <div class="playlist__cover mod_cover"><a href="' + (null == (a = N.util.getAlbumUrl(n)) ? "" : a) + '" class="js_album"  data-albummid="' + (null == (a = n.albummid) ? "" : a) + '"><img src="' + (null == (a = N.util.getAlbumPic({
                                mid: n.albummid,
                                type: 300
                            })) ? "" : _.escape(a)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/album_300.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = n.albumname) ? "" : _.escape(a)) + '" class="playlist__pic"/><i class="mod_cover__icon_play js_play" data-stat="y_new.profile.like.album.play"></i></a></div>\r\n                                <h4 class="playlist__title"><span class="playlist__title_txt"><a href="' + (null == (a = N.util.getAlbumUrl(n)) ? "" : a) + '" class="js_album"  data-albummid="' + (null == (a = n.albummid) ? "" : a) + '" title="' + (null == (a = n.albumname) ? "" : _.escape(a)) + '">' + (null == (a = n.albumname) ? "" : _.escape(a)) + '</a></span></h4>\r\n                                <div class="playlist__number">\r\n                                    ' + (null == (a = n.songnum) ? "" : a) + '首\r\n                                </div>\r\n                                <div class="playlist__author">\r\n                                    <a href="' + (null == (a = N.util.getSingerUrl(n)) ? "" : a) + '" class="js_singer" data-singermid="' + (null == (a = n.singermid) ? "" : a) + '" title="' + (null == (a = n.singername) ? "" : _.escape(a)) + '">' + (null == (a = n.singername) ? "" : _.escape(a)) + '</a>\r\n                                </div>\r\n				    <div class="playlist__other">\r\n					' + (null == (a = N.util.toYMDString(1e3 * n.pubtime)) ? "" : a) + '\r\n				    </div>\r\n				    <a href="javascript:;" class="btn_operate_menu js_albumlist_more" data-type="2" data-mid="' + (null == (a = n.albummid) ? "" : a) + '" data-id="' + (null == (a = n.albumid) ? "" : a) + '" data-delete="delfav_album" data-stat="y_new.profile.like.album.pic_mod_more"><span class="icon_txt">更多</span></a>\r\n				</div>\r\n                            </li>\r\n			'
                    }
                    return t += "\r\n                        </ul>\r\n                    </div>"
                };
                l.async("js/common/html/albumlist.js", function (i) {
                    r.init = !0;
                    var l = Q.like_album.showtype;
                    i.init({
                        container: U("#like_album_box"),
                        specilData: {list: a.albumlist, showtype: l},
                        from: 0,
                        specialTpl: o,
                        reportType: N.reportMap.profile,
                        callback: function () {
                            e(), H || (U(".js_delfav_album").hide(), U('[data-delete="delfav_album"]').removeAttr("data-delete"))
                        }
                    })
                })
            } else if ("mv" == s) {
                if (!a.mvlist || a.mvlist.length <= 0)return U("#like_mv_box").html(B({})), void 0;
                r.total_num = a.total_num;
                var o = function (l) {
                    {
                        var a, t = "";
                        Array.prototype.join
                    }
                    t += '\r\n                    <div class="mod_mv_list">\r\n                        <ul class="mv_list__list">\r\n			';
                    var s = l.list;
                    for (i = 0; i < s.length; i++) {
                        var n = s[i];
                        t += '\r\n                            <li class="mv_list__item" data-vid="' + (null == (a = n.vid) ? "" : a) + '" data-id="' + (null == (a = n.id) ? "" : a) + '" onmouseover="this.className=(this.className+\' mv_list__item--hover\')" onmouseout="this.className=this.className.replace(/ mv_list__item--hover/, \'\')">\r\n                                <div class="mv_list__item_box">\r\n                                    <a href="' + (null == (a = N.util.getMvUrl(n.vid)) ? "" : a) + '" title="' + (null == (a = n.mv_name) ? "" : _.escape(a)) + '" class="mv_list__cover mod_cover js_mv" data-vid="' + (null == (a = n.vid) ? "" : a) + '" data-id="' + (null == (a = n.id) ? "" : a) + '" hidefocus="true">\r\n                                        <img class="mv_list__pic" src="//shp.qpic.cn/qqvideo_ori/0/' + (null == (a = n.vid) ? "" : a) + '_360_204/0" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/mv_300.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = n.mv_name) ? "" : _.escape(a)) + '">\r\n                                        <i class="mod_cover__icon_play"></i>\r\n                                    </a>\r\n                                    <h3 class="mv_list__title"><a href="' + (null == (a = N.util.getMvUrl(n.vid)) ? "" : a) + '" class="js_mv" data-vid="' + (null == (a = n.vid) ? "" : a) + '" data-id="' + (null == (a = n.id) ? "" : a) + '" title="' + (null == (a = n.mv_name) ? "" : _.escape(a)) + '">' + (null == (a = n.mv_name) ? "" : _.escape(a)) + '</a></h3>\r\n                                    <p class="mv_list__singer"><a href="' + (null == (a = N.util.getSingerUrl({mid: n.singer_mid})) ? "" : a) + '" class="js_singer" data-singermid=' + (null == (a = n.singer_mid) ? "" : a) + ' data-singerid="' + (null == (a = n.singer_id) ? "" : a) + '" title="' + (null == (a = n.singer_name) ? "" : _.escape(a)) + '">' + (null == (a = n.singer_name) ? "" : _.escape(a)) + '</a></p>\r\n				    <a href="javascript:;" class="mv_list__delete js_delfav_mv"  data-id="' + (null == (a = n.id) ? "" : a) + '"><span class="icon_txt">删除</span></a>\r\n                                </div>\r\n                            </li>\r\n			'
                    }
                    return t += "\r\n                        </ul>\r\n                    </div>"
                };
                l.async("js/common/html/mvlist.js", function (i) {
                    i.init({
                        container: U("#like_mv_box"),
                        specilData: a.mvlist,
                        specialTpl: o,
                        reportType: N.reportMap.search,
                        callback: function () {
                            e(), H || U(".js_delfav_mv").hide()
                        }
                    })
                })
            }
        } else if ("uploadmv" == t) {
            if (!a.mvlist || a.mvlist.length <= 0)return U("#uploadmv_box").html(B({desc: "还没有上传视频... "})), void 0;
            r.total_num = a.total;
            var p = function (l) {
                {
                    var a, t = "";
                    Array.prototype.join
                }
                t += '		    <div class="playlist_toolbar">\r\n			', l.list.isStateHost && (t += '\r\n			    <button class="mod_btn js_goto_uploadmv" data-stat="y_new.profile.create_playlist.goto_uploadmv"><i class="mod_btn__icon_new"></i>上传视频</button>\r\n			    <button class="mod_btn js_uploadmv_system" data-stat="y_new.profile.create_playlist.uploadmv_system"><i class="mod_btn__icon_input"></i>视频管理</button>\r\n			'), t += '\r\n		    </div>\r\n                    <div class="mod_mv_list">\r\n                        <ul class="mv_list__list">\r\n			';
                var s = l.list.mvlist;
                for (i = 0; i < s.length; i++) {
                    var n = s[i];
                    t += '\r\n                            <li class="mv_list__item" data-vid="' + (null == (a = n.play_vid) ? "" : a) + '" data-id="' + (null == (a = n.mvid) ? "" : a) + '" onmouseover="this.className=(this.className+\' mv_list__item--hover\')" onmouseout="this.className=this.className.replace(/ mv_list__item--hover/, \'\')">\r\n                                <div class="mv_list__item_box">\r\n				', t += n.play_vid ? '\r\n                                    <a href="' + (null == (a = N.util.getMvUrl(n.play_vid)) ? "" : a) + '" title="' + (null == (a = n.title) ? "" : _.escape(a)) + '" class="mv_list__cover mod_cover js_mv" data-vid="' + (null == (a = n.play_vid) ? "" : a) + '" data-id="' + (null == (a = n.mvid) ? "" : a) + '" hidefocus="true">\r\n                                        <img class="mv_list__pic" src="//shp.qpic.cn/qqvideo_ori/0/' + (null == (a = n.play_vid) ? "" : a) + '_360_204/0" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/mv_300.png?max_age=31536000\';this.onerror=null;" alt="' + (null == (a = n.title) ? "" : _.escape(a)) + '">\r\n                                        <i class="mod_cover__icon_play"></i>\r\n                                    </a>\r\n                                    <h3 class="mv_list__title"><a href="' + (null == (a = N.util.getMvUrl(n.play_vid)) ? "" : a) + '" class="js_mv" data-vid="' + (null == (a = n.play_vid) ? "" : a) + '" data-id="' + (null == (a = n.mvid) ? "" : a) + '" title="' + (null == (a = n.title) ? "" : _.escape(a)) + '">' + (null == (a = n.title) ? "" : _.escape(a)) + "</a></h3>\r\n				" : '\r\n                                    <a class="mv_list__cover mod_cover" hidefocus="true">\r\n                                        <img class="mv_list__pic" src="//y.gtimg.cn/mediastyle/global/img/mv_300.png?max_age=31536000" alt="' + (null == (a = n.title) ? "" : _.escape(a)) + '">\r\n                                        <i class="mod_cover__icon_play"></i>\r\n                                    </a>\r\n                                    <h3 class="mv_list__title"><a title="' + (null == (a = n.title) ? "" : _.escape(a)) + '">' + (null == (a = n.title) ? "" : _.escape(a)) + "</a></h3>\r\n\r\n				", t += '\r\n                                    <p class="mv_list__singer"><a href="' + (null == (a = N.util.getSingerUrl({mid: n.singer[0].mid})) ? "" : a) + '" class="js_singer" data-singermid=' + (null == (a = n.singer[0].mid) ? "" : a) + ' data-singerid="' + (null == (a = n.singer[0].id) ? "" : a) + '" title="' + (null == (a = n.singer[0].name) ? "" : _.escape(a)) + '">' + (null == (a = n.singer[0].name) ? "" : _.escape(a)) + "</a></p>\r\n                                </div>\r\n                            </li>\r\n			"
                }
                return t += "\r\n                        </ul>\r\n                    </div>"
            };
            r.init = !0, l.async("js/common/html/mvlist.js", function (i) {
                i.init({
                    container: U("#uploadmv_box"),
                    specilData: {mvlist: a.mvlist, isStateHost: H},
                    specialTpl: p,
                    reportType: N.reportMap.search,
                    callback: function () {
                        e()
                    }
                })
            })
        } else if ("magazine" == t)if (U("#magazine_tab").length > 0) {
            if (!a.v_magzine || a.v_magzine.length <= 0)return U("#magazine_box").html(B({desc: "还没有发表杂志... "})), void 0;
            r.total_num = a.total;
            var p = function (i) {
                {
                    var l, a = "";
                    Array.prototype.join
                }
                a += '\r\n            <a href="//y.qq.com/portal/headline/editor.html" rel="noopener" target="_blank" class="mod_btn mod_btn_add_article"><i class="mod_btn__icon_new"></i>发表文章</a>\r\n            <a href="//y.qq.com/portal/headline/manage.html" rel="noopener" target="_blank" class="mod_btn mod_btn_manage_article"><i class="mod_btn__icon_upload"></i>文章管理</a>\r\n\r\n            <div class="mod_article">\r\n                <table class="article__table" width="100%">\r\n                    <thead>\r\n                        <tr>\r\n                            <th class="article__col_1">文章</th>\r\n                            <th class="article__col_2">发表时间</th>\r\n                            <th class="article__col_3">阅读量</th>\r\n                            <th class="article__col_4">操作</th>\r\n                        </tr>\r\n                    </thead>\r\n                    <tbody>\r\n		    ';
                for (var t = 0, s = i.length; s > t; t++) {
                    var n = i[t];
                    a += '\r\n                        <tr data-zid="' + (null == (l = n.zid) ? "" : l) + '">\r\n                            <td>\r\n                                <div class="article__info">\r\n                                    <img class="article__cover" src="' + (null == (l = n.front_pic) ? "" : l) + '" alt="' + (null == (l = n.title) ? "" : _.escape(l)) + '" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/album_300.png?max_age=31536000\';this.onerror=null;"/>\r\n                                    <span class="article__title">' + (null == (l = n.title) ? "" : _.escape(l)) + '</span>\r\n                                </div>\r\n                            </td>\r\n                            <td><p class="article__time">' + (null == (l = N.util.toYMDString(1e3 * n.modify_time)) ? "" : l) + '</p></td>\r\n                            <td><p class="article__view__num">' + (null == (l = n.read_cnt) ? "" : l) + '</p> </td>\r\n                            <td>\r\n                                <div class="article__view">\r\n                                    <a class="article__view__link js_magazine_preview_qrcode" href="javascript:;">', a += 200 == n.level || 300 == n.level || 400 == n.level ? "查看" : "预览", a += '</a>\r\n                                    <div class="popup_phone_qrcode js_preview_qrcode_popup" data-aria="popup" style="display:none;">\r\n                                        <i class="popup_phone_qrcode__arrow"></i>\r\n                                        <img src="http://i.gtimg.cn/mediastyle/musicprotal/img/qrcode_qqmusic.jpg" alt="请扫描二维码" class="popup_phone_qrcode__pic">\r\n                                    </div>\r\n                                </div>\r\n                            </td>\r\n                        </tr>\r\n		    '
                }
                return a += "\r\n                    </tbody>\r\n                </table>\r\n            </div>\r\n        </div>"
            };
            r.init = !0, U.each(a.v_magzine, function (i, l) {
                O[l.zid] = l
            }), U("#magazine_box").html(p(a.v_magzine)), e()
        } else U("#magazine_box").html(""), window.location.replace(location.protocol + "//y.qq.com/portal/profile.html#sub=song&tab=like&"); else if ("radio" == t) {
            var p = function (i) {
                {
                    var l, a = "";
                    Array.prototype.join
                }
                if (a += "", i = i.list || {}, a += "\r\n", i.isStateHost && (a += '\r\n<div class="playlist_toolbar">\r\n    <a class="js_edit_radio mod_btn" href="//y.qq.com/portal/audio/radio_edit.html" rel="noopener" target="_blank"><i class="mod_btn__icon_new"></i>创建电台</a>\r\n    <a class="js_radio_list mod_btn" href="//y.qq.com/portal/audio/radio_list.html" rel="noopener" target="_blank"><i class="mod_btn__icon_batch"></i>管理电台</a>\r\n</div>\r\n'), a += "\r\n", i.radiolist && i.radiolist.length) {
                    a += '\r\n<div class="mod_voice_text">\r\n    <ul class="voice__header">\r\n        <li class="voice__header_name">电台</li>\r\n        <li class="voice__header_number">节目数</li>\r\n        <li class="voice__header_other">收听</li>\r\n    </ul>\r\n    <ul class="voice__list">\r\n        ';
                    for (var t = 0; t < i.radiolist.length; t++) {
                        var s = i.radiolist[t];
                        a += '\r\n        <li class="js_radio voice__item voice__item--hover" data-albummid="' + (null == (l = s.mid) ? "" : l) + '">\r\n            <div class="voice__item_box playlist__item">\r\n                <h4 class="voice__title">\r\n                    <span class="voice__title_txt">\r\n                    <a href="javascript:;" class="voice__cover"><img src="' + (null == (l = s.cover) ? "" : l) + '" alt=""' + (null == (l = s.desc) ? "" : _.escape(l)) + '" class="voice__pic"></a>\r\n                    <a href="javascript:;">' + (null == (l = s.name) ? "" : _.escape(l)) + '</a>\r\n                    </span>\r\n\r\n                </h4>\r\n                <div class="mod_list_menu">\r\n                    <a href="javascript:;" class="js_play list_menu__item list_menu__play" title="播放">\r\n                        <i class="list_menu__icon_play"></i>\r\n                        <span class="icon_txt">播放</span>\r\n                    </a>\r\n                    <a href="javascript:;" class="js_share list_menu__item list_menu__share" title="分享">\r\n                        <i class="list_menu__icon_share"></i>\r\n                        <span class="icon_txt">分享</span>\r\n                    </a>\r\n                    <a href="javascript:;" class="js_fav list_menu__item list_menu__add" title="添加到歌单">\r\n                        <i class="list_menu__icon_add"></i>\r\n                        <span class="icon_txt">添加到歌单</span>\r\n                    </a>\r\n                    <a href="javascript:;" class="js_down list_menu__item list_menu__down" title="下载">\r\n                        <i class="list_menu__icon_down"></i>\r\n                        <span class="icon_txt">下载</span>\r\n                    </a>\r\n                </div>\r\n                <div class="voice__number">\r\n                    ' + (null == (l = s.audio_count || 0) ? "" : l) + '\r\n                </div>\r\n                <div class="voice__other">\r\n                    ' + (null == (l = parseInt(s.play_count, 10) >= 1e4 ? ((s.play_count / 1e4).toFixed(1) + "万").replace(".0万", "万") : s.play_count) ? "" : l) + '\r\n                </div>\r\n                <!--<a href="javascript:;" class="js_delete voice__delete"><span class="icon_txt">删除</span></a>-->\r\n            </div>\r\n        </li>\r\n        '
                    }
                    a += "\r\n    </ul>\r\n</div>\r\n"
                } else a += '\r\n<div class="none_txt">\r\n    <i class="none_txt__symbol none_txt__symbol--album"></i>\r\n    <p>审核通过的电台将显示在这里</p>\r\n    <div class="none_txt__action"><a rel="noopener" target="_blank" href="//y.qq.com/portal/audio/radio_edit.html" class="js_edit_radio mod_btn_green none_txt__btn">创建电台</a></div>\r\n    </div>\r\n';
                return a += "\r\n"
            };
            l.async("js/common/html/albumlist.js", function (i) {
                r.init = !0, i.init({
                    container: U("#radio_box"),
                    specilData: {isStateHost: H, radiolist: a || []},
                    from: 0,
                    specialTpl: p,
                    reportType: N.reportMap.profile,
                    callback: function () {
                    }
                })
            })
        }
    }

    function d(i, l) {
        var a = '<div class="mod_loading"><i class="icon_txt">加载中</i></div>';
        l = l || "", "buy" == i ? "album" == l ? U("#buy_album_box").html(a) : "song" == l ? U("#buy_song_box").html(a) : "peri" == l && U("#buy_peri_box").html(a) : "create" == i ? U("#create_box").html(a) : "fans" == i ? U("#fans_box").html(a) : "focus" == i ? "singer" == l ? U("#focus_singer_box").html(a) : "user" == l && U("#focus_user_box").html(a) : "like" == i ? "song" == l ? U("#like_song_box").html(a) : "playlist" == l ? U("#like_playlist_box").html(a) : "album" == l ? U("#like_album_box").html(a) : "mv" == l && U("#like_mv_box").html(a) : "uploadmv" == i ? U("#uploadmv_box").html(a) : "magazine" == i && U("#magazine_box").html(a)
    }

    function u(i, l, a, t) {
        !t && d(i, l), l = l || "";
        var s = a || 1;
        Q[i + (l ? "_" + l : "")].cur_page = s;
        var e = Q[i + (l ? "_" + l : "")];
        if ("buy" == i) {
            var _, o = A.getUin(), u = (e.cur_page - 1) * e.per_page, m = e.per_page;
            "album" == l ? _ = "//c.y.qq.com/shop/fcgi-bin/fcg_get_order?from=1&cmd=sales_album&type=1&guest_uin=&callback=MusicJsonCallback&start=" + u + "&num=" + m + "&uin=" + o + "&t=" + (new Date).getTime() : "song" == l ? _ = "//c.y.qq.com/shop/fcgi-bin/fcg_get_order?from=1&cmd=sales_album&type=2&guest_uin=&callback=MusicJsonCallback&start=" + u + "&num=" + m + "&uin=" + o + "&t=" + (new Date).getTime() : "peri" == l && (_ = "//c.y.qq.com/shop/fcgi-bin/fcg_peri_order?uin=" + o + "&callback=MusicJsonCallback&type=5&start=" + u + "&num=" + m + "&t=" + (new Date).getTime()), N.jQueryAjax.jsonp({
                url: _,
                data: {},
                jsonpCallback: "MusicJsonCallback",
                charset: "utf-8",
                success: function (a) {
                    return 1e3 == a.code ? (A.openLogin(), void 0) : (c(a, i, l), void 0)
                },
                error: function () {
                }
            })
        } else if ("create" == i) {
            var _ = "//c.y.qq.com/rsc/fcgi-bin/fcg_user_created_diss?hostuin=" + L + "&sin=" + (e.per_page * (e.cur_page - 1) + (e.cur_page > 1 ? $ : 0)) + "&size=" + (e.per_page + (1 == e.cur_page ? 2 : 0)) + "&r=" + (new Date).getTime();
            T.jsonp({
                url: _, charset: "utf-8", success: function (a) {
                    if (1e3 == a.code)return A.openLogin(), void 0;
                    if (0 == a.code && a.data && a.data.disslist) {
                        if (1 == e.cur_page)if (A.isWeiXin()) {
                            var t = [];
                            U.each(a.data.disslist, function (i, l) {
                                205 != l.dirid && 206 != l.dirid && t.push(l)
                            }), a.data.disslist = t, $ = 2
                        } else {
                            var t = [];
                            U.each(a.data.disslist, function (i, l) {
                                l.dirid > 200 && l.dirid < 210 ? H ? parseInt(l.song_cnt) > 0 ? t.push(l) : $++ : l.dirid > 200 && l.dirid < 210 && parseInt(l.song_cnt) > 0 ? t.push(l) : $++ : t.push(l)
                            }), a.data.disslist = t
                        }
                        c(a, i, l)
                    } else U("#create_box").html(B({})), N.popup.show("服务器繁忙，请稍后再试！")
                }, error: function () {
                    U("#create_box").html(B({})), N.popup.show("服务器繁忙，请稍后再试！")
                }
            })
        } else if ("fans" == i) J.getList({
            uin: L,
            start: (e.cur_page - 1) * e.per_page,
            num: e.per_page,
            type: 1
        }, function (a) {
            for (var t = [], s = 0; s < a.list.length; s++) {
                var e = a.list[s];
                e.logo || t.push(e.encrypt_uin || e.uin)
            }
            c(a, i, l, function () {
                n(t)
            })
        }); else if ("focus" == i) "singer" == l ? R.getList(L, function (a) {
            c(a, i, l)
        }, function () {
        }, e.cur_page, e.per_page) : "user" == l && J.getList({
                uin: L,
                start: (e.cur_page - 1) * e.per_page,
                num: e.per_page
            }, function (a) {
                for (var t = [], s = 0; s < a.list.length; s++) {
                    var e = a.list[s];
                    e.logo || t.push(e.encrypt_uin || e.uin)
                }
                c(a, i, l, function () {
                    n(t)
                })
            }); else if ("like" == i) a > 0 || (a = 1), myFav_type = l, myFav_page = a, r(l, a, function (a, t) {
            Q["like_" + l].total_num = t, c(a, i, l, function () {
            })
        }); else if ("uploadmv" == i) {
            var p = B({desc: "还没有上传视频... "});
            if (H)var p = '<div class="playlist_toolbar"><button class="mod_btn js_goto_uploadmv" data-stat="y_new.profile.create_playlist.goto_uploadmv"><i class="mod_btn__icon_new"></i>上传视频</button><button class="mod_btn js_uploadmv_system" data-stat="y_new.profile.create_playlist.uploadmv_system"><i class="mod_btn__icon_input"></i>视频管理</button> </div><div class="mod_mv_list">' + B({desc: "还没有上传视频... "}) + "</div>";
            y(function (a) {
                0 == a.code && a.data && a.data.total && a.data.mvlist && a.data.mvlist.length > 0 ? c(a.data, i, l, function () {
                }) : U("#uploadmv_box").html(p)
            }, function () {
                U("#uploadmv_box").html(p)
            })
        } else if ("magazine" == i) {
            var p = "";
            H ? (p = '<a href="//y.qq.com/portal/headline/editor.html" rel="noopener nofollow" target="_blank" class="mod_btn mod_btn_add_article" data-stat="y_new.profile.create_playlist.goto_magazine"><i class="mod_btn__icon_new"></i>发表文章</a><a href="//y.qq.com/portal/headline/manage.html" rel="noopener nofollow" target="_blank" class="mod_btn mod_btn_manage_article" data-stat="y_new.profile.create_playlist.manage_magazine"><i class="mod_btn__icon_upload"></i>文章管理</a><div class="mod_mv_list">' + B({desc: "还没有发表文章... "}) + "</div>", w(function (a) {
                0 == a.code && a.magzine && 0 == a.magzine.code && a.magzine.data && a.magzine.data.v_magzine.length > 0 ? c(a.magzine.data, i, l, function () {
                }) : U("#magazine_box").html(p)
            }, function () {
                U("#magazine_box").html(p)
            })) : U("#magazine_box").html("")
        } else"radio" == i && U("#radio_box").show()
    }

    function m(i, l) {
        setTimeout(function () {
            T.jsonp({
                url: "//c.y.qq.com/rsc/fcgi-bin/3g_fav_lock?rnd=" + Math.random(),
                data: {cid: 339, chloginstyle: 1, qq: P, lock: i, rettype: 20, ct: 19, cv: "yqq"},
                charset: "utf-8",
                success: function (i) {
                    i && 0 == i.code ? l && l(i) : N.popup.show("操作失败！当前网络繁忙，请稍后重试。", 3e3, 1)
                },
                error: function () {
                    N.popup.show("操作失败！当前网络繁忙，请稍后重试。", 3e3, 1)
                }
            })
        }, 1)
    }

    function p(i, a, t, s) {
        l.async("js/common/dialog.js", function (l) {
            l.show({
                mode: "common",
                title: "QQ音乐",
                icon_type: 2,
                sub_title: i,
                desc: a,
                button_info1: {
                    highlight: 1, title: t || "确定", fn: function () {
                        l.hide(), s && s()
                    }
                },
                button_info2: {
                    highlight: 0, title: "取消", fn: function () {
                        l.hide()
                    }
                }
            })
        })
    }

    function g() {
    }

    function h(i) {
        p("确定要删除该歌单？ ", "删除后收藏该歌单的用户将无法访问！", null, function () {
            l.async("js/common/fav.js", function (l) {
                l.del(i, function () {
                    Q.create.init = !1, C()
                })
            })
        })
    }

    function f(i) {
        p("确定要取消收藏该歌单？ ", null, null, function () {
            var l, a = {uin: A.getUin(), ordertype: 0, optype: 2, dissid: i, from: 1};
            l = new N.FormSender("//c.y.qq.com/folder/fcgi-bin/fcg_qm_order_diss.fcg", "post", a, "gb2312"), l.onSuccess = function (i) {
                0 == i.ret ? (I.show("删除成功！", 2e3), Q.like_playlist.init = !1, C()) : I.show("网络繁忙，请稍后再试。", 2e3, 1)
            }, l.onError = g, l.send()
        })
    }

    function v(i, l) {
        p("确定要取消收藏该专辑？ ", null, null, function () {
            var a, t = {uin: A.getUin(), ordertype: 1, optype: 2, albumid: i, albummid: l, from: 1};
            a = new N.FormSender("//c.y.qq.com/folder/fcgi-bin/fcg_qm_order_diss.fcg", "post", t, "gb2312"), a.onSuccess = function (i) {
                0 == i.ret ? (I.show("删除成功！", 2e3), Q.like_album.init = !1, C()) : I.show("网络繁忙，请稍后再试。", 2e3, 1)
            }, a.onError = g, a.send()
        })
    }

    function y(i, l) {
        var a = {cmd: 3, uin: L, sin: (Q.uploadmv.cur_page - 1) * Q.uploadmv.per_page, size: Q.uploadmv.per_page};
        N.jQueryAjax.json({
            url: "//c.y.qq.com/mv/fcgi-bin/fcg_ugc_mv_list.fcg",
            data: a,
            charset: "utf-8",
            success: function (l) {
                i && i(l)
            },
            error: function () {
                l && l()
            }
        })
    }

    function b(i) {
        return i.indexOf("&") > -1 || i.indexOf("+") > -1 || i.indexOf('"') > -1 || i.indexOf("#") > -1 || i.indexOf("=") > -1 || i.indexOf("%") > -1 || i.indexOf("<") > -1 || i.indexOf(">") > -1 || i.indexOf("\\") > -1 ? (N.popup.show('输入错误！输入的内容中请不要使用+, &, #, %, ", =, \\, <, >等特殊字符.', 3e3, 1), !1) : !0
    }

    function j(i, l, a) {
        var t = "getMagzine" + (Math.random() + "").replace("0.", "");
        T.jsonp({
            url: "//u.y.qq.com/cgi-bin/musicu.fcg?callback=" + t,
            data: {data: JSON.stringify(i)},
            jsonpCallback: t,
            charset: "utf-8",
            success: function (i) {
                l && l(i)
            },
            error: function () {
                a && a(null)
            }
        })
    }

    function w(i, l) {
        var a = {
            magzine: {
                method: "get_author_magzine_list",
                param: {
                    fieldtype: 2,
                    ordertype: 1,
                    versiontype: 1,
                    uin: A.isWeiXin() ? 0 : L,
                    suin: A.isWeiXin() ? L : "" + L,
                    sin: (Q.magazine.cur_page - 1) * Q.magazine.per_page,
                    size: Q.magazine.per_page,
                    level: [200, 300, 400],
                    status: [100, 200]
                },
                module: "magzine.MagzineReadServer"
            }
        };
        j(a, i, l)
    }

    function x(i, l) {
        if (!(i in O))return !1;
        var a = O[i], t = {};
        U.extend(t, {
            title: a.title,
            content_brief: a.content_brief,
            author: a.author,
            front_pic: a.front_pic,
            rend_style: a.rend_style,
            head_raw_pic: a.head_raw_pic,
            head_pic: a.head_pic,
            head_word: a.head_word,
            content: a.content,
            v_media_type: a.v_media_type,
            v_media_subtype: a.v_media_subtype,
            v_media_id: a.v_media_id,
            v_media_mid: a.v_media_mid,
            status: a.status,
            cmd: "preview",
            zid: i
        }), T.post({
            url: "//c.y.qq.com/rsc/fcgi-bin/fcg_write_magzine.fcg",
            data: t,
            charset: "utf-8",
            success: function (i) {
                i = JSON.parse(i), l && l(i)
            },
            error: function () {
                l && l(null)
            }
        })
    }

    function k() {
        if (!H)return !1;
        var i = {magzine: {method: "get_identity", param: {uin: A.getUin()}, module: "magzine.MagzineUtilityServer"}};
        j(i, function (i) {
            i && i.magzine && 0 == i.magzine.code && i.magzine.data && i.magzine.data.is_invited && 1 == i.magzine.data.is_invited ? 0 == U("#magazine_tab").length && U("#uploadmv_tab").after('<a class="mod_tab__item" href="javascript:;" id="magazine_tab" data-tab="magazine" data-stat="y_new.profile.tab.magazine">我的专栏</a>') : U("#magazine_box").html("")
        }, function () {
        })
    }

    function q() {
        var i = {cmd: 9, hostuin: L, cid: 205362273}, l = "getRadioData" + (Math.random() + "").replace("0.", "");
        T.jsonp({
            url: "//c.y.qq.com/rsc/fcgi-bin/fcg_ugc_radio_pro.fcg?callback=" + l,
            data: i,
            jsonpCallback: l,
            charset: "utf-8",
            success: function (i) {
                i && 0 == i.code && i.data && i.data.showtab && (U("#radio_tab").show(), c(i.data.radiolist || [], "radio"))
            },
            error: function () {
            }
        })
    }

    function z() {
        H && U(".main").addClass("main--profile"), e(function () {
            var i = N.util.getParameterNew("tab") || "like", l = N.util.getParameterNew("sub") || "";
            i in E || "gedan" == i && (i = "like"), U(".mod_tab__item", U("#nav")).removeClass("mod_tab__current"), U("#" + i + "_tab").addClass("mod_tab__current"), 1 == E[i] ? l = null : l in E[i] || (l = E[i]["default"]), l ? (U(".js_sub", "#" + i + "_box").hide(), U(".mod_tab__item", U("#" + i + "_box")).removeClass("mod_tab__current"), U('.mod_tab__item[data-tab="' + i + "_" + l + '"]').addClass("mod_tab__current"), U("#" + i + "_" + l + "_box").show(), !Q[i + "_" + l].init && u(i, l), "focus" == i && H ? "user" == l ? A.isWeiXin() ? U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多好友').hide() : U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多好友').show() : U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多歌手').show() : U(".js_focus_friends").hide()) : !Q[i].init && u(i, l), U(".js_box").hide(), U("#" + i + "_box").show()
        }), U("body").off().on("click", ".js_profile", function () {
            var i = U(this).data("uin");
            N.util.gotoUser({uin: i, target: "_self"})
        }).on("click", ".js_vip", function () {
            var i = U(this).data("href"), l = window.open(i, "_blank");
            return l && (l.opener = null), M.pgvClickStat("y_new.profile.header.icon_click"), !1
        }).on("click", ".js_singer", function () {
            var i = U(this).data("mid"), l = U(this).data("target");
            N.util.gotoSinger({singermid: i, target: l})
        }).on("click", ".js_btn_lock", function () {
            var i = this, l = "0" == this.getAttribute("data-status") ? 1 : 2;
            return m(l, function () {
                2 == l ? (i.setAttribute("data-status", "0"), U(i).html('<span class="icon_txt">主页已公开</span>').attr("title", "主页已公开").removeClass("btn_unlock").addClass("btn_lock"), N.popup.show("主页已公开!", 3e3)) : (i.setAttribute("data-status", "1"), U(i).html('<span class="icon_txt">主页非公开</span>').attr("title", "主页非公开").removeClass("btn_lock").addClass("btn_unlock"), N.popup.show("主页非公开!", 3e3))
            }), !1
        }).on("click", ".js_follow_singer", function () {
            var i = this, l = this.getAttribute("data-id"), a = 1 == this.getAttribute("data-follow") ? 0 : 1;
            return l && !R.delLock && (R.delLock = !0, R.add({singerid: l, status: a, uin: P}, function (l) {
                if (R.delLock = !1, l && 0 == l.code) {
                    var t = U(".js_user_data .js_num_follow").text().replace(/\(|\)/g, "");
                    0 > t && (t = 0), 0 == a ? (N.popup.show("取消关注成功！", 3e3), U(i).html('<i class="mod_btn__icon_new"></i>关注'), U(i).attr("data-follow", 0), H && (U(".popup_user .js_focus").html(parseInt(t) - 1), U(".js_user_data .js_num_follow").text(parseInt(t) - 1))) : (N.popup.show("关注成功！", 3e3), U(i).html('<span class="btn_focus__cont"><i class="mod_btn__icon_yes"></i>已关注</span>'), U(i).attr("data-follow", 1), H && (U(".popup_user .js_focus").html(parseInt(t) + 1), U(".js_user_data .js_num_follow").text(parseInt(t) + 1)))
                } else N.popup.show("操作失败！", 3e3, 1)
            })), !1
        }).on("click", ".js_follow_user", function () {
            var i = this, l = this.getAttribute("data-id"), a = 1 == this.getAttribute("data-follow") ? 0 : 1;
            return 1e4 > P && A.openLogin(null, function () {
                location.reload()
            }), l && J.doFollow({my_uin: P, friend_uin: l, status: a}, function (l) {
                if (l && 0 == l.code) {
                    var t = parseInt(U(".js_user_data .js_num_follow").text().replace(/\(|\)/g, ""));
                    0 > t && (t = 0), 0 == a ? (N.popup.show("取消关注成功！", 3e3), U(i).html('<i class="mod_btn__icon_new"></i>关注'), U(i).attr("data-follow", 0), H && (U(".popup_user .js_focus").html(parseInt(t) - 1), U(".js_user_data .js_num_follow").text(parseInt(t) - 1))) : (N.popup.show("关注成功！", 3e3), U(i).html('<span class="btn_focus__cont"><i class="mod_btn__icon_yes"></i>已关注</span>'), U(i).attr("data-follow", 1), H && (U(".popup_user .js_focus").html(t + 1), U(".js_user_data .js_num_follow").text(t + 1)))
                } else N.popup.show("操作失败！", 3e3, 1);
                S()
            }), !1
        }).off("click", ".js_create_new").on("click", ".js_create_new", function () {
            function i() {
                var i = 20, l = U("#new_playlist"), a = U("#name_leftnum"), t = N.string.getRealLen(l.val());
                t = Math.ceil(t / 2), i >= t ? (a.html(i - t), a.css({color: "#999"})) : (a.html("-" + (t - i)), a.css({color: "#F70505"}))
            }

            l.async("js/common/dialog.js", function (i) {
                i.show({
                    mode: "common",
                    width: 520,
                    dialogclass: "popup_new_list",
                    content: ['<label class="form__label">歌单名</label>', ' <div class="mod_form_txt">', ' <input type="text" value="" class="form_txt__input" id="new_playlist"><span class="form_txt__tips" id="name_leftnum">20</span>', "</div>"].join(""),
                    title: "创建新歌单",
                    button_info1: {
                        highlight: 0, fn: function () {
                            i.hide()
                        }, title: "取消"
                    },
                    button_info2: {
                        highlight: 1, fn: function () {
                            if ("" == U("#new_playlist").val())return N.popup.show("请输入歌单名！", 3e3, 1), void 0;
                            if (b(U("#new_playlist").val()))return parseInt(U("#name_leftnum").html()) < 0 ? (N.popup.show("歌单名最多20个字！", 3e3, 1), void 0) : (l.async("js/common/fav.js", function (l) {
                                var a = {moddirnames: U("#new_playlist").val(), moddirids: 0};
                                l.favToNew(a, function () {
                                    i.hide(), N.popup.show("已成功添加到新建歌单"), Q.like_song.init = !1, C()
                                })
                            }), void 0)
                        }, title: "确定"
                    }
                })
            });
            var a = U(this).data("stat") || "";
            a && M.pgvClickStat(a), U(document).on("keyup input propertychange", "#new_playlist", function () {
                i()
            })
        }).on("click", ".js_import", function () {
            var i = U(this).data("stat") || "";
            i ? (setStatCookie && setStatCookie(), window.location.href = location.protocol + "//y.qq.com/portal/songlist_import.html#stat=" + i) : window.location.href = location.protocol + "//y.qq.com/portal/songlist_import.html"
        }).on("click", ".js_recover", function () {
            var i = U(this).data("stat") || "";
            i ? (setStatCookie && setStatCookie(), window.location.href = location.protocol + "//y.qq.com/portal/list_recover.html#stat=" + i) : window.location.href = location.protocol + "//y.qq.com/portal/list_recover.html"
        }).off("click", ".js_delfav_song").on("click", ".js_delfav_song", function () {
            var i = this;
            p("确定要取消收藏该歌曲？ ", null, null, function () {
                var l, a = U(i), t = {
                    uin: A.getUin(),
                    formsender: 1,
                    flag: 2,
                    from: 3,
                    source: 103,
                    ids: a.data("id"),
                    types: 3,
                    dirid: 201
                };
                a.data("type") && (t.types = a.data("type")), l = new N.FormSender("//c.y.qq.com/qzone/fcg-bin/fcg_music_delbatchsong.fcg", "post", t, "GB2312"), l.onSuccess = function (i) {
                    0 == i.code ? (I.show("删除成功！", 2e3), Q.like_song.init = !1, C()) : I.show("网络繁忙，请稍后再试。", 2e3, 1)
                }, l.onError = g, l.send()
            })
        }).off("click", ".js_delfav_album").on("click", ".js_delfav_album", function () {
            var i = U(this).data("id"), l = U(this).data("mid");
            v(i, l)
        }).on("delfav_album", "", function (i, l) {
            v(l.id, l.mid)
        }).off("click", ".js_delfav_gedan").on("click", ".js_delfav_gedan", function () {
            var i = U(this).data("id");
            f(i)
        }).on("delfav_gedan", "", function (i, l) {
            f(l.id)
        }).off("click", ".js_delfav_mv").on("click", ".js_delfav_mv", function () {
            var i = this;
            p("确定要取消收藏该MV？ ", null, null, function () {
                var l = new N.FormSender("//c.y.qq.com/mv/fcgi-bin/fcg_mvlist_mod.fcg", "post", {
                    uin: A.getUin(),
                    formsender: 1,
                    mvrmid: U(i).data("id")
                }, "gb2312");
                l.onSuccess = function (i) {
                    0 == i.code ? (I.show("删除成功！", 2e3), Q.like_mv.init = !1, C()) : I.show("网络繁忙，请稍后再试。", 2e3, 1)
                }, l.onError = g, l.send()
            })
        }).off("click", ".js_delcreate_gedan").on("click", ".js_delcreate_gedan", function () {
            var i = U(this).data("dirid");
            h(i)
        }).on("delcreate_gedan", "", function (i, l) {
            h(l.dirid)
        }).on("click", ".js_focus_friends", function () {
            return "singer" == N.util.getParameterNew("sub") ? window.location.href = location.protocol + "//y.qq.com/portal/singer_list.html" : l.async("js/v4/mymusic_friend.js", function (i) {
                i.init()
            }), M.pgvClickStat("y_new.profile.focus.addmore"), !1
        }).on("click", ".js_goto_uploadmv", function () {
            var i = window.open(location.protocol + "//y.qq.com/portal/mv/mv_upload.html");
            i && (i.opener = null)
        }).on("click", ".js_uploadmv_system", function () {
            var i = window.open(location.protocol + "//y.qq.com/portal/mv/mv_upload_system.html");
            i && (i.opener = null)
        }).on("click", ".js_add_magazine", function () {
            var i = window.open(location.protocol + "//y.qq.com/portal/headline/editor.html");
            i && (i.opener = null)
        }).on("click", ".js_manage_magazine", function () {
            var i = window.open(location.protocol + "//y.qq.com/portal/headline/manage.html");
            i && (i.opener = null)
        }).on("click", ".js_magazine_preview_qrcode", function () {
            U(".js_preview_qrcode_popup").hide();
            var i = U(this).parent("div.article__view"), l = U("div.popup_phone_qrcode", i),
                a = U(this).parents("tr").data("zid");
            if ("查看" == U(this).html().trim()) {
                var t = "//c.y.qq.com/tplcloud/fcgi-bin/fcg_get_2dcode.fcg?width=200&margin=1&eclevel=4&encode=1&url=" + encodeURIComponent(location.protocol + "//c.y.qq.com/node/m/client/music_headline/index.html?_hidehd=1&_button=2&zid=" + a);
                U("img", l).attr("src", t), l.show()
            } else x(a, function (i) {
                if (0 == i.code && i.data && i.data.zid > 0) {
                    var a = "//c.y.qq.com/tplcloud/fcgi-bin/fcg_get_2dcode.fcg?width=200&margin=1&eclevel=4&encode=1&url=" + encodeURIComponent(location.protocol + "//c.y.qq.com/node/m/client/music_headline/index.html?_hidehd=1&_button=2&test=1&zid=" + i.data.zid);
                    U("img", l).attr("src", a), l.show()
                }
            })
        }).on("click", ".js_radio", function () {
            var i = U(this).data("albummid");
            i && (location.href = location.protocol + "//y.qq.com/n/yqq/album/" + i + ".html?pagetype=radio")
        }), U(document).on("click", "body", function (i) {
            var l = N.util.getTarget(i);
            0 != U(l).parents(".js_magazine_preview_qrcode").length || U(l).hasClass("js_magazine_preview_qrcode") || U(".js_preview_qrcode_popup").hide()
        }), U(document).off("click", ".mod_tab__item,.js_tab").on("click", ".mod_tab__item,.js_tab", function () {
            var i = U(this).data("tab").split("_"), l = i.length > 0 ? i[0] : "like", a = i.length > 1 ? i[1] : "";
            K[l](a);
            var t = U(this).data("stat") || "";
            t && M.pgvClickStat(t)
        }).off("click", ".style_switch__item").on("click", ".style_switch__item", function () {
            if (U(this).hasClass("style_switch__item--select"))return !1;
            var i = U(this).parents(".js_sub");
            0 == i.length && (i = U(this).parents(".js_box")), U(".style_switch__item", i).removeClass("style_switch__item--select"), U(this).addClass("style_switch__item--select");
            var l = U(this).data("type"), a = U(this).data("tab");
            U(".js_list", i).hide(), U("." + l, i).show(), Q[a].showtype = l;
            var t = [];
            t.push("mod_playlist_text" == Q.like_playlist.showtype ? 0 : 1), t.push("mod_playlist_text" == Q.like_album.showtype ? 0 : 1), t.push("mod_playlist_text" == Q.create.showtype ? 0 : 1), D.set("portal_profile", t.join(","));
            var s = U(this).data("stat") || "";
            s && M.pgvClickStat(s)
        })
    }

    function S() {
        Q.focus_user.init = !1, u("focus", "user")
    }

    function C(i) {
        var l = !1;
        i || (l = !0), i = i || N.util.getUrlParams();
        var a = i.uin || P;
        if (L != a)return window.location.reload(), void 0;
        var t = i.tab || "like", s = i.sub;
        U(".mod_tab__item", U("#nav")).removeClass("mod_tab__current"), U("#" + t + "_tab").addClass("mod_tab__current"), "buy" == t && "song" == s && U(".js_delfav_song").hide(), "focus" == t && H ? "user" == s ? A.isWeiXin() ? U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多好友').hide() : U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多好友').show() : U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多歌手').show() : U(".js_focus_friends").hide(), 1 == E[t] ? s = null : s in E[t] || (s = E[t]["default"]), s ? (U(".js_sub", "#" + t + "_box").hide(), U(".mod_tab__item", U("#" + t + "_box")).removeClass("mod_tab__current"), U('.mod_tab__item[data-tab="' + t + "_" + s + '"]').addClass("mod_tab__current"), U("#" + t + "_" + s + "_box").show(), !Q[t + "_" + s].init && u(t, s, Q[t + "_" + s].cur_page, l), "focus" == t && ("user" == s ? A.isWeiXin() ? U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多好友').hide() : U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多好友').show() : U(".js_focus_friends").html('<i class="mod_btn__icon_new"></i>关注更多歌手'))) : !Q[t].init && u(t, s, Q[t].cur_page, l), U(".js_box").hide(), U("#" + t + "_box").show();
        var n = i.stat;
        n && M.pgvClickStat(n)
    }

    var N = l("js/common/music.js"), U = N.$, M = N.statistics, T = N.jQueryAjax;
    window.MUSIC = N;
    var A = N.widget.user, I = N.popup, D = l("js/common/music/storage.js"), L = N.util.getParameterNew("uin");
    1e4 >= L && (L = "");
    var F, O = {}, P = 0, H = !0, E = {
        like: {"default": "song", song: 1, playlist: 1, album: 1, mv: 1},
        buy: {"default": "song", album: 1, song: 1, peri: 1},
        create: 1,
        focus: {"default": "singer", singer: 1, user: 1},
        fans: 1,
        uploadmv: 1,
        magazine: 1,
        radio: 1
    }, V = {
        like_song: 0,
        like_playlist: 0,
        like_album: 0,
        like_mv: 0,
        follow: 0,
        fans: 0,
        uploadmv: 0,
        magazine: 0,
        radio: 0
    }, Q = {
        like_song: {cur_page: 1, per_page: 30, total_page: 1, total_num: 0, max_num: 420, init: !1},
        like_playlist: {
            cur_page: 1,
            per_page: 25,
            total_page: 1,
            total_num: 0,
            max_num: 100,
            init: !1,
            showtype: "mod_playlist_text"
        },
        like_album: {
            cur_page: 1,
            per_page: 15,
            total_page: 1,
            total_num: 0,
            max_num: 100,
            init: !1,
            showtype: "mod_playlist_text"
        },
        like_mv: {cur_page: 1, per_page: 30, total_page: 1, total_num: 0, max_num: 100, init: !1},
        buy_album: {cur_page: 1, per_page: 30, total_page: 1, total_num: 0, max_num: 100, init: !1},
        buy_song: {cur_page: 1, per_page: 30, total_page: 1, total_num: 0, max_num: 100, init: !1},
        buy_peri: {cur_page: 1, per_page: 30, total_page: 1, total_num: 0, max_num: 100, init: !1},
        create: {
            cur_page: 1,
            per_page: 30,
            total_page: 1,
            total_num: 0,
            max_num: 100,
            init: !1,
            showtype: "mod_playlist_text"
        },
        focus_singer: {cur_page: 1, per_page: 30, total_page: 1, total_num: 0, max_num: 100, init: !1},
        focus_user: {cur_page: 1, per_page: 30, total_page: 1, total_num: 0, max_num: 100, init: !1},
        fans: {cur_page: 1, per_page: 30, total_page: 1, total_num: 0, max_num: 100, init: !1},
        uploadmv: {cur_page: 1, per_page: 28, total_page: 1, total_num: 0, max_num: 100, init: !1},
        magazine: {cur_page: 1, per_page: 28, total_page: 1, total_num: 0, max_num: 100, init: !1},
        radio: {cur_page: 1, per_page: 28, total_page: 1, total_num: 0, max_num: 100, init: !1}
    }, R = {
        _cacheList: null, delLock: !1, getList: function (i, l, a, t, s) {
            function n() {
                "function" == typeof a ? a() : N.popup.show("获取关注歌手列表失败！当前网络繁忙，请稍后重试。", 3e3, 1)
            }

            var e = this, r = "//c.y.qq.com/rsc/fcgi-bin/fcg_order_singer_getlist.fcg?utf8=1&uin=" + i;
            "undefined" != typeof t && (t = t || 1, r = "//c.y.qq.com/rsc/fcgi-bin/fcg_order_singer_getlist.fcg?utf8=1&page=" + t + "&perpage=" + s + "&uin=" + i), T.jsonp({
                url: r + "&rnd=" + Math.random(),
                success: function (i) {
                    return 0 != i.code ? (-1e3 == i.code || 1e3 == i.code ? N.widget.user.openLogin() : n(), void 0) : (e._cacheList = i.list, "undefined" != typeof t ? l(i) : l(i.list), void 0)
                },
                error: n
            })
        }, add: function (i, l) {
            i.formsender = 1;
            var a = "//c.y.qq.com/rsc/fcgi-bin/fcg_order_singer_add.fcg";
            0 == i.status && (a = "//c.y.qq.com/rsc/fcgi-bin/fcg_order_singer_del.fcg");
            var t = new N.FormSender(a, "post", {singerid: i.singerid, uin: i.uin, formsender: i.formsender}, "gb2312");
            t.onSuccess = function (i) {
                l && l(i)
            }, t.onError = function () {
            }, t.send()
        }, delCache: function (i) {
            if (this._cacheList) {
                for (var l = [], a = 0, t = this._cacheList.length; t > a; a++) {
                    var s = this._cacheList[a];
                    s.id != i && l.push(s)
                }
                this._cacheList = l
            }
        }
    }, J = {
        _cacheList: null, getList: function (i, l) {
            function a() {
                N.popup.show("获取粉丝列表失败！当前网络繁忙，请稍后重试。", 3e3, 1)
            }

            var t = i.type || 0, s = i.start || 0, n = i.num || 20,
                e = "//c.y.qq.com/rsc/fcgi-bin/friend_follow_or_listen_list.fcg?utf8=1&start=" + s + "&num=" + n + "&is_listen=" + t + "&uin=" + i.uin + "&rnd=" + Math.random();
            T.jsonp({
                url: e, charset: "utf-8", success: function (i) {
                    return 0 != i.retcode ? (a(), void 0) : (l(i), void 0)
                }, error: a
            })
        }, delCache: function (i) {
            if (this._cacheList) {
                for (var l = [], a = 0, t = this._cacheList.length; t > a; a++) {
                    var s = this._cacheList[a];
                    s.id != i && l.push(s)
                }
                this._cacheList = l
            }
        }, doFollow: function (i, l) {
            function a() {
                "function" == typeof errCallback ? errCallback() : N.popup.show("当前网络繁忙，请稍后重试。", 3e3, 1)
            }

            i.formsender = 1;
            var t = "//c.y.qq.com/rsc/fcgi-bin/add_attention_status.fcg", s = new N.FormSender(t, "post", i, "gb2312");
            s.onSuccess = function (i) {
                l && l(i)
            }, s.onError = a, s.send()
        }
    }, W = 0, X = (Q.like_song.per_page, Q.like_playlist.per_page, Q.like_mv.per_page), Y = function (i) {
        {
            var l, a = "";
            Array.prototype.join
        }
        if (a += '\r\n            <div class="mod_singer_list mod_singer_list--fans">\r\n                <ul class="singer_list__list">\r\n	', i.list && i.list.length > 0 && !i.list[0].mid) {
            a += "\r\n		";
            for (var t = 0, s = i.list.length; s > t; t++) {
                var n = i.list[t];
                a += '\r\n                    <li class="singer_list__item">\r\n                        <div class="singer_list__item_box">\r\n                            <a href="//y.qq.com/portal/profile.html?uin=' + (null == (l = n.encrypt_uin || n.uin) ? "" : l) + '" class="singer_list__cover js_profile" hidefocus="true" data-uin="' + (null == (l = n.encrypt_uin || n.uin) ? "" : l) + '">\r\n                                <img class="singer_list__pic ' + (null == (l = "" != n.logo ? "" : "need_avatar") ? "" : _.escape(l)) + '" src="' + (null == (l = "" != n.logo ? n.logo : "//y.gtimg.cn/mediastyle/global/img/person_300.png?max_age=31536000") ? "" : _.escape(l)) + '" alt="' + (null == (l = n.nick_name) ? "" : _.escape(l)) + '">\r\n                            </a>\r\n                            <h3 class="singer_list__title"><a href="//y.qq.com/portal/profile.html?uin=' + (null == (l = n.encrypt_uin || n.uin) ? "" : l) + '" data-uin="' + (null == (l = n.encrypt_uin || n.uin) ? "" : l) + '" class="js_profile" title="' + (null == (l = n.nick_name) ? "" : _.escape(l)) + '">' + (null == (l = "" == n.nick_name ? "无" : n.nick_name) ? "" : _.escape(l)) + '</a></h3>\r\n                            <p class="singer_list__info">' + (null == (l = n.listen_num) ? "" : l) + '人关注</p>\r\n                            <div class="singer_list__focus">\r\n                                <a href="javascript:;" class="mod_btn singer_list__btn_focus js_follow_user" data-follow=\'' + (null == (l = n.is_follow) ? "" : l) + "' data-id='" + (null == (l = n.encrypt_uin || n.uin) ? "" : l) + "'>\r\n				", a += n.is_follow ? '\r\n					<span class="btn_focus__cont"><i class="mod_btn__icon_yes"></i>已关注</span>\r\n				   ' : '\r\n					<i class="mod_btn__icon_new"></i>关注\r\n				   ', a += "\r\n                                </a>\r\n                            </div>\r\n                        </div>\r\n                    </li>\r\n		"
            }
            a += "\r\n	 "
        } else {
            a += "\r\n	 \r\n		";
            for (var t = 0, s = i.list.length; s > t; t++) {
                {
                    var n = i.list[t], e = n.mid + "", r = e.length;
                    [e[r - 2], e[r - 1], e].join("/")
                }
                a += '\r\n                    <li class="singer_list__item">\r\n                        <div class="singer_list__item_box">\r\n                            <a href="' + (null == (l = N.util.getSingerUrl(n)) ? "" : l) + '" class="singer_list__cover js_singer" hidefocus="true" data-mid="' + (null == (l = n.mid) ? "" : l) + '" data-id="' + (null == (l = n.id) ? "" : l) + '">\r\n                                <img class="singer_list__pic" src="//y.gtimg.cn/music/photo_new/T001R150x150M000' + (null == (l = n.mid) ? "" : l) + '.jpg?max_age=2592000" onerror="this.src=\'//y.gtimg.cn/mediastyle/global/img/singer_300.png?max_age=31536000\';this.error=null;" alt="' + (null == (l = n.name) ? "" : _.escape(l)) + '">\r\n                            </a>\r\n                            <h3 class="singer_list__title"><a href="' + (null == (l = N.util.getSingerUrl(n)) ? "" : l) + '" data-mid="' + (null == (l = n.mid) ? "" : l) + '" data-id="' + (null == (l = n.id) ? "" : l) + '" class="js_singer" title="' + (null == (l = n.name) ? "" : _.escape(l)) + '">' + (null == (l = "" == n.name ? "无" : n.name) ? "" : _.escape(l)) + '</a></h3>\r\n			    <p class="singer_list__info">' + (null == (l = parseInt(n.num, 10) >= 1e4 ? ((n.num / 1e4).toFixed(1) + "万").replace(".0万", "万") : n.num) ? "" : l) + '人关注</p>\r\n                            <div class="singer_list__focus">\r\n                                <a href="javascript:;" class="mod_btn singer_list__btn_focus js_follow_singer" data-follow=\'' + (null == (l = n.is_follow) ? "" : l) + "' data-mid=\"" + (null == (l = n.mid) ? "" : l) + '" data-id="' + (null == (l = n.id) ? "" : l) + '">\r\n				', a += n.is_follow ? '\r\n					<span class="btn_focus__cont"><i class="mod_btn__icon_yes"></i>已关注</span>\r\n				   ' : '\r\n					<i class="mod_btn__icon_new"></i>关注\r\n				   ', a += "\r\n                                </a>\r\n                            </div>\r\n                        </div>\r\n                    </li>\r\n		"
            }
            a += "\r\n	 "
        }
        return a += "\r\n		</ul>\r\n	   </div>"
    }, B = function (i) {
        {
            var l, a = "";
            Array.prototype.join
        }
        return a += '<div class="">\r\n            <div class="none_txt">\r\n                <i class="none_txt__symbol"></i>\r\n		', a += i.desc ? "\r\n		<p>" + (null == (l = i.desc) ? "" : l) + "</p>\r\n		" : '\r\n                <p>什么也没有，去<a href="//y.qq.com">音乐馆</a>发现好音乐！</p>\r\n		', a += "\r\n            </div>\r\n        </div>"
    }, G = {
        config: {}, init: function (i) {
            var l = this;
            U.extend(l.config, i), reportType = i.reportType, l.show(), l.config.callback && l.config.callback()
        }, bindEvents: function () {
        }, show: function () {
            var i = this, l = Y, a = (i.config.specialTpl || l)({list: i.config.specilData});
            i.config.container.html(a).find("img").lazyload({effect: "fadeIn"}).show(), i.bindEvents()
        }
    }, $ = 0, K = {
        like: function (i) {
            i = i || "song", o("like", i)
        }, buy: function (i) {
            i = i || "album", o("buy", i)
        }, create: function () {
            o("create")
        }, focus: function (i) {
            i = i || "singer", o("focus", i)
        }, fans: function () {
            o("fans")
        }, uploadmv: function () {
            o("uploadmv")
        }, magazine: function () {
            0 == U("#magazine_tab").length ? o("like", "song") : o("magazine")
        }, radio: function () {
            U("#radio_tab").is(":hidden") ? o("like", "song") : o("radio")
        }
    }, Z = {
        init: function () {
            D.get("portal_profile", function (i) {
                if (i) {
                    var l = i.split(",");
                    Q.like_playlist.showtype = l.length > 0 ? parseInt(l[0], 10) > 0 ? "mod_playlist" : "mod_playlist_text" : "mod_playlist_text", Q.like_album.showtype = l.length > 1 ? parseInt(l[1], 10) > 0 ? "mod_playlist" : "mod_playlist_text" : "mod_playlist_text", Q.create.showtype = l.length > 2 ? parseInt(l[2], 10) > 0 ? "mod_playlist" : "mod_playlist_text" : "mod_playlist_text"
                }
                P = A.getUin(), L ? L != P && (H = !1) : L = P, A.getVipInfo(function () {
                    z()
                }, function () {
                    U("#before_page").remove(), U("#cgi_none_box").hide(), U(".js_mod_profile_unlogin").html('<div class="mod_profile_unlogin"><div class="section_inner"><h2 class="profile_unlogin__tit"><div class="icon_txt">听我喜欢听的歌</div></h2><div class="profile_unlogin__desc"></div><a href="javascript:;" data-stat="y_new.profile.login" class="mod_btn_green profile_unlogin__btn js_login">立即登录</a></div></div>').show(), setTimeout(function () {
                        U(".js_mod_profile_unlogin").addClass("play")
                    }, 10), U(".mod_profile, .main").hide()
                }), N.util.hashChangeInit(function (i) {
                    C(i)
                }), k(), q()
            })
        }
    };
    return Z
});