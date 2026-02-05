# jmtotorryy

공공데이터를 활용한 실시간 청약/임대 공고 수집 및 자동 포스팅 프로젝트입니다.

## 프로젝트 목표
- **통합 청약 정보 수집**: LH(한국토지주택공사) 및 청약홈(한국부동산원)의 최신 공고 데이터를 자동으로 수집합니다.
- **자동 알림 및 게시**: 수집된 데이터를 워드프레스 블로그 및 이벤트 캘린더(The Events Calendar)에 자동으로 포스팅하여 사용자에게 시각화된 정보를 제공합니다.

## 사용 기술
- **Language**: Java 21 (Virtual Threads 등 최신 기능 활용)
- **Framework**: Spring Boot 3.x
- **API**: 
  - 공공데이터포털 (LH, 청약홈)
  - WordPress REST API

## 환경 변수 설정
보안을 위해 API 인증 정보는 시스템 환경 변수로 관리합니다.
- `PUBLIC_DATA_KEY`: 공공데이터포털 인증키
- `WP_ADMIN_ID`: 워드프레스 관리자 ID
- `WP_APP_PASSWORD`: 워드프레스 애플리케이션 비밀번호
