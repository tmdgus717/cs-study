# 재귀호출
- 직관적으로 코드를 알아볼 수 있다.
- 분할 정복 (Divide and Conquer) : 문제의 타입은 작고 문제의 범위를 작게 하여 해결
- 재귀 호출에서는 종료 조건(Terminate Condition)이 명확해야한다! (유한성)
- 재귀 호출시 스택 메모리가 계속 쌓이고, 각 변수와 반환값 등 함수에 대한 환경 값들이 변하는 Context Switch 가 발생하는데 많은 비용이 소모된다
  - 종료 조건이 명확하지 않은경우 stack overflow 발생


## 팩토리얼
- 반복문을 사용하여 순환을 사용한 경우보다 쉽게 계산할 수 있다.
- 함수의 마지막 부분에서 순환하는 것을 꼬리 순환(Tail Recursion) 이라고하며, 꼬리 순환은 반복문으로 변환하는 것이 효율적이다(수행 속도, 메모리)

## 섬나라 관광 문제
- Acourse : 항상 도착한 섬을 먼저 관광하고 왼쪽 섬으로 관광을 진행, 왼쪽 방향의 모든 섬을 방문한 후에는 오른쪽 섬으로 관광을 진행.
- Bcourse : 섬에 도착하면 도착한 섬의 관광을 미루고 왼쪽 섬으로 관광을 진행하고 왼쪽 방향의 모든 섬들을 방문한 후에 돌아와서 섬을 관광한다.
- Ccourse : 도착한 섬의 관광을 미루고 왼쪽 섬으로 관광을 진행한다. 왼쪽 방향의 모든 섬들을 관광한 후 오른쪽 섬으로 관광을 진행하고 미루었던 섬을 관광한다.

## 하노이 타워
- 맨 아래 원반을 제외한 나머지 n-1 원반을 기둥 c로 옮긴다
- a에 남은 원반 1개를 b로 옮긴다
- 나머지 원반을 c에서 b로 옮긴다

## 중위, 전위, 후위 표현법
- 전위 표현법 : + A B
- 중위 표현법 : A + B
- 후위 표현법 : A B +

전위 표현법이나 후위 표현법에서는 우선순위를 설정할 필요가 없어서 괄호가 필요 없다
- 중위 표현법 : (A + B) * (C - 2)
- 전위 표현법 : * + A B - C 2
- 후위 표현법 : A B + C 2 - *

## 깊이 우선 탐색 (DFS)
```text
DFS(X):
  x.visited <- true
    if(y.visited = false) DFS(y)
```


