import java.util.Scanner

def moves = ["rock", "paper", "scissors"]


def scanner = new Scanner(System.in)

print "Enter your move (rock, paper, or scissors): "
def userMove = scanner.nextLine().toLowerCase()

if (!moves.contains(userMove)) {
    println "Invalid move! Please choose rock, paper, or scissors."
    return
}


def computerMove = moves[new Random().nextInt(3)]
println "Computer chose: $computerMove"

// Determine winner
if (userMove == computerMove) {
    println "It's a tie!"
} else if (
    (userMove == "rock" && computerMove == "scissors") ||
    (userMove == "paper" && computerMove == "rock") ||
    (userMove == "scissors" && computerMove == "paper")
) {
    println "You win!"
} else {
    println "Computer wins!"
}
