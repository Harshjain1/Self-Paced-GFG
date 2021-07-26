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

->Stack using Queue (Push Efficient)

public static class StackfromQueue{
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public StackfromQueue() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        return mainQ.size();
    }

    void push(int val) {
        mainQ.add(val);
    }

    int pop() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }

        while (mainQ.size() > 1) {
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.peek();
        mainQ.remove();
        Queue<Integer> temp = mainQ;
        mainQ = helperQ;
        helperQ = temp;
        return val;
    }

    int top() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }

        while (mainQ.size() > 1) {
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.peek();
        helperQ.add(mainQ.remove());
        Queue<Integer> temp = mainQ;
        mainQ = helperQ;
        helperQ = temp;
        return val;
    }
}

->Stack using Queue(Pop Efficient)

public static class StackfromQueue {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public StackfromQueue() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
        return mainQ.size();
    }

    void push(int val) {
        helperQ.add(val);
        while (mainQ.size() > 0) {
            helperQ.add(mainQ.remove());
        }
        mainQ = helperQ;
        helperQ = new ArrayDeque<>();
    }

    int pop() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        return mainQ.remove();
    }

    int top() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        return mainQ.peek();
    }
}


->queue from stack (add efficient)

public static class QueuefromStack{
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public QueuefromStack(){
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
        return mainS.size();
    }

    void add(int val) {
        mainS.push(val);
    }

    int remove() {
        if (mainS.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        while (mainS.size() > 1) {
            helperS.push(mainS.pop());
        }
        int val = mainS.pop();
        while (helperS.size() > 0) {
            mainS.push(helperS.pop());
        }
        return val;
    }

    int peek() {
        if (mainS.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        while (mainS.size() > 1) {
            helperS.push(mainS.pop());
        }
        int val = mainS.peek();
        while (helperS.size() > 0) {
            mainS.push(helperS.pop());
        }
        return val;
    }
}

->queue from stack(remove efficient)

public static class QueuefromStack{
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public QueuefromStack() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    int size(){
        return mainS.size();
    }

    void add(int val){
        while (mainS.size() > 0) {
            helperS.push(mainS.pop());
        }
        mainS.push(val);
        while (helperS.size() > 0) {
            mainS.push(helperS.pop());
        }
    }

    int remove(){
        if (mainS.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return mainS.pop();
    }

    int peek(){
        if (mainS.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return mainS.peek();
    }
}


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
