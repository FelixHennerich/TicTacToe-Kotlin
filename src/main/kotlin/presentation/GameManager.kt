package presentation

class GameManager {

    var fields = mutableMapOf<Int, String>()

    fun printPlayground(): String{
        var playground = buildString {
            for(i in (0..8)){
                if(getAllFields().containsKey(i)){
                    append(getAllFields()[i])
                }else {
                    append(" ")
                }
                if(i != 2 && i != 5 && i != 8)
                    append(" | ")
                if(i == 2 || i == 5)
                    append("\n")
            }
        }

        return playground
    }

    private val winningCombinations = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
        listOf(0, 4, 8), listOf(2, 4, 6), listOf(6, 4, 2) // Diagonals
    )

    fun checkWin(player: String): Boolean {
        for (combination in winningCombinations) {
            if (combination.all { fields[it] == player }) {
                return true
            }
        }
        return false
    }

    fun addX(field: Int): Response{
        if(fields.contains(field)){
            return Response.FIELDNOTEMPTY
        }else {
            fields.set(field, "X")
        }
        return Response.FIELDISSET
    }

    fun addO(field: Int): Response {
        if(fields.contains(field)){
            return Response.FIELDNOTEMPTY
        }else {
            fields.set(field, "O")
        }
        return Response.FIELDISSET
    }

    fun clearAll(){
        fields.clear()
    }

    fun getAllFields(): MutableMap<Int, String> {
        return fields
    }

}