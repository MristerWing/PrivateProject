function printDayTitle(month, date, tagId) {
    const week = moment([moment().year(), month, date]).format("dddd");
    const id = document.getElementById(tagId);
    id.innerHTML = week;
}

function printDayTitle2(day, tagId) {
    const week = moment().day(day).format('ddd');
    const id = document.getElementById(tagId);
    id.innerHTML = week;
}

function printCalendarTitle(month) {
    const id= document.getElementById('calendarTitleID');
    id.innerHTML = moment().year() + '년 ' + month + '월';
}

