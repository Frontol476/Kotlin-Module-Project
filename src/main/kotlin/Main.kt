import Items.Archive
import Items.Note
import Menu.ArchiveMenu
import Menu.Menu

fun main() {

    var archiveList: MutableList<Archive> = mutableListOf()

    var archiveMenu: Menu<MutableList<Note>, Archive> =
        ArchiveMenu("Управление Архивами", TypeOfInterface.ARCHIVE, archiveList)

    archiveMenu.start()
    println("Работа программы завершена!")

}
