->Largest Element in an Array

public static int largest(int[] arr){
    int maxval = Integer.MIN_VALUE;
    for(int val : arr){
        maxval = Math.max(val,maxval);
    }
    return maxval;
}

->Second Largest Element in an Array

//method I
public static int SecondLargest(int[] arr){
    int res = -1;
    int max1 = largest(arr);
    for(int val : arr){
        if(val!=max1){
            if(res==-1 || res<val){
                res = val;
            }
        }
    }
    return res;
}
 
//method II
public static int SecondLargest(int[] arr){
    int res = -1;
    int max = arr[0];
    for(int val : arr){
        if(val>max){
            res = max;
            max = val;
        }
        else if(val<max){
            if(res==-1 || res<val){
                res = val;
            }
        }
    }
    return res;
}

->Check if an Array is Sorted

//method I
public static boolean IsSorted(int[] arr){
    for(int i=0;i<arr.length-1;i++){
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]>arr[j]){
                return false;
            }
        }
    }
    return true;
}

//method II
public static boolean IsSorted(int[] arr){
    for(int i=1;i<arr.length;i++){
        if(arr[i]<arr[i-1]){
            return false;
        }
    }
    return true;
}

->Reverse an Array
//we can also suggest one more method by help of stack 

public static void Reverse(int[] arr){
    int lo = 0;
    int hi = arr.length-1;
    while(lo<hi){
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
        lo++;
        hi--;
    }
    return ;
}

->Remove Duplicates from an Sorted array

//method I
public static void RemoveDuplicate(int[] arr){
    int res = 1;
    int[] temp = new int[arr.length];
    temp[0]=arr[0];
    for(int i=1;i<arr.length;i++){
        if(temp[res-1]!=arr[i]){
            temp[res]=arr[i];
            res++;
        }
    }
    for(int i=0;i<arr.length;i++){
        arr[i]=temp[i];
    }
    return res;
}

//method II
public static void RemoveDuplicateArray(int[] arr){
    //res here indicate no of unique elements
    int res = 1;
    for(int i=1;i<arr.length;i++){
        if(arr[res-1]!=arr[i]){
            arr[res]=arr[i];
            res++;
        }
    }
    return res;
}

->Move Zeros to End

//method I
public static void MoveZeros(int[] arr){
    for(int i=0;i<arr.length;i++){
        if(arr[i]==0){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]!=0){
                    swap(arr[i],arr[j]);
                }
            }
        }
    }
    return ;
}

//method II
public static void MoveZeros(int[] arr){
    //idx here shows the no of non zero elements at curr moment
    //or idx can be says as index of first zero
    int idx = 0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]!=0){
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
            idx++;
        }
    }
    
}

->Left Rotate an Array by One

public static void LeftRotateByOne(int[] arr){
    int ele = arr[0];
    for(int i=1;i<arr.length;i++){
        arr[i-1]=arr[i];
    }
    arr[arr.length-1]=ele;
    return ;
}

->Left Rotate an Array by d th

//method I
public static void LeftRotateByD(int[] arr,int d){
    int[] temp = new int[d];
    for(int i=0;i<d;i++){
        temp[i]=arr[i];
    }
    for(int i=d;i<arr.length;i++){
        arr[i-d]=arr[i];
    }
    int n = arr.length;
    for(int i=0;i<d;i++){
        arr[n-d+i]=temp[i];
    }
    return ;
}

//method II
public static void LeftRotateByD(int[] arr,int d){
    int n = arr.length;
    reverse(arr,0,d-1);
    reverse(arr,d,n-1);
    reverse(arr,0,n-1);
}

public static void reverse(int[] arr,int lo,int hi){
    while(lo<hi){
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
        lo++;
        hi--;
    }
}

->Leader in an Array

//method I
public static void Leaders(int[] arr){
    for(int i=0;i<arr.length;i++){
        flag=true;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]>=arr[i]){
                flag=false;
                break;
            }
        }
        if(flag==true){
            System.out.print(arr[i]);
        }
    }
    return ;
}

//method II
public static void Leaders(int[] arr){
    int curr_ldr = arr[arr.length-1];
    System.out.print(curr_ldr);
    for(int i=arr.length-2;i>=0;i--){
        if(arr[i]>curr_ldr){
            curr_ldr=arr[i];
            System.out.print(curr_ldr);
        }
    }
    return ;
}