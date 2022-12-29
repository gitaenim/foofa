/**
 * 
 */
 
 $(function(){
	getBaseAddress();
	$("#btn-delivery").click(function(){
		$(this).preventDefault();
	});
	$("#delivery-table").submit(deliverySubmited);
	console.log("11111111111111111111111111111");
});

function getBaseAddress(){//기본배송지정보확인
	$.ajax({
		url:"/order/address/base",
		success:function(resultHTML){
			$("#base-address-disp").html(resultHTML);
			
			$("#address-no").val($("#addressNo").val());
			$("#menu-ad>li").removeClass("target");
			$("#menu-ad>li").eq(0).addClass("target");
		},
		error:function(){
			memuAdClicked($("menu-ad>li").eq(1));
			console.log("배송지정보가 없습니다");
		}
	});
}
function memuAdClicked(el){
	if($(el).index()==0){
		getBaseAddress();
		return;
	}
	$("#menu-ad>li").removeClass("target");
	$(el).addClass("target");
}


function deliverySubmited(event){

	event.preventDefault();
	
	var queryString=$(this).serialize();
	$.ajax({
		url:"/order/deliveryInfo",
		type:"post",
		data:queryString,
		success:function(){
			console.log("등록완료");
		}
		
	});

}


///////////////주소검색//////////////////////////////
 function adrList(){
    new daum.Postcode({
        oncomplete: function(data) {
        	 var roadAddr = data.roadAddress; // 도로명 주소 변수
             var extraRoadAddr = ''; // 참고 항목 변수
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
               // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddr").value = roadAddr;
                document.getElementById("jibunAddr").value = data.jibunAddress;
	           
               
       }
    }).open();
}

