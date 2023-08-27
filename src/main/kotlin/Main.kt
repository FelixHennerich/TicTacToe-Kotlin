import presentation.GameManager
import presentation.Response

fun main(args: Array<String>) {
    val gameManager = GameManager()
    while (gameManager.fields.size < 9){
        if(gameManager.checkWin("X") ){
            break
        }
        if(gameManager.checkWin("O") ){
            break
        }
        println("Setze deinen zug:")
        if(gameManager.fields.size % 2 == 0) {
            readlnOrNull()?.let {
                if(gameManager.addX(it.toInt()) == Response.FIELDNOTEMPTY){
                    println("Zug nicht verfügbar!")
                }
            }
        }else {
            readlnOrNull()?.let {
                if(gameManager.addO(it.toInt()) == Response.FIELDNOTEMPTY){
                    println("Zug nicht verfügbar!")
                }
            }
        }
        println(gameManager.printPlayground())
    }
    if(gameManager.checkWin("X") ){
        println("ES STEHT EIN GEWINNER FEST!!! GEWONNEN HAT X")
        return
    }
    if(gameManager.checkWin("O") ){
        println("ES STEHT EIN GEWINNER FEST!!! GEWONNEN HAT O")
        return
    }

}