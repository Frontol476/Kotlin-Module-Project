import java.util.InputMismatchException
import java.util.Scanner

object Utils {
     fun INPUT_NUMBER(checkOnlyNum:Boolean=false, minNum:Int =0, MaxNum:Int =1000): Int {
        var scanner: Scanner =  Scanner(System.`in`)
        var result = -1

         try {
             result = scanner.nextInt()
         }catch (e: InputMismatchException){
             scanner.nextLine() //очистим ст\
             return -1
         }


        if(checkOnlyNum){
            if ((result<minNum) or (result>MaxNum)){
                return -1
            }else{
                return result
            }
        }else{
            return result
        }

        return -1
    }


    fun INPUT_TEXT(checkEmpty:Boolean = false): String {
        var scanner: Scanner =  Scanner(System.`in`)
        var result = ""

        try {
            result = scanner.nextLine()
        }catch (e: InputMismatchException){
            scanner.nextInt() //очистим ст\
            return ""
        }

        if (checkEmpty){
            if (result==""){
                return ""
            }else{
                return result
            }
        }else{
            scanner.nextLine()
        }

        return scanner.nextLine()
    }
}


