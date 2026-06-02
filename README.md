# NullSpace

개발자의 몰입을 위한 코딩 ASMR 큐레이션 서비스입니다.

## 🚀 프로젝트 소개
조용한 공간(NullSpace)에서 키보드 타건 소리와 함께 코드에 몰입할 수 있도록, 
엄선된 코딩 ASMR 영상과 관련 깃허브 저장소를 연결하여 제공합니다.

## 🛠 기술 스택
- **Language:** Java 21
- **Framework:** Spring Boot 3.5.x
- **Build Tool:** Gradle
- **Batch:** Spring Batch
- **DB:** H2 Database(배포 시 PostgreSQL 전환 예정)

## 🏗 프로젝트 구조 (Monorepo)
본 프로젝트는 효율적인 관리를 위해 모노레포 구조로 관리됩니다.

```text
null-space/
├── backend/    # Spring Boot 백엔드 프로젝트
└── frontend/   # React/Next.js 프론트엔드 프로젝트 (예정)
```

## 🚀 배포 환경 (CI/CD)
- Backend: Railway (Root Directory: /backend)
- Frontend: Vercel (Root Directory: /frontend)

## 📌 주요 특징
- 매월 1회 유튜브 API를 활용한 최신 ASMR 데이터 업데이트
- 신뢰할 수 있는 유튜버 화이트리스트 기반 영상 필터링
- 깃허브 링크 자동 추출을 통한 개발 학습 연동

## ⚙️ 실행 방법 (Backend)
```bash
cd backend
./gradlew bootRun
```