class Solution {

    public String[] reorderLogFiles(String[] logs) {
        /*
         LL : 모든 단어가 소문자
         DL : 모든 단어가 숫자
         identifier : 각 로그의 첫번쨰 단어
         
         order 
         1. LL -> DL
         2. LL : 사전순 정렬, 같으면 identifier 기준 정렬
         3. DL : 상대적인 순서 유지
         
         Q. 새로운 배열을 선언해도 되는지?
         Q. 식별자 뒤에 무조건 한 단어 이상?
         
         1. 첫번째 " "를 기준으로 2차원 배열로 나눔
         2. 만들어진 배열을 Comparator를 이용해 비교
            1) LL , DL -> LL > DL
            2) LL, LL
                - LL을 비교해서 사전순 정렬
                - 동일할 경우 identifier로 비교
            3) DL, DL -> 기존 정렬 유지
        */
        
        Comparator<String> sortLog = new Comparator<>() {
            @Override
            public int compare (String log1, String log2) {
                String[] split_l1 = log1.split(" ",2);
                String[] split_l2 = log2.split(" ",2);
                
                boolean isLog1Digit = Character.isDigit(split_l1[1].charAt(0));
                boolean isLog2Digit = Character.isDigit(split_l2[1].charAt(0));
                
                if(isLog1Digit && isLog2Digit) return 0;
                else if(isLog1Digit && !isLog2Digit) return 1;
                else if(!isLog1Digit && isLog2Digit) return -1;
                else {
                    int cmp = split_l1[1].compareTo(split_l2[1]);
                    if(cmp!=0) return cmp;
                    return split_l1[0].compareTo(split_l2[0]);
                }
            }
        };
        
        Arrays.sort(logs, sortLog);
        
        return logs;     
    }
}
