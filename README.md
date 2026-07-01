
# Task Tracker CLI app
## To install run thse commands in this exact order:
```
git clone javac TaskTracker.java TaskHandler.java
cd TaskTracker
javac TaskTracker.java TaskHandler.java
```
### Then you should be good to go!
## The commands you can use are:

**Adding a new task**
```
task-cli add "Buy groceries"
```
**Updating and deleting tasks**
```
task-cli update 1 "Buy groceries and cook dinner"
task-cli delete 1
```
**Marking a task as in progress or done**
```
task-cli mark-in-progress 1
task-cli mark-done 1
```
**Listing all tasks**
```
task-cli list
```
**Listing tasks by status**
```
task-cli list done
task-cli list todo
task-cli list in-progress
```
