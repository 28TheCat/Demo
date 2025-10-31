def is_palindrome(s):
    for i in range(0, int(len(s) / 2)):
        if s[i] != s[len(s) - i - 1]:
            return False
    return  True

print (is_palindrome('abcdcba'))