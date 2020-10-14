#include <bits/stdc++.h>
using namespace std;

vector<long long> solve (int N, vector<long long> A, int K) {
    // Write your code here
    vector<long long> out_;
    for(int x=0; x<=K; x++){
        int result = 0; 
        unordered_set<int> s; 

        for (int i=0; i<N ; i++) {
            if (s.find(x^A[i]) != s.end()) 
            result++; 
            s.insert(A[i]); 
        }
    //return result;
    out_.push_back(result);
    }
    return out_;
}
    
    
int main() {
    
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    vector<long long> A(N);
    
    for(int i_A = 0; i_A < N; i_A++){
        cin>> A[i_A];
    }
    int K;
    cin >> K;
    
    vector<long long> out_;
    out_ = solve(N, A, K);
    cout<< out_[0];
    for(int i_out_ = 1; i_out_ < out_.size(); i_out_++){
        cout << " " << out_[i_out_]; 
    }
}

