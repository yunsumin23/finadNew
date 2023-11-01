$(document).ready(function() {
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
	const ctx = document.querySelector(".line_canvas");
	const line_canvas = new Chart(ctx, {
		type : 'line',
		data : {
			labels : [ '30일전', '25일전', '20일전', '15일전', '10일전', '1일전' ],
			datasets : [ {
				label : '최근 30일 조회수',
				data : [ 271300, 348000, 297000, 317000, 210000, 379000 ],
				borderColor : [ '#014D81' ],
				borderWidth : 1
			} ]
		},
		options : {
			responsive: false,
			scales : {
				y : {
					beginAtZero : true
				}
			}
		}
	});
	const ctx2 = document.querySelector(".doughnut_graph");
	const doughnut_graph = new Chart(ctx2, {
		type : 'doughnut',
		data : {
			labels : [ '남','여' ],
			datasets : [ {
				label : ['신청인원','모집인원'],
				data : [2,4],
				backgroundColor: ['#36A2EB', '#FF5733'], // 각 데이터에 대한 색상 설정
	            borderColor: ['#36A2EB', '#FF5733'],
	            borderWidth: 1

			} ]
		},
		options : {
			responsive: false,
			scales : {
				y : {
					beginAtZero : true
				}
			}
		}
	});

	

});
function resetSearch() {
	document.getElementById('search_input').value = '';
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
