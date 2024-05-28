package Menu

import Items.Note
import TypeOfInterface
import Utils

class NoteMenu(titleOfMenu: String, typeOfInterface: TypeOfInterface,itemList:MutableList<Note>) : Menu<String,Note>(titleOfMenu, typeOfInterface, itemList){

    override fun create() {
        var newName = ""
        var noteText = ""

        while (true) {
            while(true){
                println("Введите наименование новой заметки")
                newName = Utils.INPUT_TEXT(true)
                if (newName==""){
                    println("Наименование заметки  не может быть пустым! Повторите попытку")
                    continue
                }
                break
            }

            while (true){
                println("Введите текст заметки")
                noteText = Utils.INPUT_TEXT(true)

                if (noteText==""){
                    println("текст заметки  не может быть пустым! Повторите попытку")
                    continue
                }
                break
            }

            add(Note(newName, noteText))
            break
        }
        println("Создана новая заметка \n")
    }

    override fun open(item: Note) {
        println("Содержимое заметки:")
        println("${item.data} \n")
        println()
    }

}
