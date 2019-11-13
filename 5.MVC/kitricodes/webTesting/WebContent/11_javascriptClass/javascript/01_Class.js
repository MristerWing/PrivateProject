// js class
/*
    basic: className = function () {}
    className.protype.functionName = function() {}
*/

// basic class (old ver)
Fruit = function() {
    this.msg = "맛있는";
};

// basic function
Fruit.prototype.taste = function() {
    var str = "과일";
    alert(this.msg + str);
};

Fruit.prototype.disp = function(msg) {
    alert(msg);
};

Apple = function() {};
Apple.prototype = new Fruit(); // 상속

// Override
Apple.prototype.taste = function() {
    var str = "사과";
    alert(this.msg + str);
};

Apple.prototype.abc = function() {
    alert("msg function");
};

Orange = function() {};

Orange.prototype = new Fruit(); // 상속
Orange.prototype.taste = function() {
    var str = "오렌지";
    alert(this.msg + str);
};
