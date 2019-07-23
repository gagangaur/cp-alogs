class Solution:
    # @param A : list of integers
    # @return a list of integers
    def plusOne(self, a):
        a = a[::-1]
        n = len(a)
        y = 1
        for i in range(n):
            x = a[i]+y
            ans = str(x)
            ans = list(ans)
            if len(str(x))>1:
                y = int(ans[0])
            else:
                y = 0
            a[i] = ans[-1]
        if y!=0:
            a.append(y)
        a=a[::-1]
        ss=""
        for i in range(len(a)):
            ss+=str(a[i])
        ss=int(ss)
        ss=str(ss)
        answer = []
        for i in ss:
            answer.append(i)
        return answer
            
            
        
            