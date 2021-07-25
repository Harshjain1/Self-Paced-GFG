->Parathesis Checker
public static boolean ParathesisChecker(String str){
    Stack<Character> st = new Stack<>();
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        if(ch=='(' || ch=='{' || ch=='['){
            st.push(ch);
        }
        else if(ch==')'){
            if(st.isEmpty() || st.peek()!='('){
                return false;
            }
            st.pop();
        }
        else if(ch==']'){
            if(st.isEmpty() || st.peek()!='['){
                return false;
            }
            st.pop();
        }
        else if(ch=='}'){
            if(st.isEmpty() || st.peek()!='{'){
                return false;
            }
            st.pop();
        }
        else{
            continue;
        }
    }
    return st.size()==0;
}

->Next Larger Element
public static int[] nextLarger(int[] arr){
    int[] res = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    st.push(0);
    for(int i=1;i<arr.length;i++){
        while(st.size()>0 && arr[st.peek()]<arr[i]){
            res[st.pop()]=i;
        }
        st.push(i);
    }
    while(st.size()>0){
        res[st.pop()]=-1;
    }
    return res;
}

->Queue using two stacks
->Stacks using two Queues
->Get Minimum Element from Stack (2 Methods)
->LRU Cache
->Circular tour
->First Non repeating Character in a stream
->Rotten oranges
->Maximum of all subarrays of size k
->Two stacks in an Array
->K stacks in an Array
->Stock Span Problem
->Previous Greater Element
->Next Greater Element
->Largest Rectanglur area
->largest rectangle with all 1s
->Infix evaluation
->Infix to Prefix
->Infix to Postfix
->Prefix Evaluation
->Postfix Evaluation
