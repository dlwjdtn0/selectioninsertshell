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
            int[] A = {60,61,63,64,98,65,66,67,68,69,62,70, 71,72,73,74,76,77,78,79,80,81,82,83,75,84,85,87,88,89,90,91,92,93,94,95,96,86,97,99,100};


            // 정렬된 배열 출력
            Bubble2.buble2(A);
            int n = A.length;
            for (int i = 0; i < n; i++)
            {
                System.out.print(A[i] + " ");
            }
        }
}
