#9주차 선택 정렬, 삽입 정렬, 쉘 정렬

201902949 이정수

------------------------------------------

## 선택 정렬

선택 정렬은 전체 배열에서 가장 작은 값을 선택하여 배열의 0번과 바꾸고, 0번을 제외한 나머지 값에서 이와 같은 방법을 반복하여 정렬한다.

### 선택 정렬 코드

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
 
 
 
 ####어느정도 정렬되어 있고 4개정도 순서가 섞인 배열
 
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

        //어느정도 정렬되어 있고 4개정도 순서가 섞인 배열
        int data[] = {60,61,63,64,98,65,66,67,68,69,62,70,71,72,73,74,76,77,78,79,80,81,82,83,75,84,85,87,88,89,90,91,92,93,94,95,96,86,97,99,100};

        S.selection(data);

        System.out.println("Selection2: ");
        for (int i = 0; i < data.length; i++)
        {

            System.out.print(data[i]+" ");
        }
    }

}


