/*

[MatRoz Core Stylesheet]

Project: MatRoz - Material Design Agency and Business Template
Version: 2.2
Author : themelooks.com

*/

(function(a) {
  a(function() {
    var d = a(window);
    a("[data-bg-path]").each(function() {
      var b = a(this).data("bg-path");
      a(this).css("background-image", "url(" + b + ")")
    });
    var e = a("#topNav, .openNav"),
      f = function() {
        1 < d.scrollTop() ? e.addClass("sticky") : e.removeClass("sticky")
      };
    f();
    var g = a("#backToTop");
    a("#backToTop button").on("click", function() {
      a("html, body").animate({
        scrollTop: 0
      }, 500)
    });
    d.on("scroll", function() {
      f();
      1 < d.scrollTop() ? g.addClass("show") : g.removeClass("show")
    });
    a("[data-form-validation]").each(function() {
      a(this).find("form").validate({
        errorPlacement: function() {
          return !0
        }
      })
    });
    var h = a(".contact-form-status"),
      c = a("#contactForm");
    c.length && c.validate({
      rules: {
        contactName: "required",
        contactEmail: {
          required: !0,
          email: !0
        },
        contactMessage: "required"
      },
      errorPlacement: function(a, b) {
        return !0
      },
      submitHandler: function() {
        var b = a(this.currentForm),
          d = c.serialize();
        a.ajax({
          type: "POST",
          url: c.attr("action"),
          data: d
        }).done(function(a) {
          h.show().html(a).delay(3E3).fadeOut("slow");
          b[0].reset();
          b.find(".mdl-textfield, .mdl-textfield__input").removeClass("is-dirty valid")
        })
      }
    });
    var b, k;
    a("#map").length &&
      (k = {
        lat: 23.790546,
        lng: 90.375583
      }, b = new google.maps.Map(document.getElementById("map"), {
        center: k,
        zoom: 16,
        scrollwheel: !1,
        disableDefaultUI: !0,
        zoomControl: !0
      }), new google.maps.Marker({
        position: k,
        map: b,
        animation: google.maps.Animation.DROP,
        draggable: !0
      }));
    a(".map-toggle-btn").on("click", function() {
      a(this).toggleClass("opened")
    });
    b = a("#footerTwitter");
    b.length && twttr.widgets.createTimeline({
      sourceType: "profile",
      screenName: b.data("user-name")
    }, document.getElementById("footerTwitter"));
    b = a("#sidebarTwitter");
    b.length && twttr.widgets.createTimeline({
      sourceType: "profile",
      screenName: b.data("user-name")
    }, document.getElementById("sidebarTwitter"));
    b = document.createElement("script");
    b.async = !0;
    b.src = "https://embed.tawk.to/57dfd4b85dc7a25e92808cf6/default";
    b.charset = "UTF-8";
    b.setAttribute("crossorigin", "*");
    a(b).appendTo("body");
    b = a("#bgVideo .play-button");
    b.length && b.magnificPopup({
      delegate: "a",
      type: "iframe",
      mainClass: "my-mfp-zoom-in"
    });
    a(".portfolio-items").length && (a(".portfolio-img-link").magnificPopup({
      type: "image",
      gallery: {
        enabled: !0
      },
      mainClass: "my-mfp-zoom-in"
    }), a(".portfolio-details-link").magnificPopup({
      type: "ajax",
      mainClass: "my-mfp-zoom-in",
      callbacks: {
        ajaxContentAdded: function() {
          componentHandler.upgradeAllRegistered()
        }
      }
    }));
    a(".facts-number").length && a(".facts-number").counterUp({
      delay: 10,
      time: 1E3
    });
    a(".animatescroll > li > a").on("click", function(b) {
      b.preventDefault();
      b = a(this).attr("href");
      a(b).animatescroll({
        padding: 70,
        easing: "easeInOutExpo",
        scrollSpeed: 1E3
      })
    });
    a(".color-switcher").length && (a("#open-switcher").on("click",
        function() {
          a("#open-switcher").css("display", "none");
          a("#demo-colors").animate({
            right: "0px"
          }, 200, "linear", function() {
            a("#close-switcher").fadeIn(200)
          })
        }), a("#close-switcher").on("click", function() {
        a("#close-switcher").css("display", "none");
        a("#demo-colors").animate({
          right: "-202px"
        }, 200, "linear", function() {
          a("#open-switcher").fadeIn(200)
        })
      }), a("#buttonColors li").on("click", function() {
        a("#buttonColorScheme").attr("href", a(this).attr("data-path"));
        a(this).addClass("active").siblings().removeClass("active")
      }),
      a("#mainColors li").on("click", function() {
        a("#mainColorScheme").attr("href", a(this).attr("data-path"));
        a(this).addClass("active").siblings().removeClass("active")
      }));
    b = a(".SliderBgVideo");
    b.length && b.tubular({
      videoId: b.data("bg-video"),
      mute: !0,
      repeat: !0
    })
  });
  a(window).on("load", function() {
    var d = a(".header-items"),
      e = a(".team-items"),
      f = a(".feedback-items");
    d.length && d.owlCarousel({
      itemsSelector: ".header-item",
      slideSpeed: 1200,
      singleItem: !0,
      autoPlay: !0,
      addClassActive: !0
    });
    e.length && e.owlCarousel({
      itemsSelector: ".team-item",
      slideSpeed: 1200,
      singleItem: !0,
      autoPlay: !0,
      pagination: !0
    });
    f.length && f.owlCarousel({
      slideSpeed: 1200,
      singleItem: !0,
      autoPlay: !0,
      pagination: !0
    });
    var g = a(".FlickrImages ul");
    g.length && a.getJSON("http://api.flickr.com/services/feeds/photos_public.gne?id=64801217@N07&lang=en-us&format=json&jsoncallback=?", function(c) {
      a.each(c.items, function(b, c) {
        9 >= b && a("<img/>").attr({
          src: c.media.m.replace("_m", "_s"),
          alt: ""
        }).appendTo(g).wrap('<li><a href="' + c.link + '" title="' + c.title + '" target="_blank"></a></li>')
      })
    });
    var h = a(".portfolio-items"),
      d = a(".portfolio-filter-menu ul");
    h.length && (h.isotope({
      itemSelector: ".portfolio-item",
      layoutMode: "packery"
    }), d.on("click", function(c) {
      if (a(c.target).is("li")) {
        var b = a(c.target).data("filter");
        h.isotope({
          filter: "*" !== b ? "." + b : b
        });
        a(c.target).siblings().removeClass("active");
        a(c.target).addClass("active")
      }
    }));
    a("#preloader").fadeOut("slow")
  })
})(jQuery);
