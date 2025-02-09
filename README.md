# <img src="https://roadmap.sh/images/gifs/rocket.gif" width="25px"> Task Tracker CLI

A command-line interface (CLI) application for task management.  
<br>  
Project suggested by [Roadmap.sh - **Backend Developer**](https://roadmap.sh/projects/task-tracker).  

## Commands  
- **Add Task:** Adds a new task with a description.  
- **Update Task:** Updates the description of an existing task.  
- **Delete Task:** Removes a task by its ID.  
- **Mark Task:** Marks a task as "In Progress" or "Done".  
- **List Tasks:** Lists all tasks, with optional filtering by status (e.g., `todo`, `in_progress`, `done`).  
- **Clear Tasks:** Clears all tasks.  
- **Help:** Lists all available commands for the application.  

## Installation  
1. **Clone the Repository:** 
```bash
git clone https://github.com/matheushug0/task-tracker.git
cd task-tracker/src/
```
2. **Compile the Application Source Code:**
```bash
javac Tasker.java Task.java TaskManager.java TaskStorage.java Status.java
```
3. **Execute the Application:**
```bash
java Tasker [command] [param]
```

## Usage
```bash
# Add a task  
java Tasker add "New Task"  
# Task added successfully! (ID: 1)  

# Update a task  
java Tasker update 1 "Updated New Task"  
# Task updated successfully! (ID: 1)  

# Delete a task by ID  
java Tasker delete 1  
# Task deleted successfully! (ID: 1)  

# Mark a task  
java Tasker mark-to-do 1  
# Task already marked To Do (ID: 1)  

java Tasker mark-in-progress 1  
# Task marked successfully! (ID: 1)  

java Tasker mark-done 1  
# Task marked successfully! (ID: 1)  

# List all tasks  
java Tasker list  
# ID: 1 | Description: Updated New Task | Status: Done | Created At: 22/01/2025 - 19:25 PM | Updated At: 22/01/2025 - 19:25 PM  

# List tasks by status  
java Tasker list done  
java Tasker list in-progress  
java Tasker list todo  

# Clear all tasks  
java Tasker clear  
# Are you sure? [Y/n]:  

# Application commands  
java Tasker help
```
