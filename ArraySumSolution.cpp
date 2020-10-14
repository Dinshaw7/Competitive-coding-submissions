#include <bits/stdc++.h>

using namespace std;

long long f_of_x(long long x, vector<int> arr){
    long long p;
    bool isPossible = false;
    if(x==1){
        isPossible = false;
    }
    
    for(long long i=1; i<=x-1; i++){
        p = i;
      if( (arr[p-1] & arr[x-1]) > 0 ){
        isPossible = true;
        break;
      }
    }
    
    if(isPossible){
        long long sum = 0;
        for(long long i=1; i<=x; i++){
            sum += arr[x-1] ^ arr[i-1];
        }
        return sum;
    }
    else{
        return 0;
    }
}

long long g_of_x(long long x, vector<int> arr){
    long long p;
    bool isPossible = false;
    if(x==arr.size()){
        isPossible = false;
    }
    
    for(long long i=x+1; i<=arr.size(); i++){
        p = i;
      if((arr[p-1] & arr[x-1]) > 0 ){
        isPossible = true;
        break;
      }
    }
    
    if(isPossible){
        long long sum = 0;
        for(long long i=x; i<=arr.size(); i++){
            sum += arr[x-1] ^ arr[i-1];
        }
        return sum;
    }
    else{
        return 0;
    }
}


long long solve(int N, vector<int> arr){
    long long A=0;
    long long B=0;
    long long sum_of_f_of_x;
    long long sum_of_g_of_x;
    long long result;
    for(long long i=1; i<=N; i++){
        sum_of_f_of_x = f_of_x(i, arr);
        A += sum_of_f_of_x;
        sum_of_g_of_x = g_of_x(i, arr);
        B += sum_of_g_of_x;
    }
    result= (A+B) % 1000000007;
    return result;
}



int main()
{
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>> N;
        vector<int> arr(N);

        for(int i=0; i<N; i++){
            cin>>arr[i];
        }
    
    long long out_;
    out_ = solve(N, arr);
    cout<<out_;
    cout<< "\n";
    }
    
    
}
