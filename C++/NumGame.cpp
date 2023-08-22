#include <iostream>
#include <cstdlib>
#include <ctime>

int main() {
    // Seed the random number generator with the current time
    std::srand(std::time(nullptr));
    
    // Generate a random number between 1 and 100
    int randomNumber = std::rand() % 100 + 1;
    
    int UserGuess;
    int Attempts = 0;
    
    std::cout << "Welcome to the Number Guessing Game!" << std::endl;
    
    do {
        std::cout << "Guess a number between 1 and 100: ";
        std::cin >> UserGuess;
        
        Attempts++;
        
        if (UserGuess > randomNumber) {
            std::cout << "Too high! Try again." << std::endl;
        } else if (UserGuess < randomNumber) {
            std::cout << "Too low! Try again." << std::endl;
        } else {
            std::cout << "Congratulations! You guessed the number " << randomNumber << " in " << Attempts << " attempts." << std::endl;
        }
    } while (UserGuess != randomNumber);
    
    return 0;
}
