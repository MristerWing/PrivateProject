package sever;

class QuizProtocol {
    private static final int WAITING = 0; // ���������� ���� �� �ִ� ����
    private static final int PROBLEM = 1;
    private static final int ANSWER = 2;
    private static final int NUMPROBLEMS = 3;
    private int state = WAITING;
    private int currentProblem = 0;
    private String[] problems = { "�̹� �ڹٰ����� ���������?", "�ڹ��� �ֽŹ�����?", "������ Ǯ ����� ���� ��Ű����?" }; //����
    private String[] answers = { "25�� ��Ʈ��ũ ���α׷���", "1.8", "ExecutorService" }; //��
    
    public String process(String theInput) {
        String theOutput = null;
         if (state == WAITING) { //���°� waiting�̸� ���� �޽����� ������
            theOutput = "��� �����մϴ�(y/n)";
            state = PROBLEM;
        } else if (state == PROBLEM) {//���°� problem�̸鹮���� ������
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = problems[currentProblem];
                state = ANSWER;
            } else {
                state = WAITING;
                theOutput = "quit";
            }
        } else if (state == ANSWER) {//���°� answer�̸� ���� Ȯ���Ѵ�
            if (theInput.equalsIgnoreCase(answers[currentProblem])) {
                theOutput = "�����Դϴ�. ����Ͻðڽ��ϱ�? (y/n)";
                state = PROBLEM;
            } else {
                state = PROBLEM;
                theOutput = "�����Դϴ�. ����Ͻðڽ��ϱ�? (y/n)";
            }
            currentProblem = (currentProblem+1)% NUMPROBLEMS;
        } 
        return theOutput;
    }
}
