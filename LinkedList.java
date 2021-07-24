->middle of Linked List

//method I
public static Node middle(Node head){
    if(head==null){
        return null;
    }
    Node curr = head;
    int count = 0;
    while(curr!=null){
        count++;
        curr=curr.next;
    }
    Node curr = head;
    for(int i=0;i<count/2;i++){
        curr = curr.next;
    }
    return curr;
}

//method II
public static Node middle(Node head){
    if(head==null){
        return null;
    }
    Node slow = head;
    Node fast = head;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

->nth node from end of Linked List

//method I
public static Node NthFromEnd(Node head,int k){
    if(head==null){
        return null;
    }
    int count = 0;
    Node curr = head;
    while(curr!=null){
        count++;
        curr = curr.next;
    }
    if(k>count){
        return null;
    }
    curr = head;
    for(int i=1;i<count-k+1;i++){
        curr = curr.next;
    }
    return curr;
}

//method II
public static Node NthFromEnd(Node head,int k){
    if(head==null){
        return null;
    }
    Node slow = head;
    Node fast = head;
    for(int i=0;i<k;i++){
        if(fast==null){
            return null;
        }
        fast = fast.next;
    }
    while(fast!=null){
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
}

->Reverse a Linked List(Iterative)

//method I (changing only values)
public static Node reverse(Node head){
    ArrayList<Integer> ans = new ArrayList<>();
    for(Node curr=head;curr!=null;curr=curr.next){
        ans.add(curr.data);
    }
    for(Node curr=head;curr!=null;curr=curr.next){
        curr.data = ans.remove(ans.size()-1);
    }
    return head;
}

//method II (changing the links)
public static Node reverse(Node head){
    Node curr = head;
    Node prev = null;
    while(curr!=null){
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

->Reverse a Linked List(Recursive)

//method I
public static Node reverse(Node head){
    if(head==null || head.next==null){
        return head;
    }
    Node rest_head = reverse(head.next);
    Node rest_tail = head.next;
    rest_tail.next = head;
    head.next = null;
    return rest_head;
}

//method II
public static Node reverse(Node curr,Node prev){
    if(curr==null){
        return prev;
    }
    Node next = curr.next;
    curr.next = prev;
    return reverse(next,curr);
}

->Delete node with only pointer given to it

public static void DeleteNode(Node ptr){
    Node temp = ptr.next;
    ptr.data = temp.data;
    ptr.next = temp.next;
    return ;
}

->Seggregate even and odd nodes

public static Node EvenAndOdd(Node head){
    if(head==null || head.next==null){
        return head;
    }
    Node ehead=null,etail=null,ohead=null,otail=null;
    for(Node curr=head;curr!=null;curr=curr.next){
        int x = curr.data;
        if(x%2==0){
            if(ehead==null){
                ehead = curr;
                etail = curr;
            }
            else{
                etail.next = curr;
                etail = etail.next;
            }
        }
        else{
            if(ohead==null){
                ohead = curr;
                otail = curr;
            }
            else{
                otail.next = curr;
                otail = otail.next;
            }
        }
    }
    if(ehead==null || ohead==null){
        return head;
    }
    otail.next = ehead;
    etail.next = null;
    return ohead;
}

->Clone a Linked List with random pointer

//method I
public static Node CloneaLL(Node head){
    HashMap<Node,Node> mp = new HashMap<>();
    for(Node curr=head;curr!=null;curr=curr.next){
        mp.put(curr,new Node(curr.data));
    }
    for(Node curr=head;curr!=null;curr=curr.next){
        Node clonecurr = mp.get(curr);
        clonecurr.next = mp.get(curr.next);
        clonecurr.random = mp.get(curr.random);
    }
    Node Nhead = mp.get(head);
    return Nhead;
}

//method II
public static Node CloneaLL(Node head){
    Node curr = head;
    while(curr!=null){
        Node next = curr.next;
        curr.next = new Node(curr.data);
        curr.next.next = next;
        curr = next;
    }
    for(Node curr=head;curr!=null;curr=curr.next.next){
        if(curr.random!=null){
            curr.next.random = curr.random.next;
        }
        else{
            curr.next.random = null;
        }
    }
    Node copy = head.next;
    Node original = head;
    Node Nhead = copy;
    while(copy!=null && original!=null){
        if(copy.next!=null){
            copy.next = copy.next.next;
        }
        else{
            copy.next = null;
        }
        if(original.next!=null){
            original.next = original.next.next;
        }
        else{
            original.next = null;
        }
        copy = copy.next;
        original = original.next;
    }
    return Nhead;
}

->Merge two sorted Linked List

public static Node MergeTwoSortedLL(Node head1,Node head2){
    if(head1==null){
        return head2;
    }
    if(head2==null){
        return head1;
    }
    Node Nhead=null,Ntail=null;
    Node curr1=head1,curr2=head2;
    if(curr1.data<curr2.data){
        Nhead = curr1;
        Ntail = curr1;
    }
    else{
        Nhead = curr2;
        Ntail = curr2;
    }
    while(curr1!=null && curr2!=null){
        if(curr1.data<curr2.data){
            Ntail.next = curr1;
            Ntail = Ntail.next;
        }
        else{
            Ntail.next = curr2;
            Ntail = Ntail.next;
        }
    }
    if(curr1!=null){
        Ntail.next = curr1;
    }
    if(curr2!=null){
        Ntail.next = curr2;
    }
    return Nhead;
}

->Pallindrome Linked List

//method I
public static boolean isPallindrome(Node head){
    Stack<Integer> st = new Stack<>();
    for(Node curr=head;curr!=null;curr=curr.next){
        st.push(curr.data);
    }
    Node curr = head;
    while(curr!=null){
        if(st.pop()!=curr.data){
            return false;
        }
        curr = curr.next;
    }
    return true;
}

//method II
public static boolean Pallindrome(Node head){
    Node slow = head;
    Node fast = head;
    while(fast.next!=null && fast.next.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    Node nhead = reverse(slow.next);
    while(nhead!=null){
        if(nhead.data!=head.data){
            return false;
        }
        nhead = nhead.next;
        head = head.next;
    }
    return true;
}

public static Node reverse(Node head){
    Node curr = head;
    Node prev = null;
    while(curr!=null){
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

->Detect loop(3 methods)

//method I
public static boolean IsCycle(Node head){
    if(head==null || head.next==null){
        return false;
    }
    Node temp = new Node(0);
    Node curr = head;
    while(curr!=null){
        if(curr.next==null){
            return false;
        }
        if(curr.next==temp){
            return true;
        }
        Node next = curr.next;
        curr.next = temp;
        curr = next;
    }
    return false;
}

//method II
public static boolean IsCycle(Node head){
    if(head==null || head.next==null){
        return false;
    }
    HashSet<Node> hs = new HashSet<>();
    for(Node curr=head;curr!=null;curr=curr.next){
        if(hs.contains(curr)==true){
            return false;
        }
        hs.add(curr);
    }
    return true;
}

//method III
public static boolean IsCycle(Node head){
    if(head==null || head.next==null){
        return false;
    }
    Node slow = head;
    Node fast = head;
    slow = slow.next;
    fast = fast.next.next;
    while(fast!=null && fast.next!=null){
        if(slow==fast){
            return true;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}

->Detect and remove Loop

public static Node DetectAndRemove(Node head){
    if(head==null || head.next==null){
        return null;
    }
    Node curr = head;
    Node slow = head;
    Node fast = head;
    slow = slow.next;
    fast = fast.next.next;
    boolean flag = false;
    while(fast!=null && fast.next!=null){
        if(slow==fast){
            flag = true;
            break;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    if(flag == false){
        return curr;
    }
    slow = head;
    while(slow.next!=fast.next){
        slow = slow.next;
        fast = fast.next;
    }
    fast.next = null;
    return curr;
}

->Remove Duplicate from a Sorted Linked List

public static Node RemoveDuplicate(Node head){
    Node curr = head;
    while(curr!=null && curr.next!=null){
        if(curr.data==curr.next.data){
            curr = curr.next.next;
        }
        else{
            curr = curr.next;
        }
    }
    return head;
}

->Sorted insert in Singly Linked List

public static Node SortedInsert(Node head,int data){
    if(head==null){
        return new Node(data);
    }
    Node curr = head;
    Node temp = new Node(data);
    if(data<head.data){
        temp.next = head;
        return temp;
    }
    while(curr.next!=null && curr.next.data>data){
        curr = curr.next;
    }
    temp.next = curr.next;
    curr.next = temp;
    return head;
}
