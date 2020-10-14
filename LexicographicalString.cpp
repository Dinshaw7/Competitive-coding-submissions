#include <bits/stdc++.h>
using namespace std;

int main() {
    int test_cases;
	cin >> test_cases;
	while(test_cases--){
	   string sequence;
	   vector<char> result;
	   string data = "";
	   int asciiOfa = 97;
	   cin >> sequence;
	   for(int i=0; i< sequence.length()+1; i++){
	       data += asciiOfa+i;
	   }
	   result.push_back(data.at(0));
	   int lastIndex = 0;
	   for(int i=0 ; i<sequence.length(); i++){
	       if(sequence.at(i) == '<'){
	           result.push_back(data.at(i+1));
	           lastIndex = i+1;
	       } else {
	           result.insert(result.begin()+lastIndex, data.at(i+1));
	       }
	   }
	   for (auto it = result.begin(); it != result.end(); ++it) 
		cout << *it;
		cout << endl;
	}
	return 0;
}
