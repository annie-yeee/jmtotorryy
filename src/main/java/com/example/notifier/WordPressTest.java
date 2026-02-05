package com.example.notifier;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class WordPressTest {
    public static void main(String[] args) {
        // 1. 환경 변수에서 정보 가져오기
        String wpId = System.getenv("WP_ADMIN_ID");
        String wpAppPassword = System.getenv("WP_APP_PASSWORD");
        String apiUrl = "https://jmtotorryy.mycafe24.com/wp-json/tribe/events/v1/events";

        // 2. 인증 헤더 생성 (ID:Password를 Base64 인코딩)
        String auth = wpId + ":" + wpAppPassword;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + encodedAuth);

        // 3. 테스트용 일정 데이터 생성
        Map<String, Object> eventData = new HashMap<>();
        eventData.put("title", "Java에서 보낸 테스트 일정");
        eventData.put("description", "백엔드 개발자가 되기 위한 첫 통신 성공!");
        eventData.put("start_date", "2026-02-10 10:00:00");
        eventData.put("end_date", "2026-02-10 12:00:00");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(eventData, headers);

        // 4. 전송
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);
            if (response.getStatusCode() == HttpStatus.CREATED) {
                System.out.println("성공! 블로그의 달력을 확인해보세요.");
            }
        } catch (Exception e) {
            System.err.println("실패: " + e.getMessage());
            e.printStackTrace();
        }
    }
}