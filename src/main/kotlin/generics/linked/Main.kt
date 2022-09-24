package generics.linked

fun main(){

    var list = MyLinkedList<Int>()
    var list2 = listOf<Int>(7, 8, 65)
    list.add(5)
    list.add(10)
    list.add(15)
    list.add(20)
    list.add(10)
    list.add(40)

    list.add(200, 55)
    list.replaceAll(10, 150)

    println("get  = "+list.get(10))


    //list.addAll(0,list2)
    println("size =" + list.size)

    println(list.get(2))
    //list.clear()
//    list.remove(10)

        //  println("First Index = "+list.getIndicesOf(10))

    list.printAll()
}