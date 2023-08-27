package presentation

class GameManager {

    var fields = mutableMapOf<Int, String>()

    /**
     * Print the gameboard in console
     *
     * @return - String of gameboard to output
     */
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

    /**
     * lift of field combinations that will win
     */
    private val winningCombinations = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
        listOf(0, 4, 8), listOf(2, 4, 6), listOf(6, 4, 2) // Diagonals
    )

    /**
     * Check whether a win happend
     *
     * @param player - "X" or "O"
     * @return - Win happend or Not
     */
    fun checkWin(player: String): Boolean {
        for (combination in winningCombinations) {
            if (combination.all { fields[it] == player }) {
                return true
            }
        }
        return false
    }

    /**
     * Set X to a field
     *
     * @param field - given field
     * @return - Response of action
     */
    fun addX(field: Int, player: String): Response{
        if(fields.contains(field)){
            return Response.FIELDNOTEMPTY
        }else {
            fields.set(field, player)
        }
        return Response.FIELDISSET
    }

    /**
     * Reset the game
     */
    fun clearAll(){
        fields.clear()
    }

    /**
     * Get every state of a field
     *
     *  @return every state of a field
     */
    fun getAllFields(): MutableMap<Int, String> {
        return fields
    }

}