
 class Menu(titleOfMenu:String,typeOfInterface: String,itemList:MutableList<out Item>) {

    val titleOfMenu:String = titleOfMenu //установим заголовок меню
    var mapOfMenu:MutableMap<Int,Item> = mutableMapOf<Int,Item>() //Общий список хранения
    var listOfMenu:MutableMap<Int,String> = mutableMapOf<Int, String>() //Список для вывода

    init {
        //Наполним базовыми параметрами это Создание , Открытие, Просмотр
        val createFunText:String
        val exitFunText:String = "Выход"

        //Определим с чем мы имеем дело
        if (typeOfInterface.equals("Архив")){
            createFunText = "Создать архив"
        }else{
            createFunText = "Создать заметку"
        }
        //Добавим первый пункт создания
        listOfMenu.put(0,createFunText)
        downloadList(itemList)

    }

    //Отобразим список пунктов
    fun showMenu(){
        listOfMenu.forEach { index, itemName -> println("$index. $itemName") }
    }

     //Обновляет список
     fun downloadList(itemList:MutableList<out Item>){
         //Подготовим с ключами данные которые уже существуют
         itemList.forEachIndexed { index, item ->
             mapOfMenu.put(index+1,item)//+1 так как нулевой пункт всегда про создание.Подготовим список с объектами
             listOfMenu.put(index+1,item.name)} //И список со строковыми данными для вывода на экран
     }

}