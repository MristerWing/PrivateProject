function replyFun(root, boardNumber, groupNumber, sequenceNumber, sequenceLevel, pageNumber, link) {
    var url = root + "/board/" + link + ".do?boardNumber=" + boardNumber;
    url += "&groupNumber=" + groupNumber + "&sequenceNumber=" + sequenceNumber;
    url += "&sequenceLevel=" + sequenceLevel + "&pageNumber=" + pageNumber;

    //console.log(url);
    location.href=url;
}

function deleteFun(root, pageNumber, boardNumber, pwd) {
	var chkPwd = prompt("글삭제를 원하시면 글 비밀번호를 입력해 주세요.");
    if(chkPwd == pwd) {
        location.href = root + '/board/delete.do?pageNumber=' + pageNumber + '&boardNumber=' + boardNumber;
    }else {
        alert("비밀번호가 다릅니다!");
        return false;
    }

}