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

