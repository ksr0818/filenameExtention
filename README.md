# 개발자 채용 과제
## 파일 확장자 차단
 - 파일 확장자에 따라 특정 형식의 파일을 첨부하거나 전송하지 못하도록 제한

## 요건
1-1. 고정 확장자는 차단을 자주하는 확장자를 리스트이며, default는 unCheck되어져 있습니다. </br>
1-2. 고정 확장자를 check or uncheck를 할 경우 db에 저장됩니다. - 새로고침시 유지되어야합니다. </br>
 (아래쪽 커스텀 확장자에는 표현되지 않으니 유의해주세요.) </br>
2-1.  확장자 최대 입력 길이는 20자리 </br>
2-2. 추가버튼 클릭시 db 저장되며, 아래쪽 영역에 표현됩니다. </br>
3-1. 커스텀 확장자는 최대 200개까지 추가가 가능 </br>
3-2. 확장자 옆 X를 클릭시 db에서 삭제 </br>

## 추가 요건
- 커스텀 확장자 중복 체크(에러 발생)
- 고정 확장자와 커스텀 확장자 중복 체크(커스텀 확장자에 고정확장자 입력 시 에러 발생, enum 활용)
- 사이트 배포를 AWS를 통해 배포 (상시 유지)

배포 주소 : http://ec2-13-125-193-97.ap-northeast-2.compute.amazonaws.com:8090/my-page

### ERD
![filenameExtention_erd](https://github.com/ksr0818/filenameExtention/assets/120084774/5604bdd7-b7e9-44be-8887-1f7e277c8146)

- id :  저장시 부여되는 고유 번호 </br>
- value : 파일 확장자명을 의미 </br>
- category : 커스텀확장자인지 고정확장자인지를 구분(check / text) </br>

### OverView
![image](https://github.com/ksr0818/filenameExtention/assets/120084774/1fe955b2-c22a-4741-aab9-656d498c59f1)

### Detail

|고정 확장자 저장 및 삭제|커스텀 확장자 입력 및 저장|커스텀 확장자 조회 및 삭제|
| :---: | :---: | :---: |
|<img src="https://github.com/ksr0818/filenameExtention/assets/120084774/f14c763f-07cd-4cca-bdc8-11d67443d25b">|<img src="https://github.com/ksr0818/filenameExtention/assets/120084774/9d4ea076-f0cf-4ed0-8164-ea29bae0ecb7">|<img src="https://github.com/ksr0818/filenameExtention/assets/120084774/319a8dcc-cc80-456f-bdd0-aa083a280548">|
|고정 확장자를 저장 및 삭제할 수 있는 부분이다. </br> 고정확장자를 체크하면 저장되고 체크를 해제하면 삭제된다.  |커스텀 확장자를 입력 및 저장할 수 있는 부분이다. </br> 커스텀 확장자를 입력창에 입력 후 엔터 혹은 추가 버튼을 누르면 저장된다.|커스텀 확장자를 조회 및 삭제할 수 있는 부분이다. </br> 커스텀 확장자 옆 X 버튼을 누르면 삭제된다.




