class Calculator {
    constructor(number, oper, value) {
        this.number = parseInt(number);
        this.oper = oper;
        this.value = parseInt(value);
        this.result = 0;
    }

    getResult() {
        if (this.oper == "+") {
            this.result = this.number + this.value;
        } else if (this.oper == "-") {
            this.result = this.number - this.value;
        } else if (this.oper == "/") {
            if (this.value != 0 || this.number != 0) this.result = this.number / this.value;
            else result = "zero Division";
        } else if (this.oper == "*") {
            this.result = this.number * this.value;
        } else {
            result = "Error";
        }

        return this.result;
    }
}

Yonsan = function(number, oper, value) {
    this.number = parseInt(number);
    this.oper = oper;
    this.value = parseInt(value);
    this.result = 0;
};

Yonsan.prototype.calculator = function() {
    if (this.oper == "+") {
        this.result = this.number + this.value;
    } else if (this.oper == "-") {
        this.result = this.number - this.value;
    } else if (this.oper == "/") {
        if (this.value != 0 || this.number != 0) this.result = this.number / this.value;
        else result = "zero Division";
    } else if (this.oper == "*") {
        this.result = this.number * this.value;
    } else {
        result = "Error";
    }

    return this.result;
};
