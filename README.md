#9주차 선택 정렬, 삽입 정렬, 쉘 정렬

201902949 이정수

------------------------------------------

## 선택 정렬 (Selection Sort)

선택 정렬은 전체 배열에서 가장 작은 값을 선택하여 배열의 0번과 바꾸고, 0번을 제외한 나머지 값에서 이와 같은 방법을 반복하여 정렬한다.
또한 선택 정렬은 오름차순으로 정렬, 내림차순으로 정렬, 랜덤으로 정렬에서 항상 일정한 시간복잡도를 갖는 민감하지 않은 (input insensitive)알고리즘이다.

### 선택 정렬 코드

코드에 대한 설명은 주석에 있다.

#### 거꾸로 된 배열

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

 
 
 #### 어느정도 정렬되어 있고 몇 개의 배열 순서가 섞인 배열
 
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



### 시간복잡도

선택 정렬의 시간복잡도는 n(n-1)/2 x O(1) = O(n^2)이다.
거꾸로 된 배열 Selection1과 어느 정도 정렬되어 있고 4개정도 순서가 섞인 배열 Selection2의 수행 시간을 비교하면 다음과 같다.
![3](https://user-images.githubusercontent.com/81748368/116822534-51d34880-abba-11eb-9258-b1e4c97e2cc6.PNG)
![4](https://user-images.githubusercontent.com/81748368/116822535-526bdf00-abba-11eb-9e62-057b2b15dca7.PNG)

 Selection1과  Selection2과 수행시간은 각각 563ms, 579ms로 크게 차이가 나지 않는다는 것을 알 수 있다.
 
 ---------------------------------------------------------
 
 ## 삽입 정렬
 
 삽입 정렬은 배열을 앞에서 차례대로 정렬된 부분과 정렬 안 된 부분으로 나누고 정렬된 배열 부분과 비교하며 자신의 위치를 찾아 삽입하여 정렬하는 알고리즘이다. 
 배열의 첫번째 원소가 정렬된 부분에 있을 때 시작을 하고 정렬 안 된 부분의 값이 정렬된 부분으로 삽입되면 정렬 안 된 부분은 원소가 1개 줄고 정렬된 부분은 원소가 1개 늘어나게 되고 이를 반복하면 정렬된 부분에 전체 배열이 다 삽입되어 있다.
 
 ### 삽입 정렬 코드
 코드 설명을 주석에 있다.
 
 #### 거꾸로된 배열
 
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

#### 어느정도 정렬되어 있고 몇 개의 배열 순서가 섞인 배열

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



 ### 시간복잡도
 
 삽입 정렬의 시간복잡도는 n(n-1)/2 x O(1) = O(n^2)이고 최선일 때는 O(n)인데 이는 입력이 이미 정렬이 되어 있을 때의 시간복잡도이다. 
 입력된 배열이 얼마나 정렬이 되어 있는지에 따라 수행시간이 달라진다. 정렬이 더 되어 있을수록 다른 알고리즘보다 수행시간이 더 빠른 점이 특징이다.
 다음은 거꾸로된 배열 Insert1과 어느정도 정렬되어 있고 몇 개의 배열 순서가 섞인 배열 Insert2의 수행시간이고 어느 정도 정렬이 되어 있는 배열이 수행시간이 더 빠름을 알 수 있다.
![7](https://user-images.githubusercontent.com/81748368/116823240-50a41a80-abbe-11eb-91bd-7304155b0b09.PNG)
![8](https://user-images.githubusercontent.com/81748368/116823242-50a41a80-abbe-11eb-928a-c66ae66a6b59.PNG)

--------------------------------------------------------------------------

## 쉘 정렬

