#include <iostream>

int main() {
    double n1, n2;
    char Operation;
    
    std::cout << "Simple Calculator" << std::endl;
    std::cout << "Enter the first number: ";
    std::cin >> n1;
    
    std::cout << "Enter an operation (+, -, *, /): ";
    std::cin >> Operation;
    
    std::cout << "Enter the second number: ";
    std::cin >> n2;
    
    double Result;
    
    switch (Operation) {
        case '+':
            Result = n1 + n2;
            break;
        case '-':
            Result = n1 - n2;
            break;
        case '*':
            Result = n1 * n2;
            break;
        case '/':
            if (n2 != 0) {
                Result = n1 / n2;
            } else {
                std::cout << "Division by zero is not allowed." << std::endl;
                return 1; // Return with an error code
            }
            break;
        default:
            std::cout << "Invalid operation." << std::endl;
            return 1; // Return with an error code
    }
    
    std::cout << "Result: " << Result << std::endl;
    
    return 0;
}
