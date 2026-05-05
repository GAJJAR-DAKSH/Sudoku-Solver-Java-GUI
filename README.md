# 🧩 Sudoku Solver (Java Swing GUI)

A modern and interactive **Sudoku Solver built in Java**, featuring real-time validation, colored feedback, and a clean graphical interface.

---

## 📸 Screenshots

### 🔹 Empty Grid

<img width="629" height="703" alt="Screenshot 2026-05-05 113842" src="https://github.com/user-attachments/assets/d3f4693b-35a2-44a6-b850-ace30021e361" />


### 🔹 User Input State

<img width="641" height="656" alt="Screenshot 2026-05-05 113824" src="https://github.com/user-attachments/assets/319c2fb5-48cf-4f89-9de4-6e28beb38c79" />


### 🔹 Solved Output (Green Highlight)

<img width="633" height="703" alt="Screenshot 2026-05-05 113549" src="https://github.com/user-attachments/assets/2c49898c-61b1-439d-bb90-cbfd3ff5c442" />


## ✨ Features

* 🎯 9×9 interactive Sudoku grid
* 🔴 Invalid inputs highlighted with **red boxes**
* 🟢 Solver-filled values highlighted with **green boxes**
* ⚪ Valid user inputs remain clean and readable
* ⚡ Fast **Backtracking Algorithm**
* 🧹 Clear button to reset the board
* 💻 Smooth and responsive Swing UI

---

## 🧠 Algorithm Used

This project uses the **Backtracking Algorithm**:

* Try numbers from **1 to 9**
* Check validity in:

  * Row
  * Column
  * 3×3 subgrid
* Recursively solve remaining cells
* Backtrack if a number leads to no solution

---

## 🛠️ Tech Stack

* **Java**
* **Swing (GUI Framework)**

---

## 📂 Project Structure

```
SudokuGUI.java
README.md
screenshots/
   ├── empty.png
   ├── solved.png
   └── input.png
```

---

## ▶️ How to Run

### 1. Clone Repository

```
git clone https://github.com/your-username/sudoku-solver.git
```

### 2. Navigate

```
cd sudoku-solver
```

### 3. Compile

```
javac SudokuGUI.java
```

### 4. Run

```
java SudokuGUI
```

---

## 🎮 Usage

1. Enter numbers (1–9) in the grid
2. Invalid inputs will turn **red**
3. Click **Solve**
4. Missing cells will be filled in **green**

---

## 🚀 Future Improvements

* 🎨 Dark Mode UI
* 🎯 Highlight row/column on selection
* 🧠 Sudoku generator (Easy/Medium/Hard)
* ⏱️ Timer & scoring system
* 📱 Android version

---

## 👨‍💻 Author

**Daksh Gajjar**

* Java Developer | UI Enthusiast
* Focused on building clean and interactive applications

---

## 📜 License

This project is licensed under the **MIT License**.

---
