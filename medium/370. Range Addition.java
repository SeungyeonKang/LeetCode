class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        //updates[i] = [startIdx, endIdx, inc]
        
        //1)start - end 까지 value만큼 더해진다
        //2)start와 end 인덱스에 value를 각각 더하고, 뺴놓는다.
        //최종 arr[i] = arr[0] ~ arr[i]를 더한 값
        //arr[i]에 더해지지 않는 value는 1)에서 빼 놓은 value 값으로 인해 영향을 받지 않는다.
        int[] arr = new int[length];
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            
            arr[start] += value;
            if(end < length - 1) {
                arr[end+1] -= value;
            }
        }
        
        int sum=0;
        for(int i = 0; i < length; i++){
            sum+=arr[i];
            arr[i] = sum;
        }
        
        return arr;
    }
}
