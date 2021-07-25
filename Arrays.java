->count triplets
->rearrange array alternatively
->number of pairs
->inversion of array
->minimum Platform
->Reverse Array in groups
->Pythagorean Triplet
->chocolate distribution Problem
->Stock buy and sell
->Element with left side smaller and right side greater
->convert array into Zigzag fashion
->Last index of 1
->Largest Number formed from an Array
->Repeating and Missing Number
->set Matrix Zeros
->Rotate a Matrix
->grid unique Paths
->reverse Pairs


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

->Maximum Difference Problem

//method I
public static int maxdiff(int[] arr){
    int res = arr[1]-arr[0];
    for(int i=0;i<arr.length-1;i++){
        for(int j=i+1;j<arr.length;j++){
            res = Math.max(arr[j]-arr[i]);
        }
    }
    return res;
}

//method II
public static int maxdiff(int[] arr){
    int maxdiff = arr[1]-arr[0];
    int minval = arr[0];
    for(int i=1;i<arr.length;i++){
        maxdiff = Math.max(maxdiff,arr[i]-minval);
        minval = Math.min(minval,arr[i]);
    }
    return maxdiff;
}

->Maximum Consecutive One's

public static int ConsecutiveOnes(int[] arr){
    int res = 0;
    int count = 0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]==1){
            count++;
            res = Math.max(res,count);
        }
        else{
            count=0;
        }
    }
    return res;
}

->Longest Even Odd SubArray

public static int LongestEvenOdd(int[] arr){
    int count = 1;
    int res = 1;
    for(int i=1;i<arr.length;i++){
        if((arr[i]%2==0 && arr[i-1]%2!=0) ||
        (arr[i]%2!=0 && arr[i-1]%2==0)){
            count++;
            res = Math.max(res,count);
        }
        else{
            count = 1;
        }
    }
    return res;
}

->Maximum Circular Sum SubArray

//method I
public static int MaximumCircularSum(int[] arr){
    int maxval = arr[0];
    int sum = 0;
    for(int i=0;i<arr.length;i++){
        sum = 0;
        for(int j=0;j<arr.length;j++){
            int idx = (i+j)%arr.length;
            sum += arr[idx];
            maxval = Math.max(maxval,sum);
        }
    }
    return maxval;
}

//method II
public static int MaximumCircularSum(int[] arr){
    int max_normal = MaximumSumSubarray(arr);
    if(max_normal<0){
        return max_normal;
    }
    int sum=0;
    for(int i=0;i<arr.length;i++){
        sum += arr[i];
        arr[i] = -arr[i];
    }
    int max_circular = sum + MaximumSumSubarray(arr);
    return Math.max(max_normal,max_circular);
}

public static int MaximumSumSubarray(int[] arr){
    int maxending = arr[0];
    int res = arr[0];
    for(int i=1;i<arr.length;i++){
        maxending = Math.max(maxending+arr[i],arr[i]);
        res = Math.max(res,maxending);
    }
    return res;
}

->Minimum Consecutive Flips

public static void MinimumConsecutiveFlips(int[] arr){
    for(int i=1;i<arr.length;i++){
        if(arr[i]!=arr[i-1]){
            if(arr[i]!=arr[0]){
                System.out.print("Start Index"+i);
            }
            else{
                System.out.print("End Index"+i-1);
            }
        }
    }
    if(arr[n-1]!=arr[0]){
        System.out.print("End Index"+n-1);
    }
    return ;
}

->N-bonacci numbers

//m>n
public static int NBonacciNumber(int n,int m){
    int[] arr = new int[m];
    for(int i=0;i<m;i++){
        arr[i]=0;
    }
    arr[n-1]=1;
    arr[n]=1;
    for(int i=n+1;i<m;i++){
        arr[i] = 2*arr[i-1]-arr[i-n-1];
    }
    return arr[m-1];
}

->merge two sorted arrays

public static void MergeInplace(int[] X,int[] Y){
    int m = X.length;
    int n = Y.length;
    for(int i=0;i<m;i++){
        if(X[i]>Y[0]){
            int temp = X[i];
            X[i] = Y[0];
            Y[0] = temp;
            
            int val = Y[0];
            for(int k=1;k<n && Y[k]<val;k++){
                Y[k-1]=Y[k];
            }
            Y[k-1]=val;
        }
    }
    return ;
}

->Missing number in an array

//method I
public static int MissingNumber(int[] arr){
    int n = arr.length;
    int m = n+1; // since one no is missing
    int sum = m*(m+1)/2;
    for(int i=0;i<n;i++){
        sum -= arr[i];
    }
    return sum;
}

//method II
public static int FindMissingNumber(int[] arr){
    int xor = 0;
    for(int val : arr){
        xor = xor^val;
    }
    for(int i=1;i<=arr.length+1;i++){
        xor = xor^i;
    }
    return xor;
}

->Find duplicate in Array of Size n+1

//method I
public static int FindDuplicate(int[] arr){
    int n = arr.length;
    boolean[] visited = new int[n+1];
    for(int val : arr){
        if(visited[val]==true){
            return val;
        }
        visited[val]=true;
    }
    return -1;
}

//method II
public static int FindDuplicate(int[] arr){
    int xor = 0;
    for(int val : arr){
        xor ^= val;
    }
    for(int i=1;i<=arr.length-1;i++){
        xor ^= i;
    }
    return xor;
}

->Print Pascal Triangle

public static void PrintPattern(int n){
    for(int i=0;i<n;i++){
        int ncr = 1;
        for(int j=0;j<=i;j++){
            System.out.print(ncr+" ");
            int ncr1 = ((i-j)*ncr)/(j+1);
            ncr = ncr1;
        }
        System.out.println();
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

->Maximum Subarray Problem

//method I
public static int MaximumSumSubarray(int[] arr){
    int res = 0;
    for(int i=0;i<arr.length;i++){
        sum = 0;
        for(int j=i;j<arr.length;j++){
            sum += arr[j];
            res = Math.max(sum,res);
        }
    }
    return res;
}

//method II
public static int MaximumSumSubarray(int[] arr){
    int maxending = arr[0];
    int res = arr[0];
    for(int i=1;i<arr.length;i++){
        maxending = Math.max(maxending+arr[i],arr[i]);
        res = Math.max(res,maxending);
    }
    return res;
}

->Majority Element

//method I
public static int Majority(int[] arr){
    int freq = 0;
    for(int i=0;i<arr.length;i++){
        freq = 1;
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]==arr[j]){
                freq++;
            }
        }
        if(freq>arr.length/2){
            System.out.print(arr[i]);
        }
    }
    return ;
}

//method II
public static int Majority(int[] arr){
    int count = 0;
    int res = -1;
    for(int i=0;i<arr.length;i++){
        if(count==0){
            count = 1;
            res = arr[i];
        }
        else if(res==arr[i]){
            count+=1;
        }
        else{
            count-=1;
        }
    }
    return res;
}

->Equilibrium Point

//method I
public static int EqbPoint(int[] arr){
    for(int i=0;i<arr.length;i++){
        int lsum=0,rsum=0;
        for(int j=0;j<i;j++){
            lsum += arr[j];
        }
        for(int j=i+1;j<arr.length;j++){
            rsum += arr[j];
        }
        if(lsum==rsum){
            return i;
        }
    }
    return -1;
}

//method II
public static int EqbPoint(int[] arr){
    int sum = 0;
    for(int i=0;i<arr.length;i++){
        sum += arr[i];
    }
    int lsum = 0;
    for(int i=0;i<arr.length;i++){
        if(lsum == sum-arr[i]){
            return i;
        }
        lsum += arr[i];
        sum -= arr[i];
    }
    return -1;
}

->Prefix Sum Array

public static int[] PrefixSum(int[] arr){
    int n = arr.length;
    int[] prefix = new int[n];
    prefix[0] = arr[0];
    for(int i=1;i<n;i++){
        prefix[i] = prefix[i-1]+arr[i];
    }
    return prefix;
}

public static int getsum(int[] prefix,int l,int r){
    if(l!=0){
        return prefix[r]-prefix[l-1];
    }
    else{
        return prefix[r];
    }
}

->Maximum Occuring Element

public static int MaximumOccuringElement(int[] left,int[] right){
    int[] freq = new int[1000];
    for(int i=0;i<left.length;i++){
        freq[left[i]]++;
        freq[right[i]+1]--;
    }
    int res = 0;
    int maxfreq = freq[0];
    for(int i=1;i<1000;i++){
        freq[i] += freq[i-1];
        if(freq[i]>maxfreq){
            maxfreq = freq[i];
            res = i;
        }
    }
    return res;
}

->Frequency in an Sorted array

public static void FrequencyInSortedArray(int[] arr){
    int i=1;
    int freq = 1;
    while(i<arr.length){
        while(i<arr.length && arr[i]==arr[i-1]){
            freq++;
            i++;
        }
        System.out.print(arr[i-1]+"Freq is"+freq);
        freq=1;
        i++;
    }
    return ;
}

->Stock buy and Sell

//method I
public static int MaxProfit(int[] arr,int start,int end){
    if(start>=end){
        return 0;
    }
    int profit = 0;
    int curr_profit = 0;
    for(int i=start;i<end;i++){
        for(int j=i+1;j<=end;j++){
            if(arr[j]>arr[i]){
                curr_profit = arr[j]-arr[i] + 
                MaxProfit(arr,start,i-1) +
                MaxProfit(arr,j+1,end);
                profit = Math.max(curr_profit,profit);
            }
        }
    }
    return profit;
}

//method II
public static int MaxProfit(int[] arr){
    int profit = 0;
    for(int i=1;i<arr.length;i++){
        if(arr[i]>arr[i-1]){
            profit += arr[i]-arr[i-1];
        }
    }
    return profit;
}

->Spirally traversing a Matrix

public static void traverse(int[][] matrix){
    int rmin = 0,rmax = matrix.length-1;
    int cmin = 0,cmax = matrix[0].length-1;
    int tel = matrix.length*matrix[0].length;
    while(tel>0){
        for(int i=rmin;i<=rmax && tel>0;i++){
            System.out.print(matrix[i][cmin]);
            tel--;
        }
        cmin++;
        for(int j=cmin;j<=cmax && tel>0;j++){
            System.out.print(matrix[rmax][j]);
            tel--;
        }
        rmax--;
        for(int i=rmax;i>=rmin && tel>0;i--){
            System.out.print(matrix[i][cmax]);
            tel--;
        }
        cmax--;
        for(int j=cmax;j>=cmin && tel>0;j--){
            System.out.print(matrix[rmin][j]);
            tel--;
        }
        rmin++;
    }
    return ;
}

->Power(X,n)

public static int Power(int a,int b){
    if(b==0){
        return 1;
    }
    int res = Power(a,b/2);
    res *= res;
    return b%2==0?res:res*a;
}

->sort an array of 0's,1's and 2's

public static void SortAnArray(int[] arr){
    int lo=0,mid=0;
    int hi=arr.length-1;
    while(mid<=hi){
        if(arr[mid]==0){
            swap(arr,lo,mid);
            lo++;
            mid++;
        }
        else if(arr[mid]==1){
            mid++;
        }
        else{
            swap(arr,lo,hi);
            hi--;
        }
    }
}

public static void swap(int[] arr,int lo,int hi){
    int temp = arr[lo];
    arr[lo] = arr[hi];
    arr[hi] = temp;
    return ;
}

->Trapping Rain Water

//method I
public static int RainWaterTrapping(int[] arr){
    int res = 0;
    for(int i=1;i<arr.length-1;i++){
        int lmax = arr[i];
        for(int j=0;j<i;j++){
            lmax = Math.max(lmax,arr[j]);
        }
        int rmax = arr[i];
        for(int j=i+1;j<arr.length;j++){
            rmax = Math.max(rmax,arr[i]);
        }
        res += (Math.min(lmax,rmax)-arr[i]);
    }
    return res;
}

//method II
public static int RainWaterTrapping(int[] arr){
    int[] lmax = new int[arr.length];
    int[] rmax = new int[arr.length];
    lmax[0] = arr[0];
    for(int i=1;i<arr.length;i++){
        lmax[i] = Math.max(lmax[i-1],arr[i]);
    }
    rmax[arr.length-1] = arr[arr.length-1];
    for(int i=arr.length-2;i>=0;i--){
        rmax[i] = Math.max(rmax[i+1],arr[i]);
    }
    int res = 0;
    for(int i=1;i<arr.length-1;i++){
        res += (Math.min(lmax[i],rmax[i])-arr[i]);
    }
    return res;
}


->Merge OverLapping intervals

public static int[] MergeIntervals(int[][] intervals){
    ArrayList<int[]> res = new ArrayList<>();
    if(intervals.length==0 || intervals==null){
        return res.toArray(new int[res.size()][]);
    }
    Arrays.sort(intervals,(a,b)->a[0]-b[0]);
    int start = intervals[0][0];
    int end = intervals[0][1];
    for(int[] arr : intervals){
        if(end >= arr[0]){
            end = Math.max(end,arr[1]);
        }
        else{
            res.add(new int{start,end});
            start = arr[0];
            end = arr[1];
        }
    }
    res.add(new int{start,end});
    return res.toArray(new int[res.size()][]);
}

->Majority Element II

public static ArrayList<Integer> MajotityElementII(int[] arr){
    int ele1 = -1;
    int ele2 = -1;
    int c1=0,c2=0;
    for(int val : arr){
        if(c1==0){
            c1=1;
            ele1=val;
        }
        else if(c2==0){
            c2=1;
            ele2=val;
        }
        else if(val==ele1){
            c1++;
        }
        else if(val==ele2){
            c2++;
        }
        else{
            c1-=1;
            c2-=1;
        }
    }
}

->Next Permutation

public void nextPermutation(int[] nums){
    int n = nums.length;
    int idx1 = 0;
    boolean flag = false;
    for(int i=n-2;i>=0;i--){
        if(nums[i+1]>nums[i]){
            idx1 = i;
            flag = true;
            break;
        }
    }
    if(flag == false){
        reverse(nums,0,n-1);
        return ;
    }
    for(int j=n-1;j>=0;j--){
        if(nums[j]>nums[idx1]){
            int temp = nums[idx1];
            nums[idx1] = nums[j];
            nums[j] = temp;
            break;
        }
    }
    reverse(nums,idx1+1,n-1);
}

public void reverse(int[] nums,int li,int hi){
    while(li<hi){
        int temp = nums[li];
        nums[li] = nums[hi];
        nums[hi] = temp;
        li++;
        hi--;
    }
}

->Search in a 2D Matrix

//method I
public static boolean SearchInMatrix(int[][] matrix,int val){
    int i=0,j=matrix.length-1;
    while(i<matrix.length && j>=0){
        if(matrix[i][j]==val){
            return true;
        }
        else if(matrix[i][j]>val){
            j--;
        }
        else{
            i++;
        }
    }
    return false;
}

//method II
public static boolean SearchInMatrix(int[][] matrix,int val){
    int lo=0,hi=matrix.length*matrix[0].length-1;
    int n = matrix.length;
    int m = matrix[0].length;
    while(lo<=hi){
        int mid = (lo+hi)/2;
        if(arr[mid/n][mid%m]==val){
            return true;
        }
        else if(arr[mid/n][mid%m]>val){
            hi=mid-1;
        }
        else{
            lo=mid+1;
        }
    }
    return false;
}

->Find Subarray with Given Sum

public static void SubArraySum(int[] arr,int sum){
    int curr_sum=arr[0],start=0;
    for(int i=1;i<arr.length;i++){
        while(curr_sum>sum && start<i-1){
            curr_sum -= arr[start];
            start++;
        }
        if(curr_sum==sum){
            int end = i-1;
            System.out.print("Start Index"+start+"End Index"+end);
            return ;
        }
        if(i<n){
            curr_sum += arr[i];
        }
    }
    return ;
}

->Sum of K Consecutive Elements

//method I
public static int SumOfKConsecutiveElements(int[] arr,int k){
    int n = arr.length;
    int sum = Integer.MIN_VALUE;
    for(int i=0;i+k-1<n;i++){
        int curr_sum=0;
        for(int j=0;j<k;j++){
            curr_sum += arr[i+j];
        }
        sum = Math.max(sum,curr_sum);
    }
    return sum;
}

//method II
public static int SumOfKConsecutiveElements(int[] arr,int k){
    int curr_sum = 0;
    for(int i=0;i<k;i++){
        curr_sum += arr[i];
    }
    int sum = curr_sum;
    for(int i=k;i<arr.length;i++){
        curr_sum += arr[i]-arr[i-k];
        sum = Math.max(sum,curr_sum);
    }
    return sum;
}



