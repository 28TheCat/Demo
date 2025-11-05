
list= [1,2,3,4,5,6,7,8,9,10]
# print(list)
# for i in range(len(list)):
#     print(str(list[i]) + " ",end= "")

# list.reverse()
# print(list)
list1=[
    [3,2,3],
    [4,5,6],
    [7,8,9]
]
print(list1[1][2])
print(list1[1][-2])
for i in list1:
    print(type(i))
    for j in i:
        print(j,end=" ")
    print()

for i in list:
    print(i,end=" ")