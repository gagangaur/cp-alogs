def isvalid(ii,jj,mat,vis):
    n,m=len(mat),len(mat[0])
    if ii>=0 and ii<n and jj>=0 and jj<m and vis[ii][jj]==0 and mat[ii][jj]!=1:
        return True
    return False
def bfs(ii,jj,mat,vis):
    l = []
    l.append([ii,jj])
    while len(l)>0:
        x = l.pop(0)
        i,j = x[0],x[1]
        if i==0 or j==0 or i==n-1 or j==m-1:
            return mat[i][j]
        if isvalid(i-1,j,mat,vis):
            mat[i-1][j] = mat[i][j]+1
            l.append([i-1,j])
        if isvalid(i+1,j,mat,vis):
            mat[i+1][j] = mat[i][j]+1
            l.append([i+1,j])
        if isvalid(i,j-1,mat,vis):
            mat[i][j-1] = mat[i][j]+1
            l.append([i,j-1])
        if isvalid(i,j+1,mat,vis):
            mat[i][j+1] = mat[i][j]+1
            l.append([i,j+1])
        vis[i][j]=1
    return -1
n,m = map(int,input().split())
mat = [ list(map(int,input().split())) for i in range(n) ]
vis = [ [ 0 for i in range(m) ] for j in range(n) ]
for i in range(n):
    for j in range(m):
        if mat[i][j]==2:
            mat[i][j]=0
            ans = bfs(i,j,mat,vis)
print(*mat,sep="\n")
print()
print(*vis,sep="\n")
print(ans)