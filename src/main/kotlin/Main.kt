fun main(args: Array<String>) {
    println("Hello World!")

    var archiveList:MutableList<Archive> = mutableListOf()
    archiveList.add(Archive("Первый архив","некиеДанные",))
    archiveList.add(Archive("Второй архив","некиеДанные",))

    var archiveMenu:Menu = Menu("Меню Архива","Архив",archiveList)


    archiveMenu.showMenu()

}