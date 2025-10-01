//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val notes = mutableListOf<Note>()
    var running = true

    while (running) {
        println("------ Simple Note Taking List ------")
        println("1. Add Note")
        println("2. View Note")
        println("3. Edit Note")
        println("4. Delete Note")
        println("5. Exit Note")

        println("Please input your action: ")
        val actionInput = readLine()!!
        println("You entered $actionInput")

        when (actionInput.toInt()) {
            1 -> {
                println("-----Add Note-----")
                println("Title: ")
                val titleInput = readLine()!!
                println("Content: ")
                val contentInput = readLine()!!

                val newNote = Note(titleInput, contentInput)
                notes.add(newNote)

                val noteLength = when (newNote.content.length) {
                    in 0 .. 50 -> "Short Note"
                    in 51..100 -> "Medium Note"
                    else -> "Long Note"
                }
                println("This is a $noteLength")
                println("Note Added!")
            }

            2 -> {
                println("-----View Note-----")
                if (notes.isEmpty()) {
                    println("No notes available")
                } else {
                    println("Available Notes: ")
                    notes.forEach { println(" - ${it.title}") }
                }
                println("Title of the note you want to review: ")
                val viewNoteInput = readLine()!!

                //AI-generated example to search for a note by little (used to implement view note feature)
                val foundNote = notes.find { note -> note.title.equals(viewNoteInput, ignoreCase = true) }
                if (foundNote != null) {
                    println("Note found!")
                    println("Title: ${foundNote.title}")
                    println("Content: ${foundNote.content}")
                } else {
                    println("No note found with the title $viewNoteInput")
                }

            }

            3 -> {
                println("-----Edit Note-----")
                if (notes.isEmpty()) {
                    println("No notes available")
                } else {
                    println("Available Notes: ")
                    notes.forEach { println(" - ${it.title}") }
                }
                println("Enter the title of the note you want to edit: ")
                val editTitle = readLine()!!

                // AI-generated example to search for a note by little (used to implement view note feature)
                val foundNote = notes.find { note -> note.title.equals(editTitle, ignoreCase = true) }

                if (foundNote != null) {
                    println("Note found!")
                    println("Current content: ${foundNote.content}")
                    println("Enter the new content: ")
                    val newNoteInput = readLine()!!

                    if (newNoteInput.isNotEmpty()) {
                        foundNote.content = newNoteInput
                        println("New content updated successfully!")

                    } else {
                        println("Content cannot be empty. Please try again.")
                    }
                } else {
                    println("No note found with the title $editTitle")
                }
            }

            4 -> {
                println("-----Delete Note-----")
                if (notes.isEmpty()) {
                    println("No notes available")
                } else {
                    println("Available Notes: ")
                    notes.forEach { println(" - ${it.title}") }
                }
                println("Enter the title of the note you want to delete: ")
                val deleteTitle = readLine()!!

                // AI-generated example to search for a note by little (used to implement view note feature)
                val foundNote = notes.find { note -> note.title.equals(deleteTitle, ignoreCase = true) }

                if (foundNote != null) {
                    println("Note found!")
                    notes.remove(foundNote)
                    println("Note '${foundNote.title}' deleted!")
                } else {
                    println("NOte not found with the title $deleteTitle")
                }

            }

            5 -> {
                println("Are you sure you want to exit the note? y/n")
                val exitNote = readLine()!!
                if (exitNote.lowercase() == "y") {
                    println("Exiting Note App. See you next time!")
                    return
                } else {
                    println("Returning to the menu......")
                }
            }
        }
    }
}