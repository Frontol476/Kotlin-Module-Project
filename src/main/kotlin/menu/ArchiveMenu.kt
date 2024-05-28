package Menu

import Items.Archive
import Items.Note
import TypeOfInterface
import Utils

class ArchiveMenu(titleOfMenu: String, typeOfInterface: TypeOfInterface,itemList:MutableList<Archive>) : Menu<MutableList<Note>,Archive>(titleOfMenu, typeOfInterface, itemList) {

    override fun create() {
        while (true) {
            println("Введите наименование нового архива")
            var newName = Utils.INPUT_TEXT(true)
            if (newName == "") {
                println("Наименование архива не может быть пустым! Повторите попытку")
                continue
            }
            var newItemList: MutableList<Note> = mutableListOf()
            add(Archive(newName, newItemList))
            break
        }
        println("Создан новый архив \n")
    }

    override fun open(item: Archive) {
        var noteList: MutableList<Note> = item.data
        var noteMenu: NoteMenu = NoteMenu("Управление Заметками", TypeOfInterface.NOTE, noteList)
        noteMenu.start() //Переходим в класс по заметкам
    }

}