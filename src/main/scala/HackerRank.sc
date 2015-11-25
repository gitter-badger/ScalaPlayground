val input = List[Int](3,2,4,6,5,7,8,0,1)

input.foldLeft(0)((acc,e1) =>
  if(e1 % 2 != 0) acc + e1 else acc)

def f(arr:List[Int]):Int = {
  arr.foldLeft(0)((acc,_) => acc+1)
}
f(input)

