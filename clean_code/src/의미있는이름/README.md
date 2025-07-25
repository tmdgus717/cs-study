# CH02 의미있는 이름

### 의도를 분명히 밝혀라

#### 의도를 파악하기 어려운 코드
```java
public List<int []> getThem(){
        List<int[]> list1 = new ArrayList<>();
        for (int[] x : theList) {
            if (x[0] == 4) {
                list1.add(x);
            }
        }
        return list1;
    }
```
위 코드는 코드 맥락이 코드 자체에 명시적으로 들어나지 않는다
1. 위 코드는 theList에 무엇이 들어있는지
2. theList에서 0 번째 값이 왜 중요한지
3. 값 4 는 무슨 의미인지
4. 함수가 반환하는 리스트 list1 을 어떻게 사용하는지

#### 이름을 붙여 의도를 파악하도록 개선한 코드
정보 제공은 충분히 가능했다. 
1. theList -> gameBoard
2. 배열에서 0 번째 값은 상태를 의미한다 (값 4 는 깃발이 꽂힌 상태)
3. 각 개념에 이름만 붙여도 코드가 상당히 나아진다.
```java
    public static int STATUS_VALE = 0;
    public static int FALGGED = 4;

    public List<int []> getFlaggedCells(){
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] cell : gameBoard) {
            if (cell[STATUS_VALE] == FALGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
```

#### Cell 클래스를 만들어 개선한 코드
```java
    public static int STATUS_VALE = 0;
    public static int FALGGED = 4;

    public List<Cell> getFlaggedCells(){
        List<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : gameBoard) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
```
단순히 이름만 고쳤는데도 함수가 하는 일을 이해하기 쉬워졌다.

### 그릇된 정보를 피하라 
1. hp, aix, sco 는 변수 이름으로 적절하지 않다.
    - 유닉스 플랫폼이나 유닉스 변종을 가리키는 이름이기 때문
    - 직삼각형의 빗변 (hypotenuse) 를 구혈할 때 hp가 좋아보여도 hp 라는 변수는 독자에게 그릇된 정보를 제공

2. 여러 계정을 그룹으로 묶을 때, 실제 List가 아니라면 accountList라 명명하지 않는다
   - 프로그래머에게 List라는 단어는 특수한 의미
   - 계정을 담는 컨테이너가 실제 List 가 아나리면 프로그래머에게 그릇된 정보를 제공하는 셈
   - accountGroup, buchOfAccounts, Accounts

3. 서로 흡사한 이름을 사용하지 않도록 주의한다
4. 소문자 L, 대문자 O는 사용하지말자 l,1  과 0,O 는구별하기 어렵다

### 의미있게 구분하라
- 연속적인 숫자를 덧붙인 이름 (a1, a2 ... aN), 불용어를 추가한 이름을 사용하지 않는다
  - 변수 이름에 valiable, 표이름에 table, name을 nameString 으로 짓는 행위등은 금물이다
- 명확한 관례가 없다면 customerInfo는 customer와 accountData는 account와 theMessage는 message 와 구분이 안 된다.
- 읽는 사람이 차이를 알도록 이름을 지어라

### 발음하기 쉬운 이름을 사용하라
즉, 의미가 존재하는 이름을 지어라

### 검색하기 쉬운 이름을 사용하라
이름 길이는 범위 크기에 비례하여 길어야한다. 길 수록 짧은 이름보다 검색하기 쉽다.

### 인코딩을 피하라
- phoneNumber, phoneString 과 같은 방식은 사용하지 말자
- ShapeFactoryImp나 CShapeFactory 가 IShapeFactory보다 좋다
- 멤버 변수에 접두어를 붙이지 말자

### 기억력을 자랑하지 마라
for문의 변수명으로 i,j,k 보다는 명료한 이름이 더 좋다

### 클래스 이름
클래스 이름과 객체 이름은 명사나 명사구가 적합하다.
- Customer, WikiPage, Account, AddressParser ...

### 메서드 이름
메서드 이름은 동사나 동사구가 적합하다
- postPayment, deletePage, save ...
- 생성자를 중복정의 할 때는 정적 팩토리 메서드를 사용한다 (메서드는 인수를 설명하는 이름을 사용한다)
```java
Complex fulcrumPoint = Complex.FromRealNumber(23.0);

Complex fulcrumPoint = new Complex(23.0);
```
아래보다 위가 더 좋다 (생성자 사용을 제한하려면 생성자를 private로 선언)

### 한 개념에 한 단어를 사용하라
추상적인 개념 하나에 단어 하나를 선택해 이를 고수한다.
- 똑같은 메서드를 클래스마다 fetch, retrieve, get 으로 제각각 부르면 혼란스럽다.

### 말장난을 하지 마라
한 단어를 두가지 목적으로 사용하지 마라. 다른 개념에 같은 단어를 사용한다면 그것은 말장난에 불과하다

### 해볍 영역에서 가져온 이름을 사용하라
전산 용어, 알고리즘 이름, 패턴 이름, 수학 용어 등을 사용해도 괜찮다.
기술 개념에는 기술 이름이 가장 적합한 선택이다.

### 문제 영역에서 가져온 이름을 사용하라
적절한 프로그래머 용어가 없다면 문제 영역에서 이름을 가져온다.

### 의미 있는 맥락을 추가하라 + 불피요한 맥락을 없애라
