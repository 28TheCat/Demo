def filter_list(l):
    result = []
    for i in range(len(l)):
        if l[i] % 2 != 0:
            result.append(l[i])
    return result

print(filter_list([1,2,3,4,5,6,7,8,9,10]))
