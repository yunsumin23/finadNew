$(document).ready(function() {
	var view;
	
    $(".gnb").hide();
    $(".gnbbox").hide();
    $(".category_text").mouseenter(function() {
        $(".gnb").stop().slideDown();
        $(".gnbbox").stop().slideDown();
    });
    $(".category_div").mouseleave(function() {
        $(".gnb").stop().slideUp();
        $(".gnbbox").stop().slideUp();
    });
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
function like(){
	let likeImg = document.getElementById('like_img');
	if (image.src.endsWith('img/d.png')) {
        image.src = 'img/d_clicked.png'; // 이미지를 변경합니다.
        image.alt = '추천됨'; // 이미지의 대체 텍스트도 변경할 수 있습니다.
    } else {
        image.src = 'img/d.png';
        image.alt = '추천';
    }
	
	
}
