package com.example.notifier;

import org.springframework.web.client.RestTemplate;
import java.net.URI;

public class LhApiTest {
    public static void main(String[] args) {
        String serviceKey = System.getenv("PUBLIC_DATA_KEY");

        // [명세서 기준 최종 주소]
        String baseUrl = "http://apis.data.go.kr/B552555/lhLeaseNoticeInfo1/lhLeaseNoticeInfo1";

        try {
            // 명세서에 나온 필수 파라미터 조립
            String urlString = baseUrl + "?serviceKey=" + serviceKey +
                    "&PG_SZ=10&PAGE=1&_type=json";

            URI uri = new URI(urlString);

            System.out.println("[이 주소를 복사해서 브라우저에 넣어보세요]");
            System.out.println(urlString);
            System.out.println("\nLH 서버로 '진짜 최종' 결투 신청!");

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);

            System.out.println("성공! 데이터 확인:");
            System.out.println(result);

        } catch (Exception e) {
            System.err.println("에러: " + e.getMessage());
            System.err.println("만약 500이 나면 키(Key) 문제, 404가 나면 주소 오타 문제입니다.");
        }
    }
}