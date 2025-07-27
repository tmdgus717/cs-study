# CH03 함수

### 작게 만들어라
- 블록과 들여쓰기
  - if/else/while 등에 들어가는 블록은 한 줄이어야한다
  - 중첩 구조가 생길만큼 함수가 커져서는 안된다 (들여쓰기 수준은 1단이나 2단을 넘어서면 안 된다)
```java
public void processUser(User user) {
    if (user != null) {
        if (user.isActive()) {
            if (!user.isBanned()) {
                sendWelcomeMessage(user);
            }
        }
    }
}
```
위 보다 아래가 좋다
```java
public void processUser(User user) {
    if (user == null) return;
    if (!user.isActive()) return;
    if (user.isBanned()) return;

    sendWelcomeMessage(user);
}
```
### 한 가지만 해라!
- 함수가 한 가지만 하는지 판단하는 방법 : 의미있는 이름으로 다른 함수를 추출할 수 있다면 그 함수는 여러 작업을 하는 셈이다
- 지정된 함수 이름 아래 추상화 수준이 하나인 단계만 수행다면 그 함수는 한 가지 작업만 한다

### 함수 당 추상화 수준은 하나로!
함수가 확실히 한 가지 작업만 하려면 함수 내 모든 문장의 추상화 수준이 동일해야한다.

추상화(abstraction)란 복잡한 것을 단순하게 표현하는 방법이야.

추상화 수준이 높다 → "무엇을 하는지" 설명 (상위 개념)

추상화 수준이 낮다 → "어떻게 하는지" 설명 (구현 세부) 

추상화 수준 높다 -> getHtml() -> PathParser.render(pagepath); -> .append("\n) -> 추상화 수준 낮다

### switch 문
