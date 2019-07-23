class Solution:
	def coverPoints(self, a, b):
	    if len(a)==1:
	        return 0
	    s=0
        for i in range(len(a)-1):
            s+=max(abs(a[i]-a[i+1]),abs(b[i]-b[i+1]))
        return s