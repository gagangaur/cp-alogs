def formdate(l,arr):
  final=""
  month=[31,28,31,30,31,30,31,31,30,31,30,31]
  m1,m2,d1,d2,h1,h2,mm1,mm2=-1,-1,-1,-1,-1,-1,-1,-1
  if arr[1]>0:
    m1=1
    arr[1]-=1
  else:
    if arr[0]>0:
      m1=0
      arr[0]-=1
    else:
      return 0
  if m1==1:
    if arr[2]>0:
      m2=2
      arr[2]-=1
    elif arr[1]-1>0:
      m2=1
      arr[1]-=1
    elif arr[0]>0:
      m2=0
      arr[0]-=1
    else:
      return 0
  if m1==0:
    for i in range(9,-1,-1):
      if arr[i]>0:
        m2=i
        arr[i]-=1
        break
    if m2==0:
      return 0
  xx=int(str(m1)+str(m2))
  date = month[xx-1]
  # print(date)
  flg=0
  for i in range(date,0,-1):
    ss=str(i)
    if len(ss)>1:
      first,sec=int(ss[0]),int(ss[1])
      multidate=0
      if i%11==0:
        multidate=1
      if (multidate==1 and arr[first]>0 and arr[sec]-1>0) or (multidate==0 and arr[first]>0 and arr[sec]>0):
        d1,d2=first,sec
        arr[d1]-=1
        arr[d2]-=1
        flg=1
        break
    else:
      first,sec=0,int(ss[0])
      multidate=0
      if i%11==0:
        multidate=1
      if (multidate==1 and arr[first]>0 and arr[sec]-1>0) or (multidate==0 and arr[first]-1>0 and arr[sec]>0):
        d1,d2=first,sec
        arr[d1]-=1
        arr[d2]-=1
        flg=1
        break
  # print(flg)
  if flg==0:
    return 0
  final+=str(m1)+str(m2)+"/"+str(d1)+str(d2)+" "
  # print(final)
  flag=0
  for i in range(23,-1,-1):
    ss=str(i)
    multitime=0
    if i%11==0:
      multitime=1
    if len(ss)>1:
      fi,se=int(ss[0]),int(ss[1])
      if (multitime==1 and arr[fi]>0 and arr[se]-1>0) or (multitime==0 and arr[fi]>0 and arr[se]>0):
        h1,h2=fi,se
        arr[h1]-=1
        arr[h2]-=1
        flag=1
        break
    else:
      fi,se=0,int(ss[0])
      if arr[fi]>0 and arr[se]>0:
        h1,h2=fi,se
        flag=1
        arr[h1]-=1
        arr[h2]-=1
        break
  # print(flag)
  if flag==0:
    return 0
  final+=str(h1)+str(h2)+":"
  for i in range(59,-1,-1):
    ss=str(i)
    multimin=0
    if i%11==0:
      multimin=1
    if len(ss)>1:
      fi,se=int(ss[0]),int(ss[1])
      if (multimin==1 and arr[fi]>0 and arr[se]-1>0) or (multimin==0 and arr[fi]>0 and arr[se]>0):
        mm1,mm2=fi,se
        flag=1
        break
    else:
      fi,se=0,int(ss[0])
      if arr[fi]-1>0 and arr[se]>0:
        mm1,mm2=fi,se
        flag=1
        break
  if flag==0:
    return 0
  final+=str(mm1)+str(mm2)
  return final
l=list(map(int,input().split(",")))
arr=[0]*10
for i in l:
  arr[i]+=1
ans=formdate(l,arr)
if ans==0 or '-1' in ans:
  print(0,end="")
else:
  print(ans,end="")
# print(arr)
# 0,6,1,5,2,4,8,0,9