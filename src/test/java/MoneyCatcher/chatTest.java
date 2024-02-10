package MoneyCatcher;

import java.util.ArrayList;
import java.util.Scanner;

public class chatTest {
    private ArrayList<String> questions;
    private ArrayList<String> userResponses;

    public chatTest() {
        questions = new ArrayList<>();
        questions.add("안녕하세요! 오늘 기분은 어떠세요?");
        questions.add("오늘 무엇을 하셨나요?");
        questions.add("그럼, 오늘 하루 어떻게 마무리 하실 건가요?");
        userResponses = new ArrayList<>();
    }

    public void chat() {
        System.out.println("챗봇: 안녕하세요! 챗봇입니다.");
        Scanner scanner = new Scanner(System.in);
        for (String question : questions) {
            System.out.print("사용자: " + question + " ");
            String userInput = scanner.nextLine();
            userResponses.add(userInput);
        }
        scanner.close();
        System.out.println("챗봇: 대화가 종료되었습니다.");
        System.out.println("사용자의 답변: " + userResponses);
    }

    public boolean checkKeyword(String keyword) {
        String happy = "행복";
        for (String response : userResponses) {
            if (response.contains(keyword)) {
                System.out.println("사용자의 답변 중 '" + keyword + "' 키워드를 포함한 답변이 있습니다.");
                if (happy.equals(keyword)) {
                    // "행복" 키워드가 포함되면 추가 행동으로 "요가" 키워드를 추가합니다.
                    keyword2.add("요가");
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        chatTest chatbot = new chatTest();
        chatbot.chat();

        // 특정 키워드 확인
        String[] keywords = {"즐거운", "행복", "힘들", "피곤"};
        for (String keyword : keywords) {
            chatbot.checkKeyword(keyword);
        }
    }

    // "행복" 키워드가 포함되면 추가 행동으로 "요가" 키워드를 저장하기 위한 리스트
    public static ArrayList<String> keyword2 = new ArrayList<>();

}
