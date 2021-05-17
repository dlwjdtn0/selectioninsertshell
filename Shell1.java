public class Shell1 {
    public static void main(String[] args) {
        //정렬할 배열 a
        int[] a = {100,99, 98,97,96,95,94,93,92,91,90,89,88,87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 65, 64, 63, 62, 61, 60};

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
