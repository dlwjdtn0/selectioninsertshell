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
        int[] A = {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 65, 64, 63, 62, 61, 60};

        // 정렬된 배열 출력
        Bubble1.buble(A);
        int n = A.length;
        for (int i = 0; i < n; i++)
        {
            System.out.print(A[i] + " ");
        }
    }
}
