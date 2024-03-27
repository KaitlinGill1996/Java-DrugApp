# CPSC 210 Personal Project

## Generic Drugs and Classes

**Proposal**:
- *What will the application do?*

This application will allow you to create a list of drugs (grouped in whichever way you wish)
and then return either the cheapest, or most expensive drug within the list. You can also return
all the drugs from the same class within the list. You can edit and structure the list in the manner of
your own choosing and use it as a quick reference.

- *Who will use it?*

This would be a useful app for many healthcare professionals,
especially pharmacists, as a quick reference when working. Other healthcare professionals can also
use it to help group common drugs they use.

- *Why is this project of interest to you?*
 
As a practicing pharmacist (and aspiring computer science
degree holder), this allows a blend of the two fields I am
interested in. It allows me to make my own list of commonly used
drugs in my practice and access information about them quickly. I have the freedom to add
drugs of my choosing and use the appropriate brand name for the setting I am working in.

User Stories:

- As a user, I want to be able to create a new drug and add it to a list of favourite drugs
- As a user, I want to be able to view the drugs inside my list of favourite drugs
- As a user, I want to be able to return the most expensive drug (by unit price) in my list of drugs
- As a user, I want to be able to find the cheapest drug (by unit price) in my list of favourite drugs
- As a user, I want to be able to return all drugs from the same class in my list
- As a user, when I select the quit option from the application menu, I want to be reminded to save my to-do list to file and have the option to do so or not.
- As a user, when I start the application, I want to be given the option to load my to-do list from file.

# Instructions for Grader

- You can generate the first required action related to the user story "adding multiple drugs to your list" by clicking the add new drug button and entering the relevant fields
- You can generate the second required action related to the user story "clicking the return the cheapest drug button" and the cheapest drug in the list will print in the bottom panel
- You can also use the functionality of all the other buttons (selecting the most expensive drug button returns the most expensive drug in the list, selecting the drugs in a class button will) prompt you to enter a drug class and all drugs in this class will print in bottom panel)
- You can also remove a drug from the list by selecting the remove drug from list button. If you enter the generic name of the drug, it will remove that drug from the list.
- You can locate my visual component by running main and it will be an an image on the opening start panel.
- You can save the state of my application by clicking the save drug list button. You will receive a message that confirms it has been saved.
- You can reload the state of my application by clicking the load drug list button. It will confirm the drugs have been loaded and then they will appear in the panel on the right.
