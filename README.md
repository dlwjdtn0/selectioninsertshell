# 9주차 선택 정렬, 삽입 정렬, 쉘 정렬

201902949 이정수

------------------------------------------
## 버블 정렬 (Bubble Sort)

버블 정렬은 배열 내의 이웃한 인덱스를 비교하면서 작은 값을 앞으로 이동시키고 큰 숫자는 뒤로 보내 이를 반복해서 정렬을 하는 알고리즘이다. 원소가 이동을 할 때 상하로 보면 거품이 위로 올라오는 듯한 모습을 보여서 버블 정렬이라고 한다. 시간복잡도는 느리지만 코드가 단순해서 자주 쓰이고 있다.

### 버블 정렬 코드

코드에 대한 설명은 주석에 있다.

#### 거꾸로 된 배열 Bubble1

public class Bubble1 {
    //입력: 크기가 A.length인 배열 A
    //출력: 정렬된 배열 A
    public static void buble(int[] A)
    {
        int n = A.length;
        for(int i = 0; i < n-1; i++) //n-1번 수행
        {
            for(int j = 1 ; j < n - i ; j++) //배열의 인접한 원소 비교
            {
                if(A[j-1] > A[j])   // 참이면 서로 자리를 바꿈, 거짓이면 다음 i값으로 넘어감
                {
                    //자리 바꿈
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // 거꾸로 된 배열
        int[] A = {100,99, 98,97,96,95,94,93,92,91,90,89,88,87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 65, 64, 63, 62, 61, 60};

        // 정렬된 배열 출력
        Bubble1.buble(A);
        int n = A.length;
        for (int i = 0; i < n; i++)
        {
            System.out.print(A[i] + " ");
        }
    }
}

#### 실행 결과

![13](https://user-images.githubusercontent.com/81748368/116968721-00c57080-acf0-11eb-8fe4-937a8ac029b7.PNG)

#### 어느 정도 정렬된 배열 Bubble2

public class Bubble2
        //입력: 크기가 A.length인 배열 A
        //출력: 정렬된 배열 A
{
        public static void buble2(int[] A)
        {
            int n = A.length;
            for(int i = 0; i < n-1; i++) //n-1번 수행
            {
                for(int j = 1 ; j < n - i ; j++)  //배열의 인접한 원소 비교
                {
                    if(A[j-1] > A[j])  // 참이면 서로 자리를 바꿈, 거짓이면 다음 i값으로 넘어감
                    {
                        //자리 바꿈
                        int temp = A[j];
                        A[j] = A[j-1];
                        A[j-1] = temp;
                    }
                }
            }
        }

        public static void main(String[] args) {

            // 어느 정도 정렬이 된 배열
            int[] A = {60,61,63,64,98,65,66,67,68,69,62,70,71,72,73,74,76,77,78,79,80,81,82,83,75,84,85,87,88,89,90,91,92,93,94,95,96,86,97,99,100};


            // 정렬된 배열 출력
            Bubble2.buble2(A);
            int n = A.length;
            for (int i = 0; i < n; i++)
            {
                System.out.print(A[i] + " ");
            }
        }
}

#### 실행 결과

![14](https://user-images.githubusercontent.com/81748368/116968720-00c57080-acf0-11eb-8f13-03de2fcb19f4.PNG)

### 시간복잡도와 수행 시간

버블 정렬이 시간복잡도는 n(n-1)/2 x O(1) = O(n^2) x O(1)= O(n^2)이고 수행시간은 Bubble1과 Bubble2 각각 1sec 702ms, 1sec 765ms로 크게 차이가 나지는 않았다.

Bubble1 수행 시간: ![15](https://user-images.githubusercontent.com/81748368/116968716-ff944380-acef-11eb-864c-ecf2faecd124.PNG)

Bubble2 수행 시간: ![16](https://user-images.githubusercontent.com/81748368/116968718-002cda00-acf0-11eb-8c41-1a983bba5800.PNG)

------------------------------------------------------------------------------

## 선택 정렬 (Selection Sort)

선택 정렬은 전체 배열에서 가장 작은 값을 선택하여 배열의 0번과 바꾸고, 0번을 제외한 나머지 값에서 이와 같은 방법을 반복하여 정렬한다.
또한 선택 정렬은 오름차순으로 정렬, 내림차순으로 정렬, 랜덤으로 정렬에서 항상 일정한 시간복잡도를 갖는 민감하지 않은 (input insensitive)알고리즘이다.

### 선택 정렬 코드

코드에 대한 설명은 주석에 있다.

#### 거꾸로 된 배열 Selection1

public class Selection1 {

    public static void selection(int[] a)
    {
        sort(a, a.length);
    }

    private static void sort(int[] a, int size)
    {
        //최솟값을 찾기 위한 for문
        for(int i = 0; i < size - 1; i++)
        {
            int b = i; //b는 최소값

            //a[i+1]부터 1개씩 a[b]와 비교
            for(int j = i + 1; j < size; j++)  //최소값의 인덱스를 찾음
            {
                //a[b]보다 작으면 b=j로 갱신
                if(a[j] < a[b])
                {
                    b = j;
                }
            }

            swap(a, b, i); //최소값b와 i번째 값을 교환
        }
    }

    private static void swap(int[] p, int i, int j) //문자 배열을 사용하여 교환
    {
        int tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }

    public static void main(String[] args) {

        Selection1 S = new Selection1();

        //거꾸로된 배열
        int data[] = {100, 99, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 65, 64, 63, 62, 61, 60};

        S.selection(data);
        System.out.println("Selection1: ");
        for (int i = 0; i < data.length; i++)
        {
            System.out.print(data[i]+" ");
        }
    }
 }
 
 #### 실행 결과
 
![1](https://user-images.githubusercontent.com/81748368/116822430-afb36080-abb9-11eb-8252-b26e9a6837d9.PNG)

 
 
 #### 어느정도 정렬되어 있고 몇 개의 배열 순서가 섞인 배열 Selection2
 
 public class Selection2 {
    public static void selection(int[] a)
    {
        sort(a, a.length);
    }

    private static void sort(int[] a, int size)
    {
        //최솟값을 찾기 위한 for문
        //n-1까지 수행하지 않는 이유는 배열의 범위를 벗어나기 때문
        for(int i = 0; i < size - 1; i++)
        {
            int b = i; //b는 최소값

            //a[i+1]부터 1개씩 a[b]와 비교
            for(int j = i + 1; j < size; j++)  //최소값의 인덱스를 찾음
            {
                //a[b]보다 작으면 b=j로 갱신
                if(a[j] < a[b])
                {
                    b = j;
                }
            }

            swap(a, b, i); //최소값b와 i번째 값을 교환
        }
    }

    private static void swap(int[] p, int i, int j) //문자 배열을 사용하여 교환
    {
        int tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }

    public static void main(String[] args) {

        Selection2 S = new Selection2();

        // 어느정도 정렬되어 있고 몇 개의 배열 순서가 섞인 배열
        int data[] = {60,61,63,64,98,65,66,67,68,69,62,70,71,72,73,74,76,77,78,79,80,81,82,83,75,84,85,87,88,89,90,91,92,93,94,95,96,86,97,99,100};

        S.selection(data);

        System.out.println("Selection2: ");
        for (int i = 0; i < data.length; i++)
        {

            System.out.print(data[i]+" ");
        }
    }

}

#### 실행 결과

![2](https://user-images.githubusercontent.com/81748368/116822433-b2ae5100-abb9-11eb-9cbb-49405b1ffd8b.PNG)



### 시간복잡도와 수행 시간

선택 정렬의 시간복잡도는 n(n-1)/2 x O(1) = O(n^2)이다. 최선과 최악의 시간복잡도도 O(n^2)로 평균 시간복잡도와 같다.
거꾸로 된 배열 Selection1과 어느 정도 정렬되어 있고 4개정도 순서가 섞인 배열 Selection2의 수행 시간을 비교하면 Selection1과 Selection2과 수행시간은 각각 1sec 749ms, 1sec 739ms로 크게 차이가 나지 않는다는 것을 알 수 있다.


Selection1 수행시간: ![se1](https://user-images.githubusercontent.com/81748368/116970505-16886500-acf3-11eb-8fb1-fb6fdfcf2b0c.PNG)

Selection2 수행 시간: ![se2](https://user-images.githubusercontent.com/81748368/116970509-1720fb80-acf3-11eb-9748-bedaef5e3723.PNG)

 ---------------------------------------------------------
 
 ## 삽입 정렬
 
 삽입 정렬은 배열을 앞에서 차례대로 정렬된 부분과 정렬 안 된 부분으로 나누고 정렬된 배열 부분과 비교하며 자신의 위치를 찾아 삽입하여 정렬하는 알고리즘이다. 
 배열의 첫번째 원소가 정렬된 부분에 있을 때 시작을 하고 정렬 안 된 부분의 값이 정렬된 부분으로 삽입되면 정렬 안 된 부분은 원소가 1개 줄고 정렬된 부분은 원소가 1개 늘어나게 되고 이를 반복하면 정렬된 부분에 전체 배열이 다 삽입되어 있다.
 
 ### 삽입 정렬 코드
 코드 설명을 주석에 있다.
 
 #### 거꾸로된 배열 Insert1
 
 public class Insert1 {

    public static void main(String[] args) {
        //거꾸로된 배열
        int [] a =  {100, 99, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 65, 64, 63, 62, 61, 60};

        //0번 인덱스에는 정렬이 되어있다고 가정하고 시작은 1번 인덱스
        for (int i = 1; i < a.length; i++)
        {
            int b = a[i];  // b가 기준이 되는 인덱스 값
            int j = i - 1;   // j는 비교되는 대상

            //비교되는 앞쪽 인덱스 a[j]가 크면 한칸 밀고 b의 값을 넣음
            while (j >= 0 && b < a[j])
            {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = b;  // 기준값 b를 저장
        }


        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}

#### 실행 결과

![5](https://user-images.githubusercontent.com/81748368/116823237-4f72ed80-abbe-11eb-8cbe-47e8ab0c51d6.PNG)

#### 어느정도 정렬되어 있고 몇 개의 배열 순서가 섞인 배열 Insert2

public class Insert2 {

        public static void main(String[] args) {

            int [] a = {80, 100, 88, 87, 86, 85, 67, 84, 83, 82, 99 ,81, 79, 78, 77, 76, 75, 73, 72, 71, 70, 69, 68, 65, 64, 63, 62, 61, 74, 60};

            //0번 인덱스에는 정렬이 되어있다고 가정하고 시작은 1번 인덱스
            for (int i = 1; i < a.length; i++)
            {
                int b = a[i];  // b가 기준이 되는 인덱스 값
                int j = i - 1;   // j는 비교되는 대상

                //비교되는 앞쪽 인덱스 a[j]가 크면 한칸 밀고 b의 값을 넣음
                while (j >= 0 && b < a[j])
                {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = b;  // 기준값 b를 저장
            }


            for (int i = 0; i < a.length; i++)
            {
                System.out.print(a[i] + " ");
            }
        }
    }

#### 실행결과

![6](https://user-images.githubusercontent.com/81748368/116823238-500b8400-abbe-11eb-9353-30da1b9aba3c.PNG)



 ### 시간복잡도와 수행 
 
 삽입 정렬의 시간복잡도는 n(n-1)/2 x O(1) = O(n^2)이고 최악일때와 같다. 최선일 때는 O(n)인데 이는 입력이 이미 정렬이 되어 있을 때의 시간복잡도이다. 
 입력된 배열이 얼마나 정렬이 되어 있는지에 따라 수행시간이 달라진다. 정렬이 더 되어 있을수록 다른 알고리즘보다 수행시간이 더 빠른 점이 특징이다.
 다음은 거꾸로된 배열 Insert1과 어느정도 정렬되어 있고 몇 개의 배열 순서가 섞인 배열 Insert2의 수행시간이고 어느 정도 정렬이 되어 있는 배열이 수행시간이 더 빠름을 알 수 있다.
 
Insert1 수행 시간: ![in1](https://user-images.githubusercontent.com/81748368/116970115-58fd7200-acf2-11eb-8660-72feeb75fac5.PNG)

Insert2 수행 시간: ![in2](https://user-images.githubusercontent.com/81748368/116970118-5a2e9f00-acf2-11eb-8803-e6a1200cc646.PNG)

--------------------------------------------------------------------------

## 쉘 정렬

쉘 정렬은 'Donald L. Shell'가 개발해낸 알고리즘으로 삽입 정렬의 단점을 보완한 알고리즘이다.
삽입 정렬의 장점은 어느 정도 정렬이 된 배열은 수행 시간이 짧다는 점이고 단점은 전체 배열을 한번에 정렬하기 때문에 요소들이 삽입되어야 할 자신의 위치와 멀리 있다면 이웃한 위치에서 많은 이동을 해야 하고 수행 시간이 오래 걸린다. 쉘 정렬은 전체를 한 번에 정렬하지 않게 해서 삽입 정렬의 장점은 살리고 단점은 보완하였다.
 일정한 기준에 따라 정렬할 배열을 분류하고 부분 배열로 분류를 한 후에 삽입 정렬을 이용해서 연산을 한 후 정렬을 하고 이를 부분 배열이 1개가 될때 까지 반복한다.
 쉘 정렬의 특징은 배열의 크기가 너무 크지 않을 경우 성능이 좋고 간격을 이용한 방법이 H/W로 정렬 알고리즘을 구현하는데 알맞기 때문에 임베디드 시스템에서 주로 쓰인다.
 

### 알고리즘 코드

코드에 대한 설명은 주석에 있다.

#### 거꾸로 된 배열 Shell1

public class Shell1 {
    public static void main(String[] args) {
        //정렬할 배열 a
        int[] a = {  100,99, 98,97,96,95,94,93,92,91,90,89,88,87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 65, 64, 63, 62, 61, 60};

        int b = a.length; //b는 배열a의 길이

        int h; // 간격(gap) h는 정렬할 배열의 길이의 반
        //간격 gap
        for(h = b / 2; h > 0; h /= 2)
        {
            int i;
            int j;

            //삽입정렬로 정렬
            for(i = h; i < b; i++)
            {
                //부분 배열로 분류
                int tmp = a[i];
                //부분 배열 연산(j=i-gap)
                for(j = i - h; j >= 0 && a[j] > tmp; j -= h)
                {
                    a[j + h] = a[j];   //삽입 정렬 해야 하니까 gap만큼 한칸씩 이동
                }
                //부분 배열 연산이 끝나서 다시 gap을 더해줌
                a[j + h] = tmp;
            }
        }

        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }


    }

}


### 실행 결과

![9](https://user-images.githubusercontent.com/81748368/116823936-6287bc80-abc2-11eb-9d57-9d3ab0123f47.PNG)


## 시간복잡도와 수행 시간

쉘 정렬의 시간복잡도는 O(n^1.25)이고 간격에 따라 달라진다.
- 최악의 경우는 O(n^2)
- 히바드(Hibbard)의 간격 2k-1 (즉, 2k-1, ⋯, 15, 7, 5, 3, 1)에서는 시간복잡도가 O(n^1.5)이다.
- 지금까지 알려진 가장 좋은 성능을 보인 간격은 1, 4, 10, 23, 57, 132, 301, 701, 1750 (Marcin Ciura)이다.

다음은 쉘 정렬 Shell1의 거꾸로된 배열 수행시간이고 삽입 정렬의 거꾸로된 배열 Insert1과 비교를 하면 Shell1의 수행 시간이 더 빠른 것을 알 수 있다.

Shell1 수행 시간: ![111](https://user-images.githubusercontent.com/81748368/116969328-0ff8ee00-acf1-11eb-827d-6a928c327f1f.PNG)

Insert1 수행 시간: ![in1](https://user-images.githubusercontent.com/81748368/116970115-58fd7200-acf2-11eb-8660-72feeb75fac5.PNG)

--------------------------------------

## 선택, 삽입, 쉘 정렬의 시간복잡도와 수행 시간 비교

시간복잡도 비교는 다음과 같다.

![11](https://user-images.githubusercontent.com/81748368/116965468-db813400-ace8-11eb-87d1-1ac678d97647.PNG)

수행 시간 비교는 다음과 같다.

![12](https://user-images.githubusercontent.com/81748368/116965551-108d8680-ace9-11eb-99d2-43cd0e13d94e.png)

