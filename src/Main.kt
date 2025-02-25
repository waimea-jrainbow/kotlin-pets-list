fun main() {
    val pets = mutableListOf<String>()

    pets.add("Dog")
    pets.add("Cat")
    pets.add("Birb")
    pets.add("Fish")
    pets.add("Hamster")
    pets.add("Eldritch god")

    while(true) {

        // show current pets
        println("pet-list-atron")
        println("=========================================")
        show(pets)
        println("=========================================")
        //get user action
        val action = menu()
        //act upon action
        when (action) {
            'Q' -> break
            'A' -> getNewPet(pets)
            'D' -> delPet(pets)
        }

    }
}


/**
 * Show a list with given entries
 * starting from 1
 */
fun show(list: List<Any>){
    for ((i, item) in list.withIndex()) {
        println("${i+1}: $item")
    }
}

/**
 * Show a menu and get the users choice
 * Return this as a char
 */
fun menu(): Char {
    println("[A]dd a new pet")
    println("[D]elete a pet")
    println("[Q]uit")

    val validChoices = "ADQ"

    while (true){
        print("Choice:")
        val input = readln()

        //typed nothing then loop
        if (input.isBlank()) continue

        // grab first letter in lowercase
        val choice = input.uppercase().first()

        //check if it's a valid input
        if(validChoices.contains(choice)) return choice
    }

}

/**
 * get a pet from the user
 * add to the given list of pets
 */
fun getNewPet(pets: MutableList<String>) {
    val newPet = getString("New pet: ")
    pets.add(newPet)
}

/**
 * get a pet from the user
 * add to the given list of pets
 */
fun delPet(pets: MutableList<String>) {
    val delPet = getString("Pet to remove : ")
    pets.remove(delPet)
}

/**
 * Function to get a string from the user
 *
 * parameters:
 * prompt:
 * -text to show user
 * returns:
 * -string that the user has entered
 */

fun getString(prompt: String): String {
    var userinput: String

    while (true) {
        print(prompt)
        userinput = readln()
        if (userinput.isNotBlank()) break

    }
    return userinput
}