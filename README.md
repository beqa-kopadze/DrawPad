# Java DrawPad Application

This project is a simple drawing pad built using Java Swing. It consists of two main classes:
- `DrawPadPanel`: A custom `JPanel` that allows drawing and managing shapes.
- `Panel`: An abstract class that manages the application window, updates, and user input.

## Project Structure

### 1. DrawPadPanel
The `DrawPadPanel` class is responsible for:
- Managing a collection of shapes.
- Drawing these shapes on the screen using `paintComponent`.
- Providing methods to add or remove shapes and automatically update the display.

### 2. Panel
The `Panel` class handles:
- Creating the main application window using Java Swing.
- Running an update loop at 60 frames per second.
- Handling user input through key bindings.
- Managing the dimensions and title of the application window.

## Getting Started

### Prerequisites
- Java JDK 8 or higher.
- An IDE like IntelliJ IDEA or Eclipse (optional but recommended).

### Installation
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/drawpad.git
