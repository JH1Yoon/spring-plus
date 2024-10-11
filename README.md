## 🚫 레거시 코드 리팩토링 플러스 🚫

--------------------------------------------------------------

- **Transaction** 수정
- **JWT** 수정
- **AOP** 수정
- **컨트롤러 테스트** 코드 수정
- JPA 코드 개선(**JPQL를 이용**)
- **JPA Cascade**
- **N+1**문제 해결
- **QueryDSL**를 사용
- **Spring Security** 사용하여 인증/인가 처리
- **QueryDSL**를 통해 **할일 검색 기능** 생성
- 담당자 등록과 별개로 **로그 데이터** 저장 (**@Transactional**)
- **AWS EC2, RDS, S3**를 사용해서 프로젝트 관리 및 배포

## AWS 설정

--------------------------------------------------------------

### 1. EC2
<details>
    <ul>
        <img src="https://github.com/user-attachments/assets/f77f175f-2139-49ce-82a3-6387e0e26e5e" alt="ERD">
    </ul>
</details>

### 2. RDS
<details>
    <ul>
        <img src="https://github.com/user-attachments/assets/041ab223-50f9-42a1-8d5b-cddcf1efb4ac" alt="ERD">
    </ul>
</details>

### 3. Elastic IP
<details>
    <ul>
        <img src="https://github.com/user-attachments/assets/b21cc05a-fdcc-4299-9949-dfd7c7e90420" alt="ERD">
    </ul>
</details>

### 4. S3
<details>
    <ul>
        <img src="https://github.com/user-attachments/assets/fb01f9a5-ae3e-420d-80da-87129eb19802" alt="ERD">
    </ul>
</details>


## AWS 실행화면
--------------------------------------------------------------

### HealthChaeck 실행화면
<details>
    <summary>성공</summary>
    <ul>
        <img src="https://github.com/user-attachments/assets/e61afc46-335f-44ca-a3db-c44d8a6d78a7" alt="ERD">
    </ul>
</details>

<details>
    <summary>실패</summary>
    <ul>
        <img src="https://github.com/user-attachments/assets/14c47fe3-afd6-4059-aca8-c9ff189b7cf7" alt="ERD">
    </ul>
</details>

## 트러블 슈팅
--------------------------------------------------------------
[예외가 발생했을 때 Transactional 실패](https://velog.io/@jhy1/%EC%98%88%EC%99%B8%EA%B0%80-%EB%B0%9C%EC%83%9D%ED%96%88%EC%9D%84-%EB%95%8C-Transactional)
