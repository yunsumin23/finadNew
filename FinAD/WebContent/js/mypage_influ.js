$(document).ready(function () {
    $(".gnb").hide();
    $(".gnbbox").hide();
    $(".img_info02").hide();
    $(".info_ul").hide();
    $(".category_text").mouseenter(function () {
        $(".gnb").stop().slideDown();
        $(".gnbbox").stop().slideDown();
    });
    $(".category_div").mouseleave(function () {
        $(".gnb").stop().slideUp();
        $(".gnbbox").stop().slideUp();
    });
    $(".img_info_main").mouseenter(function () {
        $(".img_info02").stop().slideDown();
    });
    $("#showInfo").click(function() {
    	 $(".info_ul").show();
    	 $(this).hide();
	});
    $('.count-num').each(function() { 
    	  var $this = $(this),
    	      countTo = $this.attr('data-count');
// $this = 첫번째~세번째 .count-num
// countTo = 첫번째~세번째 .count-num의 data-count 속성의 값(user1.getThravgSub(),
// getThravgViewer(),getThravgHit()
    	  $({ countNum: $this.text()}).animate({
    	    countNum: countTo 
// this.text() = 0 
// countTo = user1.getThravgSub(),
// getThravgViewer(),getThravgHit()
    	  },
    	  {
    	    duration: 2000, 
    	    easing:'linear',
    	    step: function() {
    	      $this.text(Math.floor(this.countNum));
    	    },
    	    complete: function() { 
    	    	$this.text(this.countNum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    	    }
    	  });  
    });
//    $.ajax({
//    	url:"test1.jsp",
//    	method: "post",
//    	dataType: "json",
//    	success: function(data) {
//			drawPieChart(data);
//			console.log(data);
//		},
//    	error: function(data) {
//			console.error("데이터 가져오는데 실패함");
//		}
//    });
});


function zoomIn(event) {
    event.target.style.transform = "scale(1.2)";
    event.target.style.zIndex = "1";
    event.target.style.transition = "all 0.5s";
}

function zoomOut(event) {
    event.target.style.transform = "scale(1)";
    event.target.style.zIndex = 0;
    event.target.style.transition = "all 0.5s"
}

//function drawPieChart() {
//	var gender = document.querySelector(".gender_type").getContext("2d");
//	var genderData = {
//			labels:["남성", "여성"],
//			datasets: [{
//                data: [data.man, data.woman],
//                backgroundColor: ['#FF5733', '#3498db'],
//            }]
//	};
//	var genderChart = new Chart(gender, {
//        type: 'pie',
//        data: genderData,
//    });
//	$(".gender_type").css({
//		"background":"conic-gradient(#FF766B 0% 50%, #014D81 50% 100%)"
//	});
//	
//}
