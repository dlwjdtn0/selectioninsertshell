public class Insert2 {

        public static void main(String[] args) {

            int [] a = {60,61,62,63,64,65,66,67,68,69,70,72,73,74,76,77,78,79,80,81,82,83,75,84,85,71,87,88,89,90,91,92,93,94,95,96,86,100,97,98,99};

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
