function checkId(){
    var memberId = $("#memberId").val();
    if(memberId==""){
        alert("아이디를 입력하세요");
        return;
    }
    var url = "/checkId";
    var title ="checkId";
    var status ="left=500px, top=100px, width=300px,height=200px,menubar=no,status=no,scrollbars=yes";
    var popup = window.open("",title,status);    
    checkIdFrm.checkId.value=memberId;
    checkIdFrm.target=title;//popup 창과 form태그를 연결하는 속성
    checkIdFrm.action=url;
    checkIdFrm.method="post";
    checkIdFrm.submit();
}