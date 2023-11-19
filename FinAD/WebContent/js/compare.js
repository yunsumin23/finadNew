$(document).ready(function() {
    $("#nonMat").on("change", function() {
    	var selectedValue = $(this).val();
        var values = selectedValue.split(','); // 쉼표를 기준으로 값을 나눔
        
        var nickname = values[0];
        var category = values[1];
        
        console.log("Selected nickname:", nickname);
        console.log("Selected category:", category);
        
       $.ajax({
    	  type: "POST",
    	  url:"nonMat.finad23?nickname="+ nickname +"&category="+ category +"",
    	  data:{
    		  nickname: nickname,
    		  category: category
    	  },
    	  success: function(rs) {
              var img = $(rs).find(".ajax_img");
              $(".com_img").html(img); // 기존 내용을 지우고 새로운 내용으로 대체
              var nick = $(rs).find(".ajax_nick");
              $(".com_nick").html(nick);
              var avgsub = $(rs).find(".ajax_avgSub");
              $(".com_sub").html(avgsub);
              var avgview = $(rs).find(".ajax_avgView");
              $(".com_view").html(avgview);
              var thrsub = $(rs).find(".ajax_thrSub");
              $(".com_thr").html(thrsub);
              var shorts = $(rs).find(".ajax_shorts");
              $(".com_shorts").html(shorts);
              console.log("성공");
          },
		error: function(error) {
			console.log("실패");
		}
       });
    });
});
