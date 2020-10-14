def solution(l):
    list1 = [] # this is the list for the nested strings
    for x in l:
        list1.append(x.split("."))
    list2 = [] # this is the same list as list one except everything  is an integer in order for proper sorting
    for y in list1:
        y = list(map(int, y))
        list2.append(y)
    list3 = sorted(list2) #this is the sorted list of of list 2
    FinalList = [] # this is the list that converts everything back to the way it was
    for a in list3:
        a = '.'.join(str(z) for z in a)
        FinalList.append(a)
    return FinalList
