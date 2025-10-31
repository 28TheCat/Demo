def max_num(list):
    max=list[0];
    for i in range(1,len(list)):
        if max<list[i]:
            max=list[i]
    return  max

list=[1,2,3,4,5,6,7,8,9,10]
print(max_num(list))