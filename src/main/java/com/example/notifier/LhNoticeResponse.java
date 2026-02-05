package com.example.notifier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

/**
 * LH API 응답 구조에 맞춘 그릇(DTO)
 */
@Data
public class LhNoticeResponse {
    @JsonProperty("dsList") // LH API는 공고 목록을 dsList라는 이름으로 보내줍니다.
    private List<LhNoticeItem> dsList;

    @Data
    public static class LhNoticeItem {
        @JsonProperty("PAN_NM")         // 공고 제목
        private String panNm;

        @JsonProperty("PAN_NT_ST_DT")   // 공고 게시일(시작일)
        private String panNtStDt;

        @JsonProperty("CLSG_DT")        // 마감일
        private String clsgDt;

        @JsonProperty("AIS_TP_CD_NM")   // 매물 종류 (청년주택, 신혼희망타운 등)
        private String aisTpCdNm;

        @JsonProperty("CNP_CD_NM")      // 지역명 (서울, 경기 등)
        private String cnpCdNm;
    }
}