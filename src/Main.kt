import kotlin.reflect.KClass

/*
Collection
 - 자료 구조에 나오는 다양한 Data 관리 기법을 사용할 수 있도록 제공하고 있는 Library
 1. List : 순서를 통해 관리합니다.
 2. Map : 이름을 통해 관리합니다.
 3. Set : 집합 관리

List
 - 배열과 동일하게 Index 번호를 통해 객체를 관리합니다.
 - 배열은 크기가 정해지면 변경할 수 없지만 List 는 추가, 삭제가 가능합니다.

List 생성 Method
 - listOf() : 불변형 리스트 생성
 - mutableListOf() : 가변형  List 생성
 - emptyList() : 비어있는 불변형 List 를 생성합니다.
 - listOfNotNull : null 을 제외한 나머지만으로 List 를 생성합니다.

List Method
 - indexOf () : 지정된 값의 Index 번호를 반환합니다. 값이 없을 경우 -1 을 반환합니다.
 - lastIndexOf () : 지정된 값이 마지막에 해당하는 값의 Index 번호를 반환합니다. 값이 없을 경우 -1 을 반환합니다.
 - subList () : 지정된 범위의 값을 추출하여 새로운 List 를 생성해 반환합니다.

가변형 List Method
 - add (Object) : 해당 객체를 추가합니다.
 - add (Index, Object) : 해당 Index 위치에 객체를 삽입 추가합니다.
 - remove (Object) : 해당객체를 제거합니다.
 - removeAt (Index) : 해당 Index 를 객체를 제거합니다.
 - set (Index, Objec) : 주어진 Index 에 객체를 덮어 씌웁니다.

Set => List (변경)
 - toList () : 불변형 List 로 변경합니다.
 - toMutable () : 가변형 List 로 변경합니다.

List => Set (변경)
 - toSet () : 불변형 Set 으로 변경합니다.
 - toMutableSet () : 가변형 Set 으로 변환합니다.
 * Set 의 특성에 따라 중복된 객체는 제거됩니다. *
 * List 의 Index 순서를 보장받을 수 없습니다. *

 */

fun main() {

    // 불변형 List
    val list1 = listOf <Int> (10, 20, 30, 40, 50) // Generic 생략 가능합니다.
    // val list1 = listOf (10, 20, 30, 40, 50)
    val list2 = listOf("문자열1", "문자열2","문자열3",)
    println("list1 : $list1")
    println("list2 : $list2")

    // 가변형 List
    val list3 = mutableListOf(10, 20, 30, 40, 50)
    val list4 = mutableListOf("문자열1", "문자열2","문자열3",)
    println("list3 : $list3")
    println("list5 : $list4")

    // emptyList () : 요소가 없는 빈 List 를 생성합니다.
    val list5 = emptyList<Int>()
    println("list5 : $list5")

    // listOfNotNull () : 요소 중 null 값을 제외한 List 를 생성합니다.
    val list6 = listOfNotNull(10, 20, 30, 40 ,null, 50)
    println("list6 : $list6")
    val list0 = listOf(10, 20, 30, 40 ,null, 50) // listOf() Method 는 null 을 포함합니다.
    println("list0 : $list0")

    for (item in list1) {
        println("List1 : $item")
    }

    println("List1 size : ${list1.size}")

    println("---------------------------------")

    println("list1 0 : ${list1.get(0)}")
    println("list1 1 : ${list1.get(1)}")
    println("list1 2 : ${list1[2]}")
    println("list1 3 : ${list1[3]}")

    println("------------------------------")

    val list7 = listOf(10, 20, 30, 10, 20, 30)

    val index1 = list7.indexOf(20)
    println("index1 : $index1")

    val index2 = list7.lastIndexOf(20)
    println("index2 : $index2")

    val list8 = list1.subList(1, 3) // Index 1번 부터 3번의 Index 직전까지의 요소를 List 로 반환한다.
    println("list8 : $list8")

    println("-------------------------------")

    println("list3 : $list3")

    list3.add(10)
    list3.add(20)
    list3.add(30)

    println("list3 : $list3")

    list3.addAll(listOf(40, 50, 60))
    println("list3 : $list3")

    list3.add(1, 100)
    println("list3 : $list3")

    list3.addAll(2, listOf(200, 300, 400))
    println("list3 : $list3")

    list3.remove(100)
    println("list3 : $list3")

    println("----- test -----")
    val test3: KClass<*> = list3::class
    val test4:Class<*> = list3::class.java
    println("test1 : $test3")
    println("test2 : $test3")
    println("----- test -----")

    list3.removeAll(listOf(200, 300))
    println("list3 : $list3")

    list3.removeAt(1)
    println("list3 : $list3")

    list3.set(1, 200)
    println("list3 : $list3")

    list3[2] = 300
    println("list3 : $list3")

    println("-----------------------------")

    // List Type 가변형으로 변경
    val list100 = list1.toMutableList()
    list100.add(1000)
    println("list100 : $list100")

    // List Type 불변형으로 변경
    val list200 = list100.toList()
    // list200.add(300)

    println("-----------------------------")

    val list9 = mutableListOf(100, 200, 300, 100, 200)
    println("list9 : $list9")
    val test1: KClass<*> = list9::class
    val test2:Class<*> = list9::class.java
    println("test1 : $test1")
    println("test2 : $test2")
    list9.remove(100) // 값 100 인 요소 한 개 제거 => list9 : [200, 300, 100, 200]
    println("list9 : $list9")
    list9.remove(100) // 값 100 요소 한 개 추가 제거 => ist9 : [200, 300, 200]
    println("list9 : $list9")

    list9.addAll(listOf(100, 100))
    println("list9 : $list9")
    list9.removeAll(listOf(100))
    println("list9 : $list9") // => list9 : [200, 300, 200]
    list9.removeAll(listOf(100, 200))
    println("list9 : $list9") // => list9 : [300]

}
