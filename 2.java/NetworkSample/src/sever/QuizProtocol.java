package sever;

class QuizProtocol {
    private static final int WAITING = 0; // 프로토콜이 가질 수 있는 상태
    private static final int PROBLEM = 1;
    private static final int ANSWER = 2;
    private static final int NUMPROBLEMS = 3;
    private int state = WAITING;
    private int currentProblem = 0;
    private String[] problems = { "이번 자바과목의 시험범위는?", "자바의 최신버전은?", "스레드 풀 사용을 위한 패키지는?" }; //문제
    private String[] answers = { "25장 네트워크 프로그래밍", "1.8", "ExecutorService" }; //답
    
    public String process(String theInput) {
        String theOutput = null;
         if (state == WAITING) { //상태가 waiting이면 시작 메시지를 보낸다
            theOutput = "퀴즈를 시작합니다(y/n)";
            state = PROBLEM;
        } else if (state == PROBLEM) {//상태가 problem이면문제를 보낸다
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = problems[currentProblem];
                state = ANSWER;
            } else {
                state = WAITING;
                theOutput = "quit";
            }
        } else if (state == ANSWER) {//상태가 answer이면 답을 확인한다
            if (theInput.equalsIgnoreCase(answers[currentProblem])) {
                theOutput = "정답입니다. 계속하시겠습니까? (y/n)";
                state = PROBLEM;
            } else {
                state = PROBLEM;
                theOutput = "오답입니다. 계속하시겠습니까? (y/n)";
            }
            currentProblem = (currentProblem+1)% NUMPROBLEMS;
        } 
        return theOutput;
    }
}
