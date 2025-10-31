def sum_list(list):
    sum=0
    for i in range(len(list)):
        sum+=list[i]
    return sum

list1=[1,2,3,4,5]
print(sum_list(list1))