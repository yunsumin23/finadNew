$(document).ready(function () {
    $(".gnb").hide();
    $(".gnbbox").hide();
    $(".category_text").mouseenter(function () {
        $(".gnb").stop().slideDown();
        $(".gnbbox").stop().slideDown();
    });
    $(".category_div").mouseleave(function () {
        $(".gnb").stop().slideUp();
        $(".gnbbox").stop().slideUp();
    });

    $(".shorts").hide();
    $(".sub").hide();
    $(".price").hide();
    $(".avg").hide();
    $(".offer").hide();
    $(".shorts_div").click(function () {
        $(".shorts").stop().slideToggle();
    });
    $(".sub_div").click(function () {
        $(".sub").stop().slideToggle();
    });
    $(".price_div").click(function () {
        $(".price").stop().slideToggle();
    });
    $(".avg_div").click(function () {
        $(".avg").stop().slideToggle();
    });
    $(".offer_div").click(function () {
        $(".offer").stop().slideToggle();
    });
});

window.onload = function all_check() {
    let che_all = document.querySelector("#check");
    let all01 = document.querySelectorAll(".list_check");
    che_all.onclick = function() {
        if (che_all.checked == true) {
            for (let che_all of all01) {
                che_all.checked = true;
            }
        } else {
            for (let che_all of all01) {
                che_all.checked = false;
            }
        }
    }
}
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

function img_change(imgElement) {
    // 현재 클릭된 이미지의 src 값을 가져온다
    var currentSrc = imgElement.src;
    
    // 현재 이미지의 파일 이름을 추출한다
    var currentFileName = currentSrc.substring(currentSrc.lastIndexOf("/") + 1);
    
    // 이미지 파일 이름에 따라 다음 이미지 파일 이름을 생성한다
    var nextFileName = currentFileName === "star01.png" ? "star02.png" : "star01.png";
    
    // 다음 이미지로 변경한다.
    imgElement.src = "img/" + nextFileName;
  }

//function filter(category) {
//	var shorts = document.querySelector(".shorts").value;
//	var sub = document.querySelector(".sub").value;
//	var price = document.querySelector(".price").value;
//	var avg = document.querySelector(".avg").value;
//	var offer = document.querySelector(".offer").value;
//	
//	$.ajax({
//		type: "POST",
//		url: "category.finad?url=" + category + "&filter=true",
//		data: {
//			shorts : shorts,
//			sub : sub,
//			price : price,
//			avg : avg,
//			offer : offer},
//			success: function (response) {
//				if(result === "true") {
//					
//				}
//			},
//			error: function () {
//				alert("실패함 ㅋㅅㅋ");
//			}
//	});
//}
