# Projects 

Mini projects that take more time to achieve result. 

## ATM Machine

Program emulates how ATM machine works. 

- ATM machine has two states, logged in and not logged in.


- Not logged in
	- Will as user to "authenticate itself" (for now leave only one username/password)
	- If authentication fails, ask user to try again.
	- If authentication succeeds, change app state to "Logged in"

- Logged in 
	- User can see the current ballance of his card (eg.: 200$)
	- User can withdraw money (cannot withdraw more than there is on his current ballance)
	- User can bring in money.
	- User can log out of the account (change app state to "Not logged in")
