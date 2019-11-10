function printDayTitle2(day, tagId) {
    const week = moment()
        .day(day)
        .format('ddd');
    const id = document.getElementById(tagId);
    id.innerHTML = week;
}

function printCalendarTitle(year, month) {
    const id = document.getElementById('calendarTitleID');
    id.innerHTML = year + '년 ' + month + '월';
}

function printSelectBox(root) {
    const selectBox = document.getElementById('selectBox');
    const selectAction = document.getElementById('selectAction');

    // event
    if (selectAction.value == 'event') {
        selectBox.innerHTML =
            '<ul>' +
            "<li class='selectLine'>" +
            "<label for='selectTitle'>제목 &nbsp;&nbsp;&nbsp;</label>" +
            "<input type='text' id='selectTitle'>" +
            '</li>' +
            "<li class='selectLine'>" +
            "<label for='selectAttendee'>참석자 </label>" +
            "<input type='text' id='selectAttendee'>" +
            '</li>' +
            "<li class='selectLine'>" +
            "<label for='selectLoc'>장소 &nbsp;&nbsp;&nbsp;</label>" +
            "<input type='text' id='selectLoc'>" +
            '</li>' +
            "<li class='selectLine'>" +
            "<label for='selectExplan'>설명 &nbsp;&nbsp;&nbsp;</label>" +
            "<input type='text' id='selectExplan'>" +
            '</li>' +
            "<li class='selectLine'>" +
            '<button onclick="javascript:submitSelectValue(' +
            true +
            ',' +
            "'" +
            root +
            "'" +
            ")\" class='selectButton'>확인</button>" +
            '</li>' +
            '</ul>';
    }

    // alarm
    else if (selectAction.value == 'alarm') {
        selectBox.innerHTML =
            '<ul>' +
            "<li class='selectLine'>" +
            "<label for='selectTitle'>제목 &nbsp;&nbsp;&nbsp;</label>" +
            "<input type='text' id='selectTitle'>" +
            '</li>' +
            "<li class='selectLine'>" +
            "<button onclick='javascript:submitSelectValue(" +
            false +
            ")' class='selectButton'>확인</button>" +
            '</li>' +
            '</ul>';
    }
}

function submitSelectValue(type, root) {
    // type ture = event / false = alram
    if (type) {
        const startDate = document.getElementById('selectedStartDate').value;
        const startHour = document.getElementById('selectStartHour').value;
        const startMinute = document.getElementById('selectStartMinute').value;
        const endDate = document.getElementById('selectedEndDate').value;
        const endHour = document.getElementById('selectEndHour').value;
        const endMinute = document.getElementById('selectEndMinute').value;
        const title = document.getElementById('selectTitle').value;
        const attendee = document.getElementById('selectAttendee').value;
        const loc = document.getElementById('selectLoc').value;
        const explan = document.getElementById('selectExplan').value;

        const url =
            root +
            '/calendar/event.do?' +
            'startDate=' +
            startDate +
            ' ' +
            startHour +
            ':' +
            startMinute +
            '&endDate=' +
            endDate +
            ' ' +
            endHour +
            ':' +
            endMinute +
            '&title=' +
            title +
            '&attendee=' +
            attendee +
            '&loc=' +
            loc +
            '&explan=' +
            explan;

        //console.log(url);

        location.href = url;
    }
}

function printDayContent(title, attendee, loc, explan, startDate, endDate) {
    const infoBox = document.getElementById('infoBox');
    infoBox.innerHTML =
        '<ul>' +
        "<li class='infoLine'>" +
        '<label>제목</label>' +
        '<br>' +
        '<span>' +
        title +
        '</span>' +
        '</li>' +
        "<li class='infoLine'>" +
        '<label>참석자</label>' +
        '<br>' +
        '<span>' +
        attendee +
        '</span>' +
        '</li>' +
        "<li class='infoLine'>" +
        '<label>장소</label>' +
        '<br>' +
        '<span>' +
        loc +
        '</span>' +
        '</li>' +
        "<li class='infoLine'>" +
        '<label>설명</label>' +
        '<br>' +
        '<span>' +
        explan +
        '</span>' +
        '</li>' +
        "<li class='infoLine'>" +
        '<label>시작일</label>' +
        '<br>' +
        '<span>' +
        startDate +
        '</span>' +
        '</li>' +
        "<li class='infoLine'>" +
        '<label>종료일</label>' +
        '<br>' +
        '<span>' +
        endDate +
        '</span>' +
        '</li>' +
        '</ul>';
}
