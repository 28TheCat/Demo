def reverse(s):
    s1 = ''
    for i in range(len(s)):
        s1+=s[len(s)-i-1]
    return s1
s = 'hello world'
print(reverse(s))