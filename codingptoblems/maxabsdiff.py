class Solution:
    # @param A : list of integers
    # @return an integer
    def maxArr(self, a):
        n = len(a)
        s=0
        max1,min1,max2,min2=-1000000000,1000000000,-1000000000,1000000000
        for i in range(n):
            max1 = max(max1,a[i]+i)
            min1 = min(min1,a[i]+i)
            max2 = max(max2,a[i]-i)
            min2 = min(min2,a[i]-i)
        return max(max1-min1,max2-min2)