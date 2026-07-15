class Solution {
    public int gcdOfOddEvenSums(int n) {
        if(n==1){
            return 1;
        }
        int sumodd=0;
        int sumeven=0;
        for(int i=1;i<=n*2;i++){
            if(i%2==0){
                sumeven+=i;
            }else{
                sumodd+=i;
            }
        }
        int min=Math.min(sumodd,sumeven);
        int gcd=0;
        for(int i=2;i<=min;i++){
            if(sumodd%i==0 && sumeven%i==0){
                gcd=i;
            }
        }
        return gcd;
    }
}