money = 1000

def view(name):
    print("============主菜单===========")
    print("欢迎%s登录ATM机" % name)
    print("1.查询余额")
    print("2.取款")
    print("3.存款")
    print("4.退出")

def query(name):
    print("查询余额")
    print("用户%s的余额为%d" % (name, money))

def withdraw(name):
    global money
    print("取款")
    withdraw_amount = int(input("请输入取款金额:"))
    if withdraw_amount > money:
        print("余额不足，取款失败！")
    else:
        money -= withdraw_amount
        print("取款成功，余额为%d" % money)

def deposit(name):
    global money
    print("存款")
    deposit_amount = int(input("请输入存款金额:"))
    money += deposit_amount
    print("存款成功，余额为%d" % money)

name = input("请输入用户名: ")

while True:
    view(name)
    choice = input("请选择操作：")
    if choice == "1":
        query(name)
    elif choice == "2":
        withdraw(name)
    elif choice == "3":
        deposit(name)
    elif choice == "4":
        print("欢迎下次光临")
        break
    else:
        print("输入错误，请重新输入")
