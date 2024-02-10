package MoneyCatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelReader {
    public static void main(String[] args) {
//        chatTest obj = new chatTest();
//        int keyword = obj.keyword2();
        // 엑셀 파일 경로 설정
        String excelFilePath = ""; // 엑셀 파일 경로에 맞게 수정

        // 엑셀 파일 읽기
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(excelFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 엑셀 파일에서 특정 키워드가 있는 행만 필터링
        List<String> filteredLines = lines.stream()
                .filter(line -> line.contains(keyword2.get(0)))
                .collect(Collectors.toList());

        // 필터링된 데이터 출력
        for (String line : filteredLines) {
            System.out.println(line);
        }
    }

    // "행복" 키워드가 포함된 데이터를 필터링하기 위한 키워드 리스트
    private static List<String> keyword2;
}
