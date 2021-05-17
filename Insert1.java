public class Insert1 {

    public static void main(String[] args) {

        int [] a =  {100 ,99, 98,97, 96,95,94,93,92,91,90,89,88,87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 65, 64, 63, 62, 61, 60};

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


