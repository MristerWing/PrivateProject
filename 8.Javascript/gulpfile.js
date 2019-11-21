const gulp = require("gulp");
//gulp의 의존성을 작성
const babel = require("gulp-babel");
const eslint = require("gulp-eslint");

gulp.task("default", function(done) {
    //gulp의 작업을 작성
    //run eslint
    gulp.src(["es6/**/*.js", "public/es6/**/*.js"])
        .pipe(eslint())
        .pipe(eslint.format());

    //node source
    gulp.src("es6/**/*.js")
        .pipe(babel())
        .pipe(gulp.dest("dist"));

    //browser source
    gulp.src("public/es6/**/*.js")
        .pipe(babel())
        .pipe(gulp.dest("public/dist"));

    done();
});
