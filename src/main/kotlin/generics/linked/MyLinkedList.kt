package generics.linked

class MyLinkedList<T> {
    var head: Node<T>? = null
    var size = 0

    fun add(data: T){
        if(size == 0) addFirst(data)
        else addLast(data)
    }

    fun printAll(){
        var currentNode = head
        while (currentNode != null){
            println("item: "+ currentNode.data)
            currentNode = currentNode.next
        }
    }

    fun add(index: Int, data: T){
        if(index > size-1){
            println("Index tapılmadı.")
            return
        }

        if(index == 0){
            var currentNode = Node(data = data)
            currentNode!!.next = head
            head = currentNode
            size++

        }
        if(index>0){
            addByIndex(index, data)
        }
    }

    fun get(index: Int): T{
        if(index > size-1){
            println("Index tapılmadı.")
        }

        var currentNode = head
        var i = 0
        while(currentNode?.next != null){
            if(i == index) break

            currentNode = currentNode.next

            i++
        }
        return currentNode!!.data
    }

    fun replace(index: Int, data: T){
        if(index > size-1){
            println("Index tapılmadı.")
            return
        }

        var currentNode = head
        var nodeAfterIndex = head
        var i = 1

        while(currentNode?.next != null){
            if(index == 0){
                nodeAfterIndex = currentNode.next

                head = Node(data = data)
                currentNode = head
                currentNode!!.next = nodeAfterIndex

                break
            }
            if(i == index){

                nodeAfterIndex = currentNode.next!!.next

                currentNode.next = Node(data = data)
                currentNode = currentNode.next
                currentNode!!.next = nodeAfterIndex

                break
            }

            currentNode = currentNode.next

            i++
        }
    }

    fun replaceAll(old: T, data: T){

        var currentNode = head
        var i = 0

        while(currentNode != null){

            if(currentNode.data == old){
                replace(i, data)
            }

            currentNode = currentNode.next
            i++

        }
    }

    private fun addByIndex(index: Int, data: T){
        var i = 1
        var currentNode = head
        var nodeAfterIndex = head
        while(currentNode?.next != null){
            if(i == index){

                nodeAfterIndex = currentNode.next

                currentNode!!.next = Node(data = data)
                currentNode = currentNode.next
                currentNode!!.next = nodeAfterIndex

                size++
                break

            }

                currentNode = currentNode.next


            i++

        }
    }

    fun addAll(items: List<T>){
        for(a in items){
            addLast(a)
        }
    }

    fun addAll(index: Int, items: List<T>){
        var currentNode = head
        var i = index
        for(a in items){
            add(i, a)
            i++
        }
    }


    fun removeAt(index: Int){
        var currentNode = head
        var nodeAfterIndex: Node<T>? = null;
        var i = 1
        // i = 1
        while(currentNode?.next != null){
            if(index == 0){
                head = currentNode.next
                break
            }
            if(i == index){
                currentNode.next = currentNode.next!!.next

                break
            }

            currentNode = currentNode.next
            i++
        }
    }

    fun remove(data: T){
        var currentNode = head
        var i = 0

        while(currentNode != null){

            if(currentNode.data == data) {
                removeAt(i)
                i--
            }

            currentNode = currentNode.next
            i++

        }
    }

    fun getFirstIndexOf(data: T): Int{

        var currentNode = head
        var i = 0

        while(currentNode != null){

            if(currentNode.data == data){
                break
            }

            currentNode = currentNode.next

            i++
        }

        return i
    }

    fun getLastIndexOf(data: T): Int{

        var currentNode = head
        var lastIndex = 0
        var i = 0


        while(currentNode != null){

            if(currentNode.data == data){
                lastIndex = i
            }

            currentNode = currentNode.next

            i++
        }

        return lastIndex
    }

    fun getIndicesOf(data: T): List<Int>{
        var currentNode = head
        var indexList = mutableListOf<Int>()
        var i = 0


        while(currentNode != null){

            if(currentNode.data == data){
                indexList.add(i)
            }

            currentNode = currentNode.next

            i++
        }

        return indexList
    }

    fun clear(){
        head = null
        size = 0
    }

    private fun addFirst(data: T){
        head = Node( data = data)
        size++
    }

    private fun addLast(data: T){
        var currentNode = head

        while(currentNode?.next != null){
            currentNode = currentNode.next
        }

        currentNode!!.next = Node(data = data)
        size++
    }


}

data class Node<T>(var next: Node<T>? = null, var data: T)