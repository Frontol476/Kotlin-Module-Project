package Menu
import Items.Item
import TypeOfInterface
import Utils

abstract class Menu<T,I : Item<T>>(titleOfMenu:String, typeOfInterface: TypeOfInterface, itemList:MutableList<I>) {

    private val titleOfMenu:String = titleOfMenu //установим заголовок меню

    private var itemList:MutableList<I> = itemList//Общий список хранения объектов Архивы Заметки и тд
    var listOfMenu:MutableMap<Int,String> = mutableMapOf<Int, String>() //Список для вывода ИНДЕКС и Наименование команды или объекта


    var createFunText:String =""
    var exitFunText:String = "Выход"

    init {

        //Наполним базовыми параметрами это Создание , Открытие, Просмотр

        //Определим с чем мы имеем дело
        if (typeOfInterface == TypeOfInterface.ARCHIVE){
            createFunText = "Создать архив"
        }else{
            createFunText = "Создать заметку"
        }
        //Загрузим в удобный список для отображения
        downloadList(itemList)
    }

    fun start() {

        while (true){
            var command:Int = -1 /////НАЧАЛО ПРОВЕРОК
            println(titleOfMenu)
            showMenu()//покажем список действии
            command = Utils.INPUT_NUMBER(true,0,listOfMenu.size-1)

            if (command == -1){
                println("Разрешен только ввод чисел из пункта меню!")
                continue
            }

            when(command){
                0 -> create()//Первый пункт создание
                listOfMenu.size-1 -> break //Если последний индекс то выход
                else->  open(itemList.get(command-1)) //Иначе открываем объект по индексу
            }

        }
    }

    //Отобразим список пунктов
    fun showMenu(){
        listOfMenu.forEach { index, itemName -> println("$index. $itemName") }
    }

    //Обновляет список для отображения
    fun downloadList(itemList:MutableList<I>){

        listOfMenu.clear()

        //Добавим первый пункт создания
        listOfMenu.put(0,createFunText)

        itemList.forEachIndexed { index, item ->
            listOfMenu.put(index+1,item.name)} //так как нулевой пункт всегда про создание.  список со строковыми данными для вывода на экран

        //Добавим последний пункт ВЫХОД
        listOfMenu.put(listOfMenu.size,exitFunText)
    }

    final fun add(item:I) {
        itemList.add(item)
        downloadList(itemList)
    }

    abstract fun create()

    abstract fun open(item:I)

}
